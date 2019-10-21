package br.com.mind5.model.common;

import br.com.mind5.json.JsonResponseMaker;
import br.com.mind5.json.standard.JstdResponseMaker;
import br.com.mind5.model.ModelResponseTemplate;

public final class ModelResponseStandard<T> extends ModelResponseTemplate<T> {
	
	public ModelResponseStandard() {
		super();
	}
	
	
	
	@Override protected JsonResponseMaker getJsonReponseParserHook() {
		return new JstdResponseMaker();
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
