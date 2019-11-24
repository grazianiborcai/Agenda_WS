package br.com.mind5.business.employeeSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
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

public final class EmpnapSelectSingle implements DaoStmt<EmpnapInfo> {
	private final String LT_EMP = DaoDbTable.EMP_SNAPSHOT_TABLE;	
	
	private DaoStmt<EmpnapInfo> stmtSql;
	private DaoStmtOption_<EmpnapInfo> stmtOption;
	
	
	
	public EmpnapSelectSingle(Connection conn, EmpnapInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, EmpnapInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption_<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_EMP;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_EMP);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new EmpnapWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<EmpnapInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<EmpnapInfo> getNewInstance() {
		return new EmpnapSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser_<EmpnapInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<EmpnapInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<EmpnapInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				EmpnapInfo dataInfo = new EmpnapInfo();
				dataInfo.codOwner = stmtResult.getLong(EmpnapDbTableColumn.COL_COD_OWNER);
				dataInfo.codSnapshot = stmtResult.getLong(EmpnapDbTableColumn.COL_COD_SNAPSHOT);
				dataInfo.codEmployee = stmtResult.getLong(EmpnapDbTableColumn.COL_COD_EMPLOYEE);
				dataInfo.recordMode = stmtResult.getString(EmpnapDbTableColumn.COL_RECORD_MODE);	
				dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, EmpnapDbTableColumn.COL_COD_USER);
				dataInfo.codUserSnapshot = DaoFormatter.sqlToLong(stmtResult, EmpnapDbTableColumn.COL_COD_USER_SNAPSHOT);
				dataInfo.codPerson = DaoFormatter.sqlToLong(stmtResult, EmpnapDbTableColumn.COL_COD_PERSON);
				dataInfo.codPersonSnapshot = DaoFormatter.sqlToLong(stmtResult, EmpnapDbTableColumn.COL_COD_PERSON_SNAPSHOT);
				dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, EmpnapDbTableColumn.COL_LAST_CHANGED);
				dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, EmpnapDbTableColumn.COL_LAST_CHANGED_BY);		
				dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, EmpnapDbTableColumn.COL_CREATED_ON);
				dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, EmpnapDbTableColumn.COL_CREATED_BY);
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
