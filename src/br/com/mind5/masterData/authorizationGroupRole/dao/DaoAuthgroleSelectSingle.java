package br.com.mind5.masterData.authorizationGroupRole.dao;

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
import br.com.mind5.masterData.authorizationGroupRole.info.AuthgroleInfo;

public final class DaoAuthgroleSelectSingle extends DaoStmtTemplate<AuthgroleInfo> {	
	private final String MAIN_TABLE = DaoDbTable.AUTH_GROUP_ROLE_TABLE;
	
	
	public DaoAuthgroleSelectSingle(Connection conn, AuthgroleInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, AuthgroleInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoAuthgroleWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
		
	
	
	@Override protected DaoResultParser<AuthgroleInfo> getResultParserHook() {
		return new DaoResultParser<AuthgroleInfo>() {
			@Override public List<AuthgroleInfo> parseResult(AuthgroleInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<AuthgroleInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					AuthgroleInfo dataInfo = new AuthgroleInfo();
					
					dataInfo.codAuthRole = stmtResult.getString(DaoAuthgroleDbTableColumn.COL_COD_AUTH_ROLE);
					dataInfo.codAuthGroup = stmtResult.getString(DaoAuthgroleDbTableColumn.COL_COD_AUTH_GROUP);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
