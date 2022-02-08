package br.com.mind5.servlet.resource;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.mind5.model.Model;
import br.com.mind5.stats.statsOwnerDashboard.info.SowashInfo;
import br.com.mind5.stats.statsOwnerDashboard.model.SowashModelSelectLtm;

@Path("/Stats")
public class StatsResource {

	private static final String SELECT_OWNER_DASHBOARD = "/selectOwnerDashboard";

	
	
	@GET
	@Path(SELECT_OWNER_DASHBOARD)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectSowashLtm(@HeaderParam("TOKEN_OWNER")    @DefaultValue("-1") long codOwner,
									@HeaderParam("TOKEN_USERNAME") String username,
									@HeaderParam("codLanguage")    @DefaultValue("EN") String codLanguage) {

		SowashInfo recordInfo = new SowashInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;
		
		Model model = new SowashModelSelectLtm(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
}
