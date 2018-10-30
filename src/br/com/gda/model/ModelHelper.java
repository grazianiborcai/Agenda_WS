package br.com.gda.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.core.Response;

import br.com.gda.common.DbConnection;
import br.com.gda.common.SystemMessage;
import br.com.gda.json.JsonResponseMaker;
import br.com.gda.json.JsonToList;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;

public class ModelHelper<T> implements Model {
	private final boolean RESULT_FAILED = false;
	private final boolean RESULT_SUCCESS = true;
	
	private List<T> recordInfos;	
	private Connection conn;
	private String schemaName;
	private Response response;
	private DeciTree<T> decisionTree;
	private List<DeciResult<T>> treeResults;
	private DeciTreeFactory<T> treeFactory;
	private Iterator<T> infoRecordItr;
	private T currentRecordInfo;
	private DeciResult<T> currentTreeResult;
	
	
	
	public static <T> Model factory(ModelOption<T> option, String incomingData) {
		try {
			return new ModelHelper<T>(option, incomingData);
		} catch (Exception e) {
			return new ModelDummyFailed();
		}
	}
	
	
	
	public static <T> Model factory(ModelOption<T> option, T recordInfo) {
		try {
			return new ModelHelper<T>(option, recordInfo);
		} catch (Exception e) {
			return new ModelDummyFailed();
		}
	}
	
	
	
	private ModelHelper(ModelOption<T> option, String incomingData) {		
		checkArgument(option, incomingData);
		List<T> parsedRecordInfos = parseRawInfo(incomingData, option.infoRecordClass);
		initialize(option, parsedRecordInfos);	
	}
	
	

	private ModelHelper(ModelOption<T> option, T recordInfo) {
		checkArgument(option, recordInfo);
		List<T> requestedRecordInfos = new ArrayList<>();
		requestedRecordInfos.add(recordInfo);
		initialize(option, requestedRecordInfos);	
	}
	
	
	
	private void checkArgument(ModelOption<T> option, String incomingData) {
		if (incomingData == null)
			throw new NullPointerException("incomingData" + SystemMessage.NULL_ARGUMENT);
		
		checkOption(option);
	}
	
	
	
	private void checkArgument(ModelOption<T> option, T recordInfo) {
		if (recordInfo == null)
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		
		checkOption(option);
	}
	
	
	
	private void checkOption(ModelOption<T> option) {
		if (option == null)
			throw new NullPointerException("option" + SystemMessage.NULL_ARGUMENT);
		
		if (option.infoRecordClass == null)
			throw new NullPointerException("option.infoRecordClass" + SystemMessage.NULL_ARGUMENT);
		
		if (option.decisionTreeFactory == null)
			throw new NullPointerException("option.decisionTreeFactory" + SystemMessage.NULL_ARGUMENT);
		
		if (option.conn == null)
			throw new NullPointerException("option.conn" + SystemMessage.NULL_ARGUMENT);
		
		if (option.schemaName == null)
			throw new NullPointerException("option.schemaName" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	private List<T> parseRawInfo(String rawInfo, Class<T> infoRecordClass) {
		JsonToList<T> parser = new JsonToList<>(infoRecordClass);
		return parser.parse(rawInfo);
	}
	
	
	
	private void initialize(ModelOption<T> option, List<T> recordInfos) {
		this.conn = option.conn;
		this.schemaName = option.schemaName;
		this.treeFactory = option.decisionTreeFactory;
		this.recordInfos = recordInfos;	
		this.infoRecordItr = this.recordInfos.iterator();
		this.treeResults = new ArrayList<>();
	}

	
	
	@Override public boolean executeRequest() {
		return tryToExecuteRequest();
	}
	
	
	
	private boolean tryToExecuteRequest() {				
		try {
			while (infoRecordItr.hasNext()) {
				currentRecordInfo = infoRecordItr.next();
				
				buildDecisionTree();
				makeDecision();
				
				if (currentTreeResult.isSuccess() == RESULT_FAILED)
					break;
			}
			
			closeTransaction();
			buildResponse();
			
			return currentTreeResult.isSuccess();
			
		} catch (Exception e) {
			makeResponse(SystemMessage.INTERNAL_ERROR, Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Response.Status.INTERNAL_SERVER_ERROR);
			return RESULT_FAILED;
		}
	}
	
	
	
	private void buildDecisionTree() {
		DeciTreeOption<T> treeOption = new DeciTreeOption<>();
		
		List<T> currentRecordInfos = new ArrayList<>();
		currentRecordInfos.add(this.currentRecordInfo);
		
		treeOption.conn = this.conn;
		treeOption.recordInfos = currentRecordInfos;
		treeOption.schemaName = this.schemaName;
		
		this.decisionTree = this.treeFactory.getInstance(treeOption);
	}
	
	
	
	private void makeDecision() {
		decisionTree.makeDecision();
		
		currentTreeResult = decisionTree.getDecisionResult();
		treeResults.add(currentTreeResult);
	}
	
	
	
	private void closeTransaction() throws SQLException {
		if (this.currentTreeResult.isSuccess() == RESULT_SUCCESS) 
			commitWork();
			
		if (this.currentTreeResult.isSuccess() == RESULT_FAILED) 
			rollback();
		
		DbConnection.closeConnection(this.conn);
	}
	
	
	
	private void commitWork() throws SQLException {
		try {
			this.conn.commit();
		
		} catch (Exception e) {
			rollback();
			throw e;
		}
	}
	
	
	
	private void rollback() throws SQLException {
		this.conn.rollback();
	}
	
	
	
	private void buildResponse() {		
		if (this.currentTreeResult.isSuccess() == RESULT_FAILED) 
			makeResponseFailed();
		
		
		if (this.currentTreeResult.isSuccess() == RESULT_SUCCESS)
			makeResponseSuccess();
	}
	
	
	
	private void makeResponseFailed() {
		Response.Status htmlStatus = Response.Status.BAD_REQUEST;
		
		if (this.currentTreeResult.getFailCode() == Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
			htmlStatus = Response.Status.INTERNAL_SERVER_ERROR;
		
		makeResponse(this.currentTreeResult.getFailMessage(), this.currentTreeResult.getFailCode(), htmlStatus);
	}
	
	
	
	private void makeResponseSuccess() {
		List<T> allResultset = new ArrayList<>();
		
		for (DeciResult<T> eachTreeResult : this.treeResults) {
			if (eachTreeResult.hasResultset()) {
				List<T> eachResultset = eachTreeResult.getResultset();
				allResultset.addAll(eachResultset);
			}
		}
		
		makeResponse(SystemMessage.RETURNED_SUCCESSFULLY, Response.Status.OK.getStatusCode(), Response.Status.OK, allResultset);
	}
	
	
	
	private void makeResponse(String msg, int msgCode, Response.Status htmlStatus) {		
		makeResponse(msg, msgCode, htmlStatus, new Object());
	}
	
	
	
	private void makeResponse(String msg, int msgCode, Response.Status htmlStatus, Object bodyMsg) {		
		JsonResponseMaker responseMaker = new JsonResponseMaker(msg, msgCode, htmlStatus, bodyMsg);
		this.response = responseMaker.makeResponse();
	}
	
	
	
	public Response getResponse() {
		if (this.response == null)
			throw new IllegalStateException(SystemMessage.NO_RESPONSE);
		
		return this.response;
	}
}
