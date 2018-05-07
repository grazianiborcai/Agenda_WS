package br.com.gda.resource;

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

import br.com.gda.business.store.info.StoreEmpInfo;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.StoreEmpModelSelect;
import br.com.gda.business.store.model.StoreModelDelete;
import br.com.gda.business.store.model.StoreModelInsert;
import br.com.gda.business.store.model.StoreModelSelect;
import br.com.gda.business.store.model.StoreModelUpdate;
import br.com.gda.model.Model;
import br.com.gda.model.legacy.StoreModel;

@Path("/Store")
public class StoreResource {

	private static final String INSERT_STORE = "/insertStore";
	private static final String UPDATE_STORE = "/updateStore";
	private static final String DELETE_STORE = "/deleteStore";
	private static final String SELECT_STORE = "/selectStore";
	private static final String SELECT_STORE_EMPLOYEE = "/selectStoreEmployee";
	private static final String SELECT_STORE_LOCATION = "/selectStoreLoc";

	
	@POST
	@Path(INSERT_STORE)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertStore(String incomingData) {
		//TODO: verificar fluxo: Store com status inativo/eliminado
		//TODO: campos latitude e longitude não setão sendo preenchidos
		//TODO: não tem campos de horário de funcionamento
		Model storeInsert = new StoreModelInsert(incomingData);
		storeInsert.executeRequest();
		return storeInsert.getResponse();
	}
	
	

	@POST
	@Path(UPDATE_STORE)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStore(String incomingData) {
		//TODO: falta inativar/ativar um Store
		Model storeUpdate = new StoreModelUpdate(incomingData);
		storeUpdate.executeRequest();
		return storeUpdate.getResponse();
	}
	

	
	@DELETE
	@Path(DELETE_STORE)
	public Response deleteStore(@HeaderParam("codOwner") long codOwner, @HeaderParam("codStore") int codStore) {
		StoreInfo store = new StoreInfo();
		store.codOwner = codOwner;
		store.codStore = codStore;
		
		Model storeDelete = new StoreModelDelete(store);
		storeDelete.executeRequest();
		return storeDelete.getResponse();
	}

	
	
	@GET
	@Path(SELECT_STORE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectStore(@HeaderParam("codOwner") long codOwner, @HeaderParam("codStore")int codStore) {

		//TODO: precisa investigar a chamada do iOS para que o refactoring aqui não quebre a chamada iOS
		StoreInfo recordInfo = new StoreInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		
		Model storeSelect = new StoreModelSelect(recordInfo);
		storeSelect.executeRequest();
		return storeSelect.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_STORE_EMPLOYEE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectStoreEmp(@HeaderParam("codOwner") long codOwner, @HeaderParam("codStore") int codStore) {
		StoreEmpInfo recordInfo = new StoreEmpInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		
		Model storeSelect = new StoreEmpModelSelect(recordInfo);
		storeSelect.executeRequest();
		return storeSelect.getResponse();
	}

	
	
	@GET
	@Path(SELECT_STORE_LOCATION)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectStoreLoc(@DefaultValue("Z") @HeaderParam("zoneId") String zoneId,
			@HeaderParam("codOwner") List<Long> codOwner, @QueryParam("codStore") List<Integer> codStore,
			@QueryParam("cnpj") List<String> cnpj, @QueryParam("inscEstadual") List<String> inscEstadual,
			@QueryParam("inscMunicipal") List<String> inscMunicipal,
			@QueryParam("razaoSocial") List<String> razaoSocial, @QueryParam("name") List<String> name,
			@QueryParam("address1") List<String> address1, @QueryParam("address2") List<String> address2,
			@QueryParam("postalcode") List<Integer> postalcode, @QueryParam("city") List<String> city,
			@QueryParam("country") List<String> country, @QueryParam("state") List<String> state,
			@QueryParam("phone") List<String> phone, @QueryParam("codCurr") List<String> codCurr,
			@DefaultValue(" ") @QueryParam("recordMode") List<String> recordMode,
			@QueryParam("language") List<String> language,
			@DefaultValue("true") @QueryParam("withMaterial") Boolean withMaterial,
			@DefaultValue("true") @QueryParam("withEmployee") Boolean withEmployee,
			@QueryParam("latitude") String latitude, @QueryParam("longitude") String longitude) {

		Float latitudeF = Float.parseFloat(latitude);
		Float longitudeF = Float.parseFloat(longitude);

		return new StoreModel().selectStoreResponseLoc(codOwner, codStore, cnpj, inscEstadual, inscMunicipal,
				razaoSocial, name, address1, address2, postalcode, city, country, state, phone, codCurr, recordMode,
				language, withMaterial, withEmployee, zoneId, latitudeF, longitudeF);
	}

}
