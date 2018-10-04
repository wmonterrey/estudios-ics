package ni.org.ics.estudios.domain;

import ni.org.ics.estudios.domain.catalogs.Barrio;
import ni.org.ics.estudios.domain.muestreoanual.MovilInfo;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import java.io.Serializable;


/**
 *  Objeto que representa DatosCoordenadas
 * @author Miguel Salinas
 **/
@Entity
@Table(name = "datos_coordenadas", catalog = "estudios_ics")
public class DatosCoordenadas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String codigo;
    private Integer codigoCasa;
    private String estudios;
    private Participante participante;
    private String motivo;
	private Barrio barrio;
    private String otroBarrio;
	private String direccion;
    private String manzana;
    private String conpunto;
    private String puntoGps;
	private Double latitud;
	private Double longitud;
    private String razonNoGeoref;
    private String otraRazonNoGeoref;

    private MovilInfo movilInfo;
    @Id
    @Column(name = "CODIGO", nullable = false, length = 50)
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Column(name = "CODIGO_CASA", nullable = true, length = 4)
    public Integer getCodigoCasa() {
        return codigoCasa;
    }

    public void setCodigoCasa(Integer codigoCasa) {
        this.codigoCasa = codigoCasa;
    }

    @Column(name = "ESTUDIOS_ACTUALES", nullable = true, length = 255)
    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
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

    @Column(name = "MOTIVO", nullable = true, length = 2)
    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @ManyToOne(optional = true)
    @JoinColumn(name="CODIGO_BARRIO", nullable = true)
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

    @Column(name = "CON_PUNTO_GPS", nullable = true, length = 2)
    public String getConpunto() {
        return conpunto;
    }

    public void setConpunto(String conpunto) {
        this.conpunto = conpunto;
    }

    @Column(name = "PUNTO_GPS", nullable = true, length = 100)
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

    public MovilInfo getMovilInfo() {
        return movilInfo;
    }

    public void setMovilInfo(MovilInfo movilInfo) {
        this.movilInfo = movilInfo;
    }

    @Override
	public String toString(){
		return this.codigo + " " + this.latitud+" "+this.longitud;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DatosCoordenadas)) return false;

        DatosCoordenadas casa = (DatosCoordenadas) o;

        return (!codigo.equals(casa.codigo));
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }
}
