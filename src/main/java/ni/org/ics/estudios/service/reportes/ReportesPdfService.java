package ni.org.ics.estudios.service.reportes;

import ni.org.ics.estudios.domain.*;
import ni.org.ics.estudios.domain.muestreoanual.EncuestaParticipanteMA;
import ni.org.ics.estudios.domain.muestreoanual.ParticipanteProcesos;
import ni.org.ics.estudios.language.MessageResource;
import ni.org.ics.estudios.service.*;
import ni.org.ics.estudios.service.muestreoanual.EncuestaParticipanteService;
import ni.org.ics.estudios.service.muestreoanual.ParticipanteProcesosService;
import ni.org.ics.estudios.users.model.UserSistema;
import ni.org.ics.estudios.web.utils.DateUtil;
import ni.org.ics.estudios.web.utils.pdf.DatosGeneralesParticipante;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Miguel Salinas on 19/10/2018.
 * V1.0
 */
@Service("reportesPdfService")
@Transactional
public class ReportesPdfService {
    @Resource(name = "participanteService")
    ParticipanteService participanteService;
    @Resource(name = "participanteProcesosService")
    ParticipanteProcesosService participanteProcesosService;
    @Resource(name = "messageResourceService")
    MessageResourceService messageResourceService;
    @Resource(name = "cartaConsentimientoService")
    CartaConsentimientoService cartaConsentimientoService;
    @Resource(name = "encuestaParticipanteMAService")
    EncuestaParticipanteService encuestaParticipanteService;
    @Resource(name = "tamizajeService")
    TamizajeService tamizajeService;
    @Resource(name = "usuarioService")
    UsuarioService usuarioService;

    private final static String SI="SI";
    private final static String NO="NO";
    private final static String NINGUNO="NINGUNO";
    private final static String NINGUNA="NINGUNA";
    private final static String DESCONOCIDO="DESCONOCIDO";
    private final static String CSSF = "SOCRATES FLORES VIVAS";

