package cbr

import java.util.GregorianCalendar
import javax.xml.datatype.{XMLGregorianCalendar, DatatypeFactory}

import cbr.client.{GetCursOnDateXMLResponse, DailyInfo, DailyInfoSoap}

/**
 * Created by Roman Gordeev on 04.12.15.
 */
object Starter {
  def main(args : Array[String]): Unit = {
    //println("Hello!")

    val service: DailyInfoSoap = new DailyInfo().getDailyInfoSoap
    val gregorianCalendar: GregorianCalendar = new GregorianCalendar(2015, 10, 30)
    val datatypeFactory: DatatypeFactory = DatatypeFactory.newInstance
    // init date by certain value
    val date: XMLGregorianCalendar = datatypeFactory.newXMLGregorianCalendar(gregorianCalendar)
    //date = service.getLatestDateTime
    // or request latest date from SOAP service
    //date = service.getLatestDateTime();
    // request currency on the date
    val result: GetCursOnDateXMLResponse.GetCursOnDateXMLResult = service.getCursOnDateXML(date)
    val l = new CurrencyAccessor().listCurrencies(result)
  }

}
