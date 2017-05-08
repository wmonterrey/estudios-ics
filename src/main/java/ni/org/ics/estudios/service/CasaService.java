package ni.org.ics.estudios.service;

import ni.org.ics.estudios.domain.Casa;
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
@Service("casaService")
@Transactional
public class CasaService {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    private List<Casa> getCasas()
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Casa ");
        return query.list();
    }

    public Casa getCasaByCodigo(Integer codigo)
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Casa where codigo = :codigo");
        query.setParameter("codigo",codigo);
        return (Casa)query.uniqueResult();
    }

    public List<Casa> getCasasByUser(String username)
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select c from Casa c where c.pasive = false and c.codigo in (select cc.tamizaje.participante.casa.codigo from CartaConsentimiento cc where cc.estudio.codigo in (" +
                "  select us.estudio.codigo  from UserStudy us where us.usuario.username = :username))");
        query.setParameter("username",username);
        return query.list();
    }

    public void saveOrUpdateCasa(Casa casa)
    {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(casa);
    }
}
