package br.com.mind5.business.orderSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderSearch.info.OrdarchInfo;
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

public final class OrdarchSelectSingle implements DaoStmt<OrdarchInfo> {
	private final String LT_HDR = DaoDbTable.ORDER_HDR_TABLE;
	
	private DaoStmt<OrdarchInfo> stmtSql;
	private DaoStmtOption<OrdarchInfo> stmtOption;
	
	
	
	public OrdarchSelectSingle(Connection conn, OrdarchInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, OrdarchInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_HDR;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(DaoDbTable.ORDER_SEARCH_VIEW);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new OrdarchWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		stmtSql = new DaoStmtHelper<>(DaoOperation.SELECT, this.stmtOption, this.getClass());
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

	
	
	@Override public List<OrdarchInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<OrdarchInfo> getNewInstance() {
		return new OrdarchSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<OrdarchInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<OrdarchInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			
			List<OrdarchInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				OrdarchInfo dataInfo = new OrdarchInfo();
				dataInfo.codOwner = stmtResult.getLong(OrdarchDbTableColumn.COL_COD_OWNER);	
				dataInfo.codOrder = stmtResult.getLong(OrdarchDbTableColumn.COL_COD_ORDER);
				dataInfo.codUser = stmtResult.getLong(OrdarchDbTableColumn.COL_COD_USER);	
				dataInfo.codOrderExt = stmtResult.getString(OrdarchDbTableColumn.COL_COD_ORDER_EXTERNAL);	
				dataInfo.codOrderStatus = stmtResult.getString(OrdarchDbTableColumn.COL_COD_ORDER_STATUS);
				dataInfo.codCustomer = stmtResult.getLong(OrdarchDbTableColumn.COL_COD_CUSTOMER);
				dataInfo.codPayOrder = stmtResult.getLong(OrdarchDbTableColumn.COL_COD_PAY_ORDER);				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
