package br.com.mind5.payment.payOrder.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper_;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.dao.obsolete.DaoResultParser_;
import br.com.mind5.dao.obsolete.DaoStmtOption_;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class PayordSelectSingle implements DaoStmt<PayordInfo> {
	private final static String LT_PAY_ORDER = DaoDbTable.PAY_ORDER_HDR_TABLE;
	
	private DaoStmt<PayordInfo> stmtSql;
	private DaoStmtOption_<PayordInfo> stmtOption;
	
	
	
	public PayordSelectSingle(Connection conn, PayordInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, PayordInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption_<>();
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
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new PayordWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper_<>(DaoOperation.SELECT, this.stmtOption, this.getClass());
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

	
	
	@Override public List<PayordInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<PayordInfo> getNewInstance() {
		return new PayordSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser_<PayordInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<PayordInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<PayordInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				PayordInfo dataInfo = new PayordInfo();
				dataInfo.codOwner = stmtResult.getLong(PayordDbTableColumn.COL_COD_OWNER);
				dataInfo.codPayOrder = stmtResult.getLong(PayordDbTableColumn.COL_COD_PAY_ORDER);				
				dataInfo.idOrderPartner = stmtResult.getString(PayordDbTableColumn.COL_ID_ORDER_PARTNER);
				dataInfo.statusOrderPartner = stmtResult.getString(PayordDbTableColumn.COL_STATUS_ORDER_PARTNER);
				dataInfo.amountTotalPartner = stmtResult.getString(PayordDbTableColumn.COL_AMOUNT_TOTAL_PARTNER);
				dataInfo.amountCurrencyPartner = stmtResult.getString(PayordDbTableColumn.COL_AMOUNT_CURRENCY_PARTNER);
				dataInfo.idPaymentPartner = stmtResult.getString(PayordDbTableColumn.COL_ID_PAYMENT_PARTNER);
				dataInfo.statusPaymentPartner = stmtResult.getString(PayordDbTableColumn.COL_STATUS_PAYMENT_PARTNER);
				dataInfo.codOrder = DaoFormatter.sqlToLong(stmtResult, PayordDbTableColumn.COL_COD_ORDER);
				dataInfo.codCreditCard = DaoFormatter.sqlToLong(stmtResult, PayordDbTableColumn.COL_COD_CREDIT_CARD);
				dataInfo.codPayCustomer = DaoFormatter.sqlToLong(stmtResult, PayordDbTableColumn.COL_COD_PAY_CUSTOMER);
				dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, PayordDbTableColumn.COL_LAST_CHANGED);
				dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, PayordDbTableColumn.COL_CREATED_ON);
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
