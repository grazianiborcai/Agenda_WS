package br.com.gda.servlet.resource;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.gda.business.scheduleLine.model.SchedineModelInsert;
import br.com.gda.model.Model;

@Path("/Schedule")
public final class ScheduleResource {
	private static final String INSERT_SCHEDULE_LINE = "/insertScheduleLine";
	
	@POST
	@Path(INSERT_SCHEDULE_LINE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertSchedine(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new SchedineModelInsert(incomingData, request);
		model.executeRequest();
		return model.getResponse();	
	}

}
