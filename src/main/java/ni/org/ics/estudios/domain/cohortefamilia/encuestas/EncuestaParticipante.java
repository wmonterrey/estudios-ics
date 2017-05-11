package ni.org.ics.estudios.domain.cohortefamilia.encuestas;

import ni.org.ics.estudios.domain.BaseMetaData;
import ni.org.ics.estudios.domain.Participante;
import ni.org.ics.estudios.domain.audit.Auditable;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;

/**
 * Created by Miguel Salinas on 5/3/2017.
 * V1.0
 */

@Entity
@Table(name = "chf_encuestas_participante", catalog = "estudios_ics")
public class EncuestaParticipante extends BaseMetaData implements Auditable {

    private Participante participante;
    //Adulto   (Mayores o igual a 18 años; Mujeres menores de 18 años con niños o embarazadas)
    private char emancipado;
    private String motivoEmacipacion;
    private String otroMotivoEmancipacion;
    private char estaEmbarazada;
    private Integer semanasEmbarazo;
    private char esAlfabeto;
    private String nivelEducacion;
    private char trabaja;
    private String tipoTrabajo;
    private String ocupacionActual;
    //Niño
    private char vaNinoEscuela;
    private String gradoCursa;
    private String turno;
    private String nombreCentroEstudio;
    private String dondeCuidanNino;
    private char ninoTrabaja;
    private String ocupacionActualNino;
    private Integer cantNinosLugarCuidan; //Cuántos niños aproximadamente hay en el lugar que cuidan al niño
    //Datos generales de los padres y factores de hacinamiento
    private String conQuienViveNino;
    private String descOtroViveNino;
    private char padreEnEstudio;
    private Integer codigoPadreEstudio;
    private char padreAlfabeto;
    private String nivelEducacionPadre;
    private char trabajaPadre;
    private String tipoTrabajoPadre;
    private char madreEnEstudio;
    private Integer codigoMadreEstudio;
    private char madreAlfabeto;
    private String nivelEducacionMadre;
    private char trabajaMadre;
    private String tipoTrabajoMadre;
    // Para todos los participantes
    private char fuma;
    private String periodicidadFuma;
    private Integer cantidadCigarrillos;
    private char fumaDentroCasa;
    //Antecedentes de Salud
    private char tuberculosisPulmonarActual;
    private String fechaDiagnosticoTubPulActual;
    private char tomaTratamientoTubPulActual;
    private char completoTratamientoTubPulActual;
    private char tuberculosisPulmonarPasado;
    private String fechaDiagnosticoTubPulPasado;
    private char tomaTratamientoTubPulPasado;
    private char completoTratamientoTubPulPasado;
    private char alergiaRespiratoria;
    private char cardiopatia;
    private char enfermedadPulmonarOC; // enfermedad pulmonar obstructiva crónica
    private char diabetes;
    private char presionAlta;
    private char asma;
    private char silvidoRespirarPechoApretado;
    private char tosSinFiebreResfriado;
    private char usaInhaladoresSpray;
    private char crisisAsma;
    private Integer cantidadCrisisAsma;
    private Integer vecesEnfermoEnfermedadesRes; //veces enfermo en el último año por cuadros o enfermedades respiratorias
    private char otrasEnfermedades;
    private String descOtrasEnfermedades;
    private char vacunaInfluenza;
    private Integer anioVacunaInfluenza;

    @Id
    @ManyToOne
    @JoinColumn(name = "CODIDO_PARTICIPANTE")
    @ForeignKey(name = "FK_PARTICIPANTE_ENCUESTAPARTICIPANTE")
    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    @Column(name = "ENMANCIPADO", length = 1)
    public char getEmancipado() {
        return emancipado;
    }

    public void setEmancipado(char enmancipado) {
        this.emancipado = enmancipado;
    }

    @Column(name = "MOTIVO_ENMANCIPADO")
    public String getMotivoEmacipacion() {
        return motivoEmacipacion;
    }

    public void setMotivoEmacipacion(String motivoEnmacipacion) {
        this.motivoEmacipacion = motivoEnmacipacion;
    }

    @Column(name = "OTRO_MOTIVO_ENMANCIPADO")
    public String getOtroMotivoEmancipacion() {
        return otroMotivoEmancipacion;
    }

    public void setOtroMotivoEmancipacion(String otroMotivoEmancipacion) {
        this.otroMotivoEmancipacion = otroMotivoEmancipacion;
    }

