package br.com.mind5.servlet.resource;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
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

import br.com.mind5.model.Model;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.CrecardModelDelete;
import br.com.mind5.payment.creditCard.model.CrecardModelInsert;
import br.com.mind5.payment.creditCard.model.CrecardModelSearch;
import br.com.mind5.payment.creditCard.model.CrecardModelSelect;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.PayordModelPay;
import br.com.mind5.payment.payOrder.model.PayordModelRefreshAuth;
import br.com.mind5.payment.refundOrder.info.RefuInfo;
import br.com.mind5.payment.refundOrder.model.RefuModelRefund;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;
import br.com.mind5.payment.refundOrderItem.model.RefemModelRefundAuth;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.PeresmoipModelCode;

@Path("/Payment")
public final class PaymentResource {
	private static final String PAY_ORDER = "/payOrder";
	private static final String REFUND_ORDER = "/refundOrder";
	private static final String REFUND_ORDER_ITEM = "/refundOrderItem";
	private static final String REFRESH_STATUS = "/refreshStatus";
	private static final String PERMISSION_CODE_MOIP = "/permissionCodeMoip";
	private static final String INSERT_CREDIT_CARD = "/insertCreditCard";
	private static final String DELETE_CREDIT_CARD = "/deleteCreditCard";
	private static final String SELECT_CREDIT_CARD = "/selectCreditCard";
	private static final String SEARCH_CREDIT_CARD = "/searchCreditCard";
	
	
	@POST
	@Path(PAY_ORDER)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response payOrder(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new PayordModelPay(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(REFUND_ORDER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response refundOrder(@HeaderParam("TOKEN_OWNER") 	@DefaultValue("-1") long codOwner,
								@HeaderParam("codOrder")  		@DefaultValue("-1") long codOrder,
								@HeaderParam("TOKEN_USERNAME") 	String username,
								@HeaderParam("codLanguage") 	@DefaultValue("EN") String codLanguage) {

		RefuInfo recordInfo = new RefuInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codOrder = codOrder;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;
		
		
		Model model = new RefuModelRefund(recordInfo);
		model.executeRequest();
		Response result =  model.getResponse();
		model.close();
		
		return result;
	}		
	
	
	
	@GET
	@Path(REFUND_ORDER_ITEM)
	@Produces(MediaType.APPLICATION_JSON)
	public Response refundOrderItem(@HeaderParam("TOKEN_OWNER") 	@DefaultValue("-1") long codOwner,
									@HeaderParam("codOrder")  		@DefaultValue("-1") long codOrder,
									@HeaderParam("codOrderItem")  	@DefaultValue("-1") int codOrderItem,
									@HeaderParam("TOKEN_USERNAME") 	String username,
									@HeaderParam("codLanguage") 	@DefaultValue("EN") String codLanguage) {

		RefemInfo recordInfo = new RefemInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codOrder = codOrder;
		recordInfo.codOrderItem = codOrderItem;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;
		
		
		Model model = new RefemModelRefundAuth(recordInfo);
		model.executeRequest();
		Response result =  model.getResponse();
		model.close();
		
		return result;
	}	
	
	
	
	@GET
	@Path(REFRESH_STATUS)
	@Produces(MediaType.APPLICATION_JSON)
	public Response refreshPayStatus(@HeaderParam("TOKEN_OWNER") 	@DefaultValue("-1") long codOwner,
								     @HeaderParam("codPayOrder")  	@DefaultValue("-1") long codPayOrder,
								     @HeaderParam("TOKEN_USERNAME") String username,
								     @HeaderParam("codLanguage") 	@DefaultValue("EN") String codLanguage) {

		PayordInfo recordInfo = new PayordInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codPayOrder = codPayOrder;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;
		
		
		Model model = new PayordModelRefreshAuth(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}		
	
	
	
	@GET
	@Path(PERMISSION_CODE_MOIP)
	@Produces(MediaType.APPLICATION_JSON)
	public Response permissionCodeMoip(@QueryParam("codOwner")    	@DefaultValue("-1") long codOwner, 
									   @QueryParam("username")  	String username,
									   @QueryParam("codStore")  	@DefaultValue("-1") long codStore,
									   @QueryParam("code") 			String code,
						               @QueryParam("codLanguage")   @DefaultValue("EN") String codLanguage) {
		
		PeresmoipInfo recordInfo = new PeresmoipInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.code = code;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;
		
		Model model = new PeresmoipModelCode(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
	
	
	
	@POST
	@Path(INSERT_CREDIT_CARD)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response crecardInsert(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new CrecardModelInsert(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@DELETE
	@Path(DELETE_CREDIT_CARD)
	@Produces(MediaType.APPLICATION_JSON)
	public Response crecardDelete(@HeaderParam("TOKEN_OWNER")    	@DefaultValue("-1") long codOwner, 
			                      @HeaderParam("codCreditCard")  	@DefaultValue("-1") long codCreditCard,
			                      @HeaderParam("TOKEN_USERNAME") 	String username,
			                      @HeaderParam("codLanguage")    	@DefaultValue("EN") String codLanguage) {
		
		CrecardInfo recordInfo = new CrecardInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codCreditCard = codCreditCard;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;
		
		
		Model model = new CrecardModelDelete(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_CREDIT_CARD)
	@Produces(MediaType.APPLICATION_JSON)
	public Response crecardSelect(@HeaderParam("TOKEN_OWNER") 		@DefaultValue("-1") long codOwner,
								  @HeaderParam("codCreditCard")  	@DefaultValue("-1") long codCreditCard,
								  @HeaderParam("TOKEN_USERNAME") 	String username,
								  @HeaderParam("codLanguage") 		@DefaultValue("EN") String codLanguage) {

		CrecardInfo recordInfo = new CrecardInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codCreditCard = codCreditCard;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;
		
		
		Model model = new CrecardModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}	
	
	
	
	@POST
	@Path(SEARCH_CREDIT_CARD)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response crecardSearch(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new CrecardModelSearch(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();
		model.close();
		
		return result;
	}
}
