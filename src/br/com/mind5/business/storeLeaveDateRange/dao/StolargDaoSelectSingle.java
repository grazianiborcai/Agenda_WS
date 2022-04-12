package br.com.mind5.business.storeLeaveDateRange.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLeaveDateRange.info.StolargInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class StolargDaoSelectSingle extends DaoStmtTemplate<StolargInfo> {	
	private final String MAIN_TABLE = DaoDbTable.STORE_LD_TABLE;	
	
	
	
	public StolargDaoSelectSingle(Connection conn, StolargInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.STORE_LD_RANGE_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}

		
	
	@Override protected String buildWhereClauseHook(String tableName, StolargInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new StolargDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<StolargInfo> getResultParserHook() {
		return new DaoResultParser<StolargInfo>() {
			@Override public List<StolargInfo> parseResult(StolargInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StolargInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StolargInfo dataInfo = new StolargInfo();
					
					dataInfo.codOwner = stmtResult.getLong(StolargDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(StolargDaoDbTableColumn.COL_COD_STORE);
					dataInfo.recordMode = stmtResult.getString(StolargDaoDbTableColumn.COL_RECORD_MODE);	
					dataInfo.timeValidFrom = DaoFormatter.sqlToLocalTime(stmtResult, StolargDaoDbTableColumn.COL_TM_VALID_FROM);
					dataInfo.timeValidTo = DaoFormatter.sqlToLocalTime(stmtResult, StolargDaoDbTableColumn.COL_TM_VALID_TO);
					dataInfo.dateValidFrom = DaoFormatter.sqlToLocalDate(stmtResult, StolargDaoDbTableColumn.COL_DT_VALID_FROM);
					dataInfo.dateValidTo = DaoFormatter.sqlToLocalDate(stmtResult, StolargDaoDbTableColumn.COL_DT_VALID_TO);
					dataInfo.validFrom = DaoFormatter.sqlToLocalDateTime(stmtResult, StolargDaoDbTableColumn.COL_DATE_TIME_VALID_FROM);
					dataInfo.validTo = DaoFormatter.sqlToLocalDateTime(stmtResult, StolargDaoDbTableColumn.COL_DATE_TIME_VALID_TO);
					
					finalResult.add(dataInfo);		
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		super.executeStmt();
	}
}
