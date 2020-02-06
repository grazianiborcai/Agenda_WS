package br.com.mind5.business.orderList.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class OrdistSelectSingle extends DaoStmtTemplate<OrdistInfo> {
	private final String MAIN_TABLE = DaoDbTable.ORDER_HDR_TABLE;
	
	
	public OrdistSelectSingle(Connection conn, OrdistInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}	
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.ORDER_LIST_VIEW;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, OrdistInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new OrdistWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
		
	
	
	@Override protected DaoResultParser<OrdistInfo> getResultParserHook() {
		return new DaoResultParser<OrdistInfo>() {
			@Override public List<OrdistInfo> parseResult(OrdistInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<OrdistInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					OrdistInfo dataInfo = new OrdistInfo();
					
					dataInfo.codOwner = stmtResult.getLong(OrdistDbTableColumn.COL_COD_OWNER);	
					dataInfo.codOrder = stmtResult.getLong(OrdistDbTableColumn.COL_COD_ORDER);
					dataInfo.codUser = stmtResult.getLong(OrdistDbTableColumn.COL_COD_USER);	
					dataInfo.codOrderExt = stmtResult.getString(OrdistDbTableColumn.COL_COD_ORDER_EXTERNAL);	
					dataInfo.codOrderStatus = stmtResult.getString(OrdistDbTableColumn.COL_COD_ORDER_STATUS);
					dataInfo.codCurr = stmtResult.getString(OrdistDbTableColumn.COL_COD_CURRENCY);
					dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, OrdistDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, OrdistDbTableColumn.COL_LAST_CHANGED);
					dataInfo.itemTotal = DaoFormatter.sqlToDouble(stmtResult, OrdistDbTableColumn.COL_ITEM_TOTAL);
					dataInfo.feeService = DaoFormatter.sqlToDouble(stmtResult, OrdistDbTableColumn.COL_FEE_SERVICE);
					dataInfo.grandTotal = DaoFormatter.sqlToDouble(stmtResult, OrdistDbTableColumn.COL_GRAND_TOTAL);
					dataInfo.codPayOrder = DaoFormatter.sqlToLong(stmtResult, OrdistDbTableColumn.COL_COD_PAY_ORDER);	
					dataInfo.postingDate = DaoFormatter.sqlToLocalDate(stmtResult, OrdistDbTableColumn.COL_POSTING_DATE);
					dataInfo.postingYear = DaoFormatter.sqlToInt(stmtResult, OrdistDbTableColumn.COL_POSTING_YEAR);
					dataInfo.postingYearMonth = DaoFormatter.sqlToInt(stmtResult, OrdistDbTableColumn.COL_POSTING_YEAR_MONTH);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
