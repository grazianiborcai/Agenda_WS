package br.com.mind5.business.storeTextSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeTextSnapshot.info.StorextsnapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public class StorextsnapDaoSelectSingle extends DaoStmtTemplate<StorextsnapInfo> {
	private final String MAIN_TABLE = DaoDbTable.STORE_TEXT_SNAPSHOT_TABLE;
	
	
	public StorextsnapDaoSelectSingle(Connection conn, StorextsnapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StorextsnapInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new StorextsnapDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	
	@Override protected DaoResultParser<StorextsnapInfo> getResultParserHook() {
		return new DaoResultParser<StorextsnapInfo>() {
			@Override public List<StorextsnapInfo> parseResult(StorextsnapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StorextsnapInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StorextsnapInfo dataInfo = new StorextsnapInfo();
					
					dataInfo.codOwner = stmtResult.getLong(StorextsnapDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codSnapshot = stmtResult.getLong(StorextsnapDaoDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codStore = stmtResult.getLong(StorextsnapDaoDbTableColumn.COL_COD_STORE);
					dataInfo.description = stmtResult.getString(StorextsnapDaoDbTableColumn.COL_DESCRIPTION);
					dataInfo.codLanguage = stmtResult.getString(StorextsnapDaoDbTableColumn.COL_COD_LANGUAGE);	
					dataInfo.isDefault = stmtResult.getBoolean(StorextsnapDaoDbTableColumn.COL_IS_DEFAULT);	
					dataInfo.recordMode = stmtResult.getString(StorextsnapDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, StorextsnapDaoDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, StorextsnapDaoDbTableColumn.COL_LAST_CHANGED_BY);					
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, StorextsnapDaoDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, StorextsnapDaoDbTableColumn.COL_CREATED_BY);					
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
