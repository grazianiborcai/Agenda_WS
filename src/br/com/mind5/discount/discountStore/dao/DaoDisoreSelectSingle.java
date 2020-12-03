package br.com.mind5.discount.discountStore.dao;

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
import br.com.mind5.discount.discountStore.info.DisoreInfo;

public final class DaoDisoreSelectSingle extends DaoStmtTemplate<DisoreInfo> {	
	private final String MAIN_TABLE = DaoDbTable.DISCOUNT_STORE_TABLE;	
	
	
	
	public DaoDisoreSelectSingle(Connection conn, DisoreInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, DisoreInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoDisoreWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<DisoreInfo> getResultParserHook() {
		return new DaoResultParser<DisoreInfo>() {
			@Override public List<DisoreInfo> parseResult(DisoreInfo redcordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<DisoreInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					DisoreInfo dataInfo = new DisoreInfo();
					
					dataInfo.codDiscount = DaoFormatter.sqlToLong(stmtResult, DaoDisoreDbTableColumn.COL_COD_DISCOUNT);
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoDisoreDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, DaoDisoreDbTableColumn.COL_COD_STORE);		
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoDisoreDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codDiscountStrategy = DaoFormatter.sqlToInt(stmtResult, DaoDisoreDbTableColumn.COL_COD_DISCOUNT_STRATEGY);
					dataInfo.discountPercent = DaoFormatter.sqlToInt(stmtResult, DaoDisoreDbTableColumn.COL_DISCOUNT_PERCENT);
					dataInfo.isActive = DaoFormatter.sqlToBoole(stmtResult, DaoDisoreDbTableColumn.COL_IS_ACTIVE);					
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoDisoreDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, DaoDisoreDbTableColumn.COL_LAST_CHANGED_BY);				
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoDisoreDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, DaoDisoreDbTableColumn.COL_CREATED_BY);
					dataInfo.validFrom = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoDisoreDbTableColumn.COL_VALID_FROM);
					dataInfo.validTo = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoDisoreDbTableColumn.COL_VALID_TO);
					
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
