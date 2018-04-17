package br.com.gda.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
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
	private List<T> resultset;
	private Connection conn;
	private String schemaName;
	private Response response;
	private Class<T> infoRecordClass;
	private DecisionTree<T> decisionTree;
	private DecisionResult<T> treeResult;
	
	
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
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
		this.infoRecordClass = option.infoRecordClass;		
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
			buildResultset();
			buildResponse();
			
			return treeResult.hasSuccessfullyFinished();
			
		} catch (Exception e) {
			makeResponse(SystemMessage.INTERNAL_ERROR, Response.Status.INTERNAL_SERVER_ERROR);
			return RESULT_FAILED;
		}
	}
	
	
	
	private void closeTransaction() throws SQLException {
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
			this.conn.rollback();
			throw e;
		}
	}
	
	
	
	private void rollback() throws SQLException {
		try {
			this.conn.rollback();
		
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	
	private void buildResultset() {
		this.resultset = new ArrayList<>();
		
		if (this.treeResult.hasResultset())
		  this.resultset = this.treeResult.getResultset();
	}
	
	
	
	private void buildResponse() {		
		if (this.treeResult.hasSuccessfullyFinished() == RESULT_FAILED) {
			makeResponse(this.treeResult.getFailureMessage(), this.treeResult.getFailureCode(), Response.Status.BAD_REQUEST);
			return;
		}
		
		
		if (this.treeResult.hasResultset()) {
			if (this.resultset == null || this.resultset.isEmpty()) {
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
		Object infoRecord;
		
		if (htmlStatus.getStatusCode() >= 400) {
			infoRecord = new Object();
		} else {
			infoRecord = this.resultset;
		}		
		
		JsonResponseMaker responseMaker = new JsonResponseMaker(msg, msgCode, htmlStatus, infoRecord);
		this.response = responseMaker.makeResponse();
	}
	
	
	
	public Response getResponse() {
		if (this.response == null)
			throw new IllegalStateException(SystemMessage.NO_RESPONSE);
		
		return this.response;
	}
}
