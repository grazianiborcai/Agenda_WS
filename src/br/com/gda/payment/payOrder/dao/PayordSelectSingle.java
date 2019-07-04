package br.com.gda.payment.payOrder.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;
import br.com.gda.payment.payOrder.info.PayordInfo;

public final class PayordSelectSingle implements DaoStmt<PayordInfo> {
	private final static String LT_PAY_ORDER = DaoDbTable.PAY_ORDER_HDR_TABLE;
	
	private DaoStmt<PayordInfo> stmtSql;
	private DaoStmtOption<PayordInfo> stmtOption;
	
	
	
	public PayordSelectSingle(Connection conn, PayordInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, PayordInfo recordInfo, String schemaName) {
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
		
		DaoStmtWhere whereClause = new PayordWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.SELECT, this.stmtOption);
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
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<PayordInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		private final boolean NOT_NULL = false;
		
		@Override public List<PayordInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<PayordInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				PayordInfo dataInfo = new PayordInfo();
				dataInfo.codOwner = stmtResult.getLong(PayordDbTableColumn.COL_COD_OWNER);
				dataInfo.codPayOrder = stmtResult.getLong(PayordDbTableColumn.COL_COD_PAY_ORDER);
				dataInfo.feeReceiver = stmtResult.getString(PayordDbTableColumn.COL_FEE_RECEIVER);
				dataInfo.codFeeCurrency = stmtResult.getString(PayordDbTableColumn.COL_FEE_CURRENCY);
				dataInfo.codPaymentStatus = stmtResult.getString(PayordDbTableColumn.COL_COD_PAY_STATUS);
				
				stmtResult.getLong(PayordDbTableColumn.COL_COD_ORDER);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codOrder = stmtResult.getLong(PayordDbTableColumn.COL_COD_ORDER);
				
				stmtResult.getLong(PayordDbTableColumn.COL_COD_CREDIT_CARD);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codCreditCard = stmtResult.getLong(PayordDbTableColumn.COL_COD_CREDIT_CARD);
				
				stmtResult.getLong(PayordDbTableColumn.COL_COD_PAY_CUSTOMER);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codPayCustomer = stmtResult.getLong(PayordDbTableColumn.COL_COD_PAY_CUSTOMER);
				
				Timestamp lastChanged = stmtResult.getTimestamp(PayordDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();
				
				Timestamp createdOn = stmtResult.getTimestamp(PayordDbTableColumn.COL_CREATED_ON);
				if (lastChanged != null)
					dataInfo.createdOn = createdOn .toLocalDateTime();
				
				stmtResult.getLong(PayordDbTableColumn.COL_FEE_AMOUNT);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.feeAmount = stmtResult.getDouble(PayordDbTableColumn.COL_FEE_AMOUNT);
				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
