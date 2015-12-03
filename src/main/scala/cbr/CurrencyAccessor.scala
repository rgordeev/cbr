package cbr


import cbr.client.GetCursOnDateXMLResponse
import org.apache.xerces.dom.ElementNSImpl
import org.w3c.dom.{Node, NodeList}

import scala.collection.JavaConversions._

/**
 * Created by Roman Gordeev on 04.12.15.
 */
class CurrencyAccessor {
  def listCurrencies(result: GetCursOnDateXMLResponse.GetCursOnDateXMLResult) = {
    val content = result.getContent
    val root: ElementNSImpl = content.head.asInstanceOf[ElementNSImpl]
    val nodes: NodeList = root.getElementsByTagName("VchCode")
    for {
      i <- 0 to nodes.getLength - 1
      node: Node = nodes.item(i)
      parent: Node = node.getParentNode
      list: NodeList = parent.getChildNodes

      l = for {
        j <- 0 to list.getLength - 1
        current: Node = list.item(j)
        name: String = current.getNodeName.trim
        firstChild: Node = current.getFirstChild
        value: String = firstChild.getNodeValue.trim
      } yield name match {
          case "Vname" => ("vname", value)
          case "VchCode" => ("vchCode", value)
          case "Vnom" => ("vnom", BigDecimal(value))
          case "Vcurs" => ("vcurs", BigDecimal(value))
          case "Vcode" => ("vcode", value.toInt)
        }
    } yield {
       Valute(l.find(k => k._1 == "vname").get._2.asInstanceOf[String],
        l.find(k => k._1 == "vchCode").get._2.asInstanceOf[String],
        l.find(k => k._1 == "vcode").get._2.asInstanceOf[Int],
        l.find(k => k._1 == "vnom").get._2.asInstanceOf[BigDecimal],
        l.find(k => k._1 == "vcurs").get._2.asInstanceOf[BigDecimal])
    }
  }

}
