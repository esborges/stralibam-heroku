package br.usp.stralibam.ws.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.usp.stralibam.ws.register_elegibility.RegisterElegibilityRequest;
import br.usp.stralibam.ws.register_elegibility.RegisterElegibilityResponse;
import lombok.extern.slf4j.Slf4j;

@Endpoint
@Slf4j
public class RegisterElegibilityEndpoint {

	private static final String NAMESPACE_URI = "http://www.usp.br/stralibam/ws/register_elegibility";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "registerElegibilityRequest")

	@ResponsePayload
	public RegisterElegibilityResponse registerElegibilityRequest(@RequestPayload RegisterElegibilityRequest request) throws Exception {
		log.info("Register Elegibility");
		
		return null;

	}
	
}
