
package cbr.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.w3.org/2001/XMLSchema}openAttrs">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element ref="{http://www.w3.org/2001/XMLSchema}include"/>
 *           &lt;element ref="{http://www.w3.org/2001/XMLSchema}import"/>
 *           &lt;element ref="{http://www.w3.org/2001/XMLSchema}redefine"/>
 *           &lt;element ref="{http://www.w3.org/2001/XMLSchema}annotation"/>
 *         &lt;/choice>
 *         &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *           &lt;group ref="{http://www.w3.org/2001/XMLSchema}schemaTop"/>
 *           &lt;element ref="{http://www.w3.org/2001/XMLSchema}annotation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;/sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="targetNamespace" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}token" />
 *       &lt;attribute name="finalDefault" type="{http://www.w3.org/2001/XMLSchema}fullDerivationSet" default="" />
 *       &lt;attribute name="blockDefault" type="{http://www.w3.org/2001/XMLSchema}blockSet" default="" />
 *       &lt;attribute name="attributeFormDefault" type="{http://www.w3.org/2001/XMLSchema}formChoice" default="unqualified" />
 *       &lt;attribute name="elementFormDefault" type="{http://www.w3.org/2001/XMLSchema}formChoice" default="unqualified" />
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang"/>
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "includesAndImportsAndRedefines"
})
@XmlRootElement(name = "schema", namespace = "http://www.w3.org/2001/XMLSchema")
public class Schema
    extends OpenAttrs
{

    @XmlElements({
        @XmlElement(name = "include", namespace = "http://www.w3.org/2001/XMLSchema", type = Include.class),
        @XmlElement(name = "import", namespace = "http://www.w3.org/2001/XMLSchema", type = Import.class),
        @XmlElement(name = "redefine", namespace = "http://www.w3.org/2001/XMLSchema", type = Redefine.class),
        @XmlElement(name = "annotation", namespace = "http://www.w3.org/2001/XMLSchema", type = Annotation.class),
        @XmlElement(name = "simpleType", namespace = "http://www.w3.org/2001/XMLSchema", type = SimpleType.class),
        @XmlElement(name = "complexType", namespace = "http://www.w3.org/2001/XMLSchema", type = ComplexType.class),
        @XmlElement(name = "group", namespace = "http://www.w3.org/2001/XMLSchema", type = Group.class),
        @XmlElement(name = "attributeGroup", namespace = "http://www.w3.org/2001/XMLSchema", type = AttributeGroup.class),
        @XmlElement(name = "element", namespace = "http://www.w3.org/2001/XMLSchema", type = Element.class),
        @XmlElement(name = "attribute", namespace = "http://www.w3.org/2001/XMLSchema", type = Attribute.class),
        @XmlElement(name = "notation", namespace = "http://www.w3.org/2001/XMLSchema", type = Notation.class)
    })
    protected List<OpenAttrs> includesAndImportsAndRedefines;
    @XmlAttribute(name = "targetNamespace")
    @XmlSchemaType(name = "anyURI")
    protected String targetNamespace;
    @XmlAttribute(name = "version")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String version;
    @XmlAttribute(name = "finalDefault")
    @XmlSchemaType(name = "fullDerivationSet")
    protected List<String> finalDefaults;
    @XmlAttribute(name = "blockDefault")
    @XmlSchemaType(name = "blockSet")
    protected List<String> blockDefaults;
    @XmlAttribute(name = "attributeFormDefault")
    protected FormChoice attributeFormDefault;
    @XmlAttribute(name = "elementFormDefault")
    protected FormChoice elementFormDefault;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "lang", namespace = "http://www.w3.org/XML/1998/namespace")
    protected String lang;

    /**
     * Gets the value of the includesAndImportsAndRedefines property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the includesAndImportsAndRedefines property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIncludesAndImportsAndRedefines().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Include }
     * {@link Import }
     * {@link Redefine }
     * {@link Annotation }
     * {@link SimpleType }
     * {@link ComplexType }
     * {@link Group }
     * {@link AttributeGroup }
     * {@link Element }
     * {@link Attribute }
     * {@link Notation }
     * 
     * 
     */
    public List<OpenAttrs> getIncludesAndImportsAndRedefines() {
        if (includesAndImportsAndRedefines == null) {
            includesAndImportsAndRedefines = new ArrayList<OpenAttrs>();
        }
        return this.includesAndImportsAndRedefines;
    }

    /**
     * Gets the value of the targetNamespace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetNamespace() {
        return targetNamespace;
    }

    /**
     * Sets the value of the targetNamespace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetNamespace(String value) {
        this.targetNamespace = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the finalDefaults property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the finalDefaults property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFinalDefaults().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getFinalDefaults() {
        if (finalDefaults == null) {
            finalDefaults = new ArrayList<String>();
        }
        return this.finalDefaults;
    }

    /**
     * Gets the value of the blockDefaults property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the blockDefaults property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBlockDefaults().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getBlockDefaults() {
        if (blockDefaults == null) {
            blockDefaults = new ArrayList<String>();
        }
        return this.blockDefaults;
    }

    /**
     * Gets the value of the attributeFormDefault property.
     * 
     * @return
     *     possible object is
     *     {@link FormChoice }
     *     
     */
    public FormChoice getAttributeFormDefault() {
        if (attributeFormDefault == null) {
            return FormChoice.UNQUALIFIED;
        } else {
            return attributeFormDefault;
        }
    }

    /**
     * Sets the value of the attributeFormDefault property.
     * 
     * @param value
     *     allowed object is
     *     {@link FormChoice }
     *     
     */
    public void setAttributeFormDefault(FormChoice value) {
        this.attributeFormDefault = value;
    }

    /**
     * Gets the value of the elementFormDefault property.
     * 
     * @return
     *     possible object is
     *     {@link FormChoice }
     *     
     */
    public FormChoice getElementFormDefault() {
        if (elementFormDefault == null) {
            return FormChoice.UNQUALIFIED;
        } else {
            return elementFormDefault;
        }
    }

    /**
     * Sets the value of the elementFormDefault property.
     * 
     * @param value
     *     allowed object is
     *     {@link FormChoice }
     *     
     */
    public void setElementFormDefault(FormChoice value) {
        this.elementFormDefault = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the lang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLang() {
        return lang;
    }

    /**
     * Sets the value of the lang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLang(String value) {
        this.lang = value;
    }

}
