package br.com.mind5.business.storeLeaveDate.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class StolateDeleteSingle extends DaoStmtTemplate<StolateInfo> {
	private final String MAIN_TABLE = DaoDbTable.STORE_LD_TABLE;	
	
	
	public StolateDeleteSingle(Connection conn, StolateInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SOFT_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StolateInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode =  DaoOptionValue.DONT_IGNORE_RECORD_MODE;	
		
		
		DaoStmtWhere whereClause = new StolateWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<StolateInfo> getResultParserHook() {
		return new DaoResultParser<StolateInfo>() {
			@Override public List<StolateInfo> parseResult(StolateInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StolateInfo> finalResult = new ArrayList<>();
				StolateInfo emptyInfo = new StolateInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
