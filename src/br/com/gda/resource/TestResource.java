package br.com.gda.resource;

import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.gda.business.address.model.AddressModelInsert;
import br.com.gda.business.address.model.AddressModelUpdate;
import br.com.gda.business.addressSnapshot.info.AddressSnapInfo;
import br.com.gda.business.addressSnapshot.model.AddressSnapModelInsert;
import br.com.gda.business.addressSnapshot.model.AddressSnapModelSelect;
import br.com.gda.business.cartSnapshot.info.CartSnapInfo;
import br.com.gda.business.cartSnapshot.model.CartSnapModelInsert;
import br.com.gda.business.cartSnapshot.model.CartSnapModelSelect;
import br.com.gda.business.company.model.CompModelInsert;
import br.com.gda.business.company.model.CompModelUpdate;
import br.com.gda.business.feeStore.info.FeeStoreInfo;
import br.com.gda.business.feeStore.model.FeeStoreModelSelect;
import br.com.gda.business.feeStore.model.FeeStoreModelSelectService;
import br.com.gda.business.materialSnapshot.info.MatSnapInfo;
import br.com.gda.business.materialSnapshot.model.MatSnapModelInsert;
import br.com.gda.business.materialSnapshot.model.MatSnapModelSelect;
import br.com.gda.business.person.model.PersonModelInsert;
import br.com.gda.business.person.model.PersonModelUpdate;
import br.com.gda.business.personCustomer.info.PersonCusInfo;
import br.com.gda.business.personCustomer.model.PersonCusModelSelect;
import br.com.gda.business.personSnapshot.info.PersonSnapInfo;
import br.com.gda.business.personSnapshot.model.PersonSnapModelInsert;
import br.com.gda.business.personSnapshot.model.PersonSnapModelSelect;
import br.com.gda.business.personUser.info.PersonUserInfo;
import br.com.gda.business.personUser.model.PersonUserModelSelect;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.PhoneModelInsert;
import br.com.gda.business.phone.model.PhoneModelSelect;
import br.com.gda.business.phone.model.PhoneModelUpdate;
import br.com.gda.business.phoneSnapshot.info.PhoneSnapInfo;
import br.com.gda.business.phoneSnapshot.model.PhoneSnapModelInsert;
import br.com.gda.business.phoneSnapshot.model.PhoneSnapModelSelect;
import br.com.gda.business.userSnapshot.info.UserSnapInfo;
import br.com.gda.business.userSnapshot.model.UserSnapModelInsert;
import br.com.gda.business.userSnapshot.model.UserSnapModelSelect;
import br.com.gda.model.Model;
import br.com.gda.payService.payCustomer.info.PaycusInfo;
import br.com.gda.payService.payCustomer.model.PaycusModelDelete;
import br.com.gda.payService.payCustomer.model.PaycusModelInsert;
import br.com.gda.payService.payCustomer.model.PaycusModelSelect;
import br.com.gda.payService.payPartnerCountry.info.PayparCountryInfo;
import br.com.gda.payService.payPartnerCountry.model.PayparCountryModelSelect;
import br.com.gda.payService.payPartnerOwner.info.PayparOwnerInfo;
import br.com.gda.payService.payPartnerOwner.model.PayparOwnerModelSelect;
import br.com.gda.payService.payPartnerStore.info.PayparStoreInfo;
import br.com.gda.payService.payPartnerStore.model.PayparStoreModelSelect;
import br.com.gda.security.userPassword.info.UpswdInfo;
import br.com.gda.security.userPassword.model.UpswdModelInsert;
import br.com.gda.security.userPassword.model.UpswdModelUpdate;
import br.com.gda.security.userPassword.model.UpswdModelAuth;
import br.com.gda.security.userPassword.model.UpswdModelDelete;

@Path("/Test")
public class TestResource {

