package br.com.gda.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.multipart.FormDataMultiPart;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.model.MatModelInsert;
import br.com.gda.business.material.model.MatModelSelect;
import br.com.gda.business.material.model.MatModelUpdate;
import br.com.gda.model.Model;
import br.com.gda.model.legacy.MaterialModel;

@Path("/Material")
public class MaterialResource {
	private static final String INSERT_MATERIAL = "/insertMaterial";
	private static final String UPDATE_MATERIAL = "/updateMaterial";
	private static final String DELETE_MATERIAL = "/deleteMaterial";
	private static final String SELECT_MATERIAL = "/selectMaterial";
	private static final String INSERT_MATERIAL_WITH_IMAGE = "/insertMaterialWithImage";
	private static final String UPDATE_MATERIAL_WITH_IMAGE = "/updateMaterialWithImage";

	
	@POST
	@Path(INSERT_MATERIAL)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertMaterial(String incomingData) {	
		
		Model modelInsert = new MatModelInsert(incomingData);
		modelInsert.executeRequest();
		return modelInsert.getResponse();
	}
	
	
	
	@POST
	@Path(UPDATE_MATERIAL)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateMaterial(String incomingData) {

		Model modelUpdate = new MatModelUpdate(incomingData);
		modelUpdate.executeRequest();
		return modelUpdate.getResponse();
	}
	
	
	
	@DELETE
	@Path(DELETE_MATERIAL)
	public Response deleteMaterial(@HeaderParam("codOwner") long codOwner, 
			                       @HeaderParam("codMaterial") int codMaterial) {
		
		return new MaterialModel().deleteMaterial(codOwner, codMaterial);
	}
	
	
	@GET
	@Path(SELECT_MATERIAL)
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectMaterial(@HeaderParam("codOwner")    @DefaultValue("-1") long codOwner,
								   @HeaderParam("codMaterial") @DefaultValue("-1") long codMat, 
								   @HeaderParam("codLanguage") String codLanguage) {


		MatInfo recordInfo = new MatInfo();
		recordInfo.codOwner = codOwner;
		recordInfo.codMat = codMat;
		recordInfo.codLanguage = codLanguage;
		
		
		Model modelSelect = new MatModelSelect(recordInfo);
		modelSelect.executeRequest();
		return modelSelect.getResponse();
	}

	
	
	@POST
	@Path(INSERT_MATERIAL_WITH_IMAGE)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response insertMaterialWithImage(FormDataMultiPart multiPart) {

		return new MaterialModel().insertMaterialWithImage(multiPart);
	}


	@POST
	@Path(UPDATE_MATERIAL_WITH_IMAGE)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response updateMaterialWithImage(FormDataMultiPart multiPart) {

		return new MaterialModel().updateMaterialWithImage(multiPart);
	}
}
