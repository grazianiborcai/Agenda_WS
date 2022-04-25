package br.com.mind5.business.employeeLunchTime.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class EmplutmDaoDeleteSingle extends DaoStmtTemplate<EmplutmInfo> {
	private final String MAIN_TABLE = DaoDbTable.EMP_LT_TABLE;	
	
	
	public EmplutmDaoDeleteSingle(Connection conn, EmplutmInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SOFT_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EmplutmInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;	
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;
		
		DaoStmtWhere whereClause = new EmplutmDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<EmplutmInfo> getResultParserHook() {
		return new DaoResultParser<EmplutmInfo>() {
			@Override public List<EmplutmInfo> parseResult(EmplutmInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<EmplutmInfo> finalResult = new ArrayList<>();
				EmplutmInfo emptyInfo = new EmplutmInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
