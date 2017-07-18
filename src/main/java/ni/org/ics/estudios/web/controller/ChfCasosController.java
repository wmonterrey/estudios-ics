package ni.org.ics.estudios.web.controller;


import ni.org.ics.estudios.domain.cohortefamilia.casos.CasaCohorteFamiliaCaso;
import ni.org.ics.estudios.domain.cohortefamilia.casos.FormularioContactoCaso;
import ni.org.ics.estudios.domain.cohortefamilia.casos.ParticipanteCohorteFamiliaCaso;
import ni.org.ics.estudios.domain.cohortefamilia.casos.VisitaSeguimientoCaso;
import ni.org.ics.estudios.domain.cohortefamilia.casos.VisitaSeguimientoCasoSintomas;
import ni.org.ics.estudios.language.MessageResource;
import ni.org.ics.estudios.service.MessageResourceService;
import ni.org.ics.estudios.service.UsuarioService;
import ni.org.ics.estudios.service.cohortefamilia.casos.CasaCohorteFamiliaCasoService;
import ni.org.ics.estudios.service.cohortefamilia.casos.FormularioContactoCasoService;
import ni.org.ics.estudios.service.cohortefamilia.casos.ParticipanteCohorteFamiliaCasoService;
import ni.org.ics.estudios.service.cohortefamilia.casos.VisitaSeguimientoCasoService;
import ni.org.ics.estudios.service.cohortefamilia.casos.VisitaSeguimientoCasoSintomasService;
import ni.org.ics.estudios.users.model.UserSistema;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

/**
 * Created by William Aviles on 10/07/2017.
 * V1.0
 */
@Controller
@RequestMapping("/chf/editarcaso/*")
public class ChfCasosController {

    private static final Logger logger = LoggerFactory.getLogger(ChfCasosController.class);
    
