package ni.org.ics.estudios.domain.seroprevalencia;

import ni.org.ics.estudios.domain.BaseMetaData;
import ni.org.ics.estudios.domain.audit.Auditable;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Miguel Salinas on 5/25/2017.
 * V1.0
 */
@Entity
@Table(name = "sa_encuestas_participante", catalog = "estudios_ics")
public class EncuestaParticipanteSA extends BaseMetaData implements Auditable {

    private ParticipanteSeroprevalencia participanteSA;
    private String escuchadoZikaSn;
    private String queEsSika;
    private String otroQueEsSika;
    private String transmiteZika;
    private String otroTransmiteZika;
    private String sintomas;
    private String tenidoZikaSn;
    private String conoceFechaZika;
    private Date fechaZika;
    private String sintomasZika;
    private String zikaConfirmadoMedico;
    private Integer cantMiembrosZika;
    private Date fechaDxZika;
    private String relacionFamZika;
    private String otraRelacionFamZika;
    private String tenidoDengueSn;
    private String conoceFechaDengue;
    private Date fechaDengue;
    private String dengueConfirmadoMedico;
    private Integer cantMiembrosDengue;
    private Date fechaDxDengue;
    private String relacionFamDengue;
    private String otraRelacionFamDengue;
    private String tenidoChikSn;
    private String conoceFechaChik;
    private Date fechaChik;
    private String chikConfirmadoMedico;
    private Integer cantMiembrosChik;
    private Date fechaDxChik;
    private String relacionFamChik;
    private String otraRelacionFamChik;
    private String vacunaFiebreAmarillaSn;
    private String conoceFechaVacFiebreAmar;
    private Date fechaVacunaFiebreAmar;
    private String transfusionSangreSn;
    private String conoceFechaTransfusion;
    private Date fechaTransfusionSangre;
    private String usaRepelentes;
    private String tieneHijos;
    private String usaPlanificacionFam;
    private String usaCondon;
    private String usaOtroMetodo;

    @Id
    @ManyToOne
    @JoinColumn(name = "CODIDO_PARTICIPANTECHF")
    @ForeignKey(name = "FK_PARTICIPANTESA_ENCUESTAPARTICIPANTE")
    public ParticipanteSeroprevalencia getParticipanteSA() {
        return participanteSA;
    }

    public void setParticipanteSA(ParticipanteSeroprevalencia participanteSA) {
        this.participanteSA = participanteSA;
    }

    @Column(name = "ESCUCHADO_ZIKA", length = 1)
    public String getEscuchadoZikaSn() {
        return escuchadoZikaSn;
    }

    public void setEscuchadoZikaSn(String escuchadoZikaSn) {
        this.escuchadoZikaSn = escuchadoZikaSn;
    }

    @Column(name = "SABE_ZIKA", length = 5)
    public String getQueEsSika() {
        return queEsSika;
    }

    public void setQueEsSika(String queEsSika) {
        this.queEsSika = queEsSika;
    }

    @Column(name = "COMO_TRANSMITE_ZIKA", length = 5)
    public String getTransmiteZika() {
        return transmiteZika;
    }

    public void setTransmiteZika(String transmiteZika) {
        this.transmiteZika = transmiteZika;
    }

    @Column(name = "SINTOMAS", length = 50)
    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    @Column(name = "TENIDO_ZIKA", length = 1)
    public String getTenidoZikaSn() {
        return tenidoZikaSn;
    }

    public void setTenidoZikaSn(String tenidoZikaSn) {
        this.tenidoZikaSn = tenidoZikaSn;
    }

    @Column(name = "CONOCE_FECHA_ZIKA", length = 1)
    public String getConoceFechaZika() {
        return conoceFechaZika;
    }

    public void setConoceFechaZika(String conoceFechaZika) {
        this.conoceFechaZika = conoceFechaZika;
    }

    @Column(name = "FECHA_ZIKA")
    public Date getFechaZika() {
        return fechaZika;
    }

    public void setFechaZika(Date fechaZika) {
        this.fechaZika = fechaZika;
    }

    @Column(name = "SINTOMAS_ZIKA", length = 50)
    public String getSintomasZika() {
        return sintomasZika;
    }

    public void setSintomasZika(String sintomasZika) {
        this.sintomasZika = sintomasZika;
    }

    @Column(name = "ZIKA_CONFIRMADO", length = 1)
    public String getZikaConfirmadoMedico() {
        return zikaConfirmadoMedico;
    }

    public void setZikaConfirmadoMedico(String zikaConfirmadoMedico) {
        this.zikaConfirmadoMedico = zikaConfirmadoMedico;
    }

    @Column(name = "CANT_MIEMBROS_ZIKA")
    public Integer getCantMiembrosZika() {
        return cantMiembrosZika;
    }

    public void setCantMiembrosZika(Integer cantMiembrosZika) {
        this.cantMiembrosZika = cantMiembrosZika;
    }

