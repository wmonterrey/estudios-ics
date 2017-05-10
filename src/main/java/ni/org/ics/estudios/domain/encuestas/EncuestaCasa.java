package ni.org.ics.estudios.domain.encuestas;

import ni.org.ics.estudios.domain.BaseMetaData;
import ni.org.ics.estudios.domain.Casa;
import ni.org.ics.estudios.domain.audit.Auditable;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Miguel Salinas on 5/3/2017.
 * V1.0
 */
@Entity
@Table(name = "encuestas_casa", catalog = "estudios_ics")
public class EncuestaCasa extends BaseMetaData implements Auditable {

    private Casa casa;
    private int cantidadCuartos;
    private int cantidadCuartosDormir;
    private Date fechaEncuestas;
    private String encuestador;
    private int hrsSinServicioAgua;
    private String ubicacionLlaveAgua;
    private char llaveCompartida;
    private char almacenaAgua;
    private char almacenaEnBarriles;
    private char almacenaEnTanques;
    private char almacenaEnPilas;
    private char almacenaOtrosRecipientes;
    private String otrosRecipientes;
    private Integer numBarriles;
    private Integer numTanques;
    private Integer numPilas;
    private Integer numOtrosRecipientes;
    private char barrilesTapados;
    private char tanquesTapados;
    private char pilasTapadas;
    private char otrosRecipientesTapados;
    private char barrilesConAbate;
    private char tanquesConAbate;
    private char pilasConAbate;
    private char otrosRecipientesConAbate;
    private String ubicacionLavandero;
    private String materialParedes;
    private String materialPiso;
    private String materialTecho;
    private String otroMaterialParedes;
    private String otroMaterialPiso;
    private String otroMaterialTecho;
    private char casaPropia;
    private char tieneAbanico;
    private char tieneTelevisor;
    private char tieneRefrigerador;
    private char tienAireAcondicionado;
    private String aireAcondicionadoFuncionando;
    private Integer numAbanicos;
    private Integer numTelevisores;
    private Integer numRefrigeradores;
    private char tieneMoto;
    private char tieneCarro;
    private char tienMicrobus;
    private char tieneCamioneta;
    private char tieneCamion;
    private char tieneOtroMedioTransAuto;
    private String otroMedioTransAuto;
    private char cocinaConLenia;
    private String ubicacionCocinaLenia;
    private String periodicidadCocinaLenia;
    private Integer numDiarioCocinaLenia;   //# de veces que cocina
    private Integer numSemanalCocinaLenia;  //# de veces que cocina semanalmente
    private Integer numQuincenalCocinaLenia;    //# de veces que cocina quincenalmente
    private Integer numMensualCocinaLenia;  //# de veces que cocina al mes
    private char tieneAnimales;
    private char tieneGallinas;
    private char tienePatos;
    private char tieneCerdos;
    private Integer cantidadGallinas;
    private Integer cantidadPatos;
    private Integer cantidadCerdos;
    private char gallinasDentroCasa;
    private char patosDentroCasa;
    private char cerdosDentroCasa;
    private char personaFumaDentroCasa;  //Alguna persona que no pertenece al estudio fuma dentro de la casa
    private char madreFuma;
    private char padreFuma;
    private char otrosFuman;
    private Integer cantidadOtrosFuman;
    private Integer cantidadCigarrilosMadre; // diarios
    private Integer cantidadCigarrillosPadre; // diarios
    private Integer cantidadCigarrillosOtros; // diarios

    @Id
    @ManyToOne
    @JoinColumn(name = "CODIGO_CASA", nullable = false)
    @ForeignKey(name = "FK_CASA_ENCUESTACASA")
    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    @Column(name = "CANTIDAD_CUARTOS")
    public int getCantidadCuartos() {
        return cantidadCuartos;
    }

    public void setCantidadCuartos(int cantidadCuartos) {
        this.cantidadCuartos = cantidadCuartos;
    }

    @Column(name = "CANT_CUARTOS_DORMIR")
    public int getCantidadCuartosDormir() {
        return cantidadCuartosDormir;
    }

    public void setCantidadCuartosDormir(int cantidadCuartosDormir) {
        this.cantidadCuartosDormir = cantidadCuartosDormir;
    }

