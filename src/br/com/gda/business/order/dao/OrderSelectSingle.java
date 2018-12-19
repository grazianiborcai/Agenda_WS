package br.com.gda.business.order.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.dao.DaoDbTable;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoJoin;
import br.com.gda.dao.DaoJoinColumn;
import br.com.gda.dao.DaoJoinType;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;

public final class OrderSelectSingle implements DaoStmt<OrderInfo> {
	private final String LT_HDR = DaoDbTable.ORDER_HDR_TABLE;	
	private final String RT_ITM = DaoDbTable.ORDER_ITM_TABLE;
	
	private DaoStmt<OrderInfo> stmtSql;
	private DaoStmtOption<OrderInfo> stmtOption;
	
	
	
	public OrderSelectSingle(Connection conn, OrderInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, OrderInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_HDR;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_HDR);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = buildJoins();
	}
	
	
	
	private String buildWhereClause() {
		final boolean IGNORE_NULL = true;
		final boolean IGNORE_RECORD_MODE = true;
		
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = IGNORE_NULL;
		whereOption.ignoreRecordMode = IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new OrderWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private List<DaoJoin> buildJoins() {
		List<DaoJoin> joins = new ArrayList<>();		
		joins.add(buildJoinCartItm());
		return joins;
	}
	
	
	
	private DaoJoin buildJoinCartItm() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_HDR;
		oneColumn.leftColumnName = OrderDbTableColumn.COL_COD_OWNER;
		oneColumn.rightColumnName = OrderDbTableColumn.COL_COD_OWNER;
		joinColumns.add(oneColumn);
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_HDR;
		oneColumn.leftColumnName = OrderDbTableColumn.COL_COD_ORDER;
		oneColumn.rightColumnName = OrderDbTableColumn.COL_COD_ORDER;
		joinColumns.add(oneColumn);
		
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RT_ITM;
		join.joinType = DaoJoinType.INNER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = null;
		
		return join;
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

	
	
	@Override public List<OrderInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<OrderInfo> getNewInstance() {
		return new OrderSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<OrderInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<OrderInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<OrderInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				OrderInfo dataInfo = new OrderInfo();
				dataInfo.codOwner = stmtResult.getLong(OrderDbTableColumn.COL_COD_OWNER);
				dataInfo.codOrder = stmtResult.getLong(OrderDbTableColumn.COL_COD_ORDER);
				dataInfo.codCustomer = stmtResult.getLong(OrderDbTableColumn.COL_COD_CUSTOMER);
				//dataInfo.codSnapshot = stmtResult.getLong(OrderDbTableColumn.COL_COD_SNAPSHOT);
				dataInfo.codOrderExt = stmtResult.getString(OrderDbTableColumn.COL_COD_ORDER_EXT);
				dataInfo.codOrderStatus = stmtResult.getString(OrderDbTableColumn.COL_COD_ORDER_STATUS);
				dataInfo.itemNumber = stmtResult.getInt(OrderDbTableColumn.COL_ITEM_NUMBER);
				dataInfo.codStore = stmtResult.getLong(OrderDbTableColumn.COL_COD_STORE);
				dataInfo.codMat = stmtResult.getLong(OrderDbTableColumn.COL_COD_MATERIAL);
				dataInfo.matTxt = stmtResult.getString(OrderDbTableColumn.COL_MAT_NAME);
				dataInfo.matUnit = stmtResult.getString(OrderDbTableColumn.COL_MAT_COD_UNIT);
				dataInfo.matPrice = stmtResult.getDouble(OrderDbTableColumn.COL_MAT_PRICE);
				dataInfo.matQuantity = stmtResult.getInt(OrderDbTableColumn.COL_MAT_QUANTITY);
				dataInfo.matCodCurr = stmtResult.getString(OrderDbTableColumn.COL_MAT_COD_CURR);
				dataInfo.matCodType = stmtResult.getInt(OrderDbTableColumn.COL_MAT_COD_TYPE);
				dataInfo.matCodCategory = stmtResult.getInt(OrderDbTableColumn.COL_MAT_COD_CATEG);
				dataInfo.matPriceUnit = stmtResult.getInt(OrderDbTableColumn.COL_MAT_PRICE_UNIT);
				dataInfo.matCodGroup = stmtResult.getInt(OrderDbTableColumn.COL_MAT_COD_GROUP);
				dataInfo.storeCnpj = stmtResult.getString(OrderDbTableColumn.COL_STORE_CNPJ);
				dataInfo.storeInscrMun = stmtResult.getString(OrderDbTableColumn.COL_STORE_INSC_MUNICIPAL);
				dataInfo.storeInscrEst = stmtResult.getString(OrderDbTableColumn.COL_STORE_INSC_ESTADUAL);
				dataInfo.storeName = stmtResult.getString(OrderDbTableColumn.COL_STORE_NAME);
				dataInfo.storeCountry = stmtResult.getString(OrderDbTableColumn.COL_STORE_COUNTRY);
				dataInfo.storeStateProvince = stmtResult.getString(OrderDbTableColumn.COL_STORE_STATE_PROVINCE);
				dataInfo.storeCodCurr = stmtResult.getString(OrderDbTableColumn.COL_STORE_COD_CURR);
				dataInfo.storeCodTimezone = stmtResult.getString(OrderDbTableColumn.COL_STORE_COD_TIMEZONE);
				dataInfo.codEmployee = stmtResult.getLong(OrderDbTableColumn.COL_COD_EMPLOYEE);
				dataInfo.empCpf = stmtResult.getString(OrderDbTableColumn.COL_EMP_COD_CPF);
				dataInfo.empName = stmtResult.getString(OrderDbTableColumn.COL_EMP_NAME);				
				
				
				String codItemCateg = stmtResult.getString(OrderDbTableColumn.COL_COD_ITEM_CATEG);
				if (codItemCateg != null)
					dataInfo.codItemCateg = codItemCateg.charAt(0);
				
				Timestamp lastChanged = stmtResult.getTimestamp(OrderDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();
				
				Time beginTime = stmtResult.getTime(OrderDbTableColumn.COL_MAT_BEGIN_TIME);
				if (beginTime != null)
					dataInfo.matBeginTime = beginTime.toLocalTime();
				
				Time endTime = stmtResult.getTime(OrderDbTableColumn.COL_MAT_END_TIME);
				if (endTime != null)
					dataInfo.matEndTime = endTime.toLocalTime();

				Date date = stmtResult.getDate(OrderDbTableColumn.COL_MAT_DATE);
				if (date != null)
					dataInfo.matDate = date.toLocalDate();
				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
