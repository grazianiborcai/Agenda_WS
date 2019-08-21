package br.com.gda.business.orderList.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.orderList.info.OrdistInfo;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public final class OrdistSelectSingle implements DaoStmt<OrdistInfo> {
	private final String LT_HDR = DaoDbTable.ORDER_HDR_TABLE;
	
	private DaoStmt<OrdistInfo> stmtSql;
	private DaoStmtOption<OrdistInfo> stmtOption;
	
	
	
	public OrdistSelectSingle(Connection conn, OrdistInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, OrdistInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_HDR;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(DaoDbTable.ORDER_LIST_VIEW);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new OrdistWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<OrdistInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<OrdistInfo> getNewInstance() {
		return new OrdistSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<OrdistInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<OrdistInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			
			List<OrdistInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				OrdistInfo dataInfo = new OrdistInfo();
				dataInfo.codOwner = stmtResult.getLong(OrdistDbTableColumn.COL_COD_OWNER);	
				dataInfo.codOrder = stmtResult.getLong(OrdistDbTableColumn.COL_COD_ORDER);
				dataInfo.codUser = stmtResult.getLong(OrdistDbTableColumn.COL_COD_USER);	
				dataInfo.codOrderExt = stmtResult.getString(OrdistDbTableColumn.COL_COD_ORDER_EXTERNAL);	
				dataInfo.codOrderStatus = stmtResult.getString(OrdistDbTableColumn.COL_COD_ORDER_STATUS);
				dataInfo.codCurr = stmtResult.getString(OrdistDbTableColumn.COL_COD_CURRENCY);
				dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, OrdistDbTableColumn.COL_COD_CUSTOMER);
				dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, OrdistDbTableColumn.COL_LAST_CHANGED);
				dataInfo.itemTotal = DaoFormatter.sqlToDouble(stmtResult, OrdistDbTableColumn.COL_ITEM_TOTAL);
				dataInfo.feeService = DaoFormatter.sqlToDouble(stmtResult, OrdistDbTableColumn.COL_FEE_SERVICE);
				dataInfo.grandTotal = DaoFormatter.sqlToDouble(stmtResult, OrdistDbTableColumn.COL_GRAND_TOTAL);
				dataInfo.codPayOrder = DaoFormatter.sqlToLong(stmtResult, OrdistDbTableColumn.COL_COD_PAY_ORDER);
				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
