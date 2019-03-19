package br.com.gda.business.materialStore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.List;

import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtParamTranslator;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public final class MatoreInsertSingle implements DaoStmt<MatoreInfo> {
	private DaoStmt<MatoreInfo> stmtSql;
	private DaoStmtOption<MatoreInfo> stmtOption;
	
	
	
	public MatoreInsertSingle(Connection conn, MatoreInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
		
	}
	
	
	
	private void buildStmtOption(Connection conn, MatoreInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DaoDbTable.MAT_STORE_TABLE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = new ParamTranslator();
		this.stmtOption.resultParser = null;
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

	
	
	@Override public List<MatoreInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<MatoreInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, MatoreInfo recordInfo) throws SQLException {
			Timestamp lastChanged = DaoFormatter.localToSqlTimestamp(recordInfo.lastChanged);
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			stmt.setLong(i++, recordInfo.codStore);
			stmt.setLong(i++, recordInfo.codMat);
			
			if (recordInfo.matPrice >= 0) {
				stmt.setFloat(i++, DaoFormatter.longToDecimal(recordInfo.matPrice));
			} else {
				stmt.setNull(i++, Types.FLOAT);
			}
			
			
			if (recordInfo.matPrice1 >= 0) {
				stmt.setFloat(i++, DaoFormatter.longToDecimal(recordInfo.matPrice1));
			} else {
				stmt.setNull(i++, Types.FLOAT);
			}
			
			
			if (recordInfo.matPrice2 >= 0) {
				stmt.setFloat(i++, DaoFormatter.longToDecimal(recordInfo.matPrice2));
			} else {
				stmt.setNull(i++, Types.FLOAT);
			}
			
			
			if (recordInfo.matPrice3 >= 0) {
				stmt.setFloat(i++, DaoFormatter.longToDecimal(recordInfo.matPrice3));
			} else {
				stmt.setNull(i++, Types.FLOAT);
			}
			
			
			if (recordInfo.matPrice4 >= 0) {
				stmt.setFloat(i++, DaoFormatter.longToDecimal(recordInfo.matPrice4));
			} else {
				stmt.setNull(i++, Types.FLOAT);
			}
			
			
			if (recordInfo.matPrice5 >= 0) {
				stmt.setFloat(i++, DaoFormatter.longToDecimal(recordInfo.matPrice5));
			} else {
				stmt.setNull(i++, Types.FLOAT);
			}
			
			
			if (recordInfo.matPrice6 >= 0) {
				stmt.setFloat(i++, DaoFormatter.longToDecimal(recordInfo.matPrice6));
			} else {
				stmt.setNull(i++, Types.FLOAT);
			}
			
			
			if (recordInfo.matPrice7 >= 0) {
				stmt.setFloat(i++, DaoFormatter.longToDecimal(recordInfo.matPrice7));
			} else {
				stmt.setNull(i++, Types.FLOAT);
			}
						

			stmt.setString(i++, recordInfo.recordMode);
			stmt.setTimestamp(i++, lastChanged);
			
			
			if (recordInfo.lastChangedBy >= 0) {
				stmt.setLong(i++, recordInfo.lastChangedBy);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}
			
			
			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<MatoreInfo> getNewInstance() {
		return new MatoreInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
}
