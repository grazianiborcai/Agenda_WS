package br.com.mind5.business.storeSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class SotarchSelectSingle extends DaoStmtTemplate<SotarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.STORE_TABLE;	
	
	
	public SotarchSelectSingle(Connection conn, SotarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.STORE_SEARCH_VIEW;
	}	
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SotarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new SotarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<SotarchInfo> getResultParserHook() {
		return new DaoResultParser<SotarchInfo>() {
			@Override public List<SotarchInfo> parseResult(SotarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SotarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					SotarchInfo dataInfo = new SotarchInfo();
					
					dataInfo.codOwner = stmtResult.getLong(SotarchDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(SotarchDbTableColumn.COL_COD_STORE);
					dataInfo.recordMode = stmtResult.getString(SotarchDbTableColumn.COL_RECORD_MODE);	
					dataInfo.codCompany = DaoFormatter.sqlToLong(stmtResult, SotarchDbTableColumn.COL_COD_COMPANY);		
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, SotarchDbTableColumn.COL_COD_USER);	
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
