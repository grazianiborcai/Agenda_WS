package br.com.gda.model.legacy;

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

import br.com.gda.dao.StoreDAO;
import br.com.gda.helper.StoreEmployee;
import br.com.gda.helper.MaterialStore;
import br.com.gda.helper.RecordMode;
import br.com.gda.helper.Store;


public class StoreModel extends JsonBuilder {
	private ArrayList<Store> storeList = new ArrayList<Store>();

	public Response insertStore(String incomingData) {
		Response resultResponse = tryToInsertStore(incomingData);	
		
		int success = Response.Status.OK.getStatusCode();
		
		if (resultResponse.getStatus() == success) 
			resultResponse = selectStoreFromCnpj(incomingData);
		
		return resultResponse;
	}
	
	
	private Response tryToInsertStore(String incomingData) {
		Store emptyStore = new Store();
		
		//TODO: inserir regra de valida��o de CNPJ
		//TODO: levantar os campos obrigat�rios do Moip
		
		try {
			ArrayList<Store> stores = jsonToStoreList(incomingData);	
			StoreChecker insertChecker = StoreChecker.factory(StoreCheckerOperation.INSERT);

			if (! insertChecker.checkOperation(stores)) {
				String errorMessage = insertChecker.getFailedExplanation();
				Response.Status errorCode = insertChecker.getFailedStatus();
				return makeResponse(errorMessage, errorCode, emptyStore);
			}
			
			new StoreDAO().insertStore(stores);			
			return makeResponse(RETURNED_SUCCESSFULLY, Response.Status.OK, emptyStore);
			
			
		} catch (JsonParseException e) {
			return makeResponse(ILLEGAL_ARGUMENT, Response.Status.BAD_REQUEST, emptyStore);
		} catch (SQLException | IndexOutOfBoundsException e) {
			return makeResponse(INTERNAL_ERROR, Response.Status.INTERNAL_SERVER_ERROR, emptyStore);
		}
	}
	
	
	
	public Response selectStoreFromCodOwner(String incomingData) {
		Response resultResponse = tryToSelectStoreFromCodOwner(incomingData);
		return resultResponse;
	}
	
	
	
	private Response tryToSelectStoreFromCodOwner(String incomingData) {
		Store emptyStore = new Store();
		
		try {
			ArrayList<Store> stores = jsonToStoreList(incomingData);
			Store oneStore = stores.get(0);
			
			List<Store> resultStores = new StoreDAO().selectStoreFromCodOwner(oneStore.getCodOwner());
			return makeResponse(RETURNED_SUCCESSFULLY, Response.Status.OK, resultStores);
			
			
		} catch (JsonParseException e) {
			return makeResponse(ILLEGAL_ARGUMENT, Response.Status.BAD_REQUEST, emptyStore);
		} catch (SQLException e) {
			return makeResponse(INTERNAL_ERROR, Response.Status.INTERNAL_SERVER_ERROR, emptyStore);
		}
	}
	
	
	
	public Response selectStoreFromCodStore(String incomingData) {
		Response resultResponse = tryToSelectStoreFromCodStore(incomingData);
		return resultResponse;
	}
	
	
	
	private Response tryToSelectStoreFromCodStore(String incomingData) {
		Store emptyStore = new Store();
		
		try {
			ArrayList<Store> stores = jsonToStoreList(incomingData);
			
			long codOwner = Long.MIN_VALUE;			
			List<Integer> codStores = new ArrayList<>();
			
			for (Store eachStore : stores) {
				codOwner = eachStore.getCodOwner();
				codStores.add(eachStore.getCodStore());
			}
			
			
			List<Store> resultStores = new StoreDAO().selectStoreFromCodStore(codOwner, codStores);
			return makeResponse(RETURNED_SUCCESSFULLY, Response.Status.OK, resultStores);
			
		} catch (SQLException e) {
			return makeResponse(INTERNAL_ERROR, Response.Status.INTERNAL_SERVER_ERROR, emptyStore);
		}
	}
	
	
	
