package br.com.mind5.discount.discountStoreSearch.dao;

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
import br.com.mind5.discount.discountStoreSearch.info.DisorarchInfo;

public final class DaoDisorarchSelectSingle extends DaoStmtTemplate<DisorarchInfo> {	
	private final String MAIN_TABLE = DaoDbTable.DISCOUNT_STORE_TABLE;	
	
	
	
	public DaoDisorarchSelectSingle(Connection conn, DisorarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.DISCOUNT_STORE_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, DisorarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoDisorarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<DisorarchInfo> getResultParserHook() {
		return new DaoResultParser<DisorarchInfo>() {
			@Override public List<DisorarchInfo> parseResult(DisorarchInfo redcordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<DisorarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					DisorarchInfo dataInfo = new DisorarchInfo();
					
					dataInfo.codDiscount = DaoFormatter.sqlToLong(stmtResult, DaoDisorarchDbTableColumn.COL_COD_DISCOUNT);
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoDisorarchDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, DaoDisorarchDbTableColumn.COL_COD_STORE);		
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoDisorarchDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codDiscountStrategy = DaoFormatter.sqlToInt(stmtResult, DaoDisorarchDbTableColumn.COL_COD_DISCOUNT_STRATEGY);
					dataInfo.isActive = DaoFormatter.sqlToBoole(stmtResult, DaoDisorarchDbTableColumn.COL_IS_ACTIVE);					
					dataInfo.validFrom = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoDisorarchDbTableColumn.COL_VALID_FROM);
					dataInfo.validTo = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoDisorarchDbTableColumn.COL_VALID_TO);
					
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
