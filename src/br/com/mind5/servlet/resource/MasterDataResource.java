package br.com.mind5.servlet.resource;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.mind5.masterData.areaPhoneSearch.info.AreanarchInfo;
import br.com.mind5.masterData.areaPhoneSearch.model.AreanarchModelSelect;
import br.com.mind5.masterData.bankAccountTypeSearch.info.BankacyperchInfo;
import br.com.mind5.masterData.bankAccountTypeSearch.model.BankacyperchModelSelect;
import br.com.mind5.masterData.bankHolderTypeSearch.info.BankoldyperchInfo;
import br.com.mind5.masterData.bankHolderTypeSearch.model.BankoldyperchModelSelect;
import br.com.mind5.masterData.bankSearch.info.BankarchInfo;
import br.com.mind5.masterData.bankSearch.model.BankarchModelSelect;
import br.com.mind5.masterData.businessAreaSearch.info.BusarearchInfo;
import br.com.mind5.masterData.businessAreaSearch.model.BusarearchModelSelect;
import br.com.mind5.masterData.cartItemCategorySearch.info.CaritegarchInfo;
import br.com.mind5.masterData.cartItemCategorySearch.model.CaritegarchModelSelect;
import br.com.mind5.masterData.countryLegal.info.CountralInfo;
import br.com.mind5.masterData.countryLegal.model.CountralModelSearch;
import br.com.mind5.masterData.countryPhoneSearch.info.CountronarchInfo;
import br.com.mind5.masterData.countryPhoneSearch.model.CountronarchModelSelect;
import br.com.mind5.masterData.countrySearch.info.CountarchInfo;
import br.com.mind5.masterData.countrySearch.model.CountarchModelSelect;
import br.com.mind5.masterData.currencySearch.info.CurrarshInfo;
import br.com.mind5.masterData.currencySearch.model.CurrarshModelSelect;
import br.com.mind5.masterData.dayParting.info.DaypartInfo;
import br.com.mind5.masterData.dayParting.model.DaypartModelSearch;
import br.com.mind5.masterData.entityCategory.info.EntitegInfo;
import br.com.mind5.masterData.entityCategory.model.EntitegModelSelect;
import br.com.mind5.masterData.feeCategorySearch.info.FeecatarchInfo;
import br.com.mind5.masterData.feeCategorySearch.model.FeecatarchModelSelect;
import br.com.mind5.masterData.fileDocTypeSearch.info.FidocarchInfo;
import br.com.mind5.masterData.fileDocTypeSearch.model.FidocarchModelSelect;
import br.com.mind5.masterData.genderSearch.info.GendarchInfo;
import br.com.mind5.masterData.genderSearch.model.GendarchModelSelect;
import br.com.mind5.masterData.languageSearch.info.LangarchInfo;
import br.com.mind5.masterData.languageSearch.model.LangarchModelSelect;
import br.com.mind5.masterData.materialCategorySearch.info.MategarchInfo;
import br.com.mind5.masterData.materialCategorySearch.model.MategarchModelSelect;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.masterData.materialGroup.model.MatoupModelSearch;
import br.com.mind5.masterData.materialGroupOwner.info.MatoupowInfo;
import br.com.mind5.masterData.materialGroupOwner.model.MatoupowModelActivate;
import br.com.mind5.masterData.materialGroupOwner.model.MatoupowModelInactivate;
import br.com.mind5.masterData.materialGroupOwner.model.MatoupowModelSearch;
import br.com.mind5.masterData.materialGroupOwner.model.MatoupowModelUpsert;
import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;
import br.com.mind5.masterData.materialSubgroup.model.MatubupModelSearch;
import br.com.mind5.masterData.materialTypeSearch.info.MatyparchInfo;
import br.com.mind5.masterData.materialTypeSearch.model.MatyparchModelSelect;
import br.com.mind5.masterData.materialUnitSearch.info.MatunitarchInfo;
import br.com.mind5.masterData.materialUnitSearch.model.MatunitarchModelSelect;
import br.com.mind5.masterData.monthSearch.info.MontharchInfo;
import br.com.mind5.masterData.monthSearch.model.MontharchModelSelect;
import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.masterData.moonPhase.model.MoonaseModelSearch;
import br.com.mind5.masterData.movimentType.info.MamovypeInfo;
import br.com.mind5.masterData.movimentType.model.MamovypeModelSelect;
import br.com.mind5.masterData.orderStatusSearch.info.OrderatarchInfo;
import br.com.mind5.masterData.orderStatusSearch.model.OrderatarchModelSelect;
import br.com.mind5.masterData.paymentStatusSearch.info.PaymenusarchInfo;
import br.com.mind5.masterData.paymentStatusSearch.model.PaymenusarchModelSelect;
import br.com.mind5.masterData.petTypeSearch.info.PetyparchInfo;
import br.com.mind5.masterData.petTypeSearch.model.PetyparchModelSelect;
import br.com.mind5.masterData.petWeightSearch.info.PeteightarchInfo;
import br.com.mind5.masterData.petWeightSearch.model.PeteightarchModelSelect;
import br.com.mind5.masterData.position.info.PositionInfo;
import br.com.mind5.masterData.position.model.PositionModelSelect;
import br.com.mind5.masterData.prospectStatusSearch.info.ProstarchInfo;
import br.com.mind5.masterData.prospectStatusSearch.model.ProstarchModelSelect;
import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;
import br.com.mind5.masterData.refundPolicyGroup.model.RefugroupModelSearch;
import br.com.mind5.masterData.scheduleStatus.info.SchedatusInfo;
import br.com.mind5.masterData.scheduleStatus.model.SchedatusModelSelect;
import br.com.mind5.masterData.stateSearch.info.StatarchInfo;
import br.com.mind5.masterData.stateSearch.model.StatarchModelSelect;
import br.com.mind5.masterData.timezoneSearch.info.TimezonarchInfo;
import br.com.mind5.masterData.timezoneSearch.model.TimezonarchModelSelect;
import br.com.mind5.masterData.userCategory.info.UseregInfo;
import br.com.mind5.masterData.userCategory.model.UseregModelSelect;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.masterData.weekday.model.WeekdayModelSearch;
import br.com.mind5.model.Model;


