package br.com.gda.resource;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.gda.business.order.model.OrderModelPlace;
import br.com.gda.model.Model;

@Path("/Order")
public final class OrderResource {
	//private static final String SELECT_CART = "/selectCart"	;
	private static final String ORDER_PLACE = "/orderPlace";
	
	
	/*
	@GET
	@Path(SELECT_CART)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectCart(@HeaderParam("codOwner")    @DefaultValue("-1") long codOwner, 
							   @HeaderParam("codUser")     @DefaultValue("-1") long codUser,
							   @HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage) {
		
		CartInfo recordInfo = new CartInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codUser = codUser;
		recordInfo.codLanguage = codLanguage;
		
		
		Model model = new CartModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();	
	} */
	
	
	
	@POST
	@Path(ORDER_PLACE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response orderPlace(String incomingData) {
		
		Model model = new OrderModelPlace(incomingData);
		model.executeRequest();
		return model.getResponse();	
	}
}
