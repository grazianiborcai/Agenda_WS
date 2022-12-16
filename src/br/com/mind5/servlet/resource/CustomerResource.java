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
import br.com.mind5.business.customer.model.CusModelUserInsert;
import br.com.mind5.business.customer.model.CusModelSelect;
import br.com.mind5.business.customer.model.CusModelUpdate;
import br.com.mind5.business.customerList.model.CuslisModelSearchAuth;
import br.com.mind5.model.Model;

@Path("/Customer")
public class CustomerResource {
	private static final String INSERT_CUSTOMER = "/insertCustomer";
	private static final String UPDATE_CUSTOMER = "/updateCustomer";
	private static final String DELETE_CUSTOMER = "/deleteCustomer";
	private static final String SELECT_CUSTOMER = "/selectCustomer";
	private static final String SEARCH_CUSTOMER = "/searchCustomer";

	
	
	@POST
	@Path(INSERT_CUSTOMER)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertCustomer(@Context HttpServletRequest request, String incomingData) {		
		
		Model model = new CusModelUserInsert(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
	
	

	@POST
	@Path(UPDATE_CUSTOMER)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCustomer(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new CusModelUpdate(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}

	
	
	@DELETE
	@Path(DELETE_CUSTOMER)
	@Produces(MediaType.APPLICATION_JSON)
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
	
	
	
	@POST
	@Path(SEARCH_CUSTOMER)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchCustomer(@Context HttpServletRequest request, String incomingData) {

		
		Model model = new CuslisModelSearchAuth(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
}
