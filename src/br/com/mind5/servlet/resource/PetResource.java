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

import br.com.mind5.business.materialList.model.MatlisModelSearchAuth;
import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.pet.model.PetModelDelete;
import br.com.mind5.business.pet.model.PetModelInsert;
import br.com.mind5.business.pet.model.PetModelSelect;
import br.com.mind5.business.pet.model.PetModelUpdate;
import br.com.mind5.model.Model;

@Path("/Pet")
public class PetResource {
	private static final String INSERT_PET = "/insertPet";
	private static final String UPDATE_PET = "/updatePet";
	private static final String DELETE_PET = "/deletePet";
	private static final String SELECT_PET = "/selectPet";	
	private static final String SEARCH_PET = "/searchPet";

	
	@POST
	@Path(INSERT_PET)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertPet(@Context HttpServletRequest request, String incomingData) {	
		
		Model model = new PetModelInsert(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
	
	
	
	@POST
	@Path(UPDATE_PET)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePet(@Context HttpServletRequest request, String incomingData) {

		Model model = new PetModelUpdate(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
	
	
	
	@DELETE
	@Path(DELETE_PET)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletePet(@HeaderParam("TOKEN_OWNER")    @DefaultValue("-1") long codOwner, 
			                  @HeaderParam("codPet")    	 @DefaultValue("-1") long codPet,
			                  @HeaderParam("TOKEN_USERNAME") String username,
			                  @HeaderParam("codLanguage")    @DefaultValue("EN") String codLanguage) {
		
		PetInfo recordInfo = new PetInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codPet = codPet;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;
		
		
		Model model = new PetModelDelete(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_PET)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectPet(@HeaderParam("TOKEN_OWNER") 	 @DefaultValue("-1") long codOwner,
							  @HeaderParam("codPet") 		 @DefaultValue("-1") long codPet, 
							  @HeaderParam("TOKEN_USERNAME") String username,
							  @HeaderParam("codLanguage") 	 @DefaultValue("EN") String codLanguage) {


		PetInfo recordInfo = new PetInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codPet = codPet;
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		
		
		Model model = new PetModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
	
	
	
	@POST
	@Path(SEARCH_PET)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response searchPetlis(@Context HttpServletRequest request, String incomingData) {	
		
		Model model = new MatlisModelSearchAuth(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
}
