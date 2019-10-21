package br.com.mind5.business.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper;
import br.com.mind5.dao.DaoStmtOption;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.dao.common.DaoOptionValue;

public final class CompUpdateSingle implements DaoStmt<CompInfo> {
	private DaoStmt<CompInfo> stmtSql;
	private DaoStmtOption<CompInfo> stmtOption;
	
	
	public CompUpdateSingle(Connection conn, CompInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, CompInfo recordInfo, String schemaName) {
		stmtOption = new DaoStmtOption<>();
		stmtOption.conn = conn;
		stmtOption.recordInfo = recordInfo;
		stmtOption.schemaName = schemaName;
		stmtOption.tableName = DaoDbTable.COMP_TABLE;
		stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(stmtOption.tableName);
		stmtOption.stmtParamTranslator = new ParamTranslator();
		stmtOption.resultParser = null;
		stmtOption.whereClause = buildWhereClause();
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;
		
		DaoStmtWhere whereClause = new CompWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		stmtSql = new DaoStmtHelper<>(DaoOperation.UPDATE, stmtOption, this.getClass());
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

	
	
	@Override public List<CompInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<CompInfo> getNewInstance() {
		return new CompUpdateSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<CompInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, CompInfo recordInfo) throws SQLException {			
			int i = 1;
			stmt.setString(i++, recordInfo.cnpj);
			stmt.setString(i++, recordInfo.name);
			stmt.setString(i++, recordInfo.email);	
			stmt.setString(i++, recordInfo.recordMode);
			DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
			stmt.setString(i++, recordInfo.codEntityCateg);
			stmt.setString(i++, recordInfo.codCountryLegal);
			stmt.setString(i++, recordInfo.inscrEst);
			stmt.setString(i++, recordInfo.inscrMun);
			stmt.setString(i++, recordInfo.razaoSocial);	
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codSnapshot);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);	
			DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);	
			
			return stmt;
		}		
	}
}
