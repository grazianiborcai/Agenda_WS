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

import br.com.mind5.model.Model;
import br.com.mind5.security.otpUserPassword.model.OtperasModelInsert;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.UserModelDeleteAuth;
import br.com.mind5.security.user.model.UserModelInsert;
import br.com.mind5.security.user.model.UserModelSelectAuth;
import br.com.mind5.security.user.model.UserModelUpdateAuth;
import br.com.mind5.security.userPassword.model.UpswdModelUpdateAuth;

@Path("/User")
public class UserResource {

	private static final String INSERT_OTP_USER_PASSWORD = "/insertOtpUserPassword";
	private static final String INSERT_USER = "/insertUser";
	private static final String UPDATE_USER = "/updateUser";
	private static final String DELETE_USER = "/deleteUser";
	private static final String SELECT_USER = "/selectUser";
	private static final String UPDATE_USER_PASSWORD = "/updateUserPassword";

	
	
	@POST
	@Path(INSERT_OTP_USER_PASSWORD)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertOtperas(@Context HttpServletRequest request, String incomingData) {		
		
		Model model = new OtperasModelInsert(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@POST
	@Path(INSERT_USER)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertUser(@Context HttpServletRequest request, String incomingData) {		
		
		Model model = new UserModelInsert(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	

	@POST
	@Path(UPDATE_USER)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUser(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new UserModelUpdateAuth(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}

	
	
	@DELETE
	@Path(DELETE_USER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUser(@HeaderParam("TOKEN_OWNER") @DefaultValue("-1") long codOwner,
							   @HeaderParam("TOKEN_USERNAME") String username,
							   @HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage) {

		UserInfo recordInfo = new UserInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;
		
		Model model = new UserModelDeleteAuth(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
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
		
		Model model = new UserModelSelectAuth(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@POST
	@Path(UPDATE_USER_PASSWORD)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUpswd(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new UpswdModelUpdateAuth(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
}
