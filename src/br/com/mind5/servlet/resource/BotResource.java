package br.com.mind5.servlet.resource;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.mind5.bot.botStats.botStatsStore.info.BostodInfo;
import br.com.mind5.bot.botStats.botStatsStore.model.BostodModelUpsertL2m;
import br.com.mind5.model.Model;

@Path("/Bot")
public class BotResource {
	private static final String UPSERT_STATS_STORE_L2M = "/upsertStatsStoreL2m";

	
	
	@GET
	@Path(UPSERT_STATS_STORE_L2M)
	@Produces(MediaType.APPLICATION_JSON)
	public Response BostodUpsertL2m(@HeaderParam("codOwner")    @DefaultValue("-1") long codOwner,
							  	    @HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage) {

		BostodInfo recordInfo = new BostodInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codLanguage = codLanguage;
		
		Model model = new BostodModelUpsertL2m(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
}
