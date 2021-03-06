package ni.org.ics.estudios.web.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Miguel Salinas on 7/3/2017.
 * V1.0
 */
public final class DateUtil {

    /**
    * Convierte un string a Date segun el formato indicado
    * @param strFecha cadena a convertir
    * @param formato formato solicitado
    * @return Fecha
    * @throws java.text.ParseException
    */
    public static Date StringToDate(String strFecha, String formato) throws ParseException {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formato);
            return simpleDateFormat.parse(strFecha);
        }catch (Exception ex){
            return null;
        }
    }

    /**
     * Convierte una Date a String, segun el formato indicado
     * @param dtFecha Fecha a convertir
     * @param format formato solicitado
     * @return String
     */
    public static String DateToString(Date dtFecha, String format)  {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        if(dtFecha!=null)
            return simpleDateFormat.format(dtFecha);
        else
            return null;
    }
}
