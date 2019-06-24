package br.usp.stralibam.template;

import org.springframework.stereotype.Component;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

@Component
public class SloExecutionTemplate implements TemplateLoader {

	@Override
	public void load() {
		
		Fixture.of(SloResult.class).addTemplate("slo_boolean_result", new Rule() {
            {
                add("integerTargetValue", random(Integer.class, range(1, 10)));
            }
        });	
		
		Fixture.of(SloResult.class).addTemplate("slo_integer_result_menor_60", new Rule() {
            {
                add("integerTargetValue", random(Integer.class, range(10, 60)));
            }
        });
		
		Fixture.of(SloResult.class).addTemplate("slo_integer_result_maior_60", new Rule() {
            {
                add("integerTargetValue", random(Integer.class, range(61, 120)));
            }
        });
	}
	
}