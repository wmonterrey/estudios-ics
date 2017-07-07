package ni.org.ics.estudios.web.controller;

import com.google.gson.Gson;
import ni.org.ics.estudios.domain.Participante;
import ni.org.ics.estudios.domain.cohortefamilia.ParticipanteCohorteFamilia;
import ni.org.ics.estudios.domain.cohortefamilia.casos.ParticipanteCohorteFamiliaCaso;
import ni.org.ics.estudios.service.ParticipanteService;
import ni.org.ics.estudios.service.cohortefamilia.ParticipanteCohorteFamiliaService;
import ni.org.ics.estudios.service.cohortefamilia.casos.ParticipanteCohorteFamiliaCasoService;
import ni.org.ics.estudios.web.utils.DateUtil;
import org.apache.commons.lang3.text.translate.UnicodeEscaper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.*;

/**
 * Created by Miguel Salinas on 6/28/2017.
 * V1.0
 */
@Controller
@RequestMapping("/super/particaso/*")
public class ParticipanteCohorteFamiliaCasoWebController {

    private static final Logger logger = LoggerFactory.getLogger(ParticipanteCohorteFamiliaCasoWebController.class);

    @Resource(name = "participanteCohorteFamiliaCasoService")
    private ParticipanteCohorteFamiliaCasoService participanteCohorteFamiliaCasoService;

    @Resource(name = "participanteCohorteFamiliaService")
    private ParticipanteCohorteFamiliaService participanteCohorteFamiliaService;

    @Resource(name = "participanteService")
    private ParticipanteService participanteService;

    @RequestMapping(value = "searchParticipant", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ResponseEntity<String> buscarParticipante(@RequestParam(value="participantCode", required=true ) Integer codigo) throws ParseException {
        logger.debug("buscar participanteChf para monitoreo intensivo");
        ParticipanteCohorteFamilia participanteChf = participanteCohorteFamiliaService.getParticipanteCHFByCodigo(codigo);
        if (participanteChf==null) {
            Participante participante = participanteService.getParticipanteByCodigo(codigo);
            if (participante!=null)
                return createJsonResponse("Participante aún no ha sido enrolado");
            return createJsonResponse("No se encontró participante según el código ingresado");
        }else{
            ParticipanteCohorteFamiliaCaso participanteCaso = this.participanteCohorteFamiliaCasoService.getParticipanteCohorteFamiliaCasosByParticipantePos(codigo);
            if (participanteCaso!=null)
                return createJsonResponse("Participante ya fue registrado como positivo en la casa: "+participanteCaso.getCodigoCaso().getCasa().getCodigoCHF());
        }
            return createJsonResponse(participanteChf);
    }

    @RequestMapping(value = "getParticipantsCasos", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ResponseEntity<String> buscarParticipantesByCasa(@RequestParam(value="casas", required=true ) String casas) throws ParseException {
        logger.debug("buscar participantes de las casas para monitoreo intensivo");
        //Map<String, Object> map = new HashMap<String, Object>();
        Map<String, String> map = new HashMap<String, String>();
        String[] codigosCasas = casas.split(",");
        int indice = 0;
        for(String codigoCasa : codigosCasas){
            List<ParticipanteCohorteFamiliaCaso> participantesCasos = participanteCohorteFamiliaCasoService.getParticipantesCohorteFamiliaCasoByCodigoCasa(codigoCasa);
            List<String> codigoLineal = new ArrayList<String>();
            for(ParticipanteCohorteFamiliaCaso participante : participantesCasos){
                String codigo="";
                if (participante.getEnfermo().equalsIgnoreCase("S")) {
                    codigo = DateUtil.DateToString(participante.getFechaEnfermedad(), "dd/MM/yyyy") +
                            DateUtil.DateToString(new Date(), "dd/MM/yyyy");
                } else {
                    codigo = "10/10/3000" + DateUtil.DateToString(new Date(), "dd/MM/yyyy");
                }
                //*1*1 indica que es una copia del estiquer y es tipo QRCode
                //El formato para los tipo QRCode es: <fechafif><fechaHoy>*<codigolab>*<codigocasa>*<copias>*<tipo>
                codigo+="*"+participante.getParticipante().getParticipante().getCodigo()+ ".01.T*" +
                        participante.getCodigoCaso().getCasa().getCodigoCHF()+"*1*1";
                //se agrega en esta lista, para agregarlos al final de la casa
                //*1*2 indica que es una copia del estiquer y es tipo Codabar
                //El formato para los tipo Codabar es: <codigoparticipante>*<copias>*<tipo>
                codigoLineal.add(participante.getParticipante().getParticipante().getCodigo()+"*1*2");
                indice++;
                map.put("CODIGO"+indice, codigo);
            }
            for(String codigo : codigoLineal){
                indice++;
                map.put("CODIGO"+indice, codigo);
            }
        }
        map.put("TOTAL", String.valueOf(indice));
        return createJsonResponse(map);
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

}
