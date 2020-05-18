package br.com.mind5.servlet.resource;

import javax.servlet.http.HttpServletRequest;
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
import br.com.mind5.model.Model;

@Path("/RefundPolicy")
public final class RefundPolicyResource {
	private static final String DELETE_REFUPOL_OWNER = "/deleteRefundPolicyOwner";
	private static final String SELECT_REFUPOL_OWNER = "/selectRefundPolicyOwner";	
	private static final String UPSERT_REFUPOL_OWNER = "/upsertRefundPolicyOwner";	
	
	
	
	@DELETE
	@Path(DELETE_REFUPOL_OWNER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteRefupown(@HeaderParam("TOKEN_OWNER")    		@DefaultValue("-1") long codOwner, 
				                   @HeaderParam("TOKEN_USERNAME") 		String username,
				                   @HeaderParam("codRefundPolicyGroup") @DefaultValue("-1") int codRefundPolicyGroup,
							       @HeaderParam("codLanguage")      	@DefaultValue("EN") String codLanguage) {
		
		RefupownInfo recordInfo = new RefupownInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codRefundPolicyGroup = codRefundPolicyGroup;
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
	public Response selectRefupown(@HeaderParam("TOKEN_OWNER") 			@DefaultValue("-1") long codOwner, 
								   @HeaderParam("TOKEN_USERNAME")  		String username,
							       @HeaderParam("codRefundPolicyGroup") @DefaultValue("-1") int codRefundPolicyGroup,
							       @HeaderParam("codLanguage") 			@DefaultValue("EN") String codLanguage) {
		
		RefupownInfo recordInfo = new RefupownInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.username = username;
		recordInfo.codRefundPolicyGroup = codRefundPolicyGroup;
		recordInfo.codLanguage = codLanguage;		
		
		Model model = new RefupownModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@POST
	@Path(UPSERT_REFUPOL_OWNER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response upsertRefupown(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new RefupownModelUpsert(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	} 
}