	public Response selectStoreFromCnpj(String incomingData) {
		Response resultResponse = tryToSelectStoreFromCnpj(incomingData);
		return resultResponse;
	}
	
	
	
	private Response tryToSelectStoreFromCnpj(String incomingData) {
		Store emptyStore = new Store();
		
		try {
			ArrayList<Store> stores = jsonToStoreList(incomingData);
			Store oneStore = stores.get(0);
			
			List<Store> resultStores = new StoreDAO().selectStoreFromCnpj(oneStore.getCodOwner(), oneStore.getCnpj());
			return makeResponse(RETURNED_SUCCESSFULLY, Response.Status.OK, resultStores);
			
			
		} catch (JsonParseException e) {
			return makeResponse(ILLEGAL_ARGUMENT, Response.Status.BAD_REQUEST, emptyStore);
		} catch (SQLException e) {
			return makeResponse(INTERNAL_ERROR, Response.Status.INTERNAL_SERVER_ERROR, emptyStore);
		}
	}
	
	

	public Response updateStore(String incomingData) {
		Response resultResponse = tryToUpdateStore(incomingData);		
		int success = Response.Status.OK.getStatusCode();
		
		if (resultResponse.getStatus() == success) {
			resultResponse = null;
			resultResponse = selectStoreFromCodStore(incomingData);
		}
		
		return resultResponse;
	}
	
	
	
	private Response tryToUpdateStore(String incomingData) {
		Store emptyStore = new Store();
		
		try {
			ArrayList<Store> stores = jsonToStoreList(incomingData);
			StoreChecker updateChecker = StoreChecker.factory(StoreCheckerOperation.UPDATE);
			//TODO: validar mudan�a de CNPJ
			if (! updateChecker.checkOperation(stores)) {
				String errorMessage = updateChecker.getFailedExplanation();
				Response.Status errorCode = updateChecker.getFailedStatus();
				return makeResponse(errorMessage, errorCode, emptyStore);
			}
			
			new StoreDAO().updateStore(stores);
			return makeResponse(RETURNED_SUCCESSFULLY, Response.Status.OK, stores);
			
			
		} catch (JsonParseException e) {
			return makeResponse(ILLEGAL_ARGUMENT, Response.Status.BAD_REQUEST, emptyStore);
		} catch (SQLException e) {
			return makeResponse(INTERNAL_ERROR, Response.Status.INTERNAL_SERVER_ERROR, emptyStore);
		}
	}
	
	

	public Response deleteStore(long codOwner, int codStore) {
		Response resultResponse = tryToDeleteStore(codOwner, codStore);
		return resultResponse;
	}
	
	
	
	private Response tryToDeleteStore(long codOwner, int codStore) {
		Store emptyStore = new Store();
		
		try {
			Store store = initStoreForDeletion(codOwner, codStore);		
			StoreChecker deleteChecker = StoreChecker.factory(StoreCheckerOperation.DELETE);
			
			if (! deleteChecker.checkOperation(store)) {
				String errorMessage = deleteChecker.getFailedExplanation();
				Response.Status errorCode = deleteChecker.getFailedStatus();
				return makeResponse(errorMessage, errorCode, emptyStore);
			}
		
			new StoreDAO().deleteStore(store);
			return makeResponse(RETURNED_SUCCESSFULLY, Response.Status.OK, emptyStore);
		
		} catch (SQLException e) {
			return makeResponse(INTERNAL_ERROR, Response.Status.INTERNAL_SERVER_ERROR, emptyStore);
		}
	}
	
	
	
	private Store initStoreForDeletion(long codOwner, int codStore) {
		Store store = new Store();
		store.setCodOwner(codOwner);
		store.setCodStore(codStore);
		store.setRecordMode(RecordMode.RECORD_DELETED);
		return store;
	}
	
	

