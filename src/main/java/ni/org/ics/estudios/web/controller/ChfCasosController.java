package ni.org.ics.estudios.web.controller;


import ni.org.ics.estudios.domain.cohortefamilia.ParticipanteCohorteFamilia;
import ni.org.ics.estudios.domain.cohortefamilia.casos.CasaCohorteFamiliaCaso;
import ni.org.ics.estudios.domain.cohortefamilia.casos.FormularioContactoCaso;
import ni.org.ics.estudios.domain.cohortefamilia.casos.ParticipanteCohorteFamiliaCaso;
import ni.org.ics.estudios.domain.cohortefamilia.casos.VisitaFallidaCaso;
import ni.org.ics.estudios.domain.cohortefamilia.casos.VisitaSeguimientoCaso;
import ni.org.ics.estudios.domain.cohortefamilia.casos.VisitaSeguimientoCasoSintomas;
import ni.org.ics.estudios.language.MessageResource;
import ni.org.ics.estudios.service.MessageResourceService;
import ni.org.ics.estudios.service.UsuarioService;
import ni.org.ics.estudios.service.cohortefamilia.ParticipanteCohorteFamiliaService;
import ni.org.ics.estudios.service.cohortefamilia.casos.CasaCohorteFamiliaCasoService;
import ni.org.ics.estudios.service.cohortefamilia.casos.FormularioContactoCasoService;
import ni.org.ics.estudios.service.cohortefamilia.casos.ParticipanteCohorteFamiliaCasoService;
import ni.org.ics.estudios.service.cohortefamilia.casos.VisitaFallidaCasoService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    @Resource(name = "participanteCohorteFamiliaService")
    private ParticipanteCohorteFamiliaService participanteCohorteFamiliaService;
    @Resource(name = "visitaSeguimientoCasoService")
    private VisitaSeguimientoCasoService visitaSeguimientoCasoService;
    @Resource(name = "visitaFallidaCasoService")
    private VisitaFallidaCasoService visitaFallidaCasoService;
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
    
    @RequestMapping(value = "/participants/{codigoCaso}/", method = RequestMethod.GET)
    public String obtenerParticipantesCaso(@PathVariable("codigoCaso") String codigoCaso, Model model) {
    	CasaCohorteFamiliaCaso caso = casaCohorteFamiliaCasoService.getCasaCohorteFamiliaCasosByCodigo(codigoCaso);
    	List<ParticipanteCohorteFamiliaCaso> participantes = participanteCohorteFamiliaCasoService.getParticipantesCohorteFamiliaCasoByCodigoCaso(codigoCaso);
        model.addAttribute("caso",caso);
        model.addAttribute("participantes",participantes);
        return "/chfcasos/participantsList";
    }
    
    
    @RequestMapping(value = "/participantdata/{codigo}/", method = RequestMethod.GET)
    public String obtenerDatosParticipanteCaso(@PathVariable("codigo") String codigo, Model model) {
        logger.debug("Mostrando datos de un participante de caso monitoreo intensivo en JSP");
        ParticipanteCohorteFamiliaCaso participante = participanteCohorteFamiliaCasoService.getParticipanteCohorteFamiliaCasosByCodigo(codigo);
        List<VisitaSeguimientoCaso> vseg = visitaSeguimientoCasoService.getVisitaSeguimientoCasos(codigo);
        List<VisitaFallidaCaso> vfall = this.visitaFallidaCasoService.getVisitaFallidaCasos(codigo);
        model.addAttribute("participante",participante);
        model.addAttribute("visitas",vseg);
        model.addAttribute("fallidas",vfall);
        return "/chfcasos/participantData";
    }
    
    @RequestMapping(value = "/newvisit/{codigo}/", method = RequestMethod.GET)
	public String initCreationVisit(@PathVariable("codigo") String codigo, Model model) {
    	ParticipanteCohorteFamiliaCaso participante = participanteCohorteFamiliaCasoService.getParticipanteCohorteFamiliaCasosByCodigo(codigo);
    	List<MessageResource> visitas = messageResourceService.getCatalogo("CHF_CAT_VIS_MI");
    	List<MessageResource> sino = messageResourceService.getCatalogo("CHF_CAT_SINO");
    	model.addAttribute("participante",participante);
    	model.addAttribute("visitas",visitas);
    	model.addAttribute("sino",sino);
		return "/chfcasos/enterVisit";
	}
    
    @RequestMapping(value = "/editVisit/{codigoCasoVisita}/", method = RequestMethod.GET)
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
    
    /**
     * Custom handler for enabling/disabling a visit.
     *
     * @param username the ID of the visit to enable
     * @return a String
     */
    @RequestMapping("/voidVisit/{accion}/{codigoCasoVisita}")
    public String initDeletionVisit(@PathVariable("codigoCasoVisita") String codigoCasoVisita, 
    		@PathVariable("accion") String accion, RedirectAttributes redirectAttributes) {
    	String redirecTo="404";
    	UserSistema usuarioActual = this.usuarioService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
    	VisitaSeguimientoCaso vsc = this.visitaSeguimientoCasoService.getVisitaSeguimientoCaso(codigoCasoVisita);
    	
    	char hab;
    	if (accion.matches("enable")){
        	redirecTo = "redirect:/chf/editarcaso/participantdata/"+vsc.getCodigoParticipanteCaso().getCodigoCasoParticipante()+"/";
    		hab = '0';
    		redirectAttributes.addFlashAttribute("visitaHabilitado", true);
        }
        else if(accion.matches("disable")){
        	redirecTo = "redirect:/chf/editarcaso/participantdata/"+vsc.getCodigoParticipanteCaso().getCodigoCasoParticipante()+"/";
    		hab = '1';
    		redirectAttributes.addFlashAttribute("visitaDeshabilitado", true);
        }
        else{
        	return redirecTo;
        }
    	if(vsc!=null){
    		vsc.setRecordDate(new Date());
    		vsc.setRecordUser(usuarioActual.getUsername());
    		vsc.setPasive(hab);
    		this.visitaSeguimientoCasoService.saveOrUpdateVisitaSeguimientoCaso(vsc);
    	}
    	return redirecTo;	
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
			vsc.setRecordUser(usuario.getUsername());
			vsc.setRecordDate(new Date());
			WebAuthenticationDetails wad  = (WebAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
        	String idSesion = wad.getSessionId();
        	String direccionIp = wad.getRemoteAddress();
			vsc.setDeviceid(idSesion + "-"+ direccionIp);
			vsc.setEstado('1');
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
    	List<MessageResource> sino = messageResourceService.getCatalogo("CHF_CAT_SND");
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
			vscs.setRecordUser(usuario.getUsername());
			vscs.setRecordDate(new Date());
			WebAuthenticationDetails wad  = (WebAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
        	String idSesion = wad.getSessionId();
        	String direccionIp = wad.getRemoteAddress();
			vscs.setDeviceid(idSesion + "-"+ direccionIp);
			vscs.setEstado('1');
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
    
    @RequestMapping(value = "editCont/{codigoCasoContacto}/", method = RequestMethod.GET)
    public String initEditionCont(Model model, @PathVariable(value = "codigoCasoContacto") String codigoCasoContacto){
    	FormularioContactoCaso fcc = this.formularioContactoCasoService.getFormularioContactoCaso(codigoCasoContacto);
    	if (fcc!=null){
    		model.addAttribute("contacto", fcc);
    		model.addAttribute("visita",fcc.getCodigoVisitaCaso());
    		List<MessageResource> tiempoCat = messageResourceService.getCatalogo("CHF_CAT_TIEMPO_INTERACCION");
        	List<MessageResource> tipoCat = messageResourceService.getCatalogo("CHF_CAT_TIPO_INTERACCION");
        	List<ParticipanteCohorteFamiliaCaso> participantes = participanteCohorteFamiliaCasoService.getParticipantesCohorteFamiliaCasoByCodigoCaso(fcc.getCodigoVisitaCaso().getCodigoParticipanteCaso().getCodigoCaso().getCodigoCaso());
        	participantes.remove(fcc.getCodigoVisitaCaso().getCodigoParticipanteCaso());
            model.addAttribute("participantes",participantes);
        	model.addAttribute("tiempoCat",tiempoCat);
        	model.addAttribute("tipoCat",tipoCat);
    		return "/chfcasos/enterCont";
    	}
    	else{
    		return "404";
        }
    }  
    
    @RequestMapping( value="saveCont", method=RequestMethod.POST)
	public ResponseEntity<String> processContForm( @RequestParam(value="codigoCasoContacto", required=false, defaultValue="" ) String codigoCasoContacto
			, @RequestParam( value="codigoCasoVisita", required=true ) String codigoCasoVisita
			, @RequestParam( value="fechaContacto", required=true ) String fechaContacto
			, @RequestParam( value="partContacto", required=true ) Integer partContacto
			, @RequestParam( value="tiempoInteraccion", required=true ) String tiempoInteraccion
			, @RequestParam( value="tipoInteraccion", required=false, defaultValue="" ) String tipoInteraccion
	        ){
    	try{
    		UserSistema usuario = usuarioService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
    		VisitaSeguimientoCaso vsc = this.visitaSeguimientoCasoService.getVisitaSeguimientoCaso(codigoCasoVisita);
    		FormularioContactoCaso fc = new FormularioContactoCaso();
			//Si el codigoCasoContacto viene en blanco es un nuevo contacto
			if (codigoCasoContacto.equals("")){
				if (this.formularioContactoCasoService.checkContactoCasoSintomas(vsc.getCodigoParticipanteCaso().getParticipante().getParticipante().getCodigo(), fechaContacto, partContacto)){
					MessageResource repetido = messageResourceService.getMensaje("contDuplicated");
					Gson gson = new Gson();
		    	    String json = gson.toJson(repetido.getSpanish());
					return new ResponseEntity<String>( json, HttpStatus.CREATED);
				}
				//Crear un nuevo FormularioContactoCaso
				codigoCasoContacto = new UUID(usuario.getUsername().hashCode(),new Date().hashCode()).toString();
				fc.setCodigoCasoContacto(codigoCasoContacto);
				fc.setCodigoVisitaCaso(vsc);
			}
			//Si el codigoCasoContacto no viene en blanco hay que editar el contacto
			else{
				//Recupera el contacto de la base de datos
				fc = this.formularioContactoCasoService.getFormularioContactoCaso(codigoCasoContacto);
			}
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        	Date date1 = formatter.parse(fechaContacto);
        	fc.setFechaContacto(date1);
        	ParticipanteCohorteFamilia participante = participanteCohorteFamiliaService.getParticipanteCHFByCodigo(partContacto);
        	fc.setPartContacto(participante);
			fc.setTiempoInteraccion(tiempoInteraccion);
			fc.setTipoInteraccion(tipoInteraccion);
			fc.setRecordUser(usuario.getUsername());
			fc.setRecordDate(new Date());
			WebAuthenticationDetails wad  = (WebAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
        	String idSesion = wad.getSessionId();
        	String direccionIp = wad.getRemoteAddress();
			fc.setDeviceid(idSesion + "-"+ direccionIp);
			fc.setEstado('1');
			//Actualiza el contacto
			this.formularioContactoCasoService.saveOrUpdateFormularioContactoCaso(fc);
			return createJsonResponse(fc);
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
    
    
    @RequestMapping(value = "/newfailvisit/{codigoCaso}", method = RequestMethod.GET)
	public String initCreationFailVisit(@PathVariable("codigoCaso") String codigoCaso, Model model) {
    	CasaCohorteFamiliaCaso caso = casaCohorteFamiliaCasoService.getCasaCohorteFamiliaCasosByCodigo(codigoCaso);
    	List<MessageResource> razones = messageResourceService.getCatalogo("CHF_CAT_VISITA_NO_C");
    	model.addAttribute("caso",caso);
    	model.addAttribute("razones",razones);
		return "/chfcasos/enterFailVisit";
	}
    
    @RequestMapping(value = "/newfailvisitpart/{codigoCasoParticipante}", method = RequestMethod.GET)
	public String initCreationFailVisitPart(@PathVariable("codigoCasoParticipante") String codigoCasoParticipante, Model model) {
    	ParticipanteCohorteFamiliaCaso participante = participanteCohorteFamiliaCasoService.getParticipanteCohorteFamiliaCasosByCodigo(codigoCasoParticipante);
    	List<MessageResource> razones = messageResourceService.getCatalogo("CHF_CAT_VISITA_NO_P");
    	model.addAttribute("participante",participante);
    	model.addAttribute("razones",razones);
		return "/chfcasos/enterFailVisitPart";
	}
    
    
    @RequestMapping(value = "editfailvisit/{codigoFallaVisita}/", method = RequestMethod.GET)
    public String initEditionFailVisit(Model model, @PathVariable(value = "codigoFallaVisita") String codigoFallaVisita){
    	VisitaFallidaCaso vfc = this.visitaFallidaCasoService.getVisitaFallidaCaso(codigoFallaVisita);
    	if (vfc!=null){
    		model.addAttribute("visitafallida", vfc);
    		ParticipanteCohorteFamiliaCaso participante = participanteCohorteFamiliaCasoService.getParticipanteCohorteFamiliaCasosByCodigo(vfc.getCodigoParticipanteCaso().getCodigoCasoParticipante());
    		model.addAttribute("participante",participante);
    		List<MessageResource> razones = messageResourceService.getCatalogo("CHF_CAT_VISITA_NO_P");
    		model.addAttribute("razones",razones);
    		return "/chfcasos/enterFailVisitPart";
    	}
    	else{
    		return "404";
        }
    }
    
    
    @RequestMapping( value="saveCasoFailVisit", method=RequestMethod.POST)
	public ResponseEntity<String> processFailVisitForm( @RequestParam(value="codigoCaso", required=false, defaultValue="" ) String codigo
			, @RequestParam( value="fechaVisita", required=true ) String fechaVisita
			, @RequestParam( value="horaVisita", required=true ) String horaVisita
			, @RequestParam( value="razonVisitaFallida", required=true ) String razonVisitaFallida
			, @RequestParam( value="otraRazon", required=false, defaultValue="" ) String otraRazon
			){
    	try{
    		UserSistema usuario = usuarioService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
    		CasaCohorteFamiliaCaso caso = casaCohorteFamiliaCasoService.getCasaCohorteFamiliaCasosByCodigo(codigo);
    		List<ParticipanteCohorteFamiliaCaso> participantes = participanteCohorteFamiliaCasoService.getParticipantesCohorteFamiliaCasoByCodigoCaso(codigo);
    		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        	Date date1 = formatter.parse(fechaVisita+" "+horaVisita);
        	WebAuthenticationDetails wad  = (WebAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
        	String idSesion = wad.getSessionId();
        	String direccionIp = wad.getRemoteAddress();
    		for (ParticipanteCohorteFamiliaCaso part:participantes){
    			VisitaFallidaCaso vfc = new VisitaFallidaCaso();
    			vfc.setCodigoFallaVisita(new UUID(usuario.getUsername().hashCode(),new Date().hashCode()).toString());
    			vfc.setCodigoParticipanteCaso(part);
    			vfc.setFechaVisita(date1);
    			vfc.setRecordUser(usuario.getUsername());
    			vfc.setRecordDate(new Date());
    			vfc.setDeviceid(idSesion + "-"+ direccionIp);
    			vfc.setEstado('1');
    			vfc.setRazonVisitaFallida(razonVisitaFallida);
    			vfc.setOtraRazon(otraRazon);
    			//Actualiza la visita
    			this.visitaFallidaCasoService.saveOrUpdateVisitaFallidaCaso(vfc);
    		}
    		return createJsonResponse(caso);
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
    
    
    @RequestMapping( value="saveCasoFailVisitPart", method=RequestMethod.POST)
	public ResponseEntity<String> processFailVisitPartForm( @RequestParam(value="codigoFallaVisita", required=false, defaultValue="" ) String codigoFallaVisita
			, @RequestParam( value="codigoParticipanteCaso", required=true ) String codigoParticipanteCaso
			, @RequestParam( value="fechaVisita", required=true ) String fechaVisita
			, @RequestParam( value="horaVisita", required=true ) String horaVisita
			, @RequestParam( value="razonVisitaFallida", required=true ) String razonVisitaFallida
			, @RequestParam( value="otraRazon", required=false, defaultValue="" ) String otraRazon
	        ){
    	try{
    		UserSistema usuario = usuarioService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
    		ParticipanteCohorteFamiliaCaso participante = participanteCohorteFamiliaCasoService.getParticipanteCohorteFamiliaCasosByCodigo(codigoParticipanteCaso);
    		VisitaFallidaCaso vfc = new VisitaFallidaCaso();
			//Si el codigoFallaVisita viene en blanco es un nuevo visita
			if (codigoFallaVisita.equals("")){
				//Crear un nuevo VisitaFallidaCaso
				codigoFallaVisita = new UUID(usuario.getUsername().hashCode(),new Date().hashCode()).toString();
				vfc.setCodigoFallaVisita(codigoFallaVisita);
				vfc.setCodigoParticipanteCaso(participante);
			}
			//Si el codigoFallaVisita no viene en blanco hay que editar el visita
			else{
				//Recupera el visita de la base de datos
				vfc = this.visitaFallidaCasoService.getVisitaFallidaCaso(codigoFallaVisita);
			}
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        	Date date1 = formatter.parse(fechaVisita+" "+horaVisita);
        	vfc.setFechaVisita(date1);
			vfc.setRecordUser(usuario.getUsername());
			vfc.setRecordDate(new Date());
			WebAuthenticationDetails wad  = (WebAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
			String idSesion = wad.getSessionId();
        	String direccionIp = wad.getRemoteAddress();
			vfc.setDeviceid(idSesion + "-"+ direccionIp);
			vfc.setEstado('1');
			vfc.setRazonVisitaFallida(razonVisitaFallida);
			vfc.setOtraRazon(otraRazon);
			//Actualiza el contacto
			this.visitaFallidaCasoService.saveOrUpdateVisitaFallidaCaso(vfc);
			return createJsonResponse(vfc);
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
    
    private ResponseEntity<String> createJsonResponse( Object o ){
	    HttpHeaders headers = new HttpHeaders();
	    headers.set("Content-Type", "application/json");
	    Gson gson = new Gson();
	    String json = gson.toJson(o);
	    return new ResponseEntity<String>( json, headers, HttpStatus.CREATED );
	}

       
}
