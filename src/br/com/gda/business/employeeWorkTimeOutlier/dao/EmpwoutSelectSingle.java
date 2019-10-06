package br.com.gda.business.employeeWorkTimeOutlier.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
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
import br.com.gda.dao.common.DaoOptionValue;

public final class EmpwoutSelectSingle implements DaoStmt<EmpwoutInfo> {
	private final String LT_EMP_WT = DaoDbTable.EMP_WT_TABLE;	
	
	private DaoStmt<EmpwoutInfo> stmtSql;
	private DaoStmtOption<EmpwoutInfo> stmtOption;
	
	
	
	public EmpwoutSelectSingle(Connection conn, EmpwoutInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, EmpwoutInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_EMP_WT;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(DaoDbTable.EMP_WT_OUTLIER_VIEW);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause(stmtOption.tableName, stmtOption.recordInfo);
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause(String tableName, EmpwoutInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new EmpwoutWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.SELECT, this.stmtOption, this.getClass());
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

	
	
	@Override public List<EmpwoutInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<EmpwoutInfo> getNewInstance() {
		return new EmpwoutSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	private class ResultParser implements DaoResultParser<EmpwoutInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<EmpwoutInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<EmpwoutInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
		
			do {				
				EmpwoutInfo dataInfo = new EmpwoutInfo();
				dataInfo.codOwner = stmtResult.getLong(EmpwoutDbTableColumn.COL_COD_OWNER);
				dataInfo.codStore = stmtResult.getLong(EmpwoutDbTableColumn.COL_COD_STORE);
				dataInfo.codEmployee = stmtResult.getLong(EmpwoutDbTableColumn.COL_COD_EMPLOYEE);
				dataInfo.codWeekday = stmtResult.getInt(EmpwoutDbTableColumn.COL_COD_WEEKDAY);
				dataInfo.recordMode = stmtResult.getString(EmpwoutDbTableColumn.COL_RECORD_MODE);
				dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, EmpwoutDbTableColumn.COL_BEGIN_TIME);
				dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, EmpwoutDbTableColumn.COL_END_TIME);
				
				finalResult.add(dataInfo);				
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
