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
	
	
	public ModelHelper(ModelOption<T> option, String incomingData) {		
		List<T> parsedRecordInfos = parseRawInfo(incomingData, option.infoRecordClass);
		initialize(option, parsedRecordInfos);		
	}
	
	
	
	public ModelHelper(ModelOption<T> option, T recordInfo) {
		List<T> requestedRecordInfos = new ArrayList<>();
		requestedRecordInfos.add(recordInfo);
		initialize(option, requestedRecordInfos);	
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
				
				if (currentTreeResult.hasSuccessfullyFinished() == RESULT_FAILED)
					break;
			}
			
			closeTransaction();
			buildResponse();
			
			return currentTreeResult.hasSuccessfullyFinished();
			
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
		
		this.decisionTree = this.treeFactory.getDecisionTree(treeOption);
	}
	
	
	
	private void makeDecision() {
		decisionTree.makeDecision();
		
		currentTreeResult = decisionTree.getDecisionResult();
		treeResults.add(currentTreeResult);
	}
	
	
	
	private void closeTransaction() throws SQLException {
		if (this.currentTreeResult.hasSuccessfullyFinished() == RESULT_SUCCESS) 
			commitWork();
			
		if (this.currentTreeResult.hasSuccessfullyFinished() == RESULT_FAILED) 
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
		if (this.currentTreeResult.hasSuccessfullyFinished() == RESULT_FAILED) 
			makeResponseFailed();
		
		
		if (this.currentTreeResult.hasSuccessfullyFinished() == RESULT_SUCCESS)
			makeResponseSuccess();
	}
	
	
	
	private void makeResponseFailed() {
		Response.Status htmlStatus = Response.Status.BAD_REQUEST;
		
		if (this.currentTreeResult.getFailureCode() == Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
			htmlStatus = Response.Status.INTERNAL_SERVER_ERROR;
		
		makeResponse(this.currentTreeResult.getFailureMessage(), this.currentTreeResult.getFailureCode(), htmlStatus);
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
