package br.com.gda.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import br.com.gda.common.DbConnection;
import br.com.gda.common.SystemMessage;
import br.com.gda.json.JsonResponseMaker;
import br.com.gda.json.JsonToList;
import br.com.gda.model.decisionTree.DecisionResult;
import br.com.gda.model.decisionTree.DecisionTree;
import br.com.gda.model.decisionTree.DecisionTreeFactory;
import br.com.gda.model.decisionTree.DecisionTreeOption;

public final class ModelHelperV2<T> implements Model {
	private final boolean RESULT_FAILED = false;
	private final boolean RESULT_SUCCESS = true;
	
	private List<T> recordInfos;	
	private Connection conn;
	private String schemaName;
	private Response response;
	private Class<T> infoRecordClass;
	private DecisionTree<T> decisionTree;
	private DecisionResult<T> treeResult;
	private boolean closeTransaction;
	
	
	public ModelHelperV2(ModelOptionV2<T> option, String incomingData) {
		initialize(option, null);
		parseRawInfo(incomingData);
		buildDecisionTree(option.decisionTreeFactory);
	}
	
	
	
	public ModelHelperV2(ModelOptionV2<T> option, T recordInfo) {
		initialize(option, recordInfo);
		this.recordInfos = new ArrayList<>();
		this.recordInfos.add(recordInfo);		
		buildDecisionTree(option.decisionTreeFactory);
	}
	
	
	
	private void initialize(ModelOptionV2<T> option, T recordInfo) {
		this.conn = option.conn;
		this.schemaName = option.schemaName;
		this.infoRecordClass = option.infoRecordClass;
		this.closeTransaction = option.closeTransaction;
	}
	
	
	
	private void parseRawInfo(String rawInfo) {
		JsonToList<T> parser = new JsonToList<>(this.infoRecordClass);
		this.recordInfos = parser.parse(rawInfo);
	}
	
	
	
	private void buildDecisionTree(DecisionTreeFactory<T> treeFactory) {
		DecisionTreeOption<T> treeOption = new DecisionTreeOption<>();
		
		treeOption.conn = this.conn;
		treeOption.recordInfos = this.recordInfos;
		treeOption.schemaName = this.schemaName;
		
		this.decisionTree = treeFactory.getDecisionTree(treeOption);
	}
	

	
	@Override public boolean executeRequest() {
		return tryToExecuteRequest();
	}
	
	
	
	private boolean tryToExecuteRequest() {		
		try {
			this.decisionTree.makeDecision();
			this.treeResult = this.decisionTree.getDecisionResult();			
			
			closeTransaction();
			buildResponse();
			
			return treeResult.hasSuccessfullyFinished();
			
		} catch (Exception e) {
			makeResponse(SystemMessage.INTERNAL_ERROR, Response.Status.INTERNAL_SERVER_ERROR);
			return RESULT_FAILED;
		}
	}
	
	
	
	private void closeTransaction() throws SQLException {
	/*	boolean DONT_CLOSE_TRANSACTION = false;
		
		if (closeTransaction == DONT_CLOSE_TRANSACTION)
			return; */
		
		if (treeResult.hasSuccessfullyFinished() == RESULT_SUCCESS) 
			commitWork();
			
		if (treeResult.hasSuccessfullyFinished() == RESULT_FAILED) 
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
		if (this.treeResult.hasSuccessfullyFinished() == RESULT_FAILED && this.treeResult.getFailureCode() == Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()) {
			makeResponse(this.treeResult.getFailureMessage(), this.treeResult.getFailureCode(), Response.Status.INTERNAL_SERVER_ERROR);
			return;
		}
		
		
		if (this.treeResult.hasSuccessfullyFinished() == RESULT_FAILED) {
			makeResponse(this.treeResult.getFailureMessage(), this.treeResult.getFailureCode(), Response.Status.BAD_REQUEST);
			return;
		}
		
		
		if (this.treeResult.hasResultset()) {
			List<T> resultset = this.treeResult.getResultset();
					
			if (resultset == null || resultset.isEmpty()) {
				makeResponse(SystemMessage.DATA_NOT_FOUND, Response.Status.BAD_REQUEST);
				return;
			}
		}
			
		
		makeResponse(SystemMessage.RETURNED_SUCCESSFULLY, Response.Status.OK);
	}
	
	
	
	private void makeResponse(String msg, Response.Status htmlStatus) {
		makeResponse(msg, htmlStatus.getStatusCode(), htmlStatus);
	}
	
	
	
	private void makeResponse(String msg, int msgCode, Response.Status htmlStatus) {
		final int ERROR_RANGER_MIN = 400;		
		Object infoRecord = new Object();
		
		if (htmlStatus.getStatusCode() < ERROR_RANGER_MIN && this.treeResult.hasResultset())
			infoRecord = this.treeResult.getResultset();
		
		JsonResponseMaker responseMaker = new JsonResponseMaker(msg, msgCode, htmlStatus, infoRecord);
		this.response = responseMaker.makeResponse();
	}
	
	
	
	public Response getResponse() {
		if (this.response == null)
			throw new IllegalStateException(SystemMessage.NO_RESPONSE);
		
		return this.response;
	}
}