    public DatosGeneralesParticipante getDatosGeneralesParticipante(Integer codigo) {
        MessageResource messageResource = null;
        Participante participante = participanteService.getParticipanteByCodigo(codigo);
        DatosGeneralesParticipante dgp = new DatosGeneralesParticipante();
        if (participante!=null) {
            ParticipanteProcesos procesos = participanteProcesosService.getParticipante(codigo);
            List<ContactoParticipante> contactoParticipantes = participanteService.getContactosParticipante(codigo);
            List<CartaConsentimiento> cartaConsentimientos = cartaConsentimientoService.getCartaConsentimientoByCodParticipante(codigo);
            List<EncuestaParticipanteMA> encuestasParticipante = encuestaParticipanteService.getEncuestasParticipante(codigo);


            dgp.setNombreCompleto(participante.getNombreCompleto());
            String edad[] = participante.getEdad().split("/");
            if (edad.length > 0) {
                dgp.setEdad(edad[0]);
            }
            dgp.setCodigo(participante.getCodigo().toString());
            dgp.setBarrio(participante.getCasa().getBarrio().getNombre());
            dgp.setDireccion(participante.getCasa().getDireccion());
            dgp.setManzana(participante.getCasa().getManzana());
            dgp.setSexo(participante.getSexo());
            dgp.setFechaNacimiento(DateUtil.DateToString(participante.getFechaNac(), "dd/MM/yyyy"));

            String jefeFamilia = participante.getCasa().getNombre1JefeFamilia().toUpperCase();
            if (participante.getCasa().getNombre2JefeFamilia() != null)
                jefeFamilia = jefeFamilia + " " + participante.getCasa().getNombre2JefeFamilia().toUpperCase();
            jefeFamilia = jefeFamilia + " " + participante.getCasa().getApellido1JefeFamilia().toUpperCase();
            if (participante.getCasa().getApellido2JefeFamilia() != null)
                jefeFamilia = jefeFamilia + " " + participante.getCasa().getApellido2JefeFamilia().toUpperCase();
            dgp.setJefeFamilia(jefeFamilia);

            dgp.setTutor(procesos.getTutor());

            if (procesos.getRelacionFam() != null)
                messageResource = messageResourceService.getMensajeByCatalogAndCatKey(procesos.getRelacionFam().toString(), "CP_CAT_RFTUTOR");
            if (messageResource != null) dgp.setRelFamTutor(messageResource.getSpanish());

            String madre = participante.getNombre1Madre().toUpperCase();
            if (participante.getNombre2Madre() != null)
                madre = madre + " " + participante.getNombre2Madre().toUpperCase();
            madre = madre + " " + participante.getApellido1Madre().toUpperCase();
            if (participante.getApellido2Madre() != null)
                madre = madre + " " + participante.getApellido2Madre().toUpperCase();
            dgp.setMadre(madre);

            String padre = participante.getNombre1Padre().toUpperCase();
            if (participante.getNombre2Padre() != null)
                padre = padre + " " + participante.getNombre2Padre().toUpperCase();
            padre = padre + " " + participante.getApellido1().toUpperCase();
            if (participante.getApellido2Padre() != null)
                padre = padre + " " + participante.getApellido2Padre().toUpperCase();
            dgp.setPadre(padre);

            for (ContactoParticipante contacto : contactoParticipantes) {
                if (contacto.getEsPropio() != null && contacto.getEsPropio().equalsIgnoreCase("0")) {
                    dgp.setNombreContacto(contacto.getNombre());
                    dgp.setBarrioContacto(contacto.getBarrio().getNombre());
                    dgp.setTelefonosContacto((contacto.getNumero1() != null ? contacto.getNumero1() : "") + "   " + (contacto.getNumero2() != null ? contacto.getNumero2() : ""));
                    if (contacto.getDireccion().toUpperCase().contains("MISMA")) {
                        dgp.setDireccionContacto(participante.getCasa().getDireccion());
                    } else {
                        dgp.setDireccionContacto(contactoParticipantes.get(0).getDireccion());
                    }
                    break;
                }
            }

            for (ContactoParticipante contacto : contactoParticipantes) {
                if (contacto.getEsPropio() != null && contacto.getEsPropio().equalsIgnoreCase("1")) {
                    dgp.setTelefonos((contacto.getNumero1() != null ? contacto.getNumero1() : "") + "   " + (contacto.getNumero2() != null ? contacto.getNumero2() : ""));
                    break;
                }
            }

            if (contactoParticipantes.size() <= 0) {
                dgp.getMensajes().add(messageResourceService.getMensaje("lbl.contact.not.found").getSpanish());
            }

            //se toma la primera porque estan ordenadas de la mas reciente a la mas antigua
            if (cartaConsentimientos.size() > 0) {
                dgp.setFechaIngreso(DateUtil.DateToString(cartaConsentimientos.get(0).getFechaFirma(), "dd/MM/yyyy"));
                UserSistema digitador = usuarioService.getUser(cartaConsentimientos.get(0).getRecordUser());
                if (digitador != null) dgp.setDigitador(digitador.getCompleteName());

                Tamizaje tamizaje = cartaConsentimientos.get(0).getTamizaje();
                if (tamizaje != null) {
                    messageResource = messageResourceService.getMensajeByCatalogAndCatKey(tamizaje.getTipoVivienda(), "CP_CAT_TV");
                    if (messageResource != null) dgp.setTipoVivienda(messageResource.getSpanish());

                    messageResource = messageResourceService.getMensajeByCatalogAndCatKey(tamizaje.getTiempoResidencia(), "CP_CAT_TR");
                    if (messageResource != null) dgp.setTiempoResidencia(messageResource.getSpanish());

                    //pediatrica
                    if (tamizaje.getCriteriosInclusion() != null && tamizaje.getCriteriosInclusion().length() == 3) {
                        if (tamizaje.getCriteriosInclusion().contains("2"))
                            dgp.setPermanecerTresAnios(SI);
                        else
                            dgp.setPermanecerTresAnios(NO);
                        //familia
                    } else if (tamizaje.getCriteriosInclusion() != null && tamizaje.getCriteriosInclusion().length() == 7) {
                        if (tamizaje.getCriteriosInclusion().contains("3"))
                            dgp.setPermanecerTresAnios(SI);
                        else
                            dgp.setPermanecerTresAnios(NO);
                    } else //cuando es reconsentimiento y estaba activo, no se guardan los criterios, se supone que ya los cumple
                        dgp.setPermanecerTresAnios(SI);
                    if (tamizaje.getDondeAsisteProblemasSalud() != null) {
                        messageResource = messageResourceService.getMensajeByCatalogAndCatKey(tamizaje.getDondeAsisteProblemasSalud(), "CHF_CAT_DONDEASISTE");
                        if (messageResource != null) dgp.setDondeAsiste(messageResource.getSpanish());

                        switch (Integer.valueOf(tamizaje.getDondeAsisteProblemasSalud())) {
                            case 1: //Centro de Salud Sócrates Flores
                                dgp.setUnidadAsiste(CSSF);
                                break;
                            case 2: //Otro centro de salud
                                dgp.setUnidadAsiste(tamizaje.getOtroCentroSalud());
                                break;
                            case 3: //Puesto de Salud
                                messageResource = messageResourceService.getMensajeByCatalogAndCatKey(tamizaje.getPuestoSalud(), "CHF_CAT_PUESTO");
                                if (messageResource != null) dgp.setUnidadAsiste(messageResource.getSpanish());
                                break;
                            default:
                                break;
                        }
                    }
                    if (tamizaje.getAceptaAtenderCentro() != null) {
                        messageResource = messageResourceService.getMensajeByCatalogAndCatKey(tamizaje.getAceptaAtenderCentro(), "CHF_CAT_SINO");
                        if (messageResource != null) dgp.setAsistirCSSF(messageResource.getSpanish().toUpperCase());
                    } else //cuando es reconsentimiento y estaba activo, no se guardan los criterios, se supone que ya los cumple
                        dgp.setAsistirCSSF(SI);

                    if (tamizaje.getEnfermedadCronica() != null) {
                        messageResource = messageResourceService.getMensajeByCatalogAndCatKey(tamizaje.getEnfermedadCronica(), "CHF_CAT_SINO");
                        if (messageResource != null)
                            dgp.setEnfermedadCronica(messageResource.getSpanish().toUpperCase());

                        List<MessageResource> enfermedades = messageResourceService.getMensajeEnfCronByTamizaje(tamizaje.getCodigo(), "ENFERMEDAD_CRN");
                        for (MessageResource enfermedad : enfermedades) {
                            dgp.setCualEnfermedadCronica((dgp.getCualEnfermedadCronica().length()>0?", ":"")+dgp.getCualEnfermedadCronica() + enfermedad.getSpanish());
                        }

                    } else
                        dgp.setEnfermedadCronica(NO);

                    if (tamizaje.getTratamiento() != null) {
                        messageResource = messageResourceService.getMensajeByCatalogAndCatKey(tamizaje.getTratamiento(), "CHF_CAT_SND");
                        if (messageResource != null) dgp.setTomaTratamiento(messageResource.getSpanish().toUpperCase());
                        if (tamizaje.getCualTratamiento() != null) {
                            messageResource = messageResourceService.getMensajeByCatalogAndCatKey(tamizaje.getCualTratamiento(), "CPD_CAT_TRATAMIENTO");
                            if (messageResource != null) dgp.setCualTratamiento(messageResource.getSpanish());
                        } else dgp.setTomaTratamiento(NO);
                    } else
                        dgp.setTomaTratamiento(NO);

                    if (tamizaje.getDiagDengue() != null) {
                        messageResource = messageResourceService.getMensajeByCatalogAndCatKey(tamizaje.getDiagDengue(), "CHF_CAT_SND");
                        if (messageResource != null) dgp.setTieneDxDengue(messageResource.getSpanish().toUpperCase());
                        if (tamizaje.getFechaDiagDengue() != null)
                            dgp.setFechaDxDengue(DateUtil.DateToString(tamizaje.getFechaDiagDengue(), "dd/MM/yyyy"));
                    } else
                        dgp.setTieneDxDengue(NO);

                    if (tamizaje.getHospDengue() != null) {
                        messageResource = messageResourceService.getMensajeByCatalogAndCatKey(tamizaje.getHospDengue(), "CHF_CAT_SND");
                        if (messageResource != null) dgp.setHospitalizadoDengue(messageResource.getSpanish().toUpperCase());
                        if (tamizaje.getFechaHospDengue() != null)
                            dgp.setFechaHospitalizadoDengue(DateUtil.DateToString(tamizaje.getFechaHospDengue(), "dd/MM/yyyy"));
                    } else
                        dgp.setHospitalizadoDengue(NO);
                }
            } else {
                dgp.getMensajes().add(messageResourceService.getMensaje("lbl.consent.not.found").getSpanish());
            }

            if (encuestasParticipante.size() > 0) {
                if (encuestasParticipante.get(0).getNinoAsisteEscuela() != null) {
                    if (encuestasParticipante.get(0).getNinoAsisteEscuela().equalsIgnoreCase("1"))
                        dgp.setEstudiante(SI);
                    else if (encuestasParticipante.get(0).getNinoAsisteEscuela().equalsIgnoreCase("0"))
                        dgp.setEstudiante(NO);
                    else
                        dgp.setEstudiante(DESCONOCIDO);
                } else
                    dgp.setEstudiante(NO);


                if (encuestasParticipante.get(0).getTurno() != null) {
                    messageResource = messageResourceService.getMensajeByCatalogAndCatKey(encuestasParticipante.get(0).getTurno().toString(), "CHF_CAT_TURNO");
                    if (messageResource != null) dgp.setTurno(messageResource.getSpanish());
                } else {
                    dgp.setTurno(NINGUNO);
                }
                if (encuestasParticipante.get(0).getnEscuela() != null) {
                    messageResource = messageResourceService.getMensajeByCatalogAndCatKey(encuestasParticipante.get(0).getnEscuela().toString(), "CENTRO_EST");
                    if (messageResource != null) dgp.setEscuela(messageResource.getSpanish());
                } else {
                    dgp.setEscuela(NINGUNA);
                }
            } else {
                dgp.getMensajes().add(messageResourceService.getMensaje("lbl.participant survey.not.found").getSpanish());
            }
        }else {
            dgp.getMensajes().add(messageResourceService.getMensaje("lbl.participant.not.found").getSpanish());
        }

        return dgp;

    }

}
