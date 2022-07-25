package br.com.mind5.masterData.paymentStatus.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.masterData.paymentStatus.info.PaymenusInfo;

public final class PaymenusDaoSelectSingle extends DaoStmtTemplate<PaymenusInfo> {
	private final String MAIN_TABLE = DaoDbTable.PAYMENT_STATUS_TABLE;
	
	
	public PaymenusDaoSelectSingle(Connection conn, PaymenusInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PaymenusInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new PaymenusDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(PaymenusInfo recordInfo) {
		DaoJoinBuilder joinText = new PaymenusDaoJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<PaymenusInfo> getResultParserHook() {
		return new DaoResultParser<PaymenusInfo>() {
			@Override public List<PaymenusInfo> parseResult(PaymenusInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PaymenusInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					PaymenusInfo dataInfo = new PaymenusInfo();
					
					dataInfo.codPaymentStatus = stmtResult.getString(PaymenusDaoDbTableColumn.COL_COD_PAYMENT_STATUS);
					dataInfo.txtPaymentStatus = stmtResult.getString(PaymenusDaoDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(PaymenusDaoDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
