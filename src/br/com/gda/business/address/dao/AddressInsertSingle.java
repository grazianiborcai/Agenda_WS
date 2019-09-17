package br.com.gda.business.address.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtParamTranslator;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public final class AddressInsertSingle implements DaoStmt<AddressInfo> {
	private DaoStmt<AddressInfo> stmtSql;
	private DaoStmtOption<AddressInfo> stmtOption;
	
	
	
	public AddressInsertSingle(Connection conn, AddressInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, AddressInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DaoDbTable.ADDRESS_TABLE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = new ParamTranslator();
		this.stmtOption.resultParser = new ResultParser(recordInfo);
		this.stmtOption.whereClause = null;
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.INSERT, this.stmtOption, this.getClass());
	}
		
	
	
	@Override public void generateStmt() throws SQLException {
		stmtSql.generateStmt();		
	}

	
	
	@Override public boolean checkStmtGeneration() {
		return stmtSql.checkStmtGeneration();
	}

	
	
	@Override public void executeStmt() throws SQLException {
		stmtSql.executeStmt();
	}

	
	
	@Override public List<AddressInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<AddressInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, AddressInfo recordInfo) throws SQLException {			
			int i = 1;
			
			stmt.setLong(i++, recordInfo.codOwner);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCustomer);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codEmployee);			
			stmt.setString(i++, recordInfo.codCountry);
			stmt.setString(i++, recordInfo.codState);
			stmt.setString(i++, recordInfo.city);
			stmt.setString(i++, recordInfo.district);
			stmt.setString(i++, recordInfo.street);
			stmt.setString(i++, recordInfo.streetNumber);
			stmt.setString(i++, recordInfo.complement);
			stmt.setString(i++, recordInfo.postalCode);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.latitude);	
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.longitude);	
			stmt.setString(i++, recordInfo.line1);
			stmt.setString(i++, recordInfo.line2);
			stmt.setString(i++, recordInfo.line3);
			stmt.setString(i++, recordInfo.line4);
			stmt.setString(i++, recordInfo.line5);
			stmt.setString(i++, recordInfo.line6);
			stmt.setString(i++, recordInfo.line7);
			stmt.setString(i++, recordInfo.recordMode);
			DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);	
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUser);	
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwnerRef);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codSnapshot);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCustomerSnapshot);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codEmployeeSnapshot);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStoreSnapshot);	
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUserSnapshot);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwnerRefSnapshot);			

			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<AddressInfo> getNewInstance() {
		return new AddressInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<AddressInfo> {
		private AddressInfo recordInfo;
		
		public ResultParser(AddressInfo recordToParse) {
			recordInfo = recordToParse;
		}
		
		
		
		@Override public List<AddressInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<AddressInfo> finalResult = new ArrayList<>();
			recordInfo.codAddress = lastId;
			finalResult.add(recordInfo);			
			return finalResult;
		}
	}
}
