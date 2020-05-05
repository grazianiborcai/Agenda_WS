package br.com.mind5.servlet.resource;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.SchedineModelCancel;
import br.com.mind5.business.scheduleLine.model.SchedineModelInsert;
import br.com.mind5.business.scheduleLine.model.SchedineModelMove;
import br.com.mind5.business.scheduleLine.model.SchedineModelSelect;
import br.com.mind5.business.scheduleLine.model.SchedineModelUpdate;
import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.business.scheduleMonth.model.SchedmonModelSelect;
import br.com.mind5.business.scheduleRange.info.SchedageInfo;
import br.com.mind5.business.scheduleRange.model.SchedageModelSelect;
import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.business.scheduleWeek.model.SchedeekModelSelect;
import br.com.mind5.business.scheduleYear.info.SchedyearInfo;
import br.com.mind5.business.scheduleYear.model.SchedyearModelSelect;
import br.com.mind5.model.Model;

@Path("/Schedule")
public final class ScheduleResource {
	private static final String INSERT_SCHEDULE_LINE = "/insertScheduleLine";
	private static final String UPDATE_SCHEDULE_LINE = "/updateScheduleLine";
	private static final String MOVE_SCHEDULE_LINE = "/moveScheduleLine";
	private static final String SELECT_SCHEDULE_LINE = "/selectScheduleLine";
	private static final String CANCEL_SCHEDULE_LINE = "/cancelScheduleLine";
	private static final String SELECT_SCHEDULE_YEAR = "/selectScheduleYear";
	private static final String SELECT_SCHEDULE_MONTH = "/selectScheduleMonth";
	private static final String SELECT_SCHEDULE_WEEK = "/selectScheduleWeek";
	private static final String SELECT_SCHEDULE_RANGE = "/selectScheduleRange";
	
	
	@POST
	@Path(INSERT_SCHEDULE_LINE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertSchedine(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new SchedineModelInsert(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
	
	
	
	@POST
	@Path(UPDATE_SCHEDULE_LINE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateSchedine(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new SchedineModelUpdate(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
	
	
	
	@POST
	@Path(MOVE_SCHEDULE_LINE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response moveSchedine(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new SchedineModelMove(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
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
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}	
	
	
	
	@GET
	@Path(CANCEL_SCHEDULE_LINE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cancelSchedine(@HeaderParam("TOKEN_OWNER")    	@DefaultValue("-1") long codOwner, 
			                       @HeaderParam("codSchedule")    	@DefaultValue("-1") long codSchedule,
								   @HeaderParam("TOKEN_USERNAME") 	String username,
								   @HeaderParam("codLanguage")      @DefaultValue("EN") String codLanguage) {
		
		SchedineInfo recordInfo = new SchedineInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codSchedule = codSchedule;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;		
		
		Model model = new SchedineModelCancel(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}	
	
	
	
	@GET
	@Path(SELECT_SCHEDULE_YEAR)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectSchedyear(@HeaderParam("TOKEN_OWNER")    	@DefaultValue("-1") long codOwner, 
			                        @HeaderParam("codStore")    	@DefaultValue("-1") long codStore,
			                        @HeaderParam("year")    		@DefaultValue("-1") int year,
								    @HeaderParam("TOKEN_USERNAME") 	String username,
								    @HeaderParam("codLanguage")     @DefaultValue("EN") String codLanguage) {
		
		SchedyearInfo recordInfo = new SchedyearInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.year = year;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;		
		
		Model model = new SchedyearModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}	
	
	
	
	@GET
	@Path(SELECT_SCHEDULE_MONTH)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectSchedMonth(@HeaderParam("TOKEN_OWNER")    @DefaultValue("-1") long codOwner, 
			                         @HeaderParam("codStore")    	@DefaultValue("-1") long codStore,
			                         @HeaderParam("codEmployee")   	@DefaultValue("-1") long codEmployee,
			                         @HeaderParam("codMaterial")   	@DefaultValue("-1") long codMat,
			                         @HeaderParam("year")    		@DefaultValue("-1") int year,
			                         @HeaderParam("month")    		@DefaultValue("-1") int month,
								     @HeaderParam("TOKEN_USERNAME") String username,
								     @HeaderParam("codLanguage")    @DefaultValue("EN") String codLanguage) {
		
		SchedmonInfo recordInfo = new SchedmonInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codEmployee = codEmployee;
		recordInfo.codMat = codMat;
		recordInfo.codStore = codStore;
		recordInfo.year = year;
		recordInfo.month = month;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;		
		
		Model model = new SchedmonModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}	
	
	
	
	@GET
	@Path(SELECT_SCHEDULE_WEEK)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectSchedWeek(@HeaderParam("TOKEN_OWNER")    @DefaultValue("-1") long codOwner, 
			                        @HeaderParam("codStore")    	@DefaultValue("-1") long codStore,
			                        @HeaderParam("codEmployee")   	@DefaultValue("-1") long codEmployee,
			                        @HeaderParam("codCustomer")   	@DefaultValue("-1") long codCustomer,
			                        @HeaderParam("codMaterial")   	@DefaultValue("-1") long codMat,
			                        @HeaderParam("year")    		@DefaultValue("-1") int year,
			                        @HeaderParam("month")    		@DefaultValue("-1") int month,
			                        @HeaderParam("weekMonth")    	@DefaultValue("-1") int weekMonth,
								    @HeaderParam("TOKEN_USERNAME") String username,
								    @HeaderParam("codLanguage")    @DefaultValue("EN") String codLanguage) {
		
		SchedeekInfo recordInfo = new SchedeekInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codEmployee = codEmployee;
		recordInfo.codCustomer = codCustomer;
		recordInfo.codMat = codMat;
		recordInfo.codStore = codStore;
		recordInfo.year = year;
		recordInfo.month = month;
		recordInfo.weekMonth = weekMonth;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;		
		
		Model model = new SchedeekModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}		
	
	
	
	@GET
	@Path(SELECT_SCHEDULE_RANGE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectSchedRange(@HeaderParam("TOKEN_OWNER")    @DefaultValue("-1") long codOwner, 
			                         @HeaderParam("codStore")    	@DefaultValue("-1") long codStore,
				                     @HeaderParam("dateValidFrom")	@DefaultValue("1900-01-01") String dateValidFrom,
				                     @HeaderParam("timeValidFrom")	@DefaultValue("12:00") String timeValidFrom,
				                     @HeaderParam("dateValidTo")	@DefaultValue("1900-01-01") String dateValidTo,
				                     @HeaderParam("timeValidTo")    @DefaultValue("12:00") String timeValidTo,
								     @HeaderParam("TOKEN_USERNAME") String username,
								     @HeaderParam("codLanguage")    @DefaultValue("EN") String codLanguage) {
		
		SchedageInfo recordInfo = new SchedageInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.dateValidFrom = LocalDate.parse(dateValidFrom, DateTimeFormatter.ISO_LOCAL_DATE);	//TODO: criar/mover para uma classe
		recordInfo.dateValidTo = LocalDate.parse(dateValidTo, DateTimeFormatter.ISO_LOCAL_DATE);		//TODO: criar/mover para uma classe
		recordInfo.timeValidFrom = LocalTime.parse(timeValidFrom, DateTimeFormatter.ISO_LOCAL_TIME);	//TODO: criar/mover para uma classe
		recordInfo.timeValidTo = LocalTime.parse(timeValidTo, DateTimeFormatter.ISO_LOCAL_TIME);		//TODO: criar/mover para uma classe
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;		
		
		Model model = new SchedageModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}	
}