    @Column(name = "ENBARAZADA", length = 1)
    public char getEstaEmbarazada() {
        return estaEmbarazada;
    }

    public void setEstaEmbarazada(char estaEmbarazada) {
        this.estaEmbarazada = estaEmbarazada;
    }

    @Column(name = "SEMANAS_EMBARAZO", length = 2)
    public Integer getSemanasEmbarazo() {
        return semanasEmbarazo;
    }

    public void setSemanasEmbarazo(Integer semanasEmbarazo) {
        this.semanasEmbarazo = semanasEmbarazo;
    }

    @Column(name = "ALFABETO", length = 1)
    public char getEsAlfabeto() {
        return esAlfabeto;
    }

    public void setEsAlfabeto(char esAlfabeto) {
        this.esAlfabeto = esAlfabeto;
    }

    @Column(name = "NIVEL_EDUCACION", length = 50)
    public String getNivelEducacion() {
        return nivelEducacion;
    }

    public void setNivelEducacion(String nivelEducacion) {
        this.nivelEducacion = nivelEducacion;
    }

    @Column(name = "TRABAJA", length = 1)
    public char getTrabaja() {
        return trabaja;
    }

    public void setTrabaja(char trabaja) {
        this.trabaja = trabaja;
    }

    @Column(name = "TIPO_TRABAJO", length = 50)
    public String getTipoTrabajo() {
        return tipoTrabajo;
    }

    public void setTipoTrabajo(String tipoTrabajo) {
        this.tipoTrabajo = tipoTrabajo;
    }

    @Column(name = "OCUPACION_ACTUAL")
    public String getOcupacionActual() {
        return ocupacionActual;
    }

    public void setOcupacionActual(String ocupacionActual) {
        this.ocupacionActual = ocupacionActual;
    }

    @Column(name = "NINO_ASISTE_ESCUELA", length = 1)
    public char getVaNinoEscuela() {
        return vaNinoEscuela;
    }

    public void setVaNinoEscuela(char vaNinoEscuela) {
        this.vaNinoEscuela = vaNinoEscuela;
    }

    @Column(name = "GRADO_ESTUDIA_NINO", length = 50)
    public String getGradoCursa() {
        return gradoCursa;
    }

    public void setGradoCursa(String gradoCursa) {
        this.gradoCursa = gradoCursa;
    }

    @Column(name = "TURNO_ESTUDIA_NINO", length = 50)
    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Column(name = "NOMBRE_CENTRO_ESTUDIO")
    public String getNombreCentroEstudio() {
        return nombreCentroEstudio;
    }

    public void setNombreCentroEstudio(String nombreCentroEstudio) {
        this.nombreCentroEstudio = nombreCentroEstudio;
    }

    @Column(name = "DONDE_CUIDAN_NINO")
    public String getDondeCuidanNino() {
        return dondeCuidanNino;
    }

    public void setDondeCuidanNino(String dondeCuidanNino) {
        this.dondeCuidanNino = dondeCuidanNino;
    }

    @Column(name = "NINO_TRABAJA", length = 1)
    public char getNinoTrabaja() {
        return ninoTrabaja;
    }

    public void setNinoTrabaja(char ninoTrabaja) {
        this.ninoTrabaja = ninoTrabaja;
    }

    @Column(name = "OCUPACION_ACTUAL_NINO")
    public String getOcupacionActualNino() {
        return ocupacionActualNino;
    }

    public void setOcupacionActualNino(String ocupacionActualNino) {
        this.ocupacionActualNino = ocupacionActualNino;
    }

    @Column(name = "CANT_NINOS_LUGAR_CUIDAN_NINO", length = 4)
    public Integer getCantNinosLugarCuidan() {
        return cantNinosLugarCuidan;
    }

    public void setCantNinosLugarCuidan(Integer cantNinosLugarCuidan) {
        this.cantNinosLugarCuidan = cantNinosLugarCuidan;
    }

    @Column(name = "CON_QUIEN_VIVE_NINO", length = 50)
    public String getConQuienViveNino() {
        return conQuienViveNino;
    }

    public void setConQuienViveNino(String conQuienViveNino) {
        this.conQuienViveNino = conQuienViveNino;
    }

    @Column(name = "DESC_OTRO_VIVE_NINO")
    public String getDescOtroViveNino() {
        return descOtroViveNino;
    }

