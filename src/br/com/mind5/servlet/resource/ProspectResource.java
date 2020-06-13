package br.com.mind5.servlet.resource;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.mind5.model.Model;
import br.com.mind5.security.otpProspectStore.model.OtporeModelInsert;

@Path("/Prospect")
public class ProspectResource {

	private static final String INSERT_OTP_PROSPECT_STORE = "/insertOtpProspectStore";	
	
	
	@POST
	@Path(INSERT_OTP_PROSPECT_STORE)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertOtpProspectStore(@Context HttpServletRequest request, String incomingData) {		
		
		Model model = new OtporeModelInsert(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}
}
