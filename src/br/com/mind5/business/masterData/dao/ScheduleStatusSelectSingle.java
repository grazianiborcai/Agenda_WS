package br.com.mind5.business.masterData.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.ScheduleStatusInfo;
import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class ScheduleStatusSelectSingle extends DaoStmtTemplate<ScheduleStatusInfo> {
	private final String MAIN_TABLE = DaoDbTable.SCHEDULE_STATUS_TABLE;
	
	
	public ScheduleStatusSelectSingle(Connection conn, ScheduleStatusInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, ScheduleStatusInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new ScheduleStatusWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(ScheduleStatusInfo recordInfo) {
		DaoJoinBuilder joinText = new ScheduleStatusJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<ScheduleStatusInfo> getResultParserHook() {
		return new DaoResultParser<ScheduleStatusInfo>() {
			@Override public List<ScheduleStatusInfo> parseResult(ScheduleStatusInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<ScheduleStatusInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					ScheduleStatusInfo dataInfo = new ScheduleStatusInfo();
					
					dataInfo.codScheduleStatus = stmtResult.getString(MasterDataDbTableColumn.COL_COD_SCHEDULE_STATUS);
					dataInfo.txtScheduleStatus = stmtResult.getString(MasterDataDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(MasterDataDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
