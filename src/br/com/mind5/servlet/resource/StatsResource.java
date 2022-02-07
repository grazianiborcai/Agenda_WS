package br.com.mind5.servlet.resource;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.mind5.model.Model;
import br.com.mind5.stats.statsOwnerStore.ownerStore.info.SowotInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStore.model.SowotModelSelectLtm;
import br.com.mind5.stats.statsUserAccount.userAccount.info.SuseracInfo;
import br.com.mind5.stats.statsUserAccount.userAccount.model.SuseracModelSelectLtm;

@Path("/Stats")
public class StatsResource {

	private static final String SELECT_STORE_ACCOUNT = "/selectStoreAccountLtm";
	private static final String SELECT_USER_ACCOUNT = "/selectUserAccountLtm";

	
	
	@GET
	@Path(SELECT_STORE_ACCOUNT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectStoreAccountLtm(@HeaderParam("TOKEN_OWNER") 	 @DefaultValue("-1") long codOwner,
									      @HeaderParam("TOKEN_USERNAME") String username,
									      @HeaderParam("codLanguage") 	 @DefaultValue("EN") String codLanguage) {

		SowotInfo recordInfo = new SowotInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;
		
		Model model = new SowotModelSelectLtm(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_USER_ACCOUNT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectUserAccountLtm(@HeaderParam("TOKEN_OWNER") 	@DefaultValue("-1") long codOwner,
									     @HeaderParam("TOKEN_USERNAME") String username,
									     @HeaderParam("codLanguage") 	@DefaultValue("EN") String codLanguage) {

		SuseracInfo recordInfo = new SuseracInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;
		
		Model model = new SuseracModelSelectLtm(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}	
}
