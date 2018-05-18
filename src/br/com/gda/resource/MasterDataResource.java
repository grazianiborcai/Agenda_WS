package br.com.gda.resource;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.gda.business.masterData.info.MatUnitInfo;
import br.com.gda.business.masterData.info.EmpPositionInfo;
import br.com.gda.business.masterData.model.MatUnitModelSelect;
import br.com.gda.business.masterData.model.EmpPositionModelSelect;
import br.com.gda.model.Model;


@Path("/MasterData")
public final class MasterDataResource {
	private static final String SELECT_EMPLOYEE_POSTION = "/selectEmpPosition";
	private static final String SELECT_MATERIAL_UNIT = "/selectMatUnit";
	
	
	@GET
	@Path(SELECT_EMPLOYEE_POSTION)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectEmpPosition(@HeaderParam("codLanguage") String codLanguage, 
			                       @HeaderParam("codPosition") @DefaultValue("-1") long codPosition) {
		
		EmpPositionInfo recordInfo = new EmpPositionInfo();
		recordInfo.codLanguage = codLanguage;
		recordInfo.codPosition = codPosition;
		
		Model modelSelect = new EmpPositionModelSelect(recordInfo);
		modelSelect.executeRequest();
		return modelSelect.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_MATERIAL_UNIT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectMatUnit(@HeaderParam("codLanguage") String codLanguage, 
			                      @HeaderParam("codUnit") String codUnit) {
		
		MatUnitInfo recordInfo = new MatUnitInfo();
		recordInfo.codLanguage = codLanguage;
		recordInfo.codUnit = codUnit;
		
		Model modelSelect = new MatUnitModelSelect(recordInfo);
		modelSelect.executeRequest();
		return modelSelect.getResponse();
	}
}
