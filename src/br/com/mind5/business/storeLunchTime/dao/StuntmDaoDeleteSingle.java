package br.com.mind5.business.storeLunchTime.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class StuntmDaoDeleteSingle extends DaoStmtTemplate<StuntmInfo> {
	private final String MAIN_TABLE = DaoDbTable.STORE_LT_TABLE;	
	
	
	public StuntmDaoDeleteSingle(Connection conn, StuntmInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SOFT_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StuntmInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;			
		
		DaoStmtWhere whereClause = new StuntmDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<StuntmInfo> getResultParserHook() {
		return new DaoResultParser<StuntmInfo>() {
			@Override public List<StuntmInfo> parseResult(StuntmInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StuntmInfo> finalResult = new ArrayList<>();
				StuntmInfo emptyInfo = new StuntmInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
