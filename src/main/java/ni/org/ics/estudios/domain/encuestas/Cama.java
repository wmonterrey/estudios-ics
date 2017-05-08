package ni.org.ics.estudios.domain.encuestas;

import ni.org.ics.estudios.domain.BaseMetaData;
import ni.org.ics.estudios.domain.audit.Auditable;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;

/**
 * Created by Miguel Salinas on 5/3/2017.
 * V1.0
 */
@Entity
@Table(name = "camas_habitacion", catalog = "estudios_ics")
public class Cama extends BaseMetaData implements Auditable {

    private String codigoCama;
    private Habitacion habitacion;

    @Id
    @Column(name = "CODIGO", length = 36)
    public String getCodigoCama() {
        return codigoCama;
    }

    public void setCodigoCama(String codigoCama) {
        this.codigoCama = codigoCama;
    }

    @ManyToOne
    @JoinColumn(name = "CODIGO_HABITACION")
    @ForeignKey(name = "FK_CAMA_HABITACION")
    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    @Override
    public boolean isFieldAuditable(String fieldname) {
        return true;
    }

    @Override
    public String toString() {
        return "Cama{" + codigoCama + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cama)) return false;

        Cama cama = (Cama) o;

        return (!codigoCama.equals(cama.codigoCama));
    }

    @Override
    public int hashCode() {
        return codigoCama.hashCode();
    }
}
