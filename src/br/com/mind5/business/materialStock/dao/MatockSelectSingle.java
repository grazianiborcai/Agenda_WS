package br.com.mind5.business.materialStock.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStock.info.MatockInfo;
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

public final class MatockSelectSingle implements DaoStmt<MatockInfo> {
	private final static String LT_MAT_STOCK = DaoDbTable.MAT_STOCK_TABLE;	
	private final String RT_LANGU = DaoDbTable.LANGUAGE_TABLE;
	
	private DaoStmt<MatockInfo> stmtSql;
	private DaoStmtOption<MatockInfo> stmtOption;
	
	
	
	public MatockSelectSingle(Connection conn, MatockInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, MatockInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_MAT_STOCK;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_MAT_STOCK);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = buildJoins();
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new MatockWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<MatockInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<MatockInfo> getNewInstance() {
		return new MatockSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<MatockInfo> {
		private final boolean NOT_NULL = false;
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<MatockInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<MatockInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				MatockInfo dataInfo = new MatockInfo();
				dataInfo.codOwner = stmtResult.getLong(MatockDbTableColumn.COL_COD_OWNER);
				dataInfo.codStore = stmtResult.getLong(MatockDbTableColumn.COL_COD_STORE);
				dataInfo.codMat = stmtResult.getLong(MatockDbTableColumn.COL_COD_MATERIAL);
				dataInfo.quantityStock = stmtResult.getInt(MatockDbTableColumn.COL_QUANTITY_STOCK);
				
				
				stmtResult.getString(MatockDbTableColumn.COL_COD_LANGUAGE);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codLanguage = stmtResult.getString(MatockDbTableColumn.COL_COD_LANGUAGE);
				
				
				Timestamp lastChanged = stmtResult.getTimestamp(MatockDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();
		
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
