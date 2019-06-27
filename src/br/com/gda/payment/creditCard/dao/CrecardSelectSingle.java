package br.com.gda.payment.creditCard.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public final class CrecardSelectSingle implements DaoStmt<CrecardInfo> {
	private final String LT_CARD = DaoDbTable.CREDIT_CARD_TABLE;	
	
	private DaoStmt<CrecardInfo> stmtSql;
	private DaoStmtOption<CrecardInfo> stmtOption;
	
	
	
	public CrecardSelectSingle(Connection conn, CrecardInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, CrecardInfo recordInfo, String schemaName) {
		stmtOption = new DaoStmtOption<>();
		stmtOption.conn = conn;
		stmtOption.recordInfo = recordInfo;
		stmtOption.schemaName = schemaName;
		stmtOption.tableName = LT_CARD;
		stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_CARD);
		stmtOption.stmtParamTranslator = null;
		stmtOption.resultParser = new ResultParser();
		stmtOption.whereClause = buildWhereClause();
		stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new CrecardWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<CrecardInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<CrecardInfo> getNewInstance() {
		return new CrecardSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<CrecardInfo> {
		private final boolean NOT_NULL = false;
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<CrecardInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<CrecardInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				CrecardInfo dataInfo = new CrecardInfo();
				dataInfo.codOwner = stmtResult.getLong(CrecardDbTableColumn.COL_COD_OWNER);
				dataInfo.codPayCustomer = stmtResult.getLong(CrecardDbTableColumn.COL_COD_PAY_CUSTOMER);
				dataInfo.creditCardId = stmtResult.getString(CrecardDbTableColumn.COL_CREDIT_CARD_ID);	
				dataInfo.creditCardBrand = stmtResult.getString(CrecardDbTableColumn.COL_CREDIT_CARD_BRAND);	
				dataInfo.creditCardLast4 = stmtResult.getString(CrecardDbTableColumn.COL_CREDIT_CARD_LAST4);
				dataInfo.recordMode = stmtResult.getString(CrecardDbTableColumn.COL_RECORD_MODE);
				
				
				Timestamp lastChanged = stmtResult.getTimestamp(CrecardDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();				
				
				stmtResult.getLong(CrecardDbTableColumn.COL_LAST_CHANGED_BY);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.lastChangedBy = stmtResult.getLong(CrecardDbTableColumn.COL_LAST_CHANGED_BY);	
				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
