package br.com.gda.payment.payOrderItem.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

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
import br.com.gda.payment.payOrderItem.info.PayordemInfo;

public final class PayordemSelectSingle implements DaoStmt<PayordemInfo> {	
	private final String LT_ITM = DaoDbTable.PAY_ORDER_ITM_TABLE;
	
	private DaoStmt<PayordemInfo> stmtSql;
	private DaoStmtOption<PayordemInfo> stmtOption;
	
	
	
	public PayordemSelectSingle(Connection conn, PayordemInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, PayordemInfo recordInfo, String schemaName) {
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
		
		DaoStmtWhere whereClause = new PayordemWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<PayordemInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<PayordemInfo> getNewInstance() {
		return new PayordemSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<PayordemInfo> {
		private final boolean NOT_NULL = false;
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<PayordemInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			
			List<PayordemInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				PayordemInfo dataInfo = new PayordemInfo();
				dataInfo.codOwner = stmtResult.getLong(PayordemDbTableColumn.COL_COD_OWNER);	
				dataInfo.codPayOrder = stmtResult.getLong(PayordemDbTableColumn.COL_COD_PAY_ORDER);
				dataInfo.itemNum = stmtResult.getInt(PayordemDbTableColumn.COL_ITEM_NUMBER);
				dataInfo.quantity = stmtResult.getInt(PayordemDbTableColumn.COL_QUANTITY);
				dataInfo.codCurr = stmtResult.getString(PayordemDbTableColumn.COL_COD_CURR);
				dataInfo.itemReceiver = stmtResult.getString(PayordemDbTableColumn.COL_ITEM_RECEIVER);
				dataInfo.ownId = stmtResult.getString(PayordemDbTableColumn.COL_OWN_ID);
				dataInfo.idOrderPartner = stmtResult.getString(PayordemDbTableColumn.COL_ID_ORDER_PARTNER);
				dataInfo.statusOrderPartner = stmtResult.getString(PayordemDbTableColumn.COL_STATUS_ORDER_PARTNER);
				
				stmtResult.getString(PayordemDbTableColumn.COL_COD_FEE_CATEG);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codFeeCateg = DaoFormatter.stringToChar(stmtResult.getString(PayordemDbTableColumn.COL_COD_FEE_CATEG));
				
				stmtResult.getLong(PayordemDbTableColumn.COL_COD_STORE);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codStore = stmtResult.getLong(PayordemDbTableColumn.COL_COD_STORE);
				
				stmtResult.getLong(PayordemDbTableColumn.COL_COD_EMPLOYEE);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codEmployee = stmtResult.getLong(PayordemDbTableColumn.COL_COD_EMPLOYEE);
				
				stmtResult.getLong(PayordemDbTableColumn.COL_COD_MATERIAL);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codMat = stmtResult.getLong(PayordemDbTableColumn.COL_COD_MATERIAL);

				Date date = stmtResult.getDate(PayordemDbTableColumn.COL_DATE);
				if (date != null)
					dataInfo.date = date.toLocalDate();
				
				Time beginTime = stmtResult.getTime(PayordemDbTableColumn.COL_BEGIN_TIME);
				if (beginTime != null)
					dataInfo.beginTime = beginTime.toLocalTime();
				
				stmtResult.getDouble(PayordemDbTableColumn.COL_PRICE);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.price = stmtResult.getDouble(PayordemDbTableColumn.COL_PRICE);
				
				stmtResult.getDouble(PayordemDbTableColumn.COL_TOTAL_ITEM);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.totitem = stmtResult.getDouble(PayordemDbTableColumn.COL_TOTAL_ITEM);
				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
