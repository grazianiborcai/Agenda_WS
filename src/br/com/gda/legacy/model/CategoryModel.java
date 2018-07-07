package br.com.gda.legacy.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import br.com.gda.helper.Category;
import br.com.gda.legacy.dao.CategoryDAO;

public class CategoryModel extends JsonBuilder {

	public ArrayList<Category> selectCategory(List<Integer> codCategory,
			List<String> language, List<String> name) throws SQLException {

		return new CategoryDAO().selectCategory(codCategory, language,
				name);
	}

	public JsonObject selectCategoryJson(List<Integer> codCategory,
			List<String> language, List<String> name) {

		JsonElement jsonElement = new JsonArray().getAsJsonArray();
		SQLException exception = new SQLException(RETURNED_SUCCESSFULLY, null,
				200);

		try {

			jsonElement = new Gson().toJsonTree(selectCategory(codCategory,
					language, name));

		} catch (SQLException e) {
			exception = e;
		}

		JsonObject jsonObject = getJsonObjectSelect(jsonElement, exception);

		return jsonObject;
	}

	public Response selectCategoryResponse(List<Integer> codCategory,
			List<String> language, List<String> name) {

		return responseSuccess(selectCategoryJson(codCategory, language, name));
	}

}
