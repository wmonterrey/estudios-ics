package ni.org.ics.estudios.service.cohortefamilia;

import ni.org.ics.estudios.domain.cohortefamilia.encuestas.EncuestaVacuna;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Miguel Salinas on 5/5/2017.
 * V1.0
 */
@Transactional
@Service("encuestaVacunaService")
public class EncuestaVacunaService {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public List<EncuestaVacuna> getEncuestasVacuna(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from EncuestaVacuna");
        return query.list();
    }

    public List<EncuestaVacuna> getEncuestasVacunaByUser(String username){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from EncuestaVacuna ec where ec.pasive = false and ec.participante.casa.codigo in (" +
                "select cc.participante.casa.codigo from CartaConsentimiento cc where cc.tamizaje.estudio.codigo in (" +
                " select us.estudio.codigo from UserStudy us where us.usuario.username = :username))");
        query.setParameter("username",username);
        return query.list();
    }

    public EncuestaVacuna getEncuestaVacunaByCodigo(Integer codigo){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from EncuestaVacuna where participante.codigo = :codigo");
        query.setParameter("codigo", codigo);
        return (EncuestaVacuna)query.uniqueResult();
    }

    public void saveOrUpdateEncuestaVacuna(EncuestaVacuna encuestaVacuna){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(encuestaVacuna);
    }
}
