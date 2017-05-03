package ni.org.ics.estudios.service;

import ni.org.ics.estudios.domain.CartaConsentimiento;
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
@Service("cartaConsentimientoService")
@Transactional
public class CartaConsentimientoService {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public List<CartaConsentimiento> getCartasConsentimiento()
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CartaConsentimiento ");
        return query.list();
    }

    public CartaConsentimiento getCartaConsentimientoByCodigo(String codigo)
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CartaConsentimiento where codigo = :codigo");
        query.setParameter("codigo", codigo);
        return (CartaConsentimiento)query.uniqueResult();
    }

    public void saveOrUpdateCartaConsentimiento(CartaConsentimiento cartaConsentimiento)
    {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cartaConsentimiento);
    }
}
