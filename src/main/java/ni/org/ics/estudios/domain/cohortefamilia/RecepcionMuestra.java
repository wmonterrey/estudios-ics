package ni.org.ics.estudios.domain.cohortefamilia;

import ni.org.ics.estudios.domain.BaseMetaData;
import ni.org.ics.estudios.domain.audit.Auditable;

import javax.persistence.*;
import java.util.Date;

/**
 * Simple objeto de dominio que representa los datos de una recepción de muestra
 * 
 * @author Miguel Salinas
 **/

@Entity
@Table(name = "recepcion_muestras", catalog = "estudios_ics")
public class RecepcionMuestra extends BaseMetaData implements Auditable {

	/**
	 * 
	 */

    private String codigoMx;
    private Date fechaRecepcion;
	private Boolean paxgene;
	private Double volumen;
	private String lugar;
	private String observacion;

    @Id
    @Column(name = "CODIGO_MX", length = 50, nullable = true)
    public String getCodigoMx() {
        return codigoMx;
    }

    public void setCodigoMx(String codigoMx) {
        this.codigoMx = codigoMx;
    }

    @Id
    @Column(name = "FECHA_RECEPCION", nullable = false)
    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    @Column(name="PAXGENE", nullable = true)
	public Boolean getPaxgene() {
		return paxgene;
	}

	public void setPaxgene(Boolean paxgene) {
		this.paxgene = paxgene;
	}

	@Column(name="VOLUMEN", nullable = true)
	public Double getVolumen() {
		return volumen;
	}

	public void setVolumen(Double volumen) {
		this.volumen = volumen;
	}

	@Column(name="OBSERVACION", nullable = true)
	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	@Column(name="LUGAR", nullable = true)
	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
    @Override
    public boolean isFieldAuditable(String fieldname) {
        return true;
    }

    @Override
    public String toString() {
        return "RecepcionMuestra{" + codigoMx + "," + fechaRecepcion +'}';
    }
}
