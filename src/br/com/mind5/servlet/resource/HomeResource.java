package br.com.mind5.servlet.resource;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.mind5.business.home.info.HomeInfo;
import br.com.mind5.business.home.model.HomeModelSelect;
import br.com.mind5.model.Model;

@Path("/Home")
@Produces(MediaType.APPLICATION_JSON)
public class HomeResource {

	private static final String MAIN = "/main";	
	
	
	@GET
	@Path(MAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response main(@HeaderParam("codOwner") @DefaultValue("-1") long codOwner,
                         @HeaderParam("Username") String username,
                         @HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage) {		
		
		HomeInfo recordInfo = new HomeInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;
		
		
		Model model = new HomeModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
}
