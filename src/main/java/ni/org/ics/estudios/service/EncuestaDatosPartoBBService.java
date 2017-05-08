package ni.org.ics.estudios.service;

import ni.org.ics.estudios.domain.encuestas.EncuestaDatosPartoBB;
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
@Service("encuestaDatosPartoBBService")
public class EncuestaDatosPartoBBService {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public List<EncuestaDatosPartoBB> getEncuestasDatosPartoBB()
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from EncuestaDatosPartoBB ");
        return query.list();
    }

    public EncuestaDatosPartoBB getEncuestaDatosPartoBBByCodigo(Integer codigo){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from EncuestaDatosPartoBB where participante.codigo = :codigo");
        query.setParameter("codigo", codigo );
        return (EncuestaDatosPartoBB)query.uniqueResult();
    }

    public List<EncuestaDatosPartoBB> getEncuestasDatosPartoBBByUser(String username)
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select ec from EncuestaDatosPartoBB ec where ec.pasive = false and ec.participante.casa.codigo in (" +
                "select cc.tamizaje.participante.casa.codigo from CartaConsentimiento cc where cc.estudio.codigo in (" +
                " select us.estudio.codigo from UserStudy us where us.usuario.username = :username))");
        query.setParameter("username",username);
        return query.list();
    }

    public void saveOrUpdateEncuestaDatosPartoBB(EncuestaDatosPartoBB encuestaDatosPartoBB){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(encuestaDatosPartoBB);
    }
}
