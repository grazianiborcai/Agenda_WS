package br.com.gda.payment.systemPartner.dao;

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
import br.com.gda.payment.systemPartner.info.SysparInfo;

public final class SysparSelectSingle implements DaoStmt<SysparInfo> {
	private final static String LT_MAIN = DaoDbTable.SYS_PAY_PARTNER_TABLE;
	
	private DaoStmt<SysparInfo> stmtSql;
	private DaoStmtOption<SysparInfo> stmtOption;
	
	
	
	public SysparSelectSingle(Connection conn, SysparInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, SysparInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_MAIN;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_MAIN);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new SysparWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
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

	
	
	@Override public List<SysparInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<SysparInfo> getNewInstance() {
		return new SysparSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<SysparInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<SysparInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<SysparInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				SysparInfo dataInfo = new SysparInfo();
				dataInfo.idPayPartnerSystem = stmtResult.getString(SysparDbTableColumn.COL_ID_PAY_PARTNER_SYSTEM);
				dataInfo.idPayPartnerApp = stmtResult.getString(SysparDbTableColumn.COL_ID_PAY_PARTNER_APP);
				dataInfo.codPayPartner = stmtResult.getInt(SysparDbTableColumn.COL_COD_PAY_PARTNER);
				dataInfo.urlReturn = stmtResult.getString(SysparDbTableColumn.COL_URL_RETURN);
				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
