package br.usp.stralibam.ws.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.usp.stralibam.service.CheckCredHistService;
import br.usp.stralibam.template.SloResult;
import br.usp.stralibam.ws.check_cred_hist.CheckCredAvaiRequest;
import br.usp.stralibam.ws.check_cred_hist.CheckCredAvaiResponse;
import br.usp.stralibam.ws.check_cred_hist.CheckCredControlRequest;
import br.usp.stralibam.ws.check_cred_hist.CheckCredControlResponse;
import br.usp.stralibam.ws.check_cred_hist.SLOType;

@Endpoint
public class CheckCredHistEndpoint {

	@Autowired
	private CheckCredHistService checkCredHistService;

	private static final String NAMESPACE_URI = "http://www.usp.br/stralibam/ws/check_cred_hist";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "checkCredHistRequest")

	@ResponsePayload
	public CheckCredAvaiResponse checkCredAvaiRequest(@RequestPayload CheckCredAvaiRequest request) throws Exception {
		try {
			SloResult slo = checkCredHistService.getSLOResult();
			CheckCredAvaiResponse appPropertyResponse = new CheckCredAvaiResponse();
			SLOType sloType = new SLOType();
			sloType.setQoSMeasuredValue(slo.getBooleanTargetValue().toString());
			appPropertyResponse.getSlos().add(sloType);
			return appPropertyResponse;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}

	}
	
	@ResponsePayload
	public CheckCredControlResponse checkCredControlRequest(@RequestPayload CheckCredControlRequest request) throws Exception {
		try {
			SloResult slo = checkCredHistService.getSLOResult();
			CheckCredControlResponse appPropertyResponse = new CheckCredControlResponse();
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
