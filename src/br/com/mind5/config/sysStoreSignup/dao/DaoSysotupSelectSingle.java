package br.com.mind5.config.sysStoreSignup.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.sysStoreSignup.info.SysotupInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoSysotupSelectSingle extends DaoStmtTemplate<SysotupInfo> {
	private final String MAIN_TABLE = DaoDbTable.OWNER_CONFIG_TABLE;
	
	
	public DaoSysotupSelectSingle(Connection conn, SysotupInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.SYS_STORE_SIGNUP_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SysotupInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoSysotupWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<SysotupInfo> getResultParserHook() {
		return new DaoResultParser<SysotupInfo>() {
			@Override public List<SysotupInfo> parseResult(SysotupInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SysotupInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					SysotupInfo dataInfo = new SysotupInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoSysotupDbTableColumn.COL_COD_OWNER);
					dataInfo.storeSignup = stmtResult.getString(DaoSysotupDbTableColumn.COL_STORE_SIGNUP);	
					
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
