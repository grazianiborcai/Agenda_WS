package br.com.gda.legacy.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.gda.legacy.model.CardModel;
import br.com.gda.legacy.model.JsonBuilder;

@Path("/Card")
public class CardResource extends JsonBuilder {

	private static final String INSERT_CARD = "/insertCard";
	private static final String GET_CARDS = "/getCards";
	private static final String DELETE_CARD = "/deleteCard/{last4}";

	@POST
	@Path(INSERT_CARD)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertCard(String incomingData, @HeaderParam("codCustomer") Long codCustomer) {

			return new CardModel().insertCreditCard(incomingData, codCustomer);
	}

	@GET
	@Path(GET_CARDS)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCards(@HeaderParam("codCustomer") Long codCustomer) {

		return new CardModel().selectCreditCardResponse(codCustomer);
	}

	@POST
	@Path(DELETE_CARD)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCard(@HeaderParam("codCustomer") Long codCustomer, @PathParam("last4") String last4) {

		return new CardModel().deleteCreditCard(codCustomer, last4);
	}

}