    @Column(name = "FECHA_ENCUESTA")
    public Date getFechaEncuestas() {
        return fechaEncuestas;
    }

    public void setFechaEncuestas(Date fechaEncuestas) {
        this.fechaEncuestas = fechaEncuestas;
    }

    @Column(name = "ENCUESTADOR")
    public String getEncuestador() {
        return encuestador;
    }

    public void setEncuestador(String encuestador) {
        this.encuestador = encuestador;
    }

    @Column(name = "HRS_SIN_SRV_AGUA")
    public int getHrsSinServicioAgua() {
        return hrsSinServicioAgua;
    }

    public void setHrsSinServicioAgua(int hrsSinServicioAgua) {
        this.hrsSinServicioAgua = hrsSinServicioAgua;
    }

    @Column(name = "UBICACION_LLAVE_AGUA")
    public String getUbicacionLlaveAgua() {
        return ubicacionLlaveAgua;
    }

    public void setUbicacionLlaveAgua(String ubicacionLlaveAgua) {
        this.ubicacionLlaveAgua = ubicacionLlaveAgua;
    }

    @Column(name = "LLAVEAGUA_COMPARTIDA", length = 1)
    public char getLlaveCompartida() {
        return llaveCompartida;
    }

    public void setLlaveCompartida(char llaveCompartida) {
        this.llaveCompartida = llaveCompartida;
    }

    @Column(name = "ALMACENA_AGUA", length = 1)
    public char getAlmacenaAgua() {
        return almacenaAgua;
    }

    public void setAlmacenaAgua(char almacenaAgua) {
        this.almacenaAgua = almacenaAgua;
    }

    @Column(name = "ALMACENA_EN_BARRILES", length = 1)
    public char getAlmacenaEnBarriles() {
        return almacenaEnBarriles;
    }

    public void setAlmacenaEnBarriles(char utilizaBarriles) {
        this.almacenaEnBarriles = utilizaBarriles;
    }

    @Column(name = "ALMACENA_EN_TANQUES", length = 1)
    public char getAlmacenaEnTanques() {
        return almacenaEnTanques;
    }

    public void setAlmacenaEnTanques(char utilizaTanques) {
        this.almacenaEnTanques = utilizaTanques;
    }

    @Column(name = "ALMACENA_EN_PILAS", length = 1)
    public char getAlmacenaEnPilas() {
        return almacenaEnPilas;
    }

    public void setAlmacenaEnPilas(char utilizaPilas) {
        this.almacenaEnPilas = utilizaPilas;
    }

    @Column(name = "ALMACENA_EN_OTROSRECIP", length = 1)
    public char getAlmacenaOtrosRecipientes() {
        return almacenaOtrosRecipientes;
    }

    public void setAlmacenaOtrosRecipientes(char utilizaOtrosRecipientes) {
        this.almacenaOtrosRecipientes = utilizaOtrosRecipientes;
    }

    @Column(name = "DESC_OTROS_RECIPIENTES")
    public String getOtrosRecipientes() {
        return otrosRecipientes;
    }

    public void setOtrosRecipientes(String otrosRecipientes) {
        this.otrosRecipientes = otrosRecipientes;
    }

    @Column(name = "NUMERO_BARRILES", length = 3)
    public Integer getNumBarriles() {
        return numBarriles;
    }

    public void setNumBarriles(Integer numBarriles) {
        this.numBarriles = numBarriles;
    }

    @Column(name = "NUMERO_TANQUES", length = 3)
    public Integer getNumTanques() {
        return numTanques;
    }

    public void setNumTanques(Integer numTanques) {
        this.numTanques = numTanques;
    }

    @Column(name = "NUMERO_PILAS", length = 3)
    public Integer getNumPilas() {
        return numPilas;
    }

    public void setNumPilas(Integer numPilas) {
        this.numPilas = numPilas;
    }

    @Column(name = "NUMERO_OTROS_RECIPIENTES", length = 3)
    public Integer getNumOtrosRecipientes() {
        return numOtrosRecipientes;
    }

