package br.com.gda.resource;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.gda.business.masterData.info.PositionInfo;
import br.com.gda.business.masterData.model.PositionModelSelect;
import br.com.gda.model.Model;


@Path("/MasterData")
public final class MasterDataResource {
	private static final String SELECT_POSTION = "/selectPosition";
	
	
	@GET
	@Path(SELECT_POSTION)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectPosition(@HeaderParam("codLanguage") String codLanguage, 
			                       @HeaderParam("codPosition") @DefaultValue("-1") long codPosition) {
		
		PositionInfo recordInfo = new PositionInfo();
		recordInfo.codLanguage = codLanguage;
		recordInfo.codPosition = codPosition;
		
		Model positionSelect = new PositionModelSelect(recordInfo);
		positionSelect.executeRequest();
		return positionSelect.getResponse();
	}
}
