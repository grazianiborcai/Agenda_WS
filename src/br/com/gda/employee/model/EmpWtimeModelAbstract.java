package br.com.gda.employee.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.common.SystemMessage;
import br.com.gda.employee.dao.EmpStmtOption;
import br.com.gda.employee.info.EmpWtimeInfo;
import br.com.gda.json.JsonResponseMaker;
import br.com.gda.json.JsonToList;
import br.com.gda.model.checker.ModelCheckerAbstract;
import br.com.gda.sql.SqlStmtExecutor;

abstract class EmpWtimeModelAbstract {
	protected final boolean RESULT_FAILED = false;
	protected final boolean RESULT_SUCCESS = true;
	
	private List<EmpWtimeInfo> recordInfos;
	private SqlStmtExecutor<EmpWtimeInfo> sqlStmtExecutor;
	private List<EmpStmtOption> sqlStmtOptions = new ArrayList<>();
	private List<EmpWtimeInfo>resultset;
	private Connection conn;
	private String schemaName;
	private Response response;
	private ModelCheckerAbstract<EmpWtimeInfo> modelChecker;
	
	
	
	protected EmpWtimeModelAbstract(String incomingData) {
		initialize();
		parseRawInfo(incomingData);
	}
	
	
	
	protected EmpWtimeModelAbstract(EmpWtimeInfo workingTimeInfo) {
		initialize();
		this.recordInfos = new ArrayList<>();
		this.recordInfos.add(workingTimeInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
		this.modelChecker = buildModelCheckerHook();
	}
	
	
	
	protected ModelCheckerAbstract<EmpWtimeInfo> buildModelCheckerHook() {
		//Template Method: to be overwritten by subclasses
		return null;
	}
	
	
	
	private void parseRawInfo(String rawInfo) {
		JsonToList<EmpWtimeInfo> parser = new JsonToList<>(EmpWtimeInfo.class);
		this.recordInfos = parser.parse(rawInfo);
	}
	
	
	
	public boolean executeRequest() {
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
		prepareStatementOption();
		this.sqlStmtExecutor = prepareStatementExecutorHook(sqlStmtOptions);
		executeStatement();
		commitWork();
	}
	
	
	
	private void prepareStatementOption() {		
		for (EmpWtimeInfo eachInfo : this.recordInfos) {
			EmpStmtOption oneOption = new EmpStmtOption();		
			oneOption.conn = this.conn;
			oneOption.schemaName = this.schemaName;
			oneOption.workingTime = eachInfo;
			this.sqlStmtOptions.add(oneOption);
		}
	}
	
	
	
	protected SqlStmtExecutor<EmpWtimeInfo> prepareStatementExecutorHook(List<EmpStmtOption> sqlStmtOptions) {
		//Template method: to be overwritten by subclasses
		return null;
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
		this.resultset = buildResultsetHook(recordInfos);
	}
	
	
	
	protected List<EmpWtimeInfo> buildResultsetHook(List<EmpWtimeInfo> workingTimeInfos) {
		//Template method: to be overwritten by subclasses
		return this.sqlStmtExecutor.getResultset();
	}
	
	
	
	private void buildResponse() {		
		if (this.modelChecker.getResult() == RESULT_FAILED) {
			makeResponse(this.modelChecker.getFailureExplanation(), this.modelChecker.getFailureCode(), Response.Status.BAD_REQUEST);
			return;
		}
		
		
		if (this.resultset == null || this.resultset.isEmpty()) {
			makeResponse(SystemMessage.EMPLOYEE_DATA_NOT_FOUND, Response.Status.NOT_FOUND);
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
			EmpWtimeInfo emptyInfo = new EmpWtimeInfo();
			infoRecord = emptyInfo;
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
