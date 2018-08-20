package br.com.gda.resource;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.gda.business.cart.model.CartModelInsert;
import br.com.gda.model.Model;

@Path("/Cart")
public final class CartResource {
	private static final String INSERT_CART 	= "/insertCart"	;
	
	
	@POST
	@Path(INSERT_CART)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectOwner(String incomingData) {
		
		Model model = new CartModelInsert(incomingData);
		model.executeRequest();
		return model.getResponse();	
	}
}
