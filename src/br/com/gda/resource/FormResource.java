package br.com.gda.resource;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.gda.business.form.info.AddressFormInfo;
import br.com.gda.business.form.model.AddressFormModelSelect;
import br.com.gda.model.Model;

@Path("/Form")
public class FormResource {

	private static final String SELECT_ADDRESS_FORM = "/selectAddressForm";
	
	
	
	@GET
	@Path(SELECT_ADDRESS_FORM)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectAddressForm(@HeaderParam("codCountry") String codCountry) {
		
		AddressFormInfo recordInfo = new AddressFormInfo();
		recordInfo.codCountry = codCountry;
		
		
		Model modelSelect = new AddressFormModelSelect(recordInfo);
		modelSelect.executeRequest();
		return modelSelect.getResponse();	
	}
}
