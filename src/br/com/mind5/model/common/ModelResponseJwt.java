package br.com.mind5.model.common;

import javax.ws.rs.core.Response;

import br.com.mind5.info.InfoRecord;
import br.com.mind5.json.JsonResponseMaker;
import br.com.mind5.json.standard.JstdResponseMaker;
import br.com.mind5.model.ModelResponseTemplate;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;
import br.com.mind5.servlet.filter.common.HeaderJwtToken;

public final class ModelResponseJwt<T extends InfoRecord> extends ModelResponseTemplate<T> {
	
	public ModelResponseJwt() {
		super();
	}
	
	
	
	@Override protected JsonResponseMaker getJsonReponseParserHook() {
		return new JstdResponseMaker();
	}
	
	
	
	@Override protected Response addHeaderParamHook(Response response, T lastRecord) {
		JwtokenInfo jwtoken = JwtokenInfo.copyFrom(lastRecord);
		
		return HeaderJwtToken.addJwtToken(response, jwtoken);
	}
}
