package ni.org.ics.estudios.service;

import ni.org.ics.estudios.domain.Participante;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Miguel Salinas on 5/2/2017.
 * V1.0
 */
@Service("participanteService")
@Transactional
public class ParticipanteService {
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
	public List<Participante> getParticipantes(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Participante");
        return query.list();
    }

    public Participante getParticipanteByCodigo(Integer codigo){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Participante where codigo = :codigo");
        query.setParameter("codigo",codigo);
        return (Participante)query.uniqueResult();
    }

    public void saveOrUpdateParticipante(Participante participante){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(participante);
    }

    /**
     * Regresa un codigo de casa
     *
     * @return un <code>Integer</code>
     */

    public Integer checkCasa(Integer codigo) {
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();
        Integer codCasa = 0;
        Query query = session.createQuery("FROM Participante par where par.codigo = "+ codigo);
        Participante participante = (Participante) query.uniqueResult();
        if (participante!= null){
            codCasa = participante.getCasa().getCodigo();
        }
        return codCasa;
    }

    /**
     * Verifica un Participante
     *
     * @return true or false
     */

    public Boolean checkParticipante(Integer codigo) {
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Participante par where par.codigo = "+codigo);
        Participante participante = (Participante) query.uniqueResult();
        if(participante!=null){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Regresa todos los Participantes Activos
     *
     * @return una lista de <code>Participante</code>(s) Activos
     */

    @SuppressWarnings("unchecked")
    public List<Participante> getParticipantesActivos() {
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();
        // Create a Hibernate query (HQL)
        Query query = session.createQuery("select p FROM Participante p, ParticipanteProcesos pp where p.codigo = pp.codigo and pp.estPart = 1");
        // Retrieve all
        return  query.list();
    }
}
