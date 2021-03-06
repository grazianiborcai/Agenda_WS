package br.com.mind5.servlet.resource;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.mind5.model.Model;
import br.com.mind5.security.userAuthentication.info.UauthInfo;
import br.com.mind5.security.userAuthentication.model.UauthModelUpswd;

@Path("/Login")
public class LoginResource {
	private static final String AUTH_USER = "/authUser";

	
	
	@GET
	@Path(AUTH_USER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response authUser(@HeaderParam("codOwner")    @DefaultValue("-1") long codOwner,
			                 @HeaderParam("codUser")     @DefaultValue("-1") long codUser,
			                 @HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                 @HeaderParam("password") String password) {

		UauthInfo recordInfo = new UauthInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codUser = codUser;
		recordInfo.password = password;
		recordInfo.codLanguage = codLanguage;
		
		Model model = new UauthModelUpswd(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
}
