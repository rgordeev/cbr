package cbr

/**
 * Created by Roman Gordeev on 04.12.15.
 *
 * Для валют ЦБ сервис отделет следующие атрибуты
 * <xs:complexType>
 *    <xs:sequence>
 *        <xs:element name="Vname" type="xs:string" minOccurs="0"/>
 *        <xs:element name="Vnom" type="xs:decimal" minOccurs="0"/>
 *        <xs:element name="Vcurs" type="xs:decimal" minOccurs="0"/>
 *        <xs:element name="Vcode" type="xs:int" minOccurs="0"/>
 *        <xs:element name="VchCode" type="xs:string" minOccurs="0"/>
 *    </xs:sequence>
 * </xs:complexType>
 */
case class Valute(vcode: Int, vchCode: String, vcurs: BigDecimal, vnom: BigDecimal, vname: String)
