package ni.org.ics.estudios.domain.scancarta;

import ni.org.ics.estudios.domain.BaseMetaData;
import ni.org.ics.estudios.domain.audit.Auditable;
import ni.org.ics.estudios.domain.catalogs.Estudio;
import ni.org.ics.estudios.language.MessageResource;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Miguel Salinas on 6/26/2017.
 * V1.0
 */
@Entity
@Table(name = "version_scan_cartas", catalog = "estudios_ics", uniqueConstraints = { @UniqueConstraint(columnNames = {"CODIGO_VERSION","CODIGO_ESTUDIO"}) })
public class VersionCarta extends BaseMetaData implements Auditable {

    private Integer codigo;
    private MessageResource version;
    private Estudio estudio;
    private Date fechaInicio;
    private Date fechaFin;

    @Id
    @Column(name = "CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @ManyToOne
    @JoinColumn(name = "CODIGO_VERSION", nullable = false, referencedColumnName = "messageKey")
    @ForeignKey(name = "FK_VERSIONCARTA_VERSION")
    public MessageResource getVersion() {
        return version;
    }

    public void setVersion(MessageResource version) {
        this.version = version;
    }

    @ManyToOne
    @JoinColumn(name = "CODIGO_ESTUDIO", nullable = false)
    @ForeignKey(name = "FK_VERSIONCARTA_ESTUDIO")
    public Estudio getEstudio() {
        return estudio;
    }

    public void setEstudio(Estudio estudio) {
        this.estudio = estudio;
    }

    @Column(name = "FECHA_INICIO_VALIDEZ", nullable = false)
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Column(name = "FECHA_FIN_VALIDEZ", nullable = false)
    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public boolean isFieldAuditable(String fieldname) {
        return true;
    }

    @Override
    public String toString() {
        return "VersionCarta{" +
                "estudio=" + estudio.getNombre() +
                ",version=" + version.getSpanish() +
                '}';
}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VersionCarta)) return false;

        VersionCarta that = (VersionCarta) o;

        if (!codigo.equals(that.codigo)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }
}
