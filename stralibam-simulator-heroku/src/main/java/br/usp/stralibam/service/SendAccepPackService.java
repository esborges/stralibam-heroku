package br.usp.stralibam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.six2six.fixturefactory.Fixture;
import br.usp.stralibam.template.SloExecutionTemplate;
import br.usp.stralibam.template.SloResult;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SendAccepPackService {
	
	@Autowired
	private SloExecutionTemplate sloExecutionTemplate;

	public SloResult getSLOResult() {
		
		sloExecutionTemplate.load();

		SloResult sloResult = null;
		sloResult = Fixture.from(SloResult.class).gimme("slo_boolean_result");
		
		if(sloResult.getIntegerTargetValue() <= 7) {
			sloResult.setBooleanTargetValue(true);
		} else {
			sloResult.setBooleanTargetValue(false);
		}
		
		log.info("result -> " + sloResult.getBooleanTargetValue());
		return sloResult;
	}
}
