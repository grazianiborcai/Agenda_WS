package br.com.mind5.stats.userStorePurchaseLive.dao;

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
import br.com.mind5.stats.userStorePurchaseLive.info.StusoreveInfo;

public final class DaoStusoreveSelectSingle extends DaoStmtTemplate<StusoreveInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_USER_STORE_TABLE;	
	
	
	public DaoStusoreveSelectSingle(Connection conn, StusoreveInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StusoreveInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoStusoreveWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<StusoreveInfo> getResultParserHook() {
		return new DaoResultParser<StusoreveInfo>() {
			@Override public List<StusoreveInfo> parseResult(StusoreveInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StusoreveInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StusoreveInfo dataInfo = new StusoreveInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoStusoreveDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, DaoStusoreveDbTableColumn.COL_COD_STORE);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, DaoStusoreveDbTableColumn.COL_COD_USER);
					dataInfo.codCurr1 = stmtResult.getString(DaoStusoreveDbTableColumn.COL_COD_CURRENCY_1);
					dataInfo.totalPrice1 = DaoFormatter.sqlToDouble(stmtResult, DaoStusoreveDbTableColumn.COL_TOTAL_PRICE_1);
					dataInfo.totalQuantity = DaoFormatter.sqlToInt(stmtResult, DaoStusoreveDbTableColumn.COL_TOTAL_QUANTITY);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoStusoreveDbTableColumn.COL_LAST_CHANGED);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
