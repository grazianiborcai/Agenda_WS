package br.com.mind5.business.employeeLunchTimeConflict.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLunchTimeConflict.info.EmpulranInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;


public final class EmpulranDaoSelectSingle extends DaoStmtTemplate<EmpulranInfo> {
	private final String MAIN_TABLE = DaoDbTable.EMP_LT_TABLE;
	
	
	
	public EmpulranDaoSelectSingle(Connection conn, EmpulranInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	protected String getLookupTableHook() {
		return DaoDbTable.EMP_LT_RANGE_VIEW;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EmpulranInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;	
		
		DaoStmtWhere whereClause = new EmpulranDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<EmpulranInfo> getResultParserHook() {
		return new DaoResultParser<EmpulranInfo>() {
			@Override public List<EmpulranInfo> parseResult(EmpulranInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<EmpulranInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					EmpulranInfo dataInfo = new EmpulranInfo();
					
					dataInfo.codOwner = stmtResult.getLong(EmpulranDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(EmpulranDaoDbTableColumn.COL_COD_STORE);
					dataInfo.codEmployee = stmtResult.getLong(EmpulranDaoDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codWeekday = stmtResult.getInt(EmpulranDaoDbTableColumn.COL_COD_WEEKDAY);
					dataInfo.recordMode = stmtResult.getString(EmpulranDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, EmpulranDaoDbTableColumn.COL_BEGIN_TIME);
					dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, EmpulranDaoDbTableColumn.COL_END_TIME);
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
