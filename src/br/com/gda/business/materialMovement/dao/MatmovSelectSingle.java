package br.com.gda.business.materialMovement.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialMovement.info.MatmovInfo;
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

public final class MatmovSelectSingle implements DaoStmt<MatmovInfo> {
	private final static String LT_MAT_MOV = DaoDbTable.MAT_MOVEMENT_TABLE;	
	private final String RT_LANGU = DaoDbTable.LANGUAGE_TABLE;
	
	private DaoStmt<MatmovInfo> stmtSql;
	private DaoStmtOption<MatmovInfo> stmtOption;
	
	
	
	public MatmovSelectSingle(Connection conn, MatmovInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, MatmovInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_MAT_MOV;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_MAT_MOV);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = buildJoins();
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new MatmovWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<MatmovInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<MatmovInfo> getNewInstance() {
		return new MatmovSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<MatmovInfo> {
		private final boolean NOT_NULL = false;
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<MatmovInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<MatmovInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				MatmovInfo dataInfo = new MatmovInfo();
				dataInfo.codOwner = stmtResult.getLong(MatmovDbTableColumn.COL_COD_OWNER);
				dataInfo.codStore = stmtResult.getLong(MatmovDbTableColumn.COL_COD_STORE);
				dataInfo.codMatmov = stmtResult.getLong(MatmovDbTableColumn.COL_COD_MAT_MOV);
				dataInfo.codMatmovType = stmtResult.getString(MatmovDbTableColumn.COL_COD_MAT_MOV_TYPE).charAt(0);
				dataInfo.codMat = stmtResult.getLong(MatmovDbTableColumn.COL_COD_MATERIAL);
				dataInfo.quantity = stmtResult.getInt(MatmovDbTableColumn.COL_QUANTITY);
				
				
				stmtResult.getString(MatmovDbTableColumn.COL_COD_LANGUAGE);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codLanguage = stmtResult.getString(MatmovDbTableColumn.COL_COD_LANGUAGE);
				
				
				Date postingDate = stmtResult.getDate(MatmovDbTableColumn.COL_POSTING_DATE);
				if (postingDate != null)
					dataInfo.postingDate = postingDate.toLocalDate();
				
				
				Timestamp lastChanged = stmtResult.getTimestamp(MatmovDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();
				
				
				stmtResult.getLong(MatmovDbTableColumn.COL_LAST_CHANGED_BY);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.lastChangedBy = stmtResult.getLong(MatmovDbTableColumn.COL_LAST_CHANGED_BY);
		
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
