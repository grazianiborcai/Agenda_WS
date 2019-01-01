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
import br.com.gda.payService.payCustomer.info.PayCusInfo;

public final class PayCusSelectSingle implements DaoStmt<PayCusInfo> {
	private final String LT_CUSTOMER = DaoDbTable.PAY_CUS_TABLE;
	
	private DaoStmt<PayCusInfo> stmtSql;
	private DaoStmtOption<PayCusInfo> stmtOption;
	
	
	
	public PayCusSelectSingle(Connection conn, PayCusInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, PayCusInfo recordInfo, String schemaName) {
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
		
		DaoStmtWhere whereClause = new PayCusWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<PayCusInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<PayCusInfo> getNewInstance() {
		return new PayCusSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<PayCusInfo> {
		private final boolean NOT_NULL = false;
		
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<PayCusInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<PayCusInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				PayCusInfo dataInfo = new PayCusInfo();
				dataInfo.codOwner = stmtResult.getLong(PayCusDbTableColumn.COL_COD_OWNER);
				dataInfo.codPayCustomer = stmtResult.getLong(PayCusDbTableColumn.COL_COD_PAY_CUSTOMER);									
				dataInfo.recordMode = stmtResult.getString(PayCusDbTableColumn.COL_RECORD_MODE);
				dataInfo.codPayCustomerExt = stmtResult.getString(PayCusDbTableColumn.COL_COD_PAY_CUSTOMER_EXT);
				
				stmtResult.getLong(PayCusDbTableColumn.COL_COD_PERSON);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codPerson = stmtResult.getLong(PayCusDbTableColumn.COL_COD_PERSON);
				
				stmtResult.getLong(PayCusDbTableColumn.COL_COD_USER);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codUser = stmtResult.getLong(PayCusDbTableColumn.COL_COD_USER);
				
				stmtResult.getInt(PayCusDbTableColumn.COL_COD_PAY_PARTNER);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codPayPartner = stmtResult.getInt(PayCusDbTableColumn.COL_COD_PAY_PARTNER);
				
				Timestamp lastChanged = stmtResult.getTimestamp(PayCusDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();	

				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
