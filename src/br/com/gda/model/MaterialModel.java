package br.com.gda.model;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.sun.jersey.multipart.FormDataBodyPart;
import com.sun.jersey.multipart.FormDataMultiPart;

import br.com.gda.dao.MaterialDAO;
import br.com.gda.db.ConnectionBD;
import br.com.gda.helper.MaterialDetail;
import br.com.gda.helper.Material;
import br.com.gda.helper.RecordMode;

public class MaterialModel extends JsonBuilder {

	private static final String MATERIAL = "Material";
	private ArrayList<Material> materialList = new ArrayList<Material>();

	public Response insertMaterial(String incomingData) {
		Response resultResponse = tryToInsertMaterial(incomingData);	
		
		//TODO: pegar material do BD
		//int success = Response.Status.OK.getStatusCode();
		
		//if (resultResponse.getStatus() == success) 
			//resultResponse = selectStoreFromCnpj(incomingData);
		
		return resultResponse;
	}
	
	
	
	private Response tryToInsertMaterial(String incomingData) {
		Material emptyMaterial = new Material();
		
		try {
			List<Material> materials = jsonToMaterialList(incomingData);			
			new MaterialDAO().insertMaterial(materials);
			return makeResponse(RETURNED_SUCCESSFULLY, Response.Status.OK, materials);		

			
		} catch (JsonParseException e) {
			return makeResponse(ILLEGAL_ARGUMENT, Response.Status.BAD_REQUEST, emptyMaterial);
		} catch (SQLException | IndexOutOfBoundsException e) {
			return makeResponse(INTERNAL_ERROR, Response.Status.INTERNAL_SERVER_ERROR, emptyMaterial);
		}
	}
	
	
	
	public Response updateMaterial(String incomingData) {
		Response resultResponse = tryToUpdateMaterial(incomingData);
		
		int success = Response.Status.OK.getStatusCode();
		
		if (resultResponse.getStatus() == success) 
			resultResponse = selectMaterialFromCodeMat(incomingData);
		
		return resultResponse;
	}
	
	
	
	private Response tryToUpdateMaterial(String incomingData) {
		Material emptyMaterial = new Material();
		
		try {
			List<Material> materials = jsonToMaterialList(incomingData);			
			new MaterialDAO().updateMaterial(materials);
			return makeResponse(RETURNED_SUCCESSFULLY, Response.Status.OK, materials);		
			
		} catch (JsonParseException e) {
			return makeResponse(ILLEGAL_ARGUMENT, Response.Status.BAD_REQUEST, emptyMaterial);
		} catch (SQLException | IndexOutOfBoundsException e) {
			return makeResponse(INTERNAL_ERROR, Response.Status.INTERNAL_SERVER_ERROR, emptyMaterial);
		}
	}
	
	
	
	private Response selectMaterialFromCodeMat(String incomingData) {
		Response resultResponse = tryToSelectMaterialFromCodeMat(incomingData);		
		return resultResponse;
	}
	
	
	
	private Response tryToSelectMaterialFromCodeMat(String incomingData) {
		Material emptyMaterial = new Material();
		
		try {
			Material material = jsonToMaterial(incomingData);
			Response resultResponse = selectMaterialFromCodeMat(material.getCodOwner(), material.getCodMaterial());			
			return resultResponse;
			
		} catch (JsonParseException e) {
			return makeResponse(ILLEGAL_ARGUMENT, Response.Status.BAD_REQUEST, emptyMaterial);
		} catch (IndexOutOfBoundsException e) {
			return makeResponse(INTERNAL_ERROR, Response.Status.INTERNAL_SERVER_ERROR, emptyMaterial);
		}
	}
	
	
	
	private Response selectMaterialFromCodeMat(long codOwner, int codMaterial) {
		Response resultResponse = tryToSelectMaterialFromCodeMat(codOwner, codMaterial);
		return resultResponse;	
	}
	
	
	
	private Response tryToSelectMaterialFromCodeMat(long codOwner, int codMaterial) {
		Material emptyMaterial = new Material();
		
		try {
			Material resultMaterial = new MaterialDAO().selectMaterialFromCodeMat(codOwner, codMaterial);
			
			if (resultMaterial.getCodMaterial() == null)
				return makeResponse(MATERIAL_NOT_FOUND, Response.Status.BAD_REQUEST, emptyMaterial);		
				
			return makeResponse(RETURNED_SUCCESSFULLY, Response.Status.OK, resultMaterial);	

		} catch (SQLException e) {
			return makeResponse(INTERNAL_ERROR, Response.Status.INTERNAL_SERVER_ERROR, emptyMaterial);
		}
	}
	
	
	
	private Response selectMaterialFromCodeOwner(long codOwner) {
		Response resultResponse = tryToSelectMaterialFromCodeOwner(codOwner);
		return resultResponse;	
	}
	
	
	
