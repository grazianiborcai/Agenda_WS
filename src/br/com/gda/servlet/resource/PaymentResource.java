package br.com.gda.servlet.resource;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.gda.model.Model;
import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.payment.creditCard.model.CrecardModelDelete;
import br.com.gda.payment.creditCard.model.CrecardModelInsert;
import br.com.gda.payment.creditCard.model.CrecardModelSelect;
import br.com.gda.payment.partnerMoip.permissionMoip.info.PeresmoipInfo;
import br.com.gda.payment.partnerMoip.permissionMoip.model.PeresmoipModelCode;
import br.com.gda.payment.payOrder.model.PayordModelPay;
import br.com.gda.payment.refundOrder.info.RefuInfo;
import br.com.gda.payment.refundOrder.model.RefuModelRefund;
import br.com.gda.payment.statusPayOrder.info.PaytusInfo;
import br.com.gda.payment.statusPayOrder.model.PaytusModelRefresh;

@Path("/Payment")
public final class PaymentResource {
	private static final String PAY_ORDER = "/payOrder";
	private static final String REFUND_ORDER = "/refundOrder";
	private static final String REFRESH_STATUS = "/refreshStatus";
	private static final String PERMISSION_CODE_MOIP = "/permissionCodeMoip";
	private static final String INSERT_CREDIT_CARD = "/insertCreditCard";
	private static final String DELETE_CREDIT_CARD = "/deleteCreditCard";
	private static final String SELECT_CREDIT_CARD = "/selectCreditCard";
	
	
	@POST
	@Path(PAY_ORDER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response payOrder(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new PayordModelPay(incomingData, request);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	
	@GET
	@Path(REFUND_ORDER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response refundOrder(@HeaderParam("TOKEN_OWNER") 	@DefaultValue("-1") long codOwner,
								@HeaderParam("codPayOrder")  	@DefaultValue("-1") long codPayOrder,
								@HeaderParam("TOKEN_USERNAME") 	String username,
								@HeaderParam("codLanguage") 	@DefaultValue("EN") String codLanguage) {

		RefuInfo recordInfo = new RefuInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codPayOrder = codPayOrder;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;
		
		
		Model model = new RefuModelRefund(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}		
	
	
	
	@GET
	@Path(REFRESH_STATUS)
	@Produces(MediaType.APPLICATION_JSON)
	public Response refreshPayStatus(@HeaderParam("TOKEN_OWNER") 	@DefaultValue("-1") long codOwner,
								     @HeaderParam("codPayOrder")  	@DefaultValue("-1") long codPayOrder,
								     @HeaderParam("TOKEN_USERNAME") String username,
								     @HeaderParam("codLanguage") 	@DefaultValue("EN") String codLanguage) {

		PaytusInfo recordInfo = new PaytusInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codPayOrder = codPayOrder;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;
		
		
		Model model = new PaytusModelRefresh(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}		
	
	
	
	@GET
	@Path(PERMISSION_CODE_MOIP)
	@Produces(MediaType.APPLICATION_JSON)
	public Response permissionCodeMoip(@QueryParam("codOwner")    	@DefaultValue("-1") long codOwner, 
									   @QueryParam("codStore")  	@DefaultValue("-1") long codStore,
									   @QueryParam("code") 			String code,
						               @QueryParam("codLanguage")   @DefaultValue("EN") String codLanguage) {
		
		PeresmoipInfo recordInfo = new PeresmoipInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.code = code;
		recordInfo.codLanguage = codLanguage;
		
		Model model = new PeresmoipModelCode(recordInfo);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	
	@POST
	@Path(INSERT_CREDIT_CARD)
	@Produces(MediaType.APPLICATION_JSON)
	public Response crecardInsert(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new CrecardModelInsert(incomingData, request);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	
	@DELETE
	@Path(DELETE_CREDIT_CARD)
	public Response crecardDelete(@HeaderParam("TOKEN_OWNER")    	@DefaultValue("-1") long codOwner, 
			                      @HeaderParam("codPayCustomer")  	@DefaultValue("-1") long codPayCustomer,
			                      @HeaderParam("codCreditCard")  	@DefaultValue("-1") long codCreditCard,
			                      @HeaderParam("TOKEN_USERNAME") 	String username,
			                      @HeaderParam("codLanguage")    	@DefaultValue("EN") String codLanguage) {
		
		CrecardInfo recordInfo = new CrecardInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codPayCustomer = codPayCustomer;
		recordInfo.codCreditCard = codCreditCard;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;
		
		
		Model model = new CrecardModelDelete(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_CREDIT_CARD)
	@Produces(MediaType.APPLICATION_JSON)
	public Response crecardSelect(@HeaderParam("TOKEN_OWNER") 		@DefaultValue("-1") long codOwner,
								  @HeaderParam("codPayCustomer")  	@DefaultValue("-1") long codPayCustomer,
								  @HeaderParam("TOKEN_USERNAME") 	String username,
								  @HeaderParam("codLanguage") 		@DefaultValue("EN") String codLanguage) {


		CrecardInfo recordInfo = new CrecardInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codPayCustomer = codPayCustomer;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;
		
		
		Model model = new CrecardModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}	
}
