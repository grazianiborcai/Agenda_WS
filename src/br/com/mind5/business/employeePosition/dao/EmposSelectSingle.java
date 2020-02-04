package br.com.mind5.business.employeePosition.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class EmposSelectSingle extends DaoStmtTemplate<EmposInfo> {	
	private final String MAIN_TABLE = DaoDbTable.EMPOS_TABLE;	
	
	
	
	public EmposSelectSingle(Connection conn, EmposInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EmposInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new EmposWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<EmposInfo> getResultParserHook() {
		return new DaoResultParser<EmposInfo>() {
			@Override public List<EmposInfo> parseResult(EmposInfo redcordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<EmposInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					EmposInfo dataInfo = new EmposInfo();
					
					dataInfo.codOwner = stmtResult.getLong(EmposDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(EmposDbTableColumn.COL_COD_STORE);
					dataInfo.codEmployee = stmtResult.getLong(EmposDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codPosition = stmtResult.getInt(EmposDbTableColumn.COL_COD_POSITION);
					dataInfo.recordMode = stmtResult.getString(EmposDbTableColumn.COL_RECORD_MODE);	
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, EmposDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, EmposDbTableColumn.COL_LAST_CHANGED_BY);				
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, EmposDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, EmposDbTableColumn.COL_CREATED_BY);
					
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
