package ni.org.ics.estudios.domain;

import ni.org.ics.estudios.domain.audit.Auditable;
import ni.org.ics.estudios.domain.catalogs.Estudio;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by FIRSTICT on 4/28/2017.
 * V1.0
 */
@Entity
@Table(name = "tamizajes", catalog = "estudios_ics")
public class Tamizaje extends BaseMetaData implements Auditable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
    private Estudio estudio;
    private String sexo;
    private Date fechaNacimiento;
    private char aceptaTamizaje;
    private String razonNoAceptaTamizaje;
    private String criteriosInclusion;
    private String tienePadecimiento;
    private char elegible;
    private String dondeAsisteProblemasSalud;
    private char asisteCSSF;
    private String otroCentroSalud;
    private String puestoSalud;
    private char siEnfermaSoloAsistirCSSF;
    private char tomaPuntoGPSCasa;
    private String razonNoGeoreferenciacion;
    private String otraRazonNoGeoreferenciacion;


    @Id
    @Column(name = "CODIGO", nullable = false, insertable = true, updatable = false, length = 36)
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @ManyToOne
    @JoinColumn(name = "CODIGO_ESTUDIO", nullable = false)
    @ForeignKey(name = "FK_ESTUDIO_TAMIZAJE")
    public Estudio getEstudio() {
        return estudio;
    }

    public void setEstudio(Estudio estudio) {
        this.estudio = estudio;
    }

    @Column(name = "SEXO", length = 50)
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Column(name = "FECHA_NACIMIENTO", nullable = false)
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Column(name="ACEPTA_TAMIZAJE", nullable = false, length = 1)
    public char getAceptaTamizaje() {
        return aceptaTamizaje;
    }

    public void setAceptaTamizaje(char aceptaTamizaje) {
        this.aceptaTamizaje = aceptaTamizaje;
    }

    @Column(name="RAZON_NO_ACEPTA_TAMIZAJE", nullable = true, length = 50)
    public String getRazonNoAceptaTamizaje() {
        return razonNoAceptaTamizaje;
    }

    public void setRazonNoAceptaTamizaje(String razonNoAceptaTamizaje) {
        this.razonNoAceptaTamizaje = razonNoAceptaTamizaje;
    }

    
    @Column(name="CRITERIOS_INCLUSION", nullable = true, length = 50)
    public String getCriteriosInclusion() {
		return criteriosInclusion;
	}

	public void setCriteriosInclusion(String criteriosInclusion) {
		this.criteriosInclusion = criteriosInclusion;
	}

	@Column(name="ELEGIBLE", nullable = false, length = 1)
    public char getElegible() {
        return elegible;
    }

    public void setElegible(char elegible) {
        this.elegible = elegible;
    }

    @Column(name="DONDE_ASISTE_PROBLEMAS_SALUD", nullable = true)
    public String getDondeAsisteProblemasSalud() {
        return dondeAsisteProblemasSalud;
    }

    public void setDondeAsisteProblemasSalud(String dondeAsisteProblemasSalud) {
        this.dondeAsisteProblemasSalud = dondeAsisteProblemasSalud;
    }

    @Column(name="ASISTE_CSSF", nullable = false, length = 1)
    public char getAsisteCSSF() {
        return asisteCSSF;
    }

    public void setAsisteCSSF(char asisteCSSF) {
        this.asisteCSSF = asisteCSSF;
    }

    @Column(name="OTRO_CENTRO_SALUD", nullable = true)
    public String getOtroCentroSalud() {
        return otroCentroSalud;
    }

    public void setOtroCentroSalud(String otroCentroSalud) {
        this.otroCentroSalud = otroCentroSalud;
    }

    @Column(name="PUESTO_SALUD", nullable = true)
    public String getPuestoSalud() {
        return puestoSalud;
    }

    public void setPuestoSalud(String puestoSalud) {
        this.puestoSalud = puestoSalud;
    }

    @Column(name = "SI_ENFERMA_ASISTIR_CSSF", length = 1)
    public char getSiEnfermaSoloAsistirCSSF() {
        return siEnfermaSoloAsistirCSSF;
    }

    public void setSiEnfermaSoloAsistirCSSF(char siEnfermaSoloAsistirCSSF) {
        this.siEnfermaSoloAsistirCSSF = siEnfermaSoloAsistirCSSF;
    }

    @Column(name="TOMA_PUNTO_GPS", nullable = false, length = 1)
    public char getTomaPuntoGPSCasa() {
        return tomaPuntoGPSCasa;
    }

    public void setTomaPuntoGPSCasa(char tomaPuntoGPSCasa) {
        this.tomaPuntoGPSCasa = tomaPuntoGPSCasa;
    }

    @Column(name="RAZON_NOGEOREFERENCIA", nullable = true)
    public String getRazonNoGeoreferenciacion() {
        return razonNoGeoreferenciacion;
    }

    public void setRazonNoGeoreferenciacion(String razonNoGeoreferenciacion) {
        this.razonNoGeoreferenciacion = razonNoGeoreferenciacion;
    }

    @Column(name="OTRA_RAZON_NOGEOREFERENCIA", nullable = false)
    public String getOtraRazonNoGeoreferenciacion() {
        return otraRazonNoGeoreferenciacion;
    }

    public void setOtraRazonNoGeoreferenciacion(String otraRazonNoGeoreferenciacion) {
        this.otraRazonNoGeoreferenciacion = otraRazonNoGeoreferenciacion;
    }

    @Override
    public boolean isFieldAuditable(String fieldname) {
        return false;
    }

    @Override
    public String toString() {
        return "'" + codigo + "'";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tamizaje)) return false;

        Tamizaje tamizaje = (Tamizaje) o;

        return (!codigo.equals(tamizaje.codigo));
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }
}
