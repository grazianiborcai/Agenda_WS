package br.com.mind5.business.refundPolicyOwnerSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyOwnerSearch.info.RefupowarchInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoRefupowarchSelectSingle extends DaoStmtTemplate<RefupowarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.REFUND_POLICY_OWNER_TABLE;
	
	
	public DaoRefupowarchSelectSingle(Connection conn, RefupowarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	protected String getLookupTableHook() {
		return DaoDbTable.REFUND_POLICY_OWNER_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, RefupowarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoRefupowarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<RefupowarchInfo> getResultParserHook() {
		return new DaoResultParser<RefupowarchInfo>() {
			@Override public List<RefupowarchInfo> parseResult(RefupowarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<RefupowarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					RefupowarchInfo dataInfo = new RefupowarchInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoRefupowarchDbTableColumn.COL_COD_OWNER);
					dataInfo.codRefundPolicyGroup = DaoFormatter.sqlToInt(stmtResult, DaoRefupowarchDbTableColumn.COL_COD_REFUND_POLICY_GROUP);					
					dataInfo.recordMode = stmtResult.getString(DaoRefupowarchDbTableColumn.COL_RECORD_MODE);
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
