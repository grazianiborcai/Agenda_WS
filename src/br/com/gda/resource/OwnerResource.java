package br.com.gda.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.model.OwnerModelInsert;
import br.com.gda.business.owner.model.OwnerModelSelect;
import br.com.gda.legacy.model.OwnerModel;
import br.com.gda.model.Model;

@Path("/Owner")
public class OwnerResource {

	private static final String INSERT_OWNER 	= "/insertOwner"	;
	private static final String UPDATE_OWNER 	= "/updateOwner"	;
	private static final String DELETE_OWNER 	= "/deleteOwner"	;
	private static final String SELECT_OWNER 	= "/selectOwner"	;
	private static final String LOGIN_OWNER  	= "/loginOwner" 	;
	private static final String CHANGE_PASSWORD = "/changePassword"	;
	
	
	
	@GET
	@Path(SELECT_OWNER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectOwner(@HeaderParam("codOwner") @DefaultValue("-1") long codOwner, 
			                    @HeaderParam("codLanguage") String codLanguage) {
		
		OwnerInfo recordInfo = new OwnerInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codLanguage = codLanguage;
		
		
		Model modelSelect = new OwnerModelSelect(recordInfo);
		modelSelect.executeRequest();
		return modelSelect.getResponse();	
	}
	

	
	@POST
	@Path(INSERT_OWNER)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertOwner(String incomingData) {		
		
		Model model = new OwnerModelInsert(incomingData);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	@GET																										
	@Path(LOGIN_OWNER)																							
	@Produces(MediaType.APPLICATION_JSON)																		
	public Response loginOwner(@HeaderParam("email") String email, @HeaderParam("password") String password) {
		return new OwnerModel().loginOwner(email, password);											
	}		
	

	@POST
	@Path(UPDATE_OWNER)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateOwner(String incomingData) {
		//TODO: está alterando o password. Isso não pode acontecer.
		//TODO: se não for informado o código do owner, cria um registro novo. Isso não pode acontecer.
		return new OwnerModel().updateOwner(incomingData);
	}

	@DELETE
	@Path(DELETE_OWNER)
	public Response deleteOwner(@HeaderParam("codOwner") List<Long> codOwner,
			@QueryParam("password") List<String> password, @QueryParam("name") List<String> name,
			@QueryParam("cpf") List<String> cpf, @QueryParam("phone") List<String> phone,
			@QueryParam("email") List<String> email, @QueryParam("emailAux") List<String> emailAux,
			@QueryParam("codGender") List<Byte> codGender, @QueryParam("bornDate") List<String> bornDate,
			@QueryParam("postalcode") List<Integer> postalcode, @QueryParam("address1") List<String> address1,
			@QueryParam("address2") List<String> address2, @QueryParam("city") List<String> city,
			@QueryParam("country") List<String> country, @QueryParam("state") List<String> state,
			@QueryParam("codCurr") List<String> codCurr, @QueryParam("recordMode") List<String> recordMode) {

		return new OwnerModel().deleteOwner(codOwner, password, name, cpf, phone, email, emailAux, codGender, bornDate,
				postalcode, address1, address2, city, country, state, codCurr, recordMode);
	}
	
	
	@GET																										
	@Path(CHANGE_PASSWORD)																						
	@Produces(MediaType.APPLICATION_JSON)																		
	public Response changePassword(@HeaderParam("codOwner") Long codOwner,										
			@HeaderParam("newPassword") String newPassword) {													
																												
		return new OwnerModel().changePassword(codOwner, newPassword);											
	}
}
