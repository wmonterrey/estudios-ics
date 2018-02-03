package ni.org.ics.estudios.domain.muestreoanual;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Simple objeto de dominio que representa un participante de los estudios
 * 
 * @author William Aviles
 **/

@Entity
@Table(name = "participantes_procesos", catalog = "estudios_ics", uniqueConstraints = { @UniqueConstraint(columnNames = "codigo") })
public class ParticipanteProcesos {

	/**
	 * 
	 */
	private Integer codigo;
	private String conPto;
	private Integer estPart;
	private String estudio;
	private String pbmc;
	private String consDeng;
	private String reConsDeng;
	private String zika;
	private String consFlu;
	private String consChik;
	private String conmx;
	private String conmxbhc;
	private String encLacMat;
	private String pesoTalla;
	private String encPart;
	private String enCasa;
	private String datosVisita;
	private String obsequio;
	private String convalesciente;
    private String infoVacuna;
	private String paxgene;
	private String adn;
	private String retoma;
	private Double volRetoma;
	private String datosParto;
	private String mi;
	private String casaCHF;
    private Integer relacionFam;
    private Integer cuantasPers;
    private String posZika;
    private String enCasaChf;
    private String enCasaSa;
    private String encPartSa;

    private MovilInfo movilInfo;

	@Id
	@Column(name = "codigo", nullable = false, length = 6)
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	@Column(name = "est_part", nullable = false, length = 1)
	public Integer getEstPart() {
		return estPart;
	}

	public void setEstPart(Integer estado) {
		this.estPart = estado;
	}

	@Column(name = "estudio", nullable = false)
	public String getEstudio() {
		return estudio;
	}

	public void setEstudio(String estudio) {
		this.estudio = estudio;
	}

	@Column(name = "pbmc", nullable = false, length = 2)
	public String getPbmc() {
		return pbmc;
	}

	public void setPbmc(String pbmc) {
		this.pbmc = pbmc;
	}

	@Column(name = "cons_deng", nullable = false, length = 2)
	public String getConsDeng() {
		return consDeng;
	}

	public void setConsDeng(String consDeng) {
		this.consDeng = consDeng;
	}

	@Column(name = "cons_flu", nullable = false, length = 2)
	public String getConsFlu() {
		return consFlu;
	}

	public void setConsFlu(String consFlu) {
		this.consFlu = consFlu;
	}
	
	@Column(name = "cons_chik", nullable = false, length = 2)
	public String getConsChik() {
		return consChik;
	}

	public void setConsChik(String consChik) {
		this.consChik = consChik;
	}

	@Column(name = "conmx", nullable = false, length = 2)
	public String getConmx() {
		return conmx;
	}

	public void setConmx(String conmx) {
		this.conmx = conmx;
	}

	@Column(name = "enc_lacmat", nullable = false, length = 2)
	public String getEncLacMat() {
		return encLacMat;
	}

	public void setEncLacMat(String encLacMat) {
		this.encLacMat = encLacMat;
	}

	@Column(name = "peso_talla", nullable = false, length = 2)
	public String getPesoTalla() {
		return pesoTalla;
	}

	public void setPesoTalla(String pesoTalla) {
		this.pesoTalla = pesoTalla;
	}

	@Column(name = "enc_part", nullable = false, length = 2)
	public String getEncPart() {
		return encPart;
	}

	public void setEncPart(String encPart) {
		this.encPart = encPart;
	}
	
	@Column(name = "enc_casa", nullable = false, length = 2)
	public String getEnCasa() {
		return enCasa;
	}

	public void setEnCasa(String enCasa) {
		this.enCasa = enCasa;
	}

	@Column(name = "conmxbhc", nullable = false, length = 2)
	public String getConmxbhc() {
		return conmxbhc;
	}

	public void setConmxbhc(String conmxbhc) {
		this.conmxbhc = conmxbhc;
	}

	@Column(name = "obsequio", nullable = false, length = 2)
	public String getObsequio() {
		return obsequio;
	}

	public void setObsequio(String obsequio) {
		this.obsequio = obsequio;
	}

	@Column(name = "convalesciente", nullable = true, length = 2)
	public String getConvalesciente() {
		return convalesciente;
	}

