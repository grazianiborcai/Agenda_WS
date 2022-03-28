package br.com.mind5.business.employeeList.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class EmplisDaoSelectSingle extends DaoStmtTemplate<EmplisInfo> {
	private final String MAIN_TABLE = DaoDbTable.EMP_TABLE;
	
	
	public EmplisDaoSelectSingle(Connection conn, EmplisInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.EMP_LIST_VIEW;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EmplisInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new EmplisDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	
	
	
	@Override protected DaoResultParser<EmplisInfo> getResultParserHook() {
		return new DaoResultParser<EmplisInfo>() {
			@Override public List<EmplisInfo> parseResult(EmplisInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<EmplisInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					EmplisInfo dataInfo = new EmplisInfo();
					
					dataInfo.codOwner = stmtResult.getLong(EmplisDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codEmployee = stmtResult.getLong(EmplisDaoDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codStore = stmtResult.getLong(EmplisDaoDbTableColumn.COL_COD_STORE);
					dataInfo.recordMode = stmtResult.getString(EmplisDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.codPerson = DaoFormatter.sqlToLong(stmtResult, EmplisDaoDbTableColumn.COL_COD_PERSON);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, EmplisDaoDbTableColumn.COL_COD_SNAPSHOT);				
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
