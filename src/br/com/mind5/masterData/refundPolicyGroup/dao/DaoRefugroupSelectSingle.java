package br.com.mind5.masterData.refundPolicyGroup.dao;

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
import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;

public final class DaoRefugroupSelectSingle extends DaoStmtTemplate<RefugroupInfo> {
	private final String MAIN_TABLE = DaoDbTable.REFUND_POLICY_GROUP_HEADER_TABLE;
	
	
	public DaoRefugroupSelectSingle(Connection conn, RefugroupInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, RefugroupInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoRefugroupWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(RefugroupInfo recordInfo) {
		DaoJoinBuilder joinText = new DaoRefugroupJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<RefugroupInfo> getResultParserHook() {
		return new DaoResultParser<RefugroupInfo>() {
			@Override public List<RefugroupInfo> parseResult(RefugroupInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<RefugroupInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					RefugroupInfo dataInfo = new RefugroupInfo();
					
					dataInfo.codRefundPolicyGroup = DaoFormatter.sqlToInt(stmtResult, DaoRefugroupDbTableColumn.COL_COD_REFUND_POLICY_GROUP);
					dataInfo.txtRefundPolicyGroup = stmtResult.getString(DaoRefugroupDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(DaoRefugroupDbTableColumn.COL_COD_LANGUAGE);	
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
