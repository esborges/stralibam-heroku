package br.usp.stralibam.ws.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.usp.stralibam.ws.check_application.CheckApplicationRequest;
import br.usp.stralibam.ws.check_application.CheckApplicationResponse;
import lombok.extern.slf4j.Slf4j;

@Endpoint
@Slf4j
public class CheckApplicationEndpoint {

	private static final String NAMESPACE_URI = "http://www.usp.br/stralibam/ws/check_application";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "checkApplicationRequest")

	@ResponsePayload
	public CheckApplicationResponse sendAccepPackRequest(@RequestPayload CheckApplicationRequest request) throws Exception {
		log.info("Check Application");
		
		return null;

	}
	
}
