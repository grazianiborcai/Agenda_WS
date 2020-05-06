package br.com.mind5.business.refundPolicyOwnerSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyOwnerSearch.info.RefupownarchInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoRefupownarchSelectSingle extends DaoStmtTemplate<RefupownarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.REFUND_POLICY_OWNER;
	
	
	public DaoRefupownarchSelectSingle(Connection conn, RefupownarchInfo recordInfo, String schemaName) {
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
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, RefupownarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoRefupownarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<RefupownarchInfo> getResultParserHook() {
		return new DaoResultParser<RefupownarchInfo>() {
			@Override public List<RefupownarchInfo> parseResult(RefupownarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<RefupownarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					RefupownarchInfo dataInfo = new RefupownarchInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoRefupownarchDbTableColumn.COL_COD_OWNER);
					dataInfo.codRefundPolicy = DaoFormatter.sqlToInt(stmtResult, DaoRefupownarchDbTableColumn.COL_COD_REFUND_POLICY);					
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
