package br.com.gda.resource;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.StoreModelDelete;
import br.com.gda.business.store.model.StoreModelInsert;
import br.com.gda.business.store.model.StoreModelSelect;
import br.com.gda.business.store.model.StoreModelUpdate;
import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.business.storeLeaveDate.model.StolevateModelDelete;
import br.com.gda.business.storeLeaveDate.model.StolevateModelInsert;
import br.com.gda.business.storeLeaveDate.model.StolevateModelSelect;
import br.com.gda.business.storeLeaveDate.model.StolevateModelUpdate;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.business.storeList.model.StolisModelSelect;
import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.business.storeWorkTime.model.StowotmModelDelete;
import br.com.gda.business.storeWorkTime.model.StowotmModelInsert;
import br.com.gda.business.storeWorkTime.model.StowotmModelSelect;
import br.com.gda.business.storeWorkTime.model.StowotmModelUpdate;
import br.com.gda.business.storeWorkTimeConflict.info.StoreCoInfo;
import br.com.gda.business.storeWorkTimeConflict.model.StoreCoModelSelect;
import br.com.gda.model.Model;
import br.com.gda.payment.storePartner.info.StoparInfo;
import br.com.gda.payment.storePartner.model.StoparModelDelete;
import br.com.gda.payment.storePartner.model.StoparModelInsert;
import br.com.gda.payment.storePartner.model.StoparModelSelect;
import br.com.gda.payment.storePartner.model.StoparModelUpdate;

@Path("/Store")
@Produces(MediaType.APPLICATION_JSON)
public class StoreResource {

