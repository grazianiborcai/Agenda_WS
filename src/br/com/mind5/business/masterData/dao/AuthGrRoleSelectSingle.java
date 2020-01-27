package br.com.mind5.business.masterData.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.AuthGrRoleInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class AuthGrRoleSelectSingle extends DaoStmtTemplate<AuthGrRoleInfo> {	
	private final String MAIN_TABLE = DaoDbTable.AUTH_GROUP_ROLE_TABLE;
	
	
	public AuthGrRoleSelectSingle(Connection conn, AuthGrRoleInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, AuthGrRoleInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new AuthGrRoleWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
		
	
	
	@Override protected DaoResultParserV2<AuthGrRoleInfo> getResultParserHook() {
		return new DaoResultParserV2<AuthGrRoleInfo>() {
			@Override public List<AuthGrRoleInfo> parseResult(AuthGrRoleInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<AuthGrRoleInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					AuthGrRoleInfo dataInfo = new AuthGrRoleInfo();
					
					dataInfo.codAuthRole = stmtResult.getString(MasterDataDbTableColumn.COL_COD_AUTH_ROLE);
					dataInfo.codAuthGroup = stmtResult.getString(MasterDataDbTableColumn.COL_COD_AUTH_GROUP);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
