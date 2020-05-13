package br.com.mind5.business.orderItemList.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemList.info.OrdemistInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoOrdemistSelectSingle extends DaoStmtTemplate<OrdemistInfo> {	
	private final String MAIN_TABLE = DaoDbTable.ORDER_ITM_TABLE;
	
	
	public DaoOrdemistSelectSingle(Connection conn, OrdemistInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.ORDER_ITM_LIST_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, OrdemistInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoOrdemistWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<OrdemistInfo> getResultParserHook() {
		return new DaoResultParser<OrdemistInfo>() {
			@Override public List<OrdemistInfo> parseResult(OrdemistInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {			
				List<OrdemistInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					OrdemistInfo dataInfo = new OrdemistInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoOrdemistDbTableColumn.COL_COD_OWNER);	
					dataInfo.codOrder = stmtResult.getLong(DaoOrdemistDbTableColumn.COL_COD_ORDER);
					dataInfo.codOrderItem = DaoFormatter.sqlToInt(stmtResult, DaoOrdemistDbTableColumn.COL_COD_ORDER_ITEM);
					dataInfo.quantity = stmtResult.getInt(DaoOrdemistDbTableColumn.COL_QUANTITY);
					dataInfo.codCurr = stmtResult.getString(DaoOrdemistDbTableColumn.COL_COD_CURRENCY);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, DaoOrdemistDbTableColumn.COL_COD_STORE);
					dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, DaoOrdemistDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codMat = DaoFormatter.sqlToLong(stmtResult, DaoOrdemistDbTableColumn.COL_COD_MATERIAL);
					dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, DaoOrdemistDbTableColumn.COL_DATE);
					dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, DaoOrdemistDbTableColumn.COL_BEGIN_TIME);
					dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, DaoOrdemistDbTableColumn.COL_END_TIME);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoOrdemistDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = stmtResult.getLong(DaoOrdemistDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.price = DaoFormatter.sqlToDouble(stmtResult, DaoOrdemistDbTableColumn.COL_PRICE);
					dataInfo.totitem = DaoFormatter.sqlToDouble(stmtResult, DaoOrdemistDbTableColumn.COL_TOTAL_ITEM);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoOrdemistDbTableColumn.COL_COD_SNAPSHOT);	
					dataInfo.codOrderStatus = stmtResult.getString(DaoOrdemistDbTableColumn.COL_COD_ORDER_STATUS);
					dataInfo.codPayOrder = DaoFormatter.sqlToLong(stmtResult, DaoOrdemistDbTableColumn.COL_COD_PAY_ORDER);
					dataInfo.codPayOrderItem = DaoFormatter.sqlToInt(stmtResult, DaoOrdemistDbTableColumn.COL_COD_PAY_ORDER_ITEM);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
