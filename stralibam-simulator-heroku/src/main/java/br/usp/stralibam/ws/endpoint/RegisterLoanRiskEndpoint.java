package br.usp.stralibam.ws.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.usp.stralibam.ws.register_loan_risk.RegisterLoanRiskRequest;
import br.usp.stralibam.ws.register_loan_risk.RegisterLoanRiskResponse;
import lombok.extern.slf4j.Slf4j;

@Endpoint
@Slf4j
public class RegisterLoanRiskEndpoint {

	private static final String NAMESPACE_URI = "http://www.usp.br/stralibam/ws/register_loan_risk";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "registerLoanRiskRequest")

	@ResponsePayload
	public RegisterLoanRiskResponse registerLoanRiskRequest(@RequestPayload RegisterLoanRiskRequest request) throws Exception {
		log.info("Register Loan Risk");
		
		return null;

	}
	
}
