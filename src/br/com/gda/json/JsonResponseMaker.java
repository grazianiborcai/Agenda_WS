package br.com.gda.json;

import javax.ws.rs.core.Response;

public interface JsonResponseMaker {
	public Response makeResponse(String msg, Response.Status htmlStatus, Object dataObj);
	
	public Response makeResponse(String msg, int msgCode, Response.Status htmlStatus, Object dataObj);
}
