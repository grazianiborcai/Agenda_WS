package br.com.mind5.masterData.paymentStatusSearch.dao;

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
import br.com.mind5.masterData.paymentStatusSearch.info.PaymenusarchInfo;

public final class PaymenusarchDaoSelectSingle extends DaoStmtTemplate<PaymenusarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.PAYMENT_STATUS_TABLE;
	
	
	public PaymenusarchDaoSelectSingle(Connection conn, PaymenusarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.PAYMENT_STATUS_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PaymenusarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new PaymenusarchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(PaymenusarchInfo recordInfo) {
		DaoJoinBuilder joinText = new PaymenusarchDaoJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<PaymenusarchInfo> getResultParserHook() {
		return new DaoResultParser<PaymenusarchInfo>() {
			@Override public List<PaymenusarchInfo> parseResult(PaymenusarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PaymenusarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					PaymenusarchInfo dataInfo = new PaymenusarchInfo();
					
					dataInfo.codPaymentStatus = stmtResult.getString(PaymenusarchDaoDbTableColumn.COL_COD_PAYMENT_STATUS);
					dataInfo.txtPaymentStatus = stmtResult.getString(PaymenusarchDaoDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(PaymenusarchDaoDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
