package cbr;

/**
 * Created by rgordeev on 01.12.15.
 */

import cbr.client.GetCursOnDateXMLResponse.GetCursOnDateXMLResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.xerces.dom.ElementNSImpl;
import org.apache.xerces.dom.TextImpl;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * http://www.cbr.ru/scripts/Root.asp?PrtId=DWS
 * <p>
 * Описание методов сервиса:
 * GetCursOnDate(On_date) получение курсов валют на определенную дату (ежедневные курсы валют), GetSeldCursOnDate (ежемесячные курсы валют)
 * Аргументы:
 * On_date - Дата запроса для курсов, формат - System.DateTime
 * Результат:
 * XML документ в формате System.Data.Dataset, содержащий таблицу [ValuteCursOnDate],
 * таблица содержит поля:
 * <p>
 * Vname - Название валюты
 * Vnom - Номинал
 * Vcurs - Курс
 * Vcode - Цифровой код валюты
 * VchCode - Символьный код валюты
 */
public class GetCursOnDateAccessor {

    private static final GetCursOnDateAccessor instance = new GetCursOnDateAccessor();

    public static GetCursOnDateAccessor getInstance() {
        return instance;
    }

    private GetCursOnDateAccessor() {
    }

    /**
     * Vname - Название валюты
     * Vnom - Номинал
     * Vcurs - Курс
     * Vcode - Цифровой код валюты
     * VchCode - Символьный код валюты
     */
    public static class Currency {

        public String       vname;
        public String       vchCode;
        public Integer      vcode;
        public BigDecimal   vnom;
        public BigDecimal   vcurs;

        @Override
        public String toString() {
            return String.format("Vname: %s, VchCode: %s, Vcode: %s, Vnom: %s, Vcurs: %s",
                    vname, vchCode, vcode.toString(), vnom.toString(), vcurs.toString()
            );
        }

        public Boolean isEmpty() {
            return StringUtils.isEmpty(vname) ||
                    StringUtils.isEmpty(vchCode) ||
                    vcode == null ||
                    vnom == null ||
                    vcurs == null;
        }
    }

    public List<Currency> listCurrencies(GetCursOnDateXMLResult result)
    {
        List<Object> content = result.getContent();
        ElementNSImpl root = (ElementNSImpl) content.get(0);
        NodeList nodes = root.getElementsByTagName("VchCode");
        List<Currency> currencies = new ArrayList<>();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            Optional<Currency> c = buildCurrency(node);
            c.ifPresent(currency -> currencies.add(currency));
        }
        return currencies;
    }

    public Currency getCurrencyByVchCode(String vchcode, GetCursOnDateXMLResult result) throws Exception {

        Currency currency = new Currency();

        List<Object> content = result.getContent();
        ElementNSImpl root = (ElementNSImpl) content.get(0);

        NodeList nodes = root.getElementsByTagName("VchCode");

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            TextImpl text = (TextImpl) node.getFirstChild();
            String data = text.getData();

            if (StringUtils.equalsIgnoreCase(data, vchcode)) {
                initCurrency(currency, node);
                break; // <-- required node was found => leave loop
            }
        }

        return currency;

    }

    public Currency getCurrencyByVCode(String vcode, GetCursOnDateXMLResult result) throws Exception {

        Currency currency = new Currency();

        List<Object> content = result.getContent();
        ElementNSImpl root = (ElementNSImpl) content.get(0);
        NodeList nodes = root.getElementsByTagName("Vcode");

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            TextImpl text = (TextImpl) node.getFirstChild();
            String value = text.getData();

            if (StringUtils.endsWithIgnoreCase(value, vcode)) {
                initCurrency(currency, node);
                break; // <-- required node was found => leave loop
            }
        }

        return currency;

    }

    private Optional<Currency> buildCurrency(Node node) {
        Currency currency = new Currency();
        Node parent = node.getParentNode();
        NodeList list = parent.getChildNodes();

        for (int j = 0; j < list.getLength(); j++) {

            Node current = list.item(j);

            String name = StringUtils.trimToEmpty(current.getNodeName());
            Node firstChild = current.getFirstChild();
            String value = StringUtils.trimToEmpty(firstChild.getNodeValue());

            switch (name) {
                case "Vname":
                    currency.vname = value;
                    break;
                case "Vnom":
                    currency.vnom = new BigDecimal(value);
                    break;
                case "Vcurs":
                    currency.vcurs = new BigDecimal(value);
                    break;
                case "Vcode":
                    currency.vcode = Integer.parseInt(value);
                    break;
                case "VchCode":
                    currency.vchCode = value;
                    break;
            }
        }

        return currency.isEmpty() ? Optional.empty() : Optional.of(currency);
    }

    private void initCurrency(Currency currency, Node node) {

        Node parent = node.getParentNode();
        NodeList list = parent.getChildNodes();

        for (int j = 0; j < list.getLength(); j++) {

            Node current = list.item(j);

            String name = StringUtils.trimToEmpty(current.getNodeName());
            Node firstChild = current.getFirstChild();
            String value = StringUtils.trimToEmpty(firstChild.getNodeValue());

            switch (name) {
                case "Vname":
                    currency.vname = value;
                    break;
                case "Vnom":
                    currency.vnom = new BigDecimal(value);
                    break;
                case "Vcurs":
                    currency.vcurs = new BigDecimal(value);
                    break;
                case "Vcode":
                    currency.vcode = Integer.parseInt(value);
                    break;
                case "VchCode":
                    currency.vchCode = value;
                    break;
            }
        }
    }
}
