package br.com.mind5.masterData.paymentPartnerDefault.dao;

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
import br.com.mind5.masterData.paymentPartnerDefault.info.PayparultInfo;

public final class PayparultDaoSelectSingle extends DaoStmtTemplate<PayparultInfo> {
	private final String MAIN_TABLE = DaoDbTable.PAY_PARTNER_TABLE;
	
	
	public PayparultDaoSelectSingle(Connection conn, PayparultInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.PAY_PARTNER_DEFAULT_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PayparultInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new PayparultDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<PayparultInfo> getResultParserHook() {
		return new DaoResultParser<PayparultInfo>() {
			@Override public List<PayparultInfo> parseResult(PayparultInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PayparultInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					PayparultInfo dataInfo = new PayparultInfo();
					
					dataInfo.codPayPartner = stmtResult.getInt(PayparultDaoDbTableColumn.COL_COD_PAY_PARTNER);
					dataInfo.isDefault = stmtResult.getBoolean(PayparultDaoDbTableColumn.COL_IS_DEFAULT);
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
