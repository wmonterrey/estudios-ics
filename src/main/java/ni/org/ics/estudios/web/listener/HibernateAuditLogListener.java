package ni.org.ics.estudios.web.listener;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import ni.org.ics.estudios.domain.audit.AuditTrail;
import ni.org.ics.estudios.domain.audit.Auditable;

import org.hibernate.HibernateException;
import org.hibernate.StatelessSession;
import org.hibernate.event.spi.PostDeleteEvent;
import org.hibernate.event.spi.PostDeleteEventListener;
import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PostInsertEventListener;
import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.event.spi.PostUpdateEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/** 
 * Audit Log Listener is used to log insert, update, delete, and load operations. Complete list of listeners/events can be obtained at <tt>org.hibernate.event.EventListeners</tt>. 
 *  
 * @see org.hibernate.event.EventListeners 
 * @author whoover 
 */  
public final class HibernateAuditLogListener implements  
PostDeleteEventListener, PostInsertEventListener, PostUpdateEventListener { 
	
	
	private static final long serialVersionUID = 1L;  
    private static final Logger LOG = LoggerFactory.getLogger(HibernateAuditLogListener.class);    
    public static final String OPERATION_TYPE_UPDATE = "UPDATE";    
  

    
	/** 
     * Log updates made to the current model in the the Audit Trail. 
     *  
     * @param event 
     *            the post-update event 
     */
	@Override
	public void onPostUpdate(PostUpdateEvent event) {
		try {  
            final Serializable entityId = event.getPersister().hasIdentifierProperty() ? event.getPersister().getIdentifier(event.getEntity(), event.getSession())  
                    : null;  
            final String entityClass = event.getEntity().getClass().toString();
            final String entityName = event.getEntity().toString();
            final Date transTime = new Date(); // new Date(event.getSource().getTimestamp());   
            Object oldPropValue = null;  
            Object newPropValue = null; 
            
            if (event.getEntity() instanceof Auditable){
              	Auditable obj = (Auditable) event.getEntity();
              	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                final String actorId = authentication.getName();
                // need to have a separate session for audit save  
	            StatelessSession session = event.getPersister().getFactory().openStatelessSession();  
	            session.beginTransaction();  
	  
	            // get the existing entity from session so that we can extract existing property values  
	            Object existingEntity = session.get(event.getEntity().getClass(), entityId);  
	  
	            // cycle through property names, extract corresponding property values and insert new entry in audit trail  
	            for (String propertyName : event.getPersister().getPropertyNames()) {  
	            	if (obj.isFieldAuditable(propertyName)){
		                newPropValue = event.getPersister().getPropertyValue(event.getEntity(), propertyName);  
		                if (newPropValue != null) {  
			                // collections will fire their own events  
		                    if (!(newPropValue instanceof Collection)) {  
		                        oldPropValue = event.getPersister().getPropertyValue(existingEntity, propertyName);
		                        if(oldPropValue != null){
			                        if(!newPropValue.equals(oldPropValue)){
				                        if (LOG.isDebugEnabled()) {  
				                            LOG.debug("{} for: {}, ID: {}, property: {}, old value: {}, new value: {}, actor: {}, date: {}", new Object[] { OPERATION_TYPE_UPDATE, entityName, entityId, propertyName, oldPropValue, newPropValue, actorId, transTime });  
				                        }  
				                        session.insert(new AuditTrail(entityId.toString(), entityClass, entityName, propertyName, oldPropValue != null ? oldPropValue.toString() : null, newPropValue != null ? newPropValue  
				                                .toString() : null, OPERATION_TYPE_UPDATE, actorId, transTime));  
			                        }
		                        }
		                	}
		                }  
	            	}
	            }  
	  
	            session.getTransaction().commit();  
	            session.close(); 
            }
        } catch (HibernateException e) {  
            LOG.error("Unable to process audit log for UPDATE operation", e);  
        }
	}

	@Override
	public void onPostInsert(PostInsertEvent event) {
		// TODO Auto-generated method stub
		LOG.debug("PostInsertEvent");
	}

	@Override
	public void onPostDelete(PostDeleteEvent event) {
		// TODO Auto-generated method stub
		LOG.debug("PostDeleteEvent");
	}

	@Override
	public boolean requiresPostCommitHanding(EntityPersister arg0) {
		// TODO Auto-generated method stub
		return false;
	}   
}
