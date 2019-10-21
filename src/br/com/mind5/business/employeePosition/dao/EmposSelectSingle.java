package br.com.mind5.business.employeePosition.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinType;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper;
import br.com.mind5.dao.DaoStmtOption;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.dao.common.DaoOptionValue;

public final class EmposSelectSingle implements DaoStmt<EmposInfo> {	
	private final String LT_STORE_EMPLOYEE = DaoDbTable.EMPOS_TABLE;	
	private final String RT_LANGU = DaoDbTable.LANGUAGE_TABLE;
	
	private DaoStmt<EmposInfo> stmtSql;
	private DaoStmtOption<EmposInfo> stmtOption;
	
	
	
	public EmposSelectSingle(Connection conn, EmposInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, EmposInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_STORE_EMPLOYEE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_STORE_EMPLOYEE);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = buildJoins();
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new EmposWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<EmposInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<EmposInfo> getNewInstance() {
		return new EmposSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<EmposInfo> {
		private final boolean NOT_NULL = false;
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<EmposInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<EmposInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				EmposInfo dataInfo = new EmposInfo();
				dataInfo.codOwner = stmtResult.getLong(EmposDbTableColumn.COL_COD_OWNER);
				dataInfo.codStore = stmtResult.getLong(EmposDbTableColumn.COL_COD_STORE);
				dataInfo.codEmployee = stmtResult.getLong(EmposDbTableColumn.COL_COD_EMPLOYEE);
				dataInfo.codPosition = stmtResult.getInt(EmposDbTableColumn.COL_COD_POSITION);
				dataInfo.recordMode = stmtResult.getString(EmposDbTableColumn.COL_RECORD_MODE);		
				
				
				stmtResult.getString(EmposDbTableColumn.COL_COD_LANGUAGE);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codLanguage = stmtResult.getString(EmposDbTableColumn.COL_COD_LANGUAGE);
				
				
				Timestamp lastChanged = stmtResult.getTimestamp(EmposDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();
				
				
				stmtResult.getLong(EmposDbTableColumn.COL_LAST_CHANGED_BY);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.lastChangedBy = stmtResult.getLong(EmposDbTableColumn.COL_LAST_CHANGED_BY);
				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
