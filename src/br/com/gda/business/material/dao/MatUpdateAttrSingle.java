package br.com.gda.business.material.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.sql.SqlDbTable;
import br.com.gda.sql.SqlOperation;
import br.com.gda.sql.SqlStmt;
import br.com.gda.sql.SqlStmtHelper;
import br.com.gda.sql.SqlStmtOption;
import br.com.gda.sql.SqlStmtParamTranslator;
import br.com.gda.sql.SqlStmtWhere;
import br.com.gda.sql.SqlWhereBuilderOption;

public final class MatUpdateAttrSingle implements SqlStmt<MatInfo> {
	private SqlStmt<MatInfo> stmtSql;
	private SqlStmtOption<MatInfo> stmtOption;
	
	
	public MatUpdateAttrSingle(Connection conn, MatInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, MatInfo recordInfo, String schemaName) {
		this.stmtOption = new SqlStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = SqlDbTable.MATERIAL_TABLE;
		this.stmtOption.columns = MatDbTableColumn.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = new ParamTranslator();
		this.stmtOption.resultParser = null;
		this.stmtOption.whereClause = buildWhereClause();
	}
	
	
	
	private String buildWhereClause() {
		final boolean DONT_IGNORE_NULL = false;
		final boolean IGNORE_RECORD_MODE = true;
		final boolean IGNORE_NON_PK = true;
		
		SqlWhereBuilderOption whereOption = new SqlWhereBuilderOption();
		whereOption.ignoreNull = DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = IGNORE_RECORD_MODE;
		whereOption.ignoreNonPrimaryKey = IGNORE_NON_PK;
		
		SqlStmtWhere whereClause = new MatWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new SqlStmtHelper<>(SqlOperation.UPDATE, this.stmtOption);
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

	
	
	@Override public List<MatInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public SqlStmt<MatInfo> getNewInstance() {
		return new MatUpdateAttrSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	private class ParamTranslator implements SqlStmtParamTranslator<MatInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, MatInfo recordInfo) throws SQLException {
			
			int i = 1;
			stmt.setDouble(i++, recordInfo.price);
			stmt.setInt(i++, recordInfo.codType);
			stmt.setInt(i++, recordInfo.codCategory);
			stmt.setString(i++, recordInfo.codCurr);
			stmt.setString(i++, recordInfo.codUnit);
			stmt.setInt(i++, recordInfo.priceUnit);
			stmt.setInt(i++, recordInfo.codGroup);
			stmt.setBoolean(i++, recordInfo.isLocked);
			stmt.setString(i++, recordInfo.recordMode);
			
			return stmt;
		}		
	}
}
