	package br.usp.stralibam.ws.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
	
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/ws/*");
	}

	@Bean(name = "assess_eligibility_availability")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema assessEligibilityAvailabilitySchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("AssessEligibilityAvailability");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://www.usp.br/stralibam/ws/assess_eligibility_availability");
		wsdl11Definition.setSchema(assessEligibilityAvailabilitySchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema assessEligibilityAvailabilitySchema() {
		return new SimpleXsdSchema(new ClassPathResource("assess_eligibility_availability.xsd"));
	}
	
	@Bean(name = "assess_eligibility_resp_time")
	public DefaultWsdl11Definition defaultWsdl11DefinitionAssessLoan(XsdSchema assessEligibilityRespTimeSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("AssessEligibilityRespTime");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://www.usp.br/stralibam/ws/assess_eligibility_resp_time");
		wsdl11Definition.setSchema(assessEligibilityRespTimeSchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema assessEligibilityRespTimeSchema() {
		return new SimpleXsdSchema(new ClassPathResource("assess_eligibility_resp_time.xsd"));
	}
	
	@Bean(name = "send_accep_pack")
	public DefaultWsdl11Definition defaultWsdl11DefinitionCheckCredHist(XsdSchema sendAccepPackSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("SendAccepPack");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://www.usp.br/stralibam/ws/send_accep_pack");
		wsdl11Definition.setSchema(sendAccepPackSchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema sendAccepPackSchema() {
		return new SimpleXsdSchema(new ClassPathResource("send_accep_pack.xsd"));
	}
}
