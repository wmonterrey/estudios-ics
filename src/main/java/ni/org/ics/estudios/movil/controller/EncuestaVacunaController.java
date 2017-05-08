package ni.org.ics.estudios.movil.controller;

import ni.org.ics.estudios.domain.encuestas.EncuestaVacuna;
import ni.org.ics.estudios.service.EncuestaVacunaService;
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
public class EncuestaVacunaController {

    private static final Logger logger = LoggerFactory.getLogger(EncuestaVacunaController.class);

    @Resource(name = "encuestaVacunaService")
    private EncuestaVacunaService encuestaVacunaService;

    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "encuestasVacuna/{username}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<EncuestaVacuna> getEncuestasVacuna(@PathVariable String username) {
        logger.info("Descargando toda la informacion de formularios encuesta vacunas" +username);
        List<EncuestaVacuna> respuestaList = encuestaVacunaService.getEncuestasVacunaByUser(username);
        if (respuestaList == null){
            logger.debug("Nulo");
        }
        return respuestaList;
    }

    /**
     * Acepta una solicitud POST con un par�metro JSON
     * @param encuestas Objeto serializado de EncuestaVacuna
     * @return String con el resultado
     */
    @RequestMapping(value = "encuestasVacuna", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String saveEncuestasVacuna(@RequestBody EncuestaVacuna[] encuestas){
        logger.debug("Insertando/Actualizando formularios Encuesta Vacunas");
        if (encuestas == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }else{
            List<EncuestaVacuna> encuestasList = Arrays.asList(encuestas);
            for (EncuestaVacuna encuesta : encuestasList){
                encuestaVacunaService.saveOrUpdateEncuestaVacuna(encuesta);
            }
        }
        return "Datos recibidos!";
    }

}
