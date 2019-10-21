package br.com.mind5.payment.partnerMoip.permissionMoip.dao;

import java.sql.Connection;
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
import br.com.mind5.payment.partnerMoip.permissionMoip.info.PeresmoipInfo;

public final class PeresmoipSelectSingle implements DaoStmt<PeresmoipInfo> {
	private final static String LT_ATTR = DaoDbTable.MOIP_PERMISSION_RESPONSE_TABLE;
	
	private DaoStmt<PeresmoipInfo> stmtSql;
	private DaoStmtOption<PeresmoipInfo> stmtOption;
	
	
	
	public PeresmoipSelectSingle(Connection conn, PeresmoipInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, PeresmoipInfo recordInfo, String schemaName) {
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
		
		DaoStmtWhere whereClause = new PeresmoipWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<PeresmoipInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<PeresmoipInfo> getNewInstance() {
		return new PeresmoipSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<PeresmoipInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<PeresmoipInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<PeresmoipInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				PeresmoipInfo dataInfo = new PeresmoipInfo();
				dataInfo.codOwner = stmtResult.getLong(PeresmoipDbTableColumn.COL_COD_OWNER);
				dataInfo.codStore = stmtResult.getLong(PeresmoipDbTableColumn.COL_COD_STORE);
				dataInfo.isExpected = stmtResult.getBoolean(PeresmoipDbTableColumn.COL_IS_EXPECTED);
				dataInfo.username = stmtResult.getString(PeresmoipDbTableColumn.COL_USERNAME);
				
				Timestamp lastChanged = stmtResult.getTimestamp(PeresmoipDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
