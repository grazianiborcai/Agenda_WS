package br.com.mind5.file.filePath.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper;
import br.com.mind5.dao.DaoStmtOption;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.file.filePath.info.FathInfo;

public final class FathSelectSingle implements DaoStmt<FathInfo> {
	private final String LT_FILE = DaoDbTable.FILE_PATH_TABLE;	
	
	private DaoStmt<FathInfo> stmtSql;
	private DaoStmtOption<FathInfo> stmtOption;
	
	
	
	public FathSelectSingle(Connection conn, FathInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, FathInfo recordInfo, String schemaName) {
		stmtOption = new DaoStmtOption<>();
		stmtOption.conn = conn;
		stmtOption.recordInfo = recordInfo;
		stmtOption.schemaName = schemaName;
		stmtOption.tableName = LT_FILE;
		stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_FILE);
		stmtOption.stmtParamTranslator = null;
		stmtOption.resultParser = new ResultParser();
		stmtOption.whereClause = buildWhereClause();
		stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new FathWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.SELECT, this.stmtOption, this.getClass());
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

	
	
	@Override public List<FathInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<FathInfo> getNewInstance() {
		return new FathSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<FathInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<FathInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<FathInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				FathInfo dataInfo = new FathInfo();
				dataInfo.codFilePath = stmtResult.getString(FathDbTableColumn.COL_COD_FILE_PATH);
				dataInfo.filePath = stmtResult.getString(FathDbTableColumn.COL_FILE_PATH);
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
