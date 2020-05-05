package br.com.mind5.webhook.moipRefund.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.webhook.moipRefund.info.WokefumoipInfo;

public final class DaoWokefumoipSelectSingle extends DaoStmtTemplate<WokefumoipInfo> {
	private final String MAIN_TABLE = DaoDbTable.PAY_ORDER_ITM_TABLE;
	
	
	public DaoWokefumoipSelectSingle(Connection conn, WokefumoipInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, WokefumoipInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoWokefumoipWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<WokefumoipInfo> getResultParserHook() {
		return new DaoResultParser<WokefumoipInfo>() {
			@Override public List<WokefumoipInfo> parseResult(WokefumoipInfo redcordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<WokefumoipInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					WokefumoipInfo dataInfo = new WokefumoipInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoWokefumoipDbTableColumn.COL_COD_OWNER);
					dataInfo.codPayOrder = stmtResult.getLong(DaoWokefumoipDbTableColumn.COL_COD_PAY_ORDER);	
					dataInfo.idPaymentPartner = stmtResult.getString(DaoWokefumoipDbTableColumn.COL_ID_PAYMENT_PARTNER);				
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
