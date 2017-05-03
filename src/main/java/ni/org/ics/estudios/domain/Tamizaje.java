package ni.org.ics.estudios.domain;

import ni.org.ics.estudios.domain.audit.Auditable;
import ni.org.ics.estudios.domain.catalogs.RazonNoParticipa;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

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
    private Participante participante;
    private char aceptaTamizaje;
    private RazonNoParticipa razonNoParticipa;
    private char areaCovertura;
    private char ninoMenor12Anios;
    private char intencionPermanecerArea;
    private char tieneTarjetaVacunaOIdentificacion;
    private char enfermedadAgudaCronica;
    private char elegible;
    private char aceptaSeroprevalenciaZik;
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
    @JoinColumn(name="CODIGO_PARTICIPANTE", nullable = false)
    @ForeignKey(name = "FK_PARTICIPANTE_TAMIZAJE")
    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    @Column(name="ACEPTA_TAMIZAJE", nullable = false, length = 1)
    public char getAceptaTamizaje() {
        return aceptaTamizaje;
    }

    public void setAceptaTamizaje(char aceptaTamizaje) {
        this.aceptaTamizaje = aceptaTamizaje;
    }

    @ManyToOne(optional = true)
    @JoinColumn(name="RAZON_NO_PARTICIPA", nullable = true)
    @ForeignKey(name = "FK_RAZON_NO_PARTICIPA_TAMIZAJE")
    public RazonNoParticipa getRazonNoParticipa() {
        return razonNoParticipa;
    }

    public void setRazonNoParticipa(RazonNoParticipa razonNoParticipa) {
        this.razonNoParticipa = razonNoParticipa;
    }

    @Column(name="EN_AREA_COVERTURA", nullable = false, length = 1)
    public char getAreaCovertura() {
        return areaCovertura;
    }

    public void setAreaCovertura(char areaCovertura) {
        this.areaCovertura = areaCovertura;
    }

    @Column(name="VIVE_NINO_MENOS_12ANIOS", nullable = false, length = 1)
    public char getNinoMenor12Anios() {
        return ninoMenor12Anios;
    }

    public void setNinoMenor12Anios(char ninoMenor12Anios) {
        this.ninoMenor12Anios = ninoMenor12Anios;
    }

    @Column(name="INTENCION_PERMANECER_AREA", nullable = false, length = 1)
    public char getIntencionPermanecerArea() {
        return intencionPermanecerArea;
    }

    public void setIntencionPermanecerArea(char intencionPermanecerArea) {
        this.intencionPermanecerArea = intencionPermanecerArea;
    }

    @Column(name="TIENE_TARJETA_O_IDENTIFICACION", nullable = false, length = 1)
    public char getTieneTarjetaVacunaOIdentificacion() {
        return tieneTarjetaVacunaOIdentificacion;
    }

    public void setTieneTarjetaVacunaOIdentificacion(char tieneTarjetaVacunaOIdentificacion) {
        this.tieneTarjetaVacunaOIdentificacion = tieneTarjetaVacunaOIdentificacion;
    }

    @Column(name="TIENE_ENFERMEDAD_AGUDACRONICA", nullable = false, length = 1)
    public char getEnfermedadAgudaCronica() {
        return enfermedadAgudaCronica;
    }

    public void setEnfermedadAgudaCronica(char enfermedadAgudaCronica) {
        this.enfermedadAgudaCronica = enfermedadAgudaCronica;
    }

    @Column(name="ELEGIBLE", nullable = false, length = 1)
    public char getElegible() {
        return elegible;
    }

    public void setElegible(char elegible) {
        this.elegible = elegible;
    }

    @Column(name="ACEPTA_ESTUDIO_SEROPREVALENCIA_ZIK", nullable = false, length = 1)
    public char getAceptaSeroprevalenciaZik() {
        return aceptaSeroprevalenciaZik;
    }

    public void setAceptaSeroprevalenciaZik(char aceptaSeroprevalenciaZik) {
        this.aceptaSeroprevalenciaZik = aceptaSeroprevalenciaZik;
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
