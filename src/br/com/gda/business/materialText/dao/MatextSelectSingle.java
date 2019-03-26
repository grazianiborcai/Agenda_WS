package br.com.gda.business.materialText.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialText.info.MatextInfo;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public final class MatextSelectSingle implements DaoStmt<MatextInfo> {
	private final String LT_MAT_TEXT = DaoDbTable.MAT_TEXT_TABLE;
	
	private DaoStmt<MatextInfo> stmtSql;
	private DaoStmtOption<MatextInfo> stmtOption;
	
	
	
	public MatextSelectSingle(Connection conn, MatextInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, MatextInfo recordInfo, String schemaName) {
		stmtOption = new DaoStmtOption<>();
		stmtOption.conn = conn;
		stmtOption.recordInfo = recordInfo;
		stmtOption.schemaName = schemaName;
		stmtOption.tableName = LT_MAT_TEXT;
		stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_MAT_TEXT);
		stmtOption.stmtParamTranslator = null;
		stmtOption.resultParser = new ResultParser();
		stmtOption.whereClause = buildWhereClause();
		stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new MatextWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.SELECT, this.stmtOption);
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

	
	
	@Override public List<MatextInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<MatextInfo> getNewInstance() {
		return new MatextSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<MatextInfo> {
		private final boolean NOT_NULL = false;
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<MatextInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<MatextInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				MatextInfo dataInfo = new MatextInfo();
				dataInfo.codOwner = stmtResult.getLong(MatextDbTableColumn.COL_COD_OWNER);
				dataInfo.codMat = stmtResult.getLong(MatextDbTableColumn.COL_COD_MATERIAL);
				dataInfo.txtMat = stmtResult.getString(MatextDbTableColumn.COL_NAME);
				dataInfo.description = stmtResult.getString(MatextDbTableColumn.COL_DESCRIPTION);
				dataInfo.codLanguage = stmtResult.getString(MatextDbTableColumn.COL_COD_LANGUAGE);	
				dataInfo.isDefault = stmtResult.getBoolean(MatextDbTableColumn.COL_IS_DEFAULT);	
				dataInfo.recordMode = stmtResult.getString(MatextDbTableColumn.COL_RECORD_MODE);
				
				
				Timestamp lastChanged = stmtResult.getTimestamp(MatextDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();
				
				
				stmtResult.getLong(MatextDbTableColumn.COL_LAST_CHANGED_BY);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.lastChangedBy = stmtResult.getLong(MatextDbTableColumn.COL_LAST_CHANGED_BY);
				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
