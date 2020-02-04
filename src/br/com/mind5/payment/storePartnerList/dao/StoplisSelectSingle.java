package br.com.mind5.payment.storePartnerList.dao;

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
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;

public final class StoplisSelectSingle extends DaoStmtTemplate<StoplisInfo> {
	private final String MAIN_TABLE = DaoDbTable.PAY_PARTNER_STORE_TABLE;
	
	
	public StoplisSelectSingle(Connection conn, StoplisInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.PAY_PARTNER_STORE_VIEW;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StoplisInfo recordInfo) {		
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new StoplisWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
		
	@Override protected DaoResultParser<StoplisInfo> getResultParserHook() {
		return new DaoResultParser<StoplisInfo>() {
			@Override public List<StoplisInfo> parseResult(StoplisInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StoplisInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StoplisInfo dataInfo = new StoplisInfo();
					
					dataInfo.codOwner = stmtResult.getLong(StoplisDbTableColumn.COL_COD_OWNER);
					dataInfo.codSnapshot = stmtResult.getLong(StoplisDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codStore = stmtResult.getLong(StoplisDbTableColumn.COL_COD_STORE);
					dataInfo.codPayPartner = stmtResult.getInt(StoplisDbTableColumn.COL_COD_PAY_PARTNER);
					dataInfo.recordMode = stmtResult.getString(StoplisDbTableColumn.COL_RECORD_MODE);
					dataInfo.idPayPartnerStore = stmtResult.getString(StoplisDbTableColumn.COL_ID_PAY_PARTNER_STORE);
					dataInfo.scope = stmtResult.getString(StoplisDbTableColumn.COL_SCOPE);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
