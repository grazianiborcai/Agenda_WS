package br.com.mind5.business.employeePosition.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class EmposDeleteSingle extends DaoStmtTemplate<EmposInfo> {
	private final String LT_MAIN = DaoDbTable.EMPOS_TABLE;
	
	
	public EmposDeleteSingle(Connection conn, EmposInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return LT_MAIN;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SOFT_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EmposInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;	
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;		
		
		DaoStmtWhere whereClause = new EmposWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParserV2<EmposInfo> getResultParserHook() {
		return new DaoResultParserV2<EmposInfo>() {
			@Override public List<EmposInfo> parseResult(EmposInfo redcordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<EmposInfo> finalResult = new ArrayList<>();
				EmposInfo emptyInfo = new EmposInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
