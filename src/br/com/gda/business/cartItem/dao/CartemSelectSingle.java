package br.com.gda.business.cartItem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cartItem.info.CartemInfo;
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

public final class CartemSelectSingle implements DaoStmt<CartemInfo> {	
	private final String LT_ITM = DaoDbTable.CART_ITM_TABLE;
	
	private DaoStmt<CartemInfo> stmtSql;
	private DaoStmtOption<CartemInfo> stmtOption;
	
	
	
	public CartemSelectSingle(Connection conn, CartemInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, CartemInfo recordInfo, String schemaName) {
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
		
		DaoStmtWhere whereClause = new CartemWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<CartemInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<CartemInfo> getNewInstance() {
		return new CartemSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<CartemInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<CartemInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			
			List<CartemInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				CartemInfo dataInfo = new CartemInfo();
				dataInfo.codOwner = stmtResult.getLong(CartemDbTableColumn.COL_COD_OWNER);	
				dataInfo.codUser = stmtResult.getLong(CartemDbTableColumn.COL_COD_USER);
				dataInfo.quantity = stmtResult.getInt(CartemDbTableColumn.COL_QUANTITY);
				dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, CartemDbTableColumn.COL_COD_STORE);
				dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, CartemDbTableColumn.COL_COD_EMPLOYEE);
				dataInfo.codMat = DaoFormatter.sqlToLong(stmtResult, CartemDbTableColumn.COL_COD_MATERIAL);
				dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, CartemDbTableColumn.COL_DATE);
				dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, CartemDbTableColumn.COL_BEGIN_TIME);
				dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, CartemDbTableColumn.COL_END_TIME);
				dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, CartemDbTableColumn.COL_CREATED_ON);				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
