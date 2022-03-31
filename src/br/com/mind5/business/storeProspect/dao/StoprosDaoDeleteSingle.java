package br.com.mind5.business.storeProspect.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class StoprosDaoDeleteSingle extends DaoStmtTemplate<StoprosInfo> {
	private final String MAIN_TABLE = DaoDbTable.STORE_PROSPECT_TABLE;	
	
	
	public StoprosDaoDeleteSingle(Connection conn, StoprosInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SOFT_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StoprosInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;	
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;		
		
		DaoStmtWhere whereClause = new StoprosDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<StoprosInfo> getResultParserHook() {
		return new DaoResultParser<StoprosInfo>() {
			@Override public List<StoprosInfo> parseResult(StoprosInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StoprosInfo> finalResult = new ArrayList<>();
				StoprosInfo emptyInfo = new StoprosInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
