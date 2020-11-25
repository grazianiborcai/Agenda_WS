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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.CusModelDelete;
import br.com.mind5.business.customer.model.CusModelInsertUser;
import br.com.mind5.business.customer.model.CusModelSelect;
import br.com.mind5.business.customer.model.CusModelUpdate;
import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.customerList.model.CuslisModelSelect;
import br.com.mind5.model.Model;

@Path("/Customer")
public class CustomerResource {
	private static final String INSERT_CUSTOMER = "/insertCustomer";
	private static final String UPDATE_CUSTOMER = "/updateCustomer";
	private static final String DELETE_CUSTOMER = "/deleteCustomer";
	private static final String SELECT_CUSTOMER = "/selectCustomer";
	private static final String SELECT_CUSTOMER_LIST = "/selectCustomerList";

	
	
	@POST
	@Path(INSERT_CUSTOMER)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertCustomer(@Context HttpServletRequest request, String incomingData) {		
		
		Model model = new CusModelInsertUser(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
	
	

	@POST
	@Path(UPDATE_CUSTOMER)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCustomer(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new CusModelUpdate(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}

	
	
	@DELETE
	@Path(DELETE_CUSTOMER)
	public Response deleteCustomer(@HeaderParam("TOKEN_OWNER") 		@DefaultValue("-1") long codOwner,
								   @HeaderParam("codCustomer") 		@DefaultValue("-1") long codCustomer,
								   @HeaderParam("TOKEN_USERNAME")	String username,
								   @HeaderParam("codLanguage")    	@DefaultValue("EN") String codLanguage) {

		CusInfo recordInfo = new CusInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codCustomer = codCustomer;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;
		
		Model model = new CusModelDelete(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}

	
	
	@GET
	@Path(SELECT_CUSTOMER)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectCustomer(@HeaderParam("TOKEN_OWNER")    	@DefaultValue("-1") long codOwner,
			                       @HeaderParam("codCustomer") 		@DefaultValue("-1") long codCustomer,
			                       @HeaderParam("TOKEN_USERNAME")	String username,
								   @HeaderParam("codLanguage")    	@DefaultValue("EN") String codLanguage) {

		CusInfo recordInfo = new CusInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codCustomer = codCustomer;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;
		
		Model model = new CusModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_CUSTOMER_LIST)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectCuslis(@HeaderParam("TOKEN_OWNER")    @DefaultValue("-1") long codOwner, 
			                     @HeaderParam("codCustomer")    @DefaultValue("-1") int codCustomer,
			                     @HeaderParam("codLanguage")	@DefaultValue("EN") String codLanguage,
			                     @HeaderParam("TOKEN_USERNAME") String username) {

		CuslisInfo recordInfo = new CuslisInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codCustomer = codCustomer;
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		
		Model model = new CuslisModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
}
