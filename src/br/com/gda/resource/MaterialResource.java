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

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.model.MatModelDelete;
import br.com.gda.business.material.model.MatModelInsert;
import br.com.gda.business.material.model.MatModelSelect;
import br.com.gda.business.material.model.MatModelUpdate;
import br.com.gda.business.materialMovement.info.MatmovInfo;
import br.com.gda.business.materialMovement.model.MatmovModelInsert;
import br.com.gda.business.materialMovement.model.MatmovModelSelect;
import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.business.materialStore.model.MatoreModelDelete;
import br.com.gda.business.materialStore.model.MatoreModelInsert;
import br.com.gda.business.materialStore.model.MatoreModelSelect;
import br.com.gda.business.materialStore.model.MatoreModelUpdate;
import br.com.gda.model.Model;

@Path("/Material")
public class MaterialResource {
	private static final String INSERT_MATERIAL = "/insertMaterial";
	private static final String UPDATE_MATERIAL = "/updateMaterial";
	private static final String DELETE_MATERIAL = "/deleteMaterial";
	private static final String SELECT_MATERIAL = "/selectMaterial";	
	private static final String SELECT_MAT_STORE = "/selectMatStore";
	private static final String INSERT_MAT_STORE = "/insertMatStore";
	private static final String UPDATE_MAT_STORE = "/updateMatStore";
	private static final String DELETE_MAT_STORE = "/deleteMatStore";
	private static final String INSERT_MAT_MOV = "/insertMatmov";
	private static final String SELECT_MAT_MOV = "/selectMatmov";

	
	@POST
	@Path(INSERT_MATERIAL)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertMaterial(@Context HttpServletRequest request, String incomingData) {	
		
		Model modelInsert = new MatModelInsert(incomingData, request);
		modelInsert.executeRequest();
		return modelInsert.getResponse();
	}
	
	
	
	@POST
	@Path(UPDATE_MATERIAL)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateMaterial(@Context HttpServletRequest request, String incomingData) {

		Model modelUpdate = new MatModelUpdate(incomingData, request);
		modelUpdate.executeRequest();
		return modelUpdate.getResponse();
	}
	
	
	
	@DELETE
	@Path(DELETE_MATERIAL)
	public Response deleteMaterial(@HeaderParam("TOKEN_OWNER")    @DefaultValue("-1") long codOwner, 
			                       @HeaderParam("codMaterial")    @DefaultValue("-1") long codMat,
			                       @HeaderParam("TOKEN_USERNAME") String username,
			                       @HeaderParam("codLanguage")    @DefaultValue("EN") String codLanguage) {
		
		MatInfo recordInfo = new MatInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codMat = codMat;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;
		
		
		Model modelDelete = new MatModelDelete(recordInfo);
		modelDelete.executeRequest();
		return modelDelete.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_MATERIAL)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectMaterial(@HeaderParam("codOwner")    @DefaultValue("-1") long codOwner,
								   @HeaderParam("codMaterial") @DefaultValue("-1") long codMat, 
								   @HeaderParam("codLanguage") @DefaultValue("-1") String codLanguage) {


		MatInfo recordInfo = new MatInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codMat = codMat;
		recordInfo.codLanguage = codLanguage;
		
		
		Model modelSelect = new MatModelSelect(recordInfo);
		modelSelect.executeRequest();
		return modelSelect.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_MAT_STORE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectMatore(@HeaderParam("TOKEN_OWNER") @DefaultValue("-1") long codOwner,
			                     @HeaderParam("codStore")    @DefaultValue("-1") long codStore,
								 @HeaderParam("codMaterial") @DefaultValue("-1") long codMat, 
								 @HeaderParam("TOKEN_USERNAME") String username,
								 @HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage) {


		MatoreInfo recordInfo = new MatoreInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codMat = codMat;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;
		
		Model modelSelect = new MatoreModelSelect(recordInfo);
		modelSelect.executeRequest();
		return modelSelect.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_MAT_STORE)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertMatore(@Context HttpServletRequest request, String incomingData) {
		
		Model modelInsert = new MatoreModelInsert(incomingData, request);
		modelInsert.executeRequest();
		return modelInsert.getResponse();
	}
	
	
	
	@POST
	@Path(UPDATE_MAT_STORE)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateMatore(@Context HttpServletRequest request, String incomingData) {

		Model modelUpdate = new MatoreModelUpdate(incomingData, request);
		modelUpdate.executeRequest();
		return modelUpdate.getResponse();
	}	
	
	
	
	@DELETE
	@Path(DELETE_MAT_STORE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteMatore(@HeaderParam("TOKEN_OWNER")    @DefaultValue("-1") long codOwner,
			                     @HeaderParam("codStore")    	@DefaultValue("-1") long codStore,
								 @HeaderParam("codMaterial") 	@DefaultValue("-1") long codMat,
								 @HeaderParam("TOKEN_USERNAME") String username,
								 @HeaderParam("codLanguage")    @DefaultValue("EN") String codLanguage) {

		MatoreInfo recordInfo = new MatoreInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codMat = codMat;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;
		
		
		Model modelSelect = new MatoreModelDelete(recordInfo);
		modelSelect.executeRequest();
		return modelSelect.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_MAT_MOV)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertMatmov(@Context HttpServletRequest request, String incomingData) {	
		
		Model modelInsert = new MatmovModelInsert(incomingData, request);
		modelInsert.executeRequest();
		return modelInsert.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_MAT_MOV)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectMatmov(@HeaderParam("TOKEN_OWNER") @DefaultValue("-1") long codOwner,
								 @HeaderParam("codStore")    @DefaultValue("-1") long codStore,
								 @HeaderParam("codMaterial") @DefaultValue("-1") long codMat,
								 @HeaderParam("TOKEN_USERNAME") String username,
								 @HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage) {

		//TODO: desabilitar esse endpoint ?
		MatmovInfo recordInfo = new MatmovInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codStore = codStore;
		recordInfo.codMat = codMat;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;
		
		
		Model modelSelect = new MatmovModelSelect(recordInfo);
		modelSelect.executeRequest();
		return modelSelect.getResponse();
	}
}
