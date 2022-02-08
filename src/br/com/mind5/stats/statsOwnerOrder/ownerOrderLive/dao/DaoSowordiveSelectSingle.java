package br.com.mind5.stats.statsOwnerOrder.ownerOrderLive.dao;

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
import br.com.mind5.stats.statsOwnerOrder.ownerOrderLive.info.SowordiveInfo;

public final class DaoSowordiveSelectSingle extends DaoStmtTemplate<SowordiveInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_STORE_ORDER_DASH_LIVE_TABLE;	
	
	
	public DaoSowordiveSelectSingle(Connection conn, SowordiveInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SowordiveInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoSowordiveWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<SowordiveInfo> getResultParserHook() {
		return new DaoResultParser<SowordiveInfo>() {
			@Override public List<SowordiveInfo> parseResult(SowordiveInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SowordiveInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					SowordiveInfo dataInfo = new SowordiveInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoSowordiveDbTableColumn.COL_COD_OWNER);
					dataInfo.calmonth = stmtResult.getString(DaoSowordiveDbTableColumn.COL_CALMONTH);
					dataInfo.year = DaoFormatter.sqlToInt(stmtResult, DaoSowordiveDbTableColumn.COL_YEAR);
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, DaoSowordiveDbTableColumn.COL_MONTH);
					dataInfo.codCountry = stmtResult.getString(DaoSowordiveDbTableColumn.COL_COD_COUNTRY);
					dataInfo.codState = stmtResult.getString(DaoSowordiveDbTableColumn.COL_STATE_PROVINCE);
					dataInfo.city = stmtResult.getString(DaoSowordiveDbTableColumn.COL_CITY);
					dataInfo.totalFeeMonth = DaoFormatter.sqlToDouble(stmtResult, DaoSowordiveDbTableColumn.COL_TOTAL_FEE_MONTH);
					dataInfo.totalFeeLastYear = DaoFormatter.sqlToDouble(stmtResult, DaoSowordiveDbTableColumn.COL_TOTAL_FEE_MONTH_LAST_YEAR);
					dataInfo.totalFeeVar = DaoFormatter.sqlToDouble(stmtResult, DaoSowordiveDbTableColumn.COL_TOTAL_FEE_VAR);
					dataInfo.totalSaleMonth = DaoFormatter.sqlToDouble(stmtResult, DaoSowordiveDbTableColumn.COL_TOTAL_SALE_MONTH);
					dataInfo.totalSaleLastYear = DaoFormatter.sqlToDouble(stmtResult, DaoSowordiveDbTableColumn.COL_TOTAL_SALE_MONTH_LAST_YEAR);
					dataInfo.totalSaleVar = DaoFormatter.sqlToDouble(stmtResult, DaoSowordiveDbTableColumn.COL_TOTAL_SALE_VAR);
					dataInfo.countOrderMonth = DaoFormatter.sqlToInt(stmtResult, DaoSowordiveDbTableColumn.COL_COUNT_ORDER_TOTAL_MONTH);
					dataInfo.countOrderLastYear = DaoFormatter.sqlToInt(stmtResult, DaoSowordiveDbTableColumn.COL_COUNT_ORDER_TOTAL_MONTH_LAST_YEAR);
					dataInfo.countOrderVar = DaoFormatter.sqlToDouble(stmtResult, DaoSowordiveDbTableColumn.COL_COUNT_ORDER_TOTAL_VAR);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
