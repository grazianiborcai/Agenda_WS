package br.com.mind5.file.fileImageSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
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
import br.com.mind5.file.fileImageSearch.info.FimarchInfo;

public final class FimarchSelectSingle implements DaoStmt<FimarchInfo> {
	private final String LT_FILE = DaoDbTable.FILE_IMG_TABLE;	
	
	private DaoStmt<FimarchInfo> stmtSql;
	private DaoStmtOption<FimarchInfo> stmtOption;
	
	
	
	public FimarchSelectSingle(Connection conn, FimarchInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, FimarchInfo recordInfo, String schemaName) {
		stmtOption = new DaoStmtOption<>();
		stmtOption.conn = conn;
		stmtOption.recordInfo = recordInfo;
		stmtOption.schemaName = schemaName;
		stmtOption.tableName = LT_FILE;
		stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(DaoDbTable.FILE_IMG_SEARCH_VIEW);
		stmtOption.stmtParamTranslator = null;
		stmtOption.resultParser = new ResultParser();
		stmtOption.whereClause = buildWhereClause();
		stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new FimarchWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<FimarchInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<FimarchInfo> getNewInstance() {
		return new FimarchSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<FimarchInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<FimarchInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<FimarchInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				FimarchInfo dataInfo = new FimarchInfo();
				dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, FimarchDbTableColumn.COL_COD_OWNER);
				dataInfo.codFileImg = DaoFormatter.sqlToLong(stmtResult, FimarchDbTableColumn.COL_COD_FILE_IMG);
				dataInfo.codMat = DaoFormatter.sqlToLong(stmtResult, FimarchDbTableColumn.COL_COD_MATERIAL);
				dataInfo.codPerson = DaoFormatter.sqlToLong(stmtResult, FimarchDbTableColumn.COL_COD_PERSON);
				dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, FimarchDbTableColumn.COL_COD_STORE);
				dataInfo.recordMode = stmtResult.getString(FimarchDbTableColumn.COL_RECORD_MODE);
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
