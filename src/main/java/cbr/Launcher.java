package cbr;

import cbr.client.DailyInfo;
import cbr.client.DailyInfoSoap;
import cbr.client.GetCursOnDateXMLResponse;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import scala.xml.Source;
import scala.xml.parsing.XhtmlParser;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Launcher
{
    public static void main(String[] args)
    {
        System.out.println("hello!");

        DailyInfoSoap service = new DailyInfo().getDailyInfoSoap();
        Calendar c = new GregorianCalendar(2015, 10, 30);
        GetCursOnDateXMLResponse.GetCursOnDateXMLResult list = service.getCursOnDateXML(new XMLGregorianCalendarImpl((GregorianCalendar) c));


        new XhtmlParser(list.getContent().get(0))

        System.out.println(new SimpleDateFormat("YYYY-MM-dd").format(c.getTime()));

        System.out.println(service.getLatestDate());

        System.out.println(list.toString());

    }
}
