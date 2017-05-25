package ni.org.ics.estudios.domain.seroprevalencia;

import ni.org.ics.estudios.domain.BaseMetaData;
import ni.org.ics.estudios.domain.audit.Auditable;
import ni.org.ics.estudios.domain.cohortefamilia.CasaCohorteFamilia;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;

/**
 * Created by Miguel Salinas on 5/25/2017.
 * V1.0
 */
@Entity
@Table(name = "sa_encuestas_casa", catalog = "estudios_ics")
public class EncuestaCasaSA extends BaseMetaData implements Auditable {

    private CasaCohorteFamilia casa;
    private String sedazoPuertasVentanas;
    private String compraProdEvitarZancudos;
    private String tienePatioJardin;
    private String utilizaAbate;
    private String fumiga;
    private String conoceLarvas;
    private String lugaresLarvas;


    @Id
    @OneToOne
    @JoinColumn(name = "CODIGO_CASACHF", nullable = false)
    @ForeignKey(name = "FK_CASACHF_ENCUESTACASASA")
    public CasaCohorteFamilia getCasa() {
        return casa;
    }

    public void setCasa(CasaCohorteFamilia casa) {
        this.casa = casa;
    }

    @Override
    public boolean isFieldAuditable(String fieldname) {
        return true;
    }

    @Override
    public String toString() {
        return "EncuestaCasa{" + casa.getCodigoCHF() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EncuestaCasaSA)) return false;

        EncuestaCasaSA that = (EncuestaCasaSA) o;

        if (!casa.equals(that.casa)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return casa.hashCode();
    }
}
