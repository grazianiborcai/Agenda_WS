package br.com.gda.model.legacy;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import br.com.gda.dao.GenderDAO;
import br.com.gda.helper.Gender;

public class GenderModel extends JsonBuilder {

	public ArrayList<Gender> selectGender(List<Integer> codGender,
			List<String> language, List<String> name) throws SQLException {

		return new GenderDAO().selectGender(codGender, language, name);
	}

	public JsonObject selectGenderJson(List<Integer> codGender,
			List<String> language, List<String> name) {

		JsonElement jsonElement = new JsonArray().getAsJsonArray();
		SQLException exception = new SQLException(RETURNED_SUCCESSFULLY, null,
				200);

		try {

			jsonElement = new Gson().toJsonTree(selectGender(codGender,
					language, name));

		} catch (SQLException e) {
			exception = e;
		}

		JsonObject jsonObject = getJsonObjectSelect(jsonElement, exception);

		return jsonObject;
	}

	public Response selectGenderResponse(List<Integer> codGender,
			List<String> language, List<String> name) {

		return responseSuccess(selectGenderJson(codGender, language, name));
	}

}
