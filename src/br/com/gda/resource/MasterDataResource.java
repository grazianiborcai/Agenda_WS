package br.com.gda.resource;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.gda.business.masterData.info.MatUnitInfo;
import br.com.gda.business.masterData.info.OrderStatusInfo;
import br.com.gda.business.masterData.info.StateInfo;
import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.masterData.info.AreaPhoneInfo;
import br.com.gda.business.masterData.info.BusinessInfo;
import br.com.gda.business.masterData.info.CartCategInfo;
import br.com.gda.business.masterData.info.CountryInfo;
import br.com.gda.business.masterData.info.CountryPhoneInfo;
import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.business.masterData.info.EmpPosInfo;
import br.com.gda.business.masterData.info.FeeCategInfo;
import br.com.gda.business.masterData.info.GenderInfo;
import br.com.gda.business.masterData.info.LanguInfo;
import br.com.gda.business.masterData.info.MatCategInfo;
import br.com.gda.business.masterData.info.MatGroupInfo;
import br.com.gda.business.masterData.info.MatTypeInfo;
import br.com.gda.business.masterData.model.MatUnitModelSelect;
import br.com.gda.business.masterData.model.OrderStatusModelSelect;
import br.com.gda.business.masterData.model.StateModelSelect;
import br.com.gda.business.masterData.model.TimezoneModelSelect;
import br.com.gda.business.masterData.model.WeekdayModelSelect;
import br.com.gda.business.masterData.model.AreaPhoneModelSelect;
import br.com.gda.business.masterData.model.BusinessModelSelect;
import br.com.gda.business.masterData.model.CartCategModelSelect;
import br.com.gda.business.masterData.model.CountryModelSelect;
import br.com.gda.business.masterData.model.CountryPhoneModelSelect;
import br.com.gda.business.masterData.model.CurrencyModelSelect;
import br.com.gda.business.masterData.model.EmpPosModelSelect;
import br.com.gda.business.masterData.model.FeeCategModelSelect;
import br.com.gda.business.masterData.model.GenderModelSelect;
import br.com.gda.business.masterData.model.LanguModelSelect;
import br.com.gda.business.masterData.model.MatCategModelSelect;
import br.com.gda.business.masterData.model.MatGroupModelSelect;
import br.com.gda.business.masterData.model.MatTypeModelSelect;
import br.com.gda.model.Model;


