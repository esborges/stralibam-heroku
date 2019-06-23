package br.usp.stralibam.ws.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.usp.stralibam.service.SendAccepPackService;
import br.usp.stralibam.template.SloResult;
import br.usp.stralibam.ws.send_accep_pack.SLOType;
import br.usp.stralibam.ws.send_accep_pack.SendAccepPackRequest;
import br.usp.stralibam.ws.send_accep_pack.SendAccepPackResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Endpoint
public class SendAccepPackEndpoint {

	@Autowired
	private SendAccepPackService checkCredHistService;
	
	@Autowired
	private Environment env;

	private static final String NAMESPACE_URI = "http://www.usp.br/stralibam/ws/send_accep_pack";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "sendAccepPackRequest")

	@ResponsePayload
	public SendAccepPackResponse sendAccepPackRequest(@RequestPayload SendAccepPackRequest request) throws Exception {
		try {
			Boolean instability = new Boolean(env.getProperty("application.instability"));
			
			SloResult slo = checkCredHistService.getSLOResult();
			SendAccepPackResponse appPropertyResponse = new SendAccepPackResponse();
			
			SLOType sloType = new SLOType();
			sloType.setQoSMeasuredValue(instability ? slo.getBooleanTargetValue().toString() : "true");
			sloType.setId("SEND_ACCEP_PACK_AVAILA");
			sloType.setQoSAttribute("Availability");
			appPropertyResponse.getSlos().add(sloType);
			
			return appPropertyResponse;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}

	}
	
}
