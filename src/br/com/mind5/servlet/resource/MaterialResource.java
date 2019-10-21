package br.com.mind5.servlet.resource;

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

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.MatModelDelete;
import br.com.mind5.business.material.model.MatModelInsert;
import br.com.mind5.business.material.model.MatModelSelect;
import br.com.mind5.business.material.model.MatModelUpdate;
import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialMovement.model.MatmovModelInsert;
import br.com.mind5.business.materialMovement.model.MatmovModelSelect;
import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.MatoreModelDelete;
import br.com.mind5.business.materialStore.model.MatoreModelInsert;
import br.com.mind5.business.materialStore.model.MatoreModelSelect;
import br.com.mind5.business.materialStore.model.MatoreModelUpdate;
import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.model.MatextModelDelete;
import br.com.mind5.business.materialText.model.MatextModelSelect;
import br.com.mind5.business.materialText.model.MatextModelUpsert;
import br.com.mind5.model.Model;

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
	private static final String UPSERT_MATERIAL_TEXT = "/upsertMaterialText";
	private static final String DELETE_MATERIAL_TEXT = "/deleteMaterialText";
	private static final String SELECT_MATERIAL_TEXT = "/selectMaterialText";	

	
	@POST
	@Path(INSERT_MATERIAL)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertMaterial(@Context HttpServletRequest request, String incomingData) {	
		
		Model model = new MatModelInsert(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(UPDATE_MATERIAL)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateMaterial(@Context HttpServletRequest request, String incomingData) {

		Model model = new MatModelUpdate(incomingData, request);
		model.executeRequest();
		return model.getResponse();
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
		
		
		Model model = new MatModelDelete(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_MATERIAL)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectMaterial(@HeaderParam("TOKEN_OWNER") @DefaultValue("-1") long codOwner,
								   @HeaderParam("codMaterial") @DefaultValue("-1") long codMat, 
								   @HeaderParam("TOKEN_USERNAME") String username,
								   @HeaderParam("codLanguage") @DefaultValue("EN") String codLanguage) {


		MatInfo recordInfo = new MatInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codMat = codMat;
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		
		
		Model model = new MatModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
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
		
		Model model = new MatoreModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_MAT_STORE)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertMatore(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new MatoreModelInsert(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(UPDATE_MAT_STORE)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateMatore(@Context HttpServletRequest request, String incomingData) {

		Model model = new MatoreModelUpdate(incomingData, request);
		model.executeRequest();
		return model.getResponse();
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
		
		
		Model model = new MatoreModelDelete(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(INSERT_MAT_MOV)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertMatmov(@Context HttpServletRequest request, String incomingData) {	
		
		Model model = new MatmovModelInsert(incomingData, request);
		model.executeRequest();
		return model.getResponse();
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
		
		
		Model model = new MatmovModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@POST
	@Path(UPSERT_MATERIAL_TEXT)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response upsertMaterialText(@Context HttpServletRequest request, String incomingData) {

		Model model = new MatextModelUpsert(incomingData, request);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@DELETE
	@Path(DELETE_MATERIAL_TEXT)
	public Response deleteMaterialText(@HeaderParam("TOKEN_OWNER")    @DefaultValue("-1") long codOwner, 
			                           @HeaderParam("codMaterial")    @DefaultValue("-1") long codMat,
			                           @HeaderParam("TOKEN_USERNAME") String username,
			                           @HeaderParam("codLanguage")    String codLanguage) {
		
		MatextInfo recordInfo = new MatextInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codMat = codMat;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;
		
		
		Model model = new MatextModelDelete(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
	
	
	
	@GET
	@Path(SELECT_MATERIAL_TEXT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectMaterialText(@HeaderParam("TOKEN_OWNER") @DefaultValue("-1") long codOwner,
								       @HeaderParam("codMaterial") @DefaultValue("-1") long codMat, 
								       @HeaderParam("TOKEN_USERNAME") String username,
								       @HeaderParam("codLanguage") String codLanguage) {


		MatextInfo recordInfo = new MatextInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codMat = codMat;
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		
		
		Model model = new MatextModelSelect(recordInfo);
		model.executeRequest();
		return model.getResponse();
	}
}
