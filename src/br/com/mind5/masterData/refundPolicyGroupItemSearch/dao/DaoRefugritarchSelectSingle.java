package br.com.mind5.masterData.refundPolicyGroupItemSearch.dao;

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
import br.com.mind5.masterData.refundPolicyGroupItemSearch.info.RefugritarchInfo;

public final class DaoRefugritarchSelectSingle extends DaoStmtTemplate<RefugritarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.REFUND_POLICY_GROUP_ITEM_TABLE;
	
	
	public DaoRefugritarchSelectSingle(Connection conn, RefugritarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.REFUND_POLICY_GROUP_ITEM_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, RefugritarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoRefugritarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<RefugritarchInfo> getResultParserHook() {
		return new DaoResultParser<RefugritarchInfo>() {
			@Override public List<RefugritarchInfo> parseResult(RefugritarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<RefugritarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					RefugritarchInfo dataInfo = new RefugritarchInfo();
					
					dataInfo.codRefundPolicyGroup = DaoFormatter.sqlToInt(stmtResult, DaoRefugritarchDbTableColumn.COL_COD_REFUND_POLICY_GROUP);
					dataInfo.codRefundPolicy = DaoFormatter.sqlToInt(stmtResult, DaoRefugritarchDbTableColumn.COL_COD_REFUND_POLICY);					
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