    public void setDescOtroViveNino(String descOtroViveNino) {
        this.descOtroViveNino = descOtroViveNino;
    }

    @Column(name = "PADRE_ESTUDIO", length = 1)
    public char getPadreEnEstudio() {
        return padreEnEstudio;
    }

    public void setPadreEnEstudio(char padreEnEstudio) {
        this.padreEnEstudio = padreEnEstudio;
    }

    @Column(name = "CODIGO_PADRE_ESTUDIO", length = 6)
    public Integer getCodigoPadreEstudio() {
        return codigoPadreEstudio;
    }

    public void setCodigoPadreEstudio(Integer codigoPadreEstudio) {
        this.codigoPadreEstudio = codigoPadreEstudio;
    }

    @Column(name = "PADRE_ALFABETO", length = 1)
    public char getPadreAlfabeto() {
        return padreAlfabeto;
    }

    public void setPadreAlfabeto(char padreAlfabeto) {
        this.padreAlfabeto = padreAlfabeto;
    }

    @Column(name = "NIVEL_EDUCACION_PADRE", length = 50)
    public String getNivelEducacionPadre() {
        return nivelEducacionPadre;
    }

    public void setNivelEducacionPadre(String nivelEducacionPadre) {
        this.nivelEducacionPadre = nivelEducacionPadre;
    }

    @Column(name = "TRABAJA_PADRE", length = 1)
    public char getTrabajaPadre() {
        return trabajaPadre;
    }

    public void setTrabajaPadre(char trabajaPadre) {
        this.trabajaPadre = trabajaPadre;
    }

    @Column(name = "TIPO_TRABAJO_PADRE", length = 50)
    public String getTipoTrabajoPadre() {
        return tipoTrabajoPadre;
    }

    public void setTipoTrabajoPadre(String tipoTrabajoPadre) {
        this.tipoTrabajoPadre = tipoTrabajoPadre;
    }

    @Column(name = "MADRE_ESTUDIO", length = 1)
    public char getMadreEnEstudio() {
        return madreEnEstudio;
    }

    public void setMadreEnEstudio(char madreEnEstudio) {
        this.madreEnEstudio = madreEnEstudio;
    }

    @Column(name = "CODIGO_MADRE_ESTUDIO", length = 6)
    public Integer getCodigoMadreEstudio() {
        return codigoMadreEstudio;
    }

    public void setCodigoMadreEstudio(Integer codigoMadreEstudio) {
        this.codigoMadreEstudio = codigoMadreEstudio;
    }

    @Column(name = "MADRE_ALFABETA", length = 1)
    public char getMadreAlfabeto() {
        return madreAlfabeto;
    }

    public void setMadreAlfabeto(char madreAlfabeto) {
        this.madreAlfabeto = madreAlfabeto;
    }

    @Column(name = "NIVEL_EDUCACION_MADRE", length = 50)
    public String getNivelEducacionMadre() {
        return nivelEducacionMadre;
    }

    public void setNivelEducacionMadre(String nivelEducacionMadre) {
        this.nivelEducacionMadre = nivelEducacionMadre;
    }

    @Column(name = "TRABAJA_MADRE", length = 1)
    public char getTrabajaMadre() {
        return trabajaMadre;
    }

    public void setTrabajaMadre(char trabajaMadre) {
        this.trabajaMadre = trabajaMadre;
    }

    @Column(name = "TIPO_TRABAJO_MADRE", length = 50)
    public String getTipoTrabajoMadre() {
        return tipoTrabajoMadre;
    }

    public void setTipoTrabajoMadre(String tipoTrabajoMadre) {
        this.tipoTrabajoMadre = tipoTrabajoMadre;
    }

    @Column(name = "FUMA", length = 1)
    public char getFuma() {
        return fuma;
    }

    public void setFuma(char fuma) {
        this.fuma = fuma;
    }

    @Column(name = "PERIODICIDAD_FUNA", length = 50)
    public String getPeriodicidadFuma() {
        return periodicidadFuma;
    }

    public void setPeriodicidadFuma(String periodicidadFuma) {
        this.periodicidadFuma = periodicidadFuma;
    }

    @Column(name = "CANTIDAD_CIGARRILLOS", length = 4)
    public Integer getCantidadCigarrillos() {
        return cantidadCigarrillos;
    }

