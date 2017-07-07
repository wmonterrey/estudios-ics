package ni.org.ics.estudios.web.controller;

import com.google.gson.Gson;
import ni.org.ics.estudios.domain.cohortefamilia.ParticipanteCohorteFamilia;
import ni.org.ics.estudios.domain.cohortefamilia.casos.CasaCohorteFamiliaCaso;
import ni.org.ics.estudios.domain.cohortefamilia.casos.ParticipanteCohorteFamiliaCaso;
import ni.org.ics.estudios.domain.scancarta.VersionCarta;
import ni.org.ics.estudios.language.MessageResource;
import ni.org.ics.estudios.service.MessageResourceService;
import ni.org.ics.estudios.service.cohortefamilia.CasaCohorteFamiliaService;
import ni.org.ics.estudios.service.cohortefamilia.ParticipanteCohorteFamiliaService;
import ni.org.ics.estudios.service.cohortefamilia.casos.CasaCohorteFamiliaCasoService;
import ni.org.ics.estudios.service.cohortefamilia.casos.ParticipanteCohorteFamiliaCasoService;
import ni.org.ics.estudios.web.utils.DateUtil;
import org.apache.commons.lang3.text.translate.UnicodeEscaper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Miguel Salinas on 6/28/2017.
 * V1.0
 */
@Controller
@RequestMapping("/super/casacaso/*")
public class CasaCohorteFamiliaCasoWController {

    private static final Logger logger = LoggerFactory.getLogger(CasaCohorteFamiliaCasoWController.class);

    @Resource(name = "casaCohorteFamiliaCasoService")
    private CasaCohorteFamiliaCasoService casaCohorteFamiliaCasoService;

    @Resource(name = "participanteCohorteFamiliaCasoService")
    private ParticipanteCohorteFamiliaCasoService participanteCohorteFamiliaCasoService;

    @Resource(name = "casaCohorteFamiliaService")
    private CasaCohorteFamiliaService casaCohorteFamiliaService;

    @Resource(name = "participanteCohorteFamiliaService")
    private ParticipanteCohorteFamiliaService participanteCohorteFamiliaService;

    @Resource(name = "messageResourceService")
    private MessageResourceService messageResourceService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String obtenerCasos(Model model) throws ParseException {
        logger.debug("Mostrando casos monitoreo intensivo en JSP");
        List<ParticipanteCohorteFamiliaCaso> casos = participanteCohorteFamiliaCasoService.getParticipanteCohorteFamiliaCasosPositivos();
        List<MessageResource> visitas = messageResourceService.getCatalogo("CHF_CAT_VIS_MI");
        List<MessageResource> tiposEtiquetas = messageResourceService.getCatalogo("CHF_CAT_TIP_ETIQ_MI");
        model.addAttribute("casos",casos);
        model.addAttribute("visitas", visitas);
        model.addAttribute("etiquetas", tiposEtiquetas);
        return "/supervisor/casos/list";
    }

    @RequestMapping(value = "/participants/{codigo}", method = RequestMethod.GET)
    public String obtenerParticipantesCaso(@PathVariable("codigo") String codigo, Model model) throws ParseException {
        logger.debug("Mostrando participantes de caso monitoreo intensivo en JSP");
        List<ParticipanteCohorteFamiliaCaso> participantes = participanteCohorteFamiliaCasoService.getParticipantesCohorteFamiliaCasoByCodigoCaso(codigo);
        model.addAttribute("participantes",participantes);
        model.addAttribute("caso", participantes.get(0).getCodigoCaso());
        return "/supervisor/casos/participantsList";
    }

    @RequestMapping(value = "newCase", method = RequestMethod.GET)
    public String initAddCaseForm(Model model) {
        model.addAttribute("agregando",true);
        model.addAttribute("editando",false);
        model.addAttribute("caso", new ParticipanteCohorteFamiliaCaso());
        return "/supervisor/casos/enterForm";
    }

    @RequestMapping(value = "editCase/{codigo}", method = RequestMethod.GET)
    public String initEditCaseForm(@PathVariable("codigo") String codigo, Model model) {
        ParticipanteCohorteFamiliaCaso participanteCaso = this.participanteCohorteFamiliaCasoService.getParticipanteCohorteFamiliaCasosByCodigo(codigo);
        model.addAttribute("agregando",false);
        model.addAttribute("editando",true);
        model.addAttribute("caso", participanteCaso);
        return "/supervisor/casos/enterForm";
    }

