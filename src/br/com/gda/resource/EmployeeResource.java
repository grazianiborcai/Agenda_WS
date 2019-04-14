package br.com.gda.resource;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.model.EmpModelDelete;
import br.com.gda.business.employee.model.EmpModelInsert;
import br.com.gda.business.employee.model.EmpModelSelect;
import br.com.gda.business.employee.model.EmpModelUpdate;
import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.business.employeeLeaveDate.model.EmplevateModelDelete;
import br.com.gda.business.employeeLeaveDate.model.EmplevateModelInsert;
import br.com.gda.business.employeeLeaveDate.model.EmplevateModelSelect;
import br.com.gda.business.employeeLeaveDate.model.EmplevateModelUpdate;
import br.com.gda.business.employeeMaterial.info.EmpmatInfo;
import br.com.gda.business.employeeMaterial.model.EmpmatModelDelete;
import br.com.gda.business.employeeMaterial.model.EmpmatModelInsert;
import br.com.gda.business.employeeMaterial.model.EmpmatModelSelect;
import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.business.employeePosition.model.EmposModelDelete;
import br.com.gda.business.employeePosition.model.EmposModelInsert;
import br.com.gda.business.employeePosition.model.EmposModelSelect;
import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.business.employeeWorkTime.model.EmpwotmModelDelete;
import br.com.gda.business.employeeWorkTime.model.EmpwotmModelInsert;
import br.com.gda.business.employeeWorkTime.model.EmpwotmModelSelect;
import br.com.gda.business.employeeWorkTime.model.EmpwotmModelUpdate;
import br.com.gda.business.employeeWorkTimeConflict.info.EmpCoInfo;
import br.com.gda.business.employeeWorkTimeConflict.model.EmpCoModelSelect;
import br.com.gda.model.Model;

@Path("/Employee")
public class EmployeeResource {
	private static final String INSERT_EMP = "/insertEmployee";
	private static final String UPDATE_EMP = "/updateEmployee";
	private static final String DELETE_EMP = "/deleteEmployee";
	private static final String SELECT_EMP = "/selectEmployee";
	private static final String INSERT_WORK_TIME = "/insertWorkTime";
	private static final String UPDATE_WORK_TIME = "/updateWorkTime";
	private static final String SELECT_WORK_TIME = "/selectWorkTime";
	private static final String DELETE_WORK_TIME = "/deleteWorkTime";	
	private static final String SELECT_WT_CONFLICT = "/selectWorkTimeConflict";
	private static final String INSERT_LEAVE_DATE = "/insertLeaveDate";
	private static final String UPDATE_LEAVE_DATE = "/updateLeaveDate";
	private static final String SELECT_LEAVE_DATE = "/selectLeaveDate";
	private static final String DELETE_LEAVE_DATE = "/deleteLeaveDate";
	private static final String SELECT_EMP_POSITION = "/selectPosition";
	private static final String INSERT_EMP_POSITION = "/insertPosition";
	private static final String DELETE_EMP_POSITION = "/deletePosition";
	private static final String SELECT_EMP_MATERIAL = "/selectMaterial";
	private static final String INSERT_EMP_MATERIAL = "/insertMaterial";
	private static final String DELETE_EMP_MATERIAL = "/deleteMaterial";
	
	
	
