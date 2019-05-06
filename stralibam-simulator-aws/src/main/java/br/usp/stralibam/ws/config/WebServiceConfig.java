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

	@Bean(name = "app_property")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema appPropertySchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("AppProperty");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://www.usp.br/stralibam/ws/app_property");
		wsdl11Definition.setSchema(appPropertySchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema appPropertySchema() {
		return new SimpleXsdSchema(new ClassPathResource("appraise_property.xsd"));
	}
	
	@Bean(name = "assess_loan")
	public DefaultWsdl11Definition defaultWsdl11DefinitionAssessLoan(XsdSchema assessLoanSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("AssessLoan");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://www.usp.br/stralibam/ws/assess_loan");
		wsdl11Definition.setSchema(assessLoanSchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema assessLoanSchema() {
		return new SimpleXsdSchema(new ClassPathResource("assess_loan.xsd"));
	}
	
	@Bean(name = "check_cred_hist")
	public DefaultWsdl11Definition defaultWsdl11DefinitionCheckCredHist(XsdSchema checkCredHistSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("CheckCredHist");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://www.usp.br/stralibam/ws/check_cred_hist");
		wsdl11Definition.setSchema(checkCredHistSchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema checkCredHistSchema() {
		return new SimpleXsdSchema(new ClassPathResource("check_cred_hist.xsd"));
	}
}
