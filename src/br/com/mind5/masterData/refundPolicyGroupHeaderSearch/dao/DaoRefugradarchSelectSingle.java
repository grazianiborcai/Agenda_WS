package br.com.mind5.masterData.refundPolicyGroupHeaderSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.masterData.refundPolicyGroupHeaderSearch.info.RefugradarchInfo;

public final class DaoRefugradarchSelectSingle extends DaoStmtTemplate<RefugradarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.REFUND_POLICY_GROUP_HEADER_TABLE;
	
	
	public DaoRefugradarchSelectSingle(Connection conn, RefugradarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.REFUND_POLICY_GROUP_HEADER_SEARCH_VIEW;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, RefugradarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new DaoRefugradarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(RefugradarchInfo recordInfo) {
		DaoJoinBuilder joinText = new DaoRefugradarchJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<RefugradarchInfo> getResultParserHook() {
		return new DaoResultParser<RefugradarchInfo>() {
			@Override public List<RefugradarchInfo> parseResult(RefugradarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<RefugradarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					RefugradarchInfo dataInfo = new RefugradarchInfo();
					
					dataInfo.codRefundPolicyGroup = DaoFormatter.sqlToInt(stmtResult, DaoRefugradarchDbTableColumn.COL_COD_REFUND_POLICY_GROUP);
					dataInfo.txtRefundPolicyGroup = stmtResult.getString(DaoRefugradarchDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(DaoRefugradarchDbTableColumn.COL_COD_LANGUAGE);	
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
