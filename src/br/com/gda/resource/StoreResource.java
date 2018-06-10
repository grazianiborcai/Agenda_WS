package br.com.gda.resource;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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

import br.com.gda.business.materialEmployee.info.MatEmpInfo;
import br.com.gda.business.materialEmployee.model.MatEmpModelDelete;
import br.com.gda.business.materialEmployee.model.MatEmpModelInsert;
import br.com.gda.business.materialEmployee.model.MatEmpModelSelect;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.StoreModelDelete;
import br.com.gda.business.store.model.StoreModelInsert;
import br.com.gda.business.store.model.StoreModelSelect;
import br.com.gda.business.store.model.StoreModelUpdate;
import br.com.gda.business.storeEmployee.info.StoreEmpInfo;
import br.com.gda.business.storeEmployee.model.StoreEmpModelDelete;
import br.com.gda.business.storeEmployee.model.StoreEmpModelInsert;
import br.com.gda.business.storeEmployee.model.StoreEmpModelSelect;
import br.com.gda.business.storeEmployee.model.StoreEmpModelUpdate;
import br.com.gda.business.storeLeaveDate.info.StoreLDateInfo;
import br.com.gda.business.storeLeaveDate.model.StoreLDateModelDelete;
import br.com.gda.business.storeLeaveDate.model.StoreLDateModelInsert;
import br.com.gda.business.storeLeaveDate.model.StoreLDateModelSelect;
import br.com.gda.business.storeLeaveDate.model.StoreLDateModelUpdate;
import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.business.storeWorkTime.model.StoreWTimeModelDelete;
import br.com.gda.business.storeWorkTime.model.StoreWTimeModelInsert;
import br.com.gda.business.storeWorkTime.model.StoreWTimeModelSelect;
import br.com.gda.business.storeWorkTime.model.StoreWTimeModelUpdate;
import br.com.gda.model.Model;
import br.com.gda.model.legacy.StoreModel;

@Path("/Store")
public class StoreResource {

	private static final String INSERT_STORE = "/insertStore";
	private static final String UPDATE_STORE = "/updateStore";
	private static final String DELETE_STORE = "/deleteStore";
	private static final String SELECT_STORE = "/selectStore";
	private static final String SELECT_STORE_MAT_EMP = "/selectStoreMatEmp";
	private static final String INSERT_STORE_MAT_EMP = "/insertStoreMatEmp";
	private static final String DELETE_STORE_MAT_EMP = "/deleteStoreMatEmp";
	private static final String SELECT_STORE_EMPLOYEE = "/selectStoreEmployee";
	private static final String INSERT_STORE_EMPLOYEE = "/insertStoreEmployee";
	private static final String UPDATE_STORE_EMPLOYEE = "/updateStoreEmployee";
	private static final String DELETE_STORE_EMPLOYEE = "/deleteStoreEmployee";
	private static final String SELECT_STORE_WORK_TIME = "/selectStoreWorkTime";
	private static final String INSERT_STORE_WORK_TIME = "/insertStoreWorkTime";
	private static final String DELETE_STORE_WORK_TIME = "/deleteStoreWorkTime";
	private static final String UPDATE_STORE_WORK_TIME = "/updateStoreWorkTime";
	private static final String SELECT_STORE_LEAVE_DATE = "/selectStoreLeaveDate";
	private static final String INSERT_STORE_LEAVE_DATE = "/insertStoreLeaveDate";
	private static final String UPDATE_STORE_LEAVE_DATE = "/updateStoreLeaveDate";
	private static final String DELETE_STORE_LEAVE_DATE = "/deleteStoreLeaveDate";
	private static final String SELECT_STORE_LOCATION = "/selectStoreLoc";

	
	@POST
	@Path(INSERT_STORE)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertStore(String incomingData) {
		//TODO: verificar fluxo: Store com status inativo/eliminado
		//TODO: campos latitude e longitude não setão sendo preenchidos
		//TODO: não tem campos de horário de funcionamento
		Model modelInsert = new StoreModelInsert(incomingData);
		modelInsert.executeRequest();
		return modelInsert.getResponse();
	}
	
	

