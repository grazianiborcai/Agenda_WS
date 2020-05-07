package br.com.mind5.masterData.refundPolicyGroupHeader.dao;

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
import br.com.mind5.masterData.refundPolicyGroupHeader.info.RefugraderInfo;

public final class DaoRefugraderSelectSingle extends DaoStmtTemplate<RefugraderInfo> {
	private final String MAIN_TABLE = DaoDbTable.REFUND_POLICY_GROUP_HEADER_TABLE;
	
	
	public DaoRefugraderSelectSingle(Connection conn, RefugraderInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, RefugraderInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoRefugraderWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(RefugraderInfo recordInfo) {
		DaoJoinBuilder joinText = new DaoRefugraderJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<RefugraderInfo> getResultParserHook() {
		return new DaoResultParser<RefugraderInfo>() {
			@Override public List<RefugraderInfo> parseResult(RefugraderInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<RefugraderInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					RefugraderInfo dataInfo = new RefugraderInfo();
					
					dataInfo.codRefundPolicyGroup = DaoFormatter.sqlToInt(stmtResult, DaoRefugraderDbTableColumn.COL_COD_REFUND_POLICY_GROUP);
					dataInfo.txtRefundPolicyGroup = stmtResult.getString(DaoRefugraderDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(DaoRefugraderDbTableColumn.COL_COD_LANGUAGE);	
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
