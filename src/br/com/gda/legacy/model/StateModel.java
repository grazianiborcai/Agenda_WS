package br.com.gda.legacy.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import br.com.gda.helper.State;
import br.com.gda.legacy.dao.StateDAO;

public class StateModel extends JsonBuilder {

	public ArrayList<State> selectState(List<String> country,
			List<String> state, List<String> language, List<String> name)
			throws SQLException {

		return new StateDAO().selectState(country, state, language, name);
	}

	public JsonObject selectStateJson(List<String> country, List<String> state,
			List<String> language, List<String> name) {

		JsonElement jsonElement = new JsonArray().getAsJsonArray();
		SQLException exception = new SQLException(RETURNED_SUCCESSFULLY, null,
				200);

		try {

			jsonElement = new Gson().toJsonTree(selectState(country, state,
					language, name));

		} catch (SQLException e) {
			exception = e;
		}

		JsonObject jsonObject = getJsonObjectSelect(jsonElement, exception);

		return jsonObject;
	}

	public Response selectStateResponse(List<String> country,
			List<String> state, List<String> language, List<String> name) {

		return responseSuccess(selectStateJson(country, state, language, name));
	}

}
