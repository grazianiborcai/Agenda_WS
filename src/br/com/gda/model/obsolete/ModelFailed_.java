package br.com.gda.model.obsolete;

import javax.ws.rs.core.Response;

import br.com.gda.common.SystemMessage;
import br.com.gda.json.obsolete.JsonResponse;
import br.com.gda.model.Model;

public final class ModelFailed_ implements Model {
	private final boolean RESULT_FAILED = false;		
	private Response response;
	
	
	public ModelFailed_() {
		JsonResponse responseMaker = new JsonResponse(SystemMessage.ILLEGAL_ARGUMENT, 
				                                      Response.Status.BAD_REQUEST.getStatusCode(), 
				                                      Response.Status.BAD_REQUEST, 
				                                      new Object());
		response = responseMaker.makeResponse();
	}
	
	
	@Override public boolean executeRequest() {
		return RESULT_FAILED;
	}

	
	
	@Override public Response getResponse() {
		return response;
	}
}
