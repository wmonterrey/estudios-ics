package ni.org.ics.estudios.domain;

import ni.org.ics.estudios.domain.catalogs.Barrio;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import java.io.Serializable;


/**
 *  Objeto que representa CambioDomicilio
 * @author Miguel Salinas
 **/
@Entity
@Table(name = "cambios_domicilio", catalog = "estudios_ics")
public class CambioDomicilio extends BaseMetaData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String codigo;
    private Participante participante;
	private Barrio barrio;
    private String otroBarrio;
	private String direccion;
    private String manzana;
    private String puntoGps;
	private Double latitud;
	private Double longitud;
    private String razonNoGeoref;
    private String otraRazonNoGeoref;

    @Id
    @Column(name = "CODIGO", nullable = false, length = 50)
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @ManyToOne(optional = true)
    @JoinColumn(name="CODIGO_PARTICIPANTE", nullable = false)
    @ForeignKey(name = "FK_PARTICIPANTE_CAMBIODOM")
    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    @ManyToOne(optional = true)
    @JoinColumn(name="CODIGO_BARRIO", nullable = false)
    @ForeignKey(name = "FK_BARRIO_CAMBIODOM")
    public Barrio getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }

    @Column(name = "OTRO_BARRIO", nullable = true, length = 250)
    public String getOtroBarrio() {
        return otroBarrio;
    }

    public void setOtroBarrio(String otroBarrio) {
        this.otroBarrio = otroBarrio;
    }

    @Column(name = "DIRECCION", nullable = true, length = 250)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Column(name = "MANZANA", nullable = true, length = 4)
    public String getManzana() {
        return manzana;
    }

    public void setManzana(String manzana) {
        this.manzana = manzana;
    }

    @Column(name = "PUNTO_GPS", nullable = true, length = 2)
    public String getPuntoGps() {
        return puntoGps;
    }

    public void setPuntoGps(String puntoGps) {
        this.puntoGps = puntoGps;
    }

    @Column(name = "LATITUD", nullable = true)
    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    @Column(name = "LONGITUD", nullable = true)
    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    @Column(name = "RAZON_SIN_PUNTO", nullable = true, length = 2)
    public String getRazonNoGeoref() {
        return razonNoGeoref;
    }

    public void setRazonNoGeoref(String razonNoGeoref) {
        this.razonNoGeoref = razonNoGeoref;
    }

    @Column(name = "OTRA_RAZON_SIN_PUNTO", nullable = true, length = 250)
    public String getOtraRazonNoGeoref() {
        return otraRazonNoGeoref;
    }

    public void setOtraRazonNoGeoref(String otraRazonNoGeoref) {
        this.otraRazonNoGeoref = otraRazonNoGeoref;
    }

    @Override
	public String toString(){
		return this.codigo + " " + this.latitud+" "+this.longitud;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CambioDomicilio)) return false;

        CambioDomicilio casa = (CambioDomicilio) o;

        return (!codigo.equals(casa.codigo));
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }
}