	private static final String INSERT_ADDRESS = "/insertAddress";
	private static final String UPDATE_ADDRESS = "/updateAddress";
	private static final String INSERT_PHONE = "/insertPhone";
	private static final String UPDATE_PHONE = "/updatePhone";
	private static final String SELECT_PHONE = "/selectPhone";
	private static final String INSERT_PERSON = "/insertPerson";
	private static final String UPDATE_PERSON = "/updatePerson";
	private static final String SELECT_PERSON_USER = "/selectPersonUser";
	private static final String SELECT_PERSON_CUSTOMER = "/selectPersonCustomer";
	private static final String SELECT_ADDRESS_SNAPSHOT = "/selectAddressSnapshot";
	private static final String INSERT_ADDRESS_SNAPSHOT = "/insertAddressSnapshot";
	private static final String SELECT_PHONE_SNAPSHOT = "/selectPhoneSnapshot";
	private static final String INSERT_PHONE_SNAPSHOT = "/insertPhoneSnapshot";
	private static final String SELECT_PERSON_SNAPSHOT = "/selectPersonSnapshot";
	private static final String INSERT_PERSON_SNAPSHOT = "/insertPersonSnapshot";
	private static final String INSERT_USER_SNAPSHOT = "/insertUserSnapshot";
	private static final String SELECT_USER_SNAPSHOT = "/selectUserSnapshot";
	private static final String SELECT_FEE_STORE = "/selectFeeStore";
	private static final String SELECT_FEE_STORE_SERVICE = "/selectFeeStoreService";
	private static final String INSERT_MATERIAL_SNAPSHOT = "/insertMaterialSnapshot";
	private static final String SELECT_MATERIAL_SNAPSHOT = "/selectMaterialSnapshot";
	private static final String INSERT_CART_SNAPSHOT = "/insertCartSnapshot";
	private static final String SELECT_CART_SNAPSHOT = "/selectCartSnapshot";
	private static final String INSERT_PAY_CUSTOMER = "/insertPayCustomer";
	private static final String SELECT_PAY_CUSTOMER = "/selectPayCustomer";
	private static final String DELETE_PAY_CUSTOMER = "/deletePayCustomer";
	private static final String SELECT_PAY_PARTNER_STORE = "/selectPayPartnerStore";
	private static final String SELECT_PAY_PARTNER_COUNTRY = "/selectPayPartnerCountry";
	private static final String SELECT_PAY_PARTNER_OWNER = "/selectPayPartnerOwner";
	private static final String INSERT_COMPANY = "/insertCompany";
	private static final String UPDATE_COMPANY = "/updateCompany";
	private static final String INSERT_USER_PASSWORD = "/insertUserPassword";
	private static final String AUTH_USER_PASSWORD = "/authUserPassword";
	private static final String UPDATE_USER_PASSWORD = "/updateUserPassword";
	private static final String DELETE_USER_PASSWORD = "/deleteUserPassword";
	
	
	
