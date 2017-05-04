package ni.org.ics.estudios.domain.encuestas;

import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;

/**
 * Created by Miguel Salinas on 5/3/2017.
 * V1.0
 */
@Entity
@DiscriminatorValue("ventana")
public class Ventana extends AreaAmbiente {

    //private String codigoVentana;
    private AreaAmbiente areaAmbiente;
    private Double alto;
    private char abierta;

    /*
    @Id
    @Column(name = "CODIGO")
    public String getCodigoVentana() {
        return codigoVentana;
    }

    public void setCodigoVentana(String codigoVentana) {
        this.codigoVentana = codigoVentana;
    }*/

    @Column(name = "ALTO")
    public Double getAlto() {
        return alto;
    }

    public void setAlto(Double alto) {
        this.alto = alto;
    }

    @Column(name = "ABIERTA", length = 1)
    public char getAbierta() {
        return abierta;
    }

    public void setAbierta(char abierta) {
        this.abierta = abierta;
    }

    @ManyToOne
    @JoinColumn(name = "CODIGO_AREA_VENT")
    @ForeignKey(name = "FK_AREAAMBIENTE_VENTANA")
    public AreaAmbiente getAreaAmbiente() {
        return areaAmbiente;
    }

    public void setAreaAmbiente(AreaAmbiente areaAmbiente) {
        this.areaAmbiente = areaAmbiente;
    }
}
