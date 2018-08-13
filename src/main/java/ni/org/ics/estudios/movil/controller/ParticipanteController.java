package ni.org.ics.estudios.movil.controller;

import ni.org.ics.estudios.domain.CambioDomicilio;
import ni.org.ics.estudios.domain.ContactoParticipante;
import ni.org.ics.estudios.domain.Participante;
import ni.org.ics.estudios.domain.muestreoanual.ParticipanteProcesos;
import ni.org.ics.estudios.service.ParticipanteService;
import ni.org.ics.estudios.service.muestreoanual.ParticipanteProcesosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Miguel Salinas on 5/5/2017.
 * V1.0
 */
@Controller
@RequestMapping("/movil/*")
public class ParticipanteController {

    private static final Logger logger = LoggerFactory.getLogger(ParticipanteController.class);

    @Resource(name = "participanteService")
    private ParticipanteService participanteService;
    @Resource(name="participanteProcesosService")
    private ParticipanteProcesosService participanteProcesosService;
    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "participantes", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Participante> getParticipantes() {
        try {
            logger.info("Descargando toda la informacion de Participante");
            List<Participante> respuestaList = participanteService.getParticipantes();
            if (respuestaList == null) {
                logger.debug("Nulo");
            }
            return respuestaList;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }

    }

    /**
     * Acepta una solicitud POST con un par�metro JSON
     * @param participantesArray Objeto serializado de Participante
     * @return String con el resultado
     */
    @RequestMapping(value = "participantes", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String saveParticipantes(@RequestBody Participante[] participantesArray){
        logger.debug("Insertando/Actualizando formularios Participante");
        if (participantesArray == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }else{
            List<Participante> participantes = Arrays.asList(participantesArray);
            for (Participante participante : participantes){
                participanteService.saveOrUpdateParticipante(participante);
            }
        }
        return "Datos recibidos!";
    }

    /**
     * Retorna participantes activos. Acepta una solicitud GET para JSON
     * @return participantes JSON
     */
    @RequestMapping(value = "participantesactivos", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Participante> descargarParticipantesActivos() {
        logger.info("Descargando toda la informacion de participantes activos");
        List<Participante> participantes = participanteService.getParticipantesActivos();
        if (participantes == null){
            logger.debug("Nulo");
        }
        return participantes;
    }

    /**
     * Retorna codigo casa. Acepta una solicitud GET para JSON
     * @return participante JSON
     */
    @RequestMapping(value = "checkcasa/{codigo}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Integer checkCasa(@PathVariable Integer codigo) {
        logger.info("Descargando codigo de casa del participante");
        Integer codCasa = participanteService.checkCasa(codigo);
        if (codCasa == null){
            logger.debug("Nulo");
        }
        return codCasa;
    }

    /**
     * Retorna participante. Acepta una solicitud GET para JSON
     * @return participante JSON
     */
    @RequestMapping(value = "participante/{codigo}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Participante> descargarParticipante(@PathVariable Integer codigo) {
        logger.info("Descargando toda la informacion del participante "+codigo);
        List<Participante> participantes = new ArrayList<Participante>();
        participantes.add(participanteService.getParticipanteByCodigo(codigo));
        return participantes;
    }


    /**
     * Retorna participantes. Acepta una solicitud GET para JSON
     * @return participantes JSON
     */
    @RequestMapping(value = "participantesprocesos", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<ParticipanteProcesos> descargarParticipantes() {
        try {
            logger.info("Descargando toda la informacion de participantes");
            List<ParticipanteProcesos> participantes = participanteProcesosService.getParticipantesProcesos();
            if (participantes == null) {
                logger.debug(new Date() + " - Nulo");
            }
            return participantes;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Acepta una solicitud POST con un parámetro JSON
     * @param participantesArray Objeto serializado de Participante
     * @return String con el resultado
     */
    @RequestMapping(value = "participantesprocesos", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String saveParticipantesProcesos(@RequestBody ParticipanteProcesos[] participantesArray){
        logger.debug("Insertando/Actualizando datos procesos de participantes");
        if (participantesArray == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }else{
            List<ParticipanteProcesos> participantes = Arrays.asList(participantesArray);
            for (ParticipanteProcesos participante : participantes){
                participanteProcesosService.saveOrUpdateParticipanteProc(participante);
            }
        }
        return "Datos recibidos!";
    }

    /**
     * Retorna participante_procesos. Acepta una solicitud GET para JSON
     * @return participante JSON
     */
    @RequestMapping(value = "participanteprocesos/{codigo}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<ParticipanteProcesos> descargarParticipanteProcesos(@PathVariable Integer codigo) {
        logger.info("Descargando toda la informacion del participante "+codigo);
        List<ParticipanteProcesos> participantes = new ArrayList<ParticipanteProcesos>();
        participantes.add(participanteProcesosService.getParticipante(codigo));

        return participantes;
    }

    /**
     * Retorna participantes. Acepta una solicitud GET para JSON
     * @return participantes JSON
     */
    @RequestMapping(value = "contactosparticipantes", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<ContactoParticipante> descargarContactosParticipantes() {
        try {
            logger.info("Descargando toda la informacion de contactosParticipantes");
            List<ContactoParticipante> contactosParticipantes = participanteService.getContactosParticipantes();
            if (contactosParticipantes == null) {
                logger.debug(new Date() + " - Nulo");
            }
            return contactosParticipantes;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Acepta una solicitud POST con un parámetro JSON
     * @param participantesArray Objeto serializado de Participante
     * @return String con el resultado
     */
    @RequestMapping(value = "contactosparticipantes", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String saveContactoParticipantes(@RequestBody ContactoParticipante[] participantesArray){
        logger.debug("Insertando/Actualizando datos contactos de participantes");
        if (participantesArray == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }else{
            List<ContactoParticipante> contactoParticipantes = Arrays.asList(participantesArray);
            for (ContactoParticipante contactoParticipante : contactoParticipantes){
                participanteService.saveOrUpdateContactoParticipante(contactoParticipante);
            }
        }
        return "Datos recibidos!";
    }

    /**
     * Retorna participantes. Acepta una solicitud GET para JSON
     * @return participantes JSON
     */
    @RequestMapping(value = "cambiosdomicilio", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<CambioDomicilio> getCambiosDomicilio() {
        try {
            logger.info("Descargando toda la informacion de cambiosdomicilio");
            List<CambioDomicilio> cambiosDomicilio = participanteService.getCambiosDomicilio();
            if (cambiosDomicilio == null) {
                logger.debug(new Date() + " - Nulo");
            }
            return cambiosDomicilio;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Acepta una solicitud POST con un parámetro JSON
     * @param cambiosArray Objeto serializado de Participante
     * @return String con el resultado
     */
    @RequestMapping(value = "cambiosdomicilio", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String saveCambioDomicilio(@RequestBody CambioDomicilio[] cambiosArray){
        logger.debug("Insertando/Actualizando datos cambiosdomicilio");
        if (cambiosArray == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }else{
            List<CambioDomicilio> cambioDomicilios = Arrays.asList(cambiosArray);
            for (CambioDomicilio contactoParticipante : cambioDomicilios){
                participanteService.saveOrUpdateCambioDomicilio(contactoParticipante);
            }
        }
        return "Datos recibidos!";
    }
}
