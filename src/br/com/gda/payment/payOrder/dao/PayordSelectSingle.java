package br.com.gda.payment.payOrder.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
import br.com.gda.payment.payOrder.info.PayordInfo;

public final class PayordSelectSingle implements DaoStmt<PayordInfo> {
	private final static String LT_ATTR = DaoDbTable.PAY_ORDER_TABLE;
	
	private DaoStmt<PayordInfo> stmtSql;
	private DaoStmtOption<PayordInfo> stmtOption;
	
	
	
	public PayordSelectSingle(Connection conn, PayordInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, PayordInfo recordInfo, String schemaName) {
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
		whereOption.ignoreNull = DaoWhereBuilderOption.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new PayordWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<PayordInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<PayordInfo> getNewInstance() {
		return new PayordSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<PayordInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		private final boolean NOT_NULL = false;
		
		@Override public List<PayordInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<PayordInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				PayordInfo dataInfo = new PayordInfo();
				dataInfo.codOwner = stmtResult.getLong(PayordDbTableColumn.COL_COD_OWNER);
				dataInfo.codSnapshot = stmtResult.getLong(PayordDbTableColumn.COL_COD_SNAPSHOT);
				dataInfo.codStore = stmtResult.getLong(PayordDbTableColumn.COL_COD_STORE);
				dataInfo.codPayPartner = stmtResult.getInt(PayordDbTableColumn.COL_COD_PAY_PARTNER);
				dataInfo.recordMode = stmtResult.getString(PayordDbTableColumn.COL_RECORD_MODE);
				dataInfo.lastChangedBy = stmtResult.getLong(PayordDbTableColumn.COL_LAST_CHANGED);
				dataInfo.idPayPartnerStore = stmtResult.getString(PayordDbTableColumn.COL_ID_PAY_PARTNER_STORE);
				
				stmtResult.getLong(PayordDbTableColumn.COL_LAST_CHANGED_BY);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.lastChangedBy = stmtResult.getLong(PayordDbTableColumn.COL_LAST_CHANGED_BY);
				
				Timestamp lastChanged = stmtResult.getTimestamp(PayordDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
