//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.05.12 at 10:49:57 AM BRT 
//


package br.usp.stralibam.ws.send_accep_pack;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.usp.stralibam.ws.send_accep_pack package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Slos_QNAME = new QName("http://www.usp.br/stralibam/ws/send_accep_pack", "slos");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.usp.stralibam.ws.send_accep_pack
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SendAccepPackRequest }
     * 
     */
    public SendAccepPackRequest createSendAccepPackRequest() {
        return new SendAccepPackRequest();
    }

    /**
     * Create an instance of {@link SLOType }
     * 
     */
    public SLOType createSLOType() {
        return new SLOType();
    }

    /**
     * Create an instance of {@link SendAccepPackResponse }
     * 
     */
    public SendAccepPackResponse createSendAccepPackResponse() {
        return new SendAccepPackResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SLOType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.usp.br/stralibam/ws/send_accep_pack", name = "slos")
    public JAXBElement<SLOType> createSlos(SLOType value) {
        return new JAXBElement<SLOType>(_Slos_QNAME, SLOType.class, null, value);
    }

}
