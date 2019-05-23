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

	@Bean(name = "assess_eligibility")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema assessEligibilitySchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("AssessEligibility");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://www.usp.br/stralibam/ws/assess_eligibility");
		wsdl11Definition.setSchema(assessEligibilitySchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema assessEligibilitySchema() {
		return new SimpleXsdSchema(new ClassPathResource("assess_eligibility.xsd"));
	}
	
	@Bean(name = "register_loan_risk")
	public DefaultWsdl11Definition defaultWsdl11DefinitionRegisterLoanRisk(XsdSchema registerLoanRiskSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("RegisterLoanRisk");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://www.usp.br/stralibam/ws/register_loan_risk");
		wsdl11Definition.setSchema(registerLoanRiskSchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema registerLoanRiskSchema() {
		return new SimpleXsdSchema(new ClassPathResource("register_loan_risk.xsd"));
	}
	
	@Bean(name = "register_elegibility")
	public DefaultWsdl11Definition defaultWsdl11DefinitionRegisterElegibility(XsdSchema registerElegibilitychema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("RegisterElegibility");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://www.usp.br/stralibam/ws/register_elegibility");
		wsdl11Definition.setSchema(registerElegibilitychema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema registerElegibilitychema() {
		return new SimpleXsdSchema(new ClassPathResource("register_elegibility.xsd"));
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
	
	@Bean(name = "check_application")
	public DefaultWsdl11Definition defaultWsdl11DefinitionCheckApplication(XsdSchema checkApplicationSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("CheckApplication");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://www.usp.br/stralibam/ws/check_application");
		wsdl11Definition.setSchema(checkApplicationSchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema checkApplicationSchema() {
		return new SimpleXsdSchema(new ClassPathResource("check_application.xsd"));
	}
	
	@Bean(name = "reject_application")
	public DefaultWsdl11Definition defaultWsdl11DefinitionRejectApplication(XsdSchema rejectApplicationSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("RejectApplication");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://www.usp.br/stralibam/ws/reject_application");
		wsdl11Definition.setSchema(rejectApplicationSchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema rejectApplicationSchema() {
		return new SimpleXsdSchema(new ClassPathResource("reject_application.xsd"));
	}
}
