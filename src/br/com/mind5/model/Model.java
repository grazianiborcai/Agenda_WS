package br.com.mind5.model;

import javax.ws.rs.core.Response;

public interface Model {
	public boolean executeRequest();
	
	public Response getResponse();
	
	public void close();
}
