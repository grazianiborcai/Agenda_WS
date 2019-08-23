package br.com.gda.servlet.resource;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.business.scheduleLine.model.SchedineModelInsert;
import br.com.gda.business.scheduleLine.model.SchedineModelMove;
import br.com.gda.business.scheduleLine.model.SchedineModelSelect;
import br.com.gda.business.scheduleLine.model.SchedineModelUpdate;
import br.com.gda.model.Model;

@Path("/Schedule")
public final class ScheduleResource {
	private static final String INSERT_SCHEDULE_LINE = "/insertScheduleLine";
	private static final String UPDATE_SCHEDULE_LINE = "/updateScheduleLine";
	private static final String MOVE_SCHEDULE_LINE = "/moveScheduleLine";
	private static final String SELECT_SCHEDULE_LINE = "/selectScheduleLine";
	
	@POST
	@Path(INSERT_SCHEDULE_LINE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertSchedine(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new SchedineModelInsert(incomingData, request);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	
	@POST
	@Path(UPDATE_SCHEDULE_LINE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateSchedine(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new SchedineModelUpdate(incomingData, request);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	
	@POST
	@Path(MOVE_SCHEDULE_LINE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response moveSchedine(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new SchedineModelMove(incomingData, request);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	
	@GET
	@Path(SELECT_SCHEDULE_LINE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectSchedine(@HeaderParam("TOKEN_OWNER")    	@DefaultValue("-1") long codOwner, 
			                       @HeaderParam("codSchedule")    	@DefaultValue("-1") long codSchedule,
								   @HeaderParam("TOKEN_USERNAME") 	String username,
								   @HeaderParam("codLanguage")      @DefaultValue("EN") String codLanguage) {
		
		SchedineInfo recordInfo = new SchedineInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codSchedule = codSchedule;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;		
		
		Model model = new SchedineModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();	
	}	
}
