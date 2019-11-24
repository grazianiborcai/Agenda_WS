package br.com.mind5.payment.creditCard.dao;

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
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class CrecardSelectSingle implements DaoStmt<CrecardInfo> {
	private final String LT_CARD = DaoDbTable.CREDIT_CARD_TABLE;	
	
	private DaoStmt<CrecardInfo> stmtSql;
	private DaoStmtOption_<CrecardInfo> stmtOption;
	
	
	
	public CrecardSelectSingle(Connection conn, CrecardInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, CrecardInfo recordInfo, String schemaName) {
		stmtOption = new DaoStmtOption_<>();
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
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new CrecardWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<CrecardInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<CrecardInfo> getNewInstance() {
		return new CrecardSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser_<CrecardInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<CrecardInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<CrecardInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				CrecardInfo dataInfo = new CrecardInfo();
				dataInfo.codOwner = stmtResult.getLong(CrecardDbTableColumn.COL_COD_OWNER);
				dataInfo.codCreditCard = stmtResult.getLong(CrecardDbTableColumn.COL_COD_CREDIT_CARD);
				dataInfo.codPayCustomer = stmtResult.getLong(CrecardDbTableColumn.COL_COD_PAY_CUSTOMER);
				dataInfo.creditCardId = stmtResult.getString(CrecardDbTableColumn.COL_CREDIT_CARD_ID);	
				dataInfo.creditCardBrand = stmtResult.getString(CrecardDbTableColumn.COL_CREDIT_CARD_BRAND);	
				dataInfo.creditCardLast4 = stmtResult.getString(CrecardDbTableColumn.COL_CREDIT_CARD_LAST4);
				dataInfo.recordMode = stmtResult.getString(CrecardDbTableColumn.COL_RECORD_MODE);
				dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, CrecardDbTableColumn.COL_LAST_CHANGED);
				dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, CrecardDbTableColumn.COL_LAST_CHANGED_BY);
				dataInfo.codAddressHolder = DaoFormatter.sqlToLong(stmtResult, CrecardDbTableColumn.COL_COD_ADDRESS);
				dataInfo.codAddressSnapshotHolder = DaoFormatter.sqlToLong(stmtResult, CrecardDbTableColumn.COL_COD_ADDRESS_SNAPSHOT);
				dataInfo.codPhoneHolder = DaoFormatter.sqlToLong(stmtResult, CrecardDbTableColumn.COL_COD_PHONE);
				dataInfo.codPhoneSnapshotHolder = DaoFormatter.sqlToLong(stmtResult, CrecardDbTableColumn.COL_COD_PHONE_SNAPSHOT);				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
