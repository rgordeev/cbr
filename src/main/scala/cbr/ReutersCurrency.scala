package cbr

/**
 * User: rgordeev
 * Date: 04.12.15
 * Time: 13:15
 *
 * Для валют Реутерс сервис отает следующий перечень атрибутов
 * <xs:complexType>
 *     <xs:sequence>
 *         <xs:element name="num_code" msdata:Caption="Цифровой ISO код валюты"
 *                     type="xs:int" minOccurs="0"/>
 *         <xs:element name="val" msdata:Caption="котировка" type="xs:decimal"
 *                     minOccurs="0"/>
 *         <xs:element name="dir" msdata:Caption="0 - прямая котировка 1 - обратная"
 *                     type="xs:unsignedByte" minOccurs="0"/>
 *     </xs:sequence>
 * </xs:complexType>
 *
 */
case class ReutersCurrency(isoCode: Int, quotation: BigDecimal, quatationType: Int)