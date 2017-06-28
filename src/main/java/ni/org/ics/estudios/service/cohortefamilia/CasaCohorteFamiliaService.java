package ni.org.ics.estudios.service.cohortefamilia;

import ni.org.ics.estudios.domain.cohortefamilia.CasaCohorteFamilia;
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
@Service("casaCohorteFamiliaService")
public class CasaCohorteFamiliaService {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public List<CasaCohorteFamilia> getCasasCHFByUser(String username)
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select c from CasaCohorteFamilia c where c.pasive = '0' and c.casa.codigo in (select cc.participante.casa.codigo from CartaConsentimiento cc where cc.tamizaje.estudio.codigo in (" +
                "  select us.estudio.codigo  from UserStudy us where us.usuario.username = :username))");
        query.setParameter("username",username);
        return query.list();
    }

    public List<CasaCohorteFamilia> getCasasCHF()
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select c from CasaCohorteFamilia c where c.pasive = '0'");
        return query.list();
    }

    public CasaCohorteFamilia getCasasCHFByCodigo(String codigo)
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select c from CasaCohorteFamilia c where c.pasive = '0' and c.codigoCHF = :codigo");
        query.setParameter("codigo",codigo);
        return (CasaCohorteFamilia)query.uniqueResult();
    }

    public void saveOrUpdateCasaCHF(CasaCohorteFamilia casa)
    {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(casa);
    }
}
