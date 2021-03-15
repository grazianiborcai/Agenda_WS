package br.com.mind5.servlet.resource;

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

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.OrderModelCancelAuth;
import br.com.mind5.business.order.model.OrderModelPlaceAuth;
import br.com.mind5.business.order.model.OrderModelSelectAuth;
import br.com.mind5.business.orderHistoryDecorated.model.OrdorycoModelSearchAuth;
import br.com.mind5.business.orderList.model.OrdistModelSearchAuth;
import br.com.mind5.model.Model;

@Path("/Order")
public final class OrderResource {
	private static final String CANCEL_ORDER = "/cancelOrder";
	private static final String PLACE_ORDER = "/placeOrder";
	private static final String SEARCH_ORDER = "/searchOrder";
	private static final String SEARCH_HISTORY_ORDER = "/searchHistoryOrder";
	private static final String SELECT_ORDER = "/selectOrder";	
	
	
	
	@GET
	@Path(CANCEL_ORDER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cancelOrder(@HeaderParam("TOKEN_OWNER") 	@DefaultValue("-1") long codOwner, 
						  	    @HeaderParam("TOKEN_USERNAME")  String username,
							    @HeaderParam("codOrder")    	@DefaultValue("-1") long codOrder,
							    @HeaderParam("codLanguage") 	@DefaultValue("EN") String codLanguage) {
		
		OrderInfo recordInfo = new OrderInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.username = username;
		recordInfo.codOrder = codOrder;
		recordInfo.codLanguage = codLanguage;		
		
		Model model = new OrderModelCancelAuth(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(PLACE_ORDER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response placeOrder(@HeaderParam("TOKEN_OWNER") 		@DefaultValue("-1") long codOwner, 
						  	   @HeaderParam("TOKEN_USERNAME")  	String username,
							   @HeaderParam("codOrder")    		@DefaultValue("-1") long codOrder,
							   @HeaderParam("codLanguage") 		@DefaultValue("EN") String codLanguage) {
		
		OrderInfo recordInfo = new OrderInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.username = username;
		recordInfo.codOrder = codOrder;
		recordInfo.codLanguage = codLanguage;		
		
		Model model = new OrderModelPlaceAuth(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@POST
	@Path(SEARCH_ORDER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchOrdist(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new OrdistModelSearchAuth(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@POST
	@Path(SEARCH_HISTORY_ORDER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchOrdory(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new OrdorycoModelSearchAuth(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_ORDER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectOrder(@HeaderParam("TOKEN_OWNER") 	@DefaultValue("-1") long codOwner, 
								@HeaderParam("TOKEN_USERNAME")  String username,
							    @HeaderParam("codOrder")    	@DefaultValue("-1") long codOrder,
							    @HeaderParam("codOrderStatus")  String codOrderStatus,
							    @HeaderParam("codLanguage") 	@DefaultValue("EN") String codLanguage) {
		
		OrderInfo recordInfo = new OrderInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.username = username;
		recordInfo.codOrder = codOrder;
		recordInfo.codOrderStatus = codOrderStatus;
		recordInfo.codLanguage = codLanguage;		
		
		Model model = new OrderModelSelectAuth(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	} 
}
