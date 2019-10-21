package br.com.mind5.json.standard;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import br.com.mind5.json.JsonResponseMakerTemplate;



public class JstdResponseMaker extends JsonResponseMakerTemplate {
	private static final String RETURN_CODE = "returnCode";
	private static final String RETURN_MESSAGE = "returnMessage";
	private static final String RESULTS = "results";	
	
	
	public JstdResponseMaker() {
		super(JstdResponseMaker.class);
	}
	
	
	
	@Override protected Response makeResponseHook(String msg, int msgCode, Response.Status htmlStatus, Object dataObj) {
		JsonElement jData = parseData(dataObj);
		JsonObject jObj = addMsgToParsedData(msg, msgCode, jData);
		return generateResponse(htmlStatus, jObj);
	}
	
	
	
	private JsonElement parseData(Object dataObj) {
		Gson gson = new GsonBuilder().setExclusionStrategies(new JstdAttrExclusion()).create();
		return gson.toJsonTree(dataObj);
	}
	
	
	
	private JsonObject addMsgToParsedData(String msg, int msgCode, JsonElement jElement) {
		JsonObject jObject = new JsonObject();
		jObject.addProperty(RETURN_CODE, msgCode);
		jObject.addProperty(RETURN_MESSAGE, msg);
		jObject.add(RESULTS, jElement);
		return jObject;
	}
	
	
	
	private Response generateResponse(Response.Status htmlStatus, JsonObject jsonObject) {
		return Response.status(htmlStatus)
				       .entity(jsonObject.toString())
				       .type(MediaType.APPLICATION_JSON)
				       .build();
	}
}
