package cbr;

import cbr.client.*;
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

        // uncomment following code to log http requests to console

        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");


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

        java.util.List<GetCursOnDateAccessor.Currency> currencies = accessor.listCurrencies(result);
        System.out.println(gson.toJson(currencies));

        /*
        EnumReutersValutesXMLResponse.EnumReutersValutesXMLResult rv = service.enumReutersValutesXML();
        java.util.List<Object> o = rv.getContent();
        */

    }

    //[{"vname":"Австралийский доллар","vchCode":"AUD","vcode":36,"vnom":1,"vcurs":47.7983},{"vname":"Азербайджанский манат","vchCode":"AZN","vcode":944,"vnom":1,"vcurs":63.2960},{"vname":"Фунт стерлингов Соединенного королевства","vchCode":"GBP","vcode":826,"vnom":1,"vcurs":99.9352},{"vname":"Армянский драм","vchCode":"AMD","vcode":51,"vnom":100,"vcurs":13.7426},{"vname":"Белорусский рубль","vchCode":"BYR","vcode":974,"vnom":10000,"vcurs":36.4373},{"vname":"Болгарский лев","vchCode":"BGN","vcode":975,"vnom":1,"vcurs":35.9508},{"vname":"Бразильский реал","vchCode":"BRL","vcode":986,"vnom":1,"vcurs":17.6959},{"vname":"Венгерский форинт","vchCode":"HUF","vcode":348,"vnom":100,"vcurs":22.5350},{"vname":"Датская крона","vchCode":"DKK","vcode":208,"vnom":10,"vcurs":94.2559},{"vname":"Доллар США","vchCode":"USD","vcode":840,"vnom":1,"vcurs":66.2393},{"vname":"Евро","vchCode":"EUR","vcode":978,"vnom":1,"vcurs":70.3859},{"vname":"Индийская рупия","vchCode":"INR","vcode":356,"vnom":100,"vcurs":99.2795},{"vname":"Казахстанский тенге","vchCode":"KZT","vcode":398,"vnom":100,"vcurs":21.5644},{"vname":"Канадский доллар","vchCode":"CAD","vcode":124,"vnom":1,"vcurs":49.7217},{"vname":"Киргизский сом","vchCode":"KGS","vcode":417,"vnom":100,"vcurs":90.6767},{"vname":"Китайский юань","vchCode":"CNY","vcode":156,"vnom":1,"vcurs":10.3590},{"vname":"Молдавский лей","vchCode":"MDL","vcode":498,"vnom":10,"vcurs":33.0948},{"vname":"Норвежская крона","vchCode":"NOK","vcode":578,"vnom":10,"vcurs":76.3337},{"vname":"Польский злотый","vchCode":"PLN","vcode":985,"vnom":1,"vcurs":16.4455},{"vname":"Румынский лей","vchCode":"RON","vcode":946,"vnom":1,"vcurs":15.8244},{"vname":"СДР (специальные права заимствования)","vchCode":"XDR","vcode":960,"vnom":1,"vcurs":90.9837},{"vname":"Сингапурский доллар","vchCode":"SGD","vcode":702,"vnom":1,"vcurs":47.0182},{"vname":"Таджикский сомони","vchCode":"TJS","vcode":972,"vnom":1,"vcurs":10.0196},{"vname":"Турецкая лира","vchCode":"TRY","vcode":949,"vnom":1,"vcurs":22.5988},{"vname":"Новый туркменский манат","vchCode":"TMT","vcode":934,"vnom":1,"vcurs":18.9255},{"vname":"Узбекский сум","vchCode":"UZS","vcode":860,"vnom":1000,"vcurs":24.2191},{"vname":"Украинская гривна","vchCode":"UAH","vcode":980,"vnom":10,"vcurs":27.8902},{"vname":"Чешская крона","vchCode":"CZK","vcode":203,"vnom":10,"vcurs":26.0180},{"vname":"Шведская крона","vchCode":"SEK","vcode":752,"vnom":10,"vcurs":75.8312},{"vname":"Швейцарский франк","vchCode":"CHF","vcode":756,"vnom":1,"vcurs":64.6931},{"vname":"Южноафриканский рэнд","vchCode":"ZAR","vcode":710,"vnom":10,"vcurs":46.1588},{"vname":"Вон Республики Корея","vchCode":"KRW","vcode":410,"vnom":1000,"vcurs":57.3451},{"vname":"Японская иена","vchCode":"JPY","vcode":392,"vnom":100,"vcurs":54.1281}]


}
