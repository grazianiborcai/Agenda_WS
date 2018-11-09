package br.com.gda.resource;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.gda.business.address.model.AddressModelInsert;
import br.com.gda.business.address.model.AddressModelUpdate;
import br.com.gda.model.Model;

@Path("/Test")
public class TestResource {

	private static final String INSERT_ADDRESS = "/insertAddress";
	private static final String UPDATE_ADDRESS = "/updateAddress";
	
	
	
	@POST
	@Path(INSERT_ADDRESS)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertAddress(String incomingData) {
		
		
		Model model = new AddressModelInsert(incomingData);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	
	@POST
	@Path(UPDATE_ADDRESS)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateAddress(String incomingData) {
		
		
		Model model = new AddressModelUpdate(incomingData);
		model.executeRequest();
		return model.getResponse();	
	}
}
