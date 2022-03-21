package br.com.mind5.business.employee.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class EmpDaoSelectSingle extends DaoStmtTemplate<EmpInfo> {
	private final String MAIN_TABLE = DaoDbTable.EMP_TABLE;		
	
	
	public EmpDaoSelectSingle(Connection conn, EmpInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EmpInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new EmpDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<EmpInfo> getResultParserHook() {
		return new DaoResultParser<EmpInfo>() {
			@Override public List<EmpInfo> parseResult(EmpInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<EmpInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					EmpInfo dataInfo = new EmpInfo();
					
					dataInfo.codOwner = stmtResult.getLong(EmpDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codEmployee = stmtResult.getLong(EmpDaoDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codStore = stmtResult.getLong(EmpDaoDbTableColumn.COL_COD_STORE);
					dataInfo.recordMode = stmtResult.getString(EmpDaoDbTableColumn.COL_RECORD_MODE);	
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, EmpDaoDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, EmpDaoDbTableColumn.COL_COD_USER);
					dataInfo.codPerson = DaoFormatter.sqlToLong(stmtResult, EmpDaoDbTableColumn.COL_COD_PERSON);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, EmpDaoDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, EmpDaoDbTableColumn.COL_LAST_CHANGED_BY);	
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, EmpDaoDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, EmpDaoDbTableColumn.COL_CREATED_BY);
					dataInfo.isLocked = stmtResult.getBoolean(EmpDaoDbTableColumn.COL_IS_LOCKED);
					
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
