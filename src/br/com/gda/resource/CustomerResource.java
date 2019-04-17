package br.com.gda.resource;

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

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.customer.model.CusModelDelete;
import br.com.gda.business.customer.model.CusModelInsert;
import br.com.gda.business.customer.model.CusModelSelect;
import br.com.gda.business.customer.model.CusModelUpdate;
import br.com.gda.model.Model;

@Path("/Customer")
public class CustomerResource {
	private static final String INSERT_CUSTOMER = "/insertCustomer";
	private static final String UPDATE_CUSTOMER = "/updateCustomer";
	private static final String DELETE_CUSTOMER = "/deleteCustomer";
	private static final String SELECT_CUSTOMER = "/selectCustomer";

	
	
	@POST
	@Path(INSERT_CUSTOMER)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertCustomer(@Context HttpServletRequest request, String incomingData) {		
		
		Model model = new CusModelInsert(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}
	
	

	@POST
	@Path(UPDATE_CUSTOMER)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCustomer(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new CusModelUpdate(incomingData, request);
		model.executeRequest();
		return model.getResponse();
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
		return model.getResponse();
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
		return model.getResponse();
	}
}
