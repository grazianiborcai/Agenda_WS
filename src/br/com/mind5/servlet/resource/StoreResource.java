package br.com.mind5.servlet.resource;

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

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.StoreModelDelete;
import br.com.mind5.business.store.model.StoreModelInsert;
import br.com.mind5.business.store.model.StoreModelSelect;
import br.com.mind5.business.store.model.StoreModelUpdate;
import br.com.mind5.business.storeCatalogue.model.StogueModelSelect;
import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.business.storeFavorite.model.StoriteModelDeleteAuth;
import br.com.mind5.business.storeFavorite.model.StoriteModelInsertAuth;
import br.com.mind5.business.storeFavorite.model.StoriteModelSearchAuth;
import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.model.StolateModelDelete;
import br.com.mind5.business.storeLeaveDate.model.StolateModelInsert;
import br.com.mind5.business.storeLeaveDate.model.StolateModelSearch;
import br.com.mind5.business.storeLeaveDate.model.StolateModelSelect;
import br.com.mind5.business.storeLeaveDate.model.StolateModelUpdate;
import br.com.mind5.business.storeList.model.StolisModelSearch;
import br.com.mind5.business.storeNearby.model.StorbyModelSelect;
import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.model.StowotmModelDelete;
import br.com.mind5.business.storeWorkTime.model.StowotmModelInsert;
import br.com.mind5.business.storeWorkTime.model.StowotmModelSearch;
import br.com.mind5.business.storeWorkTime.model.StowotmModelSelect;
import br.com.mind5.business.storeWorkTime.model.StowotmModelUpdate;
import br.com.mind5.model.Model;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;
import br.com.mind5.payment.storePartnerList.model.StoplisModelSearch;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.info.AccemoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.AccemoipModelUrl;

@Path("/Store")
@Produces(MediaType.APPLICATION_JSON)
public class StoreResource {
	private static final String INSERT_STORE = "/insertStore";
	private static final String UPDATE_STORE = "/updateStore";
	private static final String DELETE_STORE = "/deleteStore";
	private static final String SELECT_STORE = "/selectStore";
	private static final String SEARCH_STORE = "/searchStore";
	private static final String SELECT_STORE_CATALOGUE = "/selectStoreCatalogue";
	private static final String SELECT_STORE_NEARBY = "/selectStoreNearby";			//TODO: Remover
	private static final String SELECT_STORE_WTIME = "/selectStoreWorkTime";
	private static final String SEARCH_STORE_WTIME = "/searchStoreWorkTime";
	private static final String INSERT_STORE_WTIME = "/insertStoreWorkTime";
	private static final String DELETE_STORE_WTIME = "/deleteStoreWorkTime";
	private static final String UPDATE_STORE_WTIME = "/updateStoreWorkTime";
	private static final String SELECT_STORE_LDATE = "/selectStoreLeaveDate";
	private static final String SEARCH_STORE_LDATE = "/searchStoreLeaveDate";
	private static final String INSERT_STORE_LDATE = "/insertStoreLeaveDate";
	private static final String UPDATE_STORE_LDATE = "/updateStoreLeaveDate";
	private static final String DELETE_STORE_LDATE = "/deleteStoreLeaveDate";	
	private static final String SELECT_STORE_PAY_PARTNER_LIST = "/selectPayPartnerList";
	private static final String GRANT_MOIP = "/grantMoip";
	private static final String INSERT_STORE_FAVORITE = "/insertStoreFavorite";
	private static final String DELETE_STORE_FAVORITE = "/deleteStoreFavorite";
	private static final String SEARCH_STORE_FAVORITE = "/searchStoreFavorite";	

	
	@POST
	@Path(INSERT_STORE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertStore(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new StoreModelInsert(incomingData, request);
		model.executeRequest();
		Response response = model.getResponse();
		
		model.close();
		return response;
	}
	
	

	@POST
	@Path(UPDATE_STORE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateStore(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new StoreModelUpdate(incomingData, request);
		model.executeRequest();
		Response response = model.getResponse();
		
		model.close();
		return response;
	}
	

	
	@DELETE
	@Path(DELETE_STORE)
	@Produces(MediaType.APPLICATION_JSON)
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
		Response response = model.getResponse();
		
		model.close();
		return response;
	}

	
	
	@GET
	@Path(SELECT_STORE)
	@Produces(MediaType.APPLICATION_JSON)
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
		Response response = model.getResponse();
		
		model.close();
		return response;
	}
	
	
	
