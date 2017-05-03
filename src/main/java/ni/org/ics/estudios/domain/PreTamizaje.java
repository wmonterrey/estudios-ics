package ni.org.ics.estudios.domain;

import ni.org.ics.estudios.domain.audit.Auditable;
import ni.org.ics.estudios.domain.catalogs.RazonNoParticipa;

import javax.persistence.*;

import org.hibernate.annotations.ForeignKey;

/**
 * Created by FIRSTICT on 4/28/2017.
 * V1.0
 */
@Entity
@Table(name = "pre_tamizajes", catalog = "estudios_ics")
public class PreTamizaje extends BaseMetaData implements Auditable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
    private char aceptaTamizaje;
    private RazonNoParticipa razonNoParticipa;
    private Casa casa;

    @Id
    @Column(name = "CODIGO", nullable = false, insertable = true, updatable = false, length = 36)
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
    @ForeignKey(name = "FK_RAZON_NOPARTICIPA_PRETAMIZAJE")
    public RazonNoParticipa getRazonNoParticipa() {
        return razonNoParticipa;
    }

    public void setRazonNoParticipa(RazonNoParticipa razonNoParticipa) {
        this.razonNoParticipa = razonNoParticipa;
    }

    @ManyToOne
    @JoinColumn(name="CODIGO_CASA", nullable = false)
    @ForeignKey(name = "FK_CASA_PRETAMIZAJE")
    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
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
        if (!(o instanceof PreTamizaje)) return false;

        PreTamizaje preTamizaje = (PreTamizaje) o;

        return (!codigo.equals(preTamizaje.codigo));
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }
}
