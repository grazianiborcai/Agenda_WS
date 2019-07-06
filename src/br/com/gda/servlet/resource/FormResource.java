package br.com.gda.servlet.resource;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.gda.business.form.formAddress.info.FormAddressInfo;
import br.com.gda.business.form.formAddress.model.FormAddressModelSelect;
import br.com.gda.model.Model;

@Path("/Form")
public class FormResource {

	private static final String SELECT_ADDRESS_FORM = "/selectAddressForm";
	
	
	
	@GET
	@Path(SELECT_ADDRESS_FORM)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectAddressForm(@HeaderParam("codCountry") String codCountry) {
		
		FormAddressInfo recordInfo = new FormAddressInfo();
		recordInfo.codCountry = codCountry;
		
		
		Model modelSelect = new FormAddressModelSelect(recordInfo);
		modelSelect.executeRequest();
		return modelSelect.getResponse();	
	}
}
