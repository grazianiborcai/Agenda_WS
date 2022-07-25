package br.com.mind5.masterData.refundPolicyGroupSearch.dao;

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
import br.com.mind5.masterData.refundPolicyGroupSearch.info.RefugrarchInfo;

public final class RefugrarchDaoSelectSingle extends DaoStmtTemplate<RefugrarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.REFUND_POLICY_GROUP_HEADER_TABLE;
	
	
	public RefugrarchDaoSelectSingle(Connection conn, RefugrarchInfo recordInfo, String schemaName) {
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
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, RefugrarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new RefugrarchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(RefugrarchInfo recordInfo) {
		DaoJoinBuilder joinText = new RefugrarchDaoJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<RefugrarchInfo> getResultParserHook() {
		return new DaoResultParser<RefugrarchInfo>() {
			@Override public List<RefugrarchInfo> parseResult(RefugrarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<RefugrarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					RefugrarchInfo dataInfo = new RefugrarchInfo();
					
					dataInfo.codRefundPolicyGroup = DaoFormatter.sqlToInt(stmtResult, RefugrarchDaoDbTableColumn.COL_COD_REFUND_POLICY_GROUP);
					dataInfo.txtRefundPolicyGroup = stmtResult.getString(RefugrarchDaoDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(RefugrarchDaoDbTableColumn.COL_COD_LANGUAGE);	
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
