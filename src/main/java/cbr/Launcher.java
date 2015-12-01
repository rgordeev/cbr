package cbr;

import cbr.client.DailyInfo;
import cbr.client.DailyInfoSoap;
import cbr.client.GetCursOnDateXMLResponse;
import com.google.gson.Gson;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;

/**
 * Created by rgordeev on 01.12.15.
 */
public class Launcher {
    public static void main(String[] args) {
        try {
            read();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void read() throws Exception {
        DailyInfoSoap service = new DailyInfo().getDailyInfoSoap();

        GregorianCalendar gregorianCalendar = new GregorianCalendar(2015, 10, 30); // 2015-11-30 // month starts from 0
        DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
        // init date by certain value
        XMLGregorianCalendar date = datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
        // or request latest date from SOAP service
        //date = service.getLatestDateTime();


        // request currency on the date
        GetCursOnDateXMLResponse.GetCursOnDateXMLResult result = service.getCursOnDateXML(date);

        GetCursOnDateAccessor.Currency currency;
        GetCursOnDateAccessor accessor = GetCursOnDateAccessor.getInstance();



        // get the same currency (USD) by character code and numeric code
        // and print it as a json using Gson as a serializer

        Gson gson = new Gson();

        currency = accessor.getCurrencyByVchCode("USD", result);
        System.out.println(gson.toJson(currency));

        currency = accessor.getCurrencyByVCode("840", result);
        System.out.println(gson.toJson(currency));

    }
}
