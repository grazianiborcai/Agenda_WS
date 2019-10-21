package br.com.mind5.payment.storePartnerSnapshot.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapInfo;

public final class StoparnapSelectSingle implements DaoStmt<StoparnapInfo> {
	private final static String LT_ATTR = DaoDbTable.PAY_PARTNER_STORE_SNAPSHOT_TABLE;
	
	private DaoStmt<StoparnapInfo> stmtSql;
	private DaoStmtOption<StoparnapInfo> stmtOption;
	
	
	
	public StoparnapSelectSingle(Connection conn, StoparnapInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, StoparnapInfo recordInfo, String schemaName) {
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
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new StoparnapWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<StoparnapInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<StoparnapInfo> getNewInstance() {
		return new StoparnapSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<StoparnapInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		private final boolean NOT_NULL = false;
		
		@Override public List<StoparnapInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<StoparnapInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				StoparnapInfo dataInfo = new StoparnapInfo();
				dataInfo.codOwner = stmtResult.getLong(StoparnapDbTableColumn.COL_COD_OWNER);
				dataInfo.codSnapshot = stmtResult.getLong(StoparnapDbTableColumn.COL_COD_SNAPSHOT);
				dataInfo.codStore = stmtResult.getLong(StoparnapDbTableColumn.COL_COD_STORE);
				dataInfo.codPayPartner = stmtResult.getInt(StoparnapDbTableColumn.COL_COD_PAY_PARTNER);
				dataInfo.recordMode = stmtResult.getString(StoparnapDbTableColumn.COL_RECORD_MODE);
				dataInfo.lastChangedBy = stmtResult.getLong(StoparnapDbTableColumn.COL_LAST_CHANGED);
				dataInfo.idPayPartnerStore = stmtResult.getString(StoparnapDbTableColumn.COL_ID_PAY_PARTNER_STORE);
				dataInfo.codePayPartnerStore = stmtResult.getString(StoparnapDbTableColumn.COL_CODE_PAY_PARTNER_STORE);
				dataInfo.accessToken = stmtResult.getString(StoparnapDbTableColumn.COL_ACCESS_TOKEN);
				dataInfo.refreshToken = stmtResult.getString(StoparnapDbTableColumn.COL_REFRESH_TOKEN);
				dataInfo.scope = stmtResult.getString(StoparnapDbTableColumn.COL_SCOPE);
				
				stmtResult.getLong(StoparnapDbTableColumn.COL_LAST_CHANGED_BY);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.lastChangedBy = stmtResult.getLong(StoparnapDbTableColumn.COL_LAST_CHANGED_BY);
				
				Timestamp lastChanged = stmtResult.getTimestamp(StoparnapDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();
				
				Date tokenExpiresIn = stmtResult.getDate(StoparnapDbTableColumn.COL_TOKEN_EXPIRES_IN);
				if (tokenExpiresIn != null)
					dataInfo.tokenExpiresIn = tokenExpiresIn.toLocalDate();
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
