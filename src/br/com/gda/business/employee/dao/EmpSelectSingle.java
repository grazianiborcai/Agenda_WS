package br.com.gda.business.employee.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.dao.DaoJoin;
import br.com.gda.dao.DaoJoinType;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public final class EmpSelectSingle implements DaoStmt<EmpInfo> {
	private final String LT_EMP = DaoDbTable.EMP_TABLE;	
	private final String RT_LANGU = DaoDbTable.LANGUAGE_TABLE;
	
	private DaoStmt<EmpInfo> stmtSql;
	private DaoStmtOption<EmpInfo> stmtOption;
	
	
	
	public EmpSelectSingle(Connection conn, EmpInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, EmpInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_EMP;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_EMP);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = buildJoins();
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new EmpWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private List<DaoJoin> buildJoins() {
		List<DaoJoin> joins = new ArrayList<>();
		joins.add(buildJoinLanguage());		
		return joins;
	}
	
	
	
	private DaoJoin buildJoinLanguage() {
		DaoJoin join = new DaoJoin();
		join.rightTableName = RT_LANGU;
		join.joinType = DaoJoinType.CROSS_JOIN;
		join.joinColumns = null;
		join.constraintClause = null;
		
		return join;
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

	
	
	@Override public List<EmpInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<EmpInfo> getNewInstance() {
		return new EmpSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<EmpInfo> {
		private final boolean NOT_NULL = false;
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<EmpInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<EmpInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				EmpInfo dataInfo = new EmpInfo();
				dataInfo.codOwner = stmtResult.getLong(EmpDbTableColumn.COL_COD_OWNER);
				dataInfo.codEmployee = stmtResult.getLong(EmpDbTableColumn.COL_COD_EMPLOYEE);
				dataInfo.recordMode = stmtResult.getString(EmpDbTableColumn.COL_RECORD_MODE);	
				
				
				stmtResult.getLong(EmpDbTableColumn.COL_COD_USER);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codUser = stmtResult.getLong(EmpDbTableColumn.COL_COD_USER);
				
				
				stmtResult.getLong(EmpDbTableColumn.COL_COD_PERSON);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codPerson = stmtResult.getLong(EmpDbTableColumn.COL_COD_PERSON);
				
				
				stmtResult.getString(EmpDbTableColumn.COL_COD_LANGUAGE);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codLanguage = stmtResult.getString(EmpDbTableColumn.COL_COD_LANGUAGE);
				
				
				Timestamp lastChanged = stmtResult.getTimestamp(EmpDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();	
				
				
				stmtResult.getLong(EmpDbTableColumn.COL_LAST_CHANGED_BY);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.lastChangedBy = stmtResult.getLong(EmpDbTableColumn.COL_LAST_CHANGED_BY);
				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
