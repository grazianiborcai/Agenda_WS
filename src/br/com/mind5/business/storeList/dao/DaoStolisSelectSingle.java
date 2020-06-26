package br.com.mind5.business.storeList.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoStolisSelectSingle extends DaoStmtTemplate<StolisInfo> {
	private final String MAIN_TABLE = DaoDbTable.STORE_TABLE;	
	
	
	public DaoStolisSelectSingle(Connection conn, StolisInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}	
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.STORE_LIST_VIEW;
	}	
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StolisInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoStolisWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<StolisInfo> getResultParserHook() {
		return new DaoResultParser<StolisInfo>() {
			@Override public List<StolisInfo> parseResult(StolisInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StolisInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StolisInfo dataInfo = new StolisInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoStolisDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(DaoStolisDbTableColumn.COL_COD_STORE);
					dataInfo.codCurr = stmtResult.getString(DaoStolisDbTableColumn.COL_COD_CURRENCY);
					dataInfo.codTimezone = stmtResult.getString(DaoStolisDbTableColumn.COL_COD_TIMEZONE);
					dataInfo.recordMode = stmtResult.getString(DaoStolisDbTableColumn.COL_RECORD_MODE);	
					dataInfo.codCompany = DaoFormatter.sqlToLong(stmtResult, DaoStolisDbTableColumn.COL_COD_COMPANY);
					dataInfo.codAddress = DaoFormatter.sqlToLong(stmtResult, DaoStolisDbTableColumn.COL_COD_ADDRESS);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoStolisDbTableColumn.COL_COD_SNAPSHOT);		
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