    public void setNumOtrosRecipientes(Integer numOtrosRecipientes) {
        this.numOtrosRecipientes = numOtrosRecipientes;
    }

    @Column(name = "BARRILES_TAPADOS", length = 1)
    public char getBarrilesTapados() {
        return barrilesTapados;
    }

    public void setBarrilesTapados(char barrilesTapados) {
        this.barrilesTapados = barrilesTapados;
    }

    @Column(name = "TANQUES_TAPADOS", length = 1)
    public char getTanquesTapados() {
        return tanquesTapados;
    }

    public void setTanquesTapados(char tanquesTapados) {
        this.tanquesTapados = tanquesTapados;
    }

    @Column(name = "PILAS_TAPADAS", length = 1)
    public char getPilasTapadas() {
        return pilasTapadas;
    }

    public void setPilasTapadas(char pilasTapadas) {
        this.pilasTapadas = pilasTapadas;
    }

    @Column(name = "OTROS_RECIP_TAPADOS", length = 1)
    public char getOtrosRecipientesTapados() {
        return otrosRecipientesTapados;
    }

    public void setOtrosRecipientesTapados(char otrosRecipientesTapados) {
        this.otrosRecipientesTapados = otrosRecipientesTapados;
    }

    @Column(name = "BARRILES_CON_ABATE", length = 1)
    public char getBarrilesConAbate() {
        return barrilesConAbate;
    }

    public void setBarrilesConAbate(char barrilesConAbate) {
        this.barrilesConAbate = barrilesConAbate;
    }

    @Column(name = "TANQUES_CON_ABATE", length = 1)
    public char getTanquesConAbate() {
        return tanquesConAbate;
    }

    public void setTanquesConAbate(char tanquesConAbate) {
        this.tanquesConAbate = tanquesConAbate;
    }

    @Column(name = "PILAS_CON_ABATE", length = 1)
    public char getPilasConAbate() {
        return pilasConAbate;
    }

    public void setPilasConAbate(char pilasConAbate) {
        this.pilasConAbate = pilasConAbate;
    }

    @Column(name = "OTROSRECIP_CON_ABATE", length = 1)
    public char getOtrosRecipientesConAbate() {
        return otrosRecipientesConAbate;
    }

    public void setOtrosRecipientesConAbate(char otrosRecipientesConAbate) {
        this.otrosRecipientesConAbate = otrosRecipientesConAbate;
    }

    @Column(name = "UBICACION_LAVANDERO", length = 50)
    public String getUbicacionLavandero() {
        return ubicacionLavandero;
    }

    public void setUbicacionLavandero(String ubicacionLavandero) {
        this.ubicacionLavandero = ubicacionLavandero;
    }

    @Column(name = "MATERIAL_PAREDES", length = 350)
    public String getMaterialParedes() {
        return materialParedes;
    }

    public void setMaterialParedes(String materialParedes) {
        this.materialParedes = materialParedes;
    }

    @Column(name = "MATERIAL_PISO", length = 250)
    public String getMaterialPiso() {
        return materialPiso;
    }

    public void setMaterialPiso(String materialPiso) {
        this.materialPiso = materialPiso;
    }

    @Column(name = "MATERIAL_TECHO", length = 200)
    public String getMaterialTecho() {
        return materialTecho;
    }

    public void setMaterialTecho(String materialTecho) {
        this.materialTecho = materialTecho;
    }

    @Column(name = "OTRO_MATERIAL_PAREDES")
    public String getOtroMaterialParedes() {
        return otroMaterialParedes;
    }

    public void setOtroMaterialParedes(String otroMaterialParedes) {
        this.otroMaterialParedes = otroMaterialParedes;
    }

    @Column(name = "OTRO_MATERIAL_PISO")
    public String getOtroMaterialPiso() {
        return otroMaterialPiso;
    }

    public void setOtroMaterialPiso(String otroMaterialPiso) {
        this.otroMaterialPiso = otroMaterialPiso;
    }

    @Column(name = "OTRO_MATERIAL_TECHO")
    public String getOtroMaterialTecho() {
        return otroMaterialTecho;
    }

    public void setOtroMaterialTecho(String otroMaterialTecho) {
        this.otroMaterialTecho = otroMaterialTecho;
    }

