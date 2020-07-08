package br.com.mind5.servlet.resource;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.mind5.business.customer.model.CusModelSignup;
import br.com.mind5.business.owner.model.OwnerModelSignup;
import br.com.mind5.model.Model;
import br.com.mind5.security.user.model.UserModelSignup;

@Path("/Signup")
public class SignupResource {

	private static final String OWNER = "/owner";	
	private static final String USER = "/user";
	private static final String CUSTOMER = "/customer";	
	
	
	@POST
	@Path(OWNER)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response signupOwner(@Context HttpServletRequest request, String incomingData) {		
		
		Model model = new OwnerModelSignup(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@POST
	@Path(USER)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response signupUser(@Context HttpServletRequest request, String incomingData) {		
		
		Model model = new UserModelSignup(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@POST
	@Path(CUSTOMER)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response signupCustomer(@Context HttpServletRequest request, String incomingData) {		
		
		Model model = new CusModelSignup(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
}
