package br.com.mind5.business.storeText.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class StorextDaoDeleteSingle extends DaoStmtTemplate<StorextInfo> {
	private final String MAIN_TABLE = DaoDbTable.STORE_TEXT_TABLE;	
	
	
	public StorextDaoDeleteSingle(Connection conn, StorextInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);	
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SOFT_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StorextInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;	
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;		
		
		DaoStmtWhere whereClause = new StorextDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<StorextInfo> getResultParserHook() {
		return new DaoResultParser<StorextInfo>() {
			@Override public List<StorextInfo> parseResult(StorextInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StorextInfo> finalResult = new ArrayList<>();
				StorextInfo emptyInfo = new StorextInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
