package br.com.mind5.model.common;

import br.com.mind5.info.InfoRecord;
import br.com.mind5.json.JsonResponseMaker;
import br.com.mind5.json.standard.JstdResponseMaker;
import br.com.mind5.model.ModelResponseTemplate;

public final class ModelResponseStandard<T extends InfoRecord> extends ModelResponseTemplate<T> {
	
	public ModelResponseStandard() {
		super();
	}
	
	
	
	@Override protected JsonResponseMaker getJsonReponseParserHook() {
		return new JstdResponseMaker();
	}
}
