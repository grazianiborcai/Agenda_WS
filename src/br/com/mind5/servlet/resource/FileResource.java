package br.com.mind5.servlet.resource;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.model.FimgModelDeleteCus;
import br.com.mind5.file.fileImage.model.FimgModelDeleteEmp;
import br.com.mind5.file.fileImage.model.FimgModelDeleteMat;
import br.com.mind5.file.fileImage.model.FimgModelDeleteOwner;
import br.com.mind5.file.fileImage.model.FimgModelDeleteStore;
import br.com.mind5.file.fileImage.model.FimgModelDeleteUser;
import br.com.mind5.file.fileImage.model.FimgModelInsertCus;
import br.com.mind5.file.fileImage.model.FimgModelInsertEmp;
import br.com.mind5.file.fileImage.model.FimgModelInsertMat;
import br.com.mind5.file.fileImage.model.FimgModelInsertOwner;
import br.com.mind5.file.fileImage.model.FimgModelInsertStore;
import br.com.mind5.file.fileImage.model.FimgModelInsertUserAuth;
import br.com.mind5.file.fileImage.model.FimgModelUpdateMat;
import br.com.mind5.file.fileImage.model.FimgModelUpdateStore;
import br.com.mind5.model.Model;

@Path("/File")
public class FileResource {

