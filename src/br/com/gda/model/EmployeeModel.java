package br.com.gda.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import br.com.gda.dao.EmployeeDAO;
import br.com.gda.helper.Employee;
import br.com.gda.helper.RecordMode;

public class EmployeeModel extends JsonBuilder {
	private static final String EMPLOYEE = "Employee";
	private ArrayList<Employee> employeeList = new ArrayList<Employee>();

	
	
	public Response insertEmployee(String incomingData) {
		Response resultResponse = tryToInsertEmployee(incomingData);
		return resultResponse;
	}
	
	
	
	private Response tryToInsertEmployee(String incomingData) {
		Employee emptyEmployee = new Employee();
		
		try {
			List<Employee> employees = jsonToEmployeeList(incomingData);
			
			new EmployeeDAO().insertEmployee(employees);			
			return makeResponse(RETURNED_SUCCESSFULLY, Response.Status.OK, employees);
			
			
		} catch (JsonParseException e) {
			return makeResponse(ILLEGAL_ARGUMENT, Response.Status.BAD_REQUEST, emptyEmployee);
		} catch (SQLException | IndexOutOfBoundsException e) {
			return makeResponse(INTERNAL_ERROR, Response.Status.INTERNAL_SERVER_ERROR, emptyEmployee);
		}
	}
	
	
	
	public Response deleteEmployee(long codOwner, int codEmployee) {
		Response resultResponse = tryToDeleteEmployee(codOwner, codEmployee);
		return resultResponse;
	}
	
	
	
	private Response tryToDeleteEmployee(long codOwner, int codEmployee) {
		Employee emptyEmployee = new Employee();
		
		try {
			new EmployeeDAO().deleteEmployee(codOwner, codEmployee);
			return makeResponse(RETURNED_SUCCESSFULLY, Response.Status.OK, emptyEmployee);
		
		} catch (SQLException e) {
			return makeResponse(INTERNAL_ERROR, Response.Status.INTERNAL_SERVER_ERROR, emptyEmployee);
		}
	}
	
	
	
	public Response updateEmployee(String incomingData) {
		Response responseResult = tryToUpdateEmployee(incomingData);
		return responseResult;
	}
	
	
	
	private Response tryToUpdateEmployee(String incomingData) {
		Employee emptyEmployee = new Employee();
		
		try {
			List<Employee> employees = jsonToEmployeeList(incomingData);
			
			new EmployeeDAO().updateEmployee(employees);			
			return makeResponse(RETURNED_SUCCESSFULLY, Response.Status.OK, employees);
			
			
		} catch (JsonParseException e) {
			return makeResponse(ILLEGAL_ARGUMENT, Response.Status.BAD_REQUEST, emptyEmployee);
		} catch (SQLException | IndexOutOfBoundsException e) {
			return makeResponse(INTERNAL_ERROR, Response.Status.INTERNAL_SERVER_ERROR, emptyEmployee);
		}
	}
	
	
	
	private List<Employee> jsonToEmployeeList(String incomingData) {
		List<Employee> employees = new ArrayList<>();
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();

		if (parser.parse(incomingData).isJsonArray()) {
			JsonArray array = parser.parse(incomingData).getAsJsonArray();

			for (int i = 0; i < array.size(); i++) {
				employees.add(gson.fromJson(array.get(i), Employee.class));
			}
		} else {
			JsonObject object = parser.parse(incomingData).getAsJsonObject();
			employees.add(gson.fromJson(object, Employee.class));
		}

		return employees;
	}
	


	public ArrayList<Employee> selectEmployee(List<Long> codOwner, List<Integer> codEmployee, List<String> cpf,
			List<String> password, List<String> name, List<Byte> codPosition, List<Byte> codGender,
			List<String> bornDate, List<String> email, List<String> address1, List<String> address2,
			List<Integer> postalcode, List<String> city, List<String> country, List<String> state, List<String> phone,
			List<String> recordMode) throws SQLException {

		return this.setEmployeeList(
				new EmployeeDAO().selectEmployee(codOwner, codEmployee, cpf, password, name, codPosition, codGender,
						bornDate, email, address1, address2, postalcode, city, country, state, phone, recordMode));

	}

	public JsonObject selectEmployeeJson(List<Long> codOwner, List<Integer> codEmployee, List<String> cpf,
			List<String> password, List<String> name, List<Byte> codPosition, List<Byte> codGender,
			List<String> bornDate, List<String> email, List<String> address1, List<String> address2,
			List<Integer> postalcode, List<String> city, List<String> country, List<String> state, List<String> phone,
			List<String> recordMode, boolean runMsg) {

		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		SQLException exception = new SQLException(RETURNED_SUCCESSFULLY, null, 200);

		try {

			employeeList = selectEmployee(codOwner, codEmployee, cpf, password, name, codPosition, codGender, bornDate,
					email, address1, address2, postalcode, city, country, state, phone, recordMode);

		} catch (SQLException e) {
			exception = e;
		}

		JsonObject jsonObject = getJsonObjectSelect(employeeList, exception);

		if (runMsg)
			sendMessage(employeeList, exception, codOwner, OWNER, EMPLOYEE);

		return jsonObject;
	}

	public Response selectEmployeeResponse(List<Long> codOwner, List<Integer> codEmployee, List<String> cpf,
			List<String> password, List<String> name, List<Byte> codPosition, List<Byte> codGender,
			List<String> bornDate, List<String> email, List<String> address1, List<String> address2,
			List<Integer> postalcode, List<String> city, List<String> country, List<String> state, List<String> phone,
			List<String> recordMode) {

		return responseSuccess(selectEmployeeJson(codOwner, codEmployee, cpf, password, name, codPosition, codGender, bornDate,
				email, address1, address2, postalcode, city, country, state, phone, recordMode, false));
	}

	public ArrayList<Employee> getEmployeeList() {
		return employeeList;
	}

	public ArrayList<Employee> setEmployeeList(ArrayList<Employee> employeeList) {
		this.employeeList = employeeList;
		return employeeList;
	}

}
