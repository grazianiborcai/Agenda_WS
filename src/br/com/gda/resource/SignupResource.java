package br.com.gda.resource;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.gda.business.customer.model.CusModelSignup;
import br.com.gda.business.owner.model.OwnerModelInsert;
import br.com.gda.model.Model;

@Path("/Signup")
public class SignupResource {

	private static final String OWNER = "/owner";	
	private static final String CUSTOMER = "/customer";	
	
	
	@POST
	@Path(OWNER)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response signupOwner(@Context HttpServletRequest request, String incomingData) {		
		
		Model model = new OwnerModelInsert(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(CUSTOMER)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response signupCustomer(@Context HttpServletRequest request, String incomingData) {		
		
		Model model = new CusModelSignup(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}
}
