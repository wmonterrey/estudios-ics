package ni.org.ics.estudios.web.controller;

import com.google.gson.Gson;
import ni.org.ics.estudios.domain.catalogs.Estudio;
import ni.org.ics.estudios.domain.scancarta.VersionCarta;
import ni.org.ics.estudios.language.MessageResource;
import ni.org.ics.estudios.service.EstudioService;
import ni.org.ics.estudios.service.MessageResourceService;
import ni.org.ics.estudios.service.UsuarioService;
import ni.org.ics.estudios.service.scancarta.VersionCartaService;
import ni.org.ics.estudios.users.model.Rol;
import ni.org.ics.estudios.users.model.UserSistema;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Miguel Salinas on 6/27/2017.
 * V1.0
 */
@Controller
@RequestMapping("/admin/vcartas/*")
public class VersionCartaController {
    private static final Logger logger = LoggerFactory.getLogger(VersionCartaController.class);

    @Resource(name = "versionCartaService")
    private VersionCartaService versionCartaService;

    @Resource(name = "messageResourceService")
    private MessageResourceService messageResourceService;

    @Resource(name = "estudioService")
    private EstudioService estudioService;

    @Resource(name="usuarioService")
    private UsuarioService usuarioService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String obtenerUsuarios(Model model) throws ParseException {
        logger.debug("Mostrando versiones de cartas en JSP");
        List<VersionCarta> versionCartas = versionCartaService.getVersionesCartas();
        model.addAttribute("versiones",versionCartas);
        return "admin/vcartas/list";
    }

    @RequestMapping(value = "newVersion", method = RequestMethod.GET)
    public String initAddUserForm(Model model) {
        List<Estudio> estudios = estudioService.getEstudios();
        List<MessageResource> versiones = messageResourceService.getCatalogo("CAT_VERSION_CARTA");
        model.addAttribute("versiones", versiones);
        model.addAttribute("estudios", estudios);
        model.addAttribute("agregando",true);
        model.addAttribute("editando",false);
        model.addAttribute("versionC", new VersionCarta());
        return "admin/vcartas/enterForm";
    }

    @RequestMapping( value="saveVersion", method=RequestMethod.POST)
    public ResponseEntity<String> processUpdateUserForm( @RequestParam(value="codigo", required=true ) Integer codigo
            , @RequestParam( value="estudio", required=true ) Integer estudio
            , @RequestParam( value="version", required=false ) String version
            , @RequestParam( value="validFrom", required=false, defaultValue="" ) Date validFrom
            , @RequestParam( value="validUntil", required=true, defaultValue="" ) Date validUntil
    )
    {
        try{
            VersionCarta versionRegistrada = this.versionCartaService.getVersionCartaByEstudioVersion(estudio, version);
            VersionCarta versionCarta = this.versionCartaService.getVersionCartaByCodigo(codigo);
            if (versionCarta==null){
                if (versionRegistrada!=null)
                    throw new Exception("Esta versión de carta ya fue registrada para este estudio");
                versionCarta = new VersionCarta();

            }else{
                if (versionRegistrada!=null && !versionCarta.getCodigo().equals(versionRegistrada.getCodigo()))
                    throw new Exception("Esta versión de carta ya ha sido registrada para este estudio");
            }
            versionRegistrada = this.versionCartaService.getVersionCartaByEstudioRangoValidez(estudio, validFrom, validUntil);
            if(versionRegistrada!=null)
                throw new Exception("Ya existe una versión de carta con período de validez entre las fechas que ha ingresado para este estudio");

            versionCarta.setVersion(messageResourceService.getMensaje(version,"CAT_VERSION_CARTA"));
            versionCarta.setEstudio(estudioService.getEstudioByCodigo(estudio));
            versionCarta.setFechaInicio(validFrom);
            versionCarta.setFechaFin(validUntil);
            versionCarta.setRecordDate(new Date());
            versionCarta.setRecordUser(SecurityContextHolder.getContext().getAuthentication().getName());

            this.versionCartaService.saveOrUpdateVersionCarta(versionCarta);
            return createJsonResponse(versionCarta);
        }
        catch(Exception e){
            Gson gson = new Gson();
            String json = gson.toJson(e.toString());
            return new ResponseEntity<String>( json, HttpStatus.CREATED);
        }
    }

    /**
     * Custom handler for enabling/disabling an user.
     *
     * @param codigo the ID of the version to enable
     * @return a String
     */
    @RequestMapping("/habdes/{accion}/{codigo}")
    public String enableUser(@PathVariable("codigo") Integer codigo,
                             @PathVariable("accion") String accion, RedirectAttributes redirectAttributes) {
        String redirecTo="404";
        boolean hab;
        if(accion.matches("disable")){
            redirecTo = "redirect:/admin/vcartas/";
            hab = false;
            redirectAttributes.addFlashAttribute("deshabilitado", true);
        }
        else{
            return redirecTo;
        }
        VersionCarta versionCarta = this.versionCartaService.getVersionCartaByCodigo(codigo);
        if (versionCarta!=null){
            versionCarta.setPasive('1');
            this.versionCartaService.saveOrUpdateVersionCarta(versionCarta);
            redirectAttributes.addFlashAttribute("registroVersion", versionCarta);
        }
        else{
            redirecTo = "403";
        }
        return redirecTo;
    }

    private ResponseEntity<String> createJsonResponse( Object o )
    {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        Gson gson = new Gson();
        String json = gson.toJson(o);
        return new ResponseEntity<String>( json, headers, HttpStatus.CREATED );
    }
}
