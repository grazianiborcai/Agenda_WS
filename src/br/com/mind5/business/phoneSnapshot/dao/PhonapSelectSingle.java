package br.com.mind5.business.phoneSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phone.dao.PhoneDbTableColumn;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
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

public final class PhonapSelectSingle implements DaoStmt<PhonapInfo> {
	private final String LT_MAIN = DaoDbTable.PHONE_SNAPSHOT_TABLE;	
	
	private DaoStmt<PhonapInfo> stmtSql;
	private DaoStmtOption_<PhonapInfo> stmtOption;
	
	
	
	public PhonapSelectSingle(Connection conn, PhonapInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, PhonapInfo recordInfo, String schemaName) {
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
		
		DaoStmtWhere whereClause = new PhonapWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<PhonapInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<PhonapInfo> getNewInstance() {
		return new PhonapSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser_<PhonapInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<PhonapInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<PhonapInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				PhonapInfo dataInfo = new PhonapInfo();
				dataInfo.codPhone = stmtResult.getLong(PhonapDbTableColumn.COL_COD_PHONE);
				dataInfo.codSnapshot = stmtResult.getLong(PhonapDbTableColumn.COL_COD_SNAPSHOT);
				dataInfo.codOwner = stmtResult.getLong(PhonapDbTableColumn.COL_COD_OWNER);
				dataInfo.codCountryPhone = stmtResult.getInt(PhonapDbTableColumn.COL_COUNTRY_PHONE);
				dataInfo.fullNumber = stmtResult.getString(PhonapDbTableColumn.COL_FULL_NUMBER);
				dataInfo.recordMode = stmtResult.getString(PhonapDbTableColumn.COL_RECORD_MODE);
				dataInfo.complement = stmtResult.getString(PhonapDbTableColumn.COL_COMPLEMENT);
				dataInfo.number = stmtResult.getString(PhonapDbTableColumn.COL_NUMBER);
				dataInfo.codArea = stmtResult.getString(PhonapDbTableColumn.COL_COD_AREA);
				dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, PhonapDbTableColumn.COL_COD_STORE);
				dataInfo.codStoreSnapshot = DaoFormatter.sqlToLong(stmtResult, PhonapDbTableColumn.COL_COD_STORE_SNAPSHOT);
				dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, PhonapDbTableColumn.COL_COD_CUSTOMER);
				dataInfo.codCustomerSnapshot = DaoFormatter.sqlToLong(stmtResult, PhonapDbTableColumn.COL_COD_CUSTOMER_SNAPSHOT);
				dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, PhonapDbTableColumn.COL_COD_EMPLOYEE);
				dataInfo.codEmployeeSnapshot = DaoFormatter.sqlToLong(stmtResult, PhonapDbTableColumn.COL_COD_EMPLOYEE_SNAPSHOT);
				dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, PhonapDbTableColumn.COL_COD_USER);
				dataInfo.codUserSnapshot = DaoFormatter.sqlToLong(stmtResult, PhonapDbTableColumn.COL_COD_USER_SNAPSHOT);
				dataInfo.codOwnerRef = DaoFormatter.sqlToLong(stmtResult, PhonapDbTableColumn.COL_COD_OWNER_REF);
				dataInfo.codOwnerRefSnapshot = DaoFormatter.sqlToLong(stmtResult, PhonapDbTableColumn.COL_COD_OWNER_REF_SNAPSHOT);
				dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, PhonapDbTableColumn.COL_LAST_CHANGED_BY);
				dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, PhonapDbTableColumn.COL_LAST_CHANGED);
				dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, PhoneDbTableColumn.COL_CREATED_ON);
				dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, PhoneDbTableColumn.COL_CREATED_BY);
				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
