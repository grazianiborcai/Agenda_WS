package br.com.mind5.config.sysOwnerSignup.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.sysOwnerSignup.info.SysonupInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoSysonupSelectSingle extends DaoStmtTemplate<SysonupInfo> {
	private final String MAIN_TABLE = DaoDbTable.SYS_CONFIG_TABLE;
	
	
	public DaoSysonupSelectSingle(Connection conn, SysonupInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.SYS_OWNER_SIGNUP_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SysonupInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;	
		
		DaoStmtWhere whereClause = new DaoSysonupWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<SysonupInfo> getResultParserHook() {
		return new DaoResultParser<SysonupInfo>() {
			@Override public List<SysonupInfo> parseResult(SysonupInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SysonupInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					SysonupInfo dataInfo = new SysonupInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoSysonupDbTableColumn.COL_COD_OWNER);
					dataInfo.ownerSignup = stmtResult.getString(DaoSysonupDbTableColumn.COL_OWNER_SIGNUP);	
					
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
