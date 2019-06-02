package br.com.gda.resource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.gda.business.address.model.AddressModelInsert;
import br.com.gda.business.address.model.AddressModelUpdate;
import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.business.addressSnapshot.model.AddresnapModelInsert;
import br.com.gda.business.addressSnapshot.model.AddresnapModelSelect;
import br.com.gda.business.cartItem.model.CartemModelUpsert;
import br.com.gda.business.company.model.CompModelInsert;
import br.com.gda.business.company.model.CompModelUpdate;
import br.com.gda.business.customerSearch.model.CusarchModelSelect_;
import br.com.gda.business.materialSnapshot.info.MatsnapInfo;
import br.com.gda.business.materialSnapshot.model.MatsnapModelInsert;
import br.com.gda.business.materialSnapshot.model.MatsnapModelSelect;
import br.com.gda.business.ownerStore.info.OwntoreInfo;
import br.com.gda.business.ownerStore.model.OwntoreModelSelect;
import br.com.gda.business.person.model.PersonModelInsert;
import br.com.gda.business.person.model.PersonModelUpdate;
import br.com.gda.business.personCustomer.info.PersonCusInfo;
import br.com.gda.business.personCustomer.model.PersonCusModelSelect;
import br.com.gda.business.personSnapshot.info.PersonapInfo;
import br.com.gda.business.personSnapshot.model.PersonapModelInsert;
import br.com.gda.business.personSnapshot.model.PersonapModelSelect;
import br.com.gda.business.personUser_.info.PersonUserInfo;
import br.com.gda.business.personUser_.model.PersonUserModelSelect;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.PhoneModelInsert;
import br.com.gda.business.phone.model.PhoneModelSelect;
import br.com.gda.business.phone.model.PhoneModelUpdate;
import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.business.phoneSnapshot.model.PhonapModelInsert;
import br.com.gda.business.phoneSnapshot.model.PhonapModelSelect;
import br.com.gda.business.planingData.info.PlanataInfo;
import br.com.gda.business.planingData.model.PlanataModelSelect;
import br.com.gda.business.storeTime_.info.StorimeInfo;
import br.com.gda.business.storeTime_.model.StorimeModelSelect;
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
import br.com.gda.security.jwtToken.info.JwtokenInfo;
import br.com.gda.security.jwtToken.model.JwtokenModelValidate;
import br.com.gda.security.storeAuthorization.info.StorauthInfo;
import br.com.gda.security.storeAuthorization.model.StorauthModelSelect;
import br.com.gda.security.tokenAuthentication.info.TauthInfo;
import br.com.gda.security.tokenAuthentication.model.TauthModelToken;
import br.com.gda.security.userAuthentication.info.UauthInfo;
import br.com.gda.security.userAuthentication.model.UauthModelUpswd;
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
	private static final String INSERT_MATERIAL_SNAPSHOT = "/insertMaterialSnapshot";
	private static final String SELECT_MATERIAL_SNAPSHOT = "/selectMaterialSnapshot";
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
	private static final String SELECT_AUTH_USERNAME = "/authUsername";
	private static final String SELECT_OWNER_STORE = "/selectOwnerStore";
	private static final String JWTOKEN_VALIDATE = "/jwtokenValidate";
	private static final String TOKEN_AUTH = "/tokenAuth";
	private static final String SELECT_STORAUTH = "/authStorauth";
	private static final String SELECT_STORIME = "/authStorime";
	private static final String CUSTOMER_SEARCH = "/customerSearch";
	private static final String SELECT_PLANING_DATA = "/selectPlaningData";
	private static final String UPSERT_CARTEM = "/upsertCartem";
	
	
	
	@POST
	@Path(INSERT_ADDRESS)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertAddress(@Context HttpServletRequest request, String incomingData) {
		
		
		Model model = new AddressModelInsert(incomingData, request);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	
	@POST
	@Path(UPDATE_ADDRESS)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateAddress(@Context HttpServletRequest request, String incomingData) {
		
		
		Model model = new AddressModelUpdate(incomingData, request);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	
	@POST
	@Path(INSERT_PHONE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertPhone(@Context HttpServletRequest request, String incomingData) {
		
		
		Model model = new PhoneModelInsert(incomingData, request);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	
	@POST
	@Path(UPDATE_PHONE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePhone(@Context HttpServletRequest request, String incomingData) {
		
		
		Model model = new PhoneModelUpdate(incomingData, request);
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
	public Response insertPerson(@Context HttpServletRequest request, String incomingData) {
		
		
		Model model = new PersonModelInsert(incomingData, request);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	
	@POST
	@Path(UPDATE_PERSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePerson(@Context HttpServletRequest request, String incomingData) {
		
		
		Model model = new PersonModelUpdate(incomingData, request);
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

		AddresnapInfo recordInfo = new AddresnapInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codSnapshot = codSnapshot;
		
		Model model = new AddresnapModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_ADDRESS_SNAPSHOT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertAddressSnapshot(@Context HttpServletRequest request, String incomingData) {
		
		
		Model model = new AddresnapModelInsert(incomingData, request);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	
	@GET
	@Path(SELECT_PHONE_SNAPSHOT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectPhoneSnapshot(@HeaderParam("codOwner")    @DefaultValue("-1") long codOwner, 
								        @HeaderParam("codSnapshot") @DefaultValue("-1") long codSnapshot) {

		PhonapInfo recordInfo = new PhonapInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codSnapshot = codSnapshot;
		
		Model model = new PhonapModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_PHONE_SNAPSHOT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertPhoneSnapshot(@Context HttpServletRequest request, String incomingData) {
		
		
		Model model = new PhonapModelInsert(incomingData, request);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	
	@GET
	@Path(SELECT_PERSON_SNAPSHOT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectPersonSnapshot(@HeaderParam("codOwner")    @DefaultValue("-1") long codOwner, 
								         @HeaderParam("codSnapshot") @DefaultValue("-1") long codSnapshot) {

		PersonapInfo recordInfo = new PersonapInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codSnapshot = codSnapshot;
		
		Model model = new PersonapModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_PERSON_SNAPSHOT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertPersonSnapshot(@Context HttpServletRequest request, String incomingData) {
		
		
		Model model = new PersonapModelInsert(incomingData, request);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	
	@POST
	@Path(INSERT_MATERIAL_SNAPSHOT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertMatSnapshot(@Context HttpServletRequest request, String incomingData) {
		
		
		Model model = new MatsnapModelInsert(incomingData, request);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	
	@GET
	@Path(SELECT_MATERIAL_SNAPSHOT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectMatSnapshot(@HeaderParam("codOwner")    @DefaultValue("-1") long codOwner, 
								      @HeaderParam("codSnapshot") @DefaultValue("-1") long codSnapshot) {

		MatsnapInfo recordInfo = new MatsnapInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codSnapshot = codSnapshot;
		
		Model model = new MatsnapModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_PAY_CUSTOMER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertPayCustomer(@Context HttpServletRequest request, String incomingData) {
		
		
		Model model = new PaycusModelInsert(incomingData, request);
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
	public Response insertCompany(@Context HttpServletRequest request, String incomingData) {
		
		
		Model model = new CompModelInsert(incomingData, request);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	
	@POST
	@Path(UPDATE_COMPANY)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCompany(@Context HttpServletRequest request, String incomingData) {
		
		
		Model model = new CompModelUpdate(incomingData, request);
		model.executeRequest();
		return model.getResponse();	
	}	
	
	
	
	@POST
	@Path(INSERT_USER_PASSWORD)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertUserPassword(@Context HttpServletRequest request, String incomingData) {
		
		
		Model model = new UpswdModelInsert(incomingData, request);
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
	public Response updateUserPassword(@Context HttpServletRequest request, String incomingData) {
		
		
		Model model = new UpswdModelUpdate(incomingData, request);
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
	
	
	
	@GET
	@Path(SELECT_AUTH_USERNAME)
	@Produces(MediaType.APPLICATION_JSON)
	public Response authUsername(@HeaderParam("codOwner") long codOwner,
								 @HeaderParam("username") String username,
								 @HeaderParam("password") String password,
								 @HeaderParam("codLanguage") String codLanguage) {

		UauthInfo recordInfo = new UauthInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.username = username;
		recordInfo.password = password;
		recordInfo.codLanguage = codLanguage;
		
		Model model = new UauthModelUpswd(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_OWNER_STORE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectOwnerStore(@HeaderParam("codOwner") long codOwner,
								     @HeaderParam("codLanguage") String codLanguage) {

		OwntoreInfo recordInfo = new OwntoreInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codLanguage = codLanguage;
		
		Model model = new OwntoreModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(JWTOKEN_VALIDATE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response jwtokenValidate(@HeaderParam("tokenEncoded") String tokenEncoded) {

		JwtokenInfo recordInfo = new JwtokenInfo();
		recordInfo.tokenToVerify = tokenEncoded;
		
		Model model = new JwtokenModelValidate(recordInfo);
		model.executeRequest();	
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(TOKEN_AUTH)
	@Produces(MediaType.APPLICATION_JSON)
	public Response tokenAuth(@HeaderParam("tokenEncoded") String tokenEncoded,
			                  @HeaderParam("codLanguage")  String codLanguage) {

		TauthInfo recordInfo = new TauthInfo();
		recordInfo.tokenToVerify = tokenEncoded;
		recordInfo.codLanguage = codLanguage;
		
		Model model = new TauthModelToken(recordInfo);
		model.executeRequest();	
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_STORAUTH)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectStorauth(@HeaderParam("codOwner") long codOwner,
								   @HeaderParam("codStore") long codStore,
								   @HeaderParam("username") String username,
								   @HeaderParam("codLanguage") String codLanguage) {

		StorauthInfo recordInfo = new StorauthInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		
		Model model = new StorauthModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_STORIME)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectStorime(@HeaderParam("codOwner") long codOwner,
								  @HeaderParam("codStore") long codStore,
								  @HeaderParam("username") String username,
								  @HeaderParam("codLanguage") String codLanguage) {

		StorimeInfo recordInfo = new StorimeInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		
		Model model = new StorimeModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(CUSTOMER_SEARCH)
	@Produces(MediaType.APPLICATION_JSON)
	public Response CustomerSearch(@Context HttpServletRequest request, String incomingData) {
		
		
		Model model = new CusarchModelSelect_(incomingData, request);
		model.executeRequest();
		return model.getResponse();	
	}	
	
	
	
	@GET
	@Path(SELECT_PLANING_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectPlanata(@HeaderParam("codOwner") @DefaultValue("-1") long codOwner,
								  @HeaderParam("codStore") @DefaultValue("-1") long codStore,
								  @HeaderParam("date") @DefaultValue("1900-01-01") String date,
								  @HeaderParam("username") String username,
								  @HeaderParam("codLanguage") String codLanguage) {

		PlanataInfo recordInfo = new PlanataInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.date = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		
		Model model = new PlanataModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(UPSERT_CARTEM)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertCartem(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new CartemModelUpsert(incomingData, request);
		model.executeRequest();
		return model.getResponse();	
	}
}
