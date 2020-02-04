package br.com.mind5.business.orderSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class OrdarchSelectSingle extends DaoStmtTemplate<OrdarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.ORDER_HDR_TABLE;
	
	
	public OrdarchSelectSingle(Connection conn, OrdarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}	
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.ORDER_SEARCH_VIEW;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, OrdarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new OrdarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<OrdarchInfo> getResultParserHook() {
		return new DaoResultParser<OrdarchInfo>() {
			@Override public List<OrdarchInfo> parseResult(OrdarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<OrdarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					OrdarchInfo dataInfo = new OrdarchInfo();
					dataInfo.codOwner = stmtResult.getLong(OrdarchDbTableColumn.COL_COD_OWNER);	
					dataInfo.codOrder = stmtResult.getLong(OrdarchDbTableColumn.COL_COD_ORDER);
					dataInfo.codUser = stmtResult.getLong(OrdarchDbTableColumn.COL_COD_USER);	
					dataInfo.codOrderExt = stmtResult.getString(OrdarchDbTableColumn.COL_COD_ORDER_EXTERNAL);	
					dataInfo.codOrderStatus = stmtResult.getString(OrdarchDbTableColumn.COL_COD_ORDER_STATUS);
					dataInfo.codCustomer = stmtResult.getLong(OrdarchDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.codPayOrder = stmtResult.getLong(OrdarchDbTableColumn.COL_COD_PAY_ORDER);				
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
