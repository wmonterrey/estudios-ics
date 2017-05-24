package ni.org.ics.estudios.service.cohortefamilia;

import ni.org.ics.estudios.domain.cohortefamilia.ParticipanteCohorteFamilia;
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
@Service("participanteCohorteFamiliaService")
@Transactional
public class ParticipanteCohorteFamiliaService {
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
	public List<ParticipanteCohorteFamilia> getParticipantesCHF(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from ParticipanteCohorteFamilia where pasive = '0'");
        return query.list();
    }

    public ParticipanteCohorteFamilia getParticipanteCHFByCodigo(String codigo){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from ParticipanteCohorteFamilia where participanteCHF = :codigo");
        query.setParameter("codigo",codigo);
        return (ParticipanteCohorteFamilia)query.uniqueResult();
    }

    public void saveOrUpdateParticipanteCHF(ParticipanteCohorteFamilia participante){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(participante);
    }
}
