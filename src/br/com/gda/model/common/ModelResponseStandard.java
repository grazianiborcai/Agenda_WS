package br.com.gda.model.common;

import br.com.gda.json.JsonResponseMaker;
import br.com.gda.json.standard.JstdResponseMaker;
import br.com.gda.model.ModelResponseTemplate;

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
