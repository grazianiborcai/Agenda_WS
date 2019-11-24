package br.com.mind5.business.orderItemSnapshot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper_;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.dao.obsolete.DaoResultParser_;
import br.com.mind5.dao.obsolete.DaoStmtOption_;

public class OrdemrapInsertSingle implements DaoStmt<OrdemrapInfo> {
	private DaoStmt<OrdemrapInfo> stmtSql;
	private DaoStmtOption_<OrdemrapInfo> stmtOption;
	
	
	
	public OrdemrapInsertSingle(Connection conn, OrdemrapInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, OrdemrapInfo recordInfo, String schemaName) {
		stmtOption = new DaoStmtOption_<>();
		stmtOption.conn = conn;
		stmtOption.recordInfo = recordInfo;
		stmtOption.schemaName = schemaName;
		stmtOption.tableName = DaoDbTable.ORDER_ITM_SNAPSHOT_TABLE;
		stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(stmtOption.tableName);
		stmtOption.stmtParamTranslator = new ParamTranslator();
		stmtOption.resultParser = new ResultParser(recordInfo);;
		stmtOption.whereClause = null;
	}
	
	
	
	private void buildStmt() {
		stmtSql = new DaoStmtHelper_<>(DaoOperation.INSERT, stmtOption, this.getClass());
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

	
	
	@Override public List<OrdemrapInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<OrdemrapInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, OrdemrapInfo recordInfo) throws SQLException {			
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOrderItem);
			stmt.setLong(i++, recordInfo.codOrder);			
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codMat);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codEmployee);
			stmt = DaoFormatter.localDateToStmt(stmt, i++, recordInfo.date);
			stmt = DaoFormatter.localTimeToStmt(stmt, i++, recordInfo.beginTime);
			stmt = DaoFormatter.localTimeToStmt(stmt, i++, recordInfo.endTime);
			stmt.setInt(i++, recordInfo.quantity);
			stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);	
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStoreSnapshot);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codMatSnapshot);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codEmployeeSnapshot);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.price);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totitem);
			stmt.setString(i++, recordInfo.codCurr);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
			
			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<OrdemrapInfo> getNewInstance() {
		return new OrdemrapInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	private static class ResultParser implements DaoResultParser_<OrdemrapInfo> {
		private OrdemrapInfo recordInfo;
		
		public ResultParser(OrdemrapInfo recordToParse) {
			recordInfo = recordToParse;
		}
		
		
		
		@Override public List<OrdemrapInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<OrdemrapInfo> finalResult = new ArrayList<>();
			recordInfo.codSnapshot = lastId;
			finalResult.add(recordInfo);			
			return finalResult;
		}
	}	
}