@Path("/MasterData")
public final class MasterDataResource {
	private static final String SELECT_EMPLOYEE_POSTION = "/selectEmpPosition";
	private static final String SELECT_MATERIAL_UNIT = "/selectMatUnit";
	private static final String SELECT_MATERIAL_TYPE = "/selectMatType";
	private static final String SELECT_MATERIAL_CATEG = "/selectMatCategory";
	private static final String SELECT_MATERIAL_GROUP = "/selectMatGroup";
	private static final String SELECT_BUSINESS_AREA = "/selectBusinessArea";
	private static final String SELECT_CURRENCY = "/selectCurrency";
	private static final String SELECT_LANGUAGE = "/selectLanguage";
	private static final String SELECT_WEEKDAY = "/selectWeekday";
	private static final String SELECT_TIMEZONE = "/selectTimezone";
	private static final String SELECT_GENDER = "/selectGender";
	private static final String SELECT_CART_ITEM_CATEG = "/selectCartItemCateg";
	private static final String SELECT_COUNTRY = "/selectCountry";
	private static final String SELECT_FEE_CATEG = "/selectFeeCateg";
	private static final String SELECT_ORDER_STATUS = "/selectOrderStatus";
	private static final String SELECT_COUNTRY_PHONE = "/selectCountryPhone";
	private static final String SELECT_STATE = "/selectState";
	private static final String SELECT_AREA_PHONE = "/selectAreaPhone";
	
	
	@GET
	@Path(SELECT_EMPLOYEE_POSTION)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectEmpPosition(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage, 
			                          @HeaderParam("codPosition") @DefaultValue("-1") long codPosition) {
		
		EmpPosInfo recordInfo = new EmpPosInfo();
		recordInfo.codLanguage = codLanguage;
		recordInfo.codPosition = codPosition;
		
		Model model = new EmpPosModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_MATERIAL_UNIT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectMatUnit(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage, 
			                      @HeaderParam("codUnit") String codUnit) {
		
		MatUnitInfo recordInfo = new MatUnitInfo();
		recordInfo.codLanguage = codLanguage;
		recordInfo.codUnit = codUnit;
		
		Model model = new MatUnitModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_MATERIAL_TYPE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectMatType(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage, 
			                      @HeaderParam("codType")     @DefaultValue("-1") int codType) {
		
		MatTypeInfo recordInfo = new MatTypeInfo();
		recordInfo.codLanguage = codLanguage;
		recordInfo.codType = codType;
		
		Model model = new MatTypeModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_MATERIAL_CATEG)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectMatCateg(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage, 
			                      @HeaderParam("codCateg")     @DefaultValue("-1") int codCategory) {
		
		MatCategInfo recordInfo = new MatCategInfo();
		recordInfo.codLanguage = codLanguage;
		recordInfo.codCategory = codCategory;
		
		Model model = new MatCategModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_MATERIAL_GROUP)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectMatGroup(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage, 
			                       @HeaderParam("codGroup")    @DefaultValue("-1") int codGroup,
								   @HeaderParam("codBusiness") @DefaultValue("-1") int codBusiness){
		
		MatGroupInfo recordInfo = new MatGroupInfo();
		recordInfo.codLanguage = codLanguage;
		recordInfo.codGroup = codGroup;
		recordInfo.codBusiness = codBusiness;
		
		Model model = new MatGroupModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_BUSINESS_AREA)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectBusinessArea(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                       	   @HeaderParam("codBusiness") @DefaultValue("-1") int codBusiness){
		
		BusinessInfo recordInfo = new BusinessInfo();
		recordInfo.codLanguage = codLanguage;
		recordInfo.codBusiness = codBusiness;
		
		Model model = new BusinessModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_CURRENCY)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectCurrency(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                       @HeaderParam("codCurr") String codCurr){
		
		CurrencyInfo recordInfo = new CurrencyInfo();
		recordInfo.codLanguage = codLanguage;
		recordInfo.codCurr = codCurr;
		
		Model model = new CurrencyModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_LANGUAGE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectLangu(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage){
		
		LanguInfo recordInfo = new LanguInfo();
		recordInfo.codLanguage = codLanguage;
		
		Model model = new LanguModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_WEEKDAY)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectWeekday(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                      @HeaderParam("codWeekday")  @DefaultValue("-1") int codWeekday){
		
		WeekdayInfo recordInfo = new WeekdayInfo();
		recordInfo.codWeekday = codWeekday;
		recordInfo.codLanguage = codLanguage;
		
		Model model = new WeekdayModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_TIMEZONE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectTimezone(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                       @HeaderParam("codTimezone") String codTimezone){
		
		TimezoneInfo recordInfo = new TimezoneInfo();
		recordInfo.codTimezone = codTimezone;
		recordInfo.codLanguage = codLanguage;
		
		Model model = new TimezoneModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_GENDER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectTGender(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                      @HeaderParam("codGender")   @DefaultValue("-1") int codGender){
		
		GenderInfo recordInfo = new GenderInfo();
		recordInfo.codGender = codGender;
		recordInfo.codLanguage = codLanguage;
		
		Model model = new GenderModelSelect(recordInfo);
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
		
		CountryInfo recordInfo = new CountryInfo();		
		recordInfo.codLanguage = codLanguage;
		recordInfo.codCountry = codCountry;
		
		
		Model model = new CountryModelSelect(recordInfo);
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
	@Path(SELECT_COUNTRY_PHONE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectCountryPhone(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                           @HeaderParam("codCountryPhone") @DefaultValue("-1") int codCountryPhone) {
		
		CountryPhoneInfo recordInfo = new CountryPhoneInfo();		
		recordInfo.codCountryPhone = codCountryPhone;
		recordInfo.codLanguage = codLanguage;
		
		
		Model model = new CountryPhoneModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_AREA_PHONE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectState(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
								@HeaderParam("codCountryPhone") @DefaultValue("-1") int codCountryPhone,
			                    @HeaderParam("codArea") String codArea) {
		
		AreaPhoneInfo recordInfo = new AreaPhoneInfo();		
		recordInfo.codCountryPhone = codCountryPhone;
		recordInfo.codArea = codArea;
		recordInfo.codLanguage = codLanguage;
		
		
		Model model = new AreaPhoneModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_STATE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectAreaPhone(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                        @HeaderParam("codCountry") String codCountry,
			                        @HeaderParam("codState") String codState) {
		
		StateInfo recordInfo = new StateInfo();		
		recordInfo.codCountry = codCountry;
		recordInfo.codState = codState;
		recordInfo.codLanguage = codLanguage;
		
		
		Model model = new StateModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
}
