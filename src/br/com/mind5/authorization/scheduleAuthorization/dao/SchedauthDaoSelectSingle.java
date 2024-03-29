package br.com.mind5.authorization.scheduleAuthorization.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.authorization.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class SchedauthDaoSelectSingle extends DaoStmtTemplate<SchedauthInfo> {	
	private final String MAIN_TABLE = DaoDbTable.SCHEDULE_TABLE;
	
	
	public SchedauthDaoSelectSingle(Connection conn, SchedauthInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.SCHEDULE_AUTH_VIEW;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SchedauthInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new SchedauthDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<SchedauthInfo> getResultParserHook() {
		return new DaoResultParser<SchedauthInfo>() {
			@Override public List<SchedauthInfo> parseResult(SchedauthInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {	
				List<SchedauthInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					SchedauthInfo dataInfo = new SchedauthInfo();
					
					dataInfo.codOwner = stmtResult.getLong(SchedauthDaoDbTableColumn.COL_COD_OWNER);	
					dataInfo.codSchedule = stmtResult.getLong(SchedauthDaoDbTableColumn.COL_COD_SCHEDULE);
					dataInfo.recordMode = stmtResult.getString(SchedauthDaoDbTableColumn.COL_RECORD_MODE);	
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, SchedauthDaoDbTableColumn.COL_COD_USER);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, SchedauthDaoDbTableColumn.COL_COD_STORE);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
