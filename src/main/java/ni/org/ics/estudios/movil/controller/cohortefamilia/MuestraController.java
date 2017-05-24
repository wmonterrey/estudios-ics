package ni.org.ics.estudios.movil.controller.cohortefamilia;

import ni.org.ics.estudios.domain.cohortefamilia.Muestra;
import ni.org.ics.estudios.domain.cohortefamilia.Paxgene;
import ni.org.ics.estudios.service.cohortefamilia.MuestraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Miguel Salinas on 5/17/2017.
 * V1.0
 */
@Controller
@RequestMapping("/movil/*")
public class MuestraController {

    private static final Logger logger = LoggerFactory.getLogger(MuestraController.class);

    @Resource(name = "muestraService")
    private MuestraService muestraService;

    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "muestras/{username}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Muestra> getMuestras(@PathVariable String username) {
        logger.info("Descargando toda la informacion de formularios muestras para el usuario " +username);
        List<Muestra> respuestaList = muestraService.getMuestrasByUser(username);
        if (respuestaList == null){
            logger.debug("Nulo");
        }
        return respuestaList;
    }

    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "muestras", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Muestra> getMuestras() {
        logger.info("Descargando toda la informacion de formularios muestras para el usuario ");
        List<Muestra> respuestaList = muestraService.getMuestras();
        if (respuestaList == null){
            logger.debug("Nulo");
        }
        return respuestaList;
    }

    /**
     * Acepta una solicitud POST con un par�metro JSON
     * @param muestras Objeto serializado de Muestras
     * @return String con el resultado
     */
    @RequestMapping(value = "muestras", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String saveMuestras(@RequestBody Muestra[] muestras){
        logger.debug("Insertando/Actualizando muestras");
        if (muestras == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }else{
            List<Muestra> muestraList = Arrays.asList(muestras);
            for (Muestra muestra : muestraList){
                muestraService.saveOrUpdate(muestra);
            }
        }
        return "Datos recibidos!";
    }


    /**
     * Acepta una solicitud GET para JSON
     * @return JSON
     */
    @RequestMapping(value = "paxgene/{username}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Paxgene> getPaxgene(@PathVariable String username) {
        logger.info("Descargando toda la informacion de paxgene para el usuario " +username);
        List<Paxgene> respuestaList = muestraService.getDatosPaxgeneByUser(username);
        if (respuestaList == null){
            logger.debug("Nulo");
        }
        return respuestaList;
    }

    /**
     * Acepta una solicitud POST con un par�metro JSON
     * @param paxgenes Objeto serializado de Paxgene
     * @return String con el resultado
     */
    @RequestMapping(value = "paxgene", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String savePaxgene(@RequestBody Paxgene[] paxgenes){
        logger.debug("Insertando/Actualizando datos paxgene");
        if (paxgenes == null){
            logger.debug("Nulo");
            return "No recibi nada!";
        }else{
            List<Paxgene> paxgeneList = Arrays.asList(paxgenes);
            for (Paxgene paxgene : paxgeneList){
                muestraService.saveOrUpdateDatosPaxgene(paxgene);
            }
        }
        return "Datos recibidos!";
    }
}
