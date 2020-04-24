package br.com.mind5.servlet.resource;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.mind5.business.masterData.info.CartCategInfo;
import br.com.mind5.business.masterData.info.CountryLegalInfo;
import br.com.mind5.business.masterData.info.EntityCategInfo;
import br.com.mind5.business.masterData.info.FeeCategInfo;
import br.com.mind5.business.masterData.info.MatmovTypeInfo;
import br.com.mind5.business.masterData.info.MonthInfo;
import br.com.mind5.business.masterData.info.OrderStatusInfo;
import br.com.mind5.business.masterData.info.PaymentStatusInfo;
import br.com.mind5.business.masterData.info.PositionInfo;
import br.com.mind5.business.masterData.info.ScheduleStatusInfo;
import br.com.mind5.business.masterData.info.UserCategInfo;
import br.com.mind5.business.masterData.model.CartCategModelSelect;
import br.com.mind5.business.masterData.model.CountryLegalModelSelect;
import br.com.mind5.business.masterData.model.EntityCategModelSelect;
import br.com.mind5.business.masterData.model.FeeCategModelSelect;
import br.com.mind5.business.masterData.model.MatmovTypeModelSelect;
import br.com.mind5.business.masterData.model.MonthModelSelect;
import br.com.mind5.business.masterData.model.OrderStatusModelSelect;
import br.com.mind5.business.masterData.model.PaymentStatusModelSelect;
import br.com.mind5.business.masterData.model.PositionModelSelect;
import br.com.mind5.business.masterData.model.ScheduleStatusModelSelect;
import br.com.mind5.business.masterData.model.UserCategModelSelect;
import br.com.mind5.masterData.areaPhoneSearch.info.AreanarchInfo;
import br.com.mind5.masterData.areaPhoneSearch.model.AreanarchModelSelect;
import br.com.mind5.masterData.businessAreaSearch.info.BusarearchInfo;
import br.com.mind5.masterData.businessAreaSearch.model.BusarearchModelSelect;
import br.com.mind5.masterData.countryPhoneSearch.info.CountronarchInfo;
import br.com.mind5.masterData.countryPhoneSearch.model.CountronarchModelSelect;
import br.com.mind5.masterData.countrySearch.info.CountarchInfo;
import br.com.mind5.masterData.countrySearch.model.CountarchModelSelect;
import br.com.mind5.masterData.currencySearch.info.CurrarshInfo;
import br.com.mind5.masterData.currencySearch.model.CurrarshModelSelect;
import br.com.mind5.masterData.dayPartingSearch.info.DayparchInfo;
import br.com.mind5.masterData.dayPartingSearch.model.DayparchModelSelect;
import br.com.mind5.masterData.genderSearch.info.GendarchInfo;
import br.com.mind5.masterData.genderSearch.model.GendarchModelSelect;
import br.com.mind5.masterData.languageSearch.info.LangarchInfo;
import br.com.mind5.masterData.languageSearch.model.LangarchModelSelect;
import br.com.mind5.masterData.materialCategorySearch.info.MategarchInfo;
import br.com.mind5.masterData.materialCategorySearch.model.MategarchModelSelect;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.masterData.materialGroup.model.MatGroupModelSearch;
import br.com.mind5.masterData.materialTypeSearch.info.MatyparchInfo;
import br.com.mind5.masterData.materialTypeSearch.model.MatyparchModelSelect;
import br.com.mind5.masterData.materialUnitSearch.info.MatunitarchInfo;
import br.com.mind5.masterData.materialUnitSearch.model.MatunitarchModelSelect;
import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.masterData.moonPhase.model.MoonaseModelSearch;
import br.com.mind5.masterData.stateSearch.info.StatarchInfo;
import br.com.mind5.masterData.stateSearch.model.StatarchModelSelect;
import br.com.mind5.masterData.timezoneSearch.info.TimezonarchInfo;
import br.com.mind5.masterData.timezoneSearch.model.TimezonarchModelSelect;
import br.com.mind5.masterData.weekdaySearch.info.WeekdarchInfo;
import br.com.mind5.masterData.weekdaySearch.model.WeekdarchModelSelect;
import br.com.mind5.model.Model;