    @RequestMapping( value="saveCase", method=RequestMethod.POST)
    public ResponseEntity<String> processUpdateUserForm( @RequestParam(value="codigo", required=true ) String codigo
            , @RequestParam( value="codigoCasa", required=true ) String codigoCasa
            , @RequestParam( value="fechaInicio", required=false ) String fechaInicio
            , @RequestParam( value="codigoParticipante", required=false, defaultValue="" ) Integer codigoParticipante
            , @RequestParam( value="fif", required=true, defaultValue="" ) String fif
    )
    {
        CasaCohorteFamiliaCaso casaCasoExistente = null;
        try{
            Date dFechaInicio = DateUtil.StringToDate(fechaInicio, "dd/MM/yyyy");
            casaCasoExistente = this.casaCohorteFamiliaCasoService.getCasaCohorteFamiliaCasosByCodigoCasaFecha(codigoCasa,dFechaInicio);
            CasaCohorteFamiliaCaso casaCaso = this.casaCohorteFamiliaCasoService.getCasaCohorteFamiliaCasosByCodigo(codigo);
            /*if (casaCasoExistente!=null && codigo.isEmpty())
                return createJsonResponse("Ya existe un caso positivo para esta casa");
*/
            if (casaCasoExistente==null) {
                if (casaCaso == null) {
                    casaCaso = new CasaCohorteFamiliaCaso();
                    casaCaso.setCodigoCaso(getCadenaAlfanumAleatoria(36, true));

                }
                casaCaso.setCasa(casaCohorteFamiliaService.getCasasCHFByCodigo(codigoCasa));
                casaCaso.setFechaInicio(dFechaInicio);
                casaCaso.setEstado('1');
                casaCaso.setPasive('0');
                casaCaso.setInactiva("0");
                casaCaso.setRecordDate(new Date());
                casaCaso.setRecordUser(SecurityContextHolder.getContext().getAuthentication().getName());

                this.casaCohorteFamiliaCasoService.saveOrUpdateCasaCohorteFamiliaCaso(casaCaso);
            }else {
                casaCaso = casaCasoExistente;
            }
            //agregar paticipante positivo
            ParticipanteCohorteFamiliaCaso participanteCaso = this.participanteCohorteFamiliaCasoService.getParticipanteCohorteFamiliaCasosByParticipante(codigoParticipante);
            if(participanteCaso==null){
                participanteCaso = new ParticipanteCohorteFamiliaCaso();
                participanteCaso.setCodigoCasoParticipante(getCadenaAlfanumAleatoria(36, true));
            }
            participanteCaso.setParticipante(this.participanteCohorteFamiliaService.getParticipanteCHFByCodigo(codigoParticipante));
            participanteCaso.setCodigoCaso(casaCaso);
            participanteCaso.setEstado('1');
            participanteCaso.setEnfermo("S");
            participanteCaso.setFechaEnfermedad(DateUtil.StringToDate(fif, "dd/MM/yyyy"));
            participanteCaso.setPasive('0');
            participanteCaso.setRecordDate(new Date());
            participanteCaso.setRecordUser(SecurityContextHolder.getContext().getAuthentication().getName());
            this.participanteCohorteFamiliaCasoService.saveOrUpdateParticipanteCohorteFamiliaCaso(participanteCaso);

            //Agregar resto de participantes de la casa
            List<ParticipanteCohorteFamilia> participantesCasa = participanteCohorteFamiliaService.getParticipantesCHFByCodigoCasa(codigoCasa);
            for(ParticipanteCohorteFamilia participante : participantesCasa){
                //como son todos los de la casa, se omite el positivo
                if (!participante.getParticipante().getCodigo().equals(codigoParticipante)) {
                    participanteCaso = this.participanteCohorteFamiliaCasoService.getParticipanteCohorteFamiliaCasosByParticipante(participante.getParticipante().getCodigo());
                    if (participanteCaso == null) {
                        participanteCaso = new ParticipanteCohorteFamiliaCaso();
                        participanteCaso.setCodigoCasoParticipante(getCadenaAlfanumAleatoria(36, true));
                        participanteCaso.setEnfermo("N");
                        participanteCaso.setFechaEnfermedad(null);
                    }
                    participanteCaso.setParticipante(participante);
                    participanteCaso.setCodigoCaso(casaCaso);
                    participanteCaso.setEstado('1');
                    participanteCaso.setPasive('0');
                    participanteCaso.setRecordDate(new Date());
                    participanteCaso.setRecordUser(SecurityContextHolder.getContext().getAuthentication().getName());
                    this.participanteCohorteFamiliaCasoService.saveOrUpdateParticipanteCohorteFamiliaCaso(participanteCaso);
                }
            }

            return createJsonResponse(casaCaso);
        }
        catch(Exception e){
            Gson gson = new Gson();
            String json = gson.toJson(e.toString());
            return new ResponseEntity<String>( json, HttpStatus.CREATED);
        }
    }

    private ResponseEntity<String> createJsonResponse( String mensaje )
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("mensaje", mensaje);
        Gson gson = new Gson();
        String json = gson.toJson(map);
        UnicodeEscaper escaper = UnicodeEscaper.above(127);
        json = escaper.translate(json);
        return new ResponseEntity<String>( json, HttpStatus.CREATED);
    }

    private ResponseEntity<String> createJsonResponse( Object o )
    {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        Gson gson = new Gson();
        String json = gson.toJson(o);
        UnicodeEscaper escaper = UnicodeEscaper.above(127);
        json = escaper.translate(json);
        return new ResponseEntity<String>( json, headers, HttpStatus.CREATED );
    }

    private String getCadenaAlfanumAleatoria (int longitud, boolean usarSeparador){
        StringBuilder  cadenaAleatoria = new StringBuilder();
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        int longitudSeparador = 0;
        while ( i < longitud){
            if (usarSeparador && longitudSeparador==4){
                cadenaAleatoria.append("-");
                i++;
                longitudSeparador=0;
            }else {
                char c = (char) r.nextInt(255);
                if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                    cadenaAleatoria.append(c);
                    i++;
                    longitudSeparador++;
                }
            }
        }
        return cadenaAleatoria.toString();
    }
}
