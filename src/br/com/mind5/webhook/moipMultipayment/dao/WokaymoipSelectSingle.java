package br.com.mind5.webhook.moipMultipayment.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.webhook.moipMultipayment.info.WokaymoipInfo;

public final class WokaymoipSelectSingle extends DaoStmtTemplate<WokaymoipInfo> {
	private final String MAIN_TABLE = DaoDbTable.PAY_ORDER_HDR_TABLE;
	
	
	public WokaymoipSelectSingle(Connection conn, WokaymoipInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, WokaymoipInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new WokaymoipWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParserV2<WokaymoipInfo> getResultParserHook() {
		return new DaoResultParserV2<WokaymoipInfo>() {
			@Override public List<WokaymoipInfo> parseResult(WokaymoipInfo redcordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<WokaymoipInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					WokaymoipInfo dataInfo = new WokaymoipInfo();
					
					dataInfo.codOwner = stmtResult.getLong(WokaymoipDbTableColumn.COL_COD_OWNER);
					dataInfo.codPayOrder = stmtResult.getLong(WokaymoipDbTableColumn.COL_COD_PAY_ORDER);	
					dataInfo.idPaymentPartner = stmtResult.getString(WokaymoipDbTableColumn.COL_ID_PAYMENT_PARTNER);				
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
		}
		};
	}
}
