package br.com.mind5.payment.storePartner.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
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
import br.com.mind5.payment.storePartner.info.StoparInfo;

public final class StoparSelectSingle implements DaoStmt<StoparInfo> {
	private final static String LT_ATTR = DaoDbTable.PAY_PARTNER_STORE_TABLE;
	
	private DaoStmt<StoparInfo> stmtSql;
	private DaoStmtOption_<StoparInfo> stmtOption;
	
	
	
	public StoparSelectSingle(Connection conn, StoparInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, StoparInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption_<>();
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
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new StoparWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<StoparInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<StoparInfo> getNewInstance() {
		return new StoparSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser_<StoparInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<StoparInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<StoparInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				StoparInfo dataInfo = new StoparInfo();
				dataInfo.codOwner = stmtResult.getLong(StoparDbTableColumn.COL_COD_OWNER);
				dataInfo.codSnapshot = stmtResult.getLong(StoparDbTableColumn.COL_COD_SNAPSHOT);
				dataInfo.codStore = stmtResult.getLong(StoparDbTableColumn.COL_COD_STORE);
				dataInfo.codPayPartner = stmtResult.getInt(StoparDbTableColumn.COL_COD_PAY_PARTNER);
				dataInfo.recordMode = stmtResult.getString(StoparDbTableColumn.COL_RECORD_MODE);
				dataInfo.codePayPartnerStore = stmtResult.getString(StoparDbTableColumn.COL_CODE_PAY_PARTNER_STORE);
				dataInfo.idPayPartnerStore = stmtResult.getString(StoparDbTableColumn.COL_ID_PAY_PARTNER_STORE);				
				dataInfo.accessToken = stmtResult.getString(StoparDbTableColumn.COL_ACCESS_TOKEN);
				dataInfo.refreshToken = stmtResult.getString(StoparDbTableColumn.COL_REFRESH_TOKEN);
				dataInfo.scope = stmtResult.getString(StoparDbTableColumn.COL_SCOPE);
				dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, StoparDbTableColumn.COL_LAST_CHANGED_BY);
				dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, StoparDbTableColumn.COL_LAST_CHANGED);
				dataInfo.tokenExpiresIn = DaoFormatter.sqlToLocalDate(stmtResult, StoparDbTableColumn.COL_TOKEN_EXPIRES_IN);
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