    @Column(name = "CASA_PROPIA", length = 1)
    public char getCasaPropia() {
        return casaPropia;
    }

    public void setCasaPropia(char casaPropia) {
        this.casaPropia = casaPropia;
    }

    @Column(name = "TIENE_ABANICO", length = 1)
    public char getTieneAbanico() {
        return tieneAbanico;
    }

    public void setTieneAbanico(char tieneAbanico) {
        this.tieneAbanico = tieneAbanico;
    }

    @Column(name = "TIENE_TELEVISOR", length = 1)
    public char getTieneTelevisor() {
        return tieneTelevisor;
    }

    public void setTieneTelevisor(char tieneTelevisor) {
        this.tieneTelevisor = tieneTelevisor;
    }

    @Column(name = "TIENE_REFRIGERADOR_FREEZER", length = 1)
    public char getTieneRefrigerador() {
        return tieneRefrigerador;
    }

    public void setTieneRefrigerador(char tieneRefrigerador) {
        this.tieneRefrigerador = tieneRefrigerador;
    }

    @Column(name = "TIENE_AIRE_ACONDICIONADO", length = 1)
    public char getTienAireAcondicionado() {
        return tienAireAcondicionado;
    }

    public void setTienAireAcondicionado(char tienAireAcondicionado) {
        this.tienAireAcondicionado = tienAireAcondicionado;
    }

    @Column(name = "FUNCIONAMIENTO_AIRE", length = 100)
    public String getAireAcondicionadoFuncionando() {
        return aireAcondicionadoFuncionando;
    }

    public void setAireAcondicionadoFuncionando(String aireAcondicionadoFuncionando) {
        this.aireAcondicionadoFuncionando = aireAcondicionadoFuncionando;
    }

    @Column(name = "CANTIDAD_ABANICOS", length = 2)
    public Integer getNumAbanicos() {
        return numAbanicos;
    }

    public void setNumAbanicos(Integer numAbanicos) {
        this.numAbanicos = numAbanicos;
    }

    @Column(name = "CANTIDAD_TELEVISORES", length = 2)
    public Integer getNumTelevisores() {
        return numTelevisores;
    }

    public void setNumTelevisores(Integer numTelevisores) {
        this.numTelevisores = numTelevisores;
    }

    @Column(name = "CANTIDAD_REFRIGERADORES", length = 2)
    public Integer getNumRefrigeradores() {
        return numRefrigeradores;
    }

    public void setNumRefrigeradores(Integer numRefrigeradores) {
        this.numRefrigeradores = numRefrigeradores;
    }

    @Column(name = "TIENE_MOTO", length = 1)
    public char getTieneMoto() {
        return tieneMoto;
    }

    public void setTieneMoto(char tieneMoto) {
        this.tieneMoto = tieneMoto;
    }

    @Column(name = "TIENE_CARRO", length = 1)
    public char getTieneCarro() {
        return tieneCarro;
    }

    public void setTieneCarro(char tieneCarro) {
        this.tieneCarro = tieneCarro;
    }

    @Column(name = "TIENE_MICROBUS", length = 1)
    public char getTienMicrobus() {
        return tienMicrobus;
    }

    public void setTienMicrobus(char tienMicrobus) {
        this.tienMicrobus = tienMicrobus;
    }

    @Column(name = "TIENE_CAMIONETA", length = 1)
    public char getTieneCamioneta() {
        return tieneCamioneta;
    }

    public void setTieneCamioneta(char tieneCamioneta) {
        this.tieneCamioneta = tieneCamioneta;
    }

    @Column(name = "TIENE_CAMION", length = 1)
    public char getTieneCamion() {
        return tieneCamion;
    }

    public void setTieneCamion(char tieneCamion) {
        this.tieneCamion = tieneCamion;
    }

    @Column(name = "TIENE_OTRO_MEDIO_TRANS", length = 1)
    public char getTieneOtroMedioTransAuto() {
        return tieneOtroMedioTransAuto;
    }

    public void setTieneOtroMedioTransAuto(char tieneOtroMedioTransAuto) {
        this.tieneOtroMedioTransAuto = tieneOtroMedioTransAuto;
    }

