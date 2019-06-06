package br.com.gda.resource;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.model.OrderModelCancel;
import br.com.gda.business.order.model.OrderModelPlace;
import br.com.gda.business.order.model.OrderModelSelect;
import br.com.gda.model.Model;

@Path("/Order")
public final class OrderResource {
	private static final String SELECT_ORDER = "/selectOrder";
	private static final String PLACE_ORDER = "/placeOrder";
	private static final String CANCEL_ORDER = "/cancelOrder";
	
	
	
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
		
		
		Model model = new OrderModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();	
	} 
	
	
	
	@GET
	@Path(PLACE_ORDER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response placeOrder(@HeaderParam("TOKEN_OWNER") 	@DefaultValue("-1") long codOwner, 
						  	   @HeaderParam("TOKEN_USERNAME")  String username,
							   @HeaderParam("codOrder")    	@DefaultValue("-1") long codOrder,
							   @HeaderParam("codLanguage") 	@DefaultValue("EN") String codLanguage) {
		
		OrderInfo recordInfo = new OrderInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.username = username;
		recordInfo.codOrder = codOrder;
		recordInfo.codLanguage = codLanguage;
		
		
		Model model = new OrderModelPlace(recordInfo);
		model.executeRequest();
		return model.getResponse();	
	} 
	
	
	
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
		
		
		Model model = new OrderModelCancel(recordInfo);
		model.executeRequest();
		return model.getResponse();	
	} 
}
