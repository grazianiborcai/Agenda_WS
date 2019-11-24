package br.com.mind5.business.addressSnapshot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper_;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.dao.obsolete.DaoResultParser_;
import br.com.mind5.dao.obsolete.DaoStmtOption_;

public final class AddresnapInsertSingle implements DaoStmt<AddresnapInfo> {
	private DaoStmt<AddresnapInfo> stmtSql;
	private DaoStmtOption_<AddresnapInfo> stmtOption;
	
	
	
	public AddresnapInsertSingle(Connection conn, AddresnapInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, AddresnapInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption_<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DaoDbTable.ADDRESS_SNAPSHOT_TABLE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = new ParamTranslator();
		this.stmtOption.resultParser = new ResultParser(recordInfo);
		this.stmtOption.whereClause = null;
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper_<>(DaoOperation.INSERT, this.stmtOption, this.getClass());
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

	
	
	@Override public List<AddresnapInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<AddresnapInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, AddresnapInfo recordInfo) throws SQLException {			
			int i = 1;
			
			stmt.setLong(i++, recordInfo.codOwner);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codAddress);
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
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.latitude);	
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.longitude);	
			stmt.setString(i++, recordInfo.line1);
			stmt.setString(i++, recordInfo.line2);
			stmt.setString(i++, recordInfo.line3);
			stmt.setString(i++, recordInfo.line4);
			stmt.setString(i++, recordInfo.line5);
			stmt.setString(i++, recordInfo.line6);
			stmt.setString(i++, recordInfo.line7);
			stmt.setString(i++, recordInfo.recordMode);
			stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);	
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUser);	
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwnerRef);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCustomerSnapshot);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codEmployeeSnapshot);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStoreSnapshot);	
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUserSnapshot);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwnerRefSnapshot);	
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);	
			stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);	

			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<AddresnapInfo> getNewInstance() {
		return new AddresnapInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	private static class ResultParser implements DaoResultParser_<AddresnapInfo> {
		private AddresnapInfo recordInfo;
		
		public ResultParser(AddresnapInfo recordToParse) {
			recordInfo = recordToParse;
		}
		
		
		
		@Override public List<AddresnapInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<AddresnapInfo> finalResult = new ArrayList<>();
			recordInfo.codSnapshot = lastId;
			finalResult.add(recordInfo);			
			return finalResult;
		}
	}
}
