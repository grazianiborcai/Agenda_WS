package br.com.gda.servlet.resource;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.io.FilenameUtils;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import br.com.gda.file.fileImage.info.FimgInfo;
import br.com.gda.file.fileImage.model.FimgModelInsert;
import br.com.gda.file.fileImage.model.FimgModelInsertOwner;
import br.com.gda.model.Model;

@Path("/File")
public class FileResource {

	private static final String INSERT_FILE_IMG = "/insertFileImg";
	private static final String INSERT_FILE_IMG_OWNER = "/insertFileImgOwner";

	
	//TODO: remover ?
	@POST
	@Path(INSERT_FILE_IMG)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)	
	public Response insertFileImg(@HeaderParam("TOKEN_OWNER")    	@DefaultValue("-1") long codOwner, 
					              @HeaderParam("TOKEN_USERNAME") 	String username,
					              @FormDataParam("codLanguage")     @DefaultValue("EN") String codLanguage,
					              @FormDataParam("codMaterial")     @DefaultValue("-1") long codMat,
					              @FormDataParam("codPerson")       @DefaultValue("-1") long codPerson,
					              @FormDataParam("codCompany")      @DefaultValue("-1") long codCompany,
								  @FormDataParam("file") 			InputStream fileData,
								  @FormDataParam("file") 			FormDataContentDisposition fileDetails) {		
		
		FimgInfo recordInfo = new FimgInfo();		
		
		recordInfo.codOwner = codOwner;	
		recordInfo.codMat = codMat;
		recordInfo.codPerson = codPerson;
		recordInfo.codCompany = codCompany;
		recordInfo.fileImgData = fileData;
		recordInfo.codLanguage = codLanguage;		
		recordInfo.username = username;	
		recordInfo.fileImgExtension = FilenameUtils.getExtension(fileDetails.getFileName());
		
		Model model = new FimgModelInsert(recordInfo);
		model.executeRequest();
		return model.getResponse();
	} 
	
	
	
	@POST
	@Path(INSERT_FILE_IMG_OWNER)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)	
	public Response insertFileImgOwner(@HeaderParam("TOKEN_OWNER")    	@DefaultValue("-1") long codOwner, 
					                   @HeaderParam("TOKEN_USERNAME") 	String username,
					                   @FormDataParam("codLanguage")    @DefaultValue("EN") String codLanguage,
					                   @FormDataParam("codMaterial")    @DefaultValue("-1") long codMat,
					                   @FormDataParam("codPerson")      @DefaultValue("-1") long codPerson,
					                   @FormDataParam("codCompany")     @DefaultValue("-1") long codCompany,
					                   @FormDataParam("file") 			InputStream fileData,
					                   @FormDataParam("file") 			FormDataContentDisposition fileDetails) {		
		
		FimgInfo recordInfo = new FimgInfo();		
		
		recordInfo.codOwner = codOwner;	
		recordInfo.codMat = codMat;
		recordInfo.codPerson = codPerson;
		recordInfo.codCompany = codCompany;
		recordInfo.fileImgData = fileData;
		recordInfo.codLanguage = codLanguage;		
		recordInfo.username = username;	
		recordInfo.fileImgExtension = FilenameUtils.getExtension(fileDetails.getFileName());
		
		Model model = new FimgModelInsertOwner(recordInfo);
		model.executeRequest();
		return model.getResponse();
	} 
}
