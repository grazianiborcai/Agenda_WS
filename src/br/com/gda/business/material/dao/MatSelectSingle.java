package br.com.gda.business.material.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.material.info.MatInfo;
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

public final class MatSelectSingle implements DaoStmt<MatInfo> {
	private final String LT_MAT = DaoDbTable.MAT_TABLE;	
	private final String RT_MAT_TEXT = DaoDbTable.MAT_TEXT_TABLE;
	
	private DaoStmt<MatInfo> stmtSql;
	private DaoStmtOption<MatInfo> stmtOption;
	
	
	
	public MatSelectSingle(Connection conn, MatInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, MatInfo recordInfo, String schemaName) {
		stmtOption = new DaoStmtOption<>();
		stmtOption.conn = conn;
		stmtOption.recordInfo = recordInfo;
		stmtOption.schemaName = schemaName;
		stmtOption.tableName = LT_MAT;
		stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_MAT);
		stmtOption.stmtParamTranslator = null;
		stmtOption.resultParser = new ResultParser();
		stmtOption.whereClause = buildWhereClause();
		stmtOption.joins = buildJoins();
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new MatWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private List<DaoJoin> buildJoins() {
		List<DaoJoin> joins = new ArrayList<>();		
		joins.add(buildJoinMatText());
		return joins;
	}
	
	
	
	private DaoJoin buildJoinMatText() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_MAT;
		oneColumn.leftColumnName = MatDbTableColumn.COL_COD_MATERIAL;
		oneColumn.rightColumnName = MatDbTableColumn.COL_COD_MATERIAL;
		joinColumns.add(oneColumn);
		
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RT_MAT_TEXT;
		join.joinType = DaoJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = buildJoinConstraintText(join.rightTableName);
		
		return join;
	}
	
	
	
	private String buildJoinConstraintText(String rightTableName) {
		StringBuilder constrainClause = new StringBuilder(); 
		
		constrainClause.append(rightTableName);
		constrainClause.append(DaoDictionary.PERIOD);
		constrainClause.append(MatDbTableColumn.COL_COD_LANGUAGE);
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

	
	
	@Override public List<MatInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<MatInfo> getNewInstance() {
		return new MatSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<MatInfo> {
		private final boolean NOT_NULL = false;
		private final boolean EMPTY_RESULT_SET = false;
		private final String COL_NAME = DaoDbTable.MAT_TEXT_TABLE + "." + MatDbTableColumn.COL_NAME;
		private final String COL_LANGU = DaoDbTable.MAT_TEXT_TABLE + "." + MatDbTableColumn.COL_COD_LANGUAGE;
		private final String COL_DESCR = DaoDbTable.MAT_TEXT_TABLE + "." + MatDbTableColumn.COL_DESCRIPTION;
		
		@Override public List<MatInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<MatInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				MatInfo dataInfo = new MatInfo();
				dataInfo.codOwner = stmtResult.getLong(MatDbTableColumn.COL_COD_OWNER);
				dataInfo.codMat = stmtResult.getLong(MatDbTableColumn.COL_COD_MATERIAL);
				dataInfo.txtMat = stmtResult.getString(COL_NAME);
				dataInfo.description = stmtResult.getString(COL_DESCR);
				dataInfo.codType = stmtResult.getInt(MatDbTableColumn.COL_COD_TYPE);
				dataInfo.codMatCateg = stmtResult.getInt(MatDbTableColumn.COL_COD_CATEGORY);
				dataInfo.priceUnit = stmtResult.getInt(MatDbTableColumn.COL_PRICE_UNIT);	
				dataInfo.codUnit = stmtResult.getString(MatDbTableColumn.COL_COD_UNIT);	
				dataInfo.codGroup = stmtResult.getInt(MatDbTableColumn.COL_COD_GROUP);
				dataInfo.codLanguage = stmtResult.getString(COL_LANGU);	
				dataInfo.isLocked = stmtResult.getBoolean(MatDbTableColumn.COL_IS_LOCKED);	
				dataInfo.recordMode = stmtResult.getString(MatDbTableColumn.COL_RECORD_MODE);
				
				
				Timestamp lastChanged = stmtResult.getTimestamp(MatDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();
				
				
				stmtResult.getLong(MatDbTableColumn.COL_LAST_CHANGED_BY);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.lastChangedBy = stmtResult.getLong(MatDbTableColumn.COL_LAST_CHANGED_BY);
				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
