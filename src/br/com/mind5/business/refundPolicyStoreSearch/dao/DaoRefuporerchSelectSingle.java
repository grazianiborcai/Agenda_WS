package br.com.mind5.business.refundPolicyStoreSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyStoreSearch.info.RefuporerchInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoRefuporerchSelectSingle extends DaoStmtTemplate<RefuporerchInfo> {
	private final String MAIN_TABLE = DaoDbTable.REFUND_POLICY_STORE;
	
	
	public DaoRefuporerchSelectSingle(Connection conn, RefuporerchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	protected String getLookupTableHook() {
		return DaoDbTable.REFUND_POLICY_STORE_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, RefuporerchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoRefuporerchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<RefuporerchInfo> getResultParserHook() {
		return new DaoResultParser<RefuporerchInfo>() {
			@Override public List<RefuporerchInfo> parseResult(RefuporerchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<RefuporerchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					RefuporerchInfo dataInfo = new RefuporerchInfo();
					
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, DaoRefuporerchDbTableColumn.COL_COD_STORE);
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoRefuporerchDbTableColumn.COL_COD_OWNER);
					dataInfo.codRefundPolicy = DaoFormatter.sqlToInt(stmtResult, DaoRefuporerchDbTableColumn.COL_COD_REFUND_POLICY);					
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