    @Column(name = "FECHA_DIAG_ZIKA")
    public Date getFechaDxZika() {
        return fechaDxZika;
    }

    public void setFechaDxZika(Date fechaDxZika) {
        this.fechaDxZika = fechaDxZika;
    }

    @Column(name = "RELACION_FAM_ZIKA", length = 50)
    public String getRelacionFamZika() {
        return relacionFamZika;
    }

    public void setRelacionFamZika(String relacionFamZika) {
        this.relacionFamZika = relacionFamZika;
    }

    @Column(name = "TENIDO_DENGUE", length = 1)
    public String getTenidoDengueSn() {
        return tenidoDengueSn;
    }

    public void setTenidoDengueSn(String tenidoDengueSn) {
        this.tenidoDengueSn = tenidoDengueSn;
    }

    @Column(name = "CONOCE_FECHA_DENGUE", length = 1)
    public String getConoceFechaDengue() {
        return conoceFechaDengue;
    }

    public void setConoceFechaDengue(String conoceFechaDengue) {
        this.conoceFechaDengue = conoceFechaDengue;
    }

    @Column(name = "FECHA_DENGUE")
    public Date getFechaDengue() {
        return fechaDengue;
    }

    public void setFechaDengue(Date fechaDengue) {
        this.fechaDengue = fechaDengue;
    }

    @Column(name = "DENGUE_CONFIRMADO", length = 1)
    public String getDengueConfirmadoMedico() {
        return dengueConfirmadoMedico;
    }

    public void setDengueConfirmadoMedico(String dengueConfirmadoMedico) {
        this.dengueConfirmadoMedico = dengueConfirmadoMedico;
    }

    @Column(name = "CANT_MIEMBROS_DENGUE")
    public Integer getCantMiembrosDengue() {
        return cantMiembrosDengue;
    }

    public void setCantMiembrosDengue(Integer cantMiembrosDengue) {
        this.cantMiembrosDengue = cantMiembrosDengue;
    }

    @Column(name = "FECHA_DIAG_DENGUE")
    public Date getFechaDxDengue() {
        return fechaDxDengue;
    }

    public void setFechaDxDengue(Date fechaDxDengue) {
        this.fechaDxDengue = fechaDxDengue;
    }

    @Column(name = "RELACION_FAM_DENGUE", length = 50)
    public String getRelacionFamDengue() {
        return relacionFamDengue;
    }

    public void setRelacionFamDengue(String relacionFamDengue) {
        this.relacionFamDengue = relacionFamDengue;
    }

    @Column(name = "TENIDO_CHIK", length = 1)
    public String getTenidoChikSn() {
        return tenidoChikSn;
    }

    public void setTenidoChikSn(String tenidoChikSn) {
        this.tenidoChikSn = tenidoChikSn;
    }

    @Column(name = "CONOCE_FECHA_CHIK", length = 1)
    public String getConoceFechaChik() {
        return conoceFechaChik;
    }

    public void setConoceFechaChik(String conoceFechaChik) {
        this.conoceFechaChik = conoceFechaChik;
    }

    @Column(name = "FECHA_CHIK")
    public Date getFechaChik() {
        return fechaChik;
    }

    public void setFechaChik(Date fechaChik) {
        this.fechaChik = fechaChik;
    }

    @Column(name = "CHIK_CONFIRMADO", length = 1)
    public String getChikConfirmadoMedico() {
        return chikConfirmadoMedico;
    }

    public void setChikConfirmadoMedico(String chikConfirmadoMedico) {
        this.chikConfirmadoMedico = chikConfirmadoMedico;
    }

    @Column(name = "CANT_MIEMBROS_CHIK")
    public Integer getCantMiembrosChik() {
        return cantMiembrosChik;
    }

    public void setCantMiembrosChik(Integer cantMiembrosChik) {
        this.cantMiembrosChik = cantMiembrosChik;
    }

    @Column(name = "FECHA_DIAG_CHIK")
    public Date getFechaDxChik() {
        return fechaDxChik;
    }

    public void setFechaDxChik(Date fechaDxChik) {
        this.fechaDxChik = fechaDxChik;
    }

    @Column(name = "RELACION_FAM_CHIK", length = 50)
    public String getRelacionFamChik() {
        return relacionFamChik;
    }

    public void setRelacionFamChik(String relacionFamChik) {
        this.relacionFamChik = relacionFamChik;
    }

    @Column(name = "VACUNA_FIEBREA", length = 1)
    public String getVacunaFiebreAmarillaSn() {
        return vacunaFiebreAmarillaSn;
    }

    public void setVacunaFiebreAmarillaSn(String vacunaFiebreAmarillaSn) {
        this.vacunaFiebreAmarillaSn = vacunaFiebreAmarillaSn;
    }

