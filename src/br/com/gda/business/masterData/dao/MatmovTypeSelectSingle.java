package br.com.gda.business.masterData.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.MatmovTypeInfo;
import br.com.gda.dao.DaoDictionary;
import br.com.gda.dao.DaoJoin;
import br.com.gda.dao.DaoJoinColumn;
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

public final class MatmovTypeSelectSingle implements DaoStmt<MatmovTypeInfo> {
	private final String LT_ATTR = DaoDbTable.MAT_MOV_TYPE_TABLE;
	private final String RT_TEXT = DaoDbTable.MAT_MOV_TYPE_TEXT_TABLE;
	
	private DaoStmt<MatmovTypeInfo> stmtSql;
	private DaoStmtOption<MatmovTypeInfo> stmtOption;
	
	
	
	public MatmovTypeSelectSingle(Connection conn, MatmovTypeInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, MatmovTypeInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_ATTR;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = buildJoins();
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoWhereBuilderOption.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new MatmovTypeWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private List<DaoJoin> buildJoins() {
		List<DaoJoin> joins = new ArrayList<>();		
		joins.add(buildJoinText());
		return joins;
	}
	
	
	
	private DaoJoin buildJoinText() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_ATTR;
		oneColumn.leftColumnName = MasterDataDbTableColumn.COL_COD_MAT_MOV_TYPE;
		oneColumn.rightColumnName = MasterDataDbTableColumn.COL_COD_MAT_MOV_TYPE;
		joinColumns.add(oneColumn);
		
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RT_TEXT;
		join.joinType = DaoJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = buildJoinConstraintText(RT_TEXT);
		
		return join;
	}
	
	
	
	private String buildJoinConstraintText(String rightTableName) {
		StringBuilder constrainClause = new StringBuilder(); 
		
		constrainClause.append(rightTableName);
		constrainClause.append(DaoDictionary.PERIOD);
		constrainClause.append(MasterDataDbTableColumn.COL_COD_LANGUAGE);
		constrainClause.append(DaoDictionary.SPACE);
		constrainClause.append(DaoDictionary.EQUAL);
		constrainClause.append(DaoDictionary.SPACE);
		constrainClause.append(DaoDictionary.QUOTE);
		constrainClause.append(this.stmtOption.recordInfo.codLanguage);
		constrainClause.append(DaoDictionary.QUOTE);
		
		return constrainClause.toString();
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

	
	
	@Override public List<MatmovTypeInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<MatmovTypeInfo> getNewInstance() {
		return new MatmovTypeSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	private class ResultParser implements DaoResultParser<MatmovTypeInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<MatmovTypeInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<MatmovTypeInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
				return finalResult;
		
			do {				
				MatmovTypeInfo dataInfo = new MatmovTypeInfo();
				dataInfo.codMatmovType = stmtResult.getString(MasterDataDbTableColumn.COL_COD_MAT_MOV_TYPE).charAt(0);
				dataInfo.txtMatmovType = stmtResult.getString(MasterDataDbTableColumn.COL_NAME);
				dataInfo.codLanguage = stmtResult.getString(MasterDataDbTableColumn.COL_COD_LANGUAGE);		
				
				finalResult.add(dataInfo);				
			} while (stmtResult.next());
			
			return finalResult;
		}
	} 
}
