package br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.dao;

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
import br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.info.SowalagrInfo;

public final class SowalagrDaoSelectSingle extends DaoStmtTemplate<SowalagrInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_OWNER_SALE_TABLE;
	
	
	public SowalagrDaoSelectSingle(Connection conn, SowalagrInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SowalagrInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new SowalagrDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<SowalagrInfo> getResultParserHook() {
		return new DaoResultParser<SowalagrInfo>() {
			@Override public List<SowalagrInfo> parseResult(SowalagrInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SowalagrInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					SowalagrInfo dataInfo = new SowalagrInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, SowalagrDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codCountry = stmtResult.getString(SowalagrDaoDbTableColumn.COL_COD_COUNTRY);
					dataInfo.codState = stmtResult.getString(SowalagrDaoDbTableColumn.COL_STATE_PROVINCE);
					dataInfo.city = stmtResult.getString(SowalagrDaoDbTableColumn.COL_CITY);					
					dataInfo.totalFee12m = DaoFormatter.sqlToDouble(stmtResult, SowalagrDaoDbTableColumn.COL_TOTAL_FEE_12M);
					dataInfo.totalFee30d = DaoFormatter.sqlToDouble(stmtResult, SowalagrDaoDbTableColumn.COL_TOTAL_FEE_30D);
					dataInfo.totalFeeCancelled12m = DaoFormatter.sqlToDouble(stmtResult, SowalagrDaoDbTableColumn.COL_TOTAL_FEE_CANCELLED_12M);
					dataInfo.totalFeeCancelled30d = DaoFormatter.sqlToDouble(stmtResult, SowalagrDaoDbTableColumn.COL_TOTAL_FEE_CANCELLED_30D);
					dataInfo.totalFeePaid12m = DaoFormatter.sqlToDouble(stmtResult, SowalagrDaoDbTableColumn.COL_TOTAL_FEE_PAID_12M);
					dataInfo.totalFeePaid30d = DaoFormatter.sqlToDouble(stmtResult, SowalagrDaoDbTableColumn.COL_TOTAL_FEE_PAID_30D);
					dataInfo.totalFeePlaced12m = DaoFormatter.sqlToDouble(stmtResult, SowalagrDaoDbTableColumn.COL_TOTAL_FEE_PLACED_12M);
					dataInfo.totalFeePlaced30d = DaoFormatter.sqlToDouble(stmtResult, SowalagrDaoDbTableColumn.COL_TOTAL_FEE_PLACED_30D);
					dataInfo.totalFeeWaiting12m = DaoFormatter.sqlToDouble(stmtResult, SowalagrDaoDbTableColumn.COL_TOTAL_FEE_WAITING_12M);
					dataInfo.totalFeeWaiting30d = DaoFormatter.sqlToDouble(stmtResult, SowalagrDaoDbTableColumn.COL_TOTAL_FEE_WAITING_30D);					
					dataInfo.totalSale12m = DaoFormatter.sqlToDouble(stmtResult, SowalagrDaoDbTableColumn.COL_TOTAL_SALE_12M);
					dataInfo.totalSale30d = DaoFormatter.sqlToDouble(stmtResult, SowalagrDaoDbTableColumn.COL_TOTAL_SALE_30D);
					dataInfo.totalSaleCancelled12m = DaoFormatter.sqlToDouble(stmtResult, SowalagrDaoDbTableColumn.COL_TOTAL_SALE_CANCELLED_12M);
					dataInfo.totalSaleCancelled30d = DaoFormatter.sqlToDouble(stmtResult, SowalagrDaoDbTableColumn.COL_TOTAL_SALE_CANCELLED_30D);
					dataInfo.totalSaleCreated12m = DaoFormatter.sqlToDouble(stmtResult, SowalagrDaoDbTableColumn.COL_TOTAL_SALE_CREATED_12M);
					dataInfo.totalSaleCreated30d = DaoFormatter.sqlToDouble(stmtResult, SowalagrDaoDbTableColumn.COL_TOTAL_SALE_CREATED_30D);
					dataInfo.totalSalePaid12m = DaoFormatter.sqlToDouble(stmtResult, SowalagrDaoDbTableColumn.COL_TOTAL_SALE_PAID_12M);
					dataInfo.totalSalePaid30d = DaoFormatter.sqlToDouble(stmtResult, SowalagrDaoDbTableColumn.COL_TOTAL_SALE_PAID_30D);
					dataInfo.totalSalePlaced12m = DaoFormatter.sqlToDouble(stmtResult, SowalagrDaoDbTableColumn.COL_TOTAL_SALE_PLACED_12M);
					dataInfo.totalSalePlaced30d = DaoFormatter.sqlToDouble(stmtResult, SowalagrDaoDbTableColumn.COL_TOTAL_SALE_PLACED_30D);
					dataInfo.totalSaleWaiting12m = DaoFormatter.sqlToDouble(stmtResult, SowalagrDaoDbTableColumn.COL_TOTAL_SALE_WAITING_12M);
					dataInfo.totalSaleWaiting30d = DaoFormatter.sqlToDouble(stmtResult, SowalagrDaoDbTableColumn.COL_TOTAL_SALE_WAITING_30D);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, SowalagrDaoDbTableColumn.COL_LAST_CHANGED);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
