//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.23 at 04:33:06 PM BRT 
//


package br.usp.stralibam.ws.register_elegibility;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SLOType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SLOType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="QoSAttribute" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="QoSMeasuredValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SLOType", propOrder = {
    "id",
    "qoSAttribute",
    "qoSMeasuredValue"
})
public class SLOType {

    @XmlElement(name = "Id")
    protected String id;
    @XmlElement(name = "QoSAttribute")
    protected String qoSAttribute;
    @XmlElement(name = "QoSMeasuredValue")
    protected String qoSMeasuredValue;

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
     * Gets the value of the qoSAttribute property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQoSAttribute() {
        return qoSAttribute;
    }

    /**
     * Sets the value of the qoSAttribute property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQoSAttribute(String value) {
        this.qoSAttribute = value;
    }

    /**
     * Gets the value of the qoSMeasuredValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQoSMeasuredValue() {
        return qoSMeasuredValue;
    }

    /**
     * Sets the value of the qoSMeasuredValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQoSMeasuredValue(String value) {
        this.qoSMeasuredValue = value;
    }

}
