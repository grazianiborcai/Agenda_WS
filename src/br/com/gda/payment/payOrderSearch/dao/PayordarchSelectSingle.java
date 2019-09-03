package br.com.gda.payment.payOrderSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;
import br.com.gda.payment.payOrderSearch.info.PayordarchInfo;

public final class PayordarchSelectSingle implements DaoStmt<PayordarchInfo> {
	private final static String LT_PAY_ORDER = DaoDbTable.PAY_ORDER_HDR_TABLE;
	
	private DaoStmt<PayordarchInfo> stmtSql;
	private DaoStmtOption<PayordarchInfo> stmtOption;
	
	
	
	public PayordarchSelectSingle(Connection conn, PayordarchInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, PayordarchInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_PAY_ORDER;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_PAY_ORDER);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {		
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new PayordarchWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.SELECT, this.stmtOption, this.getClass());
	}
	
	

	@Override public void generateStmt() throws SQLException {
		stmtSql.generateStmt();		
	}

	
	
	@Override public boolean checkStmtGeneration() {
		return stmtSql.checkStmtGeneration();
	}

	
	
	@Override public void executeStmt() throws SQLException {
		stmtSql.executeStmt();
	}

	
	
	@Override public List<PayordarchInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<PayordarchInfo> getNewInstance() {
		return new PayordarchSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<PayordarchInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<PayordarchInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<PayordarchInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				PayordarchInfo dataInfo = new PayordarchInfo();
				dataInfo.codOwner = stmtResult.getLong(PayordarchDbTableColumn.COL_COD_OWNER);
				dataInfo.codPayOrder = stmtResult.getLong(PayordarchDbTableColumn.COL_COD_PAY_ORDER);				
				dataInfo.idOrderPartner = stmtResult.getString(PayordarchDbTableColumn.COL_ID_ORDER_PARTNER);
				dataInfo.statusOrderPartner = stmtResult.getString(PayordarchDbTableColumn.COL_STATUS_ORDER_PARTNER);
				dataInfo.amountTotalPartner = stmtResult.getString(PayordarchDbTableColumn.COL_AMOUNT_TOTAL_PARTNER);
				dataInfo.amountCurrencyPartner = stmtResult.getString(PayordarchDbTableColumn.COL_AMOUNT_CURRENCY_PARTNER);
				dataInfo.idPaymentPartner = stmtResult.getString(PayordarchDbTableColumn.COL_ID_PAYMENT_PARTNER);
				dataInfo.statusPaymentPartner = stmtResult.getString(PayordarchDbTableColumn.COL_STATUS_PAYMENT_PARTNER);
				dataInfo.codOrder = DaoFormatter.sqlToLong(stmtResult, PayordarchDbTableColumn.COL_COD_ORDER);
				dataInfo.codCreditCard = DaoFormatter.sqlToLong(stmtResult, PayordarchDbTableColumn.COL_COD_CREDIT_CARD);
				dataInfo.codPayCustomer = DaoFormatter.sqlToLong(stmtResult, PayordarchDbTableColumn.COL_COD_PAY_CUSTOMER);
				dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, PayordarchDbTableColumn.COL_LAST_CHANGED);
				dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, PayordarchDbTableColumn.COL_CREATED_ON);
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
