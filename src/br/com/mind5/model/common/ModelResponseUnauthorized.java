package br.com.mind5.model.common;

import java.util.Collections;
import java.util.List;

import javax.ws.rs.core.Response;

import br.com.mind5.info.InfoRecord;
import br.com.mind5.json.JsonResponseMaker;
import br.com.mind5.json.standard.JstdResponseMaker;
import br.com.mind5.model.ModelResponse;
import br.com.mind5.model.decisionTree.DeciResult;

public final class ModelResponseUnauthorized<T extends InfoRecord> implements ModelResponse<T> {
	
	@Override public void addTreeResults(List<DeciResult<T>> results) {
		//DO NOTHING
	}


	
	@Override public void addTreeResult(DeciResult<T> result) {
		//DO NOTHING
	}


	
	@Override public Response build() {
		return buildResult();
	}
	
	
	
	private Response buildResult() {
		Response.Status htmlStatus = Response.Status.UNAUTHORIZED;		
		JsonResponseMaker jsonMaker = new JstdResponseMaker();
		
		return jsonMaker.makeResponse(htmlStatus.toString(), 
									  htmlStatus.getStatusCode(), 
									  htmlStatus, 
									  Collections.emptyList());
	}

}