    @Column(name = "DESC_OTRO_MEDIO_TRANS")
    public String getOtroMedioTransAuto() {
        return otroMedioTransAuto;
    }

    public void setOtroMedioTransAuto(String otroMedioTransAuto) {
        this.otroMedioTransAuto = otroMedioTransAuto;
    }

    @Column(name = "COCINA_CON_LENIA", length = 1)
    public char getCocinaConLenia() {
        return cocinaConLenia;
    }

    public void setCocinaConLenia(char cocinaConLenia) {
        this.cocinaConLenia = cocinaConLenia;
    }

    @Column(name = "UBICACION_COCINA_LENIA", length = 50)
    public String getUbicacionCocinaLenia() {
        return ubicacionCocinaLenia;
    }

    public void setUbicacionCocinaLenia(String ubicacionCocinaLenia) {
        this.ubicacionCocinaLenia = ubicacionCocinaLenia;
    }

    @Column(name = "PERIODICIDAD_COCINA_LENIA", length = 50)
    public String getPeriodicidadCocinaLenia() {
        return periodicidadCocinaLenia;
    }

    public void setPeriodicidadCocinaLenia(String periodicidadCocinaLenia) {
        this.periodicidadCocinaLenia = periodicidadCocinaLenia;
    }

    @Column(name = "NUM_DIARIO_COCINA_LENIA", length = 2)
    public Integer getNumDiarioCocinaLenia() {
        return numDiarioCocinaLenia;
    }

    public void setNumDiarioCocinaLenia(Integer numDiarioCocinaLenia) {
        this.numDiarioCocinaLenia = numDiarioCocinaLenia;
    }

    @Column(name = "NUM_SEMANAL_COCINA_LENIA", length = 2)
    public Integer getNumSemanalCocinaLenia() {
        return numSemanalCocinaLenia;
    }

    public void setNumSemanalCocinaLenia(Integer numSemanalCocinaLenia) {
        this.numSemanalCocinaLenia = numSemanalCocinaLenia;
    }

    @Column(name = "NUM_QUINCENAL_COCINA_LENIA", length = 2)
    public Integer getNumQuincenalCocinaLenia() {
        return numQuincenalCocinaLenia;
    }

    public void setNumQuincenalCocinaLenia(Integer numQuincenalCocinaLenia) {
        this.numQuincenalCocinaLenia = numQuincenalCocinaLenia;
    }

    @Column(name = "NUM_MENSUAL_COCINA_LENIA", length = 2)
    public Integer getNumMensualCocinaLenia() {
        return numMensualCocinaLenia;
    }

    public void setNumMensualCocinaLenia(Integer numMensualCocinaLenia) {
        this.numMensualCocinaLenia = numMensualCocinaLenia;
    }

    @Column(name = "TIENE_ANIMALES", length = 1)
    public char getTieneAnimales() {
        return tieneAnimales;
    }

    public void setTieneAnimales(char tieneAnimales) {
        this.tieneAnimales = tieneAnimales;
    }

    @Column(name = "TIENE_GALLINAS", length = 1)
    public char getTieneGallinas() {
        return tieneGallinas;
    }

    public void setTieneGallinas(char tieneGallinas) {
        this.tieneGallinas = tieneGallinas;
    }

    @Column(name = "TIENE_PATOS", length = 1)
    public char getTienePatos() {
        return tienePatos;
    }

    public void setTienePatos(char tienePatos) {
        this.tienePatos = tienePatos;
    }

    @Column(name = "TIENE_CERDOS", length = 1)
    public char getTieneCerdos() {
        return tieneCerdos;
    }

    public void setTieneCerdos(char tieneCerdos) {
        this.tieneCerdos = tieneCerdos;
    }

    @Column(name = "CANT_GALLINAS", length = 3)
    public Integer getCantidadGallinas() {
        return cantidadGallinas;
    }

    public void setCantidadGallinas(Integer cantidadGallinas) {
        this.cantidadGallinas = cantidadGallinas;
    }

    @Column(name = "CANT_PATOS", length = 3)
    public Integer getCantidadPatos() {
        return cantidadPatos;
    }

