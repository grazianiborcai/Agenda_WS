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

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.OwnerModelDelete;
import br.com.mind5.business.owner.model.OwnerModelSelect;
import br.com.mind5.business.owner.model.OwnerModelUpdate;
import br.com.mind5.business.ownerSearch.info.OwnarchInfo;
import br.com.mind5.business.ownerSearch.model.OwnarchModelSelect;
import br.com.mind5.model.Model;

@Path("/Owner")
@Produces(MediaType.APPLICATION_JSON)
public class OwnerResource {
	private static final String LIST_OWNER = "/listOwner";
	private static final String SELECT_OWNER = "/selectOwner";
	private static final String DELETE_OWNER = "/deleteOwner";
	private static final String UPDATE_OWNER = "/updateOwner";
	
	
	
	@GET
	@Path(LIST_OWNER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response listOwner(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage) {
		
		OwnarchInfo recordInfo = new OwnarchInfo();
		recordInfo.codLanguage = codLanguage;
		
		Model model = new OwnarchModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_OWNER)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectOwner(@HeaderParam("TOKEN_OWNER") 	@DefaultValue("-1") long codOwner, 
							    @HeaderParam("TOKEN_USERNAME")                  	String username,
			                    @HeaderParam("codLanguage") 	@DefaultValue("EN") String codLanguage) {
		
		OwnerInfo recordInfo = new OwnerInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.username = username;		
		recordInfo.codLanguage = codLanguage;	
		
		Model model = new OwnerModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
		


	@DELETE
	@Path(DELETE_OWNER)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteOwner(@HeaderParam("TOKEN_OWNER")    @DefaultValue("-1") long   codOwner,
								@HeaderParam("TOKEN_USERNAME")                     String username,
			                    @HeaderParam("codLanguage")    @DefaultValue("EN") String codLanguage) {

		OwnerInfo recordInfo = new OwnerInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codLanguage = codLanguage;		
		recordInfo.username = username;	
		
		Model model = new OwnerModelDelete(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@POST
	@Path(UPDATE_OWNER)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateOwner(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new OwnerModelUpdate(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
}
