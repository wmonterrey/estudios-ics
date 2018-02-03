package ni.org.ics.estudios.service.muestreoanual;

import ni.org.ics.estudios.domain.muestreoanual.Sms;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Servicio para el objeto Sms
 * 
 * @author William Aviles
 * 
 **/

@Service("smsService")
@Transactional
public class SmsService {

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	/**
	 * Regresa todos los Datos de los sms
	 * 
	 * @return una lista de <code>Sms</code>(es)
	 */

	@SuppressWarnings("unchecked")
	public List<Sms> getSms() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Sms");
		// Retrieve all
		return  query.list();
	}	
	
	/**
	 * Agrega un Sms
	 * 
	 * 
	 */
	public void addSms(Sms sms) {
		Session session = sessionFactory.getCurrentSession();
		session.save(sms);
	}
	
}
