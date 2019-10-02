package br.com.gda.file.fileImage.dao;

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
import br.com.gda.file.fileImage.info.FimgInfo;

public final class FimgSelectSingle implements DaoStmt<FimgInfo> {
	private final String LT_FILE = DaoDbTable.FILE_IMG_TABLE;	
	
	private DaoStmt<FimgInfo> stmtSql;
	private DaoStmtOption<FimgInfo> stmtOption;
	
	
	
	public FimgSelectSingle(Connection conn, FimgInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, FimgInfo recordInfo, String schemaName) {
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
		
		DaoStmtWhere whereClause = new FimgWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<FimgInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<FimgInfo> getNewInstance() {
		return new FimgSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<FimgInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<FimgInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<FimgInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				FimgInfo dataInfo = new FimgInfo();
				dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, FimgDbTableColumn.COL_COD_OWNER);
				dataInfo.codOwnerRef = DaoFormatter.sqlToLong(stmtResult, FimgDbTableColumn.COL_COD_OWNER_REF);
				dataInfo.codFileImg = DaoFormatter.sqlToLong(stmtResult, FimgDbTableColumn.COL_COD_FILE_IMG);
				dataInfo.codMat = DaoFormatter.sqlToLong(stmtResult, FimgDbTableColumn.COL_COD_MATERIAL);
				dataInfo.codPerson = DaoFormatter.sqlToLong(stmtResult, FimgDbTableColumn.COL_COD_PERSON);
				dataInfo.codCompany = DaoFormatter.sqlToLong(stmtResult, FimgDbTableColumn.COL_COD_COMPANY);
				dataInfo.recordMode = stmtResult.getString(FimgDbTableColumn.COL_RECORD_MODE);
				dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, FimgDbTableColumn.COL_CREATED_ON);		
				dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, FimgDbTableColumn.COL_LAST_CHANGED);	
				dataInfo.fileImgName = stmtResult.getString(FimgDbTableColumn.COL_FILE_IMG_NAME);
				dataInfo.fileImgExtension = stmtResult.getString(FimgDbTableColumn.COL_FILE_IMG_EXTENSION);
				dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, FimgDbTableColumn.COL_CREATED_BY);
				dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, FimgDbTableColumn.COL_LAST_CHANGED_BY);
				dataInfo.fileImgUri = stmtResult.getString(FimgDbTableColumn.COL_FILE_URI);
				dataInfo.fileImgPath = stmtResult.getString(FimgDbTableColumn.COL_IMG_FILE_PATH);
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
