package br.com.gda.file.fileUpload.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.dao.DaoFormatter;
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
import br.com.gda.file.fileUpload.info.FilupInfo;

public final class FilupSelectSingle implements DaoStmt<FilupInfo> {
	private final String LT_FILE = DaoDbTable.FILE_IMG_TABLE;	
	
	private DaoStmt<FilupInfo> stmtSql;
	private DaoStmtOption<FilupInfo> stmtOption;
	
	
	
	public FilupSelectSingle(Connection conn, FilupInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, FilupInfo recordInfo, String schemaName) {
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
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new FilupWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<FilupInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<FilupInfo> getNewInstance() {
		return new FilupSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<FilupInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<FilupInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<FilupInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				FilupInfo dataInfo = new FilupInfo();
				dataInfo.codOwner = stmtResult.getLong(FilupDbTableColumn.COL_COD_OWNER);
				dataInfo.codFileImg = stmtResult.getLong(FilupDbTableColumn.COL_COD_FILE_IMG);
				dataInfo.codMat = stmtResult.getLong(FilupDbTableColumn.COL_COD_MATERIAL);
				dataInfo.codPerson = stmtResult.getLong(FilupDbTableColumn.COL_COD_PERSON);
				dataInfo.codCompany = stmtResult.getLong(FilupDbTableColumn.COL_COD_COMPANY);
				dataInfo.recordMode = stmtResult.getString(FilupDbTableColumn.COL_RECORD_MODE);
				dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, FilupDbTableColumn.COL_CREATED_ON);		
				dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, FilupDbTableColumn.COL_LAST_CHANGED);	
				dataInfo.fileImgName = stmtResult.getString(FilupDbTableColumn.COL_FILE_IMG_NAME);
				dataInfo.createdBy = stmtResult.getLong(FilupDbTableColumn.COL_CREATED_BY);
				dataInfo.lastChangedBy = stmtResult.getLong(FilupDbTableColumn.COL_LAST_CHANGED_BY);
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