@Path("/MasterData")
public final class MasterDataResource {
	private static final String SELECT_POSTION = "/selectPosition";
	private static final String SELECT_MATERIAL_UNIT = "/selectMatUnit";
	private static final String SELECT_MATERIAL_TYPE = "/selectMatType";
	private static final String SELECT_MATERIAL_CATEG = "/selectMatCategory";
	private static final String SELECT_MATERIAL_GROUP = "/selectMatGroup";
	private static final String ACTIVATE_MATERIAL_GROUP_OWNER = "/activateMatGroupOwner";
	private static final String INACTIVATE_MATERIAL_GROUP_OWNER = "/inactivateMatGroupOwner";	
	private static final String SELECT_MATERIAL_GROUP_OWNER = "/selectMatGroupOwner";
	private static final String UPSERT_MATERIAL_GROUP_OWNER = "/upsertMatGroupOwner";
	private static final String SELECT_MATERIAL_SUBGROUP = "/selectMatSubgroup";	
	private static final String SELECT_BUSINESS_AREA = "/selectBusinessArea";
	private static final String SELECT_CURRENCY = "/selectCurrency";
	private static final String SELECT_LANGUAGE = "/selectLanguage";
	private static final String SELECT_WEEKDAY = "/selectWeekday";
	private static final String SELECT_DAYPART = "/selectDayparting";
	private static final String SELECT_TIMEZONE = "/selectTimezone";
	private static final String SELECT_GENDER = "/selectGender";
	private static final String SELECT_CART_ITEM_CATEG = "/selectCartItemCateg";
	private static final String SELECT_COUNTRY = "/selectCountry";
	private static final String SELECT_COUNTRY_LEGAL = "/selectCountryLegal";
	private static final String SELECT_FEE_CATEG = "/selectFeeCateg";
	private static final String SELECT_ORDER_STATUS = "/selectOrderStatus";
	private static final String SELECT_SCHEDULE_STATUS = "/selectScheduleStatus";
	private static final String SELECT_PAYMENT_STATUS = "/selectPaymentStatus";
	private static final String SELECT_COUNTRY_PHONE = "/selectCountryPhone";
	private static final String SELECT_STATE = "/selectState";
	private static final String SELECT_AREA_PHONE = "/selectAreaPhone";
	private static final String SELECT_ENTITY_CATEG = "/selectEntityCateg";
	private static final String SELECT_USER_CATEG = "/selectUserCategory";
	private static final String SELECT_MAT_MOV_TYPE = "/selectMatmovType";
	private static final String SELECT_MONTH = "/selectMonth";
	private static final String SELECT_MOON_PHASE = "/selectMoonPhase";
	private static final String SELECT_REFUND_POLICY_GROUP = "/selectRefundPolicyGroup";
	private static final String SELECT_FILE_DOC_TYPE = "/selectFileDocType";
	private static final String SELECT_PROSPECT_STATUS = "/selectProspectStatus";
	private static final String SELECT_PET_TYPE = "/selectPetType";
	private static final String SELECT_PET_WEIGHT = "/selectPetWeight";
	private static final String SELECT_BANK_ACCOUNT_TYPE = "/selectBankAccountType";
	private static final String SELECT_BANK_HOLDER_TYPE = "/selectBankHolderType";
	private static final String SELECT_BANK = "/selectBank";
	
	
	