	@POST
	@Path(SEARCH_STORE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchStore(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new StolisModelSearch(incomingData, request);
		model.executeRequest();
		Response response = model.getResponse();
		
		model.close();
		return response;
	}
	
	
	
	@POST
	@Path(SELECT_STORE_CATALOGUE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectStogue(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new StogueModelSelect(incomingData, request);
		model.executeRequest();
		Response response = model.getResponse();
		
		model.close();
		return response;
	}
	
	
	
	@POST
	@Path(SELECT_STORE_NEARBY)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectStoreNearby(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new StorbyModelSelect(incomingData, request);
		model.executeRequest();
		Response response = model.getResponse();
		
		model.close();
		return response;
	}
	
	
	
	@GET
	@Path(SELECT_STORE_WTIME)
	@Produces(MediaType.APPLICATION_JSON)
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
		Response response = model.getResponse();
		
		model.close();
		return response;
	}
	
	
	
	@POST
	@Path(SEARCH_STORE_WTIME)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchStoreWTime(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new StowotmModelSearch(incomingData, request);
		model.executeRequest();
		Response response = model.getResponse();
		
		model.close();
		return response;
	}
	
	
	
	@POST
	@Path(INSERT_STORE_WTIME)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertStoreWTime(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new StowotmModelInsert(incomingData, request);
		model.executeRequest();
		Response response = model.getResponse();
		
		model.close();
		return response;
	}
	
	
	
	@DELETE
	@Path(DELETE_STORE_WTIME)
	@Produces(MediaType.APPLICATION_JSON)
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
		Response response = model.getResponse();
		
		model.close();
		return response;
	}
	
	
	
	@POST
	@Path(UPDATE_STORE_WTIME)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateStoreWTime(@Context HttpServletRequest request, String incomingData) {

		Model model = new StowotmModelUpdate(incomingData, request);
		model.executeRequest();
		Response response = model.getResponse();
		
		model.close();
		return response;
	}
	
	
	
