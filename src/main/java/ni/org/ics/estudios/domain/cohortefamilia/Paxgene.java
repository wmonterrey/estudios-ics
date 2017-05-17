package ni.org.ics.estudios.domain.cohortefamilia;

import ni.org.ics.estudios.domain.BaseMetaData;
import ni.org.ics.estudios.domain.audit.Auditable;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Miguel Salinas on 5/17/2017.
 * V1.0
 */
@Entity
@Table(name = "chf_datos_paxgene", catalog = "estudios_ics")
public class Paxgene extends BaseMetaData implements Auditable, Serializable {

    private static final long serialVersionUID = 1L;

    private Muestra muestra;
    private String horaInicio;
    private String horaFin;

    @Id
    @OneToOne
    @JoinColumn(name = "CODIGO_MX",referencedColumnName = "CODIGO_MX")
    @ForeignKey(name = "FK_MUESTRA_DATOSPAXGENE")
    public Muestra getMuestra() {
        return muestra;
    }

    public void setMuestra(Muestra muestra) {
        this.muestra = muestra;
    }

    @Column(name = "HORA_INICIO", nullable = false, length = 20)
    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    @Column(name = "HORA_FIN", nullable = false, length = 20)
    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    @Override
    public String toString() {
        return "Paxgene{" + muestra.getCodigoMx() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paxgene)) return false;

        Paxgene paxgene = (Paxgene) o;

        return  (!muestra.equals(paxgene.muestra));
    }

    @Override
    public int hashCode() {
        return muestra.hashCode();
    }

    @Override
    public boolean isFieldAuditable(String fieldname) {
        return true;
    }
}
