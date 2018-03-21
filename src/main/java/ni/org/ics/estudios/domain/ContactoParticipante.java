package ni.org.ics.estudios.domain;

import ni.org.ics.estudios.domain.audit.Auditable;
import ni.org.ics.estudios.domain.catalogs.Barrio;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;

/**
 * Objeto que representa una persona de contacto asociada a un participante
 * Created by Miguel Salinas on 4/28/2017.
 * V1.0
 */
@Entity
@Table(name = "contacto_participante", catalog = "estudios_ics")
public class ContactoParticipante extends BaseMetaData implements Auditable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
    private Participante participante;
    private String nombre;
    private String Direccion;
    private Barrio barrio;
    private String numero1;
    private String operadora1;
    private String tipo1;
    private String numero2;
    private String operadora2;
    private String tipo2;

    @Id
    @Column(name = "ID", nullable = false, length = 50)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @ManyToOne(optional = true)
    @JoinColumn(name="CODIGO_PARTICIPANTE", nullable = true)
    @ForeignKey(name = "FK_PARTICIPANTE_CONTACTO")
    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    @Column(name = "NOMBRE", nullable = false, length = 150)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "DIRECCION", nullable = false, length = 250)
    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    @ManyToOne(optional = true)
    @JoinColumn(name="CODIGO_BARRIO", nullable = true)
    @ForeignKey(name = "FK_BARRIO_CONTACTO")
    public Barrio getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }

    @Column(name = "NUMERO1", nullable = true, length = 32)
    public String getNumero1() {
        return numero1;
    }

    public void setNumero1(String numero1) {
        this.numero1 = numero1;
    }

    @Column(name = "OPERADORA_NUM1", nullable = true, length = 2)
    public String getOperadora1() {
        return operadora1;
    }

    public void setOperadora1(String operadora1) {
        this.operadora1 = operadora1;
    }

    @Column(name = "TIPOTEL_NUM1", nullable = true, length = 2)
    public String getTipo1() {
        return tipo1;
    }

    public void setTipo1(String tipo1) {
        this.tipo1 = tipo1;
    }

    @Column(name = "NUMERO2", nullable = true, length = 32)
    public String getNumero2() {
        return numero2;
    }

    public void setNumero2(String numero2) {
        this.numero2 = numero2;
    }

    @Column(name = "OPERADORA_NUM2", nullable = true, length = 2)
    public String getOperadora2() {
        return operadora2;
    }

    public void setOperadora2(String operadora2) {
        this.operadora2 = operadora2;
    }

    @Column(name = "TIPOTEL_NUM2", nullable = true, length = 2)
    public String getTipo2() {
        return tipo2;
    }

    public void setTipo2(String tipo2) {
        this.tipo2 = tipo2;
    }

    @Override
    public boolean isFieldAuditable(String fieldname) {
        return true;
    }

    @Override
    public String toString() {
        return id.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactoParticipante)) return false;

        ContactoParticipante contactoParticipante = (ContactoParticipante) o;

        return  (!id.equals(contactoParticipante.id));
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
