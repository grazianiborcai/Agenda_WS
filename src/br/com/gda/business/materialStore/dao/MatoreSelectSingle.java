package br.com.gda.business.materialStore.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialStore.info.MatoreInfo;
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

public final class MatoreSelectSingle implements DaoStmt<MatoreInfo> {
	static private final String LT_MAT_STORE = DaoDbTable.MAT_STORE_TABLE;
	static private final String RT_LANGU = DaoDbTable.LANGUAGE_TABLE;
	
	private DaoStmt<MatoreInfo> stmtSql;
	private DaoStmtOption<MatoreInfo> stmtOption;
	
	
	
	public MatoreSelectSingle(Connection conn, MatoreInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, MatoreInfo recordInfo, String schemaName) {
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
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new MatoreWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<MatoreInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<MatoreInfo> getNewInstance() {
		return new MatoreSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<MatoreInfo> {
		private final boolean NOT_NULL = false;
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<MatoreInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<MatoreInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				MatoreInfo dataInfo = new MatoreInfo();
				dataInfo.codOwner = stmtResult.getLong(MatoreDbTableColumn.COL_COD_OWNER);
				dataInfo.codStore = stmtResult.getLong(MatoreDbTableColumn.COL_COD_STORE);
				dataInfo.codMat = stmtResult.getLong(MatoreDbTableColumn.COL_COD_MATERIAL);
				dataInfo.recordMode = stmtResult.getString(MatoreDbTableColumn.COL_RECORD_MODE);			
				dataInfo.codLanguage = stmtResult.getString(MatoreDbTableColumn.COL_COD_LANGUAGE);	
				
				
				Timestamp lastChanged = stmtResult.getTimestamp(MatoreDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();
				
				
				stmtResult.getLong(MatoreDbTableColumn.COL_LAST_CHANGED_BY);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.lastChangedBy = stmtResult.getLong(MatoreDbTableColumn.COL_LAST_CHANGED_BY);
				
				
				stmtResult.getFloat(MatoreDbTableColumn.COL_PRICE);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.matPrice = stmtResult.getDouble(MatoreDbTableColumn.COL_PRICE);
				
				
				stmtResult.getFloat(MatoreDbTableColumn.COL_PRICE_1);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.matPrice1 = stmtResult.getDouble(MatoreDbTableColumn.COL_PRICE_1);
				
				
				stmtResult.getFloat(MatoreDbTableColumn.COL_PRICE_2);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.matPrice2 = stmtResult.getDouble(MatoreDbTableColumn.COL_PRICE_2);
				
				
				stmtResult.getFloat(MatoreDbTableColumn.COL_PRICE_3);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.matPrice3 = stmtResult.getDouble(MatoreDbTableColumn.COL_PRICE_3);
				
				
				stmtResult.getFloat(MatoreDbTableColumn.COL_PRICE_4);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.matPrice4 = stmtResult.getDouble(MatoreDbTableColumn.COL_PRICE_4);
				
				
				stmtResult.getFloat(MatoreDbTableColumn.COL_PRICE_5);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.matPrice5 = stmtResult.getDouble(MatoreDbTableColumn.COL_PRICE_5);
				
				
				stmtResult.getFloat(MatoreDbTableColumn.COL_PRICE_6);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.matPrice6 = stmtResult.getDouble(MatoreDbTableColumn.COL_PRICE_6);
				
				
				stmtResult.getFloat(MatoreDbTableColumn.COL_PRICE_7);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.matPrice7 = stmtResult.getDouble(MatoreDbTableColumn.COL_PRICE_7);

				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
