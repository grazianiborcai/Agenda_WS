package br.com.mind5.business.storeProspectSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeProspectSearch.info.StoprarchInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoStoprarchSelectSingle extends DaoStmtTemplate<StoprarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.STORE_PROSPECT_TABLE;	
	
	
	public DaoStoprarchSelectSingle(Connection conn, StoprarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.STORE_PROSPECT_SEARCH_VIEW;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StoprarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoStoprarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<StoprarchInfo> getResultParserHook() {
		return new DaoResultParser<StoprarchInfo>() {
			@Override public List<StoprarchInfo> parseResult(StoprarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StoprarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StoprarchInfo dataInfo = new StoprarchInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoStoprarchDbTableColumn.COL_COD_OWNER);
					dataInfo.codStoreProspect = stmtResult.getLong(DaoStoprarchDbTableColumn.COL_COD_STORE_PROSPECT);
					dataInfo.recordMode = stmtResult.getString(DaoStoprarchDbTableColumn.COL_RECORD_MODE);	
					dataInfo.prospectEmail = stmtResult.getString(DaoStoprarchDbTableColumn.COL_PROSPECT_EMAIL);
					dataInfo.prospectName = stmtResult.getString(DaoStoprarchDbTableColumn.COL_PROSPECT_NAME);
					dataInfo.prospectPhone = stmtResult.getString(DaoStoprarchDbTableColumn.COL_PROSPECT_PHONE);					
					dataInfo.codProspectStatus = stmtResult.getString(DaoStoprarchDbTableColumn.COL_COD_PROSPECT_STATUS);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
