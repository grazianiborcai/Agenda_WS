package br.com.gda.legacy.model;

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

import br.com.gda.helper.Customer;
import br.com.gda.helper.DetailMat;
import br.com.gda.helper.Employee;
import br.com.gda.helper.Material;
import br.com.gda.helper.Menu;
import br.com.gda.helper.Owner;
import br.com.gda.helper.RecordMode;
import br.com.gda.helper.Store;
import br.com.gda.legacy.dao.OwnerDAO;


public class OwnerModel extends JsonBuilder {
	//TODO: Precisa inserir regras de validação de campos
	public Response insertOwner(String incomingData) {
		Response resultResponse = tryToInsertOwner(incomingData);
		
		int success = Response.Status.OK.getStatusCode();
		
		if (resultResponse.getStatus() == success) 
			resultResponse = loginOwner(incomingData);
		
		return resultResponse;
	}
	
	
	
	private Response tryToInsertOwner(String incomingData) {
		Owner emptyOwner = new Owner();
		
		try {
			ArrayList<Owner> owners = jsonToOwners(incomingData);
			
			if (! isOwnersValid(owners))
				return makeResponse(ILLEGAL_ARGUMENT, Response.Status.BAD_REQUEST, emptyOwner);
			
			
			if (isOwnersExist(owners))
				return makeResponse(USER_ALREADY_EXIST, Response.Status.FORBIDDEN, emptyOwner);
			
			
			
			new OwnerDAO().insertOwner(owners);
			return makeResponse(RETURNED_SUCCESSFULLY, Response.Status.OK, emptyOwner);
			
		} catch (JsonParseException e) {
			return makeResponse(ILLEGAL_ARGUMENT, Response.Status.BAD_REQUEST, emptyOwner);
			
		} catch (SQLException e) {
			return makeResponse(INTERNAL_ERROR, Response.Status.INTERNAL_SERVER_ERROR, emptyOwner);
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
			Owner emptyOwner = new Owner();
			return makeResponse(ILLEGAL_ARGUMENT, Response.Status.BAD_REQUEST, emptyOwner);
		}
	}	
	
	
	
	private Response tryToLoginOwner(String email, String password) {
		Owner emptyOwner = new Owner();
		
		try {
			 Owner owner = new OwnerDAO().loginOwner(email, password);
			
			if (owner.getCodOwner() == 0) 
				return makeResponse(LOGIN_FAILED, Response.Status.FORBIDDEN, emptyOwner);
			
			
			return makeResponse(RETURNED_SUCCESSFULLY, Response.Status.OK, owner);
			
			
		} catch (JsonParseException e) {
			return makeResponse(ILLEGAL_ARGUMENT, Response.Status.BAD_REQUEST, emptyOwner);
			
		} catch (SQLException | IndexOutOfBoundsException e) {
			return makeResponse(INTERNAL_ERROR, Response.Status.INTERNAL_SERVER_ERROR, emptyOwner);
		}
	}	
	
	
	
	public Response selectOwner(String ownerCode, SelectOwnerOption option) {
		Response resultResponse = tryToSelectOwner(ownerCode, option);
		return resultResponse;
	}
	
	

	private Response tryToSelectOwner(String ownerCode, SelectOwnerOption option) {
		Owner emptyOwner = new Owner();
		
		try {
			if (! isSelectOwnerValid(ownerCode, option)) 
				return makeResponse(ILLEGAL_ARGUMENT, Response.Status.BAD_REQUEST, emptyOwner);
			
			Owner owner = new Owner();
			owner = selectOwnerHeader(ownerCode, option);
			
			ArrayList<DetailMat> detailMaterial = selectOwnerDetailMat(ownerCode, option);
			owner.setDetailMat(detailMaterial);
			
			ArrayList<Material> material = selectOwnerMaterial(ownerCode, option);
			owner.setMaterial(material);
			
			ArrayList<Menu> menu = selectOwnerMenu(ownerCode, option);
			owner.setMenu(menu);
			
			ArrayList<Store> store = selectOwnerStore(ownerCode, option);
			owner.setStore(store);
			
			ArrayList<Employee> employee = selectOwnerEmployee(ownerCode, option);
			owner.setEmployee(employee);
			
			return makeResponse(RETURNED_SUCCESSFULLY, Response.Status.OK, owner);
			
			
		} catch (SQLException e) {
			return makeResponse(INTERNAL_ERROR, Response.Status.INTERNAL_SERVER_ERROR, emptyOwner);
		}		
	}
	
	
	
	private boolean isSelectOwnerValid(String ownerCode, SelectOwnerOption option) {
		if (ownerCode == null)
			return false;
		
		if (option.language == null)
			return false;
		
		
		return true;
	}
	
	
		
	private Owner selectOwnerHeader(String ownerCode, SelectOwnerOption option) throws SQLException {
		Owner ownerResult = new Owner();
		
		if (option.isHeader)
			ownerResult = new OwnerDAO().selectOwnerFromOwnerCode(ownerCode);
		
		return ownerResult;
	}
	
	
	