	@GET
	@Path(SELECT_POSTION)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectPosition(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage, 
			                       @HeaderParam("codPosition") @DefaultValue("-1") int codPosition) {
		
		PositionInfo recordInfo = new PositionInfo();
		recordInfo.codLanguage = codLanguage;
		recordInfo.codPosition = codPosition;
		
		Model model = new PositionModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_MATERIAL_UNIT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectMatUnit(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage, 
			                      @HeaderParam("codUnit") String codUnit) {
		
		MatunitarchInfo recordInfo = new MatunitarchInfo();
		recordInfo.codLanguage = codLanguage;
		recordInfo.codUnit = codUnit;
		
		Model model = new MatunitarchModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_MATERIAL_TYPE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectMatType(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage, 
			                      @HeaderParam("codType")     @DefaultValue("-1") int codType) {
		
		MatyparchInfo recordInfo = new MatyparchInfo();
		recordInfo.codLanguage = codLanguage;
		recordInfo.codType = codType;
		
		Model model = new MatyparchModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_MATERIAL_CATEG)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectMatCateg(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage, 
			                      @HeaderParam("codCateg")     @DefaultValue("-1") int codCategory) {
		
		MategarchInfo recordInfo = new MategarchInfo();
		recordInfo.codLanguage = codLanguage;
		recordInfo.codMatCateg = codCategory;
		
		Model model = new MategarchModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_MATERIAL_GROUP)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectMatoup(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage, 
			                     @HeaderParam("codGroup")    @DefaultValue("-1") int codGroup,
								 @HeaderParam("codBusiness") @DefaultValue("-1") int codBusiness){
		
		MatoupInfo recordInfo = new MatoupInfo();
		recordInfo.codLanguage = codLanguage;
		recordInfo.codGroup = codGroup;
		recordInfo.codBusiness = codBusiness;
		
		Model model = new MatoupModelSearch(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(ACTIVATE_MATERIAL_GROUP_OWNER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response activateMatoupow(@HeaderParam("TOKEN_OWNER") 	@DefaultValue("-1") long codOwner,
								     @HeaderParam("codGroup") 		@DefaultValue("-1") int codGroup, 
								     @HeaderParam("TOKEN_USERNAME") String username,
								     @HeaderParam("codLanguage") 	@DefaultValue("EN") String codLanguage) {


		MatoupowInfo recordInfo = new MatoupowInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codGroup = codGroup;
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		
		
		Model model = new MatoupowModelActivate(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(INACTIVATE_MATERIAL_GROUP_OWNER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response inactivateMatoupow(@HeaderParam("TOKEN_OWNER") 	  @DefaultValue("-1") long codOwner,
								       @HeaderParam("codGroup") 	  @DefaultValue("-1") int codGroup, 
								       @HeaderParam("TOKEN_USERNAME") String username,
								       @HeaderParam("codLanguage") 	  @DefaultValue("EN") String codLanguage) {


		MatoupowInfo recordInfo = new MatoupowInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codGroup = codGroup;
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		
		
		Model model = new MatoupowModelInactivate(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_MATERIAL_GROUP_OWNER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectMatoupow(@HeaderParam("TOKEN_OWNER")    @DefaultValue("-1") long codOwner,
								   @HeaderParam("codLanguage") 	  @DefaultValue("EN") String codLanguage,
			                       @HeaderParam("codGroup")    	  @DefaultValue("-1") int codGroup,
								   @HeaderParam("codBusiness") 	  @DefaultValue("-1") int codBusiness,
								   @HeaderParam("TOKEN_USERNAME") String username){
		
		MatoupowInfo recordInfo = new MatoupowInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codLanguage = codLanguage;
		recordInfo.codGroup = codGroup;
		recordInfo.codBusiness = codBusiness;
		recordInfo.username = username;
		
		Model model = new MatoupowModelSearch(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@POST
	@Path(UPSERT_MATERIAL_GROUP_OWNER)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response upsertMatoupow(@Context HttpServletRequest request, String incomingData) {

		Model model = new MatoupowModelUpsert(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_MATERIAL_SUBGROUP)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectMatubup(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage, 
			                      @HeaderParam("codGroup")    @DefaultValue("-1") int codGroup,
								  @HeaderParam("codSubgroup") @DefaultValue("-1") int codSubgroup){
		
		MatubupInfo recordInfo = new MatubupInfo();
		recordInfo.codLanguage = codLanguage;
		recordInfo.codGroup = codGroup;
		recordInfo.codSubgroup = codSubgroup;
		
		Model model = new MatubupModelSearch(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_BUSINESS_AREA)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectBusinessArea(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                       	   @HeaderParam("codBusiness") @DefaultValue("-1") int codBusiness){
		
		BusarearchInfo recordInfo = new BusarearchInfo();
		recordInfo.codLanguage = codLanguage;
		recordInfo.codBusiness = codBusiness;
		
		Model model = new BusarearchModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_CURRENCY)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectCurrency(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                       @HeaderParam("codCurr") String codCurr){
		
		CurrarshInfo recordInfo = new CurrarshInfo();
		recordInfo.codLanguage = codLanguage;
		recordInfo.codCurr = codCurr;
		
		Model model = new CurrarshModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_LANGUAGE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectLangu(@HeaderParam("codLanguage") String codLanguage){
		
		LangarchInfo recordInfo = new LangarchInfo();
		recordInfo.codLanguage = codLanguage;
		
		Model model = new LangarchModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_WEEKDAY)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectWeekday(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                      @HeaderParam("codWeekday")  @DefaultValue("-1") int codWeekday){
		
		WeekdayInfo recordInfo = new WeekdayInfo();
		recordInfo.codWeekday = codWeekday;
		recordInfo.codLanguage = codLanguage;
		
		Model model = new WeekdayModelSearch(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_DAYPART)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectDaypart(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                      @HeaderParam("codDaypart")  @DefaultValue("-1") int codDaypart){
		
		DaypartInfo recordInfo = new DaypartInfo();
		recordInfo.codDaypart = codDaypart;
		recordInfo.codLanguage = codLanguage;
		
		Model model = new DaypartModelSearch(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_TIMEZONE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectTimezone(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                       @HeaderParam("codTimezone") String codTimezone){
		
		TimezonarchInfo recordInfo = new TimezonarchInfo();
		recordInfo.codTimezone = codTimezone;
		recordInfo.codLanguage = codLanguage;
		
		Model model = new TimezonarchModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_GENDER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectTGender(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                      @HeaderParam("codGender")   @DefaultValue("-1") int codGender){
		
		GendarchInfo recordInfo = new GendarchInfo();
		recordInfo.codGender = codGender;
		recordInfo.codLanguage = codLanguage;
		
		Model model = new GendarchModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_CART_ITEM_CATEG)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectCartItemCateg(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                            @HeaderParam("codItemCateg") String codItemCateg){
		
		CaritegarchInfo recordInfo = new CaritegarchInfo();		
		recordInfo.codLanguage = codLanguage;
		
		if (codItemCateg != null)
			recordInfo.codItemCateg = codItemCateg.charAt(0);
		
		
		Model model = new CaritegarchModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_COUNTRY)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectCountry(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                      @HeaderParam("codCountry") String codCountry){
		
		CountarchInfo recordInfo = new CountarchInfo();		
		recordInfo.codLanguage = codLanguage;
		recordInfo.codCountry = codCountry;
		
		
		Model model = new CountarchModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_COUNTRY_LEGAL)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectCountryLegal(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                           @HeaderParam("codCountry") String codCountry){
		
		CountralInfo recordInfo = new CountralInfo();		
		recordInfo.codLanguage = codLanguage;
		recordInfo.codCountry = codCountry;
		
		
		Model model = new CountralModelSearch(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_FEE_CATEG)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectFeeCateg(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                       @HeaderParam("codFeeCateg") String codFeeCateg){
		
		FeecatarchInfo recordInfo = new FeecatarchInfo();		
		recordInfo.codLanguage = codLanguage;
		
		if (codFeeCateg != null)
			recordInfo.codFeeCateg = codFeeCateg.charAt(0);
		
		
		Model model = new FeecatarchModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_ORDER_STATUS)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectOrderStatus(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                          @HeaderParam("codOrderStatus") String codOrderStatus){
		
		OrderatarchInfo recordInfo = new OrderatarchInfo();		
		recordInfo.codOrderStatus = codOrderStatus;
		recordInfo.codLanguage = codLanguage;
		
		
		Model model = new OrderatarchModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_SCHEDULE_STATUS)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectScheduleStatus(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                             @HeaderParam("codScheduleStatus") String codScheduleStatus){
		
		SchedatusInfo recordInfo = new SchedatusInfo();		
		recordInfo.codScheduleStatus = codScheduleStatus;
		recordInfo.codLanguage = codLanguage;
		
		
		Model model = new SchedatusModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_PAYMENT_STATUS)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectPaymentStatus(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                            @HeaderParam("codPaymentStatus") String codPaymentStatus){
		
		PaymenusarchInfo recordInfo = new PaymenusarchInfo();		
		recordInfo.codPaymentStatus = codPaymentStatus;
		recordInfo.codLanguage = codLanguage;
		
		
		Model model = new PaymenusarchModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_COUNTRY_PHONE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectCountryPhone(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                           @HeaderParam("codCountryPhone") @DefaultValue("-1") int codCountryPhone) {
		
		CountronarchInfo recordInfo = new CountronarchInfo();		
		recordInfo.codCountryPhone = codCountryPhone;
		recordInfo.codLanguage = codLanguage;
		
		
		Model model = new CountronarchModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_AREA_PHONE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectAreaPhone(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
								    @HeaderParam("codCountryPhone") @DefaultValue("-1") int codCountryPhone,
			                        @HeaderParam("codArea") String codArea) {
		
		AreanarchInfo recordInfo = new AreanarchInfo();		
		recordInfo.codCountryPhone = codCountryPhone;
		recordInfo.codArea = codArea;
		recordInfo.codLanguage = codLanguage;
		
		
		Model model = new AreanarchModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_STATE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectState(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                    @HeaderParam("codCountry") String codCountry,
			                    @HeaderParam("codState") String codState) {
		
		StatarchInfo recordInfo = new StatarchInfo();		
		recordInfo.codCountry = codCountry;
		recordInfo.codState = codState;
		recordInfo.codLanguage = codLanguage;
		
		
		Model model = new StatarchModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_ENTITY_CATEG)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectEntityCateg(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                          @HeaderParam("codEntityCateg") String codEntityCateg) {
		
		EntitegInfo recordInfo = new EntitegInfo();		
		recordInfo.codEntityCateg = codEntityCateg;
		recordInfo.codLanguage = codLanguage;
		
		
		Model model = new EntitegModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}	
	
	
	
	@GET
	@Path(SELECT_USER_CATEG)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectUserCateg(@HeaderParam("codLanguage")  @DefaultValue("EN") String codLanguage, 
			                        @HeaderParam("codUserCategory") String codUserCategory) {
		
		UseregInfo recordInfo = new UseregInfo();
		recordInfo.codLanguage = codLanguage;
		
		if (codUserCategory != null)
			recordInfo.codUserCategory = codUserCategory.charAt(0);
		
		
		Model model = new UseregModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_MAT_MOV_TYPE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectMatmovType(@HeaderParam("codLanguage")  @DefaultValue("EN") String codLanguage, 
			                        @HeaderParam("codMatMovType") String codMatMovType) {
		
		MamovypeInfo recordInfo = new MamovypeInfo();
		recordInfo.codLanguage = codLanguage;
		
		if (codMatMovType != null)
			recordInfo.codMatmovType = codMatMovType.charAt(0);
		
		
		Model model = new MamovypeModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_MONTH)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectMonth(@HeaderParam("codLanguage")  @DefaultValue("EN") String codLanguage, 
			                    @HeaderParam("month")        @DefaultValue("-1") int month) {
		
		MontharchInfo recordInfo = new MontharchInfo();
		recordInfo.codLanguage = codLanguage;
		recordInfo.month = month;
		
		
		Model model = new MontharchModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_MOON_PHASE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectMoonPhase(@HeaderParam("codLanguage")  @DefaultValue("EN") String codLanguage, 
			                        @HeaderParam("codMoonPhase") @DefaultValue("-1") int codMoonPhase) {
		
		MoonaseInfo recordInfo = new MoonaseInfo();
		recordInfo.codLanguage = codLanguage;
		recordInfo.codMoonPhase = codMoonPhase;
		
		
		Model model = new MoonaseModelSearch(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_REFUND_POLICY_GROUP)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectRefundPolicyGroup(@HeaderParam("codLanguage")          @DefaultValue("EN") String codLanguage, 
			                                @HeaderParam("codRefundPolicyGroup") @DefaultValue("-1") int codRefundPolicyGroup) {
		
		RefugroupInfo recordInfo = new RefugroupInfo();
		recordInfo.codLanguage = codLanguage;
		recordInfo.codRefundPolicyGroup = codRefundPolicyGroup;
		
		
		Model model = new RefugroupModelSearch(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_FILE_DOC_TYPE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectFileDocType(@HeaderParam("codLanguage")    @DefaultValue("EN") String codLanguage, 
			                          @HeaderParam("codFileDocType")                     String codFileDocType) {
		
		FidocarchInfo recordInfo = new FidocarchInfo();
		recordInfo.codLanguage = codLanguage;
		recordInfo.codFileDocType = codFileDocType;
		
		
		Model model = new FidocarchModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_PROSPECT_STATUS)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectProspectStatus(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage, 
			                             @HeaderParam("codProspectStatus") String codProspectStatus) {
		
		ProstarchInfo recordInfo = new ProstarchInfo();
		recordInfo.codLanguage = codLanguage;
		recordInfo.codProspectStatus = codProspectStatus;
		
		
		Model model = new ProstarchModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_PET_TYPE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectPetType(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage, 
			                      @HeaderParam("codPetype")   @DefaultValue("-1") int    codPetype) {
		
		PetyparchInfo recordInfo = new PetyparchInfo();
		recordInfo.codLanguage = codLanguage;
		recordInfo.codPetype = codPetype;
		
		
		Model model = new PetyparchModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_PET_WEIGHT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectPetWeight(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage, 
			                        @HeaderParam("codPeteight") @DefaultValue("-1") int    codPeteight) {
		
		PeteightarchInfo recordInfo = new PeteightarchInfo();
		recordInfo.codLanguage = codLanguage;
		recordInfo.codPeteight = codPeteight;
		
		
		Model model = new PeteightarchModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_BANK_ACCOUNT_TYPE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectBankacyperch(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage, 
			                           @HeaderParam("codBankAccount") @DefaultValue("-1") int codBankAccount) {
		
		BankacyperchInfo recordInfo = new BankacyperchInfo();
		recordInfo.codLanguage = codLanguage;
		recordInfo.codBankAccount = codBankAccount;
		
		
		Model model = new BankacyperchModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_BANK_HOLDER_TYPE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectBankoldyperch(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage, 
			                            @HeaderParam("codBankHolder") @DefaultValue("-1") int codBankHolder) {
		
		BankoldyperchInfo recordInfo = new BankoldyperchInfo();
		recordInfo.codLanguage = codLanguage;
		recordInfo.codBankHolder = codBankHolder;
		
		
		Model model = new BankoldyperchModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_BANK)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectBankarch(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage, 
			                       @HeaderParam("codBank")     @DefaultValue("-1") int codBank,
			                       @HeaderParam("codCompe")    String codCompe,
			                       @HeaderParam("codCountry")  String codCountry) {
		
		BankarchInfo recordInfo = new BankarchInfo();
		recordInfo.codLanguage = codLanguage;
		recordInfo.codBank = codBank;
		recordInfo.codCompe = codCompe;
		recordInfo.codCountry = codCountry;
		
		
		Model model = new BankarchModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
}
