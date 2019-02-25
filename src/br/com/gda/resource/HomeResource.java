package br.com.gda.resource;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/Home")
@Produces(MediaType.APPLICATION_JSON)
public class HomeResource {

	private static final String MAIN = "/main";	
	
	
	@GET
	@Path(MAIN)	
	public Response main(@HeaderParam("codOwner") @DefaultValue("-1") long codOwner,
                         @HeaderParam("Username") String username,
                         @HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage) {		
		
		return Response.ok().build();
	}
}
