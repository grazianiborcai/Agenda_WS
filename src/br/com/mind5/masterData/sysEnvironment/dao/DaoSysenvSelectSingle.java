package br.com.mind5.masterData.sysEnvironment.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;

public final class DaoSysenvSelectSingle extends DaoStmtTemplate<SysenvInfo> {
	private final String MAIN_TABLE = DaoDbTable.SYS_ENVIRONMENT_TABLE;
	
	
	public DaoSysenvSelectSingle(Connection conn, SysenvInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SysenvInfo recordInfo) {	
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new DaoSysenvWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<SysenvInfo> getResultParserHook() {
		return new DaoResultParser<SysenvInfo>() {
			@Override public List<SysenvInfo> parseResult(SysenvInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SysenvInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					SysenvInfo dataInfo = new SysenvInfo();
					dataInfo.codSysEnviron = stmtResult.getString(DaoSysenvDbTableColumn.COL_COD_SYS_ENVIRONMENT);
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
