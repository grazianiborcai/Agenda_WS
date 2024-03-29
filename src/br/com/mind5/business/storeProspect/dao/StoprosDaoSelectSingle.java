package br.com.mind5.business.storeProspect.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class StoprosDaoSelectSingle extends DaoStmtTemplate<StoprosInfo> {
	private final String MAIN_TABLE = DaoDbTable.STORE_PROSPECT_TABLE;	
	
	
	public StoprosDaoSelectSingle(Connection conn, StoprosInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StoprosInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new StoprosDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<StoprosInfo> getResultParserHook() {
		return new DaoResultParser<StoprosInfo>() {
			@Override public List<StoprosInfo> parseResult(StoprosInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StoprosInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StoprosInfo dataInfo = new StoprosInfo();
					
					dataInfo.codOwner = stmtResult.getLong(StoprosDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codStoreProspect = stmtResult.getLong(StoprosDaoDbTableColumn.COL_COD_STORE_PROSPECT);
					dataInfo.recordMode = stmtResult.getString(StoprosDaoDbTableColumn.COL_RECORD_MODE);	
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, StoprosDaoDbTableColumn.COL_LAST_CHANGED);
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, StoprosDaoDbTableColumn.COL_CREATED_ON);
					dataInfo.prospectEmail = stmtResult.getString(StoprosDaoDbTableColumn.COL_PROSPECT_EMAIL);
					dataInfo.prospectName = stmtResult.getString(StoprosDaoDbTableColumn.COL_PROSPECT_NAME);
					dataInfo.prospectPhone = stmtResult.getString(StoprosDaoDbTableColumn.COL_PROSPECT_PHONE);					
					dataInfo.codProspectStatus = stmtResult.getString(StoprosDaoDbTableColumn.COL_COD_PROSPECT_STATUS);
					dataInfo.notes = stmtResult.getString(StoprosDaoDbTableColumn.COL_NOTES);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
