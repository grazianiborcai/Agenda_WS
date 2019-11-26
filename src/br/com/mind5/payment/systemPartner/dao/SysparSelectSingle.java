package br.com.mind5.payment.systemPartner.dao;

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
import br.com.mind5.payment.systemPartner.info.SysparInfo;

public final class SysparSelectSingle implements DaoStmt<SysparInfo> {
	private final static String MAIN_TABLE = DaoDbTable.SYS_PAY_PARTNER_TABLE;
	
	private DaoStmt<SysparInfo> stmtSql;
	private DaoStmtOption_<SysparInfo> stmtOption;
	
	
	
	public SysparSelectSingle(Connection conn, SysparInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, SysparInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption_<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = MAIN_TABLE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(MAIN_TABLE);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new SysparWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<SysparInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<SysparInfo> getNewInstance() {
		return new SysparSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser_<SysparInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<SysparInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<SysparInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				SysparInfo dataInfo = new SysparInfo();
				dataInfo.idPayPartnerSystem = stmtResult.getString(SysparDbTableColumn.COL_ID_PAY_PARTNER_SYSTEM);
				dataInfo.idPayPartnerApp = stmtResult.getString(SysparDbTableColumn.COL_ID_PAY_PARTNER_APP);
				dataInfo.codPayPartner = stmtResult.getInt(SysparDbTableColumn.COL_COD_PAY_PARTNER);
				dataInfo.payPartnerName = stmtResult.getString(SysparDbTableColumn.COL_PAY_PARTNER_NAME);	
				dataInfo.urlReturn = stmtResult.getString(SysparDbTableColumn.COL_URL_RETURN);				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
