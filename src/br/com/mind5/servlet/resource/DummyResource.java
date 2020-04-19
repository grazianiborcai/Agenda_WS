package br.com.mind5.servlet.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/Dummy")
public final class DummyResource {	
	
	@GET
	@Path("selectDummy")
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectDummy() {

		return Response.status(Response.Status.OK)
			       .entity("")
			       .type(MediaType.APPLICATION_JSON)
			       .build();
	}
	
	
}
