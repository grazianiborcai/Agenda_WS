package br.com.gda.file.fileImageList.dao;

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
import br.com.gda.file.fileImageList.info.FimistInfo;

public final class FimistSelectSingle implements DaoStmt<FimistInfo> {
	private final String LT_FILE = DaoDbTable.FILE_IMG_TABLE;	
	
	private DaoStmt<FimistInfo> stmtSql;
	private DaoStmtOption<FimistInfo> stmtOption;
	
	
	
	public FimistSelectSingle(Connection conn, FimistInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, FimistInfo recordInfo, String schemaName) {
		stmtOption = new DaoStmtOption<>();
		stmtOption.conn = conn;
		stmtOption.recordInfo = recordInfo;
		stmtOption.schemaName = schemaName;
		stmtOption.tableName = LT_FILE;
		stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(DaoDbTable.FILE_IMG_LIST_VIEW);
		stmtOption.stmtParamTranslator = null;
		stmtOption.resultParser = new ResultParser();
		stmtOption.whereClause = buildWhereClause();
		stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new FimistWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<FimistInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<FimistInfo> getNewInstance() {
		return new FimistSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<FimistInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<FimistInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<FimistInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				FimistInfo dataInfo = new FimistInfo();
				dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, FimistDbTableColumn.COL_COD_OWNER);
				dataInfo.codOwnerRef = DaoFormatter.sqlToLong(stmtResult, FimistDbTableColumn.COL_COD_OWNER_REF);
				dataInfo.codFileImg = DaoFormatter.sqlToLong(stmtResult, FimistDbTableColumn.COL_COD_FILE_IMG);
				dataInfo.codMat = DaoFormatter.sqlToLong(stmtResult, FimistDbTableColumn.COL_COD_MATERIAL);
				dataInfo.codPerson = DaoFormatter.sqlToLong(stmtResult, FimistDbTableColumn.COL_COD_PERSON);
				dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, FimistDbTableColumn.COL_COD_STORE);
				dataInfo.recordMode = stmtResult.getString(FimistDbTableColumn.COL_RECORD_MODE);	
				dataInfo.fileImgExtension = stmtResult.getString(FimistDbTableColumn.COL_FILE_IMG_EXTENSION);
				dataInfo.fileImgUri = stmtResult.getString(FimistDbTableColumn.COL_FILE_URI);
				dataInfo.isCover = DaoFormatter.sqlToBoole(stmtResult, FimistDbTableColumn.COL_IS_COVER);
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
