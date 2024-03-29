package br.com.mind5.business.employeeLeaveDate.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class EmplateDaoDeleteSingle extends DaoStmtTemplate<EmplateInfo> {
	private final String MAIN_TABLE = DaoDbTable.EMP_LD_TABLE;	
	
	
	public EmplateDaoDeleteSingle(Connection conn, EmplateInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SOFT_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EmplateInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;	
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;
		
		DaoStmtWhere whereClause = new EmplateDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<EmplateInfo> getResultParserHook() {
		return new DaoResultParser<EmplateInfo>() {
			@Override public List<EmplateInfo> parseResult(EmplateInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<EmplateInfo> finalResult = new ArrayList<>();
				EmplateInfo emptyInfo = new EmplateInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
