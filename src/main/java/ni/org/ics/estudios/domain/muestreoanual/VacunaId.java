package ni.org.ics.estudios.domain.muestreoanual;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class VacunaId implements Serializable {
	/**
	 * Objeto que representa la clave unica de una encuesta de participante
	 * 
	 * @author Brenda Lopez
	 **/

	private static final long serialVersionUID = 1L;
	private Integer codigo;
	private Date fechaVacuna;

	public VacunaId() {

	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VacunaId))
			return false;
		VacunaId castOther = (VacunaId) other;
		return (this.getCodigo() == castOther.getCodigo())
				&& (this.getFechaVacuna() == castOther.getFechaVacuna());
	}

	public int hashCode() {
		int result = 17;
		result = 37 * 3 + this.getCodigo();
		result = 37 * result + Integer.valueOf(this.getFechaVacuna().toString());
		return result;
	}

	@Column(name = "codigo", nullable = false, length = 5)
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	@Column(name = "fecha_vacuna", nullable = false)
	public Date getFechaVacuna() {
		return fechaVacuna;
	}

	public void setFechaVacuna(Date fechaVacuna) {
		this.fechaVacuna = fechaVacuna;
	}



}