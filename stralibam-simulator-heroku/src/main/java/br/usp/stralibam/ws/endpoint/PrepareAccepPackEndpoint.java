package br.usp.stralibam.ws.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.usp.stralibam.ws.prepare_accep_pack.PrepareAccepPackRequest;
import br.usp.stralibam.ws.prepare_accep_pack.PrepareAccepPackResponse;
import lombok.extern.slf4j.Slf4j;

@Endpoint
@Slf4j
public class PrepareAccepPackEndpoint {

	private static final String NAMESPACE_URI = "http://www.usp.br/stralibam/ws/prepare_accep_pack";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "prepareAccepPackRequest")

	@ResponsePayload
	public PrepareAccepPackResponse prepareAccepPackRequest(@RequestPayload PrepareAccepPackRequest request) throws Exception {
		log.info("Prepare Accep Pack");
		
		return null;

	}
	
}
