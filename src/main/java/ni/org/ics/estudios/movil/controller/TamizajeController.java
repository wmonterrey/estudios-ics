package ni.org.ics.estudios.movil.controller;

import ni.org.ics.estudios.domain.Tamizaje;
import ni.org.ics.estudios.service.TamizajeService;
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
public class TamizajeController {

    private static final Logger logger = LoggerFactory.getLogger(TamizajeController.class);

    @Resource(name = "tamizajeService")
    private TamizajeService tamizajeService;

    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "tamizajes/{username}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Tamizaje> getTamizajes(@PathVariable String username) {
        logger.info("Descargando toda la informacion de formularios Tamizaje" +username);
        List<Tamizaje> respuestaList = tamizajeService.getTamizajesByUser(username);
        if (respuestaList == null){
            logger.debug("Nulo");
        }
        return respuestaList;
    }

    /**
     * Acepta una solicitud POST con un par�metro JSON
     * @param tamizajesArr Objeto serializado de Tamizaje
     * @return String con el resultado
     */
    @RequestMapping(value = "tamizajes", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String saveTamizaje(@RequestBody Tamizaje[] tamizajesArr){
        logger.debug("Insertando/Actualizando formularios Tamizaje");
        if (tamizajesArr == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }else{
            List<Tamizaje> tamizajeList = Arrays.asList(tamizajesArr);
            for (Tamizaje tamizaje : tamizajeList){
                tamizajeService.saveOrUpdateTamizaje(tamizaje);
            }
        }
        return "Datos recibidos!";
    }


}
