package br.com.mind5.servlet.resource;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.mind5.model.Model;
import br.com.mind5.webhook.moipMultipayment.model.WokaymoipModelInsert;
import br.com.mind5.webhook.moipRefund.model.WokefumoipModelInsert;
import br.com.mind5.webhook.pagarmeHook.model.PagookModelInsert;

@Path("/Webhook")
public final class WebhookResource {
	private static final String INSERT_MULTIPAYMENT_MOIP = "/insertMultipaymentMoip";
	private static final String INSERT_REFUND_MOIP       = "/insertRefundMoip";
	private static final String INSERT_PAGARME           = "/insertPagarme";
	
	
	@POST
	@Path(INSERT_MULTIPAYMENT_MOIP)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response payMultiMoip(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new WokaymoipModelInsert(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
	
	
	
	@POST
	@Path(INSERT_REFUND_MOIP)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response refundMoip(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new WokefumoipModelInsert(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
	
	
	
	@POST
	@Path(INSERT_PAGARME)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertPagarme(@Context HttpServletRequest request, String incomingData) {
		
		
		Model model = new PagookModelInsert(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
}
