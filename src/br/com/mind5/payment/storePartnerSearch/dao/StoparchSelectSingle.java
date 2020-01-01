package br.com.mind5.payment.storePartnerSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;

public final class StoparchSelectSingle extends DaoStmtTemplate<StoparchInfo> {
	private final String MAIN_TABLE = DaoDbTable.PAY_PARTNER_STORE_TABLE;
	
	
	public StoparchSelectSingle(Connection conn, StoparchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.PAY_PARTNER_STORE_SEARCH_VIEW;
	}	
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StoparchInfo recordInfo) {	
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new StoparchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParserV2<StoparchInfo> getResultParserHook() {
		return new DaoResultParserV2<StoparchInfo>() {
			@Override public List<StoparchInfo> parseResult(StoparchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StoparchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StoparchInfo dataInfo = new StoparchInfo();
					
					dataInfo.codOwner = stmtResult.getLong(StoparchDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(StoparchDbTableColumn.COL_COD_STORE);
					dataInfo.codPayPartner = stmtResult.getInt(StoparchDbTableColumn.COL_COD_PAY_PARTNER);
					dataInfo.recordMode = stmtResult.getString(StoparchDbTableColumn.COL_RECORD_MODE);
					dataInfo.codePayPartnerStore = stmtResult.getString(StoparchDbTableColumn.COL_CODE_PAY_PARTNER_STORE);
					dataInfo.idPayPartnerStore = stmtResult.getString(StoparchDbTableColumn.COL_ID_PAY_PARTNER_STORE);	
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
