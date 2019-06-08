package br.com.gda.legacy.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import br.com.gda.helper.MaterialStore;
import br.com.gda.helper.RecordMode;
import br.com.gda.legacy.dao.MaterialStoreDAO;
import br.com.gda.helper.MaterialDetail;


public class MaterialStoreModel extends JsonBuilder {
	//TODO: weekday precisa ser chave da tabela "material_store"
	private ArrayList<MaterialStore> storeMaterialList = new ArrayList<MaterialStore>();

	public Response insertMaterialStore(String incomingData) {
		Response resultResponse = tryToInsertMaterialStore(incomingData);
		return resultResponse;
	}
	
	
	
	private Response tryToInsertMaterialStore(String incomingData) {
		MaterialStore emptyMaterialStore = new MaterialStore();
		
		try {
			List<MaterialStore> materialStores = jsonToMaterialStoreList(incomingData);
			
			new MaterialStoreDAO().insertMaterialStore(materialStores);			
			return makeResponse(RETURNED_SUCCESSFULLY, Response.Status.OK, materialStores);
			
			
		} catch (JsonParseException e) {
			return makeResponse(ILLEGAL_ARGUMENT, Response.Status.BAD_REQUEST, emptyMaterialStore);
		} catch (SQLException | IndexOutOfBoundsException e) {
			return makeResponse(INTERNAL_ERROR, Response.Status.INTERNAL_SERVER_ERROR, emptyMaterialStore);
		}
	}

	
	
	public Response updateMaterialStore(String incomingData) {
		Response resultResponse = tryToUpdateMaterialStore(incomingData);
		return resultResponse;
	}
	
	
	
	private Response tryToUpdateMaterialStore(String incomingData) {
		MaterialStore emptyMaterialStore = new MaterialStore();
		
		try {
			List<MaterialStore> materialStores = jsonToMaterialStoreList(incomingData);
			
			new MaterialStoreDAO().updateMaterialStore(materialStores);			
			return makeResponse(RETURNED_SUCCESSFULLY, Response.Status.OK, materialStores);
			
			
		} catch (JsonParseException e) {
			return makeResponse(ILLEGAL_ARGUMENT, Response.Status.BAD_REQUEST, emptyMaterialStore);
		} catch (SQLException | IndexOutOfBoundsException e) {
			return makeResponse(INTERNAL_ERROR, Response.Status.INTERNAL_SERVER_ERROR, emptyMaterialStore);
		}
	}
	
	
	
	public Response deleteMaterialStore(long codOwner, int codMaterial, int codStore, int weekday) {
			Response resultResponse = tryToDeleteMaterialStore(codOwner, codMaterial, codStore, weekday);
			return resultResponse;
	}
	
	
	
	private Response tryToDeleteMaterialStore(long codOwner, int codMaterial, int codStore, int weekday) {
		MaterialStore emptyMaterialStore = new MaterialStore();
		
		try {
			new MaterialStoreDAO().deleteMaterialStore(codOwner, codMaterial, codStore, weekday);			
			return makeResponse(RETURNED_SUCCESSFULLY, Response.Status.OK, emptyMaterialStore);
			
			
		} catch (SQLException | IndexOutOfBoundsException e) {
			return makeResponse(INTERNAL_ERROR, Response.Status.INTERNAL_SERVER_ERROR, emptyMaterialStore);
		}
	}
	
	
	
	public Response selectMaterialStoreResponse(SelectOption option) {
		Response resultResponse = tryToSelectMaterialStoreResponse(option);
		return resultResponse;
	}
	
	
	
