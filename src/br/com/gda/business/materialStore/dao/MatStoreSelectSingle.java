package br.com.gda.business.materialStore.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialStore.info.MatStoreInfo;
import br.com.gda.sql.SqlDbTable;
import br.com.gda.sql.SqlDbTableColumnAll;
import br.com.gda.sql.SqlDictionary;
import br.com.gda.sql.SqlJoin;
import br.com.gda.sql.SqlJoinColumn;
import br.com.gda.sql.SqlJoinType;
import br.com.gda.sql.SqlOperation;
import br.com.gda.sql.SqlResultParser;
import br.com.gda.sql.SqlStmt;
import br.com.gda.sql.SqlStmtHelper;
import br.com.gda.sql.SqlStmtOption;
import br.com.gda.sql.SqlStmtWhere;
import br.com.gda.sql.SqlWhereBuilderOption;

public final class MatStoreSelectSingle implements SqlStmt<MatStoreInfo> {
	static private final String LT_MAT_STORE = SqlDbTable.MAT_STORE_TABLE;
	static private final String RT_LANGU = SqlDbTable.LANGUAGE_TABLE;
	
	private SqlStmt<MatStoreInfo> stmtSql;
	private SqlStmtOption<MatStoreInfo> stmtOption;
	
	
	
	public MatStoreSelectSingle(Connection conn, MatStoreInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, MatStoreInfo recordInfo, String schemaName) {
		this.stmtOption = new SqlStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_MAT_STORE;
		this.stmtOption.columns = SqlDbTableColumnAll.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = buildJoins();
	}
	
	
	
	private String buildWhereClause() {
		final boolean IGNORE_NULL = true;
		final boolean DONT_IGNORE_RECORD_MODE = false;
		
		SqlWhereBuilderOption whereOption = new SqlWhereBuilderOption();
		whereOption.ignoreNull = IGNORE_NULL;
		whereOption.ignoreRecordMode = DONT_IGNORE_RECORD_MODE;		
		
		SqlStmtWhere whereClause = new MatStoreWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private List<SqlJoin> buildJoins() {
		List<SqlJoin> joins = new ArrayList<>();		
		joins.add(buildJoinLanguage());	
		return joins;
	}
	
	
	
	private SqlJoin buildJoinLanguage() {
		List<SqlJoinColumn> joinColumns = new ArrayList<>();
		
		SqlJoin join = new SqlJoin();
		join.rightTableName = RT_LANGU;
		join.joinType = SqlJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = buildJoinConstraintText(join.rightTableName);
		
		return join;
	}
	
	
	
	private String buildJoinConstraintText(String rightTableName) {
		StringBuilder constrainClause = new StringBuilder(); 
		
		constrainClause.append(rightTableName);
		constrainClause.append(SqlDictionary.PERIOD);
		constrainClause.append("Language");
		constrainClause.append(SqlDictionary.SPACE);
		constrainClause.append(SqlDictionary.EQUAL);
		constrainClause.append(SqlDictionary.SPACE);
		constrainClause.append(SqlDictionary.QUOTE);
		constrainClause.append(this.stmtOption.recordInfo.codLanguage);
		constrainClause.append(SqlDictionary.QUOTE);
		
		return constrainClause.toString();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new SqlStmtHelper<>(SqlOperation.SELECT, this.stmtOption);
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

	
	
	@Override public List<MatStoreInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public SqlStmt<MatStoreInfo> getNewInstance() {
		return new MatStoreSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements SqlResultParser<MatStoreInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		private final String LANGU_COL = RT_LANGU + "." + "Language";
		
		@Override public List<MatStoreInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<MatStoreInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				MatStoreInfo dataInfo = new MatStoreInfo();
				dataInfo.codOwner = stmtResult.getLong("cod_owner");
				dataInfo.codStore = stmtResult.getLong("Cod_store");
				dataInfo.codMat = stmtResult.getLong("Cod_material");
				dataInfo.recordMode = stmtResult.getString("Record_mode");			
				dataInfo.codLanguage = stmtResult.getString(LANGU_COL);	
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
