package br.com.gda.employee.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import com.google.gson.JsonParseException;

import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.common.SystemMessage;
import br.com.gda.employee.dao.EmpStmtOption;
import br.com.gda.employee.info.EmpWorkTimeInfo;
import br.com.gda.json.JsonResponseMaker;
import br.com.gda.sql.SqlStmtExecutor;

abstract class EmpWorkTimeModelAbstract {
	protected String rawInfo;
	protected List<EmpWorkTimeInfo> workingTimeInfos;
	protected SqlStmtExecutor<EmpWorkTimeInfo> sqlStmtExecutor;
	protected List<EmpStmtOption> sqlStmtOptions = new ArrayList<>();
	protected List<EmpWorkTimeInfo>resultset;
	protected Connection conn;
	protected String schemaName;
	protected Response response;
	
	
	
	protected EmpWorkTimeModelAbstract(String incomingData) {
		initialize();
		this.rawInfo = incomingData;
	}
	
	
	
	protected EmpWorkTimeModelAbstract(EmpWorkTimeInfo workingTimeInfo) {
		initialize();
		this.workingTimeInfos = new ArrayList<>();
		this.workingTimeInfos.add(workingTimeInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	public boolean executeRequest() {
		return tryToExecuteRequest();
	}
	
	
	
	private boolean tryToExecuteRequest() {		
		try {
			parseRawInfoHook();
			checkRequestHook();
			pushRequestToDb();
			buildResultset();
			buildResponse();
			return true;
			
		} catch (JsonParseException e) {
			makeResponse(SystemMessage.ILLEGAL_ARGUMENT, Response.Status.BAD_REQUEST);
			return false;
		} catch (Exception e) {
			makeResponse(SystemMessage.INTERNAL_ERROR, Response.Status.INTERNAL_SERVER_ERROR);
			return false;
		}
	}
	
	
	
	protected void parseRawInfoHook() {
		//Template method: to be overridden by subclasses
	}
	
	
	
	protected void checkRequestHook() {
		//Template method: to be overridden by subclasses
	}
	
	
	
	protected void pushRequestToDb() throws SQLException {
		prepareStatementOption();
		prepareStatementExecutorHook();
		executeStatement();
		commitWork();
	}
	
	
	
	protected void prepareStatementOption() {		
		for (EmpWorkTimeInfo eachInfo : this.workingTimeInfos) {
			EmpStmtOption oneOption = new EmpStmtOption();		
			oneOption.conn = this.conn;
			oneOption.schemaName = this.schemaName;
			oneOption.workingTime = eachInfo;
			this.sqlStmtOptions.add(oneOption);
		}
	}
	
	
	
	protected void prepareStatementExecutorHook() {
		//Template method: to be overwritten by subclasses
	}
	
	
	
	protected void executeStatement() throws SQLException {
		this.sqlStmtExecutor.executeStmt();
	}
	
	
	
	protected void commitWork() throws SQLException {
		try {
			this.conn.commit();
		
		} catch (Exception e) {
			this.conn.rollback();
			throw e;
		}
	}
	
	
	
	private void buildResultset() {
		this.resultset = buildResultsetHook();
	}
	
	
	
	private void buildResponse() {
		if (this.resultset == null || this.resultset.isEmpty()) {
			makeResponse(SystemMessage.EMPLOYEE_DATA_NOT_FOUND, Response.Status.NOT_FOUND);
		} else {
			makeResponse(SystemMessage.RETURNED_SUCCESSFULLY, Response.Status.OK);
		}
			
			
	}
	
	
	
	protected List<EmpWorkTimeInfo> buildResultsetHook() {
		return new ArrayList<EmpWorkTimeInfo>();
	}
	
	
	
	protected void makeResponse(String msg, Response.Status htmlStatus) {
		Object info;
		
		if (htmlStatus.getStatusCode() >= 400) {
			EmpWorkTimeInfo emptyInfo = new EmpWorkTimeInfo();
			info = emptyInfo;
		} else {
			info = this.resultset;
		}		
		
		JsonResponseMaker responseMaker = new JsonResponseMaker(msg, htmlStatus, info);
		this.response = responseMaker.makeResponse();
	}
	
	
	
	public Response getResponse() {
		if (this.response == null)
			throw new IllegalStateException(SystemMessage.NO_RESPONSE);
		
		return this.response;
	}
}