	@GET
	@Path(SELECT_WORK_TIME)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response selectWorkTime(@HeaderParam("TOKEN_OWNER")    	@DefaultValue("-1") long codOwner,
								   @HeaderParam("codStore")    		@DefaultValue("-1") long codStore,
								   @HeaderParam("codEmployee") 		@DefaultValue("-1") int codEmployee,
								   @HeaderParam("TOKEN_USERNAME") 	String username,
								   @HeaderParam("codLanguage")    	@DefaultValue("EN") String codLanguage) {
		
		EmpwotmInfo recordInfo = new EmpwotmInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codEmployee = codEmployee;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;
		
		Model model = new EmpwotmModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_WORK_TIME)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertWorkTime(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new EmpwotmModelInsert(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(UPDATE_WORK_TIME)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateWorkTime(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new EmpwotmModelUpdate(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@DELETE
	@Path(DELETE_WORK_TIME)
	@Consumes(MediaType.APPLICATION_JSON)	
	public Response deleteWorkTime(@HeaderParam("TOKEN_OWNER") 		@DefaultValue("-1") long codOwner,
								   @HeaderParam("codStore")    		@DefaultValue("-1") long codStore,
								   @HeaderParam("codEmployee") 		@DefaultValue("-1") int codEmployee,
								   @HeaderParam("codWeekday")  		@DefaultValue("-1") int codWeekday,
								   @HeaderParam("TOKEN_USERNAME") 	String username,
								   @HeaderParam("codLanguage")    	@DefaultValue("EN") String codLanguage) {
		
		EmpwotmInfo recordInfo = new EmpwotmInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codEmployee = codEmployee;
		recordInfo.codWeekday = codWeekday;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;
		
		Model model = new EmpwotmModelDelete(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_WT_CONFLICT)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response selectWTConflict(@HeaderParam("codOwner")    @DefaultValue("-1") long codOwner,
								     @HeaderParam("codStore")    @DefaultValue("-1") long codStore,
								     @HeaderParam("codEmployee") @DefaultValue("-1") int codEmployee,
								     @HeaderParam("codWeekday")  @DefaultValue("-1") int codWeekday,
								     @HeaderParam("beginTime")   @DefaultValue("12:00") String beginTime,
	                                 @HeaderParam("endTime")     @DefaultValue("12:00") String endTime) {
		
		EmpCoInfo recordInfo = new EmpCoInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codEmployee = codEmployee;
		recordInfo.codWeekday = codWeekday;
		recordInfo.beginTime = LocalTime.parse(beginTime, DateTimeFormatter.ISO_LOCAL_TIME);
		recordInfo.endTime = LocalTime.parse(endTime, DateTimeFormatter.ISO_LOCAL_TIME);
		
		Model model = new EmpCoModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_LEAVE_DATE)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response selectLeaveDate(@HeaderParam("TOKEN_OWNER") @DefaultValue("-1") long codOwner,
								    @HeaderParam("codStore")    @DefaultValue("-1") long codStore,
								    @HeaderParam("codEmployee") @DefaultValue("-1") int codEmployee,
								    @HeaderParam("codLanguage")	@DefaultValue("EN") String codLanguage,				                    
								    @HeaderParam("date")	    @DefaultValue("1900-01-01") String date,
								    @HeaderParam("TOKEN_USERNAME") String username) {
		
		EmplevateInfo recordInfo = new EmplevateInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codEmployee = codEmployee;
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		
		if (date.equals("1900-01-01") == false) {
			recordInfo.dateValidFrom = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
			recordInfo.dateValidTo = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
		}
		
		Model model = new EmplevateModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_LEAVE_DATE)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertLeaveDate(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new EmplevateModelInsert(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(UPDATE_LEAVE_DATE)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateLeaveDate(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new EmplevateModelUpdate(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@DELETE
	@Path(DELETE_LEAVE_DATE)
	@Consumes(MediaType.APPLICATION_JSON)	
	public Response deleteLeaveDate(@HeaderParam("TOKEN_OWNER")   @DefaultValue("-1") long codOwner,
								    @HeaderParam("codStore")      @DefaultValue("-1") long codStore,
								    @HeaderParam("codEmployee")   @DefaultValue("-1") int codEmployee,
								    @HeaderParam("dateValidFrom") @DefaultValue("1900-01-01") String dateValidFrom,
			                        @HeaderParam("timeValidFrom") @DefaultValue("12:00") String timeValidFrom,
			                        @HeaderParam("codLanguage")	  @DefaultValue("EN") String codLanguage,
				                    @HeaderParam("TOKEN_USERNAME") String username) {
		
		EmplevateInfo recordInfo = new EmplevateInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codEmployee = codEmployee;
		recordInfo.dateValidFrom = LocalDate.parse(dateValidFrom, DateTimeFormatter.ISO_LOCAL_DATE);
		recordInfo.timeValidFrom = LocalTime.parse(timeValidFrom, DateTimeFormatter.ISO_LOCAL_TIME);
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		
		Model model = new EmplevateModelDelete(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	

	@POST
	@Path(INSERT_EMP)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertEmployee(@Context HttpServletRequest request, String incomingData) {
		//TODO: horário do empregado. Se nulo, então pegar da Store	
		//TODO: position (ex: cabelereiro, manicuro) não deviria ficar na tab empregado, mas somente na store_emp. Assim um empregado pode ter mais de uma position na loja
		Model model = new EmpModelInsert(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}

	
	@POST
	@Path(UPDATE_EMP)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateEmployee(@Context HttpServletRequest request, String incomingData) {

		Model model = new EmpModelUpdate(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}

	
	
	@DELETE
	@Path(DELETE_EMP)
	public Response deleteEmployee(@HeaderParam("TOKEN_OWNER")    @DefaultValue("-1") long codOwner,
								   @HeaderParam("codEmployee") 	  @DefaultValue("-1") int codEmployee,
								   @HeaderParam("TOKEN_USERNAME") String username,
								   @HeaderParam("codLanguage")    @DefaultValue("EN") String codLanguage) {
		
		EmpInfo recordInfo = new EmpInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codEmployee = codEmployee;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;
		
		Model model = new EmpModelDelete(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}	

	
	
	@GET
	@Path(SELECT_EMP)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectEmployee(@HeaderParam("TOKEN_OWNER") 	@DefaultValue("-1") long codOwner,
								   @HeaderParam("codEmployee") 	@DefaultValue("-1") int codEmployee,
								   @HeaderParam("codLanguage")	@DefaultValue("EN") String codLanguage,
				                   @HeaderParam("TOKEN_USERNAME") String username) {
		
		EmpInfo recordInfo = new EmpInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codEmployee = codEmployee;
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		
		Model model = new EmpModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_EMP_POSITION)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectEmpos(@HeaderParam("TOKEN_OWNER") @DefaultValue("-1") long codOwner, 
			                    @HeaderParam("codStore") 	@DefaultValue("-1") int codStore,
			                    @HeaderParam("codEmployee") @DefaultValue("-1") int codEmployee,
			                    @HeaderParam("codLanguage")	@DefaultValue("EN") String codLanguage,
			                    @HeaderParam("TOKEN_USERNAME") String username) {
		
		EmposInfo recordInfo = new EmposInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codEmployee = codEmployee;
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		
		Model model = new EmposModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_EMP_POSITION)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertEmpos(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new EmposModelInsert(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@DELETE
	@Path(DELETE_EMP_POSITION)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteEmpos(@HeaderParam("TOKEN_OWNER")     @DefaultValue("-1") long codOwner, 
			                    @HeaderParam("codStore")    	@DefaultValue("-1") int codStore,
			                    @HeaderParam("codEmployee") 	@DefaultValue("-1") long codEmployee,
			                    @HeaderParam("codPosition") 	@DefaultValue("-1") int codPosition,
			                    @HeaderParam("codLanguage") 	@DefaultValue("EN") String codLanguage,
			                    @HeaderParam("TOKEN_USERNAME") String username) {
		
		EmposInfo recordInfo = new EmposInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codEmployee = codEmployee;
		recordInfo.codPosition = codPosition;
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		
		Model model = new EmposModelDelete(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_EMP_MATERIAL)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectEmpmat(@HeaderParam("TOKEN_OWNER") @DefaultValue("-1") long codOwner, 
			                     @HeaderParam("codMaterial") @DefaultValue("-1") int codMaterial,
			                     @HeaderParam("codEmployee") @DefaultValue("-1") int codEmployee,
			                     @HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                     @HeaderParam("TOKEN_USERNAME") String username) {
		
		EmpmatInfo recordInfo = new EmpmatInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codMat = codMaterial;
		recordInfo.codEmployee = codEmployee;
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		
		Model model = new EmpmatModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_EMP_MATERIAL)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertEmpmat(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new EmpmatModelInsert(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@DELETE
	@Path(DELETE_EMP_MATERIAL)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteEmpmat(@HeaderParam("TOKEN_OWNER")    @DefaultValue("-1") long codOwner, 
			                     @HeaderParam("codMaterial")   	@DefaultValue("-1") int codMaterial,
			                     @HeaderParam("codEmployee") 	@DefaultValue("-1") long codEmployee,
			                     @HeaderParam("codLanguage") 	@DefaultValue("EN") String codLanguage,
			                     @HeaderParam("TOKEN_USERNAME") String username) {
		
		EmpmatInfo recordInfo = new EmpmatInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codMat = codMaterial;
		recordInfo.codEmployee = codEmployee;
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		
		Model model = new EmpmatModelDelete(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
}
