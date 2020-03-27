package br.com.mind5.servlet.resource;

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

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.EmpModelDelete;
import br.com.mind5.business.employee.model.EmpModelInsert;
import br.com.mind5.business.employee.model.EmpModelSelect;
import br.com.mind5.business.employee.model.EmpModelUpdate;
import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.model.EmplateModelDelete;
import br.com.mind5.business.employeeLeaveDate.model.EmplateModelInsert;
import br.com.mind5.business.employeeLeaveDate.model.EmplateModelSearch;
import br.com.mind5.business.employeeLeaveDate.model.EmplateModelSelect;
import br.com.mind5.business.employeeLeaveDate.model.EmplateModelUpdate;
import br.com.mind5.business.employeeList.model.EmplisModelSearch;
import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.model.EmpmatModelDelete;
import br.com.mind5.business.employeeMaterial.model.EmpmatModelInsert;
import br.com.mind5.business.employeeMaterial.model.EmpmatModelSearch;
import br.com.mind5.business.employeeMaterial.model.EmpmatModelSelect;
import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.model.EmposModelDelete;
import br.com.mind5.business.employeePosition.model.EmposModelInsert;
import br.com.mind5.business.employeePosition.model.EmposModelSearch;
import br.com.mind5.business.employeePosition.model.EmposModelSelect;
import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.model.EmpwotmModelConflict;
import br.com.mind5.business.employeeWorkTime.model.EmpwotmModelDelete;
import br.com.mind5.business.employeeWorkTime.model.EmpwotmModelInsert;
import br.com.mind5.business.employeeWorkTime.model.EmpwotmModelInsertFromStore;
import br.com.mind5.business.employeeWorkTime.model.EmpwotmModelOutlier;
import br.com.mind5.business.employeeWorkTime.model.EmpwotmModelSearch;
import br.com.mind5.business.employeeWorkTime.model.EmpwotmModelSelect;
import br.com.mind5.business.employeeWorkTime.model.EmpwotmModelUpdate;
import br.com.mind5.model.Model;

@Path("/Employee")
public class EmployeeResource {
	private static final String INSERT_EMP = "/insertEmployee";
	private static final String UPDATE_EMP = "/updateEmployee";
	private static final String DELETE_EMP = "/deleteEmployee";
	private static final String SELECT_EMP = "/selectEmployee";
	private static final String SEARCH_EMP = "/searchEmployee";
	private static final String INSERT_WORK_TIME = "/insertWorkTime";
	private static final String INSERT_WORK_TIME_FROM_STORE = "/insertWorkTimeFromStore";
	private static final String UPDATE_WORK_TIME = "/updateWorkTime";
	private static final String SELECT_WORK_TIME = "/selectWorkTime";
	private static final String SEARCH_WORK_TIME = "/searchWorkTime";
	private static final String DELETE_WORK_TIME = "/deleteWorkTime";	
	private static final String SELECT_WT_CONFLICT = "/selectWorkTimeConflict";		//todo: REVER
	private static final String INSERT_LEAVE_DATE = "/insertLeaveDate";
	private static final String UPDATE_LEAVE_DATE = "/updateLeaveDate";
	private static final String SELECT_LEAVE_DATE = "/selectLeaveDate";
	private static final String SEARCH_LEAVE_DATE = "/searchLeaveDate";
	private static final String DELETE_LEAVE_DATE = "/deleteLeaveDate";
	private static final String SELECT_EMP_POSITION = "/selectPosition";
	private static final String SEARCH_EMP_POSITION = "/searchPosition";
	private static final String INSERT_EMP_POSITION = "/insertPosition";
	private static final String DELETE_EMP_POSITION = "/deletePosition";
	private static final String SELECT_EMP_MATERIAL = "/selectMaterial";
	private static final String SEARCH_EMP_MATERIAL = "/searchMaterial";
	private static final String INSERT_EMP_MATERIAL = "/insertMaterial";
	private static final String DELETE_EMP_MATERIAL = "/deleteMaterial";
	private static final String SELECT_EMP_WT_OUTLIER = "/selectWorkTimeOutlier";
	
	
	
