package br.com.gda.payment.creditCard.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public final class CrecardDeleteSingle implements DaoStmt<CrecardInfo> {
	private DaoStmt<CrecardInfo> stmtSql;
	private DaoStmtOption<CrecardInfo> stmtOption;	
	
	
	public CrecardDeleteSingle(Connection conn, CrecardInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, CrecardInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DaoDbTable.CREDIT_CARD_TABLE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.DONT_IGNORE_RECORD_MODE;	
		whereOption.ignoreNonPrimaryKey = DaoWhereBuilderOption.IGNORE_NON_PK;		
		
		DaoStmtWhere whereClause = new CrecardWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.SOFT_DELETE, this.stmtOption);
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

	
	
	@Override public List<CrecardInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<CrecardInfo> getNewInstance() {
		return new CrecardDeleteSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	private class ResultParser implements DaoResultParser<CrecardInfo> {
		@Override public List<CrecardInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<CrecardInfo> finalResult = new ArrayList<>();
			CrecardInfo emptyInfo = new CrecardInfo();
			finalResult.add(emptyInfo);			
			return finalResult;
		}
	}
}
