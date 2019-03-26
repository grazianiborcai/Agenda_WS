package br.com.gda.business.materialSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialSnapshot.info.MatSnapInfo;
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

public final class MatSnapSelectSingle implements DaoStmt<MatSnapInfo> {
	private final String LT_MAT = DaoDbTable.MAT_SNAPSHOT_TABLE;	
	private final String RT_MAT_TEXT = DaoDbTable.MAT_TEXT_SNAPSHOT_TABLE;
	
	private DaoStmt<MatSnapInfo> stmtSql;
	private DaoStmtOption<MatSnapInfo> stmtOption;
	
	
	
	public MatSnapSelectSingle(Connection conn, MatSnapInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, MatSnapInfo recordInfo, String schemaName) {
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
		final boolean IGNORE_NULL = true;
		final boolean DONT_IGNORE_RECORD_MODE = false;
		
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = IGNORE_NULL;
		whereOption.ignoreRecordMode = DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new MatSnapWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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
		oneColumn.leftColumnName = MatSnapDbTableColumn.COL_COD_MATERIAL;
		oneColumn.rightColumnName = MatSnapDbTableColumn.COL_COD_MATERIAL;
		joinColumns.add(oneColumn);
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_MAT;
		oneColumn.leftColumnName = MatSnapDbTableColumn.COL_COD_SNAPSHOT;
		oneColumn.rightColumnName = MatSnapDbTableColumn.COL_COD_SNAPSHOT;
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
		constrainClause.append(MatSnapDbTableColumn.COL_LANGUAGE);
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

	
	
	@Override public List<MatSnapInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<MatSnapInfo> getNewInstance() {
		return new MatSnapSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<MatSnapInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		private final String MAT_TEXT_COL = DaoDbTable.MAT_TEXT_SNAPSHOT_TABLE + "." + MatSnapDbTableColumn.COL_NAME;
		private final String MAT_LANGU_COL = DaoDbTable.MAT_TEXT_SNAPSHOT_TABLE + "." + MatSnapDbTableColumn.COL_LANGUAGE;
		private final String MAT_DESCR_COL = DaoDbTable.MAT_TEXT_SNAPSHOT_TABLE + "." + MatSnapDbTableColumn.COL_DESCRIPTION;
		
		@Override public List<MatSnapInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<MatSnapInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				MatSnapInfo dataInfo = new MatSnapInfo();
				dataInfo.codOwner = stmtResult.getLong(MatSnapDbTableColumn.COL_COD_OWNER);
				dataInfo.codSnapshot = stmtResult.getLong(MatSnapDbTableColumn.COL_COD_SNAPSHOT);
				dataInfo.codMat = stmtResult.getLong(MatSnapDbTableColumn.COL_COD_MATERIAL);
				dataInfo.txtMat = stmtResult.getString(MAT_TEXT_COL);
				dataInfo.description = stmtResult.getString(MAT_DESCR_COL);
				dataInfo.codType = stmtResult.getInt(MatSnapDbTableColumn.COL_COD_TYPE);
				dataInfo.codCategory = stmtResult.getInt(MatSnapDbTableColumn.COL_COD_CATEGORY);
				dataInfo.priceUnit = stmtResult.getInt(MatSnapDbTableColumn.COL_PRICE_UNIT);	
				dataInfo.codUnit = stmtResult.getString(MatSnapDbTableColumn.COL_COD_UNIT);	
				dataInfo.codGroup = stmtResult.getInt(MatSnapDbTableColumn.COL_COD_GROUP);
				dataInfo.codLanguage = stmtResult.getString(MAT_LANGU_COL);	
				dataInfo.isLocked = stmtResult.getBoolean(MatSnapDbTableColumn.COL_IS_LOCKED);	
				dataInfo.recordMode = stmtResult.getString(MatSnapDbTableColumn.COL_RECORD_MODE);
				
				Timestamp lastChanged = stmtResult.getTimestamp(MatSnapDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();
				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
