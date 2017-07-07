package ni.org.ics.estudios.service.scancarta;

import ni.org.ics.estudios.domain.scancarta.ScanCarta;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Miguel Salinas on 6/27/2017.
 * V1.0
 */
@Transactional
@Service("scanCartaService")
public class ScanCartaService {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;


    public List<ScanCarta> getScanCartas(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from ScanCarta ");
        return query.list();
    }

    public List<ScanCarta> getScanCartasByParticipante(Integer codigoParticipante){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from ScanCarta where participante = :codigoParticipante");
        query.setParameter("codigoParticipante",codigoParticipante);
        return query.list();
    }

    public void saveOrUpdateScanCarta(ScanCarta scanCarta)
    {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(scanCarta);
    }
}
