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
import br.com.mind5.business.material.model.MatModelActivate;
import br.com.mind5.business.material.model.MatModelDelete;
import br.com.mind5.business.material.model.MatModelInactivate;
import br.com.mind5.business.material.model.MatModelInsert;
import br.com.mind5.business.material.model.MatModelSelect;
import br.com.mind5.business.material.model.MatModelUpdate;
import br.com.mind5.business.materialCatalogue.model.MatogueModelSelect;
import br.com.mind5.business.materialList.model.MatlisModelSearchAuth;
import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialMovement.model.MatmovModelInsert;
import br.com.mind5.business.materialMovement.model.MatmovModelSearch;
import br.com.mind5.business.materialMovement.model.MatmovModelSelect;
import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.MatoreModelDelete;
import br.com.mind5.business.materialStore.model.MatoreModelInsert;
import br.com.mind5.business.materialStore.model.MatoreModelSearch;
import br.com.mind5.business.materialStore.model.MatoreModelSelect;
import br.com.mind5.business.materialStore.model.MatoreModelUpdate;
import br.com.mind5.model.Model;

@Path("/Material")
public class MaterialResource {
	private static final String ACTIVATE_MATERIAL = "/activateMaterial";
	private static final String INACTIVATE_MATERIAL = "/inactivateMaterial";
	private static final String INSERT_MATERIAL = "/insertMaterial";
	private static final String UPDATE_MATERIAL = "/updateMaterial";
	private static final String DELETE_MATERIAL = "/deleteMaterial";
	private static final String SELECT_MATERIAL = "/selectMaterial";	
	private static final String SEARCH_MATERIAL = "/searchMaterial";	
	private static final String SELECT_MAT_STORE = "/selectMatStore";
	private static final String SEARCH_MAT_STORE = "/searchMatStore";
	private static final String INSERT_MAT_STORE = "/insertMatStore";
	private static final String UPDATE_MAT_STORE = "/updateMatStore";
	private static final String DELETE_MAT_STORE = "/deleteMatStore";
	private static final String INSERT_MAT_MOV = "/insertMatmov";
	private static final String SELECT_MAT_MOV = "/selectMatmov";	
	private static final String SEARCH_MAT_MOV = "/searchMatmov";
	private static final String SELECT_MAT_CATALOGUE = "/selectMaterialCatalogue";
	
	
	@GET
	@Path(ACTIVATE_MATERIAL)
	@Produces(MediaType.APPLICATION_JSON)
	public Response activateMaterial(@HeaderParam("TOKEN_OWNER") 	@DefaultValue("-1") long codOwner,
								     @HeaderParam("codMat") 		@DefaultValue("-1") long codMat, 
								     @HeaderParam("TOKEN_USERNAME") String username,
								     @HeaderParam("codLanguage") 	@DefaultValue("EN") String codLanguage) {


		MatInfo recordInfo = new MatInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codMat = codMat;
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		
		
		Model model = new MatModelActivate(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(INACTIVATE_MATERIAL)
	@Produces(MediaType.APPLICATION_JSON)
	public Response inactivateMaterial(@HeaderParam("TOKEN_OWNER") 	  @DefaultValue("-1") long codOwner,
								       @HeaderParam("codMat") 		  @DefaultValue("-1") long codMat, 
								       @HeaderParam("TOKEN_USERNAME") String username,
								       @HeaderParam("codLanguage") 	  @DefaultValue("EN") String codLanguage) {


		MatInfo recordInfo = new MatInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codMat = codMat;
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		
		
		Model model = new MatModelInactivate(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}

	
	
	@POST
	@Path(INSERT_MATERIAL)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertMaterial(@Context HttpServletRequest request, String incomingData) {	
		
		Model model = new MatModelInsert(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
	
	
	
	@POST
	@Path(UPDATE_MATERIAL)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateMaterial(@Context HttpServletRequest request, String incomingData) {

		Model model = new MatModelUpdate(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
	
	
	
	@DELETE
	@Path(DELETE_MATERIAL)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteMaterial(@HeaderParam("TOKEN_OWNER")    @DefaultValue("-1") long codOwner, 
			                       @HeaderParam("codMat")    	  @DefaultValue("-1") long codMat,
			                       @HeaderParam("TOKEN_USERNAME") String username,
			                       @HeaderParam("codLanguage")    @DefaultValue("EN") String codLanguage) {
		
		MatInfo recordInfo = new MatInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codMat = codMat;
		recordInfo.username = username;
		recordInfo.codLanguage = codLanguage;
		
		
		Model model = new MatModelDelete(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_MATERIAL)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectMaterial(@HeaderParam("TOKEN_OWNER") 	  @DefaultValue("-1") long codOwner,
								   @HeaderParam("codMat") 		  @DefaultValue("-1") long codMat, 
								   @HeaderParam("TOKEN_USERNAME") String username,
								   @HeaderParam("codLanguage") 	  @DefaultValue("EN") String codLanguage) {


		MatInfo recordInfo = new MatInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codMat = codMat;
		recordInfo.codLanguage = codLanguage;
		recordInfo.username = username;
		
		
		Model model = new MatModelSelect(recordInfo);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
	
	
	
	@POST
	@Path(SEARCH_MATERIAL)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response searchMatlis(@Context HttpServletRequest request, String incomingData) {	
		
		Model model = new MatlisModelSearchAuth(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_MAT_STORE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectMatore(@HeaderParam("TOKEN_OWNER") @DefaultValue("-1") long codOwner,
			                     @HeaderParam("codStore")    @DefaultValue("-1") long codStore,
								 @HeaderParam("codMat") 	 @DefaultValue("-1") long codMat, 
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
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
	
	
	
	@POST
	@Path(SEARCH_MAT_STORE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchMatore(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new MatoreModelSearch(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
	
	
	
	@POST
	@Path(INSERT_MAT_STORE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertMatore(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new MatoreModelInsert(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
	
	
	
	@POST
	@Path(UPDATE_MAT_STORE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateMatore(@Context HttpServletRequest request, String incomingData) {

		Model model = new MatoreModelUpdate(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}	
	
	
	
	@DELETE
	@Path(DELETE_MAT_STORE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteMatore(@HeaderParam("TOKEN_OWNER")    @DefaultValue("-1") long codOwner,
			                     @HeaderParam("codStore")    	@DefaultValue("-1") long codStore,
								 @HeaderParam("codMat") 		@DefaultValue("-1") long codMat,
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
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
	
	
	
	@POST
	@Path(INSERT_MAT_MOV)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertMatmov(@Context HttpServletRequest request, String incomingData) {	
		
		Model model = new MatmovModelInsert(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
	
	
	
	@GET
	@Path(SELECT_MAT_MOV)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectMatmov(@HeaderParam("TOKEN_OWNER") @DefaultValue("-1") long codOwner,
								 @HeaderParam("codStore")    @DefaultValue("-1") long codStore,
								 @HeaderParam("codMat") 	 @DefaultValue("-1") long codMat,
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
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
	
	
	
	@POST
	@Path(SEARCH_MAT_MOV)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchMatmov(@Context HttpServletRequest request, String incomingData) {	
		
		Model model = new MatmovModelSearch(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
	
	
	
	@POST
	@Path(SELECT_MAT_CATALOGUE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectMatogue(@Context HttpServletRequest request, String incomingData) {
		
		Model model = new MatogueModelSelect(incomingData, request);
		model.executeRequest();
		Response result = model.getResponse();	
		model.close();
		
		return result;
	}
}
