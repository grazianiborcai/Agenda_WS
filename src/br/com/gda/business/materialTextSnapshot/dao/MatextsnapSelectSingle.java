package br.com.gda.business.materialTextSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;
import br.com.gda.dao.common.DaoOptionValue;

public class MatextsnapSelectSingle implements DaoStmt<MatextsnapInfo> {
	private final String LT_MAT_SNAP_TEXT = DaoDbTable.MAT_TEXT_SNAPSHOT_TABLE;
	
	protected DaoStmt<MatextsnapInfo> stmtSql;
	protected DaoStmtOption<MatextsnapInfo> stmtOption;
	
	
	
	public MatextsnapSelectSingle(Connection conn, MatextsnapInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, MatextsnapInfo recordInfo, String schemaName) {
		stmtOption = new DaoStmtOption<>();
		stmtOption.conn = conn;
		stmtOption.recordInfo = recordInfo;
		stmtOption.schemaName = schemaName;
		stmtOption.tableName = LT_MAT_SNAP_TEXT;
		stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_MAT_SNAP_TEXT);
		stmtOption.stmtParamTranslator = null;
		stmtOption.resultParser = new ResultParser();
		stmtOption.whereClause = buildWhereClause();
		stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new MatextsnapWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.SELECT, this.stmtOption, this.getClass());
	}
	
	
	
	@Override public DaoStmt<MatextsnapInfo> getNewInstance() {
		return new MatextsnapSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
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

	
	
	@Override public List<MatextsnapInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<MatextsnapInfo> {
		private final boolean NOT_NULL = false;
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<MatextsnapInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<MatextsnapInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				MatextsnapInfo dataInfo = new MatextsnapInfo();
				dataInfo.codOwner = stmtResult.getLong(MatextsnapDbTableColumn.COL_COD_OWNER);
				dataInfo.codSnapshot = stmtResult.getLong(MatextsnapDbTableColumn.COL_COD_SNAPSHOT);
				dataInfo.codMat = stmtResult.getLong(MatextsnapDbTableColumn.COL_COD_MATERIAL);
				dataInfo.txtMat = stmtResult.getString(MatextsnapDbTableColumn.COL_NAME);
				dataInfo.description = stmtResult.getString(MatextsnapDbTableColumn.COL_DESCRIPTION);
				dataInfo.codLanguage = stmtResult.getString(MatextsnapDbTableColumn.COL_COD_LANGUAGE);	
				dataInfo.isDefault = stmtResult.getBoolean(MatextsnapDbTableColumn.COL_IS_DEFAULT);	
				dataInfo.recordMode = stmtResult.getString(MatextsnapDbTableColumn.COL_RECORD_MODE);
				
				
				Timestamp lastChanged = stmtResult.getTimestamp(MatextsnapDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();
				
				
				stmtResult.getLong(MatextsnapDbTableColumn.COL_LAST_CHANGED_BY);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.lastChangedBy = stmtResult.getLong(MatextsnapDbTableColumn.COL_LAST_CHANGED_BY);
				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
