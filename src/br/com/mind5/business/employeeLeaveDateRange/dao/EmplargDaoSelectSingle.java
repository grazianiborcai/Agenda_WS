package br.com.mind5.business.employeeLeaveDateRange.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLeaveDateRange.info.EmplargInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class EmplargDaoSelectSingle extends DaoStmtTemplate<EmplargInfo> {	
	private final String MAIN_TABLE = DaoDbTable.EMP_LD_TABLE;	
	
	
	
	public EmplargDaoSelectSingle(Connection conn, EmplargInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.EMP_LD_RANGE_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EmplargInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new EmplargDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<EmplargInfo> getResultParserHook() {
		return new DaoResultParser<EmplargInfo>() {
			@Override public List<EmplargInfo> parseResult(EmplargInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<EmplargInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					EmplargInfo dataInfo = new EmplargInfo();
					
					dataInfo.codOwner = stmtResult.getLong(EmplargDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(EmplargDaoDbTableColumn.COL_COD_STORE);
					dataInfo.codEmployee = stmtResult.getLong(EmplargDaoDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.recordMode = stmtResult.getString(EmplargDaoDbTableColumn.COL_RECORD_MODE);	
					dataInfo.timeValidFrom = DaoFormatter.sqlToLocalTime(stmtResult, EmplargDaoDbTableColumn.COL_TM_VALID_FROM);
					dataInfo.timeValidTo = DaoFormatter.sqlToLocalTime(stmtResult, EmplargDaoDbTableColumn.COL_TM_VALID_TO);
					dataInfo.dateValidFrom = DaoFormatter.sqlToLocalDate(stmtResult, EmplargDaoDbTableColumn.COL_DT_VALID_FROM);
					dataInfo.dateValidTo = DaoFormatter.sqlToLocalDate(stmtResult, EmplargDaoDbTableColumn.COL_DT_VALID_TO);
					dataInfo.validFrom = DaoFormatter.sqlToLocalDateTime(stmtResult, EmplargDaoDbTableColumn.COL_DATE_TIME_VALID_FROM);
					dataInfo.validTo = DaoFormatter.sqlToLocalDateTime(stmtResult, EmplargDaoDbTableColumn.COL_DATE_TIME_VALID_TO);
					
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
