package br.com.mind5.servlet.resource;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.mind5.model.Model;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.UserModelInsertAnonymous;

@Path("/Test")
public final class TestResource {	
	private static final String INSERT_ANONYMOUS = "/insertAnonymous";
	
	@GET
	@Path(INSERT_ANONYMOUS)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertAnonymous(@HeaderParam("codOwner") 	@DefaultValue("-1") long codOwner,
			   						@HeaderParam("codLanguage")	@DefaultValue("EN") String codLanguage) {

		UserInfo recordInfo = new UserInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codLanguage = codLanguage;
		
		Model model = new UserModelInsertAnonymous(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
}
