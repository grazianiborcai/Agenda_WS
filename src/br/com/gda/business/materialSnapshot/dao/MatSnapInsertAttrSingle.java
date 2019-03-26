package br.com.gda.business.materialSnapshot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import br.com.gda.business.materialSnapshot.info.MatSnapInfo;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtParamTranslator;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public final class MatSnapInsertAttrSingle implements DaoStmt<MatSnapInfo> {
	private DaoStmt<MatSnapInfo> stmtSql;
	private DaoStmtOption<MatSnapInfo> stmtOption;
	
	
	
	public MatSnapInsertAttrSingle(Connection conn, MatSnapInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, MatSnapInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DaoDbTable.MAT_SNAPSHOT_TABLE;
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

	
	
	@Override public List<MatSnapInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<MatSnapInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, MatSnapInfo recordInfo) throws SQLException {
			
			Timestamp lastChanged = null;
			if(recordInfo.lastChanged != null)
				lastChanged = Timestamp.valueOf((recordInfo.lastChanged));
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			stmt.setLong(i++, recordInfo.codSnapshot);
			stmt.setLong(i++, recordInfo.codMat);
			stmt.setInt(i++, recordInfo.codType);
			stmt.setInt(i++, recordInfo.codCategory);
			stmt.setString(i++, recordInfo.codUnit);
			stmt.setInt(i++, recordInfo.priceUnit);
			stmt.setInt(i++, recordInfo.codGroup);
			stmt.setBoolean(i++, recordInfo.isLocked);
			stmt.setString(i++, recordInfo.recordMode);
			stmt.setTimestamp(i++, lastChanged);
			
			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<MatSnapInfo> getNewInstance() {
		return new MatSnapInsertAttrSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
}
