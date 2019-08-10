package br.com.gda.model.common;

import java.util.Collections;
import java.util.List;

import javax.ws.rs.core.Response;

import br.com.gda.json.JsonResponseMaker;
import br.com.gda.json.standard.JstdResponseMaker;
import br.com.gda.model.ModelResponse;
import br.com.gda.model.decisionTree.DeciResult;

public final class ModelResponseError<T> implements ModelResponse<T> {
	
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
		Response.Status htmlStatus = Response.Status.INTERNAL_SERVER_ERROR;		
		JsonResponseMaker jsonMaker = new JstdResponseMaker();
		
		return jsonMaker.makeResponse(htmlStatus.toString(), 
									  htmlStatus.getStatusCode(), 
									  htmlStatus, 
									  Collections.emptyList());
	}

}
