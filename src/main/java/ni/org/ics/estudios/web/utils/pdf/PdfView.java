package ni.org.ics.estudios.web.utils.pdf;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import com.lowagie.text.pdf.draw.LineSeparator;
import ni.org.ics.estudios.language.MessageResource;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.List;

/**
 * Created by Miguel Salinas on 19/10/2018.
 * V1.0
 */
public class PdfView extends AbstractPdfView {

    java.util.List<MessageResource> messageReports = new ArrayList<MessageResource>();

    @Override
    protected void buildPdfDocument(
            Map<String, Object> model,
            Document document,
            PdfWriter writer,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        messageReports = (java.util.List<MessageResource>) model.get("labels");
        DatosGeneralesParticipante datosParticipante = (DatosGeneralesParticipante) model.get("datos");

        MyFooter footer = new MyFooter();
        footer.setMensajes(datosParticipante.getMensajes());
        writer.setPageEvent(footer);
        Font timesRomanNormal12 = new Font(Font.TIMES_ROMAN, 12, Font.NORMAL);
        Font timesRomanBold13 = new Font(Font.TIMES_ROMAN, 13, Font.BOLD);
        Font timesRomanBold12 = new Font(Font.TIMES_ROMAN, 12, Font.BOLD);
        Font timesRomanBoldItalic12 = new Font(Font.TIMES_ROMAN, 12, Font.BOLDITALIC);

        Paragraph h1 = new Paragraph(this.getMessage("title.report.file", null), timesRomanBold13);
        document.add(h1);
        LineSeparator ls = new LineSeparator(0.5f, 100, null, 0, -5);
        ls.setLineWidth(0.5f);
        document.add(new Chunk(ls));

        PdfPTable table = new PdfPTable(new float[] { 10, 13, 10, 67 });
        table.setWidthPercentage(96);
        table.addCell(createCell(this.getMessage("lbl.code", null), timesRomanBold12, Rectangle.NO_BORDER));
        table.addCell(createCell(datosParticipante.getCodigo(), timesRomanNormal12, Rectangle.NO_BORDER));
        table.addCell(createCell(this.getMessage("lbl.date", null), timesRomanBold12, Rectangle.NO_BORDER));
        table.addCell(createCell(datosParticipante.getFechaIngreso(), timesRomanNormal12, Rectangle.NO_BORDER));
        document.add(table);

        Paragraph t1 = new Paragraph(this.getMessage("lbl.general.data", null), timesRomanBoldItalic12);
        t1.setSpacingAfter(5f);
        document.add(t1);

        table = new PdfPTable(new float[] { 23, 77 });
        table.setWidthPercentage(96);
        table.addCell(createCellUnderline(this.getMessage("lbl.family", null), timesRomanBoldItalic12, Rectangle.NO_BORDER, 2));
        table.addCell(createCell(this.getMessage("lbl.family.boss", null), timesRomanBold12, Rectangle.NO_BORDER));
        table.addCell(createCell(datosParticipante.getJefeFamilia(), timesRomanNormal12, Rectangle.NO_BORDER));
        table.addCell(createCell(this.getMessage("lbl.tutor", null), timesRomanBold12, Rectangle.NO_BORDER));
        table.addCell(createCell(datosParticipante.getTutor(), timesRomanNormal12, Rectangle.NO_BORDER));
        table.addCell(createCell(this.getMessage("lbl.father", null), timesRomanBold12, Rectangle.NO_BORDER));
        table.addCell(createCell(datosParticipante.getPadre(), timesRomanNormal12, Rectangle.NO_BORDER));
        table.addCell(createCell(this.getMessage("lbl.mother", null), timesRomanBold12, Rectangle.NO_BORDER));
        table.addCell(createCell(datosParticipante.getMadre(), timesRomanNormal12, Rectangle.NO_BORDER));
        document.add(table);

        table = new PdfPTable(new float[] { 23, 10, 25, 15, 27});
        table.setWidthPercentage(96);
        table.addCell(createCell(this.getMessage("lbl.family.relationship", null), timesRomanBold12, Rectangle.NO_BORDER, 2));
        table.addCell(createCell(datosParticipante.getRelFamTutor(), timesRomanNormal12, Rectangle.NO_BORDER));
        table.addCell(createCell(this.getMessage("lbl.housing.type", null), timesRomanBold12, Rectangle.NO_BORDER));
        table.addCell(createCell(datosParticipante.getTipoVivienda(), timesRomanNormal12, Rectangle.NO_BORDER));
        table.addCell(createCell(this.getMessage("lbl.neighborhood", null), timesRomanBold12, Rectangle.NO_BORDER));
        table.addCell(createCell(datosParticipante.getBarrio(), timesRomanNormal12, Rectangle.NO_BORDER, 2));
        table.addCell(createCell(this.getMessage("lbl.block", null), timesRomanBold12, Rectangle.NO_BORDER));
        table.addCell(createCell(datosParticipante.getManzana(), timesRomanNormal12, Rectangle.NO_BORDER));
        document.add(table);

        table = new PdfPTable(new float[] { 23, 77 });
        table.setWidthPercentage(96);
        table.addCell(createCell(this.getMessage("lbl.address", null), timesRomanBold12, Rectangle.NO_BORDER));
        table.addCell(createCell(datosParticipante.getDireccion(), timesRomanNormal12, Rectangle.NO_BORDER));
        table.addCell(createCell(this.getMessage("lbl.phone", null), timesRomanBold12, Rectangle.NO_BORDER));
        table.addCell(createCell(datosParticipante.getTelefonos(), timesRomanNormal12, Rectangle.NO_BORDER));
        table.addCell(createCellUnderline(this.getMessage("lbl.contact", null), timesRomanBoldItalic12, Rectangle.NO_BORDER));
        table.addCell(createCell(this.getMessage("lbl.contact.explanation", null), timesRomanBoldItalic12, Rectangle.NO_BORDER));
        table.addCell(createCell(this.getMessage("lbl.name", null), timesRomanBold12, Rectangle.NO_BORDER));
        table.addCell(createCell(datosParticipante.getNombreContacto(), timesRomanNormal12, Rectangle.NO_BORDER));
        table.addCell(createCell(this.getMessage("lbl.neighborhood", null), timesRomanBold12, Rectangle.NO_BORDER));
        table.addCell(createCell(datosParticipante.getBarrioContacto(), timesRomanNormal12, Rectangle.NO_BORDER));
        table.addCell(createCell(this.getMessage("lbl.phone", null), timesRomanBold12, Rectangle.NO_BORDER));
        table.addCell(createCell(datosParticipante.getTelefonosContacto(), timesRomanNormal12, Rectangle.NO_BORDER));
        table.addCell(createCell(this.getMessage("lbl.address", null), timesRomanBold12, Rectangle.NO_BORDER));
        table.addCell(createCell(datosParticipante.getDireccionContacto(), timesRomanNormal12, Rectangle.NO_BORDER));
        document.add(table);

        Paragraph t2 = new Paragraph(this.getMessage("lbl.child.data", null), timesRomanBoldItalic12);
        t2.setSpacingAfter(5f);
        document.add(t2);

        table = new PdfPTable(new float[] { 29, 71 });
        table.setWidthPercentage(96);
        table.addCell(createCell(this.getMessage("lbl.names.surnames", null), timesRomanBold12, Rectangle.NO_BORDER));
        table.addCell(createCell(datosParticipante.getNombreCompleto(), timesRomanNormal12, Rectangle.NO_BORDER));
        document.add(table);

        table = new PdfPTable(new float[] { 8, 8, 23, 17, 7, 8, 15, 14 });
        table.setWidthPercentage(96);
        table.addCell(createCell(this.getMessage("lbl.age", null), timesRomanBold12, Rectangle.NO_BORDER));
        table.addCell(createCell(datosParticipante.getEdad(), timesRomanNormal12, Rectangle.NO_BORDER));
        table.addCell(createCell(this.getMessage("lbl.birthdate", null), timesRomanBold12, Rectangle.NO_BORDER));
        table.addCell(createCell(datosParticipante.getFechaNacimiento(), timesRomanNormal12, Rectangle.NO_BORDER));
        table.addCell(createCell(this.getMessage("lbl.gender", null), timesRomanBold12, Rectangle.NO_BORDER));
        table.addCell(createCell(datosParticipante.getSexo(), timesRomanNormal12, Rectangle.NO_BORDER));
        table.addCell(createCell(this.getMessage("lbl.student", null), timesRomanBold12, Rectangle.NO_BORDER));
        table.addCell(createCell(datosParticipante.getEstudiante(), timesRomanNormal12, Rectangle.NO_BORDER));
        document.add(table);

        table = new PdfPTable(new float[] { 10, 19, 10, 61 });
        table.setWidthPercentage(96);
        table.addCell(createCell(this.getMessage("lbl.turn", null), timesRomanBold12, Rectangle.NO_BORDER));
        table.addCell(createCell(datosParticipante.getTurno(), timesRomanNormal12, Rectangle.NO_BORDER));
        table.addCell(createCell(this.getMessage("lbl.school", null), timesRomanBold12, Rectangle.NO_BORDER));
        table.addCell(createCell(datosParticipante.getEscuela(), timesRomanNormal12, Rectangle.NO_BORDER));
        document.add(table);

        table = new PdfPTable(new float[] { 29, 71 });
        table.setWidthPercentage(96);
        table.addCell(createCell(this.getMessage("lbl.residence.time", null), timesRomanBold12, Rectangle.NO_BORDER));
        table.addCell(createCell(datosParticipante.getTiempoResidencia(), timesRomanNormal12, Rectangle.NO_BORDER));
        document.add(table);

        table = new PdfPTable(new float[] { 65, 35 });
        table.setWidthPercentage(96);
        table.addCell(createCell(this.getMessage("lbl.stay.area", null), timesRomanBold12, Rectangle.NO_BORDER));
        table.addCell(createCell(datosParticipante.getPermanecerTresAnios(), timesRomanNormal12, Rectangle.NO_BORDER));
        document.add(table);

        table = new PdfPTable(new float[] { 56, 44 });
        table.setWidthPercentage(96);
        table.addCell(createCell(this.getMessage("lbl.where.child.attends", null), timesRomanBold12, Rectangle.NO_BORDER));
        table.addCell(createCell(datosParticipante.getDondeAsiste(), timesRomanNormal12, Rectangle.NO_BORDER));
        document.add(table);

        table = new PdfPTable(new float[] { 56, 44 });
        table.setWidthPercentage(96);
        table.addCell(createCell(this.getMessage("lbl.health.unit.attends", null), timesRomanBold12, Rectangle.NO_BORDER));
        table.addCell(createCell(datosParticipante.getUnidadAsiste(), timesRomanNormal12, Rectangle.NO_BORDER));
        document.add(table);

        table = new PdfPTable(new float[] { 85, 15 });
        table.setWidthPercentage(96);
        table.addCell(createCell(this.getMessage("lbl.willing.attends.cssf", null), timesRomanBold12, Rectangle.NO_BORDER));
        table.addCell(createCell(datosParticipante.getAsistirCSSF(), timesRomanNormal12, Rectangle.NO_BORDER));
        document.add(table);

        Paragraph t3 = new Paragraph(this.getMessage("lbl.clinical.epi.data", null), timesRomanBoldItalic12);
        t3.setSpacingAfter(5f);
        document.add(t3);

        table = new PdfPTable(new float[] { 53, 5, 10, 32 });
        table.setWidthPercentage(96);
        table.addCell(createCell(this.getMessage("lbl.chronic disease", null), timesRomanBold12, Rectangle.NO_BORDER));
        table.addCell(createCell(datosParticipante.getEnfermedadCronica(), timesRomanNormal12, Rectangle.NO_BORDER));
        table.addCell(createCell(this.getMessage("lbl.wich", null), timesRomanBold12, Rectangle.NO_BORDER));
        table.addCell(createCell(datosParticipante.getCualEnfermedadCronica(), timesRomanNormal12, Rectangle.NO_BORDER));
        table.addCell(createCell(this.getMessage("lbl.take.treatment", null), timesRomanBold12, Rectangle.NO_BORDER));
        table.addCell(createCell(datosParticipante.getTomaTratamiento(), timesRomanNormal12, Rectangle.NO_BORDER));
        table.addCell(createCell(this.getMessage("lbl.wich", null), timesRomanBold12, Rectangle.NO_BORDER));
        table.addCell(createCell(datosParticipante.getCualTratamiento(), timesRomanNormal12, Rectangle.NO_BORDER));
        table.addCell(createCell(this.getMessage("lbl.diagnosed.dengue", null), timesRomanBold12, Rectangle.NO_BORDER));
        table.addCell(createCell(datosParticipante.getTieneDxDengue(), timesRomanNormal12, Rectangle.NO_BORDER));
        table.addCell(createCell(this.getMessage("lbl.when", null), timesRomanBold12, Rectangle.NO_BORDER));
        table.addCell(createCell(datosParticipante.getFechaDxDengue(), timesRomanNormal12, Rectangle.NO_BORDER));
        table.addCell(createCell(this.getMessage("lbl.hospitalized.dengue", null), timesRomanBold12, Rectangle.NO_BORDER));
        table.addCell(createCell(datosParticipante.getHospitalizadoDengue(), timesRomanNormal12, Rectangle.NO_BORDER));
        table.addCell(createCell(this.getMessage("lbl.when", null), timesRomanBold12, Rectangle.NO_BORDER));
        table.addCell(createCell(datosParticipante.getFechaHospitalizadoDengue(), timesRomanNormal12, Rectangle.NO_BORDER));

        document.add(table);

        LineSeparator ls2 = new LineSeparator();
        ls2.setLineWidth(0.5f);
        document.add(new Chunk(ls2));

        table = new PdfPTable(new float[] { 20, 80 });
        table.setWidthPercentage(96);
        table.addCell(createCell(this.getMessage("lbl.digitador", null), timesRomanBold12, Rectangle.NO_BORDER));
        table.addCell(createCell(datosParticipante.getDigitador(), timesRomanNormal12, Rectangle.NO_BORDER));
        document.add(table);
    }

