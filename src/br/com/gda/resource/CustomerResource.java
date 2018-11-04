package br.com.gda.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.customer.model.CusModelDelete;
import br.com.gda.business.customer.model.CusModelInsert;
import br.com.gda.business.customer.model.CusModelSelect;
import br.com.gda.business.customer.model.CusModelUpdate;
import br.com.gda.legacy.model.CustomerModel;
import br.com.gda.model.Model;

@Path("/Customer")
public class CustomerResource {

	private static final String INSERT_CUSTOMER = "/insertCustomer";
	private static final String UPDATE_CUSTOMER = "/updateCustomer";
	private static final String DELETE_CUSTOMER = "/deleteCustomer";
	private static final String SELECT_CUSTOMER = "/selectCustomer";
	private static final String LOGIN_CUSTOMER = "/loginCustomer";
	private static final String CHANGE_PASSWORD = "/changePassword";

	
	
	@POST
	@Path(INSERT_CUSTOMER)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertCustomer(String incomingData) {		
		
		Model model = new CusModelInsert(incomingData);
		model.executeRequest();
		return model.getResponse();
	}
	
	

	@POST
	@Path(UPDATE_CUSTOMER)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCustomer(String incomingData) {
		
		Model model = new CusModelUpdate(incomingData);
		model.executeRequest();
		return model.getResponse();
	}

	
	
	@DELETE
	@Path(DELETE_CUSTOMER)
	public Response deleteCustomer(@HeaderParam("codOwner")    @DefaultValue("-1") long codOwner,
								   @HeaderParam("codCustomer") @DefaultValue("-1") long codCustomer) {

		CusInfo recordInfo = new CusInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codCustomer = codCustomer;
		
		Model model = new CusModelDelete(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}

	
	
	@GET
	@Path(SELECT_CUSTOMER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectCustomer(@HeaderParam("codOwner")    @DefaultValue("-1") long codOwner,
			                       @HeaderParam("codCustomer") @DefaultValue("-1") long codCustomer) {

		CusInfo recordInfo = new CusInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codCustomer = codCustomer;
		
		Model model = new CusModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}

	
	
	@GET
	@Path(LOGIN_CUSTOMER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response loginCustomer(@HeaderParam("email") String email, @HeaderParam("password") String password) {

		return new CustomerModel().selectCustomerResponse(email, password);
	}

	@GET
	@Path(CHANGE_PASSWORD)
	@Produces(MediaType.APPLICATION_JSON)
	public Response changePassword(@HeaderParam("codCustomer") Long codCustomer,
			@HeaderParam("newPassword") String newPassword) {

		return new CustomerModel().changePassword(codCustomer, newPassword);
	}

}
