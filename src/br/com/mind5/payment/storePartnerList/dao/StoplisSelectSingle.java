package br.com.mind5.payment.storePartnerList.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper_;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.dao.obsolete.DaoResultParser_;
import br.com.mind5.dao.obsolete.DaoStmtOption_;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;

public final class StoplisSelectSingle implements DaoStmt<StoplisInfo> {
	private final static String LT_ATTR = DaoDbTable.PAY_PARTNER_STORE_TABLE;
	
	private DaoStmt<StoplisInfo> stmtSql;
	private DaoStmtOption_<StoplisInfo> stmtOption;
	
	
	
	public StoplisSelectSingle(Connection conn, StoplisInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, StoplisInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption_<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_ATTR;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(DaoDbTable.PAY_PARTNER_STORE_VIEW);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {		
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new StoplisWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper_<>(DaoOperation.SELECT, this.stmtOption, this.getClass());
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

	
	
	@Override public List<StoplisInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<StoplisInfo> getNewInstance() {
		return new StoplisSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser_<StoplisInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<StoplisInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<StoplisInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				StoplisInfo dataInfo = new StoplisInfo();
				dataInfo.codOwner = stmtResult.getLong(StoplisDbTableColumn.COL_COD_OWNER);
				dataInfo.codSnapshot = stmtResult.getLong(StoplisDbTableColumn.COL_COD_SNAPSHOT);
				dataInfo.codStore = stmtResult.getLong(StoplisDbTableColumn.COL_COD_STORE);
				dataInfo.codPayPartner = stmtResult.getInt(StoplisDbTableColumn.COL_COD_PAY_PARTNER);
				dataInfo.recordMode = stmtResult.getString(StoplisDbTableColumn.COL_RECORD_MODE);
				dataInfo.idPayPartnerStore = stmtResult.getString(StoplisDbTableColumn.COL_ID_PAY_PARTNER_STORE);
				dataInfo.scope = stmtResult.getString(StoplisDbTableColumn.COL_SCOPE);
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
