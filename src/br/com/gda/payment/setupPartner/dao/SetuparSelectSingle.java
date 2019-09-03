package br.com.gda.payment.setupPartner.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;
import br.com.gda.payment.setupPartner.info.SetuparInfo;

public final class SetuparSelectSingle implements DaoStmt<SetuparInfo> {
	private final static String LT_ATTR = DaoDbTable.PAY_PARTNER_SETUP_TABLE;
	
	private DaoStmt<SetuparInfo> stmtSql;
	private DaoStmtOption<SetuparInfo> stmtOption;
	
	
	
	public SetuparSelectSingle(Connection conn, SetuparInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, SetuparInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_ATTR;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_ATTR);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new SetuparWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
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

	
	
	@Override public List<SetuparInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<SetuparInfo> getNewInstance() {
		return new SetuparSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<SetuparInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<SetuparInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<SetuparInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				SetuparInfo dataInfo = new SetuparInfo();
				dataInfo.codPayPartner = stmtResult.getInt(SetuparDbTableColumn.COL_COD_PAY_PARTNER);
				dataInfo.basicKey = stmtResult.getString(SetuparDbTableColumn.COL_BASIC_KEY);
				dataInfo.basicToken = stmtResult.getString(SetuparDbTableColumn.COL_BASIC_TOKEN);		
				dataInfo.secret = stmtResult.getString(SetuparDbTableColumn.COL_SECRET);
				dataInfo.oauthToken = stmtResult.getString(SetuparDbTableColumn.COL_OAUTH_TOKEN);
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
