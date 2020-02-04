package br.com.mind5.business.orderItemSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class OrdemrapSelectSingle extends DaoStmtTemplate<OrdemrapInfo> {	
	private final String MAIN_TABLE = DaoDbTable.ORDER_ITM_SNAPSHOT_TABLE;
	
	
	public OrdemrapSelectSingle(Connection conn, OrdemrapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, OrdemrapInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new OrdemrapWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<OrdemrapInfo> getResultParserHook() {
		return new DaoResultParser<OrdemrapInfo>() {
			@Override public List<OrdemrapInfo> parseResult(OrdemrapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<OrdemrapInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					OrdemrapInfo dataInfo = new OrdemrapInfo();
					
					dataInfo.codOwner = stmtResult.getLong(OrdemrapDbTableColumn.COL_COD_OWNER);	
					dataInfo.codSnapshot = stmtResult.getLong(OrdemrapDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codOrder = stmtResult.getLong(OrdemrapDbTableColumn.COL_COD_ORDER);
					dataInfo.codOrderItem = DaoFormatter.sqlToInt(stmtResult, OrdemrapDbTableColumn.COL_COD_ORDER_ITEM);
					dataInfo.quantity = stmtResult.getInt(OrdemrapDbTableColumn.COL_QUANTITY);
					dataInfo.codCurr = stmtResult.getString(OrdemrapDbTableColumn.COL_COD_CURRENCY);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, OrdemrapDbTableColumn.COL_COD_STORE);
					dataInfo.codStoreSnapshot = DaoFormatter.sqlToLong(stmtResult, OrdemrapDbTableColumn.COL_COD_STORE_SNAPSHOT);
					dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, OrdemrapDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codEmployeeSnapshot = DaoFormatter.sqlToLong(stmtResult, OrdemrapDbTableColumn.COL_COD_EMPLOYEE_SNAPSHOT);
					dataInfo.codMat = DaoFormatter.sqlToLong(stmtResult, OrdemrapDbTableColumn.COL_COD_MATERIAL);
					dataInfo.codMatSnapshot = DaoFormatter.sqlToLong(stmtResult, OrdemrapDbTableColumn.COL_COD_MATERIAL_SNAPSHOT);
					dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, OrdemrapDbTableColumn.COL_DATE);
					dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, OrdemrapDbTableColumn.COL_BEGIN_TIME);
					dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, OrdemrapDbTableColumn.COL_END_TIME);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, OrdemrapDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = stmtResult.getLong(OrdemrapDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.price = DaoFormatter.sqlToDouble(stmtResult, OrdemrapDbTableColumn.COL_PRICE);
					dataInfo.totitem = DaoFormatter.sqlToDouble(stmtResult, OrdemrapDbTableColumn.COL_TOTAL_ITEM);				
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
