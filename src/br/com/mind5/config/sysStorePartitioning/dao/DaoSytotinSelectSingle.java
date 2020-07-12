package br.com.mind5.config.sysStorePartitioning.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.sysStorePartitioning.info.SytotinInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoSytotinSelectSingle extends DaoStmtTemplate<SytotinInfo> {
	private final String MAIN_TABLE = DaoDbTable.OWNER_CONFIG_TABLE;
	
	
	public DaoSytotinSelectSingle(Connection conn, SytotinInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.SYS_STORE_PARTITIONING_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SytotinInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;	
		
		DaoStmtWhere whereClause = new DaoSytotinWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<SytotinInfo> getResultParserHook() {
		return new DaoResultParser<SytotinInfo>() {
			@Override public List<SytotinInfo> parseResult(SytotinInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SytotinInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					SytotinInfo dataInfo = new SytotinInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoSytotinDbTableColumn.COL_COD_OWNER);
					dataInfo.storePartitioning = stmtResult.getString(DaoSytotinDbTableColumn.COL_STORE_PARTITIONING);	
					
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
