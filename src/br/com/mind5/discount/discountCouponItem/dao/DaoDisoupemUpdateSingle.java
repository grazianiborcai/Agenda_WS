package br.com.mind5.discount.discountCouponItem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.discount.discountCouponItem.info.DisoupemInfo;

public final class DaoDisoupemUpdateSingle extends DaoStmtTemplate<DisoupemInfo> {
	private final String MAIN_TABLE = DaoDbTable.DISCOUNT_COUPON_TABLE;	
	
	
	public DaoDisoupemUpdateSingle(Connection conn, DisoupemInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.UPDATE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, DisoupemInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;
		
		DaoStmtWhere whereClause = new DaoDisoupemWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoStmtParamTranslator<DisoupemInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<DisoupemInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, DisoupemInfo recordInfo) throws SQLException {
				int i = 1;			
				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codSnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codDiscountStrategy);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.discountPercent);
				stmt.setBoolean(i++, recordInfo.isActive);								
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);			
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.validFrom);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.validTo);
				
				return stmt;
			}		
		};
	}
}
