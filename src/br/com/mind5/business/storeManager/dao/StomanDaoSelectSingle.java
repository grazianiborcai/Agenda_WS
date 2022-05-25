package br.com.mind5.business.storeManager.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeManager.info.StomanInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class StomanDaoSelectSingle extends DaoStmtTemplate<StomanInfo> {
	private final String MAIN_TABLE = DaoDbTable.STORE_TABLE;	
	
	
	public StomanDaoSelectSingle(Connection conn, StomanInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.STORE_MANAGER_VIEW;
	}	
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StomanInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new StomanDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<StomanInfo> getResultParserHook() {
		return new DaoResultParser<StomanInfo>() {
			@Override public List<StomanInfo> parseResult(StomanInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StomanInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StomanInfo dataInfo = new StomanInfo();
					
					dataInfo.codOwner = stmtResult.getLong(StomanDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(StomanDaoDbTableColumn.COL_COD_STORE);
					dataInfo.recordMode = stmtResult.getString(StomanDaoDbTableColumn.COL_RECORD_MODE);	
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, StomanDaoDbTableColumn.COL_COD_USER);	
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
