package br.com.gda.servlet.resource;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.multipart.FormDataParam;

import br.com.gda.file.fileImage.info.FimgInfo;
import br.com.gda.file.fileImage.model.FimgModelInsert;
import br.com.gda.model.Model;

@Path("/File")
public class FileResource {

	private static final String INSERT_FILE_IMG = "/insertFileImg";

	
	
	@POST
	@Path(INSERT_FILE_IMG)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
//	@Produces(MediaType.APPLICATION_JSON)	
	public Response insertFileImg(@HeaderParam("TOKEN_OWNER")    	@DefaultValue("-1") long codOwner, 
					              @HeaderParam("TOKEN_USERNAME") 	String username,
					              @FormDataParam("codLanguage")     @DefaultValue("EN") String codLanguage,
					              @FormDataParam("codMaterial")     @DefaultValue("-1") long codMat,
								  @FormDataParam("file") 			InputStream fileData,
								  @FormDataParam("incomingData")    String incomingData) {		
		
		FimgInfo recordInfo = new FimgInfo();		
		
		recordInfo.codOwner = codOwner;	
		recordInfo.codMat = codMat;
		recordInfo.fileImgData = fileData;
		recordInfo.codLanguage = codLanguage;		
		
		Model model = new FimgModelInsert(recordInfo);
		model.executeRequest();
		return model.getResponse();

	}
}
