package br.com.gda.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonBuilder {

	protected static final String OWNER = "Owner";
	protected static final String STORE = "Store";
	protected static final String BILL = "Bill";
	protected static final String BILL_ITEM = "BillItem";

	protected static final String UPDATE_CODE = "updateCode";
	protected static final String UPDATE_MESSAGE = "updateMessage";
	
	protected static final String UPDATE_IMAGE_CODE = "updateImageCode";
	protected static final String UPDATE_IMAGE_MESSAGE = "updateImageMessage";

	protected static final String SELECT_CODE = "selectCode";
	protected static final String SELECT_MESSAGE = "selectMessage";
	// protected static final String COUNT = "count";
	//TODO: encapsular essas mensagens em um Enum
	//TODO: traduzir tudo para Português
	//TODO: substituir constantes por tabela no BD
	public static final String RESULTS = "results";
	public static final String RETURNED_SUCCESSFULLY = "The list was returned successfully";
	public static final String LOGIN_FAILED = "User or password does not match";
	public static final String ILLEGAL_ARGUMENT = "IllegalArgument: mandatory argument might be missing or invalid value was passed";
	public static final String INTERNAL_ERROR = "Ops... something went wrong";
	public static final String FORBIDDEN = "Operation cannot be processed";
	public static final String USER_ALREADY_EXIST = "User datails already taken";
	public static final String STORED_ALREADY_EXIST = "CNPJ already taken";
	public static final String STORE_NOT_FOUND = "Store not found";

	protected static final String UPDATED_PROCESS = "updatedProcess";
	
	protected static final String FILE_UPLOADED = "File uploaded";
	protected static final String FILE_NOT_FOUND = "File not found";
	
	protected static final String JPG = "jpg";
	protected static final String BAR = "/";
	
	
	protected Response makeResponse(String msg, Response.Status htmlStatus, Object dataObj) {
		JsonElement jsonElement = new JsonArray().getAsJsonArray();
		SQLException exception = new SQLException(msg, null, htmlStatus.getStatusCode());		
		jsonElement = new Gson().toJsonTree(dataObj);
		JsonObject jsonObject = getJsonObjectSelect(jsonElement, exception);			
		return response(htmlStatus, jsonObject);
	}
	

	
	protected final JsonObject getJsonObjectUpdate(SQLException e) {

		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty(UPDATE_CODE, e.getErrorCode());
		jsonObject.addProperty(UPDATE_MESSAGE, e.getMessage());

		return jsonObject;
	}
	
	protected final JsonObject getJsonObjectUpdateImage(SQLException e) {

		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty(UPDATE_IMAGE_CODE, e.getErrorCode());
		jsonObject.addProperty(UPDATE_IMAGE_MESSAGE, e.getMessage());

		return jsonObject;
	}

	protected final JsonObject getJsonObjectSelect(JsonElement jsonElement, SQLException e) {

		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty(SELECT_CODE, e.getErrorCode());
		jsonObject.addProperty(SELECT_MESSAGE, e.getMessage());
		// jsonObject.addProperty(COUNT, jsonElement.getAsJsonArray().size());
		jsonObject.add(RESULTS, jsonElement);

		return jsonObject;

	}

	protected final JsonObject getJsonObjectSelect(ArrayList<?> objectList, SQLException e) {

		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty(SELECT_CODE, e.getErrorCode());
		jsonObject.addProperty(SELECT_MESSAGE, e.getMessage());
		// jsonObject.addProperty(COUNT, jsonElement.getAsJsonArray().size());
		jsonObject.add(RESULTS, new Gson().toJsonTree(objectList));

		return jsonObject;

	}

	protected final JsonObject getJsonObjectSelect(JsonElement jsonElement, SQLException e, String process) {

		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty(SELECT_CODE, e.getErrorCode());
		jsonObject.addProperty(SELECT_MESSAGE, e.getMessage());
		jsonObject.addProperty(UPDATED_PROCESS, process);
		// jsonObject.addProperty(COUNT, jsonElement.getAsJsonArray().size());
		jsonObject.add(RESULTS, jsonElement);

		return jsonObject;

	}

	protected final JsonObject mergeJsonObject(JsonObject jOdject01, JsonObject jObject02) {

		for (Map.Entry<String, JsonElement> entry : jObject02.entrySet()) {
			jOdject01.add(entry.getKey(), entry.getValue());
		}

		return jOdject01;
	}
	

	protected final Response responseSuccess(JsonObject jsonObject) {
		return response(Response.Status.OK, jsonObject);
	}
	
	
	protected final Response response(Response.Status status, JsonObject jsonObject) {
		return Response.status(status).entity(jsonObject.toString()).type(MediaType.APPLICATION_JSON)
				.build();
	}

	protected ArrayList<?> jsonToObjectList(String incomingData, Class<?> c) {

		ArrayList<Object> objectList = new ArrayList<Object>();
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();

		if (parser.parse(incomingData).isJsonArray()) {
			JsonArray array = parser.parse(incomingData).getAsJsonArray();

			for (int i = 0; i < array.size(); i++) {
				objectList.add(gson.fromJson(array.get(i), c));
			}
		} else {
			JsonObject object = parser.parse(incomingData).getAsJsonObject();
			objectList.add(gson.fromJson(object, c));
		}

		return objectList;
	}

	protected void sendMessage(ArrayList<?> objectList, SQLException exception, List<?> topicList, String topic,
			String process) {
		Thread t = new Thread(new Runnable() {
			public void run() {
				for (Object eachTopic : topicList) {

					String fullTopic = null;
					String methodAux = null;
					switch (topic) {
					case OWNER:
						methodAux = "getCodOwner";
						fullTopic = OWNER + "/" + eachTopic.toString();
						break;

					case STORE:
						methodAux = "getCodStore";
						fullTopic = STORE + "/" + eachTopic.toString();
						break;

					case BILL:
						methodAux = "getCodBill";
						fullTopic = BILL + "/" + eachTopic.toString();
						break;

					case BILL_ITEM:
						methodAux = "getCodBillItem";
						fullTopic = BILL_ITEM + "/" + eachTopic.toString();
						break;
					}

					String methodS = methodAux;

					Predicate<Object> filter = new Predicate<Object>() {

						@Override
						public boolean test(Object object) {
							boolean test = false;
							try {
								Method method = object.getClass().getMethod(methodS);
								test = method.invoke(object).equals(eachTopic);
							} catch (IllegalAccessException e) {
								e.printStackTrace();
							} catch (IllegalArgumentException e) {
								e.printStackTrace();
							} catch (InvocationTargetException e) {
								e.printStackTrace();
							} catch (NoSuchMethodException e) {
								e.printStackTrace();
							} catch (SecurityException e) {
								e.printStackTrace();
							}

							return test;
						}
					};

					JsonObject jsonObject = getJsonObjectSelect(
							new Gson().toJsonTree(objectList.stream().filter(filter).collect(Collectors.toList())),
							exception, process);
					//ServletContainerGDA.publisher.publishMessage(jsonObject.toString(), fullTopic.toString());
				}
			}
		});
		t.start();
	}

}
