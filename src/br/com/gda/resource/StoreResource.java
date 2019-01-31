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

import br.com.gda.business.feeStore.info.FeeStoreInfo;
import br.com.gda.business.feeStore.model.FeeStoreModelSelect;
import br.com.gda.business.materialEmployee.info.MatEmpInfo;
import br.com.gda.business.materialEmployee.model.MatEmpModelDelete;
import br.com.gda.business.materialEmployee.model.MatEmpModelInsert;
import br.com.gda.business.materialEmployee.model.MatEmpModelSelect;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.StoreModelDelete;
import br.com.gda.business.store.model.StoreModelInsert;
import br.com.gda.business.store.model.StoreModelSelect;
import br.com.gda.business.store.model.StoreModelUpdate;
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
import br.com.gda.business.storeWorkTimeConflict.info.StoreCoInfo;
import br.com.gda.business.storeWorkTimeConflict.model.StoreCoModelSelect;
import br.com.gda.legacy.model.StoreModel;
import br.com.gda.model.Model;

@Path("/Store")
public class StoreResource {

	private static final String INSERT_STORE = "/insertStore";
	private static final String UPDATE_STORE = "/updateStore";
	private static final String DELETE_STORE = "/deleteStore";
	private static final String SELECT_STORE = "/selectStore";
	private static final String SELECT_STORE_MAT_EMP = "/selectStoreMatEmp";
	private static final String INSERT_STORE_MAT_EMP = "/insertStoreMatEmp";
	private static final String DELETE_STORE_MAT_EMP = "/deleteStoreMatEmp";
	private static final String SELECT_STORE_FEE = "/selectStoreFee";
	private static final String SELECT_STORE_WTIME = "/selectStoreWorkTime";
	private static final String INSERT_STORE_WTIME = "/insertStoreWorkTime";
	private static final String DELETE_STORE_WTIME = "/deleteStoreWorkTime";
	private static final String UPDATE_STORE_WTIME = "/updateStoreWorkTime";
	private static final String SELECT_STORE_LDATE = "/selectStoreLeaveDate";
	private static final String INSERT_STORE_LDATE = "/insertStoreLeaveDate";
	private static final String UPDATE_STORE_LDATE = "/updateStoreLeaveDate";
	private static final String DELETE_STORE_LDATE = "/deleteStoreLeaveDate";
	private static final String SELECT_STORE_LOCATION = "/selectStoreLoc";
	private static final String SELECT_STORE_WT_CONFLICT = "/selectStoreWorkTimeConflict";

	
	@POST
	@Path(INSERT_STORE)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertStore(String incomingData) {
		//TODO: verificar fluxo: Store com status inativo/eliminado
		//TODO: campos latitude e longitude não setão sendo preenchidos
		//TODO: n�o tem campos de hor�rio de funcionamento
		Model model = new StoreModelInsert(incomingData);
		model.executeRequest();
		return model.getResponse();
	}
	
	