    public void setCantidadPatos(Integer cantidadPatos) {
        this.cantidadPatos = cantidadPatos;
    }

    @Column(name = "CANT_CERDOS", length = 3)
    public Integer getCantidadCerdos() {
        return cantidadCerdos;
    }

    public void setCantidadCerdos(Integer cantidadCerdos) {
        this.cantidadCerdos = cantidadCerdos;
    }

    @Column(name = "GALLINAS_DENTRO_CASA", length = 1)
    public char getGallinasDentroCasa() {
        return gallinasDentroCasa;
    }

    public void setGallinasDentroCasa(char gallinasDentroCasa) {
        this.gallinasDentroCasa = gallinasDentroCasa;
    }

    @Column(name = "PATOS_DENTRO_CASA", length = 1)
    public char getPatosDentroCasa() {
        return patosDentroCasa;
    }

    public void setPatosDentroCasa(char patosDentroCasa) {
        this.patosDentroCasa = patosDentroCasa;
    }

    @Column(name = "CERDOS_DENTRO_CASA", length = 1)
    public char getCerdosDentroCasa() {
        return cerdosDentroCasa;
    }

    public void setCerdosDentroCasa(char cerdosDentroCasa) {
        this.cerdosDentroCasa = cerdosDentroCasa;
    }

    @Column(name = "PERS_FUMA_DENTRO_CASA", length = 1)
    public char getPersonaFumaDentroCasa() {
        return personaFumaDentroCasa;
    }

    public void setPersonaFumaDentroCasa(char personaFumaDentroCasa) {
        this.personaFumaDentroCasa = personaFumaDentroCasa;
    }

    @Column(name = "MADRE_FUMA", length = 1)
    public char getMadreFuma() {
        return madreFuma;
    }

    public void setMadreFuma(char madreFuma) {
        this.madreFuma = madreFuma;
    }

    @Column(name = "PADRE_FUMA", length = 1)
    public char getPadreFuma() {
        return padreFuma;
    }

    public void setPadreFuma(char padreFuma) {
        this.padreFuma = padreFuma;
    }

    @Column(name = "OTROS_FUMAN", length = 1)
    public char getOtrosFuman() {
        return otrosFuman;
    }

    public void setOtrosFuman(char otrosFuman) {
        this.otrosFuman = otrosFuman;
    }

    @Column(name = "CANT_OTROS_FUMAN", length = 3)
    public Integer getCantidadOtrosFuman() {
        return cantidadOtrosFuman;
    }

    public void setCantidadOtrosFuman(Integer cantidadOtrosFuman) {
        this.cantidadOtrosFuman = cantidadOtrosFuman;
    }

    @Column(name = "CANT_CIGARRILLOS_MADRE", length = 3)
    public Integer getCantidadCigarrilosMadre() {
        return cantidadCigarrilosMadre;
    }

    public void setCantidadCigarrilosMadre(Integer cantidadCigarrilosMadre) {
        this.cantidadCigarrilosMadre = cantidadCigarrilosMadre;
    }

    @Column(name = "CANT_CIGARRILLOS_PADRE", length = 3)
    public Integer getCantidadCigarrillosPadre() {
        return cantidadCigarrillosPadre;
    }

    public void setCantidadCigarrillosPadre(Integer cantidadCigarrillosPadre) {
        this.cantidadCigarrillosPadre = cantidadCigarrillosPadre;
    }

    @Column(name = "CANT_CIGARRILLOS_OTROS", length = 3)
    public Integer getCantidadCigarrillosOtros() {
        return cantidadCigarrillosOtros;
    }

    public void setCantidadCigarrillosOtros(Integer cantidadCigarrillosOtros) {
        this.cantidadCigarrillosOtros = cantidadCigarrillosOtros;
    }

    @Override
    public boolean isFieldAuditable(String fieldname) {
        return true;
    }

    @Override
    public String toString() {
        return "EncuestaCasa{" + casa.getCodigo() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EncuestaCasa)) return false;

        EncuestaCasa that = (EncuestaCasa) o;

        return  (!casa.equals(that.casa));
    }

    @Override
    public int hashCode() {
        return casa.hashCode();
    }
}
