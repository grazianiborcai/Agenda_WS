package br.com.gda.model;

import javax.ws.rs.core.Response;

public interface Model {
	public boolean executeRequest();
	
	public Response getResponse();
}
