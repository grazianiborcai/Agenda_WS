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

public final class OrdemistDaoSelectSingle extends DaoStmtTemplate<OrdemistInfo> {	
	private final String MAIN_TABLE = DaoDbTable.ORDER_ITM_TABLE;
	
	
	public OrdemistDaoSelectSingle(Connection conn, OrdemistInfo recordInfo, String schemaName) {
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
		
		DaoStmtWhere whereClause = new OrdemistDaoWhere(whereOption, tableName, recordInfo);
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
					
					dataInfo.codOwner = stmtResult.getLong(OrdemistDaoDbTableColumn.COL_COD_OWNER);	
					dataInfo.codOrder = stmtResult.getLong(OrdemistDaoDbTableColumn.COL_COD_ORDER);		
					dataInfo.codOrderItem = DaoFormatter.sqlToInt(stmtResult, OrdemistDaoDbTableColumn.COL_COD_ORDER_ITEM);
					dataInfo.quantity = stmtResult.getInt(OrdemistDaoDbTableColumn.COL_QUANTITY);
					dataInfo.codCurr = stmtResult.getString(OrdemistDaoDbTableColumn.COL_COD_CURRENCY);
					dataInfo.codCustomer = stmtResult.getLong(OrdemistDaoDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, OrdemistDaoDbTableColumn.COL_COD_STORE);
					dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, OrdemistDaoDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codMat = DaoFormatter.sqlToLong(stmtResult, OrdemistDaoDbTableColumn.COL_COD_MATERIAL);
					dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, OrdemistDaoDbTableColumn.COL_DATE);
					dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, OrdemistDaoDbTableColumn.COL_BEGIN_TIME);
					dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, OrdemistDaoDbTableColumn.COL_END_TIME);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, OrdemistDaoDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = stmtResult.getLong(OrdemistDaoDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.price = DaoFormatter.sqlToDouble(stmtResult, OrdemistDaoDbTableColumn.COL_PRICE);
					dataInfo.totitem = DaoFormatter.sqlToDouble(stmtResult, OrdemistDaoDbTableColumn.COL_TOTAL_ITEM);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, OrdemistDaoDbTableColumn.COL_COD_SNAPSHOT);	
					dataInfo.codOrderStatus = stmtResult.getString(OrdemistDaoDbTableColumn.COL_COD_ORDER_STATUS);
					dataInfo.codPayOrder = DaoFormatter.sqlToLong(stmtResult, OrdemistDaoDbTableColumn.COL_COD_PAY_ORDER);
					dataInfo.codPayOrderItem = DaoFormatter.sqlToInt(stmtResult, OrdemistDaoDbTableColumn.COL_COD_PAY_ORDER_ITEM);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