	@POST
	@Path(INSERT_ADDRESS)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertAddress(String incomingData) {
		
		
		Model model = new AddressModelInsert(incomingData);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	
	@POST
	@Path(UPDATE_ADDRESS)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateAddress(String incomingData) {
		
		
		Model model = new AddressModelUpdate(incomingData);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	
	@POST
	@Path(INSERT_PHONE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertPhone(String incomingData) {
		
		
		Model model = new PhoneModelInsert(incomingData);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	
	@POST
	@Path(UPDATE_PHONE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePhone(String incomingData) {
		
		
		Model model = new PhoneModelUpdate(incomingData);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	
	@GET
	@Path(SELECT_PHONE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectPhone(@HeaderParam("codOwner") @DefaultValue("-1") long codOwner, 
								@HeaderParam("codCustomer") @DefaultValue("-1") long codCustomer,
								@HeaderParam("codEmployee") @DefaultValue("-1") long codEmployee,
			                    @HeaderParam("codStore") @DefaultValue("-1") int codStore) {

		PhoneInfo recordInfo = new PhoneInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codCustomer = codCustomer;
		recordInfo.codEmployee = codEmployee;
		recordInfo.codStore = codStore;
		
		Model model = new PhoneModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_PERSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertPerson(String incomingData) {
		
		
		Model model = new PersonModelInsert(incomingData);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	
	@POST
	@Path(UPDATE_PERSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePerson(String incomingData) {
		
		
		Model model = new PersonModelUpdate(incomingData);
		model.executeRequest();
		return model.getResponse();	
	}	
	
	
	
	@GET
	@Path(SELECT_PERSON_USER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectPersonUser(@HeaderParam("codOwner") @DefaultValue("-1") long codOwner, 
								     @HeaderParam("e-mail") String email,
			                         @HeaderParam("cpff") String cpf) {

		PersonUserInfo recordInfo = new PersonUserInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.email = email;
		recordInfo.cpf = cpf;
		
		Model model = new PersonUserModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_PERSON_CUSTOMER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectPersonCsutomer(@HeaderParam("codOwner") @DefaultValue("-1") long codOwner, 
								         @HeaderParam("e-mail") String email,
			                             @HeaderParam("cpff") String cpf) {

		PersonCusInfo recordInfo = new PersonCusInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.email = email;
		recordInfo.cpf = cpf;
		
		Model model = new PersonCusModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_ADDRESS_SNAPSHOT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectAddressSnapshot(@HeaderParam("codOwner")    @DefaultValue("-1") long codOwner, 
								          @HeaderParam("codSnapshot") @DefaultValue("-1") long codSnapshot) {

		AddressSnapInfo recordInfo = new AddressSnapInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codSnapshot = codSnapshot;
		
		Model model = new AddressSnapModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_ADDRESS_SNAPSHOT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertAddressSnapshot(String incomingData) {
		
		
		Model model = new AddressSnapModelInsert(incomingData);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	
	@GET
	@Path(SELECT_PHONE_SNAPSHOT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectPhoneSnapshot(@HeaderParam("codOwner")    @DefaultValue("-1") long codOwner, 
								        @HeaderParam("codSnapshot") @DefaultValue("-1") long codSnapshot) {

		PhoneSnapInfo recordInfo = new PhoneSnapInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codSnapshot = codSnapshot;
		
		Model model = new PhoneSnapModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_PHONE_SNAPSHOT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertPhoneSnapshot(String incomingData) {
		
		
		Model model = new PhoneSnapModelInsert(incomingData);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	
	@GET
	@Path(SELECT_PERSON_SNAPSHOT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectPersonSnapshot(@HeaderParam("codOwner")    @DefaultValue("-1") long codOwner, 
								         @HeaderParam("codSnapshot") @DefaultValue("-1") long codSnapshot) {

		PersonSnapInfo recordInfo = new PersonSnapInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codSnapshot = codSnapshot;
		
		Model model = new PersonSnapModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_PERSON_SNAPSHOT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertPersonSnapshot(String incomingData) {
		
		
		Model model = new PersonSnapModelInsert(incomingData);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	
	@POST
	@Path(INSERT_USER_SNAPSHOT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertUserSnapshot(String incomingData) {
		
		
		Model model = new UserSnapModelInsert(incomingData);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	
	@GET
	@Path(SELECT_USER_SNAPSHOT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectUserSnapshot(@HeaderParam("codOwner")    @DefaultValue("-1") long codOwner, 
								       @HeaderParam("codSnapshot") @DefaultValue("-1") long codSnapshot) {

		UserSnapInfo recordInfo = new UserSnapInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codSnapshot = codSnapshot;
		
		Model model = new UserSnapModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}	
	
	
	
	@GET
	@Path(SELECT_FEE_STORE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectFeeStore(@HeaderParam("codOwner") @DefaultValue("-1") long codOwner, 
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
	@Path(SELECT_FEE_STORE_SERVICE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectFeeStoreService(@HeaderParam("codOwner") @DefaultValue("-1") long codOwner, 
								          @HeaderParam("codStore") @DefaultValue("-1") long codStore) {

		FeeStoreInfo recordInfo = new FeeStoreInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		
		Model model = new FeeStoreModelSelectService(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}	
	
	
	
	@POST
	@Path(INSERT_MATERIAL_SNAPSHOT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertMatSnapshot(String incomingData) {
		
		
		Model model = new MatSnapModelInsert(incomingData);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	
	@GET
	@Path(SELECT_MATERIAL_SNAPSHOT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectMatSnapshot(@HeaderParam("codOwner")    @DefaultValue("-1") long codOwner, 
								      @HeaderParam("codSnapshot") @DefaultValue("-1") long codSnapshot) {

		MatSnapInfo recordInfo = new MatSnapInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codSnapshot = codSnapshot;
		
		Model model = new MatSnapModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_CART_SNAPSHOT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertCartSnapshot(String incomingData) {
		
		
		Model model = new CartSnapModelInsert(incomingData);
		model.executeRequest();
		return model.getResponse();	
	} 
	
	
	
	@GET
	@Path(SELECT_CART_SNAPSHOT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectCartSnapshot(@HeaderParam("codOwner")    @DefaultValue("-1") long codOwner, 
								       @HeaderParam("codSnapshot") @DefaultValue("-1") long codSnapshot) {

		CartSnapInfo recordInfo = new CartSnapInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codSnapshot = codSnapshot;
		
		Model model = new CartSnapModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_PAY_CUSTOMER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertPayCustomer(String incomingData) {
		
		
		Model model = new PaycusModelInsert(incomingData);
		model.executeRequest();
		return model.getResponse();	
	} 
	
	
	
	@GET
	@Path(SELECT_PAY_CUSTOMER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectPayCustomer(@HeaderParam("codOwner") @DefaultValue("-1") long codOwner, 
								      @HeaderParam("codUser")  @DefaultValue("-1") long codUser) {

		PaycusInfo recordInfo = new PaycusInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codUser = codUser;
		
		Model model = new PaycusModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@DELETE
	@Path(DELETE_PAY_CUSTOMER)
	public Response deletePayCustomer(@HeaderParam("codOwner") @DefaultValue("-1") long codOwner, 
			                          @HeaderParam("codUser")  @DefaultValue("-1") long codUser) {
		PaycusInfo recordInfo = new PaycusInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codUser = codUser;
		
		Model model = new PaycusModelDelete(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_PAY_PARTNER_STORE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectPayPartnerStore(@HeaderParam("codOwner") @DefaultValue("-1") long codOwner, 
								          @HeaderParam("codStore") @DefaultValue("-1") long codStore) {

		PayparStoreInfo recordInfo = new PayparStoreInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		
		Model model = new PayparStoreModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_PAY_PARTNER_COUNTRY)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectPayPartnerCountry(@HeaderParam("codCountry") String codCountry) {

		PayparCountryInfo recordInfo = new PayparCountryInfo();
		recordInfo.codCountry = codCountry;
		
		Model model = new PayparCountryModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_PAY_PARTNER_OWNER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectPayPartnerOwner(@HeaderParam("codOwner") long codOwner) {

		PayparOwnerInfo recordInfo = new PayparOwnerInfo();
		recordInfo.codOwner = codOwner;
		
		Model model = new PayparOwnerModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_COMPANY)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertCompany(String incomingData) {
		
		
		Model model = new CompModelInsert(incomingData);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	
	@POST
	@Path(UPDATE_COMPANY)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCompany(String incomingData) {
		
		
		Model model = new CompModelUpdate(incomingData);
		model.executeRequest();
		return model.getResponse();	
	}	
	
	
	
	@POST
	@Path(INSERT_USER_PASSWORD)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertUserPassword(String incomingData) {
		
		
		Model model = new UpswdModelInsert(incomingData);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	
	@GET
	@Path(AUTH_USER_PASSWORD)
	@Produces(MediaType.APPLICATION_JSON)
	public Response authUserPassword(@HeaderParam("codOwner") long codOwner,
			                         @HeaderParam("codUser") long codUser,
			                         @HeaderParam("password") String password) {

		UpswdInfo recordInfo = new UpswdInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codUser = codUser;
		recordInfo.password = password;
		
		Model model = new UpswdModelAuth(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(UPDATE_USER_PASSWORD)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUserPassword(String incomingData) {
		
		
		Model model = new UpswdModelUpdate(incomingData);
		model.executeRequest();
		return model.getResponse();	
	}	
	
	
	
	@DELETE
	@Path(DELETE_USER_PASSWORD)
	public Response deleteUserPassword(@HeaderParam("codOwner") @DefaultValue("-1") long codOwner, 
			                           @HeaderParam("codUser")  @DefaultValue("-1") long codUser,
			                           @HeaderParam("password") String password) {
		
		UpswdInfo recordInfo = new UpswdInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codUser = codUser;
		recordInfo.password = password;
		
		Model model = new UpswdModelDelete(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
}