	@GET
	@Path(SELECT_STORE_LDATE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectStolate(@HeaderParam("TOKEN_OWNER")    @DefaultValue("-1") long codOwner, 
			                      @HeaderParam("codStore") 	     @DefaultValue("-1") int codStore,
			                      @HeaderParam("codLanguage")    @DefaultValue("EN") String codLanguage,
			                      @HeaderParam("dateValidFrom")	 @DefaultValue("1900-01-01") String dateValidFrom,
			                      @HeaderParam("timeValidFrom")  @DefaultValue("12:00") String timeValidFrom,
			                      @HeaderParam("TOKEN_USERNAME") String username) {

		StolateInfo recordInfo = new StolateInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		recordInfo.dateValidFrom = LocalDate.parse(dateValidFrom, DateTimeFormatter.ISO_LOCAL_DATE);	//TODO: criar/mover para uma classe
		recordInfo.timeValidFrom = LocalTime.parse(timeValidFrom, DateTimeFormatter.ISO_LOCAL_TIME);	//TODO: criar/mover para uma classe
		
		Model model = new StolateModelSelect(recordInfo);
		model.executeRequest();
		Response response = model.getResponse();
		
		model.close();
		return response;
	}
	
	
	
	@GET
	@Path(SEARCH_STORE_LDATE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchStolate(@HeaderParam("TOKEN_OWNER")    @DefaultValue("-1") long codOwner, 
			                      @HeaderParam("codStore") 	     @DefaultValue("-1") int codStore,
			                      @HeaderParam("yearValidFrom")  @DefaultValue("-1") int yearValidFrom,
			                      @HeaderParam("monthValidFrom") @DefaultValue("-1") int monthValidFrom,
			                      @HeaderParam("codLanguage")    @DefaultValue("EN") String codLanguage,
			                      @HeaderParam("TOKEN_USERNAME") String username) {

		StolateInfo recordInfo = new StolateInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.yearValidFrom = yearValidFrom;
		recordInfo.monthValidFrom = monthValidFrom;
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		
		Model model = new StolateModelSearch(recordInfo);
		model.executeRequest();
		Response response = model.getResponse();
		
		model.close();
		return response;
	}
	
	
	
	@POST
	@Path(INSERT_STORE_LDATE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertStolate(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new StolateModelInsert(incomingData, request);
		model.executeRequest();
		Response response = model.getResponse();
		
		model.close();
		return response;
	}
	
	
	
	@POST
	@Path(UPDATE_STORE_LDATE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateStolate(@Context HttpServletRequest request, String incomingData) {

		Model model = new StolateModelUpdate(incomingData, request);
		model.executeRequest();
		Response response = model.getResponse();
		
		model.close();
		return response;
	}
	
	
	
	@DELETE
	@Path(DELETE_STORE_LDATE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteStolate(@HeaderParam("TOKEN_OWNER")    @DefaultValue("-1") long codOwner, 
			                      @HeaderParam("codStore")       @DefaultValue("-1") int codStore,
			                      @HeaderParam("codLanguage")    @DefaultValue("EN") String codLanguage,
			                      @HeaderParam("dateValidFrom")  @DefaultValue("1900-01-01") String dateValidFrom,
			                      @HeaderParam("timeValidFrom")  @DefaultValue("12:00") String timeValidFrom,
			                      @HeaderParam("TOKEN_USERNAME") String username) {
		
		//TODO: adicionar filtros para dar um parse nas datas
		StolateInfo recordInfo = new StolateInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		recordInfo.dateValidFrom = LocalDate.parse(dateValidFrom, DateTimeFormatter.ISO_LOCAL_DATE);
		recordInfo.timeValidFrom = LocalTime.parse(timeValidFrom, DateTimeFormatter.ISO_LOCAL_TIME);
		
		Model model = new StolateModelDelete(recordInfo);
		model.executeRequest();
		Response response = model.getResponse();
		
		model.close();
		return response;
	}

	
	
	@GET
	@Path(SELECT_STORE_PAY_PARTNER_LIST)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectStoplis(@HeaderParam("TOKEN_OWNER")    @DefaultValue("-1") long codOwner, 
			                      @HeaderParam("codStore")       @DefaultValue("-1") int codStore,
			                      @HeaderParam("codLanguage")	 @DefaultValue("EN") String codLanguage,
			                      @HeaderParam("TOKEN_USERNAME") String username) {

		StoplisInfo recordInfo = new StoplisInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		
		Model model = new StoplisModelSearch(recordInfo);
		model.executeRequest();
		Response response = model.getResponse();
		
		model.close();
		return response;
	}
	
	
	
	@GET
	@Path(GRANT_MOIP)
	@Produces(MediaType.APPLICATION_JSON)
	public Response grantMoip(@HeaderParam("TOKEN_OWNER")    	@DefaultValue("-1") long codOwner, 
				              @HeaderParam("codStore")  		@DefaultValue("-1") long codStore,
				              @HeaderParam("TOKEN_USERNAME") 	String username,
				              @HeaderParam("codLanguage")    	@DefaultValue("EN") String codLanguage) {
		
		AccemoipInfo recordInfo = new AccemoipInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;
		
		Model model = new AccemoipModelUrl(recordInfo);
		model.executeRequest();
		Response response = model.getResponse();
		
		model.close();
		return response;
	}
	
	
	
	@POST
	@Path(INSERT_STORE_FAVORITE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertStorite(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new StoriteModelInsertAuth(incomingData, request);
		model.executeRequest();
		Response response = model.getResponse();
		
		model.close();
		return response;
	}
	
	
	
	@DELETE
	@Path(DELETE_STORE_FAVORITE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteStorite(@HeaderParam("TOKEN_OWNER")    	@DefaultValue("-1") long codOwner, 
			                      @HeaderParam("codStore")       	@DefaultValue("-1") long codStore,
			                      @HeaderParam("codLanguage")		@DefaultValue("EN") String codLanguage,
			                      @HeaderParam("TOKEN_USERNAME") String username) {
		
		StoriteInfo recordInfo = new StoriteInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		
		Model model = new StoriteModelDeleteAuth(recordInfo);
		model.executeRequest();
		Response response = model.getResponse();
		
		model.close();
		return response;
	}
	
	
	
	@POST
	@Path(SEARCH_STORE_FAVORITE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchStorite(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new StoriteModelSearchAuth(incomingData, request);
		model.executeRequest();
		Response response = model.getResponse();
		
		model.close();
		return response;
	}
}