    public void setCantidadCigarrillos(Integer cantidadCigarrillos) {
        this.cantidadCigarrillos = cantidadCigarrillos;
    }

    @Column(name = "FUMA_DENTRO_CASA", length = 1)
    public char getFumaDentroCasa() {
        return fumaDentroCasa;
    }

    public void setFumaDentroCasa(char fumaDentroCasa) {
        this.fumaDentroCasa = fumaDentroCasa;
    }

    @Column(name = "TUBERCULOSIS_PULMONAR_ACTUAL", length = 1)
    public char getTuberculosisPulmonarActual() {
        return tuberculosisPulmonarActual;
    }

    public void setTuberculosisPulmonarActual(char tuberculosisPulmonarActual) {
        this.tuberculosisPulmonarActual = tuberculosisPulmonarActual;
    }

    @Column(name = "FECHA_DIAG_TUBPUL_ACTUAL", length = 8)
    public String getFechaDiagnosticoTubPulActual() {
        return fechaDiagnosticoTubPulActual;
    }

    public void setFechaDiagnosticoTubPulActual(String fechaDiagnosticoTPActual) {
        this.fechaDiagnosticoTubPulActual = fechaDiagnosticoTPActual;
    }

    @Column(name = "TRATAMIENTO_TUBPUL_ACTUAL", length = 1)
    public char getTomaTratamientoTubPulActual() {
        return tomaTratamientoTubPulActual;
    }

    public void setTomaTratamientoTubPulActual(char tomaTratamientoTPActual) {
        this.tomaTratamientoTubPulActual = tomaTratamientoTPActual;
    }

    @Column(name = "COMPLETO_TRATAMIENTO_TUBPUL_ACTUAL", length = 1)
    public char getCompletoTratamientoTubPulActual() {
        return completoTratamientoTubPulActual;
    }

    public void setCompletoTratamientoTubPulActual(char completoTratamientoTPActual) {
        this.completoTratamientoTubPulActual = completoTratamientoTPActual;
    }

    @Column(name = "TUBERCULOSIS_PULMONAR_PASADO", length = 1)
    public char getTuberculosisPulmonarPasado() {
        return tuberculosisPulmonarPasado;
    }

    public void setTuberculosisPulmonarPasado(char tuberculosisPulmonarPasado) {
        this.tuberculosisPulmonarPasado = tuberculosisPulmonarPasado;
    }

    @Column(name = "FECHA_DIAG_TUBPUL_PASADO", length = 8)
    public String getFechaDiagnosticoTubPulPasado() {
        return fechaDiagnosticoTubPulPasado;
    }

    public void setFechaDiagnosticoTubPulPasado(String fechaDiagnosticoTPPasado) {
        this.fechaDiagnosticoTubPulPasado = fechaDiagnosticoTPPasado;
    }

    @Column(name = "TRATAMIENTO_TUBBUL_PASADO", length = 1)
    public char getTomaTratamientoTubPulPasado() {
        return tomaTratamientoTubPulPasado;
    }

    public void setTomaTratamientoTubPulPasado(char tomaTratamientoTPPasado) {
        this.tomaTratamientoTubPulPasado = tomaTratamientoTPPasado;
    }

    @Column(name = "COMPLETO_TRATAMIENTO_TUBPUL_PAS", length = 1)
    public char getCompletoTratamientoTubPulPasado() {
        return completoTratamientoTubPulPasado;
    }

    public void setCompletoTratamientoTubPulPasado(char completoTratamientoTPPasado) {
        this.completoTratamientoTubPulPasado = completoTratamientoTPPasado;
    }

    @Column(name = "ALERGIA_RESPIRATORIA", length = 1)
    public char getAlergiaRespiratoria() {
        return alergiaRespiratoria;
    }

    public void setAlergiaRespiratoria(char alergiaRespiratoria) {
        this.alergiaRespiratoria = alergiaRespiratoria;
    }

    @Column(name = "CARDIOPATIA", length = 1)
    public char getCardiopatia() {
        return cardiopatia;
    }

    public void setCardiopatia(char cardiopatia) {
        this.cardiopatia = cardiopatia;
    }

    @Column(name = "ENFERM_PULMONAR_OBST_CRONICA", length = 1)
    public char getEnfermedadPulmonarOC() {
        return enfermedadPulmonarOC;
    }

