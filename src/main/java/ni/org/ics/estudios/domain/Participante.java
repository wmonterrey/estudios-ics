package ni.org.ics.estudios.domain;

import ni.org.ics.estudios.domain.audit.Auditable;

import javax.persistence.*;

import org.hibernate.annotations.ForeignKey;

import java.util.Date;

/**
 * Simple objeto de dominio que representa un participante de los estudios
 * 
 * @author William Aviles
 **/

@Entity
@Table(name = "participantes", catalog = "estudios_ics", uniqueConstraints = { @UniqueConstraint(columnNames = "codigo") })
public class Participante extends BaseMetaData implements Auditable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private Integer codigo;
	private String nombre1;
	private String nombre2;
	private String apellido1;
	private String apellido2;
	private String sexo;
	private Date fechaNac;
    private String nombre1Padre;
    private String nombre2Padre;
    private String apellido1Padre;
    private String apellido2Padre;
    private String nombre1Madre;
    private String nombre2Madre;
    private String apellido1Madre;
    private String apellido2Madre;
    private Casa casa;

	@Id
	@Column(name = "CODIGO", nullable = false, length = 6)
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	@Column(name = "NOMBRE1", nullable = false)
	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	@Column(name = "NOMBRE2", nullable = true)
	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	@Column(name = "APELLIDO1", nullable = false)
	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	@Column(name = "APELLIDO2", nullable = true)
	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	@Column(name = "SEXO", nullable = false)
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Column(name = "FECHANAC", nullable = false)
	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

    @Column(name = "NOMBRE1_PADRE", length = 100)
    public String getNombre1Padre() {
        return nombre1Padre;
    }

    public void setNombre1Padre(String nombre1Padre) {
        this.nombre1Padre = nombre1Padre;
    }

    @Column(name = "NOMBRE2_PADRE", length = 100)
    public String getNombre2Padre() {
        return nombre2Padre;
    }

    public void setNombre2Padre(String nombre2Padre) {
        this.nombre2Padre = nombre2Padre;
    }

    @Column(name = "APELLIDO1_PADRE", length = 100)
    public String getApellido1Padre() {
        return apellido1Padre;
    }

    public void setApellido1Padre(String apellido1Padre) {
        this.apellido1Padre = apellido1Padre;
    }

    @Column(name = "APELLIDO2_PADRE", length = 100)
    public String getApellido2Padre() {
        return apellido2Padre;
    }

    public void setApellido2Padre(String apellido2Padre) {
        this.apellido2Padre = apellido2Padre;
    }

    @Column(name = "NOMBRE1_MADRE", length = 100)
    public String getNombre1Madre() {
        return nombre1Madre;
    }

    public void setNombre1Madre(String nombre1Madre) {
        this.nombre1Madre = nombre1Madre;
    }

    @Column(name = "NOMBRE2_MADRE", length = 100)
    public String getNombre2Madre() {
        return nombre2Madre;
    }

    public void setNombre2Madre(String nombre2Madre) {
        this.nombre2Madre = nombre2Madre;
    }

    @Column(name = "APELLIDO1_MADRE", length = 100)
    public String getApellido1Madre() {
        return apellido1Madre;
    }

    public void setApellido1Madre(String apellido1Madre) {
        this.apellido1Madre = apellido1Madre;
    }

    @Column(name = "APELLIDO2_MADRE", length = 100)
    public String getApellido2Madre() {
        return apellido2Madre;
    }

    public void setApellido2Madre(String apellido2Madre) {
        this.apellido2Madre = apellido2Madre;
    }

    @ManyToOne
    @JoinColumn(name = "CODIGO_CASA", nullable = false)
    @ForeignKey(name = "FK_CASA_PARTICIPANTE")
    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    @Transient
    public String getEdad(){
        return "";
    }

    @Transient
    public String getNombreCompleto(){
        return "";
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
        if (!(o instanceof Participante)) return false;

        Participante participante = (Participante) o;

        return (!codigo.equals(participante.codigo));
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }
}
