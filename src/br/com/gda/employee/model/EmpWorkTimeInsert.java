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
import br.com.gda.employee.dao.EmpWorkTimeStmtExecInsert;
import br.com.gda.employee.info.EmpWorkTimeInfo;
import br.com.gda.json.JsonResponseMaker;
import br.com.gda.json.JsonToList;
import br.com.gda.sql.SqlStmtExecutor;

public class EmpWorkTimeInsert {
	private final String rawInfo;
	private List<EmpWorkTimeInfo> workingTimeInfos;
	private SqlStmtExecutor sqlStatemetExecutor;
	private List<EmpStmtOption> sqlStatemetOptions = new ArrayList<>();
	private final Connection conn;
	private final String schemaName;
	private Response response;
	
	
	public EmpWorkTimeInsert(String incomingData) {
		this.rawInfo = incomingData;
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	public boolean insert() {
		return tryToInsert();
	}
	
	
	
	private boolean tryToInsert() {		
		try {
			parseRawInfo();
			insertIntoDb();
		
			makeResponse(SystemMessage.RETURNED_SUCCESSFULLY, Response.Status.OK);
			return true;
			
		} catch (JsonParseException e) {
			makeResponse(SystemMessage.ILLEGAL_ARGUMENT, Response.Status.BAD_REQUEST);
			return false;
		} catch (Exception e) {
			makeResponse(SystemMessage.INTERNAL_ERROR, Response.Status.INTERNAL_SERVER_ERROR);
			return false;
		}
	}
	
	
	
	private void parseRawInfo() {
		JsonToList<EmpWorkTimeInfo> parser = new JsonToList<>(EmpWorkTimeInfo.class);
		workingTimeInfos = parser.parse(this.rawInfo);
	}
	
	
	
	private void insertIntoDb() throws SQLException {
		prepareStatementOption();
		prepareStatementExecutor();
		executeStatement();
		commitWork();
	}
	
	
	
	private void prepareStatementOption() {		
		for (EmpWorkTimeInfo eachInfo : this.workingTimeInfos) {
			EmpStmtOption oneOption = new EmpStmtOption();		
			oneOption.conn = this.conn;
			oneOption.schemaName = this.schemaName;
			oneOption.workingTime = eachInfo;
			this.sqlStatemetOptions.add(oneOption);
		}
	}
	
	
	
	private void prepareStatementExecutor() {
		this.sqlStatemetExecutor = new EmpWorkTimeStmtExecInsert(this.sqlStatemetOptions);
	}
	
	
	
	private void executeStatement() throws SQLException {
		this.sqlStatemetExecutor.executeStmt();
	}
	
	
	
	private void commitWork() throws SQLException {
		try {
			this.conn.commit();
		
		} catch (Exception e) {
			this.conn.rollback();
			throw e;
		}
	}
	
	
	
	private void makeResponse(String msg, Response.Status htmlStatus) {
		Object info;
		
		if (htmlStatus.getStatusCode() >= 400) {
			EmpWorkTimeInfo emptyInfo = new EmpWorkTimeInfo();
			info = emptyInfo;
		} else {
			info = this.workingTimeInfos;
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