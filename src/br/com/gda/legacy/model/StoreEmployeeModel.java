package br.com.gda.legacy.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import br.com.gda.helper.StoreEmployee;
import br.com.gda.legacy.dao.StoreEmployeeDAO;

public class StoreEmployeeModel extends JsonBuilder {

	private static final String STORE_EMPLOYEE = "StoreEmployee";
	private ArrayList<StoreEmployee> storeEmployeeList = new ArrayList<StoreEmployee>();

	public Response insertStoreEmployee(String incomingData) {
		//TODO: retornar resultado do banco
		//TODO: inserir valida��o: empregado inativo, position n�o aplic�vel
		Response resultResponse = tryToInsertStoreEmployee(incomingData);
		return resultResponse;
	}
	
	
	
	private Response tryToInsertStoreEmployee(String incomingData) {
		StoreEmployee emptyStoreEmployee = new StoreEmployee();
		
		try {
			List<StoreEmployee> storeEmployees = jsonToStoreEmployeeList(incomingData);
			
			new StoreEmployeeDAO().insertStoreEmployee(storeEmployees);			
			return makeResponse(RETURNED_SUCCESSFULLY, Response.Status.OK, storeEmployees);
			
			
		} catch (JsonParseException e) {
			return makeResponse(ILLEGAL_ARGUMENT, Response.Status.BAD_REQUEST, emptyStoreEmployee);
		} catch (SQLException | IndexOutOfBoundsException e) {
			return makeResponse(INTERNAL_ERROR, Response.Status.INTERNAL_SERVER_ERROR, emptyStoreEmployee);
		}
	}
	
	
	
	public Response updateStoreEmployee(String incomingData) {
		//TODO: retornar resultado do banco
		//TODO: inserir valida��o: empregado inativo, position n�o aplic�vel
		//TODO: Classe DAO est� complexa, precisa simplificar
		Response resultResponse = tryToUpdateStoreEmployee(incomingData);
		return resultResponse;
	}
	
	
	
	private Response tryToUpdateStoreEmployee(String incomingData) {
		StoreEmployee emptyStoreEmployee = new StoreEmployee();
		
		try {
			List<StoreEmployee> storeEmployees = jsonToStoreEmployeeList(incomingData);
			
			new StoreEmployeeDAO().updateStoreEmployee(storeEmployees);			
			return makeResponse(RETURNED_SUCCESSFULLY, Response.Status.OK, storeEmployees);
			
			
		} catch (JsonParseException e) {
			return makeResponse(ILLEGAL_ARGUMENT, Response.Status.BAD_REQUEST, emptyStoreEmployee);
		} catch (SQLException | IndexOutOfBoundsException e) {
			return makeResponse(INTERNAL_ERROR, Response.Status.INTERNAL_SERVER_ERROR, emptyStoreEmployee);
		}
	}
	
	
	
	public Response deleteStoreEmployee(long codOwner, int codStore, int codEmployee) {
		//TODO: adicionar regra de valida��o
		Response resultResponse = tryToDeleteStoreEmployee(codOwner, codStore, codEmployee);
		return resultResponse;
	}
	
	
	
	private Response tryToDeleteStoreEmployee(long codOwner, int codStore, int codEmployee) {
		StoreEmployee emptyStoreEmployee = new StoreEmployee();
		
		try {			
			new StoreEmployeeDAO().deleteStoreEmployee(codOwner, codStore, codEmployee);			
			return makeResponse(RETURNED_SUCCESSFULLY, Response.Status.OK, emptyStoreEmployee);
			
			
		} catch (JsonParseException e) {
			return makeResponse(ILLEGAL_ARGUMENT, Response.Status.BAD_REQUEST, emptyStoreEmployee);
		} catch (SQLException | IndexOutOfBoundsException e) {
			return makeResponse(INTERNAL_ERROR, Response.Status.INTERNAL_SERVER_ERROR, emptyStoreEmployee);
		}
	}
	
	
	
	private List<StoreEmployee> jsonToStoreEmployeeList(String incomingData) {
		List<StoreEmployee> storeEmployees = new ArrayList<>();
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();

		if (parser.parse(incomingData).isJsonArray()) {
			JsonArray array = parser.parse(incomingData).getAsJsonArray();

			for (int i = 0; i < array.size(); i++) {
				storeEmployees.add(gson.fromJson(array.get(i), StoreEmployee.class));
			}
		} else {
			JsonObject object = parser.parse(incomingData).getAsJsonObject();
			storeEmployees.add(gson.fromJson(object, StoreEmployee.class));
		}

		return storeEmployees;
	}





	public ArrayList<StoreEmployee> selectStoreEmployee(List<Long> codOwner, List<Integer> codStore,
			List<Integer> codEmployee, List<String> cpf, List<String> password, List<String> name,
			List<Byte> codPosition, List<Byte> codGender, List<String> bornDate, List<String> email,
			List<String> address1, List<String> address2, List<Integer> postalcode, List<String> city,
			List<String> country, List<String> state, List<String> phone, List<String> recordMode) throws SQLException {

		return this.setStoreEmployeeList(new StoreEmployeeDAO().selectStoreEmployee(codOwner, codStore, codEmployee,
				cpf, password, name, codPosition, codGender, bornDate, email, address1, address2, postalcode, city,
				country, state, phone, recordMode));

	}

	public JsonObject selectStoreEmployeeJson(List<Long> codOwner, List<Integer> codStore, List<Integer> codEmployee,
			List<String> cpf, List<String> password, List<String> name, List<Byte> codPosition, List<Byte> codGender,
			List<String> bornDate, List<String> email, List<String> address1, List<String> address2,
			List<Integer> postalcode, List<String> city, List<String> country, List<String> state, List<String> phone,
			List<String> recordMode, boolean runMsg) {

		ArrayList<StoreEmployee> storeEmployeeList = new ArrayList<StoreEmployee>();
		SQLException exception = new SQLException(RETURNED_SUCCESSFULLY, null, 200);

		try {

			storeEmployeeList = selectStoreEmployee(codOwner, codStore, codEmployee, cpf, password, name, codPosition,
					codGender, bornDate, email, address1, address2, postalcode, city, country, state, phone,
					recordMode);

		} catch (SQLException e) {
			exception = e;
		}

		JsonObject jsonObject = getJsonObjectSelect(storeEmployeeList, exception);

		if (runMsg)
			sendMessage(storeEmployeeList, exception, codStore, STORE, STORE_EMPLOYEE);

		return jsonObject;
	}

	public Response selectStoreEmployeeResponse(List<Long> codOwner, List<Integer> codStore, List<Integer> codEmployee,
			List<String> cpf, List<String> password, List<String> name, List<Byte> codPosition, List<Byte> codGender,
			List<String> bornDate, List<String> email, List<String> address1, List<String> address2,
			List<Integer> postalcode, List<String> city, List<String> country, List<String> state, List<String> phone,
			List<String> recordMode) {

		return responseSuccess(selectStoreEmployeeJson(codOwner, codStore, codEmployee, cpf, password, name, codPosition,
				codGender, bornDate, email, address1, address2, postalcode, city, country, state, phone, recordMode,
				false));
	}

	public ArrayList<StoreEmployee> getStoreEmployeeList() {
		return storeEmployeeList;
	}

	public ArrayList<StoreEmployee> setStoreEmployeeList(ArrayList<StoreEmployee> storeEmployeeList) {
		this.storeEmployeeList = storeEmployeeList;
		return storeEmployeeList;
	}

}
