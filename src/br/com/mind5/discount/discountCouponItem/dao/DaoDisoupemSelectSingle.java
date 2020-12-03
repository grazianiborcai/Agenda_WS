package br.com.mind5.discount.discountCouponItem.dao;

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
import br.com.mind5.discount.discountCouponItem.info.DisoupemInfo;

public final class DaoDisoupemSelectSingle extends DaoStmtTemplate<DisoupemInfo> {	
	private final String MAIN_TABLE = DaoDbTable.DISCOUNT_COUPON_TABLE;	
	
	
	
	public DaoDisoupemSelectSingle(Connection conn, DisoupemInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, DisoupemInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoDisoupemWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<DisoupemInfo> getResultParserHook() {
		return new DaoResultParser<DisoupemInfo>() {
			@Override public List<DisoupemInfo> parseResult(DisoupemInfo redcordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<DisoupemInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					DisoupemInfo dataInfo = new DisoupemInfo();
					
					dataInfo.codDiscount = DaoFormatter.sqlToLong(stmtResult, DaoDisoupemDbTableColumn.COL_COD_DISCOUNT);
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoDisoupemDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, DaoDisoupemDbTableColumn.COL_COD_STORE);		
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoDisoupemDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codDiscountStrategy = DaoFormatter.sqlToInt(stmtResult, DaoDisoupemDbTableColumn.COL_COD_DISCOUNT_STRATEGY);
					dataInfo.discountPercent = DaoFormatter.sqlToInt(stmtResult, DaoDisoupemDbTableColumn.COL_DISCOUNT_PERCENT);
					dataInfo.isActive = DaoFormatter.sqlToBoole(stmtResult, DaoDisoupemDbTableColumn.COL_IS_ACTIVE);					
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoDisoupemDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, DaoDisoupemDbTableColumn.COL_LAST_CHANGED_BY);				
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoDisoupemDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, DaoDisoupemDbTableColumn.COL_CREATED_BY);
					dataInfo.validFrom = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoDisoupemDbTableColumn.COL_VALID_FROM);
					dataInfo.validTo = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoDisoupemDbTableColumn.COL_VALID_TO);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		super.executeStmt();
	}
}
