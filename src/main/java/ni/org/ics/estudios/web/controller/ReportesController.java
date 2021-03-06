package ni.org.ics.estudios.web.controller;

import ni.org.ics.estudios.domain.catalogs.Estudio;
import ni.org.ics.estudios.language.MessageResource;
import ni.org.ics.estudios.service.EstudioService;
import ni.org.ics.estudios.service.MessageResourceService;
import ni.org.ics.estudios.service.cohortefamilia.ReportesService;
import ni.org.ics.estudios.service.reportes.ReportesPdfService;
import ni.org.ics.estudios.web.utils.DateUtil;
import ni.org.ics.estudios.web.utils.pdf.DatosGeneralesParticipante;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by Miguel Salinas on 9/8/2017.
 * V1.0
 */
@Controller
@RequestMapping("/reportes/*")
public class ReportesController {

    private static final Logger logger = LoggerFactory.getLogger(ChfCasosController.class);
    @Resource(name = "reportesService")
    private ReportesService reportesService;
    @Resource(name = "messageResourceService")
    private MessageResourceService messageResourceService;
    @Resource(name = "reportesPdfService")
    private ReportesPdfService reportesPdfService;
    @Resource(name = "estudioService")
    private EstudioService estudioService;

    @RequestMapping(value = "/super/visitas", method = RequestMethod.GET)
    public String obtenerVisitas(Model model) throws ParseException {
        logger.debug("Mostrando casos monitoreo intensivo en JSP");
        List<Object[]> visitas = null; //reportesService.getHistorialVisitas(null, null, null, null);
        model.addAttribute("visitas", visitas);
        return "/supervisor/visitas/list";
    }

    /**
     * Retorna una lista de casas. Acepta una solicitud GET para JSON
     * @return Un arreglo JSON de racks
     * @throws ParseException
     */
    @RequestMapping(value = "/super/getVisitas", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Object[]> fetchCasaCohorteFamiliaCasosJson(@RequestParam(value = "codigoCasa", required = false) String casa,
                                                    @RequestParam(value = "codigoParticipante", required = false) Integer codigoParticipante,
                                                    @RequestParam(value = "fechaInicio", required = false) String fechaInicio,
                                                    @RequestParam(value = "fechaFin", required = false) String fechaFin) throws ParseException {
        logger.info("Obteniendo las casas en JSON");
        List<Object[]> casas = null;
        casas = reportesService.getHistorialVisitas(casa, codigoParticipante, DateUtil.StringToDate(fechaInicio, "dd/MM/yyyy"), DateUtil.StringToDate(fechaFin + " 23:59:59", "dd/MM/yyyy HH:mm:ss"));
        return casas;
    }

    @RequestMapping(value = "/pdf/fileData", method = RequestMethod.GET)
    public String fileDataReportForm(Model model) throws ParseException {
        logger.debug("Mostrando formulario para generar datos generales para agregar al expediente");
        List<Estudio> estudios = estudioService.getEstudios();
        model.addAttribute("estudios", estudios);
        return "/reportes/fileData";
    }


    @RequestMapping(value = "/downloadFileDataReport", method = RequestMethod.GET)
    public ModelAndView downloadFilaDataReport(@RequestParam(value="estudio", required=false) int estudio,
                                               @RequestParam(value="fechaInicio", required=false ) String fechaInicio,
                                               @RequestParam(value="fechaFin", required=false ) String fechaFin,
                                               @RequestParam(value="codigoParticipante", required=false) Integer codigoParticipante
                                               ) throws Exception{
        ModelAndView excelView = new ModelAndView("pdfView");
        Date dFechaInicio = null;
        if (fechaInicio!=null && !fechaInicio.isEmpty())
            dFechaInicio = DateUtil.StringToDate(fechaInicio, "dd/MM/yyyy");
        Date dFechaFin = null;
        if (fechaFin!=null && !fechaFin.isEmpty())
            dFechaFin = DateUtil.StringToDate(fechaFin+ " 23:59:59", "dd/MM/yyyy HH:mm:ss");

        List<DatosGeneralesParticipante> datosParticipante = reportesPdfService.getDatosGeneralesParticipante(estudio, codigoParticipante, dFechaInicio, dFechaFin);
        List<MessageResource> messageReports = messageResourceService.loadAllMessagesNoCatalogs();
        excelView.addObject("labels", messageReports);
        excelView.addObject("datos", datosParticipante);
        return excelView;
    }

}
