package br.com.gda.business.phone.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.dao.DaoDbTable;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;

public final class PhoneSelectSingle implements DaoStmt<PhoneInfo> {
	private final String LT_MAIN = DaoDbTable.PHONE_TABLE;	
	
	private DaoStmt<PhoneInfo> stmtSql;
	private DaoStmtOption<PhoneInfo> stmtOption;
	
	
	
	public PhoneSelectSingle(Connection conn, PhoneInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, PhoneInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_MAIN;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_MAIN);
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
		
		DaoStmtWhere whereClause = new PhoneWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<PhoneInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<PhoneInfo> getNewInstance() {
		return new PhoneSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<PhoneInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		private final boolean NOT_NULL = false;
		
		@Override public List<PhoneInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<PhoneInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				PhoneInfo dataInfo = new PhoneInfo();
				dataInfo.codPhone = stmtResult.getLong(PhoneDbTableColumn.COL_COD_PHONE);
				dataInfo.codOwner = stmtResult.getLong(PhoneDbTableColumn.COL_COD_OWNER);
				dataInfo.codCountryPhone = stmtResult.getInt(PhoneDbTableColumn.COL_COUNTRY_PHONE);
				dataInfo.fullNumber = stmtResult.getString(PhoneDbTableColumn.COL_FULL_NUMBER);
				dataInfo.recordMode = stmtResult.getString(PhoneDbTableColumn.COL_RECORD_MODE);
				dataInfo.complement = stmtResult.getString(PhoneDbTableColumn.COL_COMPLEMENT);
				
				stmtResult.getLong(PhoneDbTableColumn.COL_COD_STORE);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codStore = stmtResult.getLong(PhoneDbTableColumn.COL_COD_STORE);
				
				stmtResult.getLong(PhoneDbTableColumn.COL_COD_CUSTOMER);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codCustomer = stmtResult.getLong(PhoneDbTableColumn.COL_COD_CUSTOMER);				
				
				stmtResult.getLong(PhoneDbTableColumn.COL_COD_EMPLOYEE);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codEmployee = stmtResult.getLong(PhoneDbTableColumn.COL_COD_EMPLOYEE);		
				
				stmtResult.getLong(PhoneDbTableColumn.COL_COD_USER);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codUser = stmtResult.getLong(PhoneDbTableColumn.COL_COD_USER);	
				
				stmtResult.getLong(PhoneDbTableColumn.COL_COD_PAY_CUSTOMER);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codPayCustomer = stmtResult.getLong(PhoneDbTableColumn.COL_COD_PAY_CUSTOMER);	
				
				Timestamp lastChanged = stmtResult.getTimestamp(PhoneDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();		
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
