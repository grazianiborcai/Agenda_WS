package br.com.gda.webhook.moipMultipayment.dao;

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
import br.com.gda.webhook.moipMultipayment.info.WokaymoipInfo;

public final class WokaymoipSelectSingle implements DaoStmt<WokaymoipInfo> {
	private final static String LT_PAY_ORDER = DaoDbTable.PAY_ORDER_HDR_TABLE;
	
	private DaoStmt<WokaymoipInfo> stmtSql;
	private DaoStmtOption<WokaymoipInfo> stmtOption;
	
	
	
	public WokaymoipSelectSingle(Connection conn, WokaymoipInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, WokaymoipInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_PAY_ORDER;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(DaoDbTable.PAYMENT_VIEW);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {		
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new WokaymoipWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<WokaymoipInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<WokaymoipInfo> getNewInstance() {
		return new WokaymoipSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<WokaymoipInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<WokaymoipInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<WokaymoipInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				WokaymoipInfo dataInfo = new WokaymoipInfo();
				dataInfo.codOwner = stmtResult.getLong(WokaymoipDbTableColumn.COL_COD_OWNER);
				dataInfo.codPayOrder = stmtResult.getLong(WokaymoipDbTableColumn.COL_COD_PAY_ORDER);	
				dataInfo.idPaymentPartner = stmtResult.getString(WokaymoipDbTableColumn.COL_ID_PAYMENT_PARTNER);				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