	private Response tryToSelectMaterialFromCodeOwner(long codOwner) {
		Material emptyMaterial = new Material();
		
		try {
			List<Material> resultMaterials = new MaterialDAO().selectMaterialFromCodeOwner(codOwner);
			
			if (resultMaterials.isEmpty())
				return makeResponse(MATERIAL_NOT_FOUND, Response.Status.BAD_REQUEST, emptyMaterial);
			
			return makeResponse(RETURNED_SUCCESSFULLY, Response.Status.OK, resultMaterials);					

		} catch (SQLException e) {
			return makeResponse(INTERNAL_ERROR, Response.Status.INTERNAL_SERVER_ERROR, emptyMaterial);
		}
	}
	
	
	
	public Response deleteMaterial(long codOwner, int codMaterial) {
		Response resultResponse = tryToDeleteMaterial(codOwner, codMaterial);
		return resultResponse;
	}
	
	
	
	private Response tryToDeleteMaterial(long codOwner, int codMaterial) {
		Material emptyMaterial = new Material();
		try {
			new MaterialDAO().deleteMaterial(codOwner, codMaterial);
			return makeResponse(RETURNED_SUCCESSFULLY, Response.Status.OK, emptyMaterial);
			
		} catch (SQLException | IndexOutOfBoundsException e) {
			return makeResponse(INTERNAL_ERROR, Response.Status.INTERNAL_SERVER_ERROR, emptyMaterial);
		}
	}
	
	
	
	//TODO: acabou ficando duplicado. Verificar se pode ficar somente um método
	public Response selectMaterial(long codOwner, int codMaterial, String language) {
		Response resultResponse = tryToSelectMaterial(codOwner, codMaterial, language);
		return resultResponse;
	}
	
	
	
	private Response tryToSelectMaterial(long codOwner, int codMaterial, String language) {
		//TODO - falta adicionar o idioma como parâmetro
		Response resultResponse;		

		if (codMaterial > 0) 
			resultResponse = selectMaterialFromCodeMat(codOwner, codMaterial);
		else
			resultResponse = selectMaterialFromCodeOwner(codOwner);
		
		return resultResponse;
	}
	
	
	
	private Material jsonToMaterial(String incomingData) {
		List<Material> materials = jsonToMaterialList(incomingData);
		Material oneMaterial = materials.get(0);
		return oneMaterial;
	}
	
	
	
	private List<Material> jsonToMaterialList(String incomingData) {
		List<Material> materials = new ArrayList<>();
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();

		if (parser.parse(incomingData).isJsonArray()) {
			JsonArray array = parser.parse(incomingData).getAsJsonArray();

			for (int i = 0; i < array.size(); i++) {
				materials.add(gson.fromJson(array.get(i), Material.class));
			}
		} else {
			JsonObject object = parser.parse(incomingData).getAsJsonObject();
			materials.add(gson.fromJson(object, Material.class));
		}

		return materials;
	}




	//TODO: tornar este aqui obsoleto
	public ArrayList<Material> selectMaterial(List<Long> codOwner, List<Integer> codMaterial, List<Integer> codCategory,
			List<Integer> codType, List<String> image, List<String> barCode, List<String> recordMode,
			List<String> language, List<String> name, List<String> description, List<String> textLong)
					throws SQLException {

		ArrayList<Material> materialList = new MaterialDAO().selectMaterial(codOwner, codMaterial, codCategory, codType,
				image, barCode, recordMode, language, name, description, textLong);

		ArrayList<MaterialDetail> detailMatList = new ArrayList<MaterialDetail>();

		List<Long> codOwnerList = new ArrayList<Long>();
		Material materialBefore = null;
		for (Material material : materialList) {
			if (materialBefore == null || material.getCodOwner() != materialBefore.getCodOwner()) {

				codOwnerList.clear();
				codOwnerList.add(material.getCodOwner());

				codMaterial = materialList.stream().filter(m -> m.getCodOwner().equals(material.getCodOwner()))
						.map(m -> m.getCodMaterial()).collect(Collectors.toList());

				detailMatList = new MaterialDetailModel().selectMaterialDetail(codOwnerList, codMaterial, null,
						recordMode, language, null);

				addDetailMat(detailMatList, material);
			} else {
				addDetailMat(detailMatList, material);
			}
			materialBefore = material;
		}

		return this.setMaterialList(materialList);
	}

	private void addDetailMat(ArrayList<MaterialDetail> detailMatList, Material material) {
		material.getDetailMat().addAll(detailMatList.stream().filter(m -> m.getCodOwner().equals(material.getCodOwner())
				&& m.getCodMaterial().equals(material.getCodMaterial())).collect(Collectors.toList()));
	}

	//TODO: tornar esse método obsoleto
	public JsonObject selectMaterialJson(List<Long> codOwner, List<Integer> codMaterial, List<Integer> codCategory,
			List<Integer> codType, List<String> image, List<String> barCode, List<String> recordMode,
			List<String> language, List<String> name, List<String> description, List<String> textLong, boolean runMsg) {

		ArrayList<Material> materialList = new ArrayList<Material>();
		SQLException exception = new SQLException(RETURNED_SUCCESSFULLY, null, 200);

		try {

			materialList = selectMaterial(codOwner, codMaterial, codCategory, codType, image, barCode, recordMode,
					language, name, description, textLong);

		} catch (SQLException e) {
			exception = e;
		}

		JsonObject jsonObject = getJsonObjectSelect(materialList, exception);

		if (runMsg)
			sendMessage(materialList, exception, codOwner, OWNER, MATERIAL);

		return jsonObject;
	}


