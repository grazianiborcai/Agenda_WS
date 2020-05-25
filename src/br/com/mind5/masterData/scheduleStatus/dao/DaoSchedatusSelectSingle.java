package br.com.mind5.masterData.scheduleStatus.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.masterData.scheduleStatus.info.SchedatusInfo;

public final class DaoSchedatusSelectSingle extends DaoStmtTemplate<SchedatusInfo> {
	private final String MAIN_TABLE = DaoDbTable.SCHEDULE_STATUS_TABLE;
	
	
	public DaoSchedatusSelectSingle(Connection conn, SchedatusInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SchedatusInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoSchedatusWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(SchedatusInfo recordInfo) {
		DaoJoinBuilder joinText = new DaoSchedatusJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<SchedatusInfo> getResultParserHook() {
		return new DaoResultParser<SchedatusInfo>() {
			@Override public List<SchedatusInfo> parseResult(SchedatusInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SchedatusInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					SchedatusInfo dataInfo = new SchedatusInfo();
					
					dataInfo.codScheduleStatus = stmtResult.getString(DaoSchedatusDbTableColumn.COL_COD_SCHEDULE_STATUS);
					dataInfo.txtScheduleStatus = stmtResult.getString(DaoSchedatusDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(DaoSchedatusDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
