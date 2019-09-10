package br.com.gda.servlet.resource;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.gda.file.fileUpload.model.FilupModelInsert;
import br.com.gda.model.Model;

@Path("/File")
public class FileResource {

	private static final String INSERT_FILE_IMG = "/insertFileImg";

	
	
	@POST
	@Path(INSERT_FILE_IMG)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertFileImg(@Context HttpServletRequest request, String incomingData) {		
		
		Model model = new FilupModelInsert(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}
}
