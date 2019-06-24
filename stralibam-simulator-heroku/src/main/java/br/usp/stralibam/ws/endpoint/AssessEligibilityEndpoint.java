package br.usp.stralibam.ws.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.usp.stralibam.service.AssessEligibilityAvailabilityService;
import br.usp.stralibam.service.AssessEligibilityRespTimeService;
import br.usp.stralibam.template.SloResult;
import br.usp.stralibam.ws.assess_eligibility.AssessEligibilityRequest;
import br.usp.stralibam.ws.assess_eligibility.AssessEligibilityResponse;
import br.usp.stralibam.ws.assess_eligibility.SLOType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Endpoint
public class AssessEligibilityEndpoint {

	@Autowired
	private AssessEligibilityAvailabilityService assessEligibilityAvailabilityService;
	
	@Autowired
	private AssessEligibilityRespTimeService assessEligibilityRespTimeService;
	
	private static final String NAMESPACE_URI = "http://www.usp.br/stralibam/ws/assess_eligibility";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "assessEligibilityRequest")

	@ResponsePayload
	public AssessEligibilityResponse assessEligibilityAvailabilityRequest(@RequestPayload AssessEligibilityRequest request) throws Exception {
		try {
			
			SloResult slo = assessEligibilityAvailabilityService.getSLOResult();
			AssessEligibilityResponse appPropertyResponse = new AssessEligibilityResponse();
			SLOType sloType = new SLOType();
			sloType.setQoSMeasuredValue(slo.getBooleanTargetValue().toString());
			sloType.setId("ASSESS_ELEG_AVAIABILITY");
			sloType.setQoSAttribute("Availability");
			appPropertyResponse.getSlos().add(sloType);
			
			slo = assessEligibilityRespTimeService.getSLOResult();
			sloType = new SLOType();
			sloType.setQoSMeasuredValue(slo.getIntegerTargetValue().toString());
			sloType.setId("ASSESS_ELEG_RESP_TIME");
			sloType.setQoSAttribute("Response Time");
			appPropertyResponse.getSlos().add(sloType);
			
			return appPropertyResponse;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}

	}

}
