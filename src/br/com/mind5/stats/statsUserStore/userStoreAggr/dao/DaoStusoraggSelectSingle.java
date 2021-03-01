package br.com.mind5.stats.statsUserStore.userStoreAggr.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.stats.statsUserStore.userStoreAggr.info.StusoraggInfo;

public final class DaoStusoraggSelectSingle extends DaoStmtTemplate<StusoraggInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_USER_STORE_AGGR_TABLE;	
	
	
	public DaoStusoraggSelectSingle(Connection conn, StusoraggInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StusoraggInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoStusoraggWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<StusoraggInfo> getResultParserHook() {
		return new DaoResultParser<StusoraggInfo>() {
			@Override public List<StusoraggInfo> parseResult(StusoraggInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StusoraggInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StusoraggInfo dataInfo = new StusoraggInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoStusoraggDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, DaoStusoraggDbTableColumn.COL_COD_STORE);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, DaoStusoraggDbTableColumn.COL_COD_USER);
					dataInfo.codCurr = stmtResult.getString(DaoStusoraggDbTableColumn.COL_COD_CURRENCY);
					dataInfo.totalPrice = DaoFormatter.sqlToDouble(stmtResult, DaoStusoraggDbTableColumn.COL_TOTAL_PRICE);
					dataInfo.totalPrice01m = DaoFormatter.sqlToDouble(stmtResult, DaoStusoraggDbTableColumn.COL_TOTAL_PRICE_01M);
					dataInfo.totalPrice03m = DaoFormatter.sqlToDouble(stmtResult, DaoStusoraggDbTableColumn.COL_TOTAL_PRICE_03M);
					dataInfo.totalPrice06m = DaoFormatter.sqlToDouble(stmtResult, DaoStusoraggDbTableColumn.COL_TOTAL_PRICE_06M);
					dataInfo.totalPrice12m = DaoFormatter.sqlToDouble(stmtResult, DaoStusoraggDbTableColumn.COL_TOTAL_PRICE_12M);
					dataInfo.totalPrice24m = DaoFormatter.sqlToDouble(stmtResult, DaoStusoraggDbTableColumn.COL_TOTAL_PRICE_24M);					
					dataInfo.totalQuantity = DaoFormatter.sqlToInt(stmtResult, DaoStusoraggDbTableColumn.COL_TOTAL_QUANTITY);
					dataInfo.totalQuantity01m = DaoFormatter.sqlToInt(stmtResult, DaoStusoraggDbTableColumn.COL_TOTAL_QUANTITY_01M);
					dataInfo.totalQuantity03m = DaoFormatter.sqlToInt(stmtResult, DaoStusoraggDbTableColumn.COL_TOTAL_QUANTITY_03M);
					dataInfo.totalQuantity06m = DaoFormatter.sqlToInt(stmtResult, DaoStusoraggDbTableColumn.COL_TOTAL_QUANTITY_06M);
					dataInfo.totalQuantity12m = DaoFormatter.sqlToInt(stmtResult, DaoStusoraggDbTableColumn.COL_TOTAL_QUANTITY_12M);
					dataInfo.totalQuantity24m = DaoFormatter.sqlToInt(stmtResult, DaoStusoraggDbTableColumn.COL_TOTAL_QUANTITY_24M);					
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoStusoraggDbTableColumn.COL_LAST_CHANGED);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
