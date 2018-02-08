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
import com.google.gson.JsonParser;
import com.google.gson.JsonParseException;

import br.com.gda.dao.OwnerDAO;
import br.com.gda.helper.Customer;
import br.com.gda.helper.DetailMat;
import br.com.gda.helper.Employee;
import br.com.gda.helper.Material;
import br.com.gda.helper.Menu;
import br.com.gda.helper.Owner;
import br.com.gda.helper.RecordMode;
import br.com.gda.helper.Store;


public class OwnerModel extends JsonBuilder {
	public Response insertOwner(String incomingData) {
		Response resultResponse = tryToInsertOwner(incomingData);
		
		if (resultResponse.getStatus() == 200) 
			resultResponse = loginOwner(incomingData);
		
		return resultResponse;
	}
	
	
	
	private Response tryToInsertOwner(String incomingData) {
		try {
			ArrayList<Owner> owners = jsonToOwners(incomingData);
			
			if (! isOwnersValid(owners)) 
				return Response.status(400).entity("IllegalArgument: mandatory argument might be missing or invalid value was passed").build();
			
			if (isOwnersExist(owners)) 
				return Response.status(403).entity("Operation cannot be processed").build();
			
			new OwnerDAO().insertOwner(owners);
			return Response.status(200).entity("Success").build();
			
		} catch (JsonParseException e) {
			return Response.status(400).entity("IllegalArgument: mandatory argument might be missing or invalid value was passed").build();
		} catch (SQLException e) {
			return Response.status(500).entity("Ops... something went wrong").build();
		}
	}
	
	
	
	private ArrayList<Owner> jsonToOwners(String incomingData) {
		ArrayList<Owner> owners = jsonArrayToOwners(incomingData);
		
		if (owners.isEmpty()) {
			Owner oneOwner = jsonObjectToOwner(incomingData);
			owners.add(oneOwner);
		}

		return owners;
	}
	
	
	
	private ArrayList<Owner> jsonArrayToOwners(String incomingData) {
		ArrayList<Owner> owners = new ArrayList<>();		
		JsonParser parser = new JsonParser();

		if (parser.parse(incomingData).isJsonArray()) {
			JsonArray rawOwners = parser.parse(incomingData).getAsJsonArray();
			Gson gson = new Gson();
			for (int i = 0; i < rawOwners.size(); i++) {
				owners.add(gson.fromJson(rawOwners.get(i), Owner.class));
			}
		}

		return owners;
	}
	
	
	
	
	private Owner jsonObjectToOwner(String incomingData) {
		Owner owner = new Owner();		
		JsonParser parser = new JsonParser();

		if (parser.parse(incomingData).isJsonObject()) {
			Gson gson = new Gson();
			JsonObject object = parser.parse(incomingData).getAsJsonObject();
			owner = gson.fromJson(object, Owner.class);
		}

		return owner;
	}
	
	
	
	private boolean isOwnersValid(List<Owner> owners) {
		if (owners == null)
			return false;
		
		if (owners.isEmpty())
			return false;
		
		for (Owner eachOwner : owners) {
			if (isMandatoryFieldEmpty(eachOwner)) 
				return false;
		}
		
		return true;
	}
	
	
	
	private boolean isMandatoryFieldEmpty(Owner owner) {
		if (owner.getPassword() 	== null ||
			owner.getName()     	== null || 
			owner.getCpf()      	== null || 
			owner.getPhone()		== null ||
			owner.getEmail()		== null ||
			owner.getAddress1() 	== null ||
			owner.getCity()			== null ||
			owner.getState()		== null ||
			owner.getCountry()		== null ||
			owner.getBornDate()		== null ||
			owner.getEmailAux()		== null ||
			owner.getPostalcode() 	== 0	||
			owner.getCodGender()    == 0) {
			
			return true;
		}
		
		return false;
	}
	
	
	
	private boolean isOwnersExist(List<Owner> owners) throws SQLException {
		for (Owner eachOwner : owners) {
			if (isOwnerExist(eachOwner)) {
				return true;
			}
		}
		
		return false;
	}
	
	
	
