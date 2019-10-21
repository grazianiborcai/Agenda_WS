package br.com.mind5.business.orderItemSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.dao.DaoFormatter;
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

public final class OrdemrapSelectSingle implements DaoStmt<OrdemrapInfo> {	
	private final String LT_ITM = DaoDbTable.ORDER_ITM_SNAPSHOT_TABLE;
	
	private DaoStmt<OrdemrapInfo> stmtSql;
	private DaoStmtOption<OrdemrapInfo> stmtOption;
	
	
	
	public OrdemrapSelectSingle(Connection conn, OrdemrapInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, OrdemrapInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_ITM;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_ITM);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new OrdemrapWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<OrdemrapInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<OrdemrapInfo> getNewInstance() {
		return new OrdemrapSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<OrdemrapInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<OrdemrapInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			
			List<OrdemrapInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				OrdemrapInfo dataInfo = new OrdemrapInfo();
				dataInfo.codOwner = stmtResult.getLong(OrdemrapDbTableColumn.COL_COD_OWNER);	
				dataInfo.codSnapshot = stmtResult.getLong(OrdemrapDbTableColumn.COL_COD_SNAPSHOT);
				dataInfo.codOrder = stmtResult.getLong(OrdemrapDbTableColumn.COL_COD_ORDER);
				dataInfo.codOrderItem = DaoFormatter.sqlToInt(stmtResult, OrdemrapDbTableColumn.COL_COD_ORDER_ITEM);
				dataInfo.quantity = stmtResult.getInt(OrdemrapDbTableColumn.COL_QUANTITY);
				dataInfo.codCurr = stmtResult.getString(OrdemrapDbTableColumn.COL_COD_CURRENCY);
				dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, OrdemrapDbTableColumn.COL_COD_STORE);
				dataInfo.codStoreSnapshot = DaoFormatter.sqlToLong(stmtResult, OrdemrapDbTableColumn.COL_COD_STORE_SNAPSHOT);
				dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, OrdemrapDbTableColumn.COL_COD_EMPLOYEE);
				dataInfo.codEmployeeSnapshot = DaoFormatter.sqlToLong(stmtResult, OrdemrapDbTableColumn.COL_COD_EMPLOYEE_SNAPSHOT);
				dataInfo.codMat = DaoFormatter.sqlToLong(stmtResult, OrdemrapDbTableColumn.COL_COD_MATERIAL);
				dataInfo.codMatSnapshot = DaoFormatter.sqlToLong(stmtResult, OrdemrapDbTableColumn.COL_COD_MATERIAL_SNAPSHOT);
				dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, OrdemrapDbTableColumn.COL_DATE);
				dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, OrdemrapDbTableColumn.COL_BEGIN_TIME);
				dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, OrdemrapDbTableColumn.COL_END_TIME);
				dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, OrdemrapDbTableColumn.COL_LAST_CHANGED);
				dataInfo.lastChangedBy = stmtResult.getLong(OrdemrapDbTableColumn.COL_LAST_CHANGED_BY);
				dataInfo.price = DaoFormatter.sqlToDouble(stmtResult, OrdemrapDbTableColumn.COL_PRICE);
				dataInfo.totitem = DaoFormatter.sqlToDouble(stmtResult, OrdemrapDbTableColumn.COL_TOTAL_ITEM);
				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
