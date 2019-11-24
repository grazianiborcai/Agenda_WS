package br.com.mind5.payment.customerPartner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper_;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.dao.obsolete.DaoResultParser_;
import br.com.mind5.dao.obsolete.DaoStmtOption_;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class CusparInsertSingle implements DaoStmt<CusparInfo> {
	private DaoStmt<CusparInfo> stmtSql;
	private DaoStmtOption_<CusparInfo> stmtOption;
	
	
	
	public CusparInsertSingle(Connection conn, CusparInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, CusparInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption_<>();
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
	
	
	
	
	
	private static class ResultParser implements DaoResultParser_<CusparInfo> {
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
