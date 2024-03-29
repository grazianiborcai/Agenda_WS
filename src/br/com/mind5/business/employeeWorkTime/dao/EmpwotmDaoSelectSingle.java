package br.com.mind5.business.employeeWorkTime.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class EmpwotmDaoSelectSingle extends DaoStmtTemplate<EmpwotmInfo> {
	private final String MAIN_TABLE = DaoDbTable.EMP_WT_TABLE;	
	
	
	public EmpwotmDaoSelectSingle(Connection conn, EmpwotmInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EmpwotmInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new EmpwotmDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<EmpwotmInfo> getResultParserHook() {
		return new DaoResultParser<EmpwotmInfo>() {
			@Override public List<EmpwotmInfo> parseResult(EmpwotmInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<EmpwotmInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					EmpwotmInfo dataInfo = new EmpwotmInfo();
					
					dataInfo.codOwner = stmtResult.getLong(EmpwotmDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(EmpwotmDaoDbTableColumn.COL_COD_STORE);
					dataInfo.codEmployee = stmtResult.getLong(EmpwotmDaoDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codWeekday = stmtResult.getInt(EmpwotmDaoDbTableColumn.COL_COD_WEEKDAY);
					dataInfo.recordMode = stmtResult.getString(EmpwotmDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, EmpwotmDaoDbTableColumn.COL_BEGIN_TIME);
					dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, EmpwotmDaoDbTableColumn.COL_END_TIME);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, EmpwotmDaoDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, EmpwotmDaoDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, EmpwotmDaoDbTableColumn.COL_COD_SNAPSHOT);
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
