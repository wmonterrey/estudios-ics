package ni.org.ics.estudios.service;

import ni.org.ics.estudios.domain.Tamizaje;
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
@Service("tamizajeService")
@Transactional
public class TamizajeService {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public List<Tamizaje> getTamizajes()
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Tamizaje ");
        return query.list();
    }

    public Tamizaje getTamizajeByCodigo(String codigo)
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Tamizaje where codigo = :codigo");
        return (Tamizaje)query.uniqueResult();
    }

    public void saveOrUpdateTamizaje(Tamizaje tamizaje)
    {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(tamizaje);
    }
}