	private static final String INSERT_STORE = "/insertStore";
	private static final String UPDATE_STORE = "/updateStore";
	private static final String DELETE_STORE = "/deleteStore";
	private static final String SELECT_STORE = "/selectStore";
	private static final String SELECT_STORE_LIST = "/selectStoreList";
	private static final String SELECT_STORE_WTIME = "/selectStoreWorkTime";
	private static final String INSERT_STORE_WTIME = "/insertStoreWorkTime";
	private static final String DELETE_STORE_WTIME = "/deleteStoreWorkTime";
	private static final String UPDATE_STORE_WTIME = "/updateStoreWorkTime";
	private static final String SELECT_STORE_LDATE = "/selectStoreLeaveDate";
	private static final String INSERT_STORE_LDATE = "/insertStoreLeaveDate";
	private static final String UPDATE_STORE_LDATE = "/updateStoreLeaveDate";
	private static final String DELETE_STORE_LDATE = "/deleteStoreLeaveDate";
	private static final String SELECT_STORE_WT_CONFLICT = "/selectStoreWorkTimeConflict";
	private static final String SELECT_STORE_PAY_PARTNER = "/selectPayPartner";				//TODO: rever esse fluxo. Eliminar ?
	private static final String INSERT_STORE_PAY_PARTNER = "/insertPayPartner";				//TODO: rever esse fluxo. Eliminar ?
	private static final String UPDATE_STORE_PAY_PARTNER = "/updatePayPartner";				//TODO: rever esse fluxo. Eliminar ?
	private static final String DELETE_STORE_PAY_PARTNER = "/deletePayPartner";				//TODO: rever esse fluxo. Eliminar ?

	
	@POST
	@Path(INSERT_STORE)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertStore(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new StoreModelInsert(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}
	
	

	@POST
	@Path(UPDATE_STORE)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStore(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new StoreModelUpdate(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}
	

	
	@DELETE
	@Path(DELETE_STORE)
	public Response deleteStore(@HeaderParam("TOKEN_OWNER")    	@DefaultValue("-1") long codOwner, 
			                    @HeaderParam("codStore")       	@DefaultValue("-1") long codStore,
			                    @HeaderParam("codLanguage")		@DefaultValue("EN") String codLanguage,
			                    @HeaderParam("TOKEN_USERNAME") String username) {
		
		StoreInfo recordInfo = new StoreInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		
		Model model = new StoreModelDelete(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}

	
	
	@GET
	@Path(SELECT_STORE)
	public Response selectStore(@HeaderParam("TOKEN_OWNER")    @DefaultValue("-1") long codOwner, 
			                    @HeaderParam("codStore")       @DefaultValue("-1") int codStore,
			                    @HeaderParam("codLanguage")	   @DefaultValue("EN") String codLanguage,
			                    @HeaderParam("TOKEN_USERNAME") String username) {

		StoreInfo recordInfo = new StoreInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		
		Model model = new StoreModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_STORE_LIST)
	public Response selectStolis(@HeaderParam("TOKEN_OWNER")    @DefaultValue("-1") long codOwner, 
			                     @HeaderParam("codStore")       @DefaultValue("-1") int codStore,
			                     @HeaderParam("codLanguage")	   @DefaultValue("EN") String codLanguage,
			                     @HeaderParam("TOKEN_USERNAME") String username) {

		StolisInfo recordInfo = new StolisInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		
		Model model = new StolisModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_STORE_WTIME)
	public Response selectStoreWTime(@HeaderParam("TOKEN_OWNER") @DefaultValue("-1") long codOwner, 
			                         @HeaderParam("codStore")    @DefaultValue("-1") int codStore,
			                         @HeaderParam("codWeekday")  @DefaultValue("-1") int codWeekday,			                         
			                         @HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                         @HeaderParam("TOKEN_USERNAME") String username) {

		StowotmInfo recordInfo = new StowotmInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codWeekday = codWeekday;
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		
		Model model = new StowotmModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_STORE_WTIME)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertStoreWTime(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new StowotmModelInsert(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@DELETE
	@Path(DELETE_STORE_WTIME)
	public Response deleteStoreWTime(@HeaderParam("TOKEN_OWNER") @DefaultValue("-1") long codOwner, 
			                         @HeaderParam("codStore")    @DefaultValue("-1") int codStore,
			                         @HeaderParam("codWeekday")  @DefaultValue("-1") int codWeekday,
			                         @HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                         @HeaderParam("TOKEN_USERNAME") String username) {
		
		StowotmInfo recordInfo = new StowotmInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codWeekday = codWeekday;
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		
		Model model = new StowotmModelDelete(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(UPDATE_STORE_WTIME)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStoreWTime(@Context HttpServletRequest request, String incomingData) {

		Model model = new StowotmModelUpdate(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_STORE_LDATE)
	public Response selectStoreLDate(@HeaderParam("TOKEN_OWNER") @DefaultValue("-1") long codOwner, 
			                         @HeaderParam("codStore") 	 @DefaultValue("-1") int codStore,
			                         @HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                         @HeaderParam("date")	  	 @DefaultValue("1900-01-01") String date) {

		StolevateInfo recordInfo = new StolevateInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codLanguage = codLanguage;
		recordInfo.dateValidFrom = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);	//TODO: criar/mover para uma classe
		recordInfo.dateValidTo = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);	//TODO: criar/mover para uma classe
		
		Model model = new StolevateModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_STORE_LDATE)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertStoreLDate(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new StolevateModelInsert(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(UPDATE_STORE_LDATE)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStoreLDate(@Context HttpServletRequest request, String incomingData) {

		Model model = new StolevateModelUpdate(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@DELETE
	@Path(DELETE_STORE_LDATE)
	public Response deleteStoreLDate(@HeaderParam("TOKEN_OWNER")   @DefaultValue("-1") long codOwner, 
			                         @HeaderParam("codStore")      @DefaultValue("-1") int codStore,
			                         @HeaderParam("codLanguage")   @DefaultValue("EN") String codLanguage,
			                         @HeaderParam("dateValidFrom") @DefaultValue("1900-01-01") String dateValidFrom,
			                         @HeaderParam("timeValidFrom") @DefaultValue("12:00") String timeValidFrom,
			                         @HeaderParam("TOKEN_USERNAME") String username) {
		
		//TODO: adicionar filtros para dar um parse nas datas
		StolevateInfo recordInfo = new StolevateInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		recordInfo.dateValidFrom = LocalDate.parse(dateValidFrom, DateTimeFormatter.ISO_LOCAL_DATE);
		recordInfo.timeValidFrom = LocalTime.parse(timeValidFrom, DateTimeFormatter.ISO_LOCAL_TIME);
		
		Model model = new StolevateModelDelete(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_STORE_WT_CONFLICT)
	public Response selectStoreWTimeConflict(@HeaderParam("codOwner")   @DefaultValue("-1") long codOwner, 
			                                 @HeaderParam("codStore")   @DefaultValue("-1") int codStore,
			                                 @HeaderParam("codWeekday") @DefaultValue("-1") int codWeekday,
			                                 @HeaderParam("beginTime")  @DefaultValue("12:00") String beginTime,
			                                 @HeaderParam("endTime")    @DefaultValue("12:00") String endTime) {

		StoreCoInfo recordInfo = new StoreCoInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codWeekday = codWeekday;
		recordInfo.beginTime = LocalTime.parse(beginTime, DateTimeFormatter.ISO_LOCAL_TIME);
		recordInfo.endTime = LocalTime.parse(endTime, DateTimeFormatter.ISO_LOCAL_TIME);
		
		Model model = new StoreCoModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_STORE_PAY_PARTNER)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertStopar(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new StoparModelInsert(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}
	
	

	@POST
	@Path(UPDATE_STORE_PAY_PARTNER)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStopar(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new StoparModelUpdate(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}
	

	
	@DELETE
	@Path(DELETE_STORE_PAY_PARTNER)
	public Response deleteStopar(@HeaderParam("TOKEN_OWNER")    	@DefaultValue("-1") long codOwner, 
			                     @HeaderParam("codStore")       	@DefaultValue("-1") long codStore,
			                     @HeaderParam("codPayPartner")      @DefaultValue("-1") int codPayPartner,
			                     @HeaderParam("codLanguage")		@DefaultValue("EN") String codLanguage,
			                     @HeaderParam("TOKEN_USERNAME") String username) {
		
		StoparInfo recordInfo = new StoparInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codPayPartner = codPayPartner;
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		
		Model model = new StoparModelDelete(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}

	
	
	@GET
	@Path(SELECT_STORE_PAY_PARTNER)
	public Response selectStopar(@HeaderParam("TOKEN_OWNER")    @DefaultValue("-1") long codOwner, 
			                     @HeaderParam("codStore")       @DefaultValue("-1") int codStore,
			                     @HeaderParam("codLanguage")	@DefaultValue("EN") String codLanguage,
			                     @HeaderParam("TOKEN_USERNAME") String username) {

		StoparInfo recordInfo = new StoparInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		
		Model model = new StoparModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
}
