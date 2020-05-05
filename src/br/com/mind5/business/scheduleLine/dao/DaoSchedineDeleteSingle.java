package br.com.mind5.business.scheduleLine.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoSchedineDeleteSingle extends DaoStmtTemplate<SchedineInfo> {
	private final String MAIN_TABLE = DaoDbTable.SCHEDULE_TABLE;		
	
	
	public DaoSchedineDeleteSingle(Connection conn, SchedineInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SOFT_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SchedineInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;	
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;		
		
		DaoStmtWhere whereClause = new DaoSchedineWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<SchedineInfo> getResultParserHook() {
		return new DaoResultParser<SchedineInfo>() {
			@Override public List<SchedineInfo> parseResult(SchedineInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SchedineInfo> finalResult = new ArrayList<>();
				SchedineInfo emptyInfo = new SchedineInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
