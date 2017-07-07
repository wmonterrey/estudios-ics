package ni.org.ics.estudios.service.scancarta;

import ni.org.ics.estudios.domain.scancarta.VersionCarta;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by Miguel Salinas on 6/27/2017.
 * V1.0
 */
@Transactional
@Service("versionCartaService")
public class VersionCartaService {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public List<VersionCarta> getVersionesCartas(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from VersionCarta where pasive = '0'");
        return query.list();
    }

    public List<VersionCarta> getVersionesCartasByEstudio(Integer codigoEstudio){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from VersionCarta where pasive='0' and estudio.codigo = :codigoEstudio");
        query.setParameter("codigoEstudio",codigoEstudio);
        return query.list();
    }

    public VersionCarta getVersionCartaByCodigo(Integer codigo){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from VersionCarta where codigo = :codigo");
        query.setParameter("codigo", codigo);
        return (VersionCarta)query.uniqueResult();
    }

    public VersionCarta getVersionCartaByEstudioVersion(Integer estudio, String version){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from VersionCarta where pasive='0' and estudio.codigo = :estudio and version.messageKey = :version");
        query.setParameter("estudio", estudio);
        query.setParameter("version", version);
        return (VersionCarta)query.uniqueResult();
    }

    public VersionCarta getVersionCartaByEstudioRangoValidez(Integer estudio, Date fechaInicio, Date fechaFin){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from VersionCarta where pasive='0' and estudio.codigo = :estudio and ((fechaInicio between :inicio and :fin) or (fechaFin between :inicio and :fin))");
        query.setParameter("estudio", estudio);
        query.setParameter("inicio", fechaInicio);
        query.setParameter("fin", fechaFin);
        return (VersionCarta)query.uniqueResult();
    }


    public void saveOrUpdateVersionCarta(VersionCarta versionCarta)
    {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(versionCarta);
    }
}
