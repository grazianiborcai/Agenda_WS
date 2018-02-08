package br.com.gda.resource;

import java.time.LocalDateTime;
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

import br.com.gda.model.OwnerModel;
import br.com.gda.model.OwnerModel.SelectOwnerOption;

@Path("/Owner")
public class OwnerResource {

	private static final String INSERT_OWNER 	= "/insertOwner"	;
	private static final String UPDATE_OWNER 	= "/updateOwner"	;
	private static final String DELETE_OWNER 	= "/deleteOwner"	;
	private static final String SELECT_OWNER 	= "/selectOwner"	;
	private static final String LOGIN_OWNER  	= "/loginOwner" 	;
	private static final String CHANGE_PASSWORD = "/changePassword"	;
	private static final String INSERT_CUSTOMER = "/insertCustomer"	;

	@POST
	@Path(INSERT_OWNER)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertOwner(String incomingData) {		
		
		return new OwnerModel().insertOwner(incomingData);
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
	@Path(SELECT_OWNER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectOwner(@HeaderParam("ownerCode") String ownerCode, 
			@HeaderParam("language") String language,
			@DefaultValue("true") @HeaderParam("withHeader") Boolean withHeader,
			@DefaultValue("true") @HeaderParam("withDetailMat") Boolean withDetailMat,
			@DefaultValue("true") @HeaderParam("withMaterial") Boolean withMaterial,
			@DefaultValue("true") @HeaderParam("withMenu") Boolean withMenu,
			@DefaultValue("true") @HeaderParam("withStore") Boolean withStore,
			@DefaultValue("true") @HeaderParam("withEmployee") Boolean withEmployee,
			@DefaultValue("true") @HeaderParam("withStoreMenu") Boolean withStoreMenu,
			@DefaultValue("true") @HeaderParam("withStoreMaterial") Boolean withStoreMaterial,
			@DefaultValue("true") @HeaderParam("withStoreEmployee") Boolean withStoreEmployee,
			@DefaultValue("true") @HeaderParam("withStoreTables") Boolean withStoreTables,
			@DefaultValue("true") @HeaderParam("withStoreBill") Boolean withStoreBill) {
		
		OwnerModel.SelectOwnerOption option = new OwnerModel.SelectOwnerOption();
		option.isMenu      = withMenu     ;
		option.isStore     = withStore    ;
		option.isHeader	   = withHeader   ;
		option.isMaterial  = withMaterial ;
		option.isEmployee  = withEmployee ;
		option.isDetailMat = withDetailMat;
		option.language    = language     ;
		
		return new OwnerModel().selectOwner(ownerCode, option);
		
		/*Response r = new OwnerModel().selectOwnerResponse(email, cpf, password, language, withDetailMat, withMaterial,
				withMenu, withStore, withEmployee, withStoreMenu, withStoreMaterial, withStoreEmployee, withStoreTables,
				withStoreBill, zoneId);*/
	
		
	}
	
	
	@GET																										
	@Path(CHANGE_PASSWORD)																						
	@Produces(MediaType.APPLICATION_JSON)																		
	public Response changePassword(@HeaderParam("codOwner") Long codOwner,										
			@HeaderParam("newPassword") String newPassword) {													
																												
		return new OwnerModel().changePassword(codOwner, newPassword);											
	}																											
	
	
	
	@POST
	@Path(INSERT_CUSTOMER)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertCustomer(String incomingData) {

		return new OwnerModel().insertCustomer(incomingData);
	}
}
