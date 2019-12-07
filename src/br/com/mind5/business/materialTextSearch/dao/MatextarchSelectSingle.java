package br.com.mind5.business.materialTextSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialTextSearch.info.MatextarchInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class MatextarchSelectSingle extends DaoStmtTemplate<MatextarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_TEXT_TABLE;	
	
	public MatextarchSelectSingle(Connection conn, MatextarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.MAT_TEXT_SEARCH_VIEW;	
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MatextarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new MatextarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
		
	@Override protected DaoResultParserV2<MatextarchInfo> getResultParserHook() {
		return new DaoResultParserV2<MatextarchInfo>() {
			@Override public List<MatextarchInfo> parseResult(MatextarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MatextarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					MatextarchInfo dataInfo = new MatextarchInfo();
					dataInfo.codOwner = stmtResult.getLong(MatextarchDbTableColumn.COL_COD_OWNER);
					dataInfo.codMat = stmtResult.getLong(MatextarchDbTableColumn.COL_COD_MATERIAL);
					dataInfo.codLanguage = stmtResult.getString(MatextarchDbTableColumn.COL_COD_LANGUAGE);
					dataInfo.recordMode = stmtResult.getString(MatextarchDbTableColumn.COL_RECORD_MODE);				
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
