package br.com.gda.payService.payCustomer.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.dao.DaoDbTable;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.payService.payCustomer.info.PaycusInfo;

public final class PaycusSelectSingle implements DaoStmt<PaycusInfo> {
	private final String LT_CUSTOMER = DaoDbTable.PAY_CUS_TABLE;
	
	private DaoStmt<PaycusInfo> stmtSql;
	private DaoStmtOption<PaycusInfo> stmtOption;
	
	
	
	public PaycusSelectSingle(Connection conn, PaycusInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, PaycusInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_CUSTOMER;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_CUSTOMER);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		final boolean IGNORE_NULL = true;
		final boolean DONT_IGNORE_RECORD_MODE = false;
		
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = IGNORE_NULL;
		whereOption.ignoreRecordMode = DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new PaycusWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<PaycusInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<PaycusInfo> getNewInstance() {
		return new PaycusSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<PaycusInfo> {
		private final boolean NOT_NULL = false;
		
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<PaycusInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<PaycusInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				PaycusInfo dataInfo = new PaycusInfo();
				dataInfo.codOwner = stmtResult.getLong(PaycusDbTableColumn.COL_COD_OWNER);
				dataInfo.codPayCustomer = stmtResult.getLong(PaycusDbTableColumn.COL_COD_PAY_CUSTOMER);									
				dataInfo.recordMode = stmtResult.getString(PaycusDbTableColumn.COL_RECORD_MODE);
				dataInfo.codPayCustomerExt = stmtResult.getString(PaycusDbTableColumn.COL_COD_PAY_CUSTOMER_EXT);
				
				stmtResult.getLong(PaycusDbTableColumn.COL_COD_PERSON);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codPerson = stmtResult.getLong(PaycusDbTableColumn.COL_COD_PERSON);
				
				stmtResult.getLong(PaycusDbTableColumn.COL_COD_USER);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codUser = stmtResult.getLong(PaycusDbTableColumn.COL_COD_USER);
				
				stmtResult.getInt(PaycusDbTableColumn.COL_COD_PAY_PARTNER);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codPayPartner = stmtResult.getInt(PaycusDbTableColumn.COL_COD_PAY_PARTNER);
				
				stmtResult.getInt(PaycusDbTableColumn.COL_COD_PERSON_REF);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codPersonRef = stmtResult.getInt(PaycusDbTableColumn.COL_COD_PERSON_REF);
				
				stmtResult.getInt(PaycusDbTableColumn.COL_COD_PHONE_REF);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codPhoneRef = stmtResult.getInt(PaycusDbTableColumn.COL_COD_PHONE_REF);
				
				stmtResult.getInt(PaycusDbTableColumn.COL_COD_ADDRESS_REF);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codAddressRef = stmtResult.getInt(PaycusDbTableColumn.COL_COD_ADDRESS_REF);
				
				Timestamp lastChanged = stmtResult.getTimestamp(PaycusDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();	

				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
