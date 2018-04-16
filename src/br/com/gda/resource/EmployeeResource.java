package br.com.gda.resource;

import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.employee.info.EmpWTimeInfo;
import br.com.gda.employee.model.EmpWtimeModelDelete;
import br.com.gda.employee.model.EmpWtimeModelInsert;
import br.com.gda.employee.model.EmpWtimeModelSelect;
import br.com.gda.employee.model.EmpWtimeModelUpdate;
import br.com.gda.employee.model.decisionTree.EmpWtimeNodeInsOrUpd;
import br.com.gda.employee.model.decisionTree.EmpWtimeRootInsert;
import br.com.gda.model.decisionTree.DecisionTreeOption;
import br.com.gda.model.legacy.EmployeeModel;

@Path("/Employee")
public class EmployeeResource {

	private static final String INSERT_EMPLOYEE = "/insertEmployee";
	private static final String UPDATE_EMPLOYEE = "/updateEmployee";
	private static final String DELETE_EMPLOYEE = "/deleteEmployee";
	private static final String SELECT_EMPLOYEE = "/selectEmployee";
	private static final String LOGIN_EMPLOYEE = "/loginEmployee";
	private static final String INSERT_WOKING_TIME = "/insertWorkingTime";
	private static final String UPDATE_WOKING_TIME = "/updateWorkingTime";
	private static final String SELECT_WOKING_TIME = "/selectWorkingTime";
	private static final String DELETE_WOKING_TIME = "/deleteWorkingTime";
	
	
	@GET
	@Path(SELECT_WOKING_TIME)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response selectWorkingTime(@HeaderParam("codOwner") long codOwner,
									  @HeaderParam("codStore") long codStore,
									  @HeaderParam("codEmployee") int codEmployee) {
		
		EmpWTimeInfo workingTimeInfo = new EmpWTimeInfo();
		workingTimeInfo.codOwner = codOwner;
		workingTimeInfo.codStore = codStore;
		workingTimeInfo.codEmployee = codEmployee;
		
		EmpWtimeModelSelect workingTimeSelect = new EmpWtimeModelSelect(workingTimeInfo);
		workingTimeSelect.executeRequest();
		return workingTimeSelect.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_WOKING_TIME)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertWorkingTime(String incomingData) {
		List<EmpWTimeInfo> recordInfos = new ArrayList<>(); 
		EmpWTimeInfo oneRecordInfo = new EmpWTimeInfo();
		oneRecordInfo.codOwner = 8;
		oneRecordInfo.codStore = 15;
		oneRecordInfo.codEmployee = 54;
		oneRecordInfo.weekday = 1;
		oneRecordInfo.beginTime = LocalTime.of(10,11);
		oneRecordInfo.endTime = LocalTime.of(12,13);
		recordInfos.add(oneRecordInfo);
		
		DecisionTreeOption<EmpWTimeInfo> treeOption = new DecisionTreeOption<>();
		treeOption.conn = DbConnection.getConnection();
		treeOption.schemaName = DbSchema.getDefaultSchemaName();
		treeOption.recordInfos = recordInfos;
		
		EmpWtimeRootInsert tree = new EmpWtimeRootInsert(treeOption);
		tree.makeDecision();
		
		try {
			treeOption.conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		/*EmpWtimeModelInsert workingTimeInsert = new EmpWtimeModelInsert(incomingData);
		workingTimeInsert.executeRequest();
		return workingTimeInsert.getResponse(); */
	}
	
	
	
	@POST
	@Path(UPDATE_WOKING_TIME)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateWorkingTime(String incomingData) {
		EmpWtimeModelUpdate workingTimeUpdate = new EmpWtimeModelUpdate(incomingData);
		workingTimeUpdate.executeRequest();
		return workingTimeUpdate.getResponse();
	}
	
	
	
	@DELETE
	@Path(DELETE_WOKING_TIME)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteWorkingTime(@HeaderParam("codOwner") long codOwner,
									  @HeaderParam("codStore") long codStore,
									  @HeaderParam("codEmployee") int codEmployee,
									  @HeaderParam("weekday") int weekday) {
		
		EmpWTimeInfo workingTimeInfo = new EmpWTimeInfo();
		workingTimeInfo.codOwner = codOwner;
		workingTimeInfo.codStore = codStore;
		workingTimeInfo.codEmployee = codEmployee;
		workingTimeInfo.weekday = weekday;
		
		EmpWtimeModelDelete workingTimeInsert = new EmpWtimeModelDelete(workingTimeInfo);
		workingTimeInsert.executeRequest();
		return workingTimeInsert.getResponse();
	}
	
	

	@POST
	@Path(INSERT_EMPLOYEE)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertEmployee(String incomingData) {
		//TODO: horário do empregado. Se nulo, então pegar da Store
		return new EmployeeModel().insertEmployee(incomingData);
	}

	
	@POST
	@Path(UPDATE_EMPLOYEE)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateOwner(String incomingData) {
		//TODO: mudanã de password não pode ser por esse serviço
		return new EmployeeModel().updateEmployee(incomingData);
	}

	
	
	@DELETE
	@Path(DELETE_EMPLOYEE)
	public Response deleteEmployee(@HeaderParam("codOwner") long codOwner,
								   @HeaderParam("codEmployee") int codEmployee) {

		//TODO: atualizar StoreEmployee
		return new EmployeeModel().deleteEmployee(codOwner, codEmployee);
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
	public Response selectEmployee(@HeaderParam("codOwner") List<Long> codOwner,
			@QueryParam("codEmployee") List<Integer> codEmployee, @QueryParam("cpf") List<String> cpf,
			@QueryParam("password") List<String> password, @QueryParam("name") List<String> name,
			@QueryParam("codPosition") List<Byte> codPosition, @QueryParam("codGender") List<Byte> codGender,
			@QueryParam("bornDate") List<String> bornDate, @QueryParam("email") List<String> email,
			@QueryParam("address1") List<String> address1, @QueryParam("address2") List<String> address2,
			@QueryParam("postalcode") List<Integer> postalcode, @QueryParam("city") List<String> city,
			@QueryParam("country") List<String> country, @QueryParam("state") List<String> state,
			@QueryParam("phone") List<String> phone,
			@DefaultValue(" ") @QueryParam("recordMode") List<String> recordMode) {
		//TODO: O Android est� chamando esse m�todo para obter os empregados. Verificar se StoreEmployee � mais apropriado
		return new EmployeeModel().selectEmployeeResponse(codOwner, codEmployee, cpf, password, name, codPosition,
				codGender, bornDate, email, address1, address2, postalcode, city, country, state, phone, recordMode);
	}

}
