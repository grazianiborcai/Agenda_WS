package br.com.mind5.business.refundPolicyStore.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class RefuporeDaoSelectSingle extends DaoStmtTemplate<RefuporeInfo> {
	private final String MAIN_TABLE = DaoDbTable.REFUND_POLICY_STORE_TABLE;
	
	
	public RefuporeDaoSelectSingle(Connection conn, RefuporeInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, RefuporeInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new RefuporeDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<RefuporeInfo> getResultParserHook() {
		return new DaoResultParser<RefuporeInfo>() {
			@Override public List<RefuporeInfo> parseResult(RefuporeInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<RefuporeInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					RefuporeInfo dataInfo = new RefuporeInfo();
					
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, RefuporeDaoDbTableColumn.COL_COD_STORE);
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, RefuporeDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codRefundPolicyGroup = DaoFormatter.sqlToInt(stmtResult, RefuporeDaoDbTableColumn.COL_COD_REFUND_POLICY_GROUP);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, RefuporeDaoDbTableColumn.COL_CREATED_BY);
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, RefuporeDaoDbTableColumn.COL_CREATED_ON);					
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, RefuporeDaoDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, RefuporeDaoDbTableColumn.COL_LAST_CHANGED);
					dataInfo.recordMode = stmtResult.getString(RefuporeDaoDbTableColumn.COL_RECORD_MODE);
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