	public ArrayList<Material> getMaterialList() {
		return materialList;
	}

	public ArrayList<Material> setMaterialList(ArrayList<Material> materialList) {
		this.materialList = materialList;
		return materialList;
	}

	public Response insertMaterialWithImage(FormDataMultiPart multiPart) {

		Map<String, List<FormDataBodyPart>> params = multiPart.getFields();
		String incomingData = params.get("json").get(0).getValue();

		@SuppressWarnings("unchecked")
		ArrayList<Material> materialList = (ArrayList<Material>) jsonToObjectList(incomingData, Material.class);
		
		SQLException exception;
		try {
			new MaterialDAO().insertMaterial(materialList);
			exception = new SQLException(ConnectionBD.UPDATE_OK, null, 200);
		} catch (SQLException e) {
			exception = e;
		}

		JsonObject jsonObject = getJsonObjectUpdate(exception);

		if (exception.getErrorCode() == 200) {

			SQLException exceptionImage = new SQLException(FILE_UPLOADED, null, 200);

			for (Material material : materialList) {

//				FormDataContentDisposition contentDispositionHeader = params.get(material.getImage()).get(0)
//						.getFormDataContentDisposition();
				InputStream fileInputStream = params.get(material.getImage()).get(0).getValueAs(InputStream.class);

				String filePath = material.getCodOwner() + BAR + material.getCodMaterial()
						+ "." + JPG;

				SQLException exceptionReturn = new FileModel().saveCompressedFile(fileInputStream, filePath);
				if (exceptionReturn.getErrorCode() != 200)
					exceptionImage = exceptionReturn;

			}

			jsonObject = mergeJsonObject(jsonObject, getJsonObjectUpdateImage(exceptionImage));

			List<Long> codOwner = materialList.stream().map(m -> m.getCodOwner()).distinct()
					.collect(Collectors.toList());

			List<String> recordMode = new ArrayList<String>();
			recordMode.add(RecordMode.RECORD_OK);

			jsonObject = mergeJsonObject(jsonObject, selectMaterialJson(codOwner, null, null, null, null, null,
					recordMode, null, null, null, null, true));
		} else {
			JsonElement jsonElement = new JsonArray();
			SQLException ex = new SQLException();
			jsonObject = mergeJsonObject(jsonObject, getJsonObjectSelect(jsonElement, ex));
		}

		return responseSuccess(jsonObject);

	}

	public Response updateMaterialWithImage(FormDataMultiPart multiPart) {

		Map<String, List<FormDataBodyPart>> params = multiPart.getFields();
		String incomingData = params.get("json").get(0).getValue();

		@SuppressWarnings("unchecked")
		ArrayList<Material> materialList = (ArrayList<Material>) jsonToObjectList(incomingData, Material.class);
		
		SQLException exception;
		try {
			new MaterialDAO().updateMaterial(materialList);
			exception = new SQLException(ConnectionBD.UPDATE_OK, null, 200);
		} catch (SQLException e) {
			exception = e;
		}

		JsonObject jsonObject = getJsonObjectUpdate(exception);

		if (exception.getErrorCode() == 200) {

			SQLException exceptionImage = new SQLException(FILE_UPLOADED, null, 200);

			for (Material material : materialList) {

//				FormDataContentDisposition contentDispositionHeader = params.get(material.getImage()).get(0)
//						.getFormDataContentDisposition();
				InputStream fileInputStream = params.get(material.getImage()).get(0).getValueAs(InputStream.class);

				String filePath = material.getCodOwner() + BAR + material.getCodMaterial()
						+ "." + JPG;

				SQLException exceptionReturn = new FileModel().saveCompressedFile(fileInputStream, filePath);
				if (exceptionReturn.getErrorCode() != 200)
					exceptionImage = exceptionReturn;

			}

			jsonObject = mergeJsonObject(jsonObject, getJsonObjectUpdateImage(exceptionImage));

			List<Long> codOwner = materialList.stream().map(m -> m.getCodOwner()).distinct()
					.collect(Collectors.toList());

			List<String> recordMode = new ArrayList<String>();
			recordMode.add(RecordMode.RECORD_OK);

			jsonObject = mergeJsonObject(jsonObject, selectMaterialJson(codOwner, null, null, null, null, null,
					recordMode, null, null, null, null, true));
		} else {
			JsonElement jsonElement = new JsonArray();
			SQLException ex = new SQLException();
			jsonObject = mergeJsonObject(jsonObject, getJsonObjectSelect(jsonElement, ex));
		}

		return responseSuccess(jsonObject);

	}

}
