package br.com.gda.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.model.EmpModelDelete;
import br.com.gda.business.employee.model.EmpModelInsert;
import br.com.gda.business.employee.model.EmpModelSelect;
import br.com.gda.business.employee.model.EmpModelUpdate;
import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.business.employeeWorkTime.model.EmpWTimeModelDelete;
import br.com.gda.business.employeeWorkTime.model.EmpWTimeModelInsert;
import br.com.gda.business.employeeWorkTime.model.EmpWTimeModelSelect;
import br.com.gda.business.employeeWorkTime.model.EmpWTimeModelUpdate;
import br.com.gda.model.Model;
import br.com.gda.model.legacy.EmployeeModel;

@Path("/Employee")
public class EmployeeResource {
	private static final String INSERT_EMPLOYEE = "/insertEmployee";
	private static final String UPDATE_EMPLOYEE = "/updateEmployee";
	private static final String DELETE_EMPLOYEE = "/deleteEmployee";
	private static final String SELECT_EMPLOYEE = "/selectEmployee";
	private static final String LOGIN_EMPLOYEE = "/loginEmployee";
	private static final String INSERT_WORK_TIME = "/insertWorkTime";
	private static final String UPDATE_WORK_TIME = "/updateWorkTime";
	private static final String SELECT_WORK_TIME = "/selectWorkTime";
	private static final String DELETE_WORK_TIME = "/deleteWorkTime";
	
	
	@GET
	@Path(SELECT_WORK_TIME)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response selectWorkTime(@HeaderParam("codOwner") long codOwner,
								   @HeaderParam("codStore") long codStore,
								   @HeaderParam("codEmployee") int codEmployee) {
		
		EmpWTimeInfo workingTimeInfo = new EmpWTimeInfo();
		workingTimeInfo.codOwner = codOwner;
		workingTimeInfo.codStore = codStore;
		workingTimeInfo.codEmployee = codEmployee;
		
		Model workingTimeSelect = new EmpWTimeModelSelect(workingTimeInfo);
		workingTimeSelect.executeRequest();
		return workingTimeSelect.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_WORK_TIME)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertWorkTime(String incomingData) {
		Model workingTimeInsert = new EmpWTimeModelInsert(incomingData);
		workingTimeInsert.executeRequest();
		return workingTimeInsert.getResponse();
	}
	
	
	
	@POST
	@Path(UPDATE_WORK_TIME)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateWorkTime(String incomingData) {
		Model workingTimeUpdate = new EmpWTimeModelUpdate(incomingData);
		workingTimeUpdate.executeRequest();
		return workingTimeUpdate.getResponse();
	}
	
	
	
	@DELETE
	@Path(DELETE_WORK_TIME)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteWorkTime(@HeaderParam("codOwner") long codOwner,
								   @HeaderParam("codStore") long codStore,
								   @HeaderParam("codEmployee") int codEmployee,
								   @HeaderParam("weekday") int weekday) {
		
		EmpWTimeInfo workingTimeInfo = new EmpWTimeInfo();
		workingTimeInfo.codOwner = codOwner;
		workingTimeInfo.codStore = codStore;
		workingTimeInfo.codEmployee = codEmployee;
		workingTimeInfo.codWeekday = weekday;
		
		Model workingTimeInsert = new EmpWTimeModelDelete(workingTimeInfo);
		workingTimeInsert.executeRequest();
		return workingTimeInsert.getResponse();
	}
	
	

	@POST
	@Path(INSERT_EMPLOYEE)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertEmployee(String incomingData) {
		//TODO: horário do empregado. Se nulo, então pegar da Store	
		//TODO: position (ex: cabelereiro, manicuro) não deviria ficar na tab empregado, mas somente na store_emp. Assim um empregado pode ter mais de uma position na loja
		Model employeeInsert = new EmpModelInsert(incomingData);
		employeeInsert.executeRequest();
		return employeeInsert.getResponse();
	}

	
	@POST
	@Path(UPDATE_EMPLOYEE)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateOwner(String incomingData) {
		//TODO: mudanã de password não pode ser por esse serviço
		Model employeeUpdate = new EmpModelUpdate(incomingData);
		employeeUpdate.executeRequest();
		return employeeUpdate.getResponse();
	}

	
	
	@DELETE
	@Path(DELETE_EMPLOYEE)
	public Response deleteEmployee(@HeaderParam("codOwner")    long codOwner,
								   @HeaderParam("codEmployee") int codEmployee) {
		
		//TODO: atualizar StoreEmployee
		EmpInfo employeeInfo = new EmpInfo();
		employeeInfo.codOwner = codOwner;
		employeeInfo.codEmployee = codEmployee;
		
		Model workingTimeInsert = new EmpModelDelete(employeeInfo);
		workingTimeInsert.executeRequest();
		return workingTimeInsert.getResponse();
	}
	
	
	
	@GET																										
	@Path(LOGIN_EMPLOYEE)																							
	@Produces(MediaType.APPLICATION_JSON)																		
	public Response loginOwner(@HeaderParam("codOwner") long codOwner, @HeaderParam("email") String email, @HeaderParam("password") String password) {
		//TODO: um mesmo empregado pode estar em mais de um estabelecimento. Retornar uma lista com todos os Owner para seleção
		//TODO: não retornar o password
		return new EmployeeModel().loginEmployee(codOwner, email, password);											
	}		

	
	
	@GET
	@Path(SELECT_EMPLOYEE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectEmployee(@HeaderParam("codOwner")    long codOwner,
								   @HeaderParam("codEmployee") int codEmployee) {
		
		//TODO: O Android est� chamando esse m�todo para obter os empregados. Verificar se StoreEmployee � mais apropriado
		//TODO: Convertido de QueryParam para headerParam
		
		
		EmpInfo employeeInfo = new EmpInfo();
		employeeInfo.codOwner = codOwner;
		employeeInfo.codEmployee = codEmployee;
		
		Model employeeSelect = new EmpModelSelect(employeeInfo);
		employeeSelect.executeRequest();
		return employeeSelect.getResponse();
	}
}
