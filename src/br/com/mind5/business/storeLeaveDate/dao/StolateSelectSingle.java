package br.com.mind5.business.storeLeaveDate.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class StolateSelectSingle extends DaoStmtTemplate<StolateInfo> {	
	private final String MAIN_TABLE = DaoDbTable.STORE_LD_TABLE;
	
	
	public StolateSelectSingle(Connection conn, StolateInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StolateInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new StolateWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParserV2<StolateInfo> getResultParserHook() {
		return new DaoResultParserV2<StolateInfo>() {
			@Override public List<StolateInfo> parseResult(StolateInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StolateInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StolateInfo dataInfo = new StolateInfo();
					
					dataInfo.codOwner = stmtResult.getLong(StolateDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(StolateDbTableColumn.COL_COD_STORE);
					dataInfo.description = stmtResult.getString(StolateDbTableColumn.COL_DESCRIPTION);	
					dataInfo.recordMode = stmtResult.getString(StolateDbTableColumn.COL_RECORD_MODE);		
					dataInfo.timeValidFrom = DaoFormatter.sqlToLocalTime(stmtResult, StolateDbTableColumn.COL_TM_VALID_FROM);
					dataInfo.timeValidTo = DaoFormatter.sqlToLocalTime(stmtResult, StolateDbTableColumn.COL_TM_VALID_TO);
					dataInfo.dateValidFrom = DaoFormatter.sqlToLocalDate(stmtResult, StolateDbTableColumn.COL_DT_VALID_FROM);
					dataInfo.dateValidTo = DaoFormatter.sqlToLocalDate(stmtResult, StolateDbTableColumn.COL_DT_VALID_TO);					
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, StolateDbTableColumn.COL_LAST_CHANGED);	
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, StolateDbTableColumn.COL_LAST_CHANGED_BY);			
					dataInfo.monthValidFrom = DaoFormatter.sqlToInt(stmtResult, StolateDbTableColumn.COL_MONTH_VALID_FROM);		
					dataInfo.yearValidFrom = DaoFormatter.sqlToInt(stmtResult, StolateDbTableColumn.COL_YEAR_VALID_FROM);	
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, StolateDbTableColumn.COL_CREATED_ON);	
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, StolateDbTableColumn.COL_CREATED_BY);	
					dataInfo.validFrom = DaoFormatter.sqlToLocalDateTime(stmtResult, StolateDbTableColumn.COL_DATE_TIME_VALID_FROM);
					dataInfo.validTo = DaoFormatter.sqlToLocalDateTime(stmtResult, StolateDbTableColumn.COL_DATE_TIME_VALID_TO);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
