package br.com.gda.business.phoneSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public final class PhonapSelectSingle implements DaoStmt<PhonapInfo> {
	private final String LT_MAIN = DaoDbTable.PHONE_SNAPSHOT_TABLE;	
	
	private DaoStmt<PhonapInfo> stmtSql;
	private DaoStmtOption<PhonapInfo> stmtOption;
	
	
	
	public PhonapSelectSingle(Connection conn, PhonapInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, PhonapInfo recordInfo, String schemaName) {
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
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.DONT_IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new PhonapWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<PhonapInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<PhonapInfo> getNewInstance() {
		return new PhonapSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<PhonapInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		private final boolean NOT_NULL = false;
		
		@Override public List<PhonapInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<PhonapInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
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
				
				stmtResult.getLong(PhonapDbTableColumn.COL_COD_STORE);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codStore = stmtResult.getLong(PhonapDbTableColumn.COL_COD_STORE);
				
				stmtResult.getLong(PhonapDbTableColumn.COL_COD_STORE_SNAPSHOT);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codStoreSnapshot = stmtResult.getLong(PhonapDbTableColumn.COL_COD_STORE_SNAPSHOT);
				
				stmtResult.getLong(PhonapDbTableColumn.COL_COD_CUSTOMER);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codCustomer = stmtResult.getLong(PhonapDbTableColumn.COL_COD_CUSTOMER);	
				
				stmtResult.getLong(PhonapDbTableColumn.COL_COD_CUSTOMER_SNAPSHOT);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codCustomerSnapshot = stmtResult.getLong(PhonapDbTableColumn.COL_COD_CUSTOMER_SNAPSHOT);	
				
				stmtResult.getLong(PhonapDbTableColumn.COL_COD_EMPLOYEE);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codEmployee = stmtResult.getLong(PhonapDbTableColumn.COL_COD_EMPLOYEE);	
				
				stmtResult.getLong(PhonapDbTableColumn.COL_COD_EMPLOYEE_SNAPSHOT);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codEmployeeSnapshot = stmtResult.getLong(PhonapDbTableColumn.COL_COD_EMPLOYEE_SNAPSHOT);
				
				stmtResult.getLong(PhonapDbTableColumn.COL_COD_USER);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codUser = stmtResult.getLong(PhonapDbTableColumn.COL_COD_USER);	
				
				stmtResult.getLong(PhonapDbTableColumn.COL_COD_USER_SNAPSHOT);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codUserSnapshot = stmtResult.getLong(PhonapDbTableColumn.COL_COD_USER_SNAPSHOT);	
				
				stmtResult.getLong(PhonapDbTableColumn.COL_COD_OWNER_REF);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codOwnerRef = stmtResult.getLong(PhonapDbTableColumn.COL_COD_OWNER_REF);
				
				stmtResult.getLong(PhonapDbTableColumn.COL_COD_OWNER_REF_SNAPSHOT);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codOwnerRefSnapshot = stmtResult.getLong(PhonapDbTableColumn.COL_COD_OWNER_REF_SNAPSHOT);
				
				stmtResult.getLong(PhonapDbTableColumn.COL_LAST_CHANGED_BY);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.lastChangedBy = stmtResult.getLong(PhonapDbTableColumn.COL_LAST_CHANGED_BY);
				
				Timestamp lastChanged = stmtResult.getTimestamp(PhonapDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();		
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
