package br.com.gda.resource;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.model.CartModelDelete;
import br.com.gda.business.cart.model.CartModelInsert;
import br.com.gda.business.cart.model.CartModelSelect;
import br.com.gda.business.cart.model.CartModelUpdate;
import br.com.gda.business.reserve.info.ReserveInfo;
import br.com.gda.business.reserve.model.ReserveModelSelect;
import br.com.gda.model.Model;

@Path("/Cart")
public final class CartResource {
	private static final String INSERT_CART = "/insertCart"	;
	private static final String UPDATE_CART = "/updateCart"	;
	private static final String SELECT_CART = "/selectCart"	;
	private static final String DELETE_CART = "/deleteCart"	;
	private static final String SELECT_RESERVE = "/selectReserve"	;
	
	
	@POST
	@Path(INSERT_CART)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertCart(String incomingData) {
		
		Model model = new CartModelInsert(incomingData);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	
	@POST
	@Path(UPDATE_CART)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCart(String incomingData) {
		
		Model model = new CartModelUpdate(incomingData);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	
	@GET
	@Path(SELECT_CART)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectCart(@HeaderParam("codOwner")    @DefaultValue("-1") long codOwner, 
							   @HeaderParam("codCustomer") @DefaultValue("-1") long codCustomer,
							   @HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage) {
		
		CartInfo recordInfo = new CartInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codCustomer = codCustomer;
		recordInfo.codLanguage = codLanguage;
		
		
		Model model = new CartModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	
	@DELETE
	@Path(DELETE_CART)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCart(@HeaderParam("codOwner")    @DefaultValue("-1") long codOwner, 
							   @HeaderParam("codCustomer") @DefaultValue("-1") long codCustomer,
							   @HeaderParam("itemNumber")  @DefaultValue("-1") int itemNumber,
							   @HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage) {
		
		CartInfo recordInfo = new CartInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codCustomer = codCustomer;
		recordInfo.itemNumber = itemNumber;
		recordInfo.codLanguage = codLanguage;
		
		
		Model model = new CartModelDelete(recordInfo);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	//TODO: Remover?
	@GET
	@Path(SELECT_RESERVE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectReserve(@HeaderParam("codOwner")    @DefaultValue("-1") long codOwner,
							      @HeaderParam("codMaterial") @DefaultValue("-1") long codMat,
							      @HeaderParam("codEmployee") @DefaultValue("-1") long codEmployee,
							      @HeaderParam("codStore")    @DefaultValue("-1") long codStore,
							      @HeaderParam("date")        @DefaultValue("1900-01-01") String date,
							      @HeaderParam("beginTime")   @DefaultValue("12:00") String beginTime,
							      @HeaderParam("endTime")     @DefaultValue("12:00") String endTime) {
		
		ReserveInfo recordInfo = new ReserveInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codMat = codMat;
		recordInfo.codEmployee = codEmployee;
		recordInfo.codStore = codStore;
		recordInfo.date = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
		recordInfo.beginTime = LocalTime.parse(beginTime, DateTimeFormatter.ISO_LOCAL_TIME);
		recordInfo.endTime = LocalTime.parse(endTime, DateTimeFormatter.ISO_LOCAL_TIME);
		
		
		Model model = new ReserveModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();	
	}
}