    @Resource(name = "casaCohorteFamiliaCasoService")
    private CasaCohorteFamiliaCasoService casaCohorteFamiliaCasoService;
    @Resource(name = "participanteCohorteFamiliaCasoService")
    private ParticipanteCohorteFamiliaCasoService participanteCohorteFamiliaCasoService;
    @Resource(name = "visitaSeguimientoCasoService")
    private VisitaSeguimientoCasoService visitaSeguimientoCasoService;
    @Resource(name = "visitaSeguimientoCasoSintomasService")
    private VisitaSeguimientoCasoSintomasService visitaSeguimientoCasoSintomasService;
    @Resource(name = "formularioContactoCasoService")
    private FormularioContactoCasoService formularioContactoCasoService;
    @Resource(name = "messageResourceService")
    private MessageResourceService messageResourceService;
    @Resource(name = "usuarioService")
    private UsuarioService usuarioService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String obtenerCasos(Model model) throws ParseException {
        logger.debug("Mostrando casos monitoreo intensivo en JSP");
        return "/chfcasos/search";
    }
    
    
    /**
     * Retorna una lista de casas. Acepta una solicitud GET para JSON
     * @return Un arreglo JSON de racks
	 * @throws ParseException 
     */
    @RequestMapping(value = "casas", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<CasaCohorteFamiliaCaso> fetchCasaCohorteFamiliaCasosJson(@RequestParam(value = "parametro", required = true) String parametro) throws ParseException {
        logger.info("Obteniendo las casas en JSON");
        List<CasaCohorteFamiliaCaso> casas = null; 
        casas = casaCohorteFamiliaCasoService.getCasaCohorteFamiliaCasos(parametro);
        return casas;	
    }
    
    @RequestMapping(value = "/participants/{codigo}", method = RequestMethod.GET)
    public String obtenerParticipantesCaso(@PathVariable("codigo") String codigo, Model model) {
        logger.debug("Mostrando participantes de caso monitoreo intensivo en JSP");
        List<ParticipanteCohorteFamiliaCaso> participantes = participanteCohorteFamiliaCasoService.getParticipantesCohorteFamiliaCasoByCodigoCaso(codigo);
        model.addAttribute("participantes",participantes);
        model.addAttribute("caso", participantes.get(0).getCodigoCaso());
        return "/chfcasos/participantsList";
    }
    
    
    @RequestMapping(value = "/participantdata/{codigo}", method = RequestMethod.GET)
    public String obtenerDatosParticipanteCaso(@PathVariable("codigo") String codigo, Model model) {
        logger.debug("Mostrando datos de un participante de caso monitoreo intensivo en JSP");
        ParticipanteCohorteFamiliaCaso participante = participanteCohorteFamiliaCasoService.getParticipanteCohorteFamiliaCasosByCodigo(codigo);
        List<VisitaSeguimientoCaso> vseg = visitaSeguimientoCasoService.getVisitaSeguimientoCasos(codigo);
        model.addAttribute("participante",participante);
        model.addAttribute("visitas",vseg);
        return "/chfcasos/participantData";
    }
    
    @RequestMapping(value = "/newvisit/{codigo}", method = RequestMethod.GET)
	public String initCreationVisit(@PathVariable("codigo") String codigo, Model model) {
    	ParticipanteCohorteFamiliaCaso participante = participanteCohorteFamiliaCasoService.getParticipanteCohorteFamiliaCasosByCodigo(codigo);
    	List<MessageResource> visitas = messageResourceService.getCatalogo("CHF_CAT_VIS_MI");
    	List<MessageResource> sino = messageResourceService.getCatalogo("CHF_CAT_SINO");
    	model.addAttribute("participante",participante);
    	model.addAttribute("visitas",visitas);
    	model.addAttribute("sino",sino);
		return "/chfcasos/enterVisit";
	}
    
    @RequestMapping(value = "editVisit/{codigoCasoVisita}/", method = RequestMethod.GET)
    public String initEditionVisit(Model model, @PathVariable(value = "codigoCasoVisita") String codigoCasoVisita){
    	VisitaSeguimientoCaso vsc = this.visitaSeguimientoCasoService.getVisitaSeguimientoCaso(codigoCasoVisita);
    	if (vsc!=null){
    		model.addAttribute("visita", vsc);
    		ParticipanteCohorteFamiliaCaso participante = participanteCohorteFamiliaCasoService.getParticipanteCohorteFamiliaCasosByCodigo(vsc.getCodigoParticipanteCaso().getCodigoCasoParticipante());
        	List<MessageResource> visitas = messageResourceService.getCatalogo("CHF_CAT_VIS_MI");
        	List<MessageResource> sino = messageResourceService.getCatalogo("CHF_CAT_SINO");
        	model.addAttribute("participante",participante);
        	model.addAttribute("visitas",visitas);
        	model.addAttribute("sino",sino);
    		return "/chfcasos/enterVisit";
    	}
    	else{
    		return "404";
        }
    }  
    
    @RequestMapping( value="saveVisit", method=RequestMethod.POST)
	public ResponseEntity<String> processVisitForm( @RequestParam(value="codigoCasoVisita", required=false, defaultValue="" ) String codigoCasoVisita
			, @RequestParam( value="codigoParticipanteCaso", required=true ) String codigoParticipanteCaso
			, @RequestParam( value="visita", required=true ) String visita
			, @RequestParam( value="fechaVisita", required=true ) String fechaVisita
			, @RequestParam( value="horaVisita", required=true ) String horaVisita
			, @RequestParam( value="horaProbableVisita", required=true ) String horaProbableVisita
			, @RequestParam( value="temp", required=true ) float temp
			, @RequestParam( value="expCS", required=true ) String expCS
	        ){
    	try{
    		UserSistema usuario = usuarioService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
    		ParticipanteCohorteFamiliaCaso participante = participanteCohorteFamiliaCasoService.getParticipanteCohorteFamiliaCasosByCodigo(codigoParticipanteCaso);
			VisitaSeguimientoCaso vsc = new VisitaSeguimientoCaso();
			//Si el codigoCasoVisita viene en blanco es una nueva visita
			if (codigoCasoVisita.equals("")){
				if (this.visitaSeguimientoCasoService.checkVisitaSeguimientoCasos(codigoParticipanteCaso, visita, fechaVisita)){
					MessageResource repetido = messageResourceService.getMensaje("visitDuplicated");
					Gson gson = new Gson();
		    	    String json = gson.toJson(repetido.getSpanish());
					return new ResponseEntity<String>( json, HttpStatus.CREATED);
				}
				//Crear un nuevo VisitaSeguimientoCaso
				codigoCasoVisita = new UUID(usuario.getUsername().hashCode(),new Date().hashCode()).toString();
				vsc.setCodigoCasoVisita(codigoCasoVisita);
				vsc.setCodigoParticipanteCaso(participante);
				vsc.setRecordUser(usuario.getUsername());
				vsc.setRecordDate(new Date());
				WebAuthenticationDetails wad  = (WebAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
	        	String idSesion = wad.getSessionId();
	        	String direccionIp = wad.getRemoteAddress();
				vsc.setDeviceid(idSesion + "-"+ direccionIp);
				vsc.setEstado('1');
			}
			//Si el codigoCasoVisita no viene en blanco hay que editar la visita
			else{
				//Recupera el medicion de la base de datos
				vsc = this.visitaSeguimientoCasoService.getVisitaSeguimientoCaso(codigoCasoVisita);
			}
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        	Date date1 = formatter.parse(fechaVisita+" "+horaVisita);
        	vsc.setVisita(visita);
			vsc.setFechaVisita(date1);
			vsc.setHoraProbableVisita(horaProbableVisita);
			vsc.setTemp(temp);
			vsc.setExpCS(expCS);
			//Actualiza la visita
			this.visitaSeguimientoCasoService.saveOrUpdateVisitaSeguimientoCaso(vsc);
			return createJsonResponse(vsc);
    	}
    	catch (DataIntegrityViolationException e){
    		String message = e.getMostSpecificCause().getMessage();
    		Gson gson = new Gson();
    	    String json = gson.toJson(message);
    		return new ResponseEntity<String>( json, HttpStatus.CREATED);
    	}
    	catch(Exception e){
    		Gson gson = new Gson();
    	    String json = gson.toJson(e.toString());
    		return new ResponseEntity<String>( json, HttpStatus.CREATED);
    	}
		
	}
    
    @RequestMapping(value = "/visitdata/{codigoCasoVisita}", method = RequestMethod.GET)
    public String obtenerDatosVisitaCaso(@PathVariable("codigoCasoVisita") String codigoCasoVisita, Model model) {
        logger.debug("Mostrando datos de un visita de caso monitoreo intensivo en JSP");
        VisitaSeguimientoCaso vsc = this.visitaSeguimientoCasoService.getVisitaSeguimientoCaso(codigoCasoVisita);
        ParticipanteCohorteFamiliaCaso participante = participanteCohorteFamiliaCasoService.getParticipanteCohorteFamiliaCasosByCodigo(vsc.getCodigoParticipanteCaso().getCodigoCasoParticipante());
        List<VisitaSeguimientoCasoSintomas> vsegsint = visitaSeguimientoCasoSintomasService.getVisitaSeguimientoCasoSintomas(codigoCasoVisita);
        List<FormularioContactoCaso> contactos = formularioContactoCasoService.getFormularioContactoCasos(codigoCasoVisita);
        model.addAttribute("participante",participante);
        model.addAttribute("visita",vsc);
        model.addAttribute("sintomas",vsegsint);
        model.addAttribute("contactos",contactos);
        return "/chfcasos/visitData";
    }
    
    @RequestMapping(value = "/newsint/{codigoCasoVisita}", method = RequestMethod.GET)
	public String initCreationSint(@PathVariable("codigoCasoVisita") String codigoCasoVisita, Model model) {
    	VisitaSeguimientoCaso vsc = this.visitaSeguimientoCasoService.getVisitaSeguimientoCaso(codigoCasoVisita);
    	List<MessageResource> sino = messageResourceService.getCatalogo("CHF_CAT_SINO");
    	model.addAttribute("visita",vsc);
    	model.addAttribute("sino",sino);
		return "/chfcasos/enterSint";
	}
    
    @RequestMapping(value = "editSint/{codigoCasoSintoma}/", method = RequestMethod.GET)
    public String initEditionSint(Model model, @PathVariable(value = "codigoCasoSintoma") String codigoCasoSintoma){
    	VisitaSeguimientoCasoSintomas vscs = this.visitaSeguimientoCasoSintomasService.getVisitaSeguimientoCasoSintoma(codigoCasoSintoma);
    	if (vscs!=null){
    		model.addAttribute("sintoma", vscs);
    		model.addAttribute("visita",vscs.getCodigoVisitaCaso());
    		List<MessageResource> sino = messageResourceService.getCatalogo("CHF_CAT_SND");
        	model.addAttribute("sino",sino);
    		return "/chfcasos/enterSint";
    	}
    	else{
    		return "404";
        }
    }  
    
    
    @RequestMapping( value="saveSint", method=RequestMethod.POST)
	public ResponseEntity<String> processSintForm( @RequestParam(value="codigoCasoSintoma", required=false, defaultValue="" ) String codigoCasoSintoma
			, @RequestParam( value="codigoCasoVisita", required=true ) String codigoCasoVisita
			, @RequestParam( value="fechaSintomas", required=true ) String fechaSintomas
			, @RequestParam( value="fiebre", required=true ) String fiebre
			, @RequestParam( value="fif", required=false, defaultValue="" ) String fif
			, @RequestParam( value="fiebreCuantificada", required=true ) String fiebreCuantificada
			, @RequestParam( value="valorFiebreCuantificada", required=false, defaultValue="" ) Float valorFiebreCuantificada
			, @RequestParam( value="dolorCabeza", required=true ) String dolorCabeza
			, @RequestParam( value="dolorArticular", required=true ) String dolorArticular
			, @RequestParam( value="dolorMuscular", required=true ) String dolorMuscular
			, @RequestParam( value="dificultadRespiratoria", required=true ) String dificultadRespiratoria
			, @RequestParam( value="secrecionNasal", required=true ) String secrecionNasal
			, @RequestParam( value="fsn", required=false, defaultValue="" ) String fsn
			, @RequestParam( value="tos", required=true ) String tos
			, @RequestParam( value="ftos", required=false, defaultValue="" ) String ftos
			, @RequestParam( value="pocoApetito", required=true ) String pocoApetito
			, @RequestParam( value="dolorGarganta", required=true ) String dolorGarganta
			, @RequestParam( value="frr", required=false, defaultValue="" ) String frr
			, @RequestParam( value="diarrea", required=true ) String diarrea
			, @RequestParam( value="quedoCama", required=true ) String quedoCama
			, @RequestParam( value="respiracionRuidosa", required=true ) String respiracionRuidosa
			, @RequestParam( value="oseltamivir", required=true ) String oseltamivir
			, @RequestParam( value="antibiotico", required=true ) String antibiotico
			, @RequestParam( value="cualAntibiotico", required=false, defaultValue="" ) String cualAntibiotico
			, @RequestParam( value="prescritoMedico", required=false, defaultValue="" ) String prescritoMedico
	        ){
    	try{
    		UserSistema usuario = usuarioService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
    		VisitaSeguimientoCaso vsc = this.visitaSeguimientoCasoService.getVisitaSeguimientoCaso(codigoCasoVisita);
    		VisitaSeguimientoCasoSintomas vscs = new VisitaSeguimientoCasoSintomas();
			//Si el codigoCasoSintoma viene en blanco es una nueva sintoma
			if (codigoCasoSintoma.equals("")){
				if (this.visitaSeguimientoCasoSintomasService.checkVisitaSeguimientoCasoSintomas(vsc.getCodigoParticipanteCaso().getCodigoCasoParticipante(), fechaSintomas)){
					MessageResource repetido = messageResourceService.getMensaje("sintDuplicated");
					Gson gson = new Gson();
		    	    String json = gson.toJson(repetido.getSpanish());
					return new ResponseEntity<String>( json, HttpStatus.CREATED);
				}
				//Crear un nuevo VisitaSeguimientoCaso
				codigoCasoSintoma = new UUID(usuario.getUsername().hashCode(),new Date().hashCode()).toString();
				vscs.setCodigoCasoSintoma(codigoCasoSintoma);
				vscs.setCodigoVisitaCaso(vsc);
				vscs.setRecordUser(usuario.getUsername());
				vscs.setRecordDate(new Date());
				WebAuthenticationDetails wad  = (WebAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
	        	String idSesion = wad.getSessionId();
	        	String direccionIp = wad.getRemoteAddress();
				vscs.setDeviceid(idSesion + "-"+ direccionIp);
				vscs.setEstado('1');
			}
			//Si el codigoCasoSintoma no viene en blanco hay que editar la sintoma
			else{
				//Recupera el sintoma de la base de datos
				vscs = this.visitaSeguimientoCasoSintomasService.getVisitaSeguimientoCasoSintoma(codigoCasoSintoma);
			}
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        	Date date1 = formatter.parse(fechaSintomas);
        	vscs.setFechaSintomas(date1);
			vscs.setFiebre(fiebre);
			if(!fif.equals("")){
				date1 = formatter.parse(fif);
				vscs.setFif(date1);
			}
			vscs.setFiebreCuantificada(fiebreCuantificada);
			vscs.setValorFiebreCuantificada(valorFiebreCuantificada);
			vscs.setDolorCabeza(dolorCabeza);
			vscs.setDolorArticular(dolorArticular);
			vscs.setDolorMuscular(dolorMuscular);
			vscs.setDificultadRespiratoria(dificultadRespiratoria);
			vscs.setSecrecionNasal(secrecionNasal);
			if(!fsn.equals("")){
				date1 = formatter.parse(fsn);
				vscs.setFsn(date1);
			}
			vscs.setTos(tos);
			if(!ftos.equals("")){
				date1 = formatter.parse(ftos);
				vscs.setFtos(date1);
			}
			vscs.setPocoApetito(pocoApetito);
			vscs.setDolorGarganta(dolorGarganta);
			if(!frr.equals("")){
				date1 = formatter.parse(frr);
				vscs.setFrr(date1);
			}
			vscs.setDiarrea(diarrea);
			vscs.setQuedoCama(quedoCama);
			vscs.setRespiracionRuidosa(respiracionRuidosa);
			vscs.setOseltamivir(oseltamivir);
			vscs.setAntibiotico(antibiotico);
			vscs.setCualAntibiotico(cualAntibiotico);
			vscs.setPrescritoMedico(prescritoMedico);
			//Actualiza la sintoma
			this.visitaSeguimientoCasoSintomasService.saveOrUpdateVisitaSeguimientoCasoSintomas(vscs);
			return createJsonResponse(vscs);
    	}
    	catch (DataIntegrityViolationException e){
    		String message = e.getMostSpecificCause().getMessage();
    		Gson gson = new Gson();
    	    String json = gson.toJson(message);
    		return new ResponseEntity<String>( json, HttpStatus.CREATED);
    	}
    	catch(Exception e){
    		Gson gson = new Gson();
    	    String json = gson.toJson(e.toString());
    		return new ResponseEntity<String>( json, HttpStatus.CREATED);
    	}
		
	}
    
    
    @RequestMapping(value = "/newcont/{codigoCasoVisita}", method = RequestMethod.GET)
	public String initCreationCont(@PathVariable("codigoCasoVisita") String codigoCasoVisita, Model model) {
    	VisitaSeguimientoCaso vsc = this.visitaSeguimientoCasoService.getVisitaSeguimientoCaso(codigoCasoVisita);
    	List<MessageResource> tiempoCat = messageResourceService.getCatalogo("CHF_CAT_TIEMPO_INTERACCION");
    	List<MessageResource> tipoCat = messageResourceService.getCatalogo("CHF_CAT_TIPO_INTERACCION");
    	List<ParticipanteCohorteFamiliaCaso> participantes = participanteCohorteFamiliaCasoService.getParticipantesCohorteFamiliaCasoByCodigoCaso(vsc.getCodigoParticipanteCaso().getCodigoCaso().getCodigoCaso());
    	participantes.remove(vsc.getCodigoParticipanteCaso());
        model.addAttribute("participantes",participantes);
    	model.addAttribute("visita",vsc);
    	model.addAttribute("tiempoCat",tiempoCat);
    	model.addAttribute("tipoCat",tipoCat);
		return "/chfcasos/enterCont";
	}
    
    private ResponseEntity<String> createJsonResponse( Object o ){
	    HttpHeaders headers = new HttpHeaders();
	    headers.set("Content-Type", "application/json");
	    Gson gson = new Gson();
	    String json = gson.toJson(o);
	    return new ResponseEntity<String>( json, headers, HttpStatus.CREATED );
	}

       
}
