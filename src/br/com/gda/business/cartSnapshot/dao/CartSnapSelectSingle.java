package br.com.gda.business.cartSnapshot.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cartSnapshot.info.CartSnapInfo;
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

public final class CartSnapSelectSingle implements DaoStmt<CartSnapInfo> {
	private final String LT_HDR = DaoDbTable.CART_HDR_SNAPSHOT_TABLE;	
	private final String RT_ITM = DaoDbTable.CART_ITM_SNAPSHOT_TABLE;
	
	private DaoStmt<CartSnapInfo> stmtSql;
	private DaoStmtOption<CartSnapInfo> stmtOption;
	
	
	
	public CartSnapSelectSingle(Connection conn, CartSnapInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, CartSnapInfo recordInfo, String schemaName) {
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
		
		DaoStmtWhere whereClause = new CartSnapWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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
		oneColumn.leftColumnName = CartSnapDbTableColumn.COL_COD_OWNER;
		oneColumn.rightColumnName = CartSnapDbTableColumn.COL_COD_OWNER;
		joinColumns.add(oneColumn);
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_HDR;
		oneColumn.leftColumnName = CartSnapDbTableColumn.COL_COD_SNAPSHOT;
		oneColumn.rightColumnName = CartSnapDbTableColumn.COL_COD_SNAPSHOT;
		joinColumns.add(oneColumn);
		
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RT_ITM;
		join.joinType = DaoJoinType.INNER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = null;
		
		return join;
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

	
	
	@Override public List<CartSnapInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<CartSnapInfo> getNewInstance() {
		return new CartSnapSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<CartSnapInfo> {
		private final boolean NOT_NULL = false;
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<CartSnapInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			
			List<CartSnapInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				CartSnapInfo dataInfo = new CartSnapInfo();
				dataInfo.codOwner = stmtResult.getLong(CartSnapDbTableColumn.COL_COD_OWNER);
				dataInfo.codSnapshot = stmtResult.getLong(CartSnapDbTableColumn.COL_COD_SNAPSHOT);
				dataInfo.codUser = stmtResult.getLong(CartSnapDbTableColumn.COL_COD_USER);
				dataInfo.itemNumber = stmtResult.getInt(CartSnapDbTableColumn.COL_ITEM_NUMBER);	
				dataInfo.quantity = stmtResult.getInt(CartSnapDbTableColumn.COL_QUANTITY);		
				dataInfo.codCurr = stmtResult.getString(CartSnapDbTableColumn.COL_COD_CURRRENCY);	
				
				stmtResult.getLong(CartSnapDbTableColumn.COL_COD_CUSTOMER);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codCustomer = stmtResult.getLong(CartSnapDbTableColumn.COL_COD_CUSTOMER);
				
				stmtResult.getLong(CartSnapDbTableColumn.COL_COD_PERSON);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codPerson = stmtResult.getLong(CartSnapDbTableColumn.COL_COD_PERSON);
				
				stmtResult.getLong(CartSnapDbTableColumn.COL_COD_STORE);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codStore = stmtResult.getLong(CartSnapDbTableColumn.COL_COD_STORE);
				
				stmtResult.getLong(CartSnapDbTableColumn.COL_COD_EMPLOYEE);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codEmployee = stmtResult.getLong(CartSnapDbTableColumn.COL_COD_EMPLOYEE);
				
				stmtResult.getLong(CartSnapDbTableColumn.COL_COD_MATERIAL);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codMat = stmtResult.getLong(CartSnapDbTableColumn.COL_COD_MATERIAL);
				
				stmtResult.getString(CartSnapDbTableColumn.COL_COD_ITEM_CATEG);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codItemCateg = stmtResult.getString(CartSnapDbTableColumn.COL_COD_ITEM_CATEG).charAt(0);
				
				stmtResult.getString(CartSnapDbTableColumn.COL_COD_FEE_CATEG);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codFeeCateg = stmtResult.getString(CartSnapDbTableColumn.COL_COD_FEE_CATEG).charAt(0);
				
				stmtResult.getDouble(CartSnapDbTableColumn.COL_PRICE);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.price = stmtResult.getDouble(CartSnapDbTableColumn.COL_PRICE);


				Date date = stmtResult.getDate(CartSnapDbTableColumn.COL_DATE);
				if (date != null)
					dataInfo.date = date.toLocalDate();
				
				Time beginTime = stmtResult.getTime(CartSnapDbTableColumn.COL_BEGIN_TIME);
				if (beginTime != null)
					dataInfo.beginTime = beginTime.toLocalTime();
				
				Time endTime = stmtResult.getTime(CartSnapDbTableColumn.COL_END_TIME);
				if (endTime != null)
					dataInfo.endTime = endTime.toLocalTime();
				
				Timestamp lastChanged = stmtResult.getTimestamp(CartSnapDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();
				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
