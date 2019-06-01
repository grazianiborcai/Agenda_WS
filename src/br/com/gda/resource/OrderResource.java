package br.com.gda.resource;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.gda.business.orderItem.info.OrderInfo;
import br.com.gda.business.orderItem.model.OrderModelPlace;
import br.com.gda.business.orderItem.model.OrderModelSelect;
import br.com.gda.model.Model;

@Path("/Order")
public final class OrderResource {
	private static final String SELECT_ORDER = "/selectOrder"	;
	private static final String PLACE_ORDER = "/placeOrder";
	
	
	
	@GET
	@Path(SELECT_ORDER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectOrder(@HeaderParam("codOwner")    @DefaultValue("-1") long codOwner, 
							    @HeaderParam("codUser")     @DefaultValue("-1") long codUser,
							    @HeaderParam("codOrder")    @DefaultValue("-1") long codOrder,
							    @HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage) {
		
		OrderInfo recordInfo = new OrderInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codUser = codUser;
		recordInfo.codOrder = codOrder;
		recordInfo.codLanguage = codLanguage;
		
		
		Model model = new OrderModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();	
	} 
	
	
	
	@POST
	@Path(PLACE_ORDER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response orderPlace(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new OrderModelPlace(incomingData, request);
		model.executeRequest();
		return model.getResponse();	
	}
}
