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
}
