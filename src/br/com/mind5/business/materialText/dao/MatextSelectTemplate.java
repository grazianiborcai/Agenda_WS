package br.com.mind5.business.materialText.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper_;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.dao.obsolete.DaoResultParser_;
import br.com.mind5.dao.obsolete.DaoStmtOption_;

abstract class MatextSelectTemplate implements DaoStmt<MatextInfo> {
	private final String LT_MAT_TEXT = DaoDbTable.MAT_TEXT_TABLE;
	
	protected DaoStmt<MatextInfo> stmtSql;
	protected DaoStmtOption_<MatextInfo> stmtOption;
	
	
	
	public MatextSelectTemplate(Connection conn, MatextInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, MatextInfo recordInfo, String schemaName) {
		stmtOption = new DaoStmtOption_<>();
		stmtOption.conn = conn;
		stmtOption.recordInfo = recordInfo;
		stmtOption.schemaName = schemaName;
		stmtOption.tableName = LT_MAT_TEXT;
		stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_MAT_TEXT);
		stmtOption.stmtParamTranslator = null;
		stmtOption.resultParser = new ResultParser();
		stmtOption.whereClause = buildWhereClauseHook();
		stmtOption.joins = null;
	}
	
	
	
	protected String buildWhereClauseHook() {
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper_<>(DaoOperation.SELECT, this.stmtOption, this.getClass());
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
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser_<MatextInfo> {
		private final boolean NOT_NULL = false;
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<MatextInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<MatextInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
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
