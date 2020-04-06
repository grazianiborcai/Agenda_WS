package br.com.mind5.servlet.resource;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.mind5.business.planningTime.model.PlanimeModelSelect;
import br.com.mind5.model.Model;

@Path("/PlanningTime")
public final class PlanningTimeResource {
	private static final String SELECT_PLAN_TIME = "/selectPlanningTime";
	
	
	@POST
	@Path(SELECT_PLAN_TIME)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectPlanime(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new PlanimeModelSelect(incomingData, request);
		model.executeRequest();
		Response response = model.getResponse();
		
		model.close();
		return response;
	}
}