    @Column(name = "CONOCE_FECHA_VACUNA_FIEBREA", length = 1)
    public String getConoceFechaVacFiebreAmar() {
        return conoceFechaVacFiebreAmar;
    }

    public void setConoceFechaVacFiebreAmar(String conoceFechaVacFiebreAmar) {
        this.conoceFechaVacFiebreAmar = conoceFechaVacFiebreAmar;
    }

    @Column(name = "FECHA_VACUNA_FIEBREA")
    public Date getFechaVacunaFiebreAmar() {
        return fechaVacunaFiebreAmar;
    }

    public void setFechaVacunaFiebreAmar(Date fechaVacunaFiebreAmar) {
        this.fechaVacunaFiebreAmar = fechaVacunaFiebreAmar;
    }

    @Column(name = "TRANSFUSION_SANGRE", length = 1)
    public String getTransfusionSangreSn() {
        return transfusionSangreSn;
    }

    public void setTransfusionSangreSn(String transfusionSangreSn) {
        this.transfusionSangreSn = transfusionSangreSn;
    }

    @Column(name = "CONOCE_FECHA_TRANSFUSION", length = 1)
    public String getConoceFechaTransfusion() {
        return conoceFechaTransfusion;
    }

    public void setConoceFechaTransfusion(String conoceFechaTransfusion) {
        this.conoceFechaTransfusion = conoceFechaTransfusion;
    }

    @Column(name = "FECHA_TRANSFUSION_SANGRE")
    public Date getFechaTransfusionSangre() {
        return fechaTransfusionSangre;
    }

    public void setFechaTransfusionSangre(Date fechaTransfusionSangre) {
        this.fechaTransfusionSangre = fechaTransfusionSangre;
    }

    @Column(name = "USA_REPELENTES", length = 1)
    public String getUsaRepelentes() {
        return usaRepelentes;
    }

    public void setUsaRepelentes(String usaRepelentes) {
        this.usaRepelentes = usaRepelentes;
    }

    @Column(name = "TIENE_HIJOS", length = 1)
    public String getTieneHijos() {
        return tieneHijos;
    }

    public void setTieneHijos(String tieneHijos) {
        this.tieneHijos = tieneHijos;
    }

    @Column(name = "PLANIFICACION_FAM", length = 1)
    public String getUsaPlanificacionFam() {
        return usaPlanificacionFam;
    }

    public void setUsaPlanificacionFam(String usaPlanificacionFam) {
        this.usaPlanificacionFam = usaPlanificacionFam;
    }

    @Column(name = "CONDON", length = 1)
    public String getUsaCondon() {
        return usaCondon;
    }

    public void setUsaCondon(String usaCondon) {
        this.usaCondon = usaCondon;
    }

    @Column(name = "OTRO_METODO", length = 1)
    public String getUsaOtroMetodo() {
        return usaOtroMetodo;
    }

    public void setUsaOtroMetodo(String usaOtroMetodo) {
        this.usaOtroMetodo = usaOtroMetodo;
    }

    @Column(name = "OTRO_SABE_ZIKA", length = 255)
    public String getOtroQueEsSika() {
        return otroQueEsSika;
    }

    public void setOtroQueEsSika(String otroQueEsSika) {
        this.otroQueEsSika = otroQueEsSika;
    }

    @Column(name = "OTRO_TRANSMITE_ZIKA", length = 255)
    public String getOtroTransmiteZika() {
        return otroTransmiteZika;
    }

    public void setOtroTransmiteZika(String otroTransmiteZika) {
        this.otroTransmiteZika = otroTransmiteZika;
    }

    @Column(name = "OTRA_RELACION_FAM_ZIKA", length = 255)
    public String getOtraRelacionFamZika() {
        return otraRelacionFamZika;
    }

    public void setOtraRelacionFamZika(String otraRelacionFamZika) {
        this.otraRelacionFamZika = otraRelacionFamZika;
    }

    @Column(name = "OTRA_RELACION_FAM_DENGUE", length = 255)
    public String getOtraRelacionFamDengue() {
        return otraRelacionFamDengue;
    }

    public void setOtraRelacionFamDengue(String otraRelacionFamDengue) {
        this.otraRelacionFamDengue = otraRelacionFamDengue;
    }

    @Column(name = "OTRA_RELACION_FAM_CHIK", length = 255)
    public String getOtraRelacionFamChik() {
        return otraRelacionFamChik;
    }

    public void setOtraRelacionFamChik(String otraRelacionFamChik) {
        this.otraRelacionFamChik = otraRelacionFamChik;
    }

    @Override
    public boolean isFieldAuditable(String fieldname) {
        return true;
    }

    @Override
    public String toString() {
        return "EncuestaParticipante{" + participanteSA +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EncuestaParticipanteSA)) return false;

        EncuestaParticipanteSA that = (EncuestaParticipanteSA) o;

        if (!participanteSA.equals(that.participanteSA)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return participanteSA.hashCode();
    }
}
