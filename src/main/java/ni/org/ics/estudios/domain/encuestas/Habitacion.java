package ni.org.ics.estudios.domain.encuestas;

import ni.org.ics.estudios.domain.Casa;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Miguel Salinas on 5/3/2017.
 * V1.0
 */
@Entity
@DiscriminatorValue("habitacion")
public class Habitacion extends AreaAmbiente {

    private int cantidadCamas;

    @Column(name = "CANTIDAD_CAMAS")
    public int getCantidadCamas() {
        return cantidadCamas;
    }

    public void setCantidadCamas(int cantidadCamas) {
        this.cantidadCamas = cantidadCamas;
    }
}
