package br.com.mind5.business.refundPolicyStoreSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyStoreSearch.info.RefuporarchInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoRefuporarchSelectSingle extends DaoStmtTemplate<RefuporarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.REFUND_POLICY_STORE_TABLE;
	
	
	public DaoRefuporarchSelectSingle(Connection conn, RefuporarchInfo recordInfo, String schemaName) {
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
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, RefuporarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoRefuporarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<RefuporarchInfo> getResultParserHook() {
		return new DaoResultParser<RefuporarchInfo>() {
			@Override public List<RefuporarchInfo> parseResult(RefuporarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<RefuporarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					RefuporarchInfo dataInfo = new RefuporarchInfo();
					
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, DaoRefuporarchDbTableColumn.COL_COD_STORE);
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoRefuporarchDbTableColumn.COL_COD_OWNER);
					dataInfo.codRefundPolicyGroup = DaoFormatter.sqlToInt(stmtResult, DaoRefuporarchDbTableColumn.COL_COD_REFUND_POLICY_GROUP);					
					dataInfo.recordMode = stmtResult.getString(DaoRefuporarchDbTableColumn.COL_RECORD_MODE);
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
