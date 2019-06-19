package br.com.gda.payment.customerPartner.dao;

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
import br.com.gda.payment.customerPartner.info.CusparInfo;

public final class CusparSelectSingle implements DaoStmt<CusparInfo> {
	private final String LT_PAYCUS = DaoDbTable.PAY_CUS_TABLE;
	
	private DaoStmt<CusparInfo> stmtSql;
	private DaoStmtOption<CusparInfo> stmtOption;
	
	
	
	public CusparSelectSingle(Connection conn, CusparInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, CusparInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_PAYCUS;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_PAYCUS);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new CusparWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		stmtSql = new DaoStmtHelper<>(DaoOperation.SELECT, this.stmtOption);
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

	
	
	@Override public List<CusparInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<CusparInfo> getNewInstance() {
		return new CusparSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<CusparInfo> {
		private final boolean NOT_NULL = false;
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<CusparInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			
			List<CusparInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				CusparInfo dataInfo = new CusparInfo();
				dataInfo.codOwner = stmtResult.getLong(CusparDbTableColumn.COL_COD_OWNER);	
				dataInfo.codPayCustomer = stmtResult.getLong(CusparDbTableColumn.COL_COD_PAYCUS);
				dataInfo.codUser = stmtResult.getLong(CusparDbTableColumn.COL_COD_USER);
				dataInfo.recordMode = stmtResult.getString(CusparDbTableColumn.COL_RECORD_MODE);
				
				stmtResult.getLong(CusparDbTableColumn.COL_COD_USER_SNAPSHOT);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codUserSnapshot = stmtResult.getLong(CusparDbTableColumn.COL_COD_USER_SNAPSHOT);
				
				stmtResult.getLong(CusparDbTableColumn.COL_COD_CUSTOMER);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codCustomer = stmtResult.getLong(CusparDbTableColumn.COL_COD_CUSTOMER);
				
				stmtResult.getLong(CusparDbTableColumn.COL_COD_CUSTOMER_SNAPSHOT);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codCustomerSnapshot = stmtResult.getLong(CusparDbTableColumn.COL_COD_CUSTOMER_SNAPSHOT);
				
				stmtResult.getLong(CusparDbTableColumn.COL_COD_PAY_PARTNER);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codPayPartner = stmtResult.getLong(CusparDbTableColumn.COL_COD_PAY_PARTNER);
				
				Timestamp lastChanged = stmtResult.getTimestamp(CusparDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();			
				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
