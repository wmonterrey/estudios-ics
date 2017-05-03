package ni.org.ics.estudios.domain;

import ni.org.ics.estudios.domain.audit.Auditable;
import ni.org.ics.estudios.domain.catalogs.Estudio;
import ni.org.ics.estudios.domain.catalogs.RelacionFamiliar;

import javax.persistence.*;

import org.hibernate.annotations.ForeignKey;

import java.util.Date;

/**
 * Created by FIRSTICT on 4/28/2017.
 * V1.0
 */
@Entity
@Table(name = "cartas_consentimientos", catalog = "estudios_ics")
public class CartaConsentimiento extends BaseMetaData implements Auditable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
    private Date fechaFirma;
    private Tamizaje tamizaje;
    private Estudio estudio;
    private char participadoCohortePediatrica;
    private String cohortePediatrica; //Dengue, Influenza, Ambas (dengue/influenza)
    private char codigoReactivado;
    private char emancipado;
    private char asentimientoVerbal; //Para Niños de 6 a 17 años
    private String nombre1Tutor;
    private String nombre2Tutor;
    private String apellido1Tutor;
    private String apellido2Tutor;
    private RelacionFamiliar relacionFamiliarTutor;
    private char participanteOTutorAlfabeto;
    private char testigoPresente;
    private String nombre1Testigo;
    private String nombre2Testigo;
    private String apellido1Testigo;
    private String apellido2Testigo;
    private char aceptaParteA;
    private String motivoRechazoParteA;
    private char aceptaContactoFuturo;
    private char aceptaParteB; //Consentimiento para almacenamiento y uso de muestras en estudios futuros
    private char aceptaParteC; //Consentimiento adicional para estudios genéticos

    @Id
    @Column(name = "CODIGO", nullable = false, insertable = true, updatable = false, length = 36)
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Temporal( TemporalType.TIMESTAMP)
    @Column(name="FECHA_FIRMA")
    public Date getFechaFirma() {
        return fechaFirma;
    }

    public void setFechaFirma(Date fechaFirma) {
        this.fechaFirma = fechaFirma;
    }

    @Column(name = "PARTICIPADO_CH_PEDIATRICA", length = 1)
    public char getParticipadoCohortePediatrica() {
        return participadoCohortePediatrica;
    }

    public void setParticipadoCohortePediatrica(char participadoCohortePediatrica) {
        this.participadoCohortePediatrica = participadoCohortePediatrica;
    }

    @Column(name = "COHORTE_PEDIATRICA")
    public String getCohortePediatrica() {
        return cohortePediatrica;
    }

    public void setCohortePediatrica(String cohortePediatrica) {
        this.cohortePediatrica = cohortePediatrica;
    }

    @Column(name = "CODIGO_REACTIVADO", length = 1)
    public char getCodigoReactivado() {
        return codigoReactivado;
    }

    public void setCodigoReactivado(char codigoReactivado) {
        this.codigoReactivado = codigoReactivado;
    }

    @Column(name = "EMANCIPADO", length = 1)
    public char getEmancipado() {
        return emancipado;
    }

    public void setEmancipado(char emancipado) {
        this.emancipado = emancipado;
    }

    @Column(name = "ASENTIMIENTO_VERBAL", length = 1)
    public char getAsentimientoVerbal() {
        return asentimientoVerbal;
    }

    public void setAsentimientoVerbal(char asentimientoVerbal) {
        this.asentimientoVerbal = asentimientoVerbal;
    }

    @Column(name = "NOMBRE1_TUTOR", length = 100)
    public String getNombre1Tutor() {
        return nombre1Tutor;
    }

    public void setNombre1Tutor(String nombre1Tutor) {
        this.nombre1Tutor = nombre1Tutor;
    }

    @Column(name = "NOMBRE2_TUTOR", length = 100)
    public String getNombre2Tutor() {
        return nombre2Tutor;
    }

    public void setNombre2Tutor(String nombre2Tutor) {
        this.nombre2Tutor = nombre2Tutor;
    }

    @Column(name = "APELLIDO1_TUTOR", length = 100)
    public String getApellido1Tutor() {
        return apellido1Tutor;
    }

    public void setApellido1Tutor(String apellido1Tutor) {
        this.apellido1Tutor = apellido1Tutor;
    }

    @Column(name = "APELLIDO2_TUTOR", length = 100)
    public String getApellido2Tutor() {
        return apellido2Tutor;
    }

    public void setApellido2Tutor(String apellido2Tutor) {
        this.apellido2Tutor = apellido2Tutor;
    }

    @Column(name = "PARTICIPANTE_TUTOR_ALFABETO", length = 1)
    public char getParticipanteOTutorAlfabeto() {
        return participanteOTutorAlfabeto;
    }

    public void setParticipanteOTutorAlfabeto(char participanteOTutorAlfabeto) {
        this.participanteOTutorAlfabeto = participanteOTutorAlfabeto;
    }

    @Column(name = "TESTIGO_PRESENTE", length = 1)
    public char getTestigoPresente() {
        return testigoPresente;
    }

    public void setTestigoPresente(char testigoPresente) {
        this.testigoPresente = testigoPresente;
    }

    @Column(name = "NOMBRE1_TESTIGO", length = 100)
    public String getNombre1Testigo() {
        return nombre1Testigo;
    }

    public void setNombre1Testigo(String nombre1Testigo) {
        this.nombre1Testigo = nombre1Testigo;
    }

    @Column(name = "NOMBRE2_TESTIGO", length = 100)
    public String getNombre2Testigo() {
        return nombre2Testigo;
    }

    public void setNombre2Testigo(String nombre2Testigo) {
        this.nombre2Testigo = nombre2Testigo;
    }

    @Column(name = "APELLIDO1_TESTIGO", length = 100)
    public String getApellido1Testigo() {
        return apellido1Testigo;
    }

    public void setApellido1Testigo(String apellido1Testigo) {
        this.apellido1Testigo = apellido1Testigo;
    }

    @Column(name = "APELLIDO2_TESTIGO", length = 100)
    public String getApellido2Testigo() {
        return apellido2Testigo;
    }

    public void setApellido2Testigo(String apellido2Testigo) {
        this.apellido2Testigo = apellido2Testigo;
    }

    @Column(name = "ACEPTA_PARTE_A", length = 1)
    public char getAceptaParteA() {
        return aceptaParteA;
    }

    public void setAceptaParteA(char aceptaParteA) {
        this.aceptaParteA = aceptaParteA;
    }

    @Column(name = "MOTIVO_RECHAZO_PARTE_A")
    public String getMotivoRechazoParteA() {
        return motivoRechazoParteA;
    }

    public void setMotivoRechazoParteA(String motivoRechazoParteA) {
        this.motivoRechazoParteA = motivoRechazoParteA;
    }

    @Column(name = "ACEPTA_CONTACTO_FUTURO", length = 1)
    public char getAceptaContactoFuturo() {
        return aceptaContactoFuturo;
    }

    public void setAceptaContactoFuturo(char aceptaContactoFuturo) {
        this.aceptaContactoFuturo = aceptaContactoFuturo;
    }

    @Column(name = "ACEPTA_PARTE_B", length = 1)
    public char getAceptaParteB() {
        return aceptaParteB;
    }

    public void setAceptaParteB(char aceptaParteB) {
        this.aceptaParteB = aceptaParteB;
    }

    @Column(name = "ACEPTA_PARTE_C", length = 1)
    public char getAceptaParteC() {
        return aceptaParteC;
    }

    public void setAceptaParteC(char aceptaParteC) {
        this.aceptaParteC = aceptaParteC;
    }

    @ManyToOne
    @JoinColumn(name = "CODIGO_TAMIZAJE", nullable = false)
    @ForeignKey(name = "FK_TAMIZAJE_CARTACON")
    public Tamizaje getTamizaje() {
        return tamizaje;
    }

    public void setTamizaje(Tamizaje tamizaje) {
        this.tamizaje = tamizaje;
    }

    @ManyToOne
    @JoinColumn(name = "CODIGO_ESTUDIO", nullable = false)
    @ForeignKey(name = "FK_ESTUDIO_CARTACON")
    public Estudio getEstudio() {
        return estudio;
    }

    public void setEstudio(Estudio estudio) {
        this.estudio = estudio;
    }


    @ManyToOne(optional = true)
    @JoinColumn(name = "CODIGO_RELACFAM", nullable = true)
    @ForeignKey(name = "FK_RELACION_FAM_TUTOR_CARTACON")
    public RelacionFamiliar getRelacionFamiliarTutor() {
        return relacionFamiliarTutor;
    }

    public void setRelacionFamiliarTutor(RelacionFamiliar relacionFamiliar) {
        this.relacionFamiliarTutor = relacionFamiliar;
    }

    @Override
    public boolean isFieldAuditable(String fieldname) {
        return false;
    }

    @Override
    public String toString() {
        return this.codigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartaConsentimiento)) return false;

        CartaConsentimiento that = (CartaConsentimiento) o;

        return  (!codigo.equals(that.codigo));
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }
}
