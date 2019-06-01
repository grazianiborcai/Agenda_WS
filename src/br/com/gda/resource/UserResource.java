package br.com.gda.resource;

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

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.model.UserModelDelete;
import br.com.gda.business.user.model.UserModelInsert;
import br.com.gda.business.user.model.UserModelSelect;
import br.com.gda.business.user.model.UserModelUpdate;
import br.com.gda.model.Model;

@Path("/User")
public class UserResource {

	private static final String INSERT_USER = "/insertUser";
	private static final String UPDATE_USER = "/updateUser";
	private static final String DELETE_USER = "/deleteUser";
	private static final String SELECT_USER = "/selectUser";

	
	
	@POST
	@Path(INSERT_USER)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertUser(@Context HttpServletRequest request, String incomingData) {		
		
		Model model = new UserModelInsert(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}
	
	

	@POST
	@Path(UPDATE_USER)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUser(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new UserModelUpdate(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}

	
	
	@DELETE
	@Path(DELETE_USER)
	public Response deleteUser(@HeaderParam("codOwner")    @DefaultValue("-1") long codOwner,
							   @HeaderParam("codUser")     @DefaultValue("-1") long codUser,
							   @HeaderParam("codPerson")   @DefaultValue("-1") long codPerson,
							   @HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage) {

		UserInfo recordInfo = new UserInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codUser = codUser;
		recordInfo.codPerson = codPerson;
		recordInfo.codLanguage = codLanguage;
		
		Model model = new UserModelDelete(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}

	
	
	@GET
	@Path(SELECT_USER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectUser(@HeaderParam("TOKEN_OWNER") 		@DefaultValue("-1") long codOwner,
							   @HeaderParam("codLanguage")		@DefaultValue("EN") String codLanguage,
				               @HeaderParam("TOKEN_USERNAME") 	String username) {

		UserInfo recordInfo = new UserInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;
		
		Model model = new UserModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
}
