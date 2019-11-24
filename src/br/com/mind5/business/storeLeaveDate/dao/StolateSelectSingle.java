package br.com.mind5.business.storeLeaveDate.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
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

public final class StolateSelectSingle implements DaoStmt<StolateInfo> {	
	private final String LT_STORE_LEAVE_DATE = DaoDbTable.STORE_LD_TABLE;
	
	private DaoStmt<StolateInfo> stmtSql;
	private DaoStmtOption_<StolateInfo> stmtOption;
	
	
	
	public StolateSelectSingle(Connection conn, StolateInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, StolateInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption_<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_STORE_LEAVE_DATE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_STORE_LEAVE_DATE);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new StolateWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<StolateInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<StolateInfo> getNewInstance() {
		return new StolateSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser_<StolateInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<StolateInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<StolateInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				StolateInfo dataInfo = new StolateInfo();
				dataInfo.codOwner = stmtResult.getLong(StolateDbTableColumn.COL_COD_OWNER);
				dataInfo.codStore = stmtResult.getLong(StolateDbTableColumn.COL_COD_STORE);
				dataInfo.description = stmtResult.getString(StolateDbTableColumn.COL_DESCRIPTION);	
				dataInfo.recordMode = stmtResult.getString(StolateDbTableColumn.COL_RECORD_MODE);		
				dataInfo.timeValidFrom = DaoFormatter.sqlToLocalTime(stmtResult, StolateDbTableColumn.COL_TM_VALID_FROM);
				dataInfo.timeValidTo = DaoFormatter.sqlToLocalTime(stmtResult, StolateDbTableColumn.COL_TM_VALID_TO);
				dataInfo.dateValidFrom = DaoFormatter.sqlToLocalDate(stmtResult, StolateDbTableColumn.COL_DT_VALID_FROM);
				dataInfo.dateValidTo = DaoFormatter.sqlToLocalDate(stmtResult, StolateDbTableColumn.COL_DT_VALID_TO);					
				dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, StolateDbTableColumn.COL_LAST_CHANGED);	
				dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, StolateDbTableColumn.COL_LAST_CHANGED_BY);			
				dataInfo.monthValidFrom = DaoFormatter.sqlToInt(stmtResult, StolateDbTableColumn.COL_MONTH_VALID_FROM);		
				dataInfo.yearValidFrom = DaoFormatter.sqlToInt(stmtResult, StolateDbTableColumn.COL_YEAR_VALID_FROM);	
				dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, StolateDbTableColumn.COL_CREATED_ON);	
				dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, StolateDbTableColumn.COL_CREATED_BY);	
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
