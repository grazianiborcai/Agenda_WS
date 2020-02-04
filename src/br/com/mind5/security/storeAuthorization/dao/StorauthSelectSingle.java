package br.com.mind5.security.storeAuthorization.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoJoinOwner;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.security.storeAuthorization.info.StorauthInfo;

public final class StorauthSelectSingle extends DaoStmtTemplate<StorauthInfo> {
	private final String MAIN_TABLE = DaoDbTable.STORE_TABLE;	
	
	
	public StorauthSelectSingle(Connection conn, StorauthInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.STORE_AUTH_VIEW;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StorauthInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;					//TODO: DONT_IGNORE_NULL
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new StorauthWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(StorauthInfo recordInfo) {		
		DaoJoinBuilder joinOwner = new DaoJoinOwner(MAIN_TABLE);		
		return joinOwner.build();		
	}
	
	
	
	@Override protected DaoResultParserV2<StorauthInfo> getResultParserHook() {
		return new DaoResultParserV2<StorauthInfo>() {
			@Override public List<StorauthInfo> parseResult(StorauthInfo redcordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StorauthInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StorauthInfo dataInfo = new StorauthInfo();
					
					dataInfo.codOwner = stmtResult.getLong(StorauthDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(StorauthDbTableColumn.COL_COD_STORE);
					dataInfo.recordMode = stmtResult.getString(StorauthDbTableColumn.COL_RECORD_MODE);	
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, StorauthDbTableColumn.COL_COD_USER);			
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
