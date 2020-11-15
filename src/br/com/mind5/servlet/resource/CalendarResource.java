package br.com.mind5.servlet.resource;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.mind5.business.calendarCatalogue.model.CalgueModelSelect;
import br.com.mind5.model.Model;

@Path("/Calendar")
public final class CalendarResource {
	private static final String SELECT_CALENDAR_CATALOGUE = "/selectCalendarCatalogue";
	
	
	@POST
	@Path(SELECT_CALENDAR_CATALOGUE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectCalgue(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new CalgueModelSelect(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
}
