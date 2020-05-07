package br.com.mind5.masterData.refundPolicyGroupItem.dao;

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
import br.com.mind5.masterData.refundPolicyGroupItem.info.RefugritemInfo;

public final class DaoRefugritemSelectSingle extends DaoStmtTemplate<RefugritemInfo> {
	private final String MAIN_TABLE = DaoDbTable.REFUND_POLICY_GROUP_ITEM_TABLE;
	
	
	public DaoRefugritemSelectSingle(Connection conn, RefugritemInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, RefugritemInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoRefugritemWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<RefugritemInfo> getResultParserHook() {
		return new DaoResultParser<RefugritemInfo>() {
			@Override public List<RefugritemInfo> parseResult(RefugritemInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<RefugritemInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					RefugritemInfo dataInfo = new RefugritemInfo();
					
					dataInfo.codRefundPolicyGroup = DaoFormatter.sqlToInt(stmtResult, DaoRefugritemDbTableColumn.COL_COD_REFUND_POLICY_GROUP);
					dataInfo.codRefundPolicy = DaoFormatter.sqlToInt(stmtResult, DaoRefugritemDbTableColumn.COL_COD_REFUND_POLICY);					
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