	private boolean isOwnerExist(Owner owner) throws SQLException {
		List<Owner> owners = new OwnerDAO().selectOwnerFromEmail(owner.getEmail());
		
		if (owners == null)
			return false;
		
		if (owners.isEmpty())
			return false;
		
		
		return true;
	}
	
	
	
	public Response loginOwner(String incomingData) {
		Response resultResponse = tryToLoginOwner(incomingData);
		return resultResponse;
	}
	
	
	
	public Response loginOwner(String email, String password) {
		Response resultResponse = tryToLoginOwner(email, password);
		return resultResponse;
	}
	
	
	
	private Response tryToLoginOwner(String incomingData) {
		try {
			List<Owner> owners = jsonToOwners(incomingData);
			Owner oneOwner = owners.get(0);
			
			return tryToLoginOwner(oneOwner.getEmail(), oneOwner.getPassword());
			
			
		} catch (JsonParseException e) {
			return Response.status(400).entity("IllegalArgument: mandatory argument might be missing or invalid value was passed").build();
		}
	}	
	
	
	
	private Response tryToLoginOwner(String email, String password) {
		try {
			 Owner owner = new OwnerDAO().loginOwner(email, password);
			
			if (owner.getCodOwner() == 0) 
				return Response.status(403).entity("User or password does not match").build();			
			
			return makeResponse(RETURNED_SUCCESSFULLY, 200, owner);
			
		} catch (JsonParseException e) {
			return Response.status(400).entity("IllegalArgument: mandatory argument might be missing or invalid value was passed").build();
		} catch (SQLException | IndexOutOfBoundsException e) {
			return Response.status(500).entity("Ops... something went wrong").build();
		}
	}	
	
	
	
	private Response makeResponse(String msg, int htmlReturnCode, Object dataObj) {
		JsonElement jsonElement = new JsonArray().getAsJsonArray();
		SQLException exception = new SQLException(msg, null, htmlReturnCode);		
		jsonElement = new Gson().toJsonTree(dataObj);
		JsonObject jsonObject = getJsonObjectSelect(jsonElement, exception);			
		return response(jsonObject);
	}
	
	
	
	public Response selectOwner(String ownerCode, SelectOwnerOption option) {
		Response resultResponse = tryToSelectOwner(ownerCode, option);
		return resultResponse;
	}
	
	
	//TODO: Código original colocava cada IF dentro de uma THREAD
	//TODO: Colocar cada IF dentro de um método
	//TODO: Verificar opções mandatórias: Language
	private Response tryToSelectOwner(String ownerCode, SelectOwnerOption option) {
		Owner owner = new Owner();
		
		try {
			if (option.isHeader)
				owner = new OwnerDAO().selectOwnerFromOwnerCode(ownerCode);
			
			
			if (option.isDetailMat) {
				List<Long> codOwnerList = new ArrayList<>();
				codOwnerList.add(Long.valueOf(ownerCode));
				List<String> recordMode = new ArrayList<String>();
				recordMode.add(RecordMode.RECORD_OK);
				List<String> language = new ArrayList<>();
				language.add(option.language);				
				
				ArrayList<DetailMat> detailMaterial = new DetailMatModel().selectDetailMat(codOwnerList, null, recordMode, language, null);
				owner.setDetailMat(detailMaterial);
			}
			
			return makeResponse(RETURNED_SUCCESSFULLY, 200, owner);
			
			
		} catch (SQLException e) {
			return Response.status(500).entity("Ops... something went wrong").build();
		}
		
		
		
/*
		return response(selectOwnerJson(email, cpf, password, language, withDetailMat,
				withMaterial, withMenu, withStore, withEmployee, withStoreMenu, withStoreMaterial, withStoreEmployee,
				withStoreTables, withStoreBill, zoneId));*/
	}
	
	
	
	

	public Response updateOwner(String incomingData) {
		
		ArrayList<Owner> ownerList = jsonToOwners(incomingData);

		SQLException exception = new OwnerDAO().updateOwner(ownerList);

		JsonObject jsonObject = getJsonObjectUpdate(exception);
		
		if (exception.getErrorCode() == 200) {
			SQLException selectException = new SQLException(RETURNED_SUCCESSFULLY, null, 200);
			jsonObject = mergeJsonObject(jsonObject, getJsonObjectSelect(ownerList, selectException));
		} else {
			JsonElement jsonElement = new JsonArray();
			SQLException ex = new SQLException();
			jsonObject = mergeJsonObject(jsonObject, getJsonObjectSelect(jsonElement, ex));
		}

		return response(jsonObject);
	}

