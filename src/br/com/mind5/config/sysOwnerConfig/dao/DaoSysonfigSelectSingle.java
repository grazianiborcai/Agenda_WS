package br.com.mind5.config.sysOwnerConfig.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.sysOwnerConfig.info.SysonfigInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoSysonfigSelectSingle extends DaoStmtTemplate<SysonfigInfo> {
	private final String MAIN_TABLE = DaoDbTable.OWNER_CONFIG_TABLE;
	
	
	public DaoSysonfigSelectSingle(Connection conn, SysonfigInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SysonfigInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;	
		
		DaoStmtWhere whereClause = new DaoSysonfigWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<SysonfigInfo> getResultParserHook() {
		return new DaoResultParser<SysonfigInfo>() {
			@Override public List<SysonfigInfo> parseResult(SysonfigInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SysonfigInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					SysonfigInfo dataInfo = new SysonfigInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoSysonfigDbTableColumn.COL_COD_OWNER);
					dataInfo.storePartitioning = stmtResult.getString(DaoSysonfigDbTableColumn.COL_STORE_PARTITIONING);	
					dataInfo.storeBusinessContent = stmtResult.getString(DaoSysonfigDbTableColumn.COL_STORE_BUSINESS_CONTENT);	
					dataInfo.storeSignup = stmtResult.getString(DaoSysonfigDbTableColumn.COL_STORE_SIGNUP);	
					
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
