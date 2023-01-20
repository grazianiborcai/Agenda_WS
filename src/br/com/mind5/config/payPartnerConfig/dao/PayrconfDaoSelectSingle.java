package br.com.mind5.config.payPartnerConfig.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.payPartnerConfig.info.PayrconfInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class PayrconfDaoSelectSingle extends DaoStmtTemplate<PayrconfInfo> {
	private final String MAIN_TABLE = DaoDbTable.PAY_PARTNER_CONFIG_TABLE;
	
	
	public PayrconfDaoSelectSingle(Connection conn, PayrconfInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PayrconfInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new PayrconfDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<PayrconfInfo> getResultParserHook() {
		return new DaoResultParser<PayrconfInfo>() {
			@Override public List<PayrconfInfo> parseResult(PayrconfInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PayrconfInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					PayrconfInfo dataInfo = new PayrconfInfo();
					
					dataInfo.codPayPartner = stmtResult.getInt(PayrconfDaoDbTableColumn.COL_COD_PAY_PARTNER);
					dataInfo.stoparCreation = stmtResult.getString(PayrconfDaoDbTableColumn.COL_STORE_PARTNER_CREATION);
					dataInfo.cusparCreation = stmtResult.getString(PayrconfDaoDbTableColumn.COL_CUSTOMER_PARTNER_CREATION);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		super.executeStmt();
	}
}