	private ArrayList<DetailMat> selectOwnerDetailMat(String ownerCode, SelectOwnerOption option) throws SQLException {
		ArrayList<DetailMat> resultDetailMat = new ArrayList<>();
		
		List<Long> codOwnerList = new ArrayList<>();
		codOwnerList.add(Long.valueOf(ownerCode));
		
		List<String> recordMode = new ArrayList<String>();
		recordMode.add(RecordMode.RECORD_OK);
		
		List<String> language = new ArrayList<>();
		language.add(option.language);	
		
		if (option.isDetailMat) 
			resultDetailMat = new DetailMatModel().selectDetailMat(codOwnerList, null, recordMode, language, null);			
		
		
		return resultDetailMat;
	}
	
	
	
	private ArrayList<Material> selectOwnerMaterial(String ownerCode, SelectOwnerOption option) throws SQLException {
		ArrayList<Material> resultMaterial = new ArrayList<>();
		
		List<Long> codOwnerList = new ArrayList<>();
		codOwnerList.add(Long.valueOf(ownerCode));
		
		List<String> recordMode = new ArrayList<String>();
		recordMode.add(RecordMode.RECORD_OK);
		
		List<String> language = new ArrayList<>();
		language.add(option.language);	
		
		if (option.isMaterial) 
			resultMaterial = new MaterialModel().selectMaterial(codOwnerList, null, null, null, null, null, recordMode, language, null, null, null);
		
		
		return resultMaterial;
	}
	
	
	
	private ArrayList<Menu> selectOwnerMenu(String ownerCode, SelectOwnerOption option) throws SQLException {
		ArrayList<Menu> resultMenu = new ArrayList<>();
		
		List<Long> codOwnerList = new ArrayList<>();
		codOwnerList.add(Long.valueOf(ownerCode));
		
		List<String> recordMode = new ArrayList<String>();
		recordMode.add(RecordMode.RECORD_OK);
		
		List<String> language = new ArrayList<>();
		language.add(option.language);	
		
		if (option.isMenu) 
			resultMenu = new MenuModel().selectMenu(codOwnerList, null, recordMode, language, null);
		
		
		return resultMenu;
	}
	
	
	
	private ArrayList<Store> selectOwnerStore(String ownerCode, SelectOwnerOption option) throws SQLException {
		ArrayList<Store> resultStore = new ArrayList<>();
		
		List<Long> codOwnerList = new ArrayList<>();
		codOwnerList.add(Long.valueOf(ownerCode));
		
		List<String> recordMode = new ArrayList<String>();
		recordMode.add(RecordMode.RECORD_OK);
		
		List<String> language = new ArrayList<>();
		language.add(option.language);	
		
		if (option.isStore) 
			resultStore = new StoreModel().selectStore(codOwnerList, null, null, null, null, null, null, null, null, null, null, null, null, null, null, recordMode, language, option.isMaterial, option.isEmployee, null);
		
		
		return resultStore;
	}
	
	
	
	private ArrayList<Employee> selectOwnerEmployee(String ownerCode, SelectOwnerOption option) throws SQLException {
		ArrayList<Employee> resultEmployee = new ArrayList<>();
		
		List<Long> codOwnerList = new ArrayList<>();
		codOwnerList.add(Long.valueOf(ownerCode));
		
		List<String> recordMode = new ArrayList<String>();
		recordMode.add(RecordMode.RECORD_OK);
		
		List<String> language = new ArrayList<>();
		language.add(option.language);	
		
		if (option.isEmployee) 
			resultEmployee = new EmployeeModel().selectEmployee(codOwnerList, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, recordMode);
		
		
		return resultEmployee;
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

		return responseSuccess(jsonObject);
	}

	public Response deleteOwner(List<Long> codOwner, List<String> password, List<String> name, List<String> cpf,
			List<String> phone, List<String> email, List<String> emailAux, List<Byte> codGender, List<String> bornDate,
			List<Integer> postalcode, List<String> address1, List<String> address2, List<String> city,
			List<String> country, List<String> state, List<String> codCurr, List<String> recordMode) {

		SQLException exception = new OwnerDAO().deleteOwner(codOwner, password, name, cpf, phone, email, emailAux,
				codGender, bornDate, postalcode, address1, address2, city, country, state, codCurr, recordMode);

		JsonObject jsonObject = getJsonObjectUpdate(exception);

		return responseSuccess(jsonObject);
	}

	//TODO: Ainda utilizado. Revisar o n�mero de par�metros 
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
	
	
	
	//TODO: encapsular em um m�todo Try
	public Response changePassword(Long codOwner, String newPassword) {						// M.Maciel - 21-jan-18
		SQLException exception = new OwnerDAO().changePassword(codOwner, newPassword);		// M.Maciel - 21-jan-18
		JsonObject jsonObject = getJsonObjectUpdate(exception);								// M.Maciel - 21-jan-18
		return responseSuccess(jsonObject);														// M.Maciel - 21-jan-18
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
