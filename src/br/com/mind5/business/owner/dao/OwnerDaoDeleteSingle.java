package br.com.mind5.business.owner.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class OwnerDaoDeleteSingle extends DaoStmtTemplate<OwnerInfo> {
	private final String MAIN_TABLE = DaoDbTable.OWNER_TABLE;	
	
	
	public OwnerDaoDeleteSingle(Connection conn, OwnerInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SOFT_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, OwnerInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;	
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;		
		
		DaoStmtWhere whereClause = new OwnerDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<OwnerInfo> getResultParserHook() {
		return new DaoResultParser<OwnerInfo>() {
			@Override public List<OwnerInfo> parseResult(OwnerInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<OwnerInfo> finalResult = new ArrayList<>();
				OwnerInfo emptyInfo = new OwnerInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
