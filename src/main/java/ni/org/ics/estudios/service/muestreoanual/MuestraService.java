package ni.org.ics.estudios.service.muestreoanual;

import ni.org.ics.estudios.domain.muestreoanual.MuestraId;
import ni.org.ics.estudios.domain.muestreoanual.MuestraMA;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Servicio para el objeto Muestra
 * 
 * @author Brenda Lopez
 * 
 **/

@Service("muestraMAService")
@Transactional
public class MuestraService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	/**
	 * Regresa todos las Muestras
	 * 
	 * @return una lista de <code>Muestras</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<MuestraMA> getMuestras() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM MuestraMA");
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Regresa todos las Muestras BHC
	 * 
	 * @return una lista de <code>Muestras</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<MuestraMA> getMuestrasBHC() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM MuestraMA mx where mx.tuboBHC = 1");
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Regresa todos las Muestras BHC de hoy
	 * 
	 * @return una lista de <code>Muestras</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<MuestraMA> getMuestrasBHCHoy() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");      
	    Date dateWithoutTime = null;
		try {
			dateWithoutTime = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Timestamp timeStamp = new Timestamp(dateWithoutTime.getTime());
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM MuestraMA mx where mx.tuboBHC = 1 and mx.movilInfo.today = :fechaBHC");
		query.setTimestamp("fechaBHC", timeStamp);
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<MuestraMA> getCompBHCEstSupHoy() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");      
	    Date dateWithoutTime = null;
		try {
			dateWithoutTime = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Timestamp timeStamp = new Timestamp(dateWithoutTime.getTime());
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("select muestras.codigo, muestras.fecha_muestra, muestras.pinchazos, muestras.recurso1, muestras.recurso2 " +
				"from muestras left join recepcionbhc on muestras.codigo = recepcionbhc.codigo and muestras.fecha_registro = recepcionbhc.fecha_bhc " +
				"where ((muestras.fecha_registro  = :fechaBHC and muestras.tubobhc =1) and (recepcionbhc.codigo Is Null or muestras.fecha_registro <> recepcionbhc.fecha_bhc));");
		query.setTimestamp("fechaBHC", timeStamp);
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<MuestraMA> getCompBHCEstLabHoy() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");      
	    Date dateWithoutTime = null;
		try {
			dateWithoutTime = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Timestamp timeStamp = new Timestamp(dateWithoutTime.getTime());
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("select muestras.codigo, muestras.fecha_muestra, muestras.pinchazos, muestras.recurso1, muestras.recurso2 " +
				"from muestras left join labbhc on muestras.codigo = labbhc.codigo and muestras.fecha_registro = labbhc.fecha_bhc " +
				"where ((muestras.fecha_registro = :fechaBHC and muestras.tubobhc =1) and (labbhc.codigo Is Null or muestras.fecha_registro <> labbhc.fecha_bhc));");
		query.setTimestamp("fechaBHC", timeStamp);
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<MuestraMA> getCompSeroEstSupHoy() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");      
	    Date dateWithoutTime = null;
		try {
			dateWithoutTime = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Timestamp timeStamp = new Timestamp(dateWithoutTime.getTime());
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("select muestras.codigo, muestras.fecha_muestra, muestras.pinchazos, muestras.recurso1, muestras.recurso2 " +
				"from muestras left join recepcionsero on muestras.codigo = recepcionsero.codigo and muestras.fecha_registro = recepcionsero.fecha_sero " +
				"where ((muestras.fecha_registro  = :fechaSero and muestras.tuborojo =1) and (recepcionsero.codigo Is Null or muestras.fecha_registro <> recepcionsero.fecha_sero));");
		query.setTimestamp("fechaSero", timeStamp);
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<MuestraMA> getCompSeroEstLabHoy() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");      
	    Date dateWithoutTime = null;
		try {
			dateWithoutTime = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Timestamp timeStamp = new Timestamp(dateWithoutTime.getTime());
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("select muestras.codigo, muestras.fecha_muestra, muestras.pinchazos, muestras.recurso1, muestras.recurso2 " +
				"from muestras left join labsero on muestras.codigo = labsero.codigo and muestras.fecha_registro = labsero.fecha_sero " +
				"where ((muestras.fecha_registro = :fechaSero and muestras.tuborojo =1) and (labsero.codigo Is Null or muestras.fecha_registro <> labsero.fecha_sero));");
		query.setTimestamp("fechaSero", timeStamp);
		// Retrieve all
		return  query.list();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<MuestraMA> getCompPbmcEstLabHoy() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");      
	    Date dateWithoutTime = null;
		try {
			dateWithoutTime = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Timestamp timeStamp = new Timestamp(dateWithoutTime.getTime());
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("select muestras.codigo, muestras.fecha_muestra, muestras.pinchazos, muestras.recurso1, muestras.recurso2 " +
				"from muestras left join labpbmc on muestras.codigo = labpbmc.codigo  and muestras.fecha_registro = labpbmc.fecha_pbmc " +
				"where ((muestras.fecha_registro = :fechaPbmc and muestras.tuboleu =1) and (labpbmc.codigo Is Null or muestras.fecha_registro <> labpbmc.fecha_pbmc));");
		query.setTimestamp("fechaPbmc", timeStamp);
		// Retrieve all
		return  query.list();
	}
	
	
	/**
	 * Regresa todos las Muestras Rojos
	 * 
	 * @return una lista de <code>Muestras</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<MuestraMA> getMuestrasRojo() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Muestra mx where mx.tuboRojo = 1");
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Regresa todos las Muestras Rojo de hoy
	 * 
	 * @return una lista de <code>Muestras</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<MuestraMA> getMuestrasRojoHoy() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");      
	    Date dateWithoutTime = null;
		try {
			dateWithoutTime = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Timestamp timeStamp = new Timestamp(dateWithoutTime.getTime());
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM MuestraMA mx where mx.tuboRojo = 1 and mx.movilInfo.today = :fechaRojo");
		query.setTimestamp("fechaRojo", timeStamp);
		// Retrieve all
		return  query.list();
	}
	
	
	/**
	 * Regresa todos las Muestras Rojos
	 * 
	 * @return una lista de <code>Muestras</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<MuestraMA> getMuestrasPbmc() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM MuestraMA mx where mx.tuboLeu = 1");
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Regresa todos las Muestras Pbmcs de hoy
	 * 
	 * @return una lista de <code>Muestras</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<MuestraMA> getMuestrasPbmcHoy() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");      
	    Date dateWithoutTime = null;
		try {
			dateWithoutTime = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Timestamp timeStamp = new Timestamp(dateWithoutTime.getTime());
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM MuestraMA mx where mx.tuboLeu = 1 and mx.movilInfo.today = :fechaLeu");
		query.setTimestamp("fechaLeu", timeStamp);
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Regresa una Muestra
	 * 
	 * @return un <code>Muestra</code>
	 */

	public MuestraMA getMuestra(MuestraId mId) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Timestamp timeStamp = new Timestamp(mId.getFechaMuestra().getTime());
		Query query = session.createQuery("FROM MuestraMA mx where " +
				"mx.mId.codigo = " + mId.getCodigo() + " AND mx.mId.fechaMuestra = :fechaE");
		query.setTimestamp("fechaE", timeStamp);

        MuestraMA muestra = (MuestraMA) query.uniqueResult();
		return muestra;
	}
	
	/**
	 * Verifica una Muestra
	 * 
	 * @return true or false
	 */

	public Boolean checkMuestra(MuestraId mId) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		Timestamp timeStamp = new Timestamp(mId.getFechaMuestra().getTime());
		Query query = session.createQuery("FROM MuestraMA mx where " +
				"mx.mId.codigo = " + mId.getCodigo() + " AND mx.mId.fechaMuestra = :fechaE");
		query.setTimestamp("fechaE", timeStamp);

        MuestraMA muestra = (MuestraMA) query.uniqueResult();
		if(muestra!=null){
			return true;
		}
		else{
			return false;
		}
			
	}
	
	/**
	 * Agrega una Muestra
	 * 
	 * 
	 */
	public void addMuestra(MuestraMA muestra) {
		Session session = sessionFactory.getCurrentSession();
		session.save(muestra);
	}
	
	/**
	 * Actualiza una Muestra
	 * 
	 * 
	 */
	public void updateMuestra(MuestraMA muestra) {
		Session session = sessionFactory.getCurrentSession();
		session.update(muestra);
	}
	
}
