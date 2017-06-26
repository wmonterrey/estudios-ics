package ni.org.ics.estudios.domain.cohortefamilia.casos;

import ni.org.ics.estudios.domain.BaseMetaData;
import ni.org.ics.estudios.domain.audit.Auditable;
import javax.persistence.*;

import org.hibernate.annotations.ForeignKey;

/**
 * Created by William Aviles on 6/07/2017.
 * V1.0
 */
@Entity
@Table(name = "chf_inf_no_completa_casos", catalog = "estudios_ics")
public class InformacionNoCompletaCaso extends BaseMetaData implements Auditable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigoNoDataVisita;
	private VisitaSeguimientoCaso codigoVisitaCaso;
	private String razonNoCompletaInformacion;
	private String otraRazon;
	
    
	@Id
    @Column(name = "CODIGO_NODATA_CASO", length = 50, nullable = false)
	public String getCodigoNoDataVisita() {
		return codigoNoDataVisita;
	}

	public void setCodigoNoDataVisita(String codigoNoDataVisita) {
		this.codigoNoDataVisita = codigoNoDataVisita;
	}

	@ManyToOne
    @JoinColumn(name = "CODIGO_VISITA_CASO", nullable = false)
    @ForeignKey(name = "FK_NODATA_PARTICIPANTE")
	public VisitaSeguimientoCaso getCodigoVisitaCaso() {
		return codigoVisitaCaso;
	}

	public void setCodigoVisitaCaso(VisitaSeguimientoCaso codigoVisitaCaso) {
		this.codigoVisitaCaso = codigoVisitaCaso;
	}

	@Column(name = "RAZON_NODATA_VISITA", length = 10, nullable = false)
	public String getRazonNoCompletaInformacion() {
		return razonNoCompletaInformacion;
	}

	public void setRazonNoCompletaInformacion(String razonNoCompletaInformacion) {
		this.razonNoCompletaInformacion = razonNoCompletaInformacion;
	}

	@Column(name = "OTRA_RAZON_NODATA_VISITA", length = 255, nullable = true)
	public String getOtraRazon() {
		return otraRazon;
	}

	public void setOtraRazon(String otraRazon) {
		this.otraRazon = otraRazon;
	}

	@Override
	public String toString(){
		return codigoVisitaCaso.getFechaVisita().toString();
	}
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InformacionNoCompletaCaso)) return false;

        InformacionNoCompletaCaso that = (InformacionNoCompletaCaso) o;

        if (!codigoNoDataVisita.equals(that.codigoNoDataVisita)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codigoNoDataVisita.hashCode();
        result = 31 * result + codigoNoDataVisita.hashCode();
        return result;
    }

	@Override
	public boolean isFieldAuditable(String fieldname) {
		// TODO Auto-generated method stub
		return true;
	}
}
