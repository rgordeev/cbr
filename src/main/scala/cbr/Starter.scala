package cbr

import java.util.GregorianCalendar
import javax.xml.datatype.{XMLGregorianCalendar, DatatypeFactory}

import cbr.client._

/**
 * Created by Roman Gordeev on 04.12.15.
 */
object Starter {
    def main(args: Array[String]): Unit = {

        val service: DailyInfoSoap = new DailyInfo().getDailyInfoSoap

        /*
        val gregorianCalendar: GregorianCalendar = new GregorianCalendar(2015, 10, 27)
        val onDate = gregorianCalendar.getTime
        */
        
        val reutersDate = service.getLatestReutersDateTime.toGregorianCalendar.getTime
        val cursLatestDate = service.getLatestDateTime.toGregorianCalendar.getTime
        val curs = CurrencyAccessor.listCurrencies(cursLatestDate)
        val reuters = CurrencyAccessor.listReuters(reutersDate)

        println(curs)
        println(reuters)
    }

}
