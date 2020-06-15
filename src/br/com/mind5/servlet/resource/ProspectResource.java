package br.com.mind5.servlet.resource;

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

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.business.storeProspect.model.StoprosModelDelete;
import br.com.mind5.business.storeProspect.model.StoprosModelInsert;
import br.com.mind5.business.storeProspect.model.StoprosModelSearch;
import br.com.mind5.business.storeProspect.model.StoprosModelSelect;
import br.com.mind5.business.storeProspect.model.StoprosModelUpdate;
import br.com.mind5.model.Model;
import br.com.mind5.security.otpProspectStore.model.OtporeModelInsert;

@Path("/Prospect")
public class ProspectResource {
	private static final String INSERT_OTP_PROSPECT_STORE = "/insertOtpProspectStore";	
	private static final String INSERT_PROSPECT_STORE = "/insertProspectStore";
	private static final String UPDATE_PROSPECT_STORE = "/updateProspectStore";
	private static final String DELETE_PROSPECT_STORE = "/deleteProspectStore";
	private static final String SEARCH_PROSPECT_STORE = "/searchProspectStore";
	private static final String SELECT_PROSPECT_STORE = "/selectProspectStore";
	
	
	@POST
	@Path(INSERT_OTP_PROSPECT_STORE)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertOtpProspectStore(@Context HttpServletRequest request, String incomingData) {		
		
		Model model = new OtporeModelInsert(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_PROSPECT_STORE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertStopros(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new StoprosModelInsert(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}
	
	

	@POST
	@Path(UPDATE_PROSPECT_STORE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateStopros(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new StoprosModelUpdate(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}
	

	
	@DELETE
	@Path(DELETE_PROSPECT_STORE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response StoprosStore(@HeaderParam("TOKEN_OWNER")    	@DefaultValue("-1") long codOwner, 
								 @HeaderParam("codStoreProspect")  	@DefaultValue("-1") long codStoreProspect,
			                     @HeaderParam("codLanguage")		@DefaultValue("EN") String codLanguage,
			                     @HeaderParam("TOKEN_USERNAME") 	String username) {
		
		StoprosInfo recordInfo = new StoprosInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStoreProspect = codStoreProspect;
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		
		Model model = new StoprosModelDelete(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(SEARCH_PROSPECT_STORE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchStopros(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new StoprosModelSearch(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}

	
	
	@GET
	@Path(SELECT_PROSPECT_STORE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectStopros(@HeaderParam("TOKEN_OWNER")    	@DefaultValue("-1") long codOwner, 
			                      @HeaderParam("codStoreProspect")  @DefaultValue("-1") long codStoreProspect,
			                      @HeaderParam("codLanguage")	 	@DefaultValue("EN") String codLanguage,
			                      @HeaderParam("TOKEN_USERNAME") 	String username) {

		StoprosInfo recordInfo = new StoprosInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStoreProspect = codStoreProspect;
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		
		Model model = new StoprosModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
}
