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
import br.com.gda.business.addressSnapshot.info.AddressSnapInfo;
import br.com.gda.business.addressSnapshot.model.AddressSnapModelInsert;
import br.com.gda.business.addressSnapshot.model.AddressSnapModelSelect;
import br.com.gda.business.person.model.PersonModelInsert;
import br.com.gda.business.person.model.PersonModelUpdate;
import br.com.gda.business.personCustomer.info.PersonCusInfo;
import br.com.gda.business.personCustomer.model.PersonCusModelSelect;
import br.com.gda.business.personSnapshot.info.PersonSnapInfo;
import br.com.gda.business.personSnapshot.model.PersonSnapModelInsert;
import br.com.gda.business.personSnapshot.model.PersonSnapModelSelect;
import br.com.gda.business.personUser.info.PersonUserInfo;
import br.com.gda.business.personUser.model.PersonUserModelSelect;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.PhoneModelInsert;
import br.com.gda.business.phone.model.PhoneModelSelect;
import br.com.gda.business.phone.model.PhoneModelUpdate;
import br.com.gda.business.phoneSnapshot.info.PhoneSnapInfo;
import br.com.gda.business.phoneSnapshot.model.PhoneSnapModelInsert;
import br.com.gda.business.phoneSnapshot.model.PhoneSnapModelSelect;
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
	private static final String SELECT_PERSON_CUSTOMER = "/selectPersonCustomer";
	private static final String SELECT_ADDRESS_SNAPSHOT = "/selectAddressSnapshot";
	private static final String INSERT_ADDRESS_SNAPSHOT = "/insertAddressSnapshot";
	private static final String SELECT_PHONE_SNAPSHOT = "/selectPhoneSnapshot";
	private static final String INSERT_PHONE_SNAPSHOT = "/insertPhoneSnapshot";
	private static final String SELECT_PERSON_SNAPSHOT = "/selectPersonSnapshot";
	private static final String INSERT_PERSON_SNAPSHOT = "/insertPersonSnapshot";
	
	
	
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
	
	
	
	@GET
	@Path(SELECT_PERSON_CUSTOMER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectPersonCsutomer(@HeaderParam("codOwner") @DefaultValue("-1") long codOwner, 
								         @HeaderParam("e-mail") String email,
			                             @HeaderParam("cpff") String cpf) {

		PersonCusInfo recordInfo = new PersonCusInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.email = email;
		recordInfo.cpf = cpf;
		
		Model model = new PersonCusModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_ADDRESS_SNAPSHOT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectAddressSnapshot(@HeaderParam("codOwner")    @DefaultValue("-1") long codOwner, 
								          @HeaderParam("codSnapshot") @DefaultValue("-1") long codSnapshot) {

		AddressSnapInfo recordInfo = new AddressSnapInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codSnapshot = codSnapshot;
		
		Model model = new AddressSnapModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_ADDRESS_SNAPSHOT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertAddressSnapshot(String incomingData) {
		
		
		Model model = new AddressSnapModelInsert(incomingData);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	
	@GET
	@Path(SELECT_PHONE_SNAPSHOT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectPhoneSnapshot(@HeaderParam("codOwner")    @DefaultValue("-1") long codOwner, 
								        @HeaderParam("codSnapshot") @DefaultValue("-1") long codSnapshot) {

		PhoneSnapInfo recordInfo = new PhoneSnapInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codSnapshot = codSnapshot;
		
		Model model = new PhoneSnapModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_PHONE_SNAPSHOT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertPhoneSnapshot(String incomingData) {
		
		
		Model model = new PhoneSnapModelInsert(incomingData);
		model.executeRequest();
		return model.getResponse();	
	}
	
	
	
	@GET
	@Path(SELECT_PERSON_SNAPSHOT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectPersonSnapshot(@HeaderParam("codOwner")    @DefaultValue("-1") long codOwner, 
								         @HeaderParam("codSnapshot") @DefaultValue("-1") long codSnapshot) {

		PersonSnapInfo recordInfo = new PersonSnapInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codSnapshot = codSnapshot;
		
		Model model = new PersonSnapModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_PERSON_SNAPSHOT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertPersonSnapshot(String incomingData) {
		
		
		Model model = new PersonSnapModelInsert(incomingData);
		model.executeRequest();
		return model.getResponse();	
	}
}
