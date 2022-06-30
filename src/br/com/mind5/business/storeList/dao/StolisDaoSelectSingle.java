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

public final class StolisDaoSelectSingle extends DaoStmtTemplate<StolisInfo> {
	private final String MAIN_TABLE = DaoDbTable.STORE_TABLE;	
	
	
	public StolisDaoSelectSingle(Connection conn, StolisInfo recordInfo, String schemaName) {
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
		
		DaoStmtWhere whereClause = new StolisDaoWhere(whereOption, tableName, recordInfo);
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
					
					dataInfo.codOwner = stmtResult.getLong(StolisDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(StolisDaoDbTableColumn.COL_COD_STORE);
					dataInfo.codCurr = stmtResult.getString(StolisDaoDbTableColumn.COL_COD_CURRENCY);
					dataInfo.codTimezone = stmtResult.getString(StolisDaoDbTableColumn.COL_COD_TIMEZONE);
					dataInfo.recordMode = stmtResult.getString(StolisDaoDbTableColumn.COL_RECORD_MODE);	
					dataInfo.codCompany = DaoFormatter.sqlToLong(stmtResult, StolisDaoDbTableColumn.COL_COD_COMPANY);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, StolisDaoDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.isLocked = DaoFormatter.sqlToBoole(stmtResult, StolisDaoDbTableColumn.COL_IS_LOCKED);
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, StolisDaoDbTableColumn.COL_CREATED_ON);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
