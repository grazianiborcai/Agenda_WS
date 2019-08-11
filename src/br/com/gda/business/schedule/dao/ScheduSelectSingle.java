package br.com.gda.business.schedule.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.schedule.info.ScheduInfo;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public final class ScheduSelectSingle implements DaoStmt<ScheduInfo> {	
	private final String LT_SCHEDULE = DaoDbTable.SCHEDULE_TABLE;
	
	private DaoStmt<ScheduInfo> stmtSql;
	private DaoStmtOption<ScheduInfo> stmtOption;
	
	
	
	public ScheduSelectSingle(Connection conn, ScheduInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, ScheduInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_SCHEDULE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_SCHEDULE);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new ScheduWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<ScheduInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<ScheduInfo> getNewInstance() {
		return new ScheduSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<ScheduInfo> {
		private final boolean NOT_NULL = false;
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<ScheduInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			
			List<ScheduInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				ScheduInfo dataInfo = new ScheduInfo();
				dataInfo.codOwner = stmtResult.getLong(ScheduDbTableColumn.COL_COD_OWNER);	
				dataInfo.codOrder = stmtResult.getLong(ScheduDbTableColumn.COL_COD_ORDER);
				dataInfo.recordMode = stmtResult.getString(ScheduDbTableColumn.COL_RECORD_MODE);
				
				stmtResult.getLong(ScheduDbTableColumn.COL_COD_STORE);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codStore = stmtResult.getLong(ScheduDbTableColumn.COL_COD_STORE);
				
				stmtResult.getLong(ScheduDbTableColumn.COL_COD_STORE_SNAPSHOT);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codStoreSnapshot = stmtResult.getLong(ScheduDbTableColumn.COL_COD_STORE_SNAPSHOT);
				
				stmtResult.getLong(ScheduDbTableColumn.COL_COD_EMPLOYEE);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codEmployee = stmtResult.getLong(ScheduDbTableColumn.COL_COD_EMPLOYEE);
				
				stmtResult.getLong(ScheduDbTableColumn.COL_COD_EMPLOYEE_SNAPSHOT);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codEmployeeSnapshot = stmtResult.getLong(ScheduDbTableColumn.COL_COD_EMPLOYEE_SNAPSHOT);
				
				stmtResult.getLong(ScheduDbTableColumn.COL_COD_MATERIAL);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codMat = stmtResult.getLong(ScheduDbTableColumn.COL_COD_MATERIAL);
				
				stmtResult.getLong(ScheduDbTableColumn.COL_COD_MATERIAL_SNAPSHOT);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codMatSnapshot = stmtResult.getLong(ScheduDbTableColumn.COL_COD_MATERIAL_SNAPSHOT);

				Date date = stmtResult.getDate(ScheduDbTableColumn.COL_DATE);
				if (date != null)
					dataInfo.date = date.toLocalDate();
				
				Time beginTime = stmtResult.getTime(ScheduDbTableColumn.COL_BEGIN_TIME);
				if (beginTime != null)
					dataInfo.beginTime = beginTime.toLocalTime();
				
				Time endTime = stmtResult.getTime(ScheduDbTableColumn.COL_END_TIME);
				if (endTime != null)
					dataInfo.endTime = endTime.toLocalTime();
				
				Timestamp lastChanged = stmtResult.getTimestamp(ScheduDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();
				
				stmtResult.getLong(ScheduDbTableColumn.COL_COD_USER);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codUser = stmtResult.getLong(ScheduDbTableColumn.COL_COD_USER);
				
				stmtResult.getLong(ScheduDbTableColumn.COL_COD_USER_SNAPSHOT);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codUserSnapshot = stmtResult.getLong(ScheduDbTableColumn.COL_COD_USER_SNAPSHOT);
				
				stmtResult.getLong(ScheduDbTableColumn.COL_COD_CUSTOMER);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codCustomer = stmtResult.getLong(ScheduDbTableColumn.COL_COD_CUSTOMER);
				
				stmtResult.getLong(ScheduDbTableColumn.COL_COD_CUSTOMER_SNAPSHOT);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codCustomerSnapshot = stmtResult.getLong(ScheduDbTableColumn.COL_COD_CUSTOMER_SNAPSHOT);
				
				stmtResult.getLong(ScheduDbTableColumn.COL_LAST_CHANGED_BY);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.lastChangedBy = stmtResult.getLong(ScheduDbTableColumn.COL_LAST_CHANGED_BY);
				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
