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
import br.com.gda.employee.dao.EmployeeStmtOption;
import br.com.gda.employee.dao.EmployeeWorkingTimeStmtInsert;
import br.com.gda.employee.info.EmployeeWorkingTimeInfo;
import br.com.gda.json.JsonResponseMaker;
import br.com.gda.json.JsonToList;

public class EmployeeWorkingTimeInsert {
	private final String rawInfo;
	private List<EmployeeWorkingTimeInfo> workingTimeInfos;
	private List<EmployeeWorkingTimeStmtInsert> sqlStatements = new ArrayList<>();
	private final Connection conn;
	private final String schemaName;
	private Response response;
	
	
	public EmployeeWorkingTimeInsert(String incomingData) {
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
			insertOnDb();
		
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
		JsonToList<EmployeeWorkingTimeInfo> parser = new JsonToList<>(EmployeeWorkingTimeInfo.class);
		workingTimeInfos = parser.parse(this.rawInfo);
	}
	
	
	
	private void insertOnDb() throws SQLException {
		//TODO: colocar em uma outra classe
		prepareStatement();
		checkStatement();
		generateStatement();
		executeStatement();
		commitWork();
	}
	
	
	
	private void prepareStatement() {
		EmployeeStmtOption option = new EmployeeStmtOption();
		option.conn = this.conn;
		option.schemaName = this.schemaName;
		
		this.sqlStatements = new ArrayList<>();
		
		for (EmployeeWorkingTimeInfo eachInfo : this.workingTimeInfos) {
			option.workingTime = eachInfo;
			EmployeeWorkingTimeStmtInsert sqlStatement = new EmployeeWorkingTimeStmtInsert(option);
			this.sqlStatements.add(sqlStatement);
		}
	}
	
	
	
	private void checkStatement() {
		for (EmployeeWorkingTimeStmtInsert eachStatement : this.sqlStatements) {
			if (! eachStatement.checkStatementGeneration())
				throw new IllegalStateException(SystemMessage.REQUEST_FAILED);
		}
	}
	
	
	
	private void generateStatement() throws SQLException {
		for (EmployeeWorkingTimeStmtInsert eachStatement : this.sqlStatements) {
			eachStatement.generateStmt();
		}
	}
	
	
	
	private void executeStatement() throws SQLException {
		for (EmployeeWorkingTimeStmtInsert eachStatement : this.sqlStatements) {
			eachStatement.executeStatement();
		}
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
			EmployeeWorkingTimeInfo emptyInfo = new EmployeeWorkingTimeInfo();
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