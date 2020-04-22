package br.com.mind5.business.employeeLeaveDate.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoEmplateSelectSingle extends DaoStmtTemplate<EmplateInfo> {	
	private final String MAIN_TABLE = DaoDbTable.EMP_LD_TABLE;	
	
	
	
	public DaoEmplateSelectSingle(Connection conn, EmplateInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EmplateInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoEmplateWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<EmplateInfo> getResultParserHook() {
		return new DaoResultParser<EmplateInfo>() {
			@Override public List<EmplateInfo> parseResult(EmplateInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<EmplateInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					EmplateInfo dataInfo = new EmplateInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoEmplateDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(DaoEmplateDbTableColumn.COL_COD_STORE);
					dataInfo.codEmployee = stmtResult.getLong(DaoEmplateDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.recordMode = stmtResult.getString(DaoEmplateDbTableColumn.COL_RECORD_MODE);	
					dataInfo.description = stmtResult.getString(DaoEmplateDbTableColumn.COL_DESCRIPTION);	
					dataInfo.timeValidFrom = DaoFormatter.sqlToLocalTime(stmtResult, DaoEmplateDbTableColumn.COL_TM_VALID_FROM);
					dataInfo.timeValidTo = DaoFormatter.sqlToLocalTime(stmtResult, DaoEmplateDbTableColumn.COL_TM_VALID_TO);
					dataInfo.dateValidFrom = DaoFormatter.sqlToLocalDate(stmtResult, DaoEmplateDbTableColumn.COL_DT_VALID_FROM);
					dataInfo.dateValidTo = DaoFormatter.sqlToLocalDate(stmtResult, DaoEmplateDbTableColumn.COL_DT_VALID_TO);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoEmplateDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, DaoEmplateDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoEmplateDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, DaoEmplateDbTableColumn.COL_CREATED_BY);					
					dataInfo.validFrom = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoEmplateDbTableColumn.COL_DATE_TIME_VALID_FROM);
					dataInfo.validTo = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoEmplateDbTableColumn.COL_DATE_TIME_VALID_TO);
					
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
