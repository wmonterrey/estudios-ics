package ni.org.ics.estudios.domain.cohortefamilia;

import ni.org.ics.estudios.domain.cohortefamilia.AreaAmbiente;

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

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigoHabitacion;
    private int cantidadCamas;

    @Column(name = "ID_HABITACION", length = 5)
    public String getCodigoHabitacion() {
        return codigoHabitacion;
    }

    public void setCodigoHabitacion(String codigoHabitacion) {
        this.codigoHabitacion = codigoHabitacion;
    }

    @Column(name = "CANTIDAD_CAMAS")
    public int getCantidadCamas() {
        return cantidadCamas;
    }

    public void setCantidadCamas(int cantidadCamas) {
        this.cantidadCamas = cantidadCamas;
    }
}