	@POST
	@Path(UPDATE_STORE)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStore(String incomingData) {
		//TODO: falta inativar/ativar um Store
		Model model = new StoreModelUpdate(incomingData);
		model.executeRequest();
		return model.getResponse();
	}
	

	
	@DELETE
	@Path(DELETE_STORE)
	public Response deleteStore(@HeaderParam("codOwner") @DefaultValue("-1") long codOwner, 
			                    @HeaderParam("codStore") @DefaultValue("-1") long codStore) {
		StoreInfo recordInfo = new StoreInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		
		Model model = new StoreModelDelete(recordInfo);
		model.executeRequest();
		return model.getResponse();
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
		
		Model model = new StoreModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_STORE_FEE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectStoreFee(@HeaderParam("codOwner") @DefaultValue("-1") long codOwner,
								   @HeaderParam("codStore") @DefaultValue("-1") long codStore,
								   @HeaderParam("codFeeCateg") String codFeeCateg) {
		
		FeeStoreInfo recordInfo = new FeeStoreInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		
		if (codFeeCateg != null)
			recordInfo.codFeeCateg = codFeeCateg.charAt(0);
		
		Model model = new FeeStoreModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
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
		
		Model model = new MatEmpModelInsert(incomingData);
		model.executeRequest();
		return model.getResponse();
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
		
		Model model = new MatEmpModelDelete(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_STORE_WTIME)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectStoreWTime(@HeaderParam("codOwner")   @DefaultValue("-1") long codOwner, 
			                         @HeaderParam("codStore")   @DefaultValue("-1") int codStore,
			                         @HeaderParam("codWeekday") @DefaultValue("-1") int codWeekday) {

		StoreWTimeInfo recordInfo = new StoreWTimeInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codWeekday = codWeekday;
		
		Model model = new StoreWTimeModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_STORE_WTIME)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertStoreWTime(String incomingData) {
		
		Model model = new StoreWTimeModelInsert(incomingData);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@DELETE
	@Path(DELETE_STORE_WTIME)
	public Response deleteStoreWTime(@HeaderParam("codOwner")   @DefaultValue("-1") long codOwner, 
			                         @HeaderParam("codStore")   @DefaultValue("-1") int codStore,
			                         @HeaderParam("codWeekday") @DefaultValue("-1") int codWeekday) {
		
		StoreWTimeInfo recordInfo = new StoreWTimeInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codWeekday = codWeekday;
		
		Model model = new StoreWTimeModelDelete(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(UPDATE_STORE_WTIME)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStoreWTime(String incomingData) {

		Model model = new StoreWTimeModelUpdate(incomingData);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_STORE_LDATE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectStoreLDate(@HeaderParam("codOwner") @DefaultValue("-1") long codOwner, 
			                         @HeaderParam("codStore") @DefaultValue("-1") int codStore,
			                         @HeaderParam("date")	  @DefaultValue("1900-01-01") String date) {

		StoreLDateInfo recordInfo = new StoreLDateInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		
		if (date.equals("1900-01-01") == false) {
			recordInfo.dateValidFrom = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
			recordInfo.dateValidTo = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
		}
		
		Model model = new StoreLDateModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_STORE_LDATE)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertStoreLDate(String incomingData) {
		
		Model model = new StoreLDateModelInsert(incomingData);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(UPDATE_STORE_LDATE)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStoreLDate(String incomingData) {

		Model model = new StoreLDateModelUpdate(incomingData);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@DELETE
	@Path(DELETE_STORE_LDATE)
	public Response deleteStoreLDate(@HeaderParam("codOwner")      @DefaultValue("-1") long codOwner, 
			                         @HeaderParam("codStore")      @DefaultValue("-1") int codStore,
			                         @HeaderParam("dateValidFrom") @DefaultValue("1900-01-01") String dateValidFrom,
			                         @HeaderParam("timeValidFrom") @DefaultValue("12:00") String timeValidFrom) {
		
		//TODO: adicionar filtros para dar um parse nas datas
		StoreLDateInfo recordInfo = new StoreLDateInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.dateValidFrom = LocalDate.parse(dateValidFrom, DateTimeFormatter.ISO_LOCAL_DATE);
		recordInfo.timeValidFrom = LocalTime.parse(timeValidFrom, DateTimeFormatter.ISO_LOCAL_TIME);
		
		Model model = new StoreLDateModelDelete(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_STORE_WT_CONFLICT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectStoreWTimeConflict(@HeaderParam("codOwner")   @DefaultValue("-1") long codOwner, 
			                                 @HeaderParam("codStore")   @DefaultValue("-1") int codStore,
			                                 @HeaderParam("codWeekday") @DefaultValue("-1") int codWeekday,
			                                 @HeaderParam("beginTime")  @DefaultValue("12:00") String beginTime,
			                                 @HeaderParam("endTime")    @DefaultValue("12:00") String endTime) {

		StoreCoInfo recordInfo = new StoreCoInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codWeekday = codWeekday;
		recordInfo.beginTime = LocalTime.parse(beginTime, DateTimeFormatter.ISO_LOCAL_TIME);
		recordInfo.endTime = LocalTime.parse(endTime, DateTimeFormatter.ISO_LOCAL_TIME);
		
		Model model = new StoreCoModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
}
