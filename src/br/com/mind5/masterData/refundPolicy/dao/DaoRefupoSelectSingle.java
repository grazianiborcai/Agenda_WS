package br.com.mind5.masterData.refundPolicy.dao;

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
import br.com.mind5.masterData.refundPolicy.info.RefupoInfo;

public final class DaoRefupoSelectSingle extends DaoStmtTemplate<RefupoInfo> {
	private final String MAIN_TABLE = DaoDbTable.REFUND_POLICY_TABLE;
	
	
	public DaoRefupoSelectSingle(Connection conn, RefupoInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, RefupoInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoRefupoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(RefupoInfo recordInfo) {
		DaoJoinBuilder joinText = new DaoRefupoJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<RefupoInfo> getResultParserHook() {
		return new DaoResultParser<RefupoInfo>() {
			@Override public List<RefupoInfo> parseResult(RefupoInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<RefupoInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					RefupoInfo dataInfo = new RefupoInfo();
					
					dataInfo.codRefundPolicy = DaoFormatter.sqlToInt(stmtResult, DaoRefupoDbTableColumn.COL_COD_REFUND_POLICY);
					dataInfo.txtRefundPolicy = stmtResult.getString(DaoRefupoDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(DaoRefupoDbTableColumn.COL_COD_LANGUAGE);		
					dataInfo.hourBefore = DaoFormatter.sqlToInt(stmtResult, DaoRefupoDbTableColumn.COL_HOUR_BEFORE);
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