	private static final String INSERT_FILE_IMG_OWNER = "/insertFileImgOwner";
	private static final String INSERT_FILE_IMG_EMPLOYEE = "/insertFileImgEmployee";
	private static final String INSERT_FILE_IMG_CUSTOMER = "/insertFileImgCustomer";
	private static final String INSERT_FILE_IMG_USER = "/insertFileImgUser";
	private static final String INSERT_FILE_IMG_STORE = "/insertFileImgStore";
	private static final String UPDATE_FILE_IMG_STORE = "/updateFileImgStore";
	private static final String DELETE_FILE_IMG_STORE = "/deleteFileImgStore";
	private static final String DELETE_FILE_IMG_OWNER = "/deleteFileImgOwner";
	private static final String DELETE_FILE_IMG_EMPLOYEE = "/deleteFileImgEmployee";
	private static final String DELETE_FILE_IMG_CUSTOMER = "/deleteFileImgCustomer";
	private static final String DELETE_FILE_IMG_USER = "/deleteFileImgUser";
	private static final String INSERT_FILE_IMG_MAT = "/insertFileImgMaterial";
	private static final String UPDATE_FILE_IMG_MAT = "/updateFileImgMaterial";
	private static final String DELETE_FILE_IMG_MAT = "/deleteFileImgMaterial";
	
	
	
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
	@Path(INSERT_FILE_IMG_EMPLOYEE)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)	
	public Response insertFileImgEmployee(@HeaderParam("TOKEN_OWNER")    	@DefaultValue("-1") long codOwner, 
						                  @HeaderParam("TOKEN_USERNAME") 	String username,
						                  @FormDataParam("codEmployee")     @DefaultValue("-1") long codEmployee,
						                  @FormDataParam("codLanguage")     @DefaultValue("EN") String codLanguage,
						                  @FormDataParam("file") 			InputStream fileData,
						                  @FormDataParam("file") 			FormDataContentDisposition fileDetails) {		
		
		FimgInfo recordInfo = new FimgInfo();		
		
		recordInfo.codOwner = codOwner;	
		recordInfo.codEmployee = codEmployee;
		recordInfo.fileImgData = fileData;
		recordInfo.codLanguage = codLanguage;		
		recordInfo.username = username;	
		recordInfo.fileImgExtension = FilenameUtils.getExtension(fileDetails.getFileName());
		
		Model model = new FimgModelInsertEmp(recordInfo);
		model.executeRequest();
		return model.getResponse();
	} 
	
	
	
	@POST
	@Path(INSERT_FILE_IMG_CUSTOMER)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)	
	public Response insertFileImgCustomer(@HeaderParam("TOKEN_OWNER")    	@DefaultValue("-1") long codOwner, 
						                  @HeaderParam("TOKEN_USERNAME") 	String username,
						                  @FormDataParam("codCustomer")     @DefaultValue("-1") long codCustomer,
						                  @FormDataParam("codLanguage")     @DefaultValue("EN") String codLanguage,
						                  @FormDataParam("file") 			InputStream fileData,
						                  @FormDataParam("file") 			FormDataContentDisposition fileDetails) {		
		
		FimgInfo recordInfo = new FimgInfo();		
		
		recordInfo.codOwner = codOwner;	
		recordInfo.codCustomer = codCustomer;
		recordInfo.fileImgData = fileData;
		recordInfo.codLanguage = codLanguage;		
		recordInfo.username = username;	
		recordInfo.fileImgExtension = FilenameUtils.getExtension(fileDetails.getFileName());
		
		Model model = new FimgModelInsertCus(recordInfo);
		model.executeRequest();
		return model.getResponse();
	} 
	
	
	
	@POST
	@Path(INSERT_FILE_IMG_USER)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)	
	public Response insertFileImgUser(@HeaderParam("TOKEN_OWNER")    	@DefaultValue("-1") long codOwner, 
					                  @HeaderParam("TOKEN_USERNAME") 	String username,
					                  @FormDataParam("codLanguage")     @DefaultValue("EN") String codLanguage,
					                  @FormDataParam("file") 			InputStream fileData,
					                  @FormDataParam("file") 			FormDataContentDisposition fileDetails) {		
		
		FimgInfo recordInfo = new FimgInfo();		
		
		recordInfo.codOwner = codOwner;	
		recordInfo.fileImgData = fileData;
		recordInfo.codLanguage = codLanguage;		
		recordInfo.username = username;	
		recordInfo.fileImgExtension = FilenameUtils.getExtension(fileDetails.getFileName());
		
		Model model = new FimgModelInsertUserAuth(recordInfo);
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
	
	
	
	@DELETE
	@Path(DELETE_FILE_IMG_OWNER)
	@Produces(MediaType.APPLICATION_JSON)	
	public Response deleteFileImgOwner(@HeaderParam("TOKEN_OWNER")    	@DefaultValue("-1") long codOwner, 
					                   @HeaderParam("TOKEN_USERNAME") 	String username,
					                   @HeaderParam("codLanguage")    	@DefaultValue("EN") String codLanguage,
					                   @HeaderParam("codFileImg") 		@DefaultValue("-1") long  codFileImg) {		
		
		FimgInfo recordInfo = new FimgInfo();		
		
		recordInfo.codOwner = codOwner;	
		recordInfo.codFileImg = codFileImg;
		recordInfo.codLanguage = codLanguage;		
		recordInfo.username = username;	
		
		Model model = new FimgModelDeleteOwner(recordInfo);
		model.executeRequest();
		return model.getResponse();
	} 
	
	
	
	@DELETE
	@Path(DELETE_FILE_IMG_EMPLOYEE)
	@Produces(MediaType.APPLICATION_JSON)	
	public Response deleteFileImgEmployee(@HeaderParam("TOKEN_OWNER")    	@DefaultValue("-1") long codOwner, 
						                  @HeaderParam("TOKEN_USERNAME") 	String username,
						                  @HeaderParam("codLanguage")    	@DefaultValue("EN") String codLanguage,
						                  @HeaderParam("codFileImg") 		@DefaultValue("-1") long  codFileImg) {		
		
		FimgInfo recordInfo = new FimgInfo();		
		
		recordInfo.codOwner = codOwner;	
		recordInfo.codFileImg = codFileImg;
		recordInfo.codLanguage = codLanguage;		
		recordInfo.username = username;	
		
		Model model = new FimgModelDeleteEmp(recordInfo);
		model.executeRequest();
		return model.getResponse();
	} 
	
	
	
	@DELETE
	@Path(DELETE_FILE_IMG_CUSTOMER)
	@Produces(MediaType.APPLICATION_JSON)	
	public Response deleteFileImgempCustomer(@HeaderParam("TOKEN_OWNER")    	@DefaultValue("-1") long codOwner, 
						                     @HeaderParam("TOKEN_USERNAME") 	String username,
						                     @HeaderParam("codLanguage")    	@DefaultValue("EN") String codLanguage,
						                     @HeaderParam("codFileImg") 		@DefaultValue("-1") long  codFileImg) {		
		
		FimgInfo recordInfo = new FimgInfo();		
		
		recordInfo.codOwner = codOwner;	
		recordInfo.codFileImg = codFileImg;
		recordInfo.codLanguage = codLanguage;		
		recordInfo.username = username;	
		
		Model model = new FimgModelDeleteCus(recordInfo);
		model.executeRequest();
		return model.getResponse();
	} 
	
	
	
	@DELETE
	@Path(DELETE_FILE_IMG_USER)
	@Produces(MediaType.APPLICATION_JSON)	
	public Response deleteFileImgempUser(@HeaderParam("TOKEN_OWNER")    	@DefaultValue("-1") long codOwner, 
					                     @HeaderParam("TOKEN_USERNAME") 	String username,
					                     @HeaderParam("codLanguage")    	@DefaultValue("EN") String codLanguage,
					                     @HeaderParam("codFileImg") 		@DefaultValue("-1") long  codFileImg) {		
		
		FimgInfo recordInfo = new FimgInfo();		
		
		recordInfo.codOwner = codOwner;	
		recordInfo.codFileImg = codFileImg;
		recordInfo.codLanguage = codLanguage;		
		recordInfo.username = username;	
		
		Model model = new FimgModelDeleteUser(recordInfo);
		model.executeRequest();
		return model.getResponse();
	} 
	
	
	
	@DELETE
	@Path(DELETE_FILE_IMG_STORE)
	@Produces(MediaType.APPLICATION_JSON)	
	public Response deleteFileImgStore(@HeaderParam("TOKEN_OWNER")    	@DefaultValue("-1") long codOwner, 
					                   @HeaderParam("TOKEN_USERNAME") 	String username,
					                   @HeaderParam("codLanguage")    	@DefaultValue("EN") String codLanguage,
					                   @HeaderParam("codFileImg") 		@DefaultValue("-1") long  codFileImg) {		
		
		FimgInfo recordInfo = new FimgInfo();		
		
		recordInfo.codOwner = codOwner;	
		recordInfo.codFileImg = codFileImg;
		recordInfo.codLanguage = codLanguage;		
		recordInfo.username = username;	
		
		Model model = new FimgModelDeleteStore(recordInfo);
		model.executeRequest();
		return model.getResponse();
	} 
	
	
	
	@POST
	@Path(INSERT_FILE_IMG_MAT)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)	
	public Response insertFileImgMat(@HeaderParam("TOKEN_OWNER")    	@DefaultValue("-1") long codOwner, 
					                 @HeaderParam("TOKEN_USERNAME") 	String username,
					                 @FormDataParam("codLanguage")      @DefaultValue("EN") String codLanguage,
					                 @FormDataParam("codMat")           @DefaultValue("-1") long codMat,
					                 @FormDataParam("isCover")          @DefaultValue("false") boolean isCover,
					                 @FormDataParam("file") 			InputStream fileData,
					                 @FormDataParam("file") 			FormDataContentDisposition fileDetails) {		
		
		FimgInfo recordInfo = new FimgInfo();		
		
		recordInfo.codOwner = codOwner;	
		recordInfo.codMat = codMat;
		recordInfo.isCover = isCover;
		recordInfo.fileImgData = fileData;
		recordInfo.codLanguage = codLanguage;		
		recordInfo.username = username;	
		recordInfo.fileImgExtension = FilenameUtils.getExtension(fileDetails.getFileName());
		
		Model model = new FimgModelInsertMat(recordInfo);
		model.executeRequest();
		return model.getResponse();
	} 
	
	
	
	@POST
	@Path(UPDATE_FILE_IMG_MAT)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)	
	public Response updateFileImgMat(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new FimgModelUpdateMat(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@DELETE
	@Path(DELETE_FILE_IMG_MAT)
	@Produces(MediaType.APPLICATION_JSON)	
	public Response deleteFileImgMat(@HeaderParam("TOKEN_OWNER")    	@DefaultValue("-1") long codOwner, 
					                 @HeaderParam("TOKEN_USERNAME") 	String username,
					                 @HeaderParam("codLanguage")    	@DefaultValue("EN") String codLanguage,
					                 @HeaderParam("codFileImg") 		@DefaultValue("-1") long  codFileImg) {		
		
		FimgInfo recordInfo = new FimgInfo();		
		
		recordInfo.codOwner = codOwner;	
		recordInfo.codFileImg = codFileImg;
		recordInfo.codLanguage = codLanguage;		
		recordInfo.username = username;	
		
		Model model = new FimgModelDeleteMat(recordInfo);
		model.executeRequest();
		return model.getResponse();
	} 
}
