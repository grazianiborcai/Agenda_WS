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
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class ModelHelper<T> implements Model {
	private final boolean RESULT_FAILED = false;
	private final boolean RESULT_SUCCESS = true;
	
	private List<T> recordInfos;
	private SqlStmtExec<T> sqlStmtExecutor;
	private List<T>resultset;
	private Connection conn;
	private String schemaName;
	private Response response;
	private ModelChecker<T> modelChecker;
	private Class<T> infoRecordClass;
	
	
	public ModelHelper(ModelOption<T> option, String incomingData) {
		initialize(option, null);
		parseRawInfo(incomingData);
		buildStmtExec(option.visitorStmtExec);
	}
	
	
	
	public ModelHelper(ModelOption<T> option, T recordInfo) {
		initialize(option, recordInfo);
		this.recordInfos = new ArrayList<>();
		this.recordInfos.add(recordInfo);
		buildStmtExec(option.visitorStmtExec);
	}
	
	
	
	private void initialize(ModelOption<T> option, T recordInfo) {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
		this.modelChecker = option.visitorChecker;
		this.infoRecordClass = option.infoRecordClass;		
	}
	
	
	
	private void parseRawInfo(String rawInfo) {
		JsonToList<T> parser = new JsonToList<>(this.infoRecordClass);
		this.recordInfos = parser.parse(rawInfo);
	}
	
	
	
	private void buildStmtExec(ModelStmtExec<T> modelStmtExec) {
		List<SqlStmtExecOption<T>> stmtExecOptions = new ArrayList<>();
		
		for (T eachRecord : this.recordInfos) {
			SqlStmtExecOption<T> eachExecOption = new SqlStmtExecOption<>();
			eachExecOption.conn = this.conn;
			eachExecOption.recordInfo = eachRecord;
			eachExecOption.schemaName = this.schemaName;
			stmtExecOptions.add(eachExecOption);
		}
		
		this.sqlStmtExecutor = modelStmtExec.getStmtExec(stmtExecOptions);
	}
	

	
	@Override public boolean executeRequest() {
		return tryToExecuteRequest();
	}
	
	
	
	private boolean tryToExecuteRequest() {		
		try {
			boolean resultChecker = checkRequest();
			
			if (resultChecker == RESULT_SUCCESS) { 	
				pushRequestToDb();
				buildResultset();
			}
			
			buildResponse();
			return resultChecker;
			
		} catch (Exception e) {
			makeResponse(SystemMessage.INTERNAL_ERROR, Response.Status.INTERNAL_SERVER_ERROR);
			return RESULT_FAILED;
		}
	}
	
	
	
	private boolean checkRequest() {
		return this.modelChecker.check(this.recordInfos);
	}
	
	
	
	private void pushRequestToDb() throws SQLException {
		executeStatement();
		commitWork();
	}
	
	
	
	private void executeStatement() throws SQLException {
		this.sqlStmtExecutor.executeStmt(); 
	}
	
	
	
	private void commitWork() throws SQLException {
		try {
			this.conn.commit();
		
		} catch (Exception e) {
			this.conn.rollback();
			throw e;
		}
	}
	
	
	
	private void buildResultset() {
		this.resultset = this.sqlStmtExecutor.getResultset(); //###
	}
	
	
	
	private void buildResponse() {		
		if (this.modelChecker.getResult() == RESULT_FAILED) {
			makeResponse(this.modelChecker.getFailureExplanation(), this.modelChecker.getFailureCode(), Response.Status.BAD_REQUEST);
			return;
		}
		
		
		if (this.resultset == null || this.resultset.isEmpty()) {
			makeResponse(SystemMessage.EMPLOYEE_DATA_NOT_FOUND, Response.Status.BAD_REQUEST);
			return;
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