	public void setConvalesciente(String convalesciente) {
		this.convalesciente = convalesciente;
	}

    @Column(name = "info_vacuna", nullable = true, length = 2)
    public String getInfoVacuna() {
        return infoVacuna;
    }

    public void setInfoVacuna(String infoVacuna) {
        this.infoVacuna = infoVacuna;
    }

    @Column(name = "paxgene", nullable = true, length = 2)
	public String getPaxgene() {
		return paxgene;
	}

	public void setPaxgene(String paxgene) {
		this.paxgene = paxgene;
	}

	@Column(name = "retoma", nullable = true, length = 2)
	public String getRetoma() {
		return retoma;
	}

	public void setRetoma(String retoma) {
		this.retoma = retoma;
	}

	@Column(name = "vol_retoma", nullable = true)
	public Double getVolRetoma() {
		return volRetoma;
	}

	public void setVolRetoma(Double volRetoma) {
		this.volRetoma = volRetoma;
	}

	@Column(name = "recons_den", nullable = false, length = 2)
	public String getReConsDeng() {
		return reConsDeng;
	}

	public void setReConsDeng(String reConsDeng) {
		this.reConsDeng = reConsDeng;
	}
	
	@Column(name = "zika", nullable = false, length = 2)
	public String getZika() {
		return zika;
	}

	public void setZika(String zika) {
		this.zika = zika;
	}
	
	@Column(name = "adn", nullable = false, length = 2)
	public String getAdn() {
		return adn;
	}

	public void setAdn(String adn) {
		this.adn = adn;
	}

	@Column(name = "conpto", nullable = true, length = 2)
	public String getConPto() {
		return conPto;
	}

	public void setConPto(String conPto) {
		this.conPto = conPto;
	}

	@Column(name = "datos_parto", nullable = true, length = 2)
	public String getDatosParto() {
		return datosParto;
	}

	public void setDatosParto(String datosParto) {
		this.datosParto = datosParto;
	}

	@Column(name = "datos_visita", nullable = true, length = 2)
	public String getDatosVisita() {
		return datosVisita;
	}

	public void setDatosVisita(String datosVisita) {
		this.datosVisita = datosVisita;
	}

	@Column(name = "mi", nullable = true, length = 2)
	public String getMi() {
		return mi;
	}

	public void setMi(String mi) {
		this.mi = mi;
	}

	@Column(name = "casa_chf", nullable = true, length = 10)
	public String getCasaCHF() {
		return casaCHF;
	}

	public void setCasaCHF(String casaCHF) {
		this.casaCHF = casaCHF;
	}

    @Column(name = "relacion_fam", nullable = false, length = 1)
    public Integer getRelacionFam() {
        return relacionFam;
    }

    public void setRelacionFam(Integer relacionFam) {
        this.relacionFam = relacionFam;
    }

    @Column(name = "cuantas_personas", nullable = false, length = 1)
    public Integer getCuantasPers() {
        return cuantasPers;
    }

    public void setCuantasPers(Integer asiste) {
        this.cuantasPers = asiste;
    }

    @Column(name = "pos_zika", nullable = true, length = 2)
    public String getPosZika() {
        return posZika;
    }

    public void setPosZika(String posZika) {
        this.posZika = posZika;
    }

    @Column(name = "enc_casa_chf", nullable = true, length = 2)
    public String getEnCasaChf() {
        return enCasaChf;
    }

    public void setEnCasaChf(String enCasaChf) {
        this.enCasaChf = enCasaChf;
    }

    @Column(name = "enc_casa_sa", nullable = true, length = 2)
    public String getEnCasaSa() {
        return enCasaSa;
    }

    public void setEnCasaSa(String enCasaSa) {
        this.enCasaSa = enCasaSa;
    }

    @Column(name = "enc_part_sa", nullable = true, length = 2)
    public String getEncPartSa() {
        return encPartSa;
    }

    public void setEncPartSa(String encPartSa) {
        this.encPartSa = encPartSa;
    }

    public MovilInfo getMovilInfo() {
        return movilInfo;
    }

    public void setMovilInfo(MovilInfo movilInfo) {
        this.movilInfo = movilInfo;
    }
}