	@GET
	@Path(SELECT_WORK_TIME)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectWorkTime(@HeaderParam("TOKEN_OWNER")    	@DefaultValue("-1") long codOwner,
								   @HeaderParam("codStore")    		@DefaultValue("-1") long codStore,
								   @HeaderParam("codEmployee") 		@DefaultValue("-1") int codEmployee,
								   @HeaderParam("codWeekday") 		@DefaultValue("-1") int codWeekday,
								   @HeaderParam("TOKEN_USERNAME") 	String username,
								   @HeaderParam("codLanguage")    	@DefaultValue("EN") String codLanguage) {
		
		EmpwotmInfo recordInfo = new EmpwotmInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codEmployee = codEmployee;
		recordInfo.codWeekday = codWeekday;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;
		
		Model model = new EmpwotmModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(SEARCH_WORK_TIME)
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchWorkTime(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new EmpwotmModelSearch(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_WORK_TIME)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertWorkTime(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new EmpwotmModelInsert(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_WORK_TIME_FROM_STORE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertWorkTimeFromStore(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new EmpwotmModelInsertFromStore(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}	
	
	
	
	@POST
	@Path(UPDATE_WORK_TIME)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateWorkTime(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new EmpwotmModelUpdate(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@DELETE
	@Path(DELETE_WORK_TIME)
	@Produces(MediaType.APPLICATION_JSON)	
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
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectWTConflict(@HeaderParam("TOKEN_OWNER")    @DefaultValue("-1") long codOwner,
								     @HeaderParam("codStore")       @DefaultValue("-1") long codStore,
								     @HeaderParam("codEmployee")    @DefaultValue("-1") int codEmployee,
								     @HeaderParam("codWeekday")     @DefaultValue("-1") int codWeekday,
								     @HeaderParam("beginTime")      @DefaultValue("12:00") String beginTime,
	                                 @HeaderParam("endTime")        @DefaultValue("12:00") String endTime,
	                                 @HeaderParam("TOKEN_USERNAME") String username) {
		
		EmpwotmInfo recordInfo = new EmpwotmInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codEmployee = codEmployee;
		recordInfo.codWeekday = codWeekday;
		recordInfo.beginTime = LocalTime.parse(beginTime, DateTimeFormatter.ISO_LOCAL_TIME);
		recordInfo.endTime = LocalTime.parse(endTime, DateTimeFormatter.ISO_LOCAL_TIME);
		recordInfo.username = username;
		
		Model model = new EmpwotmModelConflict(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_LEAVE_DATE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectLeaveDate(@HeaderParam("TOKEN_OWNER") 	@DefaultValue("-1") long codOwner,
								    @HeaderParam("codStore")    	@DefaultValue("-1") long codStore,
								    @HeaderParam("codEmployee") 	@DefaultValue("-1") int codEmployee,
								    @HeaderParam("codLanguage")		@DefaultValue("EN") String codLanguage,				                    
								    @HeaderParam("dateValidFrom")	@DefaultValue("1900-01-01") String dateValidFrom,
								    @HeaderParam("timeValidFrom")   @DefaultValue("12:00") String timeValidFrom,
								    @HeaderParam("TOKEN_USERNAME") String username) {
		
		EmplateInfo recordInfo = new EmplateInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codEmployee = codEmployee;
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		recordInfo.dateValidFrom = LocalDate.parse(dateValidFrom, DateTimeFormatter.ISO_LOCAL_DATE);
		recordInfo.timeValidFrom = LocalTime.parse(timeValidFrom, DateTimeFormatter.ISO_LOCAL_TIME);
		
		Model model = new EmplateModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SEARCH_LEAVE_DATE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchLeaveDate(@HeaderParam("TOKEN_OWNER") 	@DefaultValue("-1") long codOwner,
								    @HeaderParam("codStore")    	@DefaultValue("-1") long codStore,
								    @HeaderParam("codEmployee") 	@DefaultValue("-1") int codEmployee,
								    @HeaderParam("codLanguage")		@DefaultValue("EN") String codLanguage,	
								    @HeaderParam("TOKEN_USERNAME") String username) {
		
		EmplateInfo recordInfo = new EmplateInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codEmployee = codEmployee;
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		
		Model model = new EmplateModelSearch(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_LEAVE_DATE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertLeaveDate(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new EmplateModelInsert(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(UPDATE_LEAVE_DATE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateLeaveDate(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new EmplateModelUpdate(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@DELETE
	@Path(DELETE_LEAVE_DATE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteLeaveDate(@HeaderParam("TOKEN_OWNER")   @DefaultValue("-1") long codOwner,
								    @HeaderParam("codStore")      @DefaultValue("-1") long codStore,
								    @HeaderParam("codEmployee")   @DefaultValue("-1") int codEmployee,
								    @HeaderParam("dateValidFrom") @DefaultValue("1900-01-01") String dateValidFrom,
			                        @HeaderParam("timeValidFrom") @DefaultValue("12:00") String timeValidFrom,
			                        @HeaderParam("codLanguage")	  @DefaultValue("EN") String codLanguage,
				                    @HeaderParam("TOKEN_USERNAME") String username) {
		
		EmplateInfo recordInfo = new EmplateInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codEmployee = codEmployee;
		recordInfo.dateValidFrom = LocalDate.parse(dateValidFrom, DateTimeFormatter.ISO_LOCAL_DATE);
		recordInfo.timeValidFrom = LocalTime.parse(timeValidFrom, DateTimeFormatter.ISO_LOCAL_TIME);
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		
		Model model = new EmplateModelDelete(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	

	@POST
	@Path(INSERT_EMP)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
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
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEmployee(@Context HttpServletRequest request, String incomingData) {

		Model model = new EmpModelUpdate(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}

	
	
	@DELETE
	@Path(DELETE_EMP)
	@Produces(MediaType.APPLICATION_JSON)
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
	
	
	
	@POST
	@Path(SEARCH_EMP)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchEmployee(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new EmplisModelSearch(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_EMP_POSITION)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectEmpos(@HeaderParam("TOKEN_OWNER") @DefaultValue("-1") long codOwner, 
			                    @HeaderParam("codStore") 	@DefaultValue("-1") int codStore,
			                    @HeaderParam("codEmployee") @DefaultValue("-1") int codEmployee,
			                    @HeaderParam("codPosition") @DefaultValue("-1") int codPosition,
			                    @HeaderParam("codLanguage")	@DefaultValue("EN") String codLanguage,
			                    @HeaderParam("TOKEN_USERNAME") String username) {
		
		EmposInfo recordInfo = new EmposInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codEmployee = codEmployee;
		recordInfo.codPosition = codPosition;
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		
		Model model = new EmposModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(SEARCH_EMP_POSITION)
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchEmpos(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new EmposModelSearch(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_EMP_POSITION)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
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
	@Path(SEARCH_EMP_MATERIAL)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchEmpmat(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new EmpmatModelSearch(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_EMP_MATERIAL)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
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
	
	
	
	@GET
	@Path(SELECT_EMP_WT_OUTLIER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectEmpwout(@HeaderParam("TOKEN_OWNER")    @DefaultValue("-1") long codOwner, 
			                      @HeaderParam("codLanguage")    @DefaultValue("EN") String codLanguage,
			                      @HeaderParam("codStore")   	 @DefaultValue("-1") int codStore,
			                      @HeaderParam("codWeekday") 	 @DefaultValue("-1") int codWeekday,
			                      @HeaderParam("beginTime")  	 @DefaultValue("12:00") String beginTime,
			                      @HeaderParam("endTime")  	 	@DefaultValue("12:00") String endTime,
			                      @HeaderParam("TOKEN_USERNAME") String username) {

		EmpwotmInfo recordInfo = new EmpwotmInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codWeekday = codWeekday;
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		recordInfo.beginTime = LocalTime.parse(beginTime, DateTimeFormatter.ISO_LOCAL_TIME);
		recordInfo.endTime = LocalTime.parse(endTime, DateTimeFormatter.ISO_LOCAL_TIME);
		
		Model model = new EmpwotmModelOutlier(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
}
