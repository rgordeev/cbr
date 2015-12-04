package cbr


import java.util.{GregorianCalendar, Calendar, Date}
import javax.xml.datatype.{DatatypeFactory, XMLGregorianCalendar}

import cbr.client.{GetReutersCursOnDateXMLResponse, DailyInfo, DailyInfoSoap, GetCursOnDateXMLResponse}
import cbr.client.GetReutersCursOnDateXMLResponse.GetReutersCursOnDateXMLResult
import org.apache.xerces.dom.ElementNSImpl
import org.w3c.dom.{Node, NodeList}

import scala.collection.JavaConversions._

/**
 * Created by Roman Gordeev on 04.12.15.
 */
object CurrencyAccessor {

    def getService = {
        new DailyInfo().getDailyInfoSoap
    }

    def getCalendar(date: Date): GregorianCalendar = {
        val calendar = Calendar.getInstance()
        calendar.setTime(date)
        calendar.asInstanceOf[GregorianCalendar]
    }

    def listCurrencies(onDate: Date) = {
        val calendar = getCalendar(onDate)
        val datatypeFactory: DatatypeFactory = DatatypeFactory.newInstance
        val xmlDate: XMLGregorianCalendar = datatypeFactory.newXMLGregorianCalendar(calendar)
        val service = getService
        val result: GetCursOnDateXMLResponse.GetCursOnDateXMLResult = service.getCursOnDateXML(xmlDate)
        val content = result.getContent
        val root: ElementNSImpl = content.head.asInstanceOf[ElementNSImpl]
        // чтобы не обходить дерево по узлам через getFirstChild, проще получить узлы по тегу, а затем подняться вверх и получить остальные атрибуты
        // это кроме прочего избавит нас от необходимости фильтрации
        val nodes: NodeList = root.getElementsByTagName("VchCode")
        for (i <- 0 to nodes.getLength - 1) yield {
            val node: Node = nodes.item(i)
            val parent: Node = node.getParentNode
            val attrs: NodeList = parent.getChildNodes
            val params = for (j <- 0 to attrs.getLength - 1) yield {
                val current: Node = attrs.item(j)
                val name: String = current.getNodeName.trim
                val firstChild: Node = current.getFirstChild
                val value: String = firstChild.getNodeValue.trim
                name match {
                    case "Vname"   => ("Vname",   value)
                    case "VchCode" => ("VchCode", value)
                    case "Vnom"    => ("Vnom",    BigDecimal(value))
                    case "Vcurs"   => ("Vcurs",   BigDecimal(value))
                    case "Vcode"   => ("Vcode",   value.toInt)
                }
            }
            val map = params.toMap
            Valute(map("Vcode").asInstanceOf[Int],map("VchCode").asInstanceOf[String],map("Vcurs").asInstanceOf[BigDecimal],map("Vnom").asInstanceOf[BigDecimal],map("Vname").asInstanceOf[String])
        }
    }

    def listReuters(onDate: Date) = {
        val calendar = getCalendar(onDate)
        val datatypeFactory: DatatypeFactory = DatatypeFactory.newInstance
        val xmlDate: XMLGregorianCalendar = datatypeFactory.newXMLGregorianCalendar(calendar)
        val service = getService
        val response: GetReutersCursOnDateXMLResponse.GetReutersCursOnDateXMLResult = service.getReutersCursOnDateXML(xmlDate)
        val content = response.getContent
        val root: ElementNSImpl = content.head.asInstanceOf[ElementNSImpl]
        // чтобы не обходить дерево по узлам через getFirstChild, проще получить узлы по тегу, а затем подняться вверх и получить остальные атрибуты
        // это кроме прочего избавит нас от необходимости фильтрации
        val nodes: NodeList = root.getElementsByTagName("num_code")
        for (i <- 0 to nodes.getLength - 1) yield {
            val node: Node = nodes.item(i)
            val parent: Node = node.getParentNode
            val attrs: NodeList = parent.getChildNodes
            val params = for (j <- 0 to attrs.getLength - 1) yield {
                val current: Node = attrs.item(j)
                val name: String = current.getNodeName.trim
                val firstChild: Node = current.getFirstChild
                val value: String = firstChild.getNodeValue.trim
                name match {
                    case "num_code" => ("num_code",   value.toInt)
                    case "val"      => ("val", BigDecimal(value))
                    case "dir"      => ("dir",    value.toInt)
                }
            }
            val map = params.toMap
            ReutersCurrency(map("num_code").asInstanceOf[Int], map("val").asInstanceOf[BigDecimal], map("dir").asInstanceOf[Int])
        }
    }

}
