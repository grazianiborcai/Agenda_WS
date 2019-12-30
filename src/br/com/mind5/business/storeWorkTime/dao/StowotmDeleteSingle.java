package br.com.mind5.business.storeWorkTime.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class StowotmDeleteSingle extends DaoStmtTemplate<StowotmInfo> {
	private final String MAIN_TABLE = DaoDbTable.STORE_WT_TABLE;	
	
	
	public StowotmDeleteSingle(Connection conn, StowotmInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SOFT_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StowotmInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;			
		
		DaoStmtWhere whereClause = new StowotmWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParserV2<StowotmInfo> getResultParserHook() {
		return new DaoResultParserV2<StowotmInfo>() {
			@Override public List<StowotmInfo> parseResult(StowotmInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StowotmInfo> finalResult = new ArrayList<>();
				StowotmInfo emptyInfo = new StowotmInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
