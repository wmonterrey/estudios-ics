package ni.org.ics.estudios.domain.scancarta;

import ni.org.ics.estudios.domain.BaseMetaData;
import ni.org.ics.estudios.domain.audit.Auditable;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Miguel Salinas on 6/26/2017.
 * V1.0
 */
@Entity
@Table(name = "scan_cartas", catalog = "estudios_ics", uniqueConstraints = { @UniqueConstraint(columnNames = {"FECHA_CONS","CODIGO_PARTICIPANTE","CODIGO_VERSION"}) })
public class ScanCarta extends BaseMetaData implements Auditable {

    private Integer codigo;
    private Date fecha;
    private Integer participante;
    private VersionCarta versionCarta;
    private String asentimiento;
    private String asentChik;
    private String parteB;
    private String parteC;
    private String parteDMetabolomica;
    private String asentEscritoParteDMetabol;
    private Date fechaParteDMetabol;
    private String parteDZika;
    private String contactoFuturo;
    private String parteE;
    private Date fechaParteE;
    private String parteF;
    private String tipoParticipante;
    private String nombre1Firma;
    private String nombre2Firma;
    private String apellido1Firma;
    private String apellido2Firma;
    private String relacionFamiliar;
    private String observacion;
    private String proyecto;

    @Id
    @Column(name = "CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @Column(name = "FECHA_CONS", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "CODIGO_PARTICIPANTE", nullable = false)
    public Integer getParticipante() {
        return participante;
    }

    public void setParticipante(Integer participante) {
        this.participante = participante;
    }

    @ManyToOne
    @JoinColumn(name = "CODIGO_VERSION", nullable = false)
    @ForeignKey(name = "FK_SCANCARTA_VERSION")
    public VersionCarta getVersionCarta() {
        return versionCarta;
    }

    public void setVersionCarta(VersionCarta versionCarta) {
        this.versionCarta = versionCarta;
    }

    @Column(name = "ASENTIMIENTO", nullable = true, length = 5)
    public String getAsentimiento() {
        return asentimiento;
    }

    public void setAsentimiento(String asentimiento) {
        this.asentimiento = asentimiento;
    }

    @Column(name = "ASENT_CHIK", nullable = true, length = 5)
    public String getAsentChik() {
        return asentChik;
    }

    public void setAsentChik(String asentChik) {
        this.asentChik = asentChik;
    }

    @Column(name = "PARTE_B", nullable = true, length = 5)
    public String getParteB() {
        return parteB;
    }

    public void setParteB(String parteB) {
        this.parteB = parteB;
    }

    @Column(name = "PARTE_C", nullable = true, length = 5)
    public String getParteC() {
        return parteC;
    }

    public void setParteC(String parteC) {
        this.parteC = parteC;
    }

    @Column(name = "PARTE_D_METABOL", nullable = true, length = 5)
    public String getParteDMetabolomica() {
        return parteDMetabolomica;
    }

    public void setParteDMetabolomica(String parteDMetabolomica) {
        this.parteDMetabolomica = parteDMetabolomica;
    }

    @Column(name = "PARTE_D_ZIKA", nullable = true, length = 5)
    public String getParteDZika() {
        return parteDZika;
    }

    public void setParteDZika(String parteDZika) {
        this.parteDZika = parteDZika;
    }

    @Column(name = "ASENT_ESCRITOP_PARTE_D_METABOL", nullable = true, length = 5)
    public String getAsentEscritoParteDMetabol() {
        return asentEscritoParteDMetabol;
    }

    public void setAsentEscritoParteDMetabol(String asentEscritoParteDMetabol) {
        this.asentEscritoParteDMetabol = asentEscritoParteDMetabol;
    }

    @Column(name = "CONTACTO_FUTURO", nullable = true, length = 5)
    public String getContactoFuturo() {
        return contactoFuturo;
    }

    public void setContactoFuturo(String contactoFuturo) {
        this.contactoFuturo = contactoFuturo;
    }

    @Column(name = "FECHA_PARTE_D_METABOL", nullable = true)
    public Date getFechaParteDMetabol() {
        return fechaParteDMetabol;
    }

    public void setFechaParteDMetabol(Date fechaParteDMetabol) {
        this.fechaParteDMetabol = fechaParteDMetabol;
    }

    @Column(name = "PARTE_E", nullable = true, length = 5)
    public String getParteE() {
        return parteE;
    }

    public void setParteE(String parteE) {
        this.parteE = parteE;
    }

    @Column(name = "FECHA_PARTE_E", nullable = true)
    public Date getFechaParteE() {
        return fechaParteE;
    }

    public void setFechaParteE(Date fechaParteE) {
        this.fechaParteE = fechaParteE;
    }

    @Column(name = "PARTE_F", nullable = true, length = 5)
    public String getParteF() {
        return parteF;
    }

    public void setParteF(String parteF) {
        this.parteF = parteF;
    }

    @Column(name = "TIPO_PARTICIPANTE", nullable = true, length = 5)
    public String getTipoParticipante() {
        return tipoParticipante;
    }

    public void setTipoParticipante(String tipoParticipante) {
        this.tipoParticipante = tipoParticipante;
    }

    @Column(name = "NOMBRE1_FIRMA", nullable = true, length = 5)
    public String getNombre1Firma() {
        return nombre1Firma;
    }

    public void setNombre1Firma(String nombre1Firma) {
        this.nombre1Firma = nombre1Firma;
    }

    @Column(name = "NOMBRE2_FIRMA", nullable = true, length = 5)
    public String getNombre2Firma() {
        return nombre2Firma;
    }

    public void setNombre2Firma(String nombre2Firma) {
        this.nombre2Firma = nombre2Firma;
    }

    @Column(name = "APELLIDO1_FIRMA", nullable = true, length = 5)
    public String getApellido1Firma() {
        return apellido1Firma;
    }

    public void setApellido1Firma(String apellido1Firma) {
        this.apellido1Firma = apellido1Firma;
    }

    @Column(name = "APELLIDO2_FIRMA", nullable = true, length = 5)
    public String getApellido2Firma() {
        return apellido2Firma;
    }

    public void setApellido2Firma(String apellido2Firma) {
        this.apellido2Firma = apellido2Firma;
    }

    @Column(name = "RELACION_FAM", nullable = true, length = 5)
    public String getRelacionFamiliar() {
        return relacionFamiliar;
    }

    public void setRelacionFamiliar(String relacionFamiliar) {
        this.relacionFamiliar = relacionFamiliar;
    }

    @Column(name = "OBSERVACION", nullable = true)
    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Column(name = "PROYECTO", nullable = true, length = 50)
    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    @Override
    public boolean isFieldAuditable(String fieldname) {
        return true;
    }

    @Override
    public String toString() {
        return "ScanCarta{" +
                ",fecha=" + fecha +
                ",participante=" + participante +
                ",versionCarta=" + versionCarta +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScanCarta)) return false;

        ScanCarta scanCarta = (ScanCarta) o;

        if (!codigo.equals(scanCarta.codigo)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }
}
