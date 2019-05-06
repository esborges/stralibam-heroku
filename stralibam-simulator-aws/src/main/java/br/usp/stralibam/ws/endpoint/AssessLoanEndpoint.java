package br.usp.stralibam.ws.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.usp.stralibam.service.AssessLoanService;
import br.usp.stralibam.template.SloResult;
import br.usp.stralibam.ws.assess_loan.AssessLoanRequest;
import br.usp.stralibam.ws.assess_loan.AssessLoanResponse;
import br.usp.stralibam.ws.assess_loan.SLOType;

@Endpoint
public class AssessLoanEndpoint {

	@Autowired
	private AssessLoanService assessLoanService;

	private static final String NAMESPACE_URI = "http://www.usp.br/stralibam/ws/assess_loan";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "assessLoanRequest")

	@ResponsePayload
	public AssessLoanResponse assessLoanRequest(@RequestPayload AssessLoanRequest request) throws Exception {
		try {
			SloResult slo = assessLoanService.getSLOResult();
			AssessLoanResponse appPropertyResponse = new AssessLoanResponse();
			SLOType sloType = new SLOType();
			sloType.setQoSMeasuredValue(slo.getBooleanTargetValue().toString());
			appPropertyResponse.getSlos().add(sloType);
			return appPropertyResponse;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}

	}

}
