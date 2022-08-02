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

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.business.refundPolicyOwner.model.RefupownModelDelete;
import br.com.mind5.business.refundPolicyOwner.model.RefupownModelSelect;
import br.com.mind5.business.refundPolicyOwner.model.RefupownModelUpsert;
import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.refundPolicyStore.model.RefuporeModelDelete;
import br.com.mind5.business.refundPolicyStore.model.RefuporeModelSearch;
import br.com.mind5.business.refundPolicyStore.model.RefuporeModelSelect;
import br.com.mind5.business.refundPolicyStore.model.RefuporeModelUpsert;
import br.com.mind5.model.Model;

@Path("/RefundPolicy")
public final class RefundPolicyResource {
	private static final String DELETE_REFUPOL_OWNER = "/deleteRefundPolicyOwner";
	private static final String SELECT_REFUPOL_OWNER = "/selectRefundPolicyOwner";	
	private static final String UPSERT_REFUPOL_OWNER = "/upsertRefundPolicyOwner";		
	private static final String DELETE_REFUPOL_STORE = "/deleteRefundPolicyStore";
	private static final String SEARCH_REFUPOL_STORE = "/searchRefundPolicyStore";	
	private static final String SELECT_REFUPOL_STORE = "/selectRefundPolicyStore";
	private static final String UPSERT_REFUPOL_STORE = "/upsertRefundPolicyStore";	
	
	
	
	@DELETE
	@Path(DELETE_REFUPOL_OWNER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteRefupown(@HeaderParam("TOKEN_OWNER")    	@DefaultValue("-1") long codOwner, 
				                   @HeaderParam("TOKEN_USERNAME") 	String username,
							       @HeaderParam("codLanguage")      @DefaultValue("EN") String codLanguage) {
		
		RefupownInfo recordInfo = new RefupownInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;		
		
		Model model = new RefupownModelDelete(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_REFUPOL_OWNER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectRefupown(@HeaderParam("TOKEN_OWNER") 		@DefaultValue("-1") long codOwner, 
								   @HeaderParam("TOKEN_USERNAME")  	String username,
							       @HeaderParam("codLanguage") 		@DefaultValue("EN") String codLanguage) {
		
		RefupownInfo recordInfo = new RefupownInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;		
		
		Model model = new RefupownModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@POST
	@Path(UPSERT_REFUPOL_OWNER)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response upsertRefupown(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new RefupownModelUpsert(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	} 
	
	
	
	@DELETE
	@Path(DELETE_REFUPOL_STORE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteRefupore(@HeaderParam("TOKEN_OWNER")    	@DefaultValue("-1") long codOwner, 
				                   @HeaderParam("TOKEN_USERNAME") 	String username,
				                   @HeaderParam("codStore")    		@DefaultValue("-1") long codStore,
							       @HeaderParam("codLanguage")      @DefaultValue("EN") String codLanguage) {
		
		RefuporeInfo recordInfo = new RefuporeInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;		
		
		Model model = new RefuporeModelDelete(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
	
	
	
	@POST
	@Path(SEARCH_REFUPOL_STORE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchRefupore(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new RefuporeModelSearch(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	} 
	
	
	
	@GET
	@Path(SELECT_REFUPOL_STORE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectRefupore(@HeaderParam("TOKEN_OWNER") 		@DefaultValue("-1") long codOwner, 
								   @HeaderParam("TOKEN_USERNAME")  	String username,
				                   @HeaderParam("codStore")    		@DefaultValue("-1") long codStore,
							       @HeaderParam("codLanguage")      @DefaultValue("EN") String codLanguage) {
		
		RefuporeInfo recordInfo = new RefuporeInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;	
		
		Model model = new RefuporeModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@POST
	@Path(UPSERT_REFUPOL_STORE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response upsertRefupore(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new RefuporeModelUpsert(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	} 
}
