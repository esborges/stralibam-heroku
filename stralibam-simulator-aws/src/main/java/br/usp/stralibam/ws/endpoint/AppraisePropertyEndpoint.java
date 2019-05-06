package br.usp.stralibam.ws.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.usp.stralibam.service.AppraisePropertyService;
import br.usp.stralibam.template.SloResult;
import br.usp.stralibam.ws.app_property.AppPropertyRequest;
import br.usp.stralibam.ws.app_property.AppPropertyResponse;
import br.usp.stralibam.ws.app_property.SLOType;

@Endpoint
public class AppraisePropertyEndpoint {

	@Autowired
	private AppraisePropertyService appraisePropertyService;

	private static final String NAMESPACE_URI = "http://www.usp.br/stralibam/ws/app_property";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "appPropertyRequest")

	@ResponsePayload
	public AppPropertyResponse appPropertyRequest(@RequestPayload AppPropertyRequest request) throws Exception {
		try {
			SloResult slo = appraisePropertyService.getSLOResult();
			AppPropertyResponse appPropertyResponse = new AppPropertyResponse();
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
