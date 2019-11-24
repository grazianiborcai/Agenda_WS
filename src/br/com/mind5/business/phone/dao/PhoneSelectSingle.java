package br.com.mind5.business.phone.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
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

public final class PhoneSelectSingle implements DaoStmt<PhoneInfo> {
	private final String LT_MAIN = DaoDbTable.PHONE_TABLE;	
	
	private DaoStmt<PhoneInfo> stmtSql;
	private DaoStmtOption_<PhoneInfo> stmtOption;
	
	
	
	public PhoneSelectSingle(Connection conn, PhoneInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, PhoneInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption_<>();
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
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new PhoneWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<PhoneInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<PhoneInfo> getNewInstance() {
		return new PhoneSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser_<PhoneInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<PhoneInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<PhoneInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				PhoneInfo dataInfo = new PhoneInfo();
				dataInfo.codPhone = stmtResult.getLong(PhoneDbTableColumn.COL_COD_PHONE);
				dataInfo.codOwner = stmtResult.getLong(PhoneDbTableColumn.COL_COD_OWNER);
				dataInfo.codCountryPhone = stmtResult.getInt(PhoneDbTableColumn.COL_COUNTRY_PHONE);
				dataInfo.fullNumber = stmtResult.getString(PhoneDbTableColumn.COL_FULL_NUMBER);
				dataInfo.recordMode = stmtResult.getString(PhoneDbTableColumn.COL_RECORD_MODE);
				dataInfo.complement = stmtResult.getString(PhoneDbTableColumn.COL_COMPLEMENT);
				dataInfo.number = stmtResult.getString(PhoneDbTableColumn.COL_NUMBER);
				dataInfo.codArea = stmtResult.getString(PhoneDbTableColumn.COL_COD_AREA);
				dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, PhoneDbTableColumn.COL_COD_STORE);
				dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, PhoneDbTableColumn.COL_COD_CUSTOMER);
				dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, PhoneDbTableColumn.COL_COD_EMPLOYEE);
				dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, PhoneDbTableColumn.COL_COD_USER);
				dataInfo.codOwnerRef = DaoFormatter.sqlToLong(stmtResult, PhoneDbTableColumn.COL_COD_OWNER_REF);
				dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, PhoneDbTableColumn.COL_LAST_CHANGED);
				dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, PhoneDbTableColumn.COL_LAST_CHANGED_BY);
				dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, PhoneDbTableColumn.COL_COD_SNAPSHOT);
				dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, PhoneDbTableColumn.COL_CREATED_ON);
				dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, PhoneDbTableColumn.COL_CREATED_BY);
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
