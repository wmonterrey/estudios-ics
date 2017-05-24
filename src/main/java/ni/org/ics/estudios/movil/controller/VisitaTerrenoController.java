package ni.org.ics.estudios.movil.controller;

import ni.org.ics.estudios.domain.VisitaTerreno;
import ni.org.ics.estudios.service.VisitaTerrenoService;

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
public class VisitaTerrenoController {

    private static final Logger logger = LoggerFactory.getLogger(VisitaTerrenoController.class);

    @Resource(name = "visitaTerrenoService")
    private VisitaTerrenoService visitaTerrenoService;

    @RequestMapping(value = "visitas", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<VisitaTerreno> getVisitasTerreno(){
        logger.info("Descargando toda la informacion de los datos de las VisitaTerreno");
        List<VisitaTerreno> visitas = visitaTerrenoService.getVisitasTerreno();
        if (visitas == null){
            logger.debug("Nulo");
        }
        return  visitas;
    }

    @RequestMapping(value = "visitas", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String saveVisitaTerreno(@RequestBody VisitaTerreno[] objetos){
        logger.debug("Insertando/Actualizando Visitas");
        if (objetos == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }else{
            List<VisitaTerreno> visitas = Arrays.asList(objetos);
            for(VisitaTerreno visita : visitas) {
            	visitaTerrenoService.saveOrUpdateVisitaTerreno(visita);
            }
        }
        return "Datos recibidos!";
    }

}
