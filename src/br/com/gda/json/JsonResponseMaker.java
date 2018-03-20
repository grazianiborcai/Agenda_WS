package br.com.gda.json;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;



public class JsonResponseMaker {
	private static final String SELECT_CODE = "selectCode";
	private static final String SELECT_MESSAGE = "selectMessage";
	private static final String RESULTS = "results";
	
	private JsonObject jsonObject = null;
	private JsonElement jsonElement = null;
	private String msg;
	private int msgCode;
	private Response.Status htmlStatus;
	private Object dataObj;
	
	
	
	public JsonResponseMaker(String msg, Response.Status htmlStatus, Object dataObj) {
		this(msg, htmlStatus.getStatusCode(), htmlStatus, dataObj);
	}
	
	
	
	public JsonResponseMaker(String msg, int msgCode, Response.Status htmlStatus, Object dataObj) {
		this.msg = msg;
		this.msgCode = msgCode;
		this.htmlStatus = htmlStatus;
		this.dataObj = dataObj; //TODO: defensive copy		
	}
	
	
	
	public Response makeResponse() {		
		buildJson();
		addMessage();
		return generateResponse();
	}
	
	
	
	private void buildJson() {
		this.jsonElement = new Gson().toJsonTree(this.dataObj);
	}
	
	
	
	private void addMessage() {
		this.jsonObject = new JsonObject();
		this.jsonObject.addProperty(SELECT_CODE, this.msgCode);
		this.jsonObject.addProperty(SELECT_MESSAGE, this.msg);
		this.jsonObject.add(RESULTS, jsonElement);
	}
	
	
	
	private Response generateResponse() {
		return Response.status(this.htmlStatus).entity(this.jsonObject.toString()).type(MediaType.APPLICATION_JSON)
				.build();
	}
}
