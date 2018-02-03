package ni.org.ics.estudios.service.muestreoanual;


import ni.org.ics.estudios.domain.muestreoanual.CambiosCasas;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * Servicio para el objeto CambiosCasas
 * 
 * @author Brenda Lopez
 * 
 **/

@Service("cambiosCasasService")
@Transactional
public class CambiosCasasService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	/**
	 * Regresa todos las CambiosCasas
	 * 
	 * @return una lista de <code>CambiosCasas</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<CambiosCasas> getCambiosCasas() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM CambiosCasas");
		// Retrieve all
		return  query.list();
	}
	

	
	/**
	 * Verifica una CambiosCasas
	 * 
	 * @return true or false
	 */

public Boolean checkCambiosCasas (Long fecha){
		// Retrieve session from Hibernate
	Session session = sessionFactory.getCurrentSession();
	Timestamp timeStamp = new Timestamp(fecha);
	Query query = session.createQuery("FROM CambiosCasas cc where cc.fechaRegistro = :fechaE");
	query.setTimestamp("fechaE",timeStamp);
	
	CambiosCasas cambioCasa = (CambiosCasas) query.uniqueResult();
	if (cambioCasa!=null){
		return true;
	}
	else{
		return false;
	}			
	}
	
	/**
	 * Agrega una CambiosCasas
	 * 
	 * 
	 */
public void addCambiosCasas(CambiosCasas cambioCasa){
	Session session = sessionFactory.getCurrentSession();
	session.save(cambioCasa);
	}
	
	/**
	 * Actualiza una CambiosCasas
	 * 
	 * 
	 */

public void updateCambiosCasas(CambiosCasas cambioCasa){
	Session session = sessionFactory.getCurrentSession();
	session.update(cambioCasa);
	}

public void saveCambiosCasas(CambiosCasas cambioCasa){
	Session session = sessionFactory.getCurrentSession();
	session.saveOrUpdate(cambioCasa);
	}

	
}
