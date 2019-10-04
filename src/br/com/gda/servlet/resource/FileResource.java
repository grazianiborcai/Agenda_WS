package br.com.gda.servlet.resource;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.io.FilenameUtils;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import br.com.gda.file.fileImage.info.FimgInfo;
import br.com.gda.file.fileImage.model.FimgModelInsertOwner;
import br.com.gda.file.fileImage.model.FimgModelInsertStore;
import br.com.gda.file.fileImage.model.FimgModelUpdateStore;
import br.com.gda.model.Model;

@Path("/File")
public class FileResource {

	private static final String INSERT_FILE_IMG_OWNER = "/insertFileImgOwner";
	private static final String INSERT_FILE_IMG_STORE = "/insertFileImgStore";
	private static final String UPDATE_FILE_IMG_STORE = "/updateFileImgStore";
	
	
	
	@POST
	@Path(INSERT_FILE_IMG_OWNER)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)	
	public Response insertFileImgOwner(@HeaderParam("TOKEN_OWNER")    	@DefaultValue("-1") long codOwner, 
					                   @HeaderParam("TOKEN_USERNAME") 	String username,
					                   @FormDataParam("codLanguage")    @DefaultValue("EN") String codLanguage,
					                   @FormDataParam("file") 			InputStream fileData,
					                   @FormDataParam("file") 			FormDataContentDisposition fileDetails) {		
		
		FimgInfo recordInfo = new FimgInfo();		
		
		recordInfo.codOwner = codOwner;	
		recordInfo.fileImgData = fileData;
		recordInfo.codLanguage = codLanguage;		
		recordInfo.username = username;	
		recordInfo.fileImgExtension = FilenameUtils.getExtension(fileDetails.getFileName());
		
		Model model = new FimgModelInsertOwner(recordInfo);
		model.executeRequest();
		return model.getResponse();
	} 
	
	
	
	@POST
	@Path(INSERT_FILE_IMG_STORE)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)	
	public Response insertFileImgStore(@HeaderParam("TOKEN_OWNER")    	@DefaultValue("-1") long codOwner, 
					                   @HeaderParam("TOKEN_USERNAME") 	String username,
					                   @FormDataParam("codLanguage")    @DefaultValue("EN") String codLanguage,
					                   @FormDataParam("codStore")       @DefaultValue("-1") long codStore,
					                   @FormDataParam("isCover")        @DefaultValue("false") boolean isCover,
					                   @FormDataParam("file") 			InputStream fileData,
					                   @FormDataParam("file") 			FormDataContentDisposition fileDetails) {		
		
		FimgInfo recordInfo = new FimgInfo();		
		
		recordInfo.codOwner = codOwner;	
		recordInfo.codStore = codStore;
		recordInfo.isCover = isCover;
		recordInfo.fileImgData = fileData;
		recordInfo.codLanguage = codLanguage;		
		recordInfo.username = username;	
		recordInfo.fileImgExtension = FilenameUtils.getExtension(fileDetails.getFileName());
		
		Model model = new FimgModelInsertStore(recordInfo);
		model.executeRequest();
		return model.getResponse();
	} 
	
	
	
	@POST
	@Path(UPDATE_FILE_IMG_STORE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)	
	public Response updateFileImgStore(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new FimgModelUpdateStore(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}
}
