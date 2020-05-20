package br.com.mind5.masterData.authorizationGroup.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.masterData.authorizationGroup.info.AuthgroupInfo;

public final class DaoAuthgroupSelectSingle extends DaoStmtTemplate<AuthgroupInfo> {	
	private final String MAIN_TABLE = DaoDbTable.AUTH_GROUP_TABLE;
	
	
	public DaoAuthgroupSelectSingle(Connection conn, AuthgroupInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, AuthgroupInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoAuthgroupWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<AuthgroupInfo> getResultParserHook() {
		return new DaoResultParser<AuthgroupInfo>() {
			@Override public List<AuthgroupInfo> parseResult(AuthgroupInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<AuthgroupInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					AuthgroupInfo dataInfo = new AuthgroupInfo();					
					dataInfo.codAuthGroup = stmtResult.getString(DaoAuthgroupDbTableColumn.COL_COD_AUTH_GROUP);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
