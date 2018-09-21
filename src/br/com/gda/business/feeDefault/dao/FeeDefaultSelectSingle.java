package br.com.gda.business.feeDefault.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.feeDefault.info.FeeDefaultInfo;
import br.com.gda.dao.DaoDbTable;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoJoin;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;

public final class FeeDefaultSelectSingle implements DaoStmt<FeeDefaultInfo> {
	private final static String LT_ATTR = DaoDbTable.FEE_DEFAULT_TABLE;
	
	private DaoStmt<FeeDefaultInfo> stmtSql;
	private DaoStmtOption<FeeDefaultInfo> stmtOption;
	
	
	
	public FeeDefaultSelectSingle(Connection conn, FeeDefaultInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, FeeDefaultInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_ATTR;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_ATTR);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = buildJoins();
	}
	
	
	
	private String buildWhereClause() {
		final boolean DONT_IGNORE_NULL = false;
		final boolean DONT_IGNORE_RECORD_MODE = false;
		
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new FeeDefaultWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private List<DaoJoin> buildJoins() {
		List<DaoJoin> joins = new ArrayList<>();	
		return joins;
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

	
	
	@Override public List<FeeDefaultInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<FeeDefaultInfo> getNewInstance() {
		return new FeeDefaultSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<FeeDefaultInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<FeeDefaultInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<FeeDefaultInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				FeeDefaultInfo dataInfo = new FeeDefaultInfo();
				dataInfo.codFeeCateg = stmtResult.getString(FeeDefaultDbTableColumn.COL_COD_FEE_CATEG).charAt(0);
				dataInfo.codCurr = stmtResult.getString(FeeDefaultDbTableColumn.COL_COD_CURRENCY);
				dataInfo.value = stmtResult.getDouble(FeeDefaultDbTableColumn.COL_VALUE);
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