	@POST
	@Path(UPDATE_STORE)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStore(String incomingData) {
		//TODO: falta inativar/ativar um Store
		Model modelUpdate = new StoreModelUpdate(incomingData);
		modelUpdate.executeRequest();
		return modelUpdate.getResponse();
	}
	

	
	@DELETE
	@Path(DELETE_STORE)
	public Response deleteStore(@HeaderParam("codOwner") @DefaultValue("-1") long codOwner, 
			                    @HeaderParam("codStore") @DefaultValue("-1") int codStore) {
		StoreInfo recordInfo = new StoreInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		
		Model modelDelete = new StoreModelDelete(recordInfo);
		modelDelete.executeRequest();
		return modelDelete.getResponse();
	}

	
	
	@GET
	@Path(SELECT_STORE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectStore(@HeaderParam("codOwner") @DefaultValue("-1") long codOwner, 
			                    @HeaderParam("codStore") @DefaultValue("-1") int codStore) {

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
	public Response selectStoreEmp(@HeaderParam("codOwner") @DefaultValue("-1") long codOwner, 
			                       @HeaderParam("codStore") @DefaultValue("-1") int codStore) {
		StoreEmpInfo recordInfo = new StoreEmpInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		
		Model storeSelect = new StoreEmpModelSelect(recordInfo);
		storeSelect.executeRequest();
		return storeSelect.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_STORE_EMPLOYEE)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertStoreEmp(String incomingData) {
		
		Model modelInsert = new StoreEmpModelInsert(incomingData);
		modelInsert.executeRequest();
		return modelInsert.getResponse();
	}
	
	
	
	@POST
	@Path(UPDATE_STORE_EMPLOYEE)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStoreEmp(String incomingData) {
		Model storeEmpUpdate = new StoreEmpModelUpdate(incomingData);
		storeEmpUpdate.executeRequest();
		return storeEmpUpdate.getResponse();
	}
	
	
	
	@DELETE
	@Path(DELETE_STORE_EMPLOYEE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteStoreEmp(@HeaderParam("codOwner") @DefaultValue("-1") long codOwner, 
			                       @HeaderParam("codStore") @DefaultValue("-1") int codStore,
			                       @HeaderParam("codEmployee") @DefaultValue("-1") long codEmployee,
			                       @HeaderParam("codPositionStore") @DefaultValue("-1") long codPositionStore) {
		
		StoreEmpInfo recordInfo = new StoreEmpInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codEmployee = codEmployee;
		recordInfo.codPositionStore = codPositionStore;
		
		Model modelDelete = new StoreEmpModelDelete(recordInfo);
		modelDelete.executeRequest();
		return modelDelete.getResponse();
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
	
	
	
	@GET
	@Path(SELECT_STORE_MAT_EMP)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectStoreMatEmp(@HeaderParam("codOwner")    @DefaultValue("-1") long codOwner,
			                          @HeaderParam("codStore")    @DefaultValue("-1") long codStore,
			                          @HeaderParam("codEmployee") @DefaultValue("-1") long codEmployee,
								      @HeaderParam("codMaterial") @DefaultValue("-1") long codMat, 
								      @HeaderParam("codLanguage") String codLanguage) {


		MatEmpInfo recordInfo = new MatEmpInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codEmployee = codEmployee;
		recordInfo.codMat = codMat;
		recordInfo.codLanguage = codLanguage;
		
		
		Model modelSelect = new MatEmpModelSelect(recordInfo);
		modelSelect.executeRequest();
		return modelSelect.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_STORE_MAT_EMP)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertStoreMatEmp(String incomingData) {
		
		Model modelInsert = new MatEmpModelInsert(incomingData);
		modelInsert.executeRequest();
		return modelInsert.getResponse();
	}
	
	
	
	@DELETE
	@Path(DELETE_STORE_MAT_EMP)
	public Response deleteStoreMatEmp(@HeaderParam("codOwner")    @DefaultValue("-1") long codOwner,
            						  @HeaderParam("codStore")    @DefaultValue("-1") long codStore,
            						  @HeaderParam("codEmployee") @DefaultValue("-1") long codEmployee,
            						  @HeaderParam("codMaterial") @DefaultValue("-1") long codMat) {
		
		MatEmpInfo recordInfo = new MatEmpInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codEmployee = codEmployee;
		recordInfo.codMat = codMat;
		
		Model modelDelete = new MatEmpModelDelete(recordInfo);
		modelDelete.executeRequest();
		return modelDelete.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_STORE_WORK_TIME)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectStoreWTime(@HeaderParam("codOwner") @DefaultValue("-1") long codOwner, 
			                         @HeaderParam("codStore") @DefaultValue("-1") int codStore,
			                         @HeaderParam("codWeekday") @DefaultValue("-1") int codWeekday) {

		StoreWTimeInfo recordInfo = new StoreWTimeInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codWeekday = codWeekday;
		
		Model storeSelect = new StoreWTimeModelSelect(recordInfo);
		storeSelect.executeRequest();
		return storeSelect.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_STORE_WORK_TIME)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertStoreWTime(String incomingData) {
		
		Model modelInsert = new StoreWTimeModelInsert(incomingData);
		modelInsert.executeRequest();
		return modelInsert.getResponse();
	}
	
	
	
	@DELETE
	@Path(DELETE_STORE_WORK_TIME)
	public Response deleteStoreWTime(@HeaderParam("codOwner") @DefaultValue("-1") long codOwner, 
			                         @HeaderParam("codStore") @DefaultValue("-1") int codStore,
			                         @HeaderParam("codWeekday") @DefaultValue("-1") int codWeekday) {
		
		StoreWTimeInfo recordInfo = new StoreWTimeInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codWeekday = codWeekday;
		
		Model modelDelete = new StoreWTimeModelDelete(recordInfo);
		modelDelete.executeRequest();
		return modelDelete.getResponse();
	}
	
	
	
	@POST
	@Path(UPDATE_STORE_WORK_TIME)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStoreWTime(String incomingData) {

		Model modelUpdate = new StoreWTimeModelUpdate(incomingData);
		modelUpdate.executeRequest();
		return modelUpdate.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_STORE_LEAVE_DATE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectStoreLDate(@HeaderParam("codOwner") @DefaultValue("-1") long codOwner, 
			                         @HeaderParam("codStore") @DefaultValue("-1") int codStore) {

		StoreLDateInfo recordInfo = new StoreLDateInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		
		Model storeSelect = new StoreLDateModelSelect(recordInfo);
		storeSelect.executeRequest();
		return storeSelect.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_STORE_LEAVE_DATE)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertStoreLDate(String incomingData) {
		
		Model modelInsert = new StoreLDateModelInsert(incomingData);
		modelInsert.executeRequest();
		return modelInsert.getResponse();
	}
	
	
	
	@POST
	@Path(UPDATE_STORE_LEAVE_DATE)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStoreLDate(String incomingData) {

		Model modelUpdate = new StoreLDateModelUpdate(incomingData);
		modelUpdate.executeRequest();
		return modelUpdate.getResponse();
	}
	
	
	
	@DELETE
	@Path(DELETE_STORE_LEAVE_DATE)
	public Response deleteStoreLDate(@HeaderParam("codOwner") @DefaultValue("-1") long codOwner, 
			                         @HeaderParam("codStore") @DefaultValue("-1") int codStore,
			                         @HeaderParam("dateValidFrom") @DefaultValue("1900-01-01") String dateValidFrom,
			                         @HeaderParam("timeValidFrom") @DefaultValue("12:00") String timeValidFrom) {
		
		//TODO: adicionar filtros para dar um parse nas datas
		StoreLDateInfo recordInfo = new StoreLDateInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.dateValidFrom = LocalDate.parse(dateValidFrom, DateTimeFormatter.ISO_LOCAL_DATE);
		recordInfo.timeValidFrom = LocalTime.parse(timeValidFrom, DateTimeFormatter.ISO_LOCAL_TIME);
		
		Model modelDelete = new StoreLDateModelDelete(recordInfo);
		modelDelete.executeRequest();
		return modelDelete.getResponse();
	}
}
