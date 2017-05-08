package ni.org.ics.estudios.movil.controller;

import ni.org.ics.estudios.domain.Participante;
import ni.org.ics.estudios.service.ParticipanteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
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

    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "participantes/{username}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Participante> getParticipantes(@PathVariable String username) {
        logger.info("Descargando toda la informacion de Participante" +username);
        List<Participante> respuestaList = participanteService.getParticipantes();
        if (respuestaList == null){
            logger.debug("Nulo");
        }
        return respuestaList;
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

}
