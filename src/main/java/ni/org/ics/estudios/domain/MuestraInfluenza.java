package ni.org.ics.estudios.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Miguel Salinas on 7/3/2017.
 * V1.0
 */
@Entity
@Table(name = "muestras_inf", catalog = "estudios_ics")
public class MuestraInfluenza {

    private Integer id;
    private Integer idMx;
    private Date fechaTomaMx;
    private boolean anulada;
    private boolean mxTomada;
    private String codLab;
    private Date fif;
    private Date hoy;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "ID_MX", nullable = false)
    public Integer getIdMx() {
        return idMx;
    }

    public void setIdMx(Integer idMx) {
        this.idMx = idMx;
    }

    @Column(name = "FECHA_TOMAMX", nullable = true)
    public Date getFechaTomaMx() {
        return fechaTomaMx;
    }

    public void setFechaTomaMx(Date fechaTomaMx) {
        this.fechaTomaMx = fechaTomaMx;
    }

    @Column(name = "ANULADA", nullable = false)
    public boolean isAnulada() {
        return anulada;
    }

    public void setAnulada(boolean anulada) {
        this.anulada = anulada;
    }

    @Column(name = "MX_TOMADA", nullable = false)
    public boolean isMxTomada() {
        return mxTomada;
    }

    public void setMxTomada(boolean mxTomada) {
        this.mxTomada = mxTomada;
    }

    @Column(name = "CODIGO_LAB", nullable = true, length = 25)
    public String getCodLab() {
        return codLab;
    }

    public void setCodLab(String codLab) {
        this.codLab = codLab;
    }

    @Column(name = "FIF", nullable = true)
    public Date getFif() {
        return fif;
    }

    public void setFif(Date fif) {
        this.fif = fif;
    }

    @Column(name = "HOY", nullable = true)
    public Date getHoy() {
        return hoy;
    }

    public void setHoy(Date hoy) {
        this.hoy = hoy;
    }
}
