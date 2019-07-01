package br.com.gda.payment.customerPartner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtParamTranslator;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;
import br.com.gda.payment.customerPartner.info.CusparInfo;

public final class CusparInsertSingle implements DaoStmt<CusparInfo> {
	private DaoStmt<CusparInfo> stmtSql;
	private DaoStmtOption<CusparInfo> stmtOption;
	
	
	
	public CusparInsertSingle(Connection conn, CusparInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, CusparInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DaoDbTable.PAY_CUS_TABLE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = new ParamTranslator();
		this.stmtOption.resultParser = new ResultParser(recordInfo);
		this.stmtOption.whereClause = null;
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.INSERT, this.stmtOption);
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

	
	
	@Override public List<CusparInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<CusparInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, CusparInfo recordInfo) throws SQLException {
			
			Timestamp lastChanged = null;
			if(recordInfo.lastChanged != null)
				lastChanged = Timestamp.valueOf((recordInfo.lastChanged));
			
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			stmt.setLong(i++, recordInfo.codUser);
			
			
			if (recordInfo.codUserSnapshot >= 0) {
				stmt.setLong(i++, recordInfo.codUserSnapshot);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}	
			
			
			if (recordInfo.codCustomer >= 0) {
				stmt.setLong(i++, recordInfo.codCustomer);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}	
			
			
			if (recordInfo.codCustomerSnapshot >= 0) {
				stmt.setLong(i++, recordInfo.codCustomerSnapshot);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}	

			
			stmt.setTimestamp(i++, lastChanged);	
			stmt.setString(i++, recordInfo.recordMode);
			stmt.setLong(i++, recordInfo.codPayPartner);			
			stmt.setString(i++, recordInfo.compoundId);
			stmt.setString(i++, recordInfo.customerId);
			stmt.setNull(i++, Types.VARCHAR);
			stmt.setNull(i++, Types.VARCHAR);

			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<CusparInfo> getNewInstance() {
		return new CusparInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<CusparInfo> {
		private CusparInfo recordInfo;
		
		public ResultParser(CusparInfo recordToParse) {
			recordInfo = recordToParse;
		}
		
		
		
		@Override public List<CusparInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<CusparInfo> finalResult = new ArrayList<>();
			recordInfo.codPayCustomer = lastId;
			finalResult.add(recordInfo);			
			return finalResult;
		}
	}
}
