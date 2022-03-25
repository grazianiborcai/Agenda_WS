package br.com.mind5.business.employeeWorkTimeConflict.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;


public final class EmpwocoDaoSelectSingle extends DaoStmtTemplate<EmpwocoInfo> {
	private final String MAIN_TABLE = DaoDbTable.EMP_WT_TABLE;
	
	
	
	public EmpwocoDaoSelectSingle(Connection conn, EmpwocoInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	protected String getLookupTableHook() {
		return DaoDbTable.EMP_WT_CONFLICT_VIEW;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EmpwocoInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;	
		
		DaoStmtWhere whereClause = new EmpwocoDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<EmpwocoInfo> getResultParserHook() {
		return new DaoResultParser<EmpwocoInfo>() {
			@Override public List<EmpwocoInfo> parseResult(EmpwocoInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<EmpwocoInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					EmpwocoInfo dataInfo = new EmpwocoInfo();
					
					dataInfo.codOwner = stmtResult.getLong(EmpwocoDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(EmpwocoDaoDbTableColumn.COL_COD_STORE);
					dataInfo.codEmployee = stmtResult.getLong(EmpwocoDaoDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codWeekday = stmtResult.getInt(EmpwocoDaoDbTableColumn.COL_COD_WEEKDAY);
					dataInfo.recordMode = stmtResult.getString(EmpwocoDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, EmpwocoDaoDbTableColumn.COL_BEGIN_TIME);
					dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, EmpwocoDaoDbTableColumn.COL_END_TIME);
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
