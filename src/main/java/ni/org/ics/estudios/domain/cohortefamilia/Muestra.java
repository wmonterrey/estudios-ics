package ni.org.ics.estudios.domain.cohortefamilia;

import ni.org.ics.estudios.domain.BaseMetaData;
import ni.org.ics.estudios.domain.audit.Auditable;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Miguel Salinas on 5/17/2017.
 * V1.0
 */
@Entity
@Table(name = "muestras", catalog = "estudios_ics")
public class Muestra extends BaseMetaData implements Auditable, Serializable {

    private static final long serialVersionUID = 1L;

    private String codigo;
    private String codigoMx;
    private String hora;
    private Double volumen;
    private String observacion;
    private String descOtraObservacion;
    private String numPinchazos;
    private String razonNoToma;
    private String descOtraRazonNoToma;
    private String tubo;
    private String tipoMuestra;
    private String proposito;
    private ParticipanteCohorteFamilia participanteCHF;
    private String realizaPaxgene;

    @Id
    @Column(name = "CODIGO", length = 50, nullable = false)
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Column(name = "CODIGO_MX", length = 50, nullable = false)
    public String getCodigoMx() {
        return codigoMx;
    }

    public void setCodigoMx(String codigoMx) {
        this.codigoMx = codigoMx;
    }

    @Column(name = "HORA", length = 20, nullable = false)
    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Column(name = "VOLUMEN", nullable = false)
    public Double getVolumen() {
        return volumen;
    }

    public void setVolumen(Double volumen) {
        this.volumen = volumen;
    }

    @Column(name = "OBSERVACION", length = 50, nullable = true)
    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Column(name = "OTRA_OBSERVACION", nullable = true)
    public String getDescOtraObservacion() {
        return descOtraObservacion;
    }

    public void setDescOtraObservacion(String descOtraObservacion) {
        this.descOtraObservacion = descOtraObservacion;
    }

    @Column(name = "NUM_PINCHAZOS", length = 50, nullable = true)
    public String getNumPinchazos() {
        return numPinchazos;
    }

    public void setNumPinchazos(String numPinchazos) {
        this.numPinchazos = numPinchazos;
    }

    @Column(name = "RAZON_NOTOMA", length = 50, nullable = true)
    public String getRazonNoToma() {
        return razonNoToma;
    }

    public void setRazonNoToma(String razonNoToma) {
        this.razonNoToma = razonNoToma;
    }

    @Column(name = "OTRA_RAZON_NOTOMA", nullable = true)
    public String getDescOtraRazonNoToma() {
        return descOtraRazonNoToma;
    }

    public void setDescOtraRazonNoToma(String descOtraRazonNoToma) {
        this.descOtraRazonNoToma = descOtraRazonNoToma;
    }

    @Column(name = "TIPO_TUBO", length = 50, nullable = true)
    public String getTubo() {
        return tubo;
    }

    public void setTubo(String tubo) {
        this.tubo = tubo;
    }

    @Column(name = "TIPO_MUESTRA", length = 50, nullable = true)
    public String getTipoMuestra() {
        return tipoMuestra;
    }

    public void setTipoMuestra(String tipoMuestra) {
        this.tipoMuestra = tipoMuestra;
    }

    @Column(name = "PROPOSITO", length = 50, nullable = true)
    public String getProposito() {
        return proposito;
    }

    public void setProposito(String proposito) {
        this.proposito = proposito;
    }

    @Column(name = "PAXGENE", length = 50, nullable = true)
    public String getRealizaPaxgene() {
        return realizaPaxgene;
    }

    public void setRealizaPaxgene(String realizaPaxgene) {
        this.realizaPaxgene = realizaPaxgene;
    }

    @ManyToOne
    @JoinColumn(name = "CODIDO_PARTICIPANTECHF")
    @ForeignKey(name = "FK_PARTICIPANTECHF_MUESTRA")
    public ParticipanteCohorteFamilia getParticipanteCHF() {
        return participanteCHF;
    }

    public void setParticipanteCHF(ParticipanteCohorteFamilia participanteCHF) {
        this.participanteCHF = participanteCHF;
    }

    @Override
    public boolean isFieldAuditable(String fieldname) {
        return true;
    }

    @Override
    public String toString() {
        return "Muestra{" + codigo +
                ", '" + codigoMx + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Muestra)) return false;

        Muestra muestra = (Muestra) o;

        return  (!codigo.equals(muestra.codigo));
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }
}
