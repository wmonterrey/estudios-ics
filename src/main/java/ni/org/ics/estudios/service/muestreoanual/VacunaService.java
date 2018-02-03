package ni.org.ics.estudios.service.muestreoanual;

import ni.org.ics.estudios.domain.muestreoanual.Vacuna;
import ni.org.ics.estudios.domain.muestreoanual.VacunaId;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * Servicio para el objeto Vacuna
 * 
 * @author Brenda Lopez
 * 
 **/

@Service("vacunaService")
@Transactional
public class VacunaService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	/**
	 * Regresa todos las Vacunas
	 * 
	 * @return una lista de <code>Vacuna</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<Vacuna> getVacunas() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Vacuna");
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Regresa una Vacuna
	 * 
	 * @return un <code>Vacuna</code>
	 */

	public Vacuna getVacuna(VacunaId vacId) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Timestamp timeStamp = new Timestamp(vacId.getFechaVacuna().getTime());
		Query query = session.createQuery("FROM Vacuna vac where " +
				"vac.vacunaId.codigo = " + vacId.getCodigo() + " AND vac.vacunaId.fechaVacuna = :fechaV");
		query.setTimestamp("fechaV", timeStamp);
		
		Vacuna vacuna = (Vacuna) query.uniqueResult();
		return vacuna;
	}
	
	/**
	 * Verifica una Vacuna
	 * 
	 * @return true or false
	 */

	public Boolean checkVacuna(VacunaId vacId) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		Timestamp timeStamp = new Timestamp(vacId.getFechaVacuna().getTime());
		Query query = session.createQuery("FROM Vacuna vac where " +
				"vac.vacunaId.codigo = " + vacId.getCodigo() + " AND vac.vacunaId.fechaVacuna = :fechaV");
		query.setTimestamp("fechaV", timeStamp);
		
		Vacuna vacuna = (Vacuna) query.uniqueResult();
		if(vacuna!=null){
			return true;
		}
		else{
			return false;
		}
			
	}
	
	/**
	 * Agrega un Vacuna
	 * 
	 * 
	 */
	public void addVacuna(Vacuna vacuna) {
		Session session = sessionFactory.getCurrentSession();
		session.save(vacuna);
	}
	
	/**
	 * Actualiza un Vacuna
	 * 
	 * 
	 */
	public void updateVacuna(Vacuna vacuna) {
		Session session = sessionFactory.getCurrentSession();
		session.update(vacuna);
	}
	
}
