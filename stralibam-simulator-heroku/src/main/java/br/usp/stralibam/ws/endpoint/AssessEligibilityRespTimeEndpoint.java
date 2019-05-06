package br.usp.stralibam.ws.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.usp.stralibam.service.AssessEligibilityRespTimeService;
import br.usp.stralibam.template.SloResult;
import br.usp.stralibam.ws.assess_eligibility_resp_time.AssessEligibilityRespTimeRequest;
import br.usp.stralibam.ws.assess_eligibility_resp_time.AssessEligibilityRespTimeResponse;
import br.usp.stralibam.ws.assess_eligibility_resp_time.SLOType;

@Endpoint
public class AssessEligibilityRespTimeEndpoint {

	@Autowired
	private AssessEligibilityRespTimeService assessEligibilityRespTimeService;

	private static final String NAMESPACE_URI = "http://www.usp.br/stralibam/ws/assess_eligibility_resp_time";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "assessEligibilityRespTimeRequest")

	@ResponsePayload
	public AssessEligibilityRespTimeResponse assessEligibilityRespTimeRequest(@RequestPayload AssessEligibilityRespTimeRequest request) throws Exception {
		try {
			SloResult slo = assessEligibilityRespTimeService.getSLOResult();
			AssessEligibilityRespTimeResponse appPropertyResponse = new AssessEligibilityRespTimeResponse();
			SLOType sloType = new SLOType();
			sloType.setQoSMeasuredValue(slo.getIntegerTargetValue().toString());
			appPropertyResponse.getSlos().add(sloType);
			return appPropertyResponse;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}

	}

}
