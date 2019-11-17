package br.com.mind5.business.employeeLeaveDate.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class EmplevateSelectSingle extends DaoStmtTemplate<EmplevateInfo> {	
	private final String LT_MAIN = DaoDbTable.EMP_LD_TABLE;	
	
	
	
	public EmplevateSelectSingle(Connection conn, EmplevateInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return LT_MAIN;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EmplevateInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new EmplevateWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<EmplevateInfo> getResultParserHook() {
		return new DaoResultParser<EmplevateInfo>() {
			@Override public List<EmplevateInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
				List<EmplevateInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					EmplevateInfo dataInfo = new EmplevateInfo();
					dataInfo.codOwner = stmtResult.getLong(EmplevateDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(EmplevateDbTableColumn.COL_COD_STORE);
					dataInfo.codEmployee = stmtResult.getLong(EmplevateDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.recordMode = stmtResult.getString(EmplevateDbTableColumn.COL_RECORD_MODE);	
					dataInfo.description = stmtResult.getString(EmplevateDbTableColumn.COL_DESCRIPTION);	
					dataInfo.timeValidFrom = DaoFormatter.sqlToLocalTime(stmtResult, EmplevateDbTableColumn.COL_TM_VALID_FROM);
					dataInfo.timeValidTo = DaoFormatter.sqlToLocalTime(stmtResult, EmplevateDbTableColumn.COL_TM_VALID_TO);
					dataInfo.dateValidFrom = DaoFormatter.sqlToLocalDate(stmtResult, EmplevateDbTableColumn.COL_DT_VALID_FROM);
					dataInfo.dateValidTo = DaoFormatter.sqlToLocalDate(stmtResult, EmplevateDbTableColumn.COL_DT_VALID_TO);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, EmplevateDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, EmplevateDbTableColumn.COL_LAST_CHANGED_BY);
					
					finalResult.add(dataInfo);		
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		super.executeStmt();
	}
}
