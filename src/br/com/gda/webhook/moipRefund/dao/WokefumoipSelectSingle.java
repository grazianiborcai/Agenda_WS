package br.com.gda.webhook.moipRefund.dao;

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
import br.com.gda.webhook.moipRefund.info.WokefumoipInfo;

public final class WokefumoipSelectSingle implements DaoStmt<WokefumoipInfo> {
	private final static String LT_PAY_ORDER = DaoDbTable.PAY_ORDER_ITM_TABLE;
	
	private DaoStmt<WokefumoipInfo> stmtSql;
	private DaoStmtOption<WokefumoipInfo> stmtOption;
	
	
	
	public WokefumoipSelectSingle(Connection conn, WokefumoipInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, WokefumoipInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_PAY_ORDER;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(DaoDbTable.REFUND_VIEW);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {		
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new WokefumoipWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<WokefumoipInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<WokefumoipInfo> getNewInstance() {
		return new WokefumoipSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<WokefumoipInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<WokefumoipInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<WokefumoipInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				WokefumoipInfo dataInfo = new WokefumoipInfo();
				dataInfo.codOwner = stmtResult.getLong(WokefumoipDbTableColumn.COL_COD_OWNER);
				dataInfo.codPayOrder = stmtResult.getLong(WokefumoipDbTableColumn.COL_COD_PAY_ORDER);	
				dataInfo.idPaymentPartner = stmtResult.getString(WokefumoipDbTableColumn.COL_ID_PAYMENT_PARTNER);				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
