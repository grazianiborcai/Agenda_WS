package br.com.mind5.business.storeTextDefault.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeTextDefault.info.StorextaultInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class StorextaultDaoSelectSingle extends DaoStmtTemplate<StorextaultInfo> {
	private final String MAIN_TABLE = DaoDbTable.STORE_TEXT_TABLE;	
	
	public StorextaultDaoSelectSingle(Connection conn, StorextaultInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.STORE_TEXT_DEFAULT_VIEW;	
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StorextaultInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new StorextaultDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<StorextaultInfo> getResultParserHook() {
		return new DaoResultParser<StorextaultInfo>() {
			@Override public List<StorextaultInfo> parseResult(StorextaultInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StorextaultInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StorextaultInfo dataInfo = new StorextaultInfo();
					
					dataInfo.codOwner = stmtResult.getLong(StorextaultDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(StorextaultDaoDbTableColumn.COL_COD_STORE);
					dataInfo.codLanguage = stmtResult.getString(StorextaultDaoDbTableColumn.COL_COD_LANGUAGE);
					dataInfo.recordMode = stmtResult.getString(StorextaultDaoDbTableColumn.COL_RECORD_MODE);			
					dataInfo.isDefault = stmtResult.getBoolean(StorextaultDaoDbTableColumn.COL_IS_DEFAULT);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		super.executeStmt();
	}
}
