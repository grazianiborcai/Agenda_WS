package br.com.gda.resource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.gda.business.planningTime.info.PlanDataInfo;
import br.com.gda.business.planningTime.info.PlanInfo;
import br.com.gda.business.planningTime.model.PlanModelSelect;
import br.com.gda.model.Model;

@Path("/PlanningTime")
public final class PlanningTimeResource {
	private static final String SELECT_PLAN_TIME = "/selectPlanningTime";
	
	
	@GET
	@Path(SELECT_PLAN_TIME)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectPlanTime(@HeaderParam("codOwner")    @DefaultValue("-1") long codOwner, 
								   @HeaderParam("codStore")    @DefaultValue("-1") long codStore, 
								   @HeaderParam("codEmployee") @DefaultValue("-1") long codEmployee, 
								   @HeaderParam("date")        @DefaultValue("1900-01-01") String date,
			                       @HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage) {
		
		PlanDataInfo dataInfo = new PlanDataInfo();
		dataInfo.codOwner = codOwner;
		dataInfo.codStore = codStore;
		dataInfo.codEmployee = codEmployee;
		dataInfo.date = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
		dataInfo.codLanguage = codLanguage;
		
		List<PlanDataInfo> dataInfos = new ArrayList<>();
		dataInfos.add(dataInfo);
		
		PlanInfo recordInfo = new PlanInfo();		
		recordInfo.datas = dataInfos;		
		
		Model model = new PlanModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();	
	}
}
