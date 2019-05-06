package br.usp.stralibam.ws.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.usp.stralibam.service.AssessEligibilityAvailabilityService;
import br.usp.stralibam.template.SloResult;
import br.usp.stralibam.ws.assess_eligibility_availability.AssessEligibilityAvailabilityRequest;
import br.usp.stralibam.ws.assess_eligibility_availability.AssessEligibilityAvailabilityResponse;
import br.usp.stralibam.ws.assess_eligibility_availability.SLOType;

@Endpoint
public class AssessEligibilityAvailabilityEndpoint {

	@Autowired
	private AssessEligibilityAvailabilityService assessEligibilityAvailabilityService;

	private static final String NAMESPACE_URI = "http://www.usp.br/stralibam/ws/assess_eligibility_availability";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "assessEligibilityAvailabilityRequest")

	@ResponsePayload
	public AssessEligibilityAvailabilityResponse assessEligibilityAvailabilityRequest(@RequestPayload AssessEligibilityAvailabilityRequest request) throws Exception {
		try {
			SloResult slo = assessEligibilityAvailabilityService.getSLOResult();
			AssessEligibilityAvailabilityResponse appPropertyResponse = new AssessEligibilityAvailabilityResponse();
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
