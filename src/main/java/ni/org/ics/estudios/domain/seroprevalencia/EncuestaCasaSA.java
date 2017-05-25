package ni.org.ics.estudios.domain.seroprevalencia;

import ni.org.ics.estudios.domain.BaseMetaData;
import ni.org.ics.estudios.domain.audit.Auditable;
import ni.org.ics.estudios.domain.cohortefamilia.CasaCohorteFamilia;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;

/**
 * Created by Miguel Salinas on 5/25/2017.
 * V1.0
 */
@Entity
@Table(name = "sa_encuestas_casa", catalog = "estudios_ics")
public class EncuestaCasaSA extends BaseMetaData implements Auditable {

    private CasaCohorteFamilia casa;
    private String sedazoPuertasVentanas;
    private String compraProdEvitarZancudos;
    private String tienePatioJardin;
    private String utilizaAbate;
    private String fumiga;
    private String cadaCuantoFumiga;
    private String conoceLarvas;
    private String lugaresLarvas;
    private String otrosLugaresLarvas;


    @Id
    @OneToOne
    @JoinColumn(name = "CODIGO_CASACHF", nullable = false)
    @ForeignKey(name = "FK_CASACHF_ENCUESTACASASA")
    public CasaCohorteFamilia getCasa() {
        return casa;
    }

    public void setCasa(CasaCohorteFamilia casa) {
        this.casa = casa;
    }

    @Column(name = "SEDAZOS", length = 1)
    public String getSedazoPuertasVentanas() {
        return sedazoPuertasVentanas;
    }

    public void setSedazoPuertasVentanas(String sedazoPuertasVentanas) {
        this.sedazoPuertasVentanas = sedazoPuertasVentanas;
    }

    @Column(name = "COMPRA_PRODUCTOS", length = 1)
    public String getCompraProdEvitarZancudos() {
        return compraProdEvitarZancudos;
    }

    public void setCompraProdEvitarZancudos(String compraProdEvitarZancudos) {
        this.compraProdEvitarZancudos = compraProdEvitarZancudos;
    }

    @Column(name = "TIENE_PATIO", length = 1)
    public String getTienePatioJardin() {
        return tienePatioJardin;
    }

    public void setTienePatioJardin(String tienePatioJardin) {
        this.tienePatioJardin = tienePatioJardin;
    }

    @Column(name = "UTILIZA_ABATE", length = 1)
    public String getUtilizaAbate() {
        return utilizaAbate;
    }

    public void setUtilizaAbate(String utilizaAbate) {
        this.utilizaAbate = utilizaAbate;
    }

    @Column(name = "FUMIGA", length = 1)
    public String getFumiga() {
        return fumiga;
    }

    public void setFumiga(String fumiga) {
        this.fumiga = fumiga;
    }

    @Column(name = "CUANTO_FUMIGA", length = 5)
    public String getCadaCuantoFumiga() {
        return cadaCuantoFumiga;
    }

    public void setCadaCuantoFumiga(String cadaCuantoFumiga) {
        this.cadaCuantoFumiga = cadaCuantoFumiga;
    }

    @Column(name = "CONOCE_LARVAS", length = 1)
    public String getConoceLarvas() {
        return conoceLarvas;
    }

    public void setConoceLarvas(String conoceLarvas) {
        this.conoceLarvas = conoceLarvas;
    }

    @Column(name = "LUGARES_LARVAS", length = 50)
    public String getLugaresLarvas() {
        return lugaresLarvas;
    }

    public void setLugaresLarvas(String lugaresLarvas) {
        this.lugaresLarvas = lugaresLarvas;
    }

    @Column(name = "OTROS_LUGARES_LARVAS", length = 255)
    public String getOtrosLugaresLarvas() {
        return otrosLugaresLarvas;
    }

    public void setOtrosLugaresLarvas(String otrosLugaresLarvas) {
        this.otrosLugaresLarvas = otrosLugaresLarvas;
    }

    @Override
    public boolean isFieldAuditable(String fieldname) {
        return true;
    }

    @Override
    public String toString() {
        return "EncuestaCasa{" + casa.getCodigoCHF() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EncuestaCasaSA)) return false;

        EncuestaCasaSA that = (EncuestaCasaSA) o;

        if (!casa.equals(that.casa)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return casa.hashCode();
    }
}
