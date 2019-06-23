package br.usp.stralibam.ws.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.usp.stralibam.service.AssessLoanService;
import br.usp.stralibam.template.SloResult;
import br.usp.stralibam.ws.assess_loan.AssessLoanRequest;
import br.usp.stralibam.ws.assess_loan.AssessLoanResponse;
import br.usp.stralibam.ws.assess_loan.SLOType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Endpoint
public class AssessLoanEndpoint {

	@Autowired
	private AssessLoanService assessLoanService;
	
	@Autowired
	private Environment env;

	private static final String NAMESPACE_URI = "http://www.usp.br/stralibam/ws/assess_loan";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "assessLoanRequest")

	@ResponsePayload
	public AssessLoanResponse assessLoanRequest(@RequestPayload AssessLoanRequest request) throws Exception {
		try {
			Boolean instability = new Boolean(env.getProperty("application.instability"));
			
			SloResult slo = assessLoanService.getSLOResult();
			AssessLoanResponse appPropertyResponse = new AssessLoanResponse();
			SLOType sloType = new SLOType();
			sloType.setQoSMeasuredValue(instability ? slo.getBooleanTargetValue().toString() : "true");
			sloType.setId("ASSESS_LOAN_RISK_INTE");
			sloType.setQoSAttribute("Integrity");
			appPropertyResponse.getSlos().add(sloType);
			return appPropertyResponse;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}

	}

}
