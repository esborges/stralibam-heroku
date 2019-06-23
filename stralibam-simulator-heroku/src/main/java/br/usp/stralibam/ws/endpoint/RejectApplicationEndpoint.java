package br.usp.stralibam.ws.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.usp.stralibam.ws.reject_application.RejectApplicationRequest;
import br.usp.stralibam.ws.reject_application.RejectApplicationResponse;
import lombok.extern.slf4j.Slf4j;

@Endpoint
@Slf4j
public class RejectApplicationEndpoint {

	private static final String NAMESPACE_URI = "http://www.usp.br/stralibam/ws/reject_application";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "rejectApplicationRequest")

	@ResponsePayload
	public RejectApplicationResponse sendAccepPackRequest(@RequestPayload RejectApplicationRequest request) throws Exception {
		log.info("Reject Application");
		
		return null;

	}
	
}
