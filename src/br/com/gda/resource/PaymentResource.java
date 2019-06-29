package br.com.gda.resource;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.gda.model.Model;
import br.com.gda.payment.creditCard.model.CrecardModelInsert;
import br.com.gda.payment.payOrder.model.PayordModelPay;

@Path("/Payment")
public final class PaymentResource {
	private static final String PAY_ORDER = "/payOrder";
	private static final String INSERT_CREDIT_CARD = "/insertCreditCard";
	
	
	@POST
	@Path(PAY_ORDER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response payOrder(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new PayordModelPay(incomingData, request);
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
}
