package ni.org.ics.estudios.movil.controller.muestreoanual;

import ni.org.ics.estudios.domain.muestreoanual.ConsentimientoChik;
import ni.org.ics.estudios.domain.muestreoanual.ConsentimientoChikId;
import ni.org.ics.estudios.service.muestreoanual.ConsentimientoChikService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Maneja las solicitudes que van a la aplicacion relacionadas a json
 * 
 * @author Brenda Lopez
 */
@Controller
@RequestMapping("/movil/*")
public class ConsentimientoChikController {
	@Resource(name="consentimientoChikService")
	private ConsentimientoChikService consentimientoChikService;
	private static final Logger logger = LoggerFactory.getLogger(ConsentimientoChikController.class);

	/**
     * Retorna consentimientos. Acepta una solicitud GET para JSON
     * @return consentimientos JSON
     */
    @RequestMapping(value = "conschik", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<ConsentimientoChik> descargarConsentimientoChiks() {
        logger.info("Descargando toda la informacion de los datos de los ConsentimientoChik");
        List<ConsentimientoChik> cons = consentimientoChikService.getConsentimientoChik();
        if (cons == null){
        	logger.debug("Nulo");
        }
        return cons;	
    }
    
    
    
    /**
     * Acepta una solicitud POST con un parametro JSON
     * @param cons Objeto serializado de ReConsentimientoDen
     * @return una cadena con el resultado*/
     
    @RequestMapping(value = "conschik", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    String sendMessageJson(@RequestBody ConsentimientoChik[] envio) {
        logger.debug("Insertando/Actualizando ConsentimientoChik");
        if (envio == null){
        	logger.debug("Nulo");
        	return "No recibi nada!";
        }
        else{
        	List<ConsentimientoChik> consens = Arrays.asList(envio);
        	for (ConsentimientoChik cchik : consens){
        		ConsentimientoChikId consId = new ConsentimientoChikId();
        		consId.setCodigo(cchik.getConsChikId().getCodigo());
        		consId.setFechaCons(new Date(cchik.getConsChikId().getFechaCons().getTime()));
        		Boolean existe = consentimientoChikService.checkConsentimientoChik(consId);
        		if (!existe){
        			consentimientoChikService.addConsentimientoChik(cchik);
        		}
        		else{
        			consentimientoChikService.updateConsentimientoChik(cchik);
        		}
        	}
        }
        return "Datos recibidos!";
    }  
    
    
}