	public Response deleteOwner(List<Long> codOwner, List<String> password, List<String> name, List<String> cpf,
			List<String> phone, List<String> email, List<String> emailAux, List<Byte> codGender, List<String> bornDate,
			List<Integer> postalcode, List<String> address1, List<String> address2, List<String> city,
			List<String> country, List<String> state, List<String> codCurr, List<String> recordMode) {

		SQLException exception = new OwnerDAO().deleteOwner(codOwner, password, name, cpf, phone, email, emailAux,
				codGender, bornDate, postalcode, address1, address2, city, country, state, codCurr, recordMode);

		JsonObject jsonObject = getJsonObjectUpdate(exception);

		return response(jsonObject);
	}

	public ArrayList<Owner> selectOwner(String email, String cpf, String password, 
			List<String> language, Boolean withDetailMat, Boolean withMaterial, Boolean withMenu, Boolean withStore,
			Boolean withEmployee, Boolean withStoreMenu, Boolean withStoreMaterial, Boolean withStoreEmployee,
			Boolean withStoreTables, Boolean withStoreBill, String zoneId) throws SQLException {

		List<String> recordMode = new ArrayList<String>();
		recordMode.add(RecordMode.RECORD_OK);
		
		final ArrayList<Owner> ownerList = new OwnerDAO().selectOwner(email, cpf, password, recordMode);

		if (withDetailMat || withMaterial || withMenu || withStore || withEmployee) {

			List<Long> codOwnerList = ownerList.stream().map(s -> s.getCodOwner()).distinct()
					.collect(Collectors.toList());

			DetailMatModel detailMatModel = new DetailMatModel();
			MaterialModel materialModel = new MaterialModel();
			MenuModel menuModel = new MenuModel();
			StoreModel storeModel = new StoreModel();
			EmployeeModel employeeModel = new EmployeeModel();

			if (codOwnerList != null && !codOwnerList.isEmpty()) {

				Thread tDetailMat = null;
				Thread tMaterial = null;
				Thread tMenu = null;
				Thread tStore = null;
				Thread tEmployee = null;

				if (withDetailMat) {

					tDetailMat = new Thread(new Runnable() {
						public void run() {
							try {
								detailMatModel.selectDetailMat(codOwnerList, null, recordMode, language, null);
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					});
					tDetailMat.start();
				}

				if (withMaterial) {

					tMaterial = new Thread(new Runnable() {
						public void run() {
							try {
								materialModel.selectMaterial(codOwnerList, null, null, null, null, null, recordMode,
										language, null, null, null);
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					});
					tMaterial.start();
				}

				if (withMenu) {

					tMenu = new Thread(new Runnable() {
						public void run() {
							try {
								menuModel.selectMenu(codOwnerList, null, recordMode, language, null);
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					});
					tMenu.start();

				}

				if (withStore) {

					tStore = new Thread(new Runnable() {
						public void run() {
							try {
								storeModel.selectStore(codOwnerList, null, null, null, null, null, null, null, null,
										null, null, null, null, null, null, recordMode, language,
										withStoreMaterial, withStoreEmployee, zoneId);
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					});
					tStore.start();
				}

				if (withEmployee) {

					tEmployee = new Thread(new Runnable() {
						public void run() {
							try {
								employeeModel.selectEmployee(codOwnerList, null, null, null, null, null, null, null,
										null, null, null, null, null, null, null, null, recordMode);
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					});
					tEmployee.start();
				}

				try {
					if (tDetailMat != null)
						tDetailMat.join();
					if (tMaterial != null)
						tMaterial.join();
					if (tMenu != null)
						tMenu.join();
					if (tStore != null)
						tStore.join();
					if (tEmployee != null)
						tEmployee.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				final ArrayList<DetailMat> ownerDetailMatList = detailMatModel.getDetailMatList();
				final ArrayList<Material> ownerMaterialList = materialModel.getMaterialList();
				final ArrayList<Menu> ownerMenuList = menuModel.getMenuList();
				final ArrayList<Store> ownerStoreList = storeModel.getStoreList();
				final ArrayList<Employee> ownerEmployeeList = employeeModel.getEmployeeList();

				ownerList.stream().forEach(o -> {
					o.getDetailMat().addAll(ownerDetailMatList.stream()
							.filter(m -> o.getCodOwner().equals(m.getCodOwner())).collect(Collectors.toList()));
					o.getMaterial().addAll(ownerMaterialList.stream()
							.filter(m -> o.getCodOwner().equals(m.getCodOwner())).collect(Collectors.toList()));
					o.getMenu().addAll(ownerMenuList.stream().filter(m -> o.getCodOwner().equals(m.getCodOwner()))
							.collect(Collectors.toList()));
					o.getStore().addAll(ownerStoreList.stream().filter(t -> o.getCodOwner().equals(t.getCodOwner()))
							.collect(Collectors.toList()));
					o.getEmployee().addAll(ownerEmployeeList.stream()
							.filter(e -> o.getCodOwner().equals(e.getCodOwner())).collect(Collectors.toList()));
				});
			}
		}

		return ownerList;

	}

	public JsonObject selectOwnerJson(String email, String cpf, String password, List<String> language, Boolean withDetailMat, Boolean withMaterial, Boolean withMenu, Boolean withStore,
			Boolean withEmployee, Boolean withStoreMenu, Boolean withStoreMaterial, Boolean withStoreEmployee,
			Boolean withStoreTables, Boolean withStoreBill, String zoneId) {

		JsonElement jsonElement = new JsonArray().getAsJsonArray();
		SQLException exception = new SQLException(RETURNED_SUCCESSFULLY, null, 200);

		try {

			jsonElement = new Gson().toJsonTree(selectOwner(email, cpf, password, language, withDetailMat, withMaterial, withMenu, withStore, withEmployee, withStoreMenu,
					withStoreMaterial, withStoreEmployee, withStoreTables, withStoreBill, zoneId));

		} catch (SQLException e) {
			exception = e;
		}

		JsonObject jsonObject = getJsonObjectSelect(jsonElement, exception);

		return jsonObject;
	}
	

	//TODO: Refactoring - Começa aqui
	public Response selectOwnerResponse(String email, String cpf, String password, List<String> language, Boolean withDetailMat, Boolean withMaterial, Boolean withMenu, Boolean withStore,
			Boolean withEmployee, Boolean withStoreMenu, Boolean withStoreMaterial, Boolean withStoreEmployee,
			Boolean withStoreTables, Boolean withStoreBill, String zoneId) {

		return response(selectOwnerJson(email, cpf, password, language, withDetailMat,
				withMaterial, withMenu, withStore, withEmployee, withStoreMenu, withStoreMaterial, withStoreEmployee,
				withStoreTables, withStoreBill, zoneId));
	}
	
	
	public Response changePassword(Long codOwner, String newPassword) {						// M.Maciel - 21-jan-18
		SQLException exception = new OwnerDAO().changePassword(codOwner, newPassword);		// M.Maciel - 21-jan-18
		JsonObject jsonObject = getJsonObjectUpdate(exception);								// M.Maciel - 21-jan-18
		return response(jsonObject);														// M.Maciel - 21-jan-18
	}					
	
	
	
	public Response insertCustomer(String incomingData) {
		CustomerModel customerModel = new CustomerModel();
		List<Customer> customerList = customerModel.jsonToCustomerList(incomingData);
		
		Response responseResult = null;
		
		if (!customerModel.isCustomerExist(customerList))
			responseResult = customerModel.insertCustomer(incomingData);
		
		return responseResult;
	}
	
	
	
	public static class SelectOwnerOption {		
		public String  language;		
		public boolean isMenu;
		public boolean isStore;		
		public boolean isHeader;
		public boolean isEmployee;
		public boolean isMaterial;
		public boolean isDetailMat;		

		
		public SelectOwnerOption() {
			language    = null;
			isMenu      = false;			
			isStore     = false;
			isHeader    = false;
			isMaterial  = false;
			isEmployee  = false;
			isDetailMat = false;
		}
	}
}