	public ArrayList<Store> selectStore(List<Long> codOwner, List<Integer> codStore, List<String> cnpj,
			List<String> inscEstadual, List<String> inscMunicipal, List<String> razaoSocial, List<String> name,
			List<String> address1, List<String> address2, List<Integer> postalcode, List<String> city,
			List<String> country, List<String> state, List<String> phone, List<String> codCurr, List<String> recordMode,
			List<String> language, Boolean withMaterial, Boolean withEmployee, String zoneId) throws SQLException {

		final ArrayList<Store> storeList = new StoreDAO().selectStore(codOwner, codStore, cnpj, inscEstadual,
				inscMunicipal, razaoSocial, name, address1, address2, postalcode, city, country, state, phone, codCurr,
				recordMode);

		if (withMaterial || withEmployee) {

			codOwner = storeList.stream().map(s -> s.getCodOwner()).distinct().collect(Collectors.toList());

			for (Long eachCodOwner : codOwner) {

				List<Long> codOwnerList = new ArrayList<Long>();
				codOwnerList.add(eachCodOwner);

				List<Integer> codStoreList = storeList.stream().filter(s -> s.getCodOwner().equals(eachCodOwner))
						.map(s -> s.getCodStore()).collect(Collectors.toList());

				MaterialStoreModel materialStoreModel = new MaterialStoreModel();
				StoreEmployeeModel storeEmployeeModel = new StoreEmployeeModel();

				if (codStoreList != null && !codStoreList.isEmpty()) {

					Thread tStoreMaterial = null;
					Thread tStoreEmployee = null;

					if (withMaterial) {

						tStoreMaterial = new Thread(new Runnable() {
							public void run() {
								try {
									materialStoreModel.selectMaterialStore(codOwnerList, null, codStoreList, null, null,
											null, null, recordMode, language, null, null, null);
								} catch (SQLException e) {
									e.printStackTrace();
								}
							}
						});
						tStoreMaterial.start();
					}

					if (withEmployee) {

						tStoreEmployee = new Thread(new Runnable() {
							public void run() {
								try {
									storeEmployeeModel.selectStoreEmployee(codOwnerList, codStoreList, null, null, null,
											null, null, null, null, null, null, null, null, null, null, null, null,
											recordMode);
								} catch (SQLException e) {
									e.printStackTrace();
								}
							}
						});
						tStoreEmployee.start();
					}

					try {
						if (tStoreMaterial != null)
							tStoreMaterial.join();
						if (tStoreEmployee != null)
							tStoreEmployee.join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					final ArrayList<MaterialStore> materialStoreList = materialStoreModel.getStoreMaterialList();
					final ArrayList<StoreEmployee> storeEmployeeList = storeEmployeeModel.getStoreEmployeeList();

					storeList.stream().filter(s -> s.getCodOwner().equals(eachCodOwner)).forEach(s -> {
						s.getMaterial()
								.addAll(materialStoreList.stream()
										.filter(m -> s.getCodOwner().equals(m.getCodOwner())
												&& s.getCodStore().equals(m.getCodStore()))
										.collect(Collectors.toList()));
						s.getEmployee()
								.addAll(storeEmployeeList.stream()
										.filter(e -> s.getCodOwner().equals(e.getCodOwner())
												&& s.getCodStore().equals(e.getCodStore()))
										.collect(Collectors.toList()));
					});
				}
			}
		}

		return this.setStoreList(storeList);
	}

	public ArrayList<Store> selectStoreLoc(List<Long> codOwner, List<Integer> codStore, List<String> cnpj,
			List<String> inscEstadual, List<String> inscMunicipal, List<String> razaoSocial, List<String> name,
			List<String> address1, List<String> address2, List<Integer> postalcode, List<String> city,
			List<String> country, List<String> state, List<String> phone, List<String> codCurr, List<String> recordMode,
			List<String> language, Boolean withMaterial, Boolean withEmployee, String zoneId, Float latitude,
			Float longitude) throws SQLException {

		final ArrayList<Store> storeList = new StoreDAO().selectStoreLoc(codOwner, codStore, cnpj, inscEstadual,
				inscMunicipal, razaoSocial, name, address1, address2, postalcode, city, country, state, phone, codCurr,
				recordMode, latitude, longitude);

		if (withMaterial || withEmployee) {

			codOwner = storeList.stream().map(s -> s.getCodOwner()).distinct().collect(Collectors.toList());

			for (Long eachCodOwner : codOwner) {

				List<Long> codOwnerList = new ArrayList<Long>();
				codOwnerList.add(eachCodOwner);

				List<Integer> codStoreList = storeList.stream().filter(s -> s.getCodOwner().equals(eachCodOwner))
						.map(s -> s.getCodStore()).collect(Collectors.toList());

				MaterialStoreModel materialStoreModel = new MaterialStoreModel();
				StoreEmployeeModel storeEmployeeModel = new StoreEmployeeModel();

				if (codStoreList != null && !codStoreList.isEmpty()) {

					Thread tStoreMaterial = null;
					Thread tStoreEmployee = null;

					if (withMaterial) {

						tStoreMaterial = new Thread(new Runnable() {
							public void run() {
								try {
									materialStoreModel.selectMaterialStore(codOwnerList, null, codStoreList, null, null,
											null, null, recordMode, language, null, null, null);
								} catch (SQLException e) {
									e.printStackTrace();
								}
							}
						});
						tStoreMaterial.start();
					}

					if (withEmployee) {

						tStoreEmployee = new Thread(new Runnable() {
							public void run() {
								try {
									storeEmployeeModel.selectStoreEmployee(codOwnerList, codStoreList, null, null, null,
											null, null, null, null, null, null, null, null, null, null, null, null,
											recordMode);
								} catch (SQLException e) {
									e.printStackTrace();
								}
							}
						});
						tStoreEmployee.start();
					}

					try {
						if (tStoreMaterial != null)
							tStoreMaterial.join();
						if (tStoreEmployee != null)
							tStoreEmployee.join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					final ArrayList<MaterialStore> materialStoreList = materialStoreModel.getStoreMaterialList();
					final ArrayList<StoreEmployee> storeEmployeeList = storeEmployeeModel.getStoreEmployeeList();

					storeList.stream().filter(s -> s.getCodOwner().equals(eachCodOwner)).forEach(s -> {
						s.getMaterial()
								.addAll(materialStoreList.stream()
										.filter(m -> s.getCodOwner().equals(m.getCodOwner())
												&& s.getCodStore().equals(m.getCodStore()))
										.collect(Collectors.toList()));
						s.getEmployee()
								.addAll(storeEmployeeList.stream()
										.filter(e -> s.getCodOwner().equals(e.getCodOwner())
												&& s.getCodStore().equals(e.getCodStore()))
										.collect(Collectors.toList()));
					});
				}
			}
		}

		return this.setStoreList(storeList);
	}

	public JsonObject selectStoreJson(List<Long> codOwner, List<Integer> codStore, List<String> cnpj,
			List<String> inscEstadual, List<String> inscMunicipal, List<String> razaoSocial, List<String> name,
			List<String> address1, List<String> address2, List<Integer> postalcode, List<String> city,
			List<String> country, List<String> state, List<String> phone, List<String> codCurr, List<String> recordMode,
			List<String> language, Boolean withMaterial, Boolean withEmployee, String zoneId) {

		JsonElement jsonElement = new JsonArray().getAsJsonArray();
		SQLException exception = new SQLException(RETURNED_SUCCESSFULLY, null, 200);

		try {

			jsonElement = new Gson().toJsonTree(selectStore(codOwner, codStore, cnpj, inscEstadual, inscMunicipal,
					razaoSocial, name, address1, address2, postalcode, city, country, state, phone, codCurr, recordMode,
					language, withMaterial, withEmployee, zoneId));

		} catch (SQLException e) {
			exception = e;
		}

		JsonObject jsonObject = getJsonObjectSelect(jsonElement, exception);

		return jsonObject;
	}
	
	public JsonObject selectStoreJsonLoc(List<Long> codOwner, List<Integer> codStore, List<String> cnpj,
			List<String> inscEstadual, List<String> inscMunicipal, List<String> razaoSocial, List<String> name,
			List<String> address1, List<String> address2, List<Integer> postalcode, List<String> city,
			List<String> country, List<String> state, List<String> phone, List<String> codCurr, List<String> recordMode,
			List<String> language, Boolean withMaterial, Boolean withEmployee, String zoneId, Float latitude,
			Float longitude) {

		JsonElement jsonElement = new JsonArray().getAsJsonArray();
		SQLException exception = new SQLException(RETURNED_SUCCESSFULLY, null, 200);

		try {

			jsonElement = new Gson().toJsonTree(selectStoreLoc(codOwner, codStore, cnpj, inscEstadual, inscMunicipal,
					razaoSocial, name, address1, address2, postalcode, city, country, state, phone, codCurr, recordMode,
					language, withMaterial, withEmployee, zoneId, latitude, longitude));

		} catch (SQLException e) {
			exception = e;
		}

		JsonObject jsonObject = getJsonObjectSelect(jsonElement, exception);

		return jsonObject;
	}

	public Response selectStoreResponse(List<Long> codOwner, List<Integer> codStore, List<String> cnpj,
			List<String> inscEstadual, List<String> inscMunicipal, List<String> razaoSocial, List<String> name,
			List<String> address1, List<String> address2, List<Integer> postalcode, List<String> city,
			List<String> country, List<String> state, List<String> phone, List<String> codCurr, List<String> recordMode,
			List<String> language, Boolean withMaterial, Boolean withEmployee, String zoneId) {

		return responseSuccess(selectStoreJson(codOwner, codStore, cnpj, inscEstadual, inscMunicipal, razaoSocial, name,
				address1, address2, postalcode, city, country, state, phone, codCurr, recordMode, language,
				withMaterial, withEmployee, zoneId));
	}
	
	public Response selectStoreResponseLoc(List<Long> codOwner, List<Integer> codStore, List<String> cnpj,
			List<String> inscEstadual, List<String> inscMunicipal, List<String> razaoSocial, List<String> name,
			List<String> address1, List<String> address2, List<Integer> postalcode, List<String> city,
			List<String> country, List<String> state, List<String> phone, List<String> codCurr, List<String> recordMode,
			List<String> language, Boolean withMaterial, Boolean withEmployee, String zoneId, Float latitude,
			Float longitude) {

		return responseSuccess(selectStoreJsonLoc(codOwner, codStore, cnpj, inscEstadual, inscMunicipal, razaoSocial, name,
				address1, address2, postalcode, city, country, state, phone, codCurr, recordMode, language,
				withMaterial, withEmployee, zoneId, latitude, longitude));
	}

	public ArrayList<Store> jsonToStoreList(String incomingData) {

		ArrayList<Store> storeList = new ArrayList<Store>();
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();

		if (parser.parse(incomingData).isJsonArray()) {
			JsonArray array = parser.parse(incomingData).getAsJsonArray();

			for (int i = 0; i < array.size(); i++) {
				storeList.add(gson.fromJson(array.get(i), Store.class));
			}
		} else {
			JsonObject object = parser.parse(incomingData).getAsJsonObject();
			storeList.add(gson.fromJson(object, Store.class));
		}

		return storeList;
	}

	public ArrayList<Store> getStoreList() {
		return storeList;
	}

	public ArrayList<Store> setStoreList(ArrayList<Store> storeList) {
		this.storeList = storeList;
		return storeList;
	}
}
