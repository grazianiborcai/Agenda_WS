package br.com.mind5.business.scheduleLineSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoSchedinapSelectSingle extends DaoStmtTemplate<SchedinapInfo> {	
	private final String MAIN_TABLE = DaoDbTable.SCHEDULE_SNAPSHOT_TABLE;
	
	
	public DaoSchedinapSelectSingle(Connection conn, SchedinapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SchedinapInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoSchedinapWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<SchedinapInfo> getResultParserHook() {
		return new DaoResultParser<SchedinapInfo>() {
			@Override public List<SchedinapInfo> parseResult(SchedinapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {				
				List<SchedinapInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					SchedinapInfo dataInfo = new SchedinapInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoSchedinapDbTableColumn.COL_COD_OWNER);	
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoSchedinapDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codSchedule = DaoFormatter.sqlToLong(stmtResult, DaoSchedinapDbTableColumn.COL_COD_SCHEDULE);
					dataInfo.codScheduleRef = DaoFormatter.sqlToLong(stmtResult, DaoSchedinapDbTableColumn.COL_COD_SCHEDULE_REF);
					dataInfo.codOrder = DaoFormatter.sqlToLong(stmtResult, DaoSchedinapDbTableColumn.COL_COD_ORDER);
					dataInfo.codOrderItem = DaoFormatter.sqlToInt(stmtResult, DaoSchedinapDbTableColumn.COL_COD_ORDER_ITEM);				
					dataInfo.recordMode = stmtResult.getString(DaoSchedinapDbTableColumn.COL_RECORD_MODE);		
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, DaoSchedinapDbTableColumn.COL_COD_STORE);
					dataInfo.codStoreSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoSchedinapDbTableColumn.COL_COD_STORE_SNAPSHOT);
					dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, DaoSchedinapDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codEmployeeSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoSchedinapDbTableColumn.COL_COD_EMPLOYEE_SNAPSHOT);
					dataInfo.codMat = DaoFormatter.sqlToLong(stmtResult, DaoSchedinapDbTableColumn.COL_COD_MATERIAL);
					dataInfo.codMatSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoSchedinapDbTableColumn.COL_COD_MATERIAL_SNAPSHOT);
					dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, DaoSchedinapDbTableColumn.COL_DATE);
					dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, DaoSchedinapDbTableColumn.COL_BEGIN_TIME);
					dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, DaoSchedinapDbTableColumn.COL_END_TIME);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoSchedinapDbTableColumn.COL_LAST_CHANGED);
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoSchedinapDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, DaoSchedinapDbTableColumn.COL_CREATED_BY);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, DaoSchedinapDbTableColumn.COL_COD_USER);
					dataInfo.codUserSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoSchedinapDbTableColumn.COL_COD_USER_SNAPSHOT);
					dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, DaoSchedinapDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.codCustomerSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoSchedinapDbTableColumn.COL_COD_CUSTOMER_SNAPSHOT);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, DaoSchedinapDbTableColumn.COL_LAST_CHANGED_BY);				
					dataInfo.day = DaoFormatter.sqlToInt(stmtResult, DaoSchedinapDbTableColumn.COL_DAY);
					dataInfo.weekMonth = DaoFormatter.sqlToInt(stmtResult, DaoSchedinapDbTableColumn.COL_WEEK_MONTH);
					dataInfo.weekYear = DaoFormatter.sqlToInt(stmtResult, DaoSchedinapDbTableColumn.COL_WEEK_YEAR);
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, DaoSchedinapDbTableColumn.COL_MONTH);
					dataInfo.quarter = DaoFormatter.sqlToInt(stmtResult, DaoSchedinapDbTableColumn.COL_QUARTER);
					dataInfo.year = DaoFormatter.sqlToInt(stmtResult, DaoSchedinapDbTableColumn.COL_YEAR);		
					dataInfo.codWeekday = DaoFormatter.sqlToInt(stmtResult, DaoSchedinapDbTableColumn.COL_COD_WEEKDAY);
					dataInfo.codScheduleStatus = stmtResult.getString(DaoSchedinapDbTableColumn.COL_COD_SCHEDULE_STATUS);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
