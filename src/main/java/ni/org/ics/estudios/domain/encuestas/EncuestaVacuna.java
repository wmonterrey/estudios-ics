package ni.org.ics.estudios.domain.encuestas;

import ni.org.ics.estudios.domain.BaseMetaData;
import ni.org.ics.estudios.domain.Participante;
import ni.org.ics.estudios.domain.audit.Auditable;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import java.util.Date;

/**
 * Simple objeto de dominio que representa los datos de vacunas recibidas
 * 
 * @author Brenda Lopez
 **/

@Entity
@Table(name = "encuestas_vacuna", catalog = "estudios_ics")
public class EncuestaVacuna extends BaseMetaData implements Auditable {

	/**
	 * 
	 */
    private Participante participante;
	private Integer vacuna;
	private Date fechaVac;
	private String tipovacuna;
	private Integer tarjetaSN;
	private Integer ndosis;
	private Date fechaInf1;
	private Date fechaInf2;
	private Date fechaInf3;
	private Date fechaInf4;
	private Date fechaInf5;
	private Date fechaInf6;
	private Date fechaInf7;
	private Date fechaInf8;
	private Date fechaInf9;
	private Date fechaInf10;
	private Integer otrorecurso1;

    @Id
    @ManyToOne
    @JoinColumn(name = "CODIDO_PARTICIPANTE")
    @ForeignKey(name = "FK_PARTICIPANTE_VACUNA")
    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    @Column(name = "VACUNA", nullable = false, length = 1)
	public Integer getVacuna() {
		return vacuna;
	}

	public void setVacuna(Integer vacuna) {
		this.vacuna = vacuna;
	}

	@Column(name = "FECHA_VACUNADO", nullable = true)
	public Date getFechaVac() {
		return fechaVac;
	}

	public void setFechaVac(Date fechaVac) {
		this.fechaVac = fechaVac;
	}

	@Column(name = "TIPO_VACUNA", nullable = true)
	public String getTipovacuna() {
		return tipovacuna;
	}

	public void setTipovacuna(String tipovacuna) {
		this.tipovacuna = tipovacuna;
	}

	@Column(name = "TARJETA_SN", nullable = true)
	public Integer getTarjetaSN() {
		return tarjetaSN;
	}

	public void setTarjetaSN(Integer tarjetaSN) {
		this.tarjetaSN = tarjetaSN;
	}

	@Column(name = "N_DOSIS", nullable = true)
	public Integer getNdosis() {
		return ndosis;
	}

	public void setNdosis(Integer ndosis) {
		this.ndosis = ndosis;
	}

	@Column(name = "FECHA_INF1", nullable = true)
	public Date getFechaInf1() {
		return fechaInf1;
	}

	public void setFechaInf1(Date fechaInf1) {
		this.fechaInf1 = fechaInf1;
	}

	@Column(name = "FECHA_INF2", nullable = true)
	public Date getFechaInf2() {
		return fechaInf2;
	}

	public void setFechaInf2(Date fechaInf2) {
		this.fechaInf2 = fechaInf2;
	}

	@Column(name = "FECHA_INF3", nullable = true)
	public Date getFechaInf3() {
		return fechaInf3;
	}

	public void setFechaInf3(Date fechaInf3) {
		this.fechaInf3 = fechaInf3;
	}

	@Column(name = "FECHA_INF4", nullable = true)
	public Date getFechaInf4() {
		return fechaInf4;
	}

	public void setFechaInf4(Date fechaInf4) {
		this.fechaInf4 = fechaInf4;
	}

	@Column(name = "FECHA_INF5", nullable = true)
	public Date getFechaInf5() {
		return fechaInf5;
	}

	public void setFechaInf5(Date fechaInf5) {
		this.fechaInf5 = fechaInf5;
	}

	@Column(name = "FECHA_INF6", nullable = true)
	public Date getFechaInf6() {
		return fechaInf6;
	}

	public void setFechaInf6(Date fechaInf6) {
		this.fechaInf6 = fechaInf6;
	}

	@Column(name = "FECHA_INF7", nullable = true)
	public Date getFechaInf7() {
		return fechaInf7;
	}

	public void setFechaInf7(Date fechaInf7) {
		this.fechaInf7 = fechaInf7;
	}

	@Column(name = "FECHA_INF8", nullable = true)
	public Date getFechaInf8() {
		return fechaInf8;
	}

	public void setFechaInf8(Date fechaInf8) {
		this.fechaInf8 = fechaInf8;
	}

	@Column(name = "FECHA_INF9", nullable = true)
	public Date getFechaInf9() {
		return fechaInf9;
	}

	public void setFechaInf9(Date fechaInf9) {
		this.fechaInf9 = fechaInf9;
	}

	@Column(name = "FECHA_INF10", nullable = true)
	public Date getFechaInf10() {
		return fechaInf10;
	}

	public void setFechaInf10(Date fechaInf10) {
		this.fechaInf10 = fechaInf10;
	}

	@Column(name = "OTRO_RECURSO1", nullable = true, length = 10)
	public Integer getOtrorecurso1() {
		return otrorecurso1;
	}

	public void setOtrorecurso1(Integer otrorecurso1) {
		this.otrorecurso1 = otrorecurso1;
	}

    @Override
    public boolean isFieldAuditable(String fieldname) {
        return true;
    }

    @Override
    public String toString() {
        return "EncuestaVacuna{" + participante.getCodigo() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EncuestaVacuna)) return false;

        EncuestaVacuna that = (EncuestaVacuna) o;

        return  (!participante.equals(that.participante));
    }

    @Override
    public int hashCode() {
        return participante.hashCode();
    }
}
