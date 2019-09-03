package br.com.gda.business.employeeSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeSnapshot.info.EmpnapInfo;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public final class EmpnapSelectSingle implements DaoStmt<EmpnapInfo> {
	private final String LT_EMP = DaoDbTable.EMP_SNAPSHOT_TABLE;	
	
	private DaoStmt<EmpnapInfo> stmtSql;
	private DaoStmtOption<EmpnapInfo> stmtOption;
	
	
	
	public EmpnapSelectSingle(Connection conn, EmpnapInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, EmpnapInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
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
		whereOption.ignoreNull = DaoWhereBuilderOption.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new EmpnapWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<EmpnapInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<EmpnapInfo> getNewInstance() {
		return new EmpnapSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<EmpnapInfo> {
		private final boolean NOT_NULL = false;
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
				
				
				stmtResult.getLong(EmpnapDbTableColumn.COL_COD_USER);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codUser = stmtResult.getLong(EmpnapDbTableColumn.COL_COD_USER);
				
				
				stmtResult.getLong(EmpnapDbTableColumn.COL_COD_PERSON);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codPerson = stmtResult.getLong(EmpnapDbTableColumn.COL_COD_PERSON);
				
				
				stmtResult.getLong(EmpnapDbTableColumn.COL_COD_PERSON_SNAPSHOT);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codPersonSnapshot = stmtResult.getLong(EmpnapDbTableColumn.COL_COD_PERSON_SNAPSHOT);
				
				
				Timestamp lastChanged = stmtResult.getTimestamp(EmpnapDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();	
				
				
				stmtResult.getLong(EmpnapDbTableColumn.COL_LAST_CHANGED_BY);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.lastChangedBy = stmtResult.getLong(EmpnapDbTableColumn.COL_LAST_CHANGED_BY);
				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
