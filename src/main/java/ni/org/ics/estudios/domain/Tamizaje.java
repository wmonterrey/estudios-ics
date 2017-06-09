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
    private String aceptaTamizajePersona;
    private String razonNoAceptaTamizajePersona;
    private String otraRazonNoAceptaTamizajePersona;
    private String criteriosInclusion;
    private String enfermedad;
    private String dondeAsisteProblemasSalud;
    private String otroCentroSalud;
    private String puestoSalud;
    private String aceptaAtenderCentro;
    private String esElegible;
    private String aceptaParticipar;
    private String razonNoAceptaParticipar;
    private String otraRazonNoAceptaParticipar;
    private String asentimientoVerbal;

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

    @Column(name = "FECHA_NACIMIENTO", nullable = true)
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Column(name="ACEPTA_TAMIZAJE", nullable = false, length = 1)
    public String getAceptaTamizajePersona() {
        return aceptaTamizajePersona;
    }

    public void setAceptaTamizajePersona(String aceptaTamizajePersona) {
        this.aceptaTamizajePersona = aceptaTamizajePersona;
    }

    @Column(name="RAZON_NO_ACEPTA_TAMIZAJE", nullable = true, length = 50)
    public String getRazonNoAceptaTamizajePersona() {
        return razonNoAceptaTamizajePersona;
    }

    public void setRazonNoAceptaTamizajePersona(String razonNoAceptaTamizajePersona) {
        this.razonNoAceptaTamizajePersona = razonNoAceptaTamizajePersona;
    }

    @Column(name="CRITERIOS_INCLUSION", nullable = true, length = 50)
    public String getCriteriosInclusion() {
        return criteriosInclusion;
    }

    public void setCriteriosInclusion(String criteriosInclusion) {
        this.criteriosInclusion = criteriosInclusion;
    }

    @Column(name="ENFERMEDAD", nullable = true, length = 50)
    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    @Column(name="DONDE_ASISTE_PROBLEMAS_SALUD", nullable = true)
    public String getDondeAsisteProblemasSalud() {
        return dondeAsisteProblemasSalud;
    }

    public void setDondeAsisteProblemasSalud(String dondeAsisteProblemasSalud) {
        this.dondeAsisteProblemasSalud = dondeAsisteProblemasSalud;
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

    @Column(name="ASISTIR_CSSF", nullable = true, length = 5)
    public String getAceptaAtenderCentro() {
        return aceptaAtenderCentro;
    }

    public void setAceptaAtenderCentro(String aceptaAtenderCentro) {
        this.aceptaAtenderCentro = aceptaAtenderCentro;
    }

    @Column(name="ELEGIBLE", nullable = true, length = 1)
    public String getEsElegible() {
        return esElegible;
    }

    public void setEsElegible(String esElegible) {
        this.esElegible = esElegible;
    }

    @Column(name="ACEPTA_PARTICIPAR", nullable = true, length = 1)
    public String getAceptaParticipar() {
        return aceptaParticipar;
    }

    public void setAceptaParticipar(String aceptaParticipar) {
        this.aceptaParticipar = aceptaParticipar;
    }

    @Column(name="RAZON_NO_ACEPTA_PARTICIPAR", nullable = true, length = 5)
    public String getRazonNoAceptaParticipar() {
        return razonNoAceptaParticipar;
    }

    public void setRazonNoAceptaParticipar(String razonNoAceptaParticipar) {
        this.razonNoAceptaParticipar = razonNoAceptaParticipar;
    }

    @Column(name="ASENTIMIENTO_VERBAL", nullable = true, length = 1)
    public String getAsentimientoVerbal() {
        return asentimientoVerbal;
    }

    public void setAsentimientoVerbal(String asentimientoVerbal) {
        this.asentimientoVerbal = asentimientoVerbal;
    }

    @Column(name="OTRA_RAZON_NO_ACEPTA_TAMIZAJE", nullable = true)
    public String getOtraRazonNoAceptaTamizajePersona() {
        return otraRazonNoAceptaTamizajePersona;
    }

    public void setOtraRazonNoAceptaTamizajePersona(String otraRazonNoAceptaTamizajePersona) {
        this.otraRazonNoAceptaTamizajePersona = otraRazonNoAceptaTamizajePersona;
    }

    @Column(name="OTRA_RAZON_NO_ACEPTA_PARTICIPAR", nullable = true)
    public String getOtraRazonNoAceptaParticipar() {
        return otraRazonNoAceptaParticipar;
    }

    public void setOtraRazonNoAceptaParticipar(String otraRazonNoAceptaParticipar) {
        this.otraRazonNoAceptaParticipar = otraRazonNoAceptaParticipar;
    }

    @Override
    public boolean isFieldAuditable(String fieldname) {
        return true;
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
