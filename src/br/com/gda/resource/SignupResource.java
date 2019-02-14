package br.com.gda.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.gda.business.owner.model.OwnerModelInsert;
import br.com.gda.model.Model;

@Path("/Signup")
public class SignupResource {

	private static final String OWNER = "/owner";	
	
	
	@POST
	@Path(OWNER)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response signupOwner(String incomingData) {		
		
		Model model = new OwnerModelInsert(incomingData);
		model.executeRequest();
		return model.getResponse();
	}
}
