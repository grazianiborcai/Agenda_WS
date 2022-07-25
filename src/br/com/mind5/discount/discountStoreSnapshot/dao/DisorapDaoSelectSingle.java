package br.com.mind5.discount.discountStoreSnapshot.dao;

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
import br.com.mind5.discount.discountStoreSnapshot.info.DisorapInfo;

public final class DisorapDaoSelectSingle extends DaoStmtTemplate<DisorapInfo> {	
	private final String MAIN_TABLE = DaoDbTable.DISCOUNT_STORE_SNAPSHOT_TABLE;	
	
	
	
	public DisorapDaoSelectSingle(Connection conn, DisorapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, DisorapInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DisorapDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<DisorapInfo> getResultParserHook() {
		return new DaoResultParser<DisorapInfo>() {
			@Override public List<DisorapInfo> parseResult(DisorapInfo redcordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<DisorapInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					DisorapInfo dataInfo = new DisorapInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DisorapDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, DisorapDaoDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codDiscount = DaoFormatter.sqlToLong(stmtResult, DisorapDaoDbTableColumn.COL_COD_DISCOUNT);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, DisorapDaoDbTableColumn.COL_COD_STORE);		
					dataInfo.codDiscountStrategy = DaoFormatter.sqlToInt(stmtResult, DisorapDaoDbTableColumn.COL_COD_DISCOUNT_STRATEGY);
					dataInfo.discountPercent = DaoFormatter.sqlToInt(stmtResult, DisorapDaoDbTableColumn.COL_DISCOUNT_PERCENT);
					dataInfo.isActive = DaoFormatter.sqlToBoole(stmtResult, DisorapDaoDbTableColumn.COL_IS_ACTIVE);					
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DisorapDaoDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, DisorapDaoDbTableColumn.COL_LAST_CHANGED_BY);				
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, DisorapDaoDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, DisorapDaoDbTableColumn.COL_CREATED_BY);
					dataInfo.validFrom = DaoFormatter.sqlToLocalDateTime(stmtResult, DisorapDaoDbTableColumn.COL_VALID_FROM);
					dataInfo.validTo = DaoFormatter.sqlToLocalDateTime(stmtResult, DisorapDaoDbTableColumn.COL_VALID_TO);
					
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