    public void setEnfermedadPulmonarOC(char enfermedadPulmonarOC) {
        this.enfermedadPulmonarOC = enfermedadPulmonarOC;
    }

    @Column(name = "DIABETES", length = 1)
    public char getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(char diabetes) {
        this.diabetes = diabetes;
    }

    @Column(name = "PRESION_ALTA", length = 1)
    public char getPresionAlta() {
        return presionAlta;
    }

    public void setPresionAlta(char presionAlta) {
        this.presionAlta = presionAlta;
    }

    @Column(name = "ASMA", length = 1)
    public char getAsma() {
        return asma;
    }

    public void setAsma(char asma) {
        this.asma = asma;
    }

    @Column(name = "SILVIDO_RESPIRAR_PECHO_APRETADO", length = 1)
    public char getSilvidoRespirarPechoApretado() {
        return silvidoRespirarPechoApretado;
    }

    public void setSilvidoRespirarPechoApretado(char silvidoRespirarPechoApretado) {
        this.silvidoRespirarPechoApretado = silvidoRespirarPechoApretado;
    }

    @Column(name = "TOS_SIN_FIEBRE_RESFRIADO", length = 1)
    public char getTosSinFiebreResfriado() {
        return tosSinFiebreResfriado;
    }

    public void setTosSinFiebreResfriado(char tosSinFiebreResfriado) {
        this.tosSinFiebreResfriado = tosSinFiebreResfriado;
    }

    @Column(name = "INHALADORES_SPRAY", length = 1)
    public char getUsaInhaladoresSpray() {
        return usaInhaladoresSpray;
    }

    public void setUsaInhaladoresSpray(char usaInhaladoresSpray) {
        this.usaInhaladoresSpray = usaInhaladoresSpray;
    }

    @Column(name = "CRISIS_ASMA", length = 1)
    public char getCrisisAsma() {
        return crisisAsma;
    }

    public void setCrisisAsma(char crisisAsma) {
        this.crisisAsma = crisisAsma;
    }

    @Column(name = "CANT_CRISIS_ASMA", length = 4)
    public Integer getCantidadCrisisAsma() {
        return cantidadCrisisAsma;
    }

    public void setCantidadCrisisAsma(Integer cantidadCrisisAsma) {
        this.cantidadCrisisAsma = cantidadCrisisAsma;
    }

    @Column(name = "CANT_ENFERM_CUADROS_RESP", length = 1)
    public Integer getVecesEnfermoEnfermedadesRes() {
        return vecesEnfermoEnfermedadesRes;
    }

    public void setVecesEnfermoEnfermedadesRes(Integer vecesEnfermoEnfermedadesRes) {
        this.vecesEnfermoEnfermedadesRes = vecesEnfermoEnfermedadesRes;
    }

    @Column(name = "OTRAS_ENFERMEDADES", length = 1)
    public char getOtrasEnfermedades() {
        return otrasEnfermedades;
    }

    public void setOtrasEnfermedades(char otrasEnfermedades) {
        this.otrasEnfermedades = otrasEnfermedades;
    }

    @Column(name = "DESC_OTRAS_ENFERMEDADES", length = 1)
    public String getDescOtrasEnfermedades() {
        return descOtrasEnfermedades;
    }

    public void setDescOtrasEnfermedades(String desOtrasEnfermedades) {
        this.descOtrasEnfermedades = desOtrasEnfermedades;
    }

    @Column(name = "VACUNA_INFLUENZA", length = 1)
    public char getVacunaInfluenza() {
        return vacunaInfluenza;
    }

    public void setVacunaInfluenza(char vacunaInfluenza) {
        this.vacunaInfluenza = vacunaInfluenza;
    }

    @Column(name = "ANIO_VACUNA_INFLUENZA", length = 4)
    public Integer getAnioVacunaInfluenza() {
        return anioVacunaInfluenza;
    }

    public void setAnioVacunaInfluenza(Integer anioVacunaInfluenza) {
        this.anioVacunaInfluenza = anioVacunaInfluenza;
    }

    @Override
    public boolean isFieldAuditable(String fieldname) {
        return true;
    }

    @Override
    public String toString() {
        return "EncuestaParticipante{" + participante.getCodigo() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EncuestaParticipante)) return false;

        EncuestaParticipante that = (EncuestaParticipante) o;

        return  (!participante.equals(that.participante));
    }

    @Override
    public int hashCode() {
        return participante.hashCode();
    }
}