	private Response tryToSelectMaterialStoreResponse(SelectOption option) {
		MaterialStore emptyMaterialStore = new MaterialStore();
		
		try {
			List<Long> codOwners = new ArrayList<>();
			codOwners.add(option.codOwner);
			
			List<Integer> codMaterials = new ArrayList<>();
			codMaterials.add(option.codMaterial);
			
			List<Integer> codStores = new ArrayList<>();
			codStores.add(option.codStore);
			
			List<Integer> codCategories = new ArrayList<>();
			codCategories.add(option.codCategory);
			
			List<Integer> codTypes = new ArrayList<>();
			codTypes.add(option.codType);
			
			List<String> recodModes = new ArrayList<>();
			recodModes.add(RecordMode.RECORD_OK);
			
			List<String> languages = new ArrayList<>();
			languages.add(option.language);
			
			List<MaterialStore> resultMaterialStores = new MaterialStoreDAO().selectMaterialStore(codOwners, codMaterials, codStores, 
					codCategories, codTypes, null, null, recodModes, languages, null, null, null);
			
			resultMaterialStores = tryToSelectMaterialDetail(resultMaterialStores, option.language);			
			return makeResponse(RETURNED_SUCCESSFULLY, Response.Status.OK, resultMaterialStores);
			
			
		} catch (SQLException | IndexOutOfBoundsException e) {
			return makeResponse(INTERNAL_ERROR, Response.Status.INTERNAL_SERVER_ERROR, emptyMaterialStore);
		}
	}
	
	
	//TODO: esse método deve ser encapsulado em um nova classe
	private List<MaterialStore> tryToSelectMaterialDetail(List<MaterialStore> materialStores, String language) throws SQLException {
			MaterialDetailModel materialDetail = new MaterialDetailModel();
			
			List<Long> codOwners = new ArrayList<>(); 
			List<Integer> codMaterials = new ArrayList<>(); 
			List<String> recordModes = new ArrayList<>(); 
			List<String> languages = new ArrayList<>(); 
			languages.add(language);
			
			for (MaterialStore eachMaterialStore : materialStores) {
				codOwners.clear(); 
				codOwners.add(eachMaterialStore.getCodOwner());
				
				codMaterials.clear();
				codMaterials.add(eachMaterialStore.getCodMaterial());
				
				recordModes.clear();
				recordModes.add(eachMaterialStore.getRecordMode());
				
				ArrayList<MaterialDetail> detailMatList = materialDetail.selectMaterialDetail(codOwners, codMaterials, null,
						recordModes, languages, null);
				
				eachMaterialStore.setDetailMat(detailMatList);
			}
		
		
		return materialStores;
	}
	
	
	
	private List<MaterialStore> jsonToMaterialStoreList(String incomingData) {
		List<MaterialStore> materialStores = new ArrayList<>();
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();

		if (parser.parse(incomingData).isJsonArray()) {
			JsonArray array = parser.parse(incomingData).getAsJsonArray();

			for (int i = 0; i < array.size(); i++) {
				materialStores.add(gson.fromJson(array.get(i), MaterialStore.class));
			}
		} else {
			JsonObject object = parser.parse(incomingData).getAsJsonObject();
			materialStores.add(gson.fromJson(object, MaterialStore.class));
		}

		return materialStores;
	}
	
	



	public ArrayList<MaterialStore> selectMaterialStore(List<Long> codOwner, List<Integer> codMaterial,
			List<Integer> codStore, List<Integer> codCategory, List<Integer> codType, List<String> image,
			List<String> barCode, List<String> recordMode, List<String> language, List<String> name,
			List<String> description, List<String> textLong) throws SQLException {

		List<MaterialStore> materialList = new MaterialStoreDAO().selectMaterialStore(codOwner, codMaterial,
				codStore, codCategory, codType, image, barCode, recordMode, language, name, description, textLong);

		ArrayList<MaterialDetail> detailMatList = new ArrayList<MaterialDetail>();

		List<Long> codOwnerList = new ArrayList<Long>();
		MaterialStore materialBefore = null;
		for (MaterialStore material : materialList) {
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

		//TODO: Esse loop foi incluído somente para prover compatibilidade com o tipo de retorno. Rever!
		ArrayList<MaterialStore> resultMaterialStore = new ArrayList<>();
		for (MaterialStore eachMaterialStore : materialList) {
			resultMaterialStore.add(eachMaterialStore);
		}
		

		return this.setStoreMaterialList(resultMaterialStore);
	}

	private void addDetailMat(ArrayList<MaterialDetail> detailMatList, MaterialStore material) {
		material.getDetailMat().addAll(detailMatList.stream().filter(m -> m.getCodOwner().equals(material.getCodOwner())
				&& m.getCodMaterial().equals(material.getCodMaterial())).collect(Collectors.toList()));
	}


	public ArrayList<MaterialStore> getStoreMaterialList() {
		return storeMaterialList;
	}

	public ArrayList<MaterialStore> setStoreMaterialList(ArrayList<MaterialStore> storeMaterialList) {
		this.storeMaterialList = storeMaterialList;
		return storeMaterialList;
	}
	
	
	//TODO: colocar o idioma default em outra classe
	public static class SelectOption {
		public long codOwner;
	    public int codMaterial; 
	    public int codStore;
	    public int codCategory; 
	    public int codType;
	    public String language;
	    
	    public SelectOption() {
	    	this.codOwner = -1;
	    	this.codMaterial = -1;
	    	this.codStore = -1;
	    	this.codCategory = -1;
	    	this.codType = -1;
	    	this.language = "PT";
	    }
	}
}