    private PdfPCell createCell(String text, Font f, int border){
        PdfPCell cell = new PdfPCell(new Phrase(text, f));
        cell.setPaddingBottom(5);
        cell.setBorder(border);
        return cell;
    }

    private PdfPCell createCell(String text, Font f, int border, int colspan){
        PdfPCell cell = new PdfPCell(new Phrase(text, f));
        cell.setColspan(colspan);
        cell.setPaddingBottom(5);
        cell.setBorder(border);
        return cell;
    }

    private PdfPCell createCellUnderline(String text, Font f, int border) {
        Chunk chunk2 = new Chunk(text, f);
        chunk2.setUnderline(1f, -2f);
        PdfPCell cell = new PdfPCell(new Phrase(chunk2));
        cell.setPaddingBottom(5);
        cell.setBorder(border);
        return cell;
    }
    private PdfPCell createCellUnderline(String text, Font f, int border, int colspan) {
        Chunk chunk2 = new Chunk(text, f);
        chunk2.setUnderline(1f, -2f);
        PdfPCell cell = new PdfPCell(new Phrase(chunk2));
        cell.setColspan(colspan);
        cell.setPaddingBottom(5);
        cell.setBorder(border);
        return cell;
    }

    private String getMessage(String messageKey, String languaje){
        for(MessageResource message : messageReports){
            if (message.getMessageKey().equalsIgnoreCase(messageKey)){
                if (languaje!=null && languaje.equalsIgnoreCase("en"))
                    return message.getEnglish();
                else return message.getSpanish();
            }
        }
        return "";
    }
}

class MyFooter extends PdfPageEventHelper {
    Font ffont = new Font(Font.COURIER, 8, Font.ITALIC);

    private List<String> mensajes = new ArrayList<String>();

    public void onEndPage(PdfWriter writer, Document document) {
        PdfContentByte cb = writer.getDirectContent();
        int posicion = 5;
        for(String mensaje : mensajes) {
            Phrase footer = new Phrase("* "+mensaje, ffont);

            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT,
                    footer,
                    (document.left()) / 2 + document.leftMargin(),//(document.right() - document.left()) / 2 + document.leftMargin(),
                    document.bottom() - posicion, 0);
            posicion+=10;
        }
    }

    public List<String> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<String> mensajes) {
        this.mensajes = mensajes;
    }
}
