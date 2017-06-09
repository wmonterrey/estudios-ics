package ni.org.ics.estudios.service.cohortefamilia.casos;

import ni.org.ics.estudios.domain.cohortefamilia.casos.ParticipanteCohorteFamiliaCaso;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Miguel Salinas on 5/11/2017.
 * V1.0
 */
@Transactional
@Service("participanteCohorteFamiliaCasoService")
public class ParticipanteCohorteFamiliaCasoService {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
	public List<ParticipanteCohorteFamiliaCaso> getParticipanteCohorteFamiliaCasos(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from ParticipanteCohorteFamiliaCaso p where p.pasive = '0'");
        return query.list();
    }

    public void saveOrUpdateParticipanteCohorteFamiliaCaso(ParticipanteCohorteFamiliaCaso participante){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(participante);
    }
}
