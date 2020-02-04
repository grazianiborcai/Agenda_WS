package br.com.mind5.business.employeeWorkTimeRange.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeRange.info.EmpworgInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class EmpworgSelectSingle extends DaoStmtTemplate<EmpworgInfo> {
	private final String MAIN_TABLE = DaoDbTable.EMP_WT_TABLE;
	
	
	public EmpworgSelectSingle(Connection conn, EmpworgInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}	
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.EMP_WTIME_RANGE_VIEW;
	}	
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EmpworgInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new EmpworgWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<EmpworgInfo> getResultParserHook() {
		return new DaoResultParser<EmpworgInfo>() {
			@Override public List<EmpworgInfo> parseResult(EmpworgInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<EmpworgInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					EmpworgInfo dataInfo = new EmpworgInfo();
					
					dataInfo.codOwner = stmtResult.getLong(EmpworgDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(EmpworgDbTableColumn.COL_COD_STORE);
					dataInfo.codEmployee = stmtResult.getLong(EmpworgDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codWeekday = stmtResult.getInt(EmpworgDbTableColumn.COL_COD_WEEKDAY);
					dataInfo.recordMode = stmtResult.getString(EmpworgDbTableColumn.COL_RECORD_MODE);	
					dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, EmpworgDbTableColumn.COL_BEGIN_TIME);
					dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, EmpworgDbTableColumn.COL_END_TIME);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
