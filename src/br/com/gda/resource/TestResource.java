package br.com.gda.resource;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.gda.business.address.model.AddressModelInsert;
import br.com.gda.business.address.model.AddressModelUpdate;
import br.com.gda.business.person.model.PersonModelInsert;
import br.com.gda.business.person.model.PersonModelUpdate;
import br.com.gda.business.personUser.info.PersonUserInfo;
import br.com.gda.business.personUser.model.PersonUserModelSelect;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.PhoneModelInsert;
import br.com.gda.business.phone.model.PhoneModelSelect;
import br.com.gda.business.phone.model.PhoneModelUpdate;
import br.com.gda.model.Model;

@Path("/Test")
public class TestResource {

	private static final String INSERT_ADDRESS = "/insertAddress";
	private static final String UPDATE_ADDRESS = "/updateAddress";
	private static final String INSERT_PHONE = "/insertPhone";
	private static final String UPDATE_PHONE = "/updatePhone";
	private static final String SELECT_PHONE = "/selectPhone";
	private static final String INSERT_PERSON = "/insertPerson";
	private static final String UPDATE_PERSON = "/updatePerson";
	private static final String SELECT_PERSON_USER = "/selectPersonUser";
	
	
	
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
	
	
	
	@POST
	@Path(INSERT_PHONE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertPhone(String incomingData) {
		
		
		Model model = new PhoneModelInsert(incomingData);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	
	@POST
	@Path(UPDATE_PHONE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePhone(String incomingData) {
		
		
		Model model = new PhoneModelUpdate(incomingData);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	
	@GET
	@Path(SELECT_PHONE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectPhone(@HeaderParam("codOwner") @DefaultValue("-1") long codOwner, 
								@HeaderParam("codCustomer") @DefaultValue("-1") long codCustomer,
								@HeaderParam("codEmployee") @DefaultValue("-1") long codEmployee,
			                    @HeaderParam("codStore") @DefaultValue("-1") int codStore) {

		PhoneInfo recordInfo = new PhoneInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codCustomer = codCustomer;
		recordInfo.codEmployee = codEmployee;
		recordInfo.codStore = codStore;
		
		Model model = new PhoneModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_PERSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertPerson(String incomingData) {
		
		
		Model model = new PersonModelInsert(incomingData);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	
	@POST
	@Path(UPDATE_PERSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePerson(String incomingData) {
		
		
		Model model = new PersonModelUpdate(incomingData);
		model.executeRequest();
		return model.getResponse();	
	}	
	
	
	
	@GET
	@Path(SELECT_PERSON_USER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectPersonUser(@HeaderParam("codOwner") @DefaultValue("-1") long codOwner, 
								     @HeaderParam("e-mail") String email,
			                         @HeaderParam("cpff") String cpf) {

		PersonUserInfo recordInfo = new PersonUserInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.email = email;
		recordInfo.cpf = cpf;
		
		Model model = new PersonUserModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
}
