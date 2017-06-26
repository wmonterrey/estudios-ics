package ni.org.ics.estudios.movil.controller.cohortefamilia.casos;

import ni.org.ics.estudios.domain.cohortefamilia.casos.InformacionNoCompletaCaso;
import ni.org.ics.estudios.service.cohortefamilia.casos.InformacionNoCompletaCasoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Miguel Salinas on 5/11/2017.
 * V1.0
 */
@Controller
@RequestMapping("/movil/*")
public class InformacionNoCompletaCasoController {

    private static final Logger logger = LoggerFactory.getLogger(InformacionNoCompletaCasoController.class);

    @Resource(name = "informacionNoCompletaCasoService")
    private InformacionNoCompletaCasoService informacionNoCompletaCasoService;

    @RequestMapping(value = "visitasnodatacasos", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<InformacionNoCompletaCaso> getInformacionNoCompletaCasos(){
        logger.info("Descargando toda la informacion de las visitas sin completar datos de los participantes de las casas de la cohorte familia con caso positivo");
        List<InformacionNoCompletaCaso> infos = informacionNoCompletaCasoService.getInformacionNoCompletaCasos();
        if (infos == null){
            logger.debug("Nulo");
        }
        return  infos;
    }

    @RequestMapping(value = "visitasnodatacasos", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String saveInformacionNoCompletaCasos(@RequestBody InformacionNoCompletaCaso[] objetos){
        logger.debug("Insertando/Actualizando informacion de las visitas sin completar datos de participantes de las casas cohorte familia con casos positivos");
        if (objetos == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }else{
            List<InformacionNoCompletaCaso> infos = Arrays.asList(objetos);
            for(InformacionNoCompletaCaso info : infos) {
            	informacionNoCompletaCasoService.saveOrUpdateInformacionNoCompletaCaso(info);
            }
        }
        return "Datos recibidos!";
    }
}
