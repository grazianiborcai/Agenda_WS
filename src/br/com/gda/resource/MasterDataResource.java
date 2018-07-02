package br.com.gda.resource;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.gda.business.masterData.info.MatUnitInfo;
import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.masterData.info.BusinessInfo;
import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.business.masterData.info.EmpPosInfo;
import br.com.gda.business.masterData.info.GenderInfo;
import br.com.gda.business.masterData.info.LanguInfo;
import br.com.gda.business.masterData.info.MatCategInfo;
import br.com.gda.business.masterData.info.MatGroupInfo;
import br.com.gda.business.masterData.info.MatTypeInfo;
import br.com.gda.business.masterData.model.MatUnitModelSelect;
import br.com.gda.business.masterData.model.TimezoneModelSelect;
import br.com.gda.business.masterData.model.WeekdayModelSelect;
import br.com.gda.business.masterData.model.BusinessModelSelect;
import br.com.gda.business.masterData.model.CurrencyModelSelect;
import br.com.gda.business.masterData.model.EmpPosModelSelect;
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
	
	
	@GET
	@Path(SELECT_EMPLOYEE_POSTION)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectEmpPosition(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage, 
			                          @HeaderParam("codPosition") @DefaultValue("-1") long codPosition) {
		
		EmpPosInfo recordInfo = new EmpPosInfo();
		recordInfo.codLanguage = codLanguage;
		recordInfo.codPosition = codPosition;
		
		Model modelSelect = new EmpPosModelSelect(recordInfo);
		modelSelect.executeRequest();
		return modelSelect.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_MATERIAL_UNIT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectMatUnit(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage, 
			                      @HeaderParam("codUnit") String codUnit) {
		
		MatUnitInfo recordInfo = new MatUnitInfo();
		recordInfo.codLanguage = codLanguage;
		recordInfo.codUnit = codUnit;
		
		Model modelSelect = new MatUnitModelSelect(recordInfo);
		modelSelect.executeRequest();
		return modelSelect.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_MATERIAL_TYPE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectMatType(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage, 
			                      @HeaderParam("codType")     @DefaultValue("-1") int codType) {
		
		MatTypeInfo recordInfo = new MatTypeInfo();
		recordInfo.codLanguage = codLanguage;
		recordInfo.codType = codType;
		
		Model modelSelect = new MatTypeModelSelect(recordInfo);
		modelSelect.executeRequest();
		return modelSelect.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_MATERIAL_CATEG)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectMatCateg(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage, 
			                      @HeaderParam("codCateg")     @DefaultValue("-1") int codCategory) {
		
		MatCategInfo recordInfo = new MatCategInfo();
		recordInfo.codLanguage = codLanguage;
		recordInfo.codCategory = codCategory;
		
		Model modelSelect = new MatCategModelSelect(recordInfo);
		modelSelect.executeRequest();
		return modelSelect.getResponse();
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
		
		Model modelSelect = new MatGroupModelSelect(recordInfo);
		modelSelect.executeRequest();
		return modelSelect.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_BUSINESS_AREA)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectBusinessArea(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                       	   @HeaderParam("codBusiness") @DefaultValue("-1") int codBusiness){
		
		BusinessInfo recordInfo = new BusinessInfo();
		recordInfo.codLanguage = codLanguage;
		recordInfo.codBusiness = codBusiness;
		
		Model modelSelect = new BusinessModelSelect(recordInfo);
		modelSelect.executeRequest();
		return modelSelect.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_CURRENCY)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectCurrency(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                       @HeaderParam("codCurr") String codCurr){
		
		CurrencyInfo recordInfo = new CurrencyInfo();
		recordInfo.codLanguage = codLanguage;
		recordInfo.codCurr = codCurr;
		
		Model modelSelect = new CurrencyModelSelect(recordInfo);
		modelSelect.executeRequest();
		return modelSelect.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_LANGUAGE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectLangu(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage){
		
		LanguInfo recordInfo = new LanguInfo();
		recordInfo.codLanguage = codLanguage;
		
		Model modelSelect = new LanguModelSelect(recordInfo);
		modelSelect.executeRequest();
		return modelSelect.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_WEEKDAY)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectWeekday(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                      @HeaderParam("codWeekday")  @DefaultValue("-1") int codWeekday){
		
		WeekdayInfo recordInfo = new WeekdayInfo();
		recordInfo.codWeekday = codWeekday;
		recordInfo.codLanguage = codLanguage;
		
		Model modelSelect = new WeekdayModelSelect(recordInfo);
		modelSelect.executeRequest();
		return modelSelect.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_TIMEZONE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectTimezone(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                       @HeaderParam("codTimezone") String codTimezone){
		
		TimezoneInfo recordInfo = new TimezoneInfo();
		recordInfo.codTimezone = codTimezone;
		recordInfo.codLanguage = codLanguage;
		
		Model modelSelect = new TimezoneModelSelect(recordInfo);
		modelSelect.executeRequest();
		return modelSelect.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_GENDER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectTGender(@HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage,
			                      @HeaderParam("codGender")   @DefaultValue("-1") int codGender){
		
		GenderInfo recordInfo = new GenderInfo();
		recordInfo.codGender = codGender;
		recordInfo.codLanguage = codLanguage;
		
		Model modelSelect = new GenderModelSelect(recordInfo);
		modelSelect.executeRequest();
		return modelSelect.getResponse();
	}
}
