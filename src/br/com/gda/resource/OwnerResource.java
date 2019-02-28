package br.com.gda.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.model.OwnerModelDelete;
import br.com.gda.business.owner.model.OwnerModelSelect;
import br.com.gda.business.owner.model.OwnerModelUpdate;
import br.com.gda.model.Model;

@Path("/Owner")
@Produces(MediaType.APPLICATION_JSON)
public class OwnerResource {
	private static final String SELECT_OWNER = "/selectOwner";
	private static final String DELETE_OWNER = "/deleteOwner";
	private static final String UPDATE_OWNER = "/updateOwner";
	
	
	
	@GET
	@Path(SELECT_OWNER)	
	public Response selectOwner(@HeaderParam("TOKEN_OWNER") @DefaultValue("-1") long codOwner, 
			                    @HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage) {
		
		OwnerInfo recordInfo = new OwnerInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codLanguage = codLanguage;
		
		
		Model model = new OwnerModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();	
	}
		


	@DELETE
	@Path(DELETE_OWNER)
	public Response deleteOwner(@HeaderParam("codOwner")    @DefaultValue("-1") long codOwner,
			                    @HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage) {

		OwnerInfo recordInfo = new OwnerInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codLanguage = codLanguage;
		
		
		Model model = new OwnerModelDelete(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(UPDATE_OWNER)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateOwner(String incomingData) {
		
		Model model = new OwnerModelUpdate(incomingData);
		model.executeRequest();
		return model.getResponse();
	}
}
