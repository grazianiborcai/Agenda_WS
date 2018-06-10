package br.com.gda.business.masterData.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.MatTypeInfo;
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

public final class MatTypeSelectSingle implements SqlStmt<MatTypeInfo> {
	private final String LT_MAT_TYPE = SqlDbTable.MATERIAL_TYPE_TABLE;
	private final String RT_MAT_TYPE_TEXT = SqlDbTable.MATERIAL_TYPE_TEXT_TABLE;
	
	private SqlStmt<MatTypeInfo> stmtSql;
	private SqlStmtOption<MatTypeInfo> stmtOption;
	
	
	
	public MatTypeSelectSingle(Connection conn, MatTypeInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, MatTypeInfo recordInfo, String schemaName) {
		this.stmtOption = new SqlStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_MAT_TYPE;
		this.stmtOption.columns = SqlDbTableColumnAll.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = buildJoins();
	}
	
	
	
	private String buildWhereClause() {
		final boolean IGNORE_NULL = true;
		final boolean IGNORE_RECORD_MODE = true;
		final boolean DUMMY_CLAUSE_ALLOWED = true;
		
		SqlWhereBuilderOption whereOption = new SqlWhereBuilderOption();
		whereOption.ignoreNull = IGNORE_NULL;
		whereOption.ignoreRecordMode = IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DUMMY_CLAUSE_ALLOWED;
		
		SqlStmtWhere whereClause = new MatTypeWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private List<SqlJoin> buildJoins() {
		List<SqlJoin> joins = new ArrayList<>();		
		joins.add(buildJoinUnitText());
		return joins;
	}
	
	
	
	private SqlJoin buildJoinUnitText() {
		List<SqlJoinColumn> joinColumns = new ArrayList<>();
		
		SqlJoinColumn oneColumn = new SqlJoinColumn();
		oneColumn.leftTableName = LT_MAT_TYPE;
		oneColumn.leftColumnName = "Cod_type";
		oneColumn.rightColumnName = "Cod_type";
		joinColumns.add(oneColumn);
		
		
		SqlJoin join = new SqlJoin();
		join.rightTableName = RT_MAT_TYPE_TEXT;
		join.joinType = SqlJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = buildJoinConstraintText(RT_MAT_TYPE_TEXT);
		
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

	
	
	@Override public List<MatTypeInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public SqlStmt<MatTypeInfo> getNewInstance() {
		return new MatTypeSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	private class ResultParser implements SqlResultParser<MatTypeInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		private final String TYPE_TEXT_COL = SqlDbTable.MATERIAL_TYPE_TEXT_TABLE + "." + "Name";
		private final String LANGU_COL = SqlDbTable.MATERIAL_TYPE_TEXT_TABLE + "." + "Language";
		
		@Override public List<MatTypeInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<MatTypeInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
				return finalResult;
		
			do {				
				MatTypeInfo dataInfo = new MatTypeInfo();
				dataInfo.codType = stmtResult.getInt("Cod_type");
				dataInfo.txtType = stmtResult.getString(TYPE_TEXT_COL);
				dataInfo.codLanguage = stmtResult.getString(LANGU_COL);		
				
				finalResult.add(dataInfo);				
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