@Path("/MasterData")
public final class MasterDataResource {
	private static final String SELECT_POSTION = "/selectPosition";
	private static final String SELECT_MATERIAL_UNIT = "/selectMatUnit";
	private static final String SELECT_MATERIAL_TYPE = "/selectMatType";
	private static final String SELECT_MATERIAL_CATEG = "/selectMatCategory";
	private static final String SELECT_MATERIAL_GROUP = "/selectMatGroup";
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
		return model.getResponse();
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
		return model.getResponse();
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
		return model.getResponse();
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
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_MATERIAL_GROUP)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectMatGroup(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage, 
			                       @HeaderParam("codGroup")    @DefaultValue("-1") int codGroup,
								   @HeaderParam("codBusiness") @DefaultValue("-1") int codBusiness){
		
		MatoupInfo recordInfo = new MatoupInfo();
		recordInfo.codLanguage = codLanguage;
		recordInfo.codGroup = codGroup;
		recordInfo.codBusiness = codBusiness;
		
		Model model = new MatGroupModelSearch(recordInfo);
		model.executeRequest();
		return model.getResponse();
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
		return model.getResponse();
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
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_LANGUAGE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectLangu(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage){
		
		LangarchInfo recordInfo = new LangarchInfo();
		recordInfo.codLanguage = codLanguage;
		
		Model model = new LangarchModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_WEEKDAY)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectWeekday(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                      @HeaderParam("codWeekday")  @DefaultValue("-1") int codWeekday){
		
		WeekdarchInfo recordInfo = new WeekdarchInfo();
		recordInfo.codWeekday = codWeekday;
		recordInfo.codLanguage = codLanguage;
		
		Model model = new WeekdarchModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_DAYPART)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectDaypart(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                      @HeaderParam("codDaypart")  @DefaultValue("-1") int codDaypart){
		
		DayparchInfo recordInfo = new DayparchInfo();
		recordInfo.codDaypart = codDaypart;
		recordInfo.codLanguage = codLanguage;
		
		Model model = new DayparchModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
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
		return model.getResponse();
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
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_CART_ITEM_CATEG)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectCartItemCateg(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                            @HeaderParam("codItemCateg") String codItemCateg){
		
		CartCategInfo recordInfo = new CartCategInfo();		
		recordInfo.codLanguage = codLanguage;
		
		if (codItemCateg != null)
			recordInfo.codItemCateg = codItemCateg.charAt(0);
		
		
		Model model = new CartCategModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
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
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_COUNTRY_LEGAL)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectCountryLegal(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                           @HeaderParam("codCountry") String codCountry){
		
		CountryLegalInfo recordInfo = new CountryLegalInfo();		
		recordInfo.codLanguage = codLanguage;
		recordInfo.codCountry = codCountry;
		
		
		Model model = new CountryLegalModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_FEE_CATEG)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectFeeCateg(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                       @HeaderParam("codFeeCateg") String codFeeCateg){
		
		FeeCategInfo recordInfo = new FeeCategInfo();		
		recordInfo.codLanguage = codLanguage;
		
		if (codFeeCateg != null)
			recordInfo.codFeeCateg = codFeeCateg.charAt(0);
		
		
		Model model = new FeeCategModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_ORDER_STATUS)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectOrderStatus(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                          @HeaderParam("codOrderStatus") String codOrderStatus){
		
		OrderStatusInfo recordInfo = new OrderStatusInfo();		
		recordInfo.codOrderStatus = codOrderStatus;
		recordInfo.codLanguage = codLanguage;
		
		
		Model model = new OrderStatusModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_SCHEDULE_STATUS)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectScheduleStatus(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                             @HeaderParam("codScheduleStatus") String codScheduleStatus){
		
		ScheduleStatusInfo recordInfo = new ScheduleStatusInfo();		
		recordInfo.codScheduleStatus = codScheduleStatus;
		recordInfo.codLanguage = codLanguage;
		
		
		Model model = new ScheduleStatusModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_PAYMENT_STATUS)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectPaymentStatus(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                            @HeaderParam("codPaymentStatus") String codPaymentStatus){
		
		PaymentStatusInfo recordInfo = new PaymentStatusInfo();		
		recordInfo.codPaymentStatus = codPaymentStatus;
		recordInfo.codLanguage = codLanguage;
		
		
		Model model = new PaymentStatusModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
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
		return model.getResponse();
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
		return model.getResponse();
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
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_ENTITY_CATEG)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectEntityCateg(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                          @HeaderParam("codEntityCateg") String codEntityCateg) {
		
		EntityCategInfo recordInfo = new EntityCategInfo();		
		recordInfo.codEntityCateg = codEntityCateg;
		recordInfo.codLanguage = codLanguage;
		
		
		Model model = new EntityCategModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}	
	
	
	
	@GET
	@Path(SELECT_USER_CATEG)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectUserCateg(@HeaderParam("codLanguage")  @DefaultValue("EN") String codLanguage, 
			                        @HeaderParam("codUserCategory") String codUserCategory) {
		
		UserCategInfo recordInfo = new UserCategInfo();
		recordInfo.codLanguage = codLanguage;
		
		if (codUserCategory != null)
			recordInfo.codUserCategory = codUserCategory.charAt(0);
		
		
		Model model = new UserCategModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_MAT_MOV_TYPE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectMatmovType(@HeaderParam("codLanguage")  @DefaultValue("EN") String codLanguage, 
			                        @HeaderParam("codMatMovType") String codMatMovType) {
		
		MatmovTypeInfo recordInfo = new MatmovTypeInfo();
		recordInfo.codLanguage = codLanguage;
		
		if (codMatMovType != null)
			recordInfo.codMatmovType = codMatMovType.charAt(0);
		
		
		Model model = new MatmovTypeModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_MONTH)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectMonth(@HeaderParam("codLanguage")  @DefaultValue("EN") String codLanguage, 
			                    @HeaderParam("month")        @DefaultValue("-1") int month) {
		
		MonthInfo recordInfo = new MonthInfo();
		recordInfo.codLanguage = codLanguage;
		recordInfo.month = month;
		
		
		Model model = new MonthModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
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
		return model.getResponse();
	}
}
