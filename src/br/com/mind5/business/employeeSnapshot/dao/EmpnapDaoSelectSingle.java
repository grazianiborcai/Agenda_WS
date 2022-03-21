package br.com.mind5.business.employeeSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class EmpnapDaoSelectSingle extends DaoStmtTemplate<EmpnapInfo> {
	private final String MAIN_TABLE = DaoDbTable.EMP_SNAPSHOT_TABLE;	
	
	
	public EmpnapDaoSelectSingle(Connection conn, EmpnapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EmpnapInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new EmpnapDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<EmpnapInfo> getResultParserHook() {
		return new DaoResultParser<EmpnapInfo>() {
			@Override public List<EmpnapInfo> parseResult(EmpnapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<EmpnapInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					EmpnapInfo dataInfo = new EmpnapInfo();
					
					dataInfo.codOwner = stmtResult.getLong(EmpnapDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codSnapshot = stmtResult.getLong(EmpnapDaoDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codEmployee = stmtResult.getLong(EmpnapDaoDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, EmpnapDaoDbTableColumn.COL_COD_STORE);
					dataInfo.recordMode = stmtResult.getString(EmpnapDaoDbTableColumn.COL_RECORD_MODE);	
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, EmpnapDaoDbTableColumn.COL_COD_USER);
					dataInfo.codUserSnapshot = DaoFormatter.sqlToLong(stmtResult, EmpnapDaoDbTableColumn.COL_COD_USER_SNAPSHOT);
					dataInfo.codPerson = DaoFormatter.sqlToLong(stmtResult, EmpnapDaoDbTableColumn.COL_COD_PERSON);
					dataInfo.codPersonSnapshot = DaoFormatter.sqlToLong(stmtResult, EmpnapDaoDbTableColumn.COL_COD_PERSON_SNAPSHOT);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, EmpnapDaoDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, EmpnapDaoDbTableColumn.COL_LAST_CHANGED_BY);		
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, EmpnapDaoDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, EmpnapDaoDbTableColumn.COL_CREATED_BY);
					dataInfo.isLocked = stmtResult.getBoolean(EmpnapDaoDbTableColumn.COL_IS_LOCKED);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
