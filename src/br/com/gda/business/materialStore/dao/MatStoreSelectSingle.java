package br.com.gda.business.materialStore.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialStore.info.MatStoreInfo;
import br.com.gda.dao.DaoDbTable;
import br.com.gda.dao.DaoDbTableColumnAll;
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

public final class MatStoreSelectSingle implements DaoStmt<MatStoreInfo> {
	static private final String LT_MAT_STORE = DaoDbTable.MAT_STORE_TABLE;
	static private final String RT_LANGU = DaoDbTable.LANGUAGE_TABLE;
	
	private DaoStmt<MatStoreInfo> stmtSql;
	private DaoStmtOption<MatStoreInfo> stmtOption;
	
	
	
	public MatStoreSelectSingle(Connection conn, MatStoreInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, MatStoreInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_MAT_STORE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = buildJoins();
	}
	
	
	
	private String buildWhereClause() {
		final boolean IGNORE_NULL = true;
		final boolean DONT_IGNORE_RECORD_MODE = false;
		
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = IGNORE_NULL;
		whereOption.ignoreRecordMode = DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new MatStoreWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private List<DaoJoin> buildJoins() {
		List<DaoJoin> joins = new ArrayList<>();		
		joins.add(buildJoinLanguage());	
		return joins;
	}
	
	
	
	private DaoJoin buildJoinLanguage() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RT_LANGU;
		join.joinType = DaoJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = buildJoinConstraintText(join.rightTableName);
		
		return join;
	}
	
	
	
	private String buildJoinConstraintText(String rightTableName) {
		StringBuilder constrainClause = new StringBuilder(); 
		
		constrainClause.append(rightTableName);
		constrainClause.append(DaoDictionary.PERIOD);
		constrainClause.append("Language");
		constrainClause.append(DaoDictionary.SPACE);
		constrainClause.append(DaoDictionary.EQUAL);
		constrainClause.append(DaoDictionary.SPACE);
		constrainClause.append(DaoDictionary.QUOTE);
		constrainClause.append(this.stmtOption.recordInfo.codLanguage);
		constrainClause.append(DaoDictionary.QUOTE);
		
		return constrainClause.toString();
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

	
	
	@Override public List<MatStoreInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<MatStoreInfo> getNewInstance() {
		return new MatStoreSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<MatStoreInfo> {
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
