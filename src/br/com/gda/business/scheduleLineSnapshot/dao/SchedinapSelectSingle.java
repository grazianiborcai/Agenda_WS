package br.com.gda.business.scheduleLineSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.scheduleLine.dao.SchedineDbTableColumn;
import br.com.gda.business.scheduleLineSnapshot.info.SchedinapInfo;
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

public final class SchedinapSelectSingle implements DaoStmt<SchedinapInfo> {	
	private final String LT_SCHEDULE_SNAPSHOT = DaoDbTable.SCHEDULE_SNAPSHOT_TABLE;
	
	private DaoStmt<SchedinapInfo> stmtSql;
	private DaoStmtOption<SchedinapInfo> stmtOption;
	
	
	
	public SchedinapSelectSingle(Connection conn, SchedinapInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, SchedinapInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_SCHEDULE_SNAPSHOT;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_SCHEDULE_SNAPSHOT);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new SchedinapWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		stmtSql = new DaoStmtHelper<>(DaoOperation.SELECT, this.stmtOption);
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

	
	
	@Override public List<SchedinapInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<SchedinapInfo> getNewInstance() {
		return new SchedinapSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<SchedinapInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<SchedinapInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			
			List<SchedinapInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				SchedinapInfo dataInfo = new SchedinapInfo();
				dataInfo.codOwner = stmtResult.getLong(SchedinapDbTableColumn.COL_COD_OWNER);	
				dataInfo.codSnapshot = stmtResult.getLong(SchedinapDbTableColumn.COL_COD_SNAPSHOT);
				dataInfo.codOrder = stmtResult.getLong(SchedinapDbTableColumn.COL_COD_ORDER);
				dataInfo.recordMode = stmtResult.getString(SchedinapDbTableColumn.COL_RECORD_MODE);				
				dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, SchedinapDbTableColumn.COL_COD_STORE);
				dataInfo.codStoreSnapshot = DaoFormatter.sqlToLong(stmtResult, SchedinapDbTableColumn.COL_COD_STORE_SNAPSHOT);
				dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, SchedinapDbTableColumn.COL_COD_EMPLOYEE);
				dataInfo.codEmployeeSnapshot = DaoFormatter.sqlToLong(stmtResult, SchedinapDbTableColumn.COL_COD_EMPLOYEE_SNAPSHOT);
				dataInfo.codMat = DaoFormatter.sqlToLong(stmtResult, SchedinapDbTableColumn.COL_COD_MATERIAL);
				dataInfo.codMatSnapshot = DaoFormatter.sqlToLong(stmtResult, SchedinapDbTableColumn.COL_COD_MATERIAL_SNAPSHOT);
				dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, SchedinapDbTableColumn.COL_DATE);
				dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, SchedinapDbTableColumn.COL_BEGIN_TIME);
				dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, SchedinapDbTableColumn.COL_END_TIME);
				dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, SchedinapDbTableColumn.COL_LAST_CHANGED);
				dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, SchedinapDbTableColumn.COL_COD_USER);
				dataInfo.codUserSnapshot = DaoFormatter.sqlToLong(stmtResult, SchedinapDbTableColumn.COL_COD_USER_SNAPSHOT);
				dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, SchedinapDbTableColumn.COL_COD_CUSTOMER);
				dataInfo.codCustomerSnapshot = DaoFormatter.sqlToLong(stmtResult, SchedinapDbTableColumn.COL_COD_CUSTOMER_SNAPSHOT);
				dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, SchedinapDbTableColumn.COL_LAST_CHANGED_BY);				
				dataInfo.day = DaoFormatter.sqlToInt(stmtResult, SchedinapDbTableColumn.COL_DAY);
				dataInfo.weekMonth = DaoFormatter.sqlToInt(stmtResult, SchedinapDbTableColumn.COL_WEEK_MONTH);
				dataInfo.weekYear = DaoFormatter.sqlToInt(stmtResult, SchedinapDbTableColumn.COL_WEEK_YEAR);
				dataInfo.month = DaoFormatter.sqlToInt(stmtResult, SchedinapDbTableColumn.COL_MONTH);
				dataInfo.quarter = DaoFormatter.sqlToInt(stmtResult, SchedinapDbTableColumn.COL_QUARTER);
				dataInfo.year = DaoFormatter.sqlToInt(stmtResult, SchedinapDbTableColumn.COL_YEAR);		
				dataInfo.codWeekday = DaoFormatter.sqlToInt(stmtResult, SchedineDbTableColumn.COL_COD_WEEKDAY);
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
