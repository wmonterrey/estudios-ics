package ni.org.ics.estudios.domain.encuestas;

import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;

/**
 * Created by Miguel Salinas on 5/3/2017.
 * V1.0
 */
@Entity
@DiscriminatorValue("banio")
public class Banio extends  AreaAmbiente {

    private Habitacion habitacion;
    private char conVentana;

    @ManyToOne
    @JoinColumn(name = "CODIGO_HABITACION")
    @ForeignKey(name = "FK_HABITACION_BANIO")
    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    @Column(name = "CON_VENTANA", length = 1)
    public char getConVentana() {
        return conVentana;
    }

    public void setConVentana(char conVentana) {
        this.conVentana = conVentana;
    }
}
