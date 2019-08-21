package br.com.gda.business.orderItem.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public final class OrderemSelectSingle implements DaoStmt<OrderemInfo> {	
	private final String LT_ITM = DaoDbTable.ORDER_ITM_TABLE;
	
	private DaoStmt<OrderemInfo> stmtSql;
	private DaoStmtOption<OrderemInfo> stmtOption;
	
	
	
	public OrderemSelectSingle(Connection conn, OrderemInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, OrderemInfo recordInfo, String schemaName) {
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
		whereOption.ignoreNull = DaoWhereBuilderOption.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new OrderemWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<OrderemInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<OrderemInfo> getNewInstance() {
		return new OrderemSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<OrderemInfo> {
		private final boolean NOT_NULL = false;
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<OrderemInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			
			List<OrderemInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				OrderemInfo dataInfo = new OrderemInfo();
				dataInfo.codOwner = stmtResult.getLong(OrderemDbTableColumn.COL_COD_OWNER);	
				dataInfo.codOrder = stmtResult.getLong(OrderemDbTableColumn.COL_COD_ORDER);
				dataInfo.quantity = stmtResult.getInt(OrderemDbTableColumn.COL_QUANTITY);
				dataInfo.codCurr = stmtResult.getString(OrderemDbTableColumn.COL_COD_CURR);
				
				stmtResult.getLong(OrderemDbTableColumn.COL_COD_STORE);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codStore = stmtResult.getLong(OrderemDbTableColumn.COL_COD_STORE);
				
				stmtResult.getLong(OrderemDbTableColumn.COL_COD_STORE_SNAPSHOT);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codStoreSnapshot = stmtResult.getLong(OrderemDbTableColumn.COL_COD_STORE_SNAPSHOT);
				
				stmtResult.getLong(OrderemDbTableColumn.COL_COD_EMPLOYEE);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codEmployee = stmtResult.getLong(OrderemDbTableColumn.COL_COD_EMPLOYEE);
				
				stmtResult.getLong(OrderemDbTableColumn.COL_COD_EMPLOYEE_SNAPSHOT);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codEmployeeSnapshot = stmtResult.getLong(OrderemDbTableColumn.COL_COD_EMPLOYEE_SNAPSHOT);
				
				stmtResult.getLong(OrderemDbTableColumn.COL_COD_MATERIAL);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codMat = stmtResult.getLong(OrderemDbTableColumn.COL_COD_MATERIAL);
				
				stmtResult.getLong(OrderemDbTableColumn.COL_COD_MATERIAL_SNAPSHOT);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codMatSnapshot = stmtResult.getLong(OrderemDbTableColumn.COL_COD_MATERIAL_SNAPSHOT);

				Date date = stmtResult.getDate(OrderemDbTableColumn.COL_DATE);
				if (date != null)
					dataInfo.date = date.toLocalDate();
				
				Time beginTime = stmtResult.getTime(OrderemDbTableColumn.COL_BEGIN_TIME);
				if (beginTime != null)
					dataInfo.beginTime = beginTime.toLocalTime();
				
				Time endTime = stmtResult.getTime(OrderemDbTableColumn.COL_END_TIME);
				if (endTime != null)
					dataInfo.endTime = endTime.toLocalTime();
				
				Timestamp lastChanged = stmtResult.getTimestamp(OrderemDbTableColumn.COL_CREATED_ON);
				if (lastChanged != null)
					dataInfo.createdOn = lastChanged.toLocalDateTime();
				
				stmtResult.getDouble(OrderemDbTableColumn.COL_PRICE);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.price = stmtResult.getDouble(OrderemDbTableColumn.COL_PRICE);
				
				stmtResult.getDouble(OrderemDbTableColumn.COL_TOTAL_ITEM);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.totitem = stmtResult.getDouble(OrderemDbTableColumn.COL_TOTAL_ITEM);
				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
