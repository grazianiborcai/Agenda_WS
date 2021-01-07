package br.com.mind5.config.sysDistrictSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.sysDistrictSearch.info.SysdistrInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoSysdistrSelectSingle extends DaoStmtTemplate<SysdistrInfo> {
	private final String MAIN_TABLE = DaoDbTable.OWNER_CONFIG_TABLE;
	
	
	public DaoSysdistrSelectSingle(Connection conn, SysdistrInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.SYS_DISTRICT_SEARCH_DEFAULT_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SysdistrInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		
		DaoStmtWhere whereClause = new DaoSysdistrWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<SysdistrInfo> getResultParserHook() {
		return new DaoResultParser<SysdistrInfo>() {
			@Override public List<SysdistrInfo> parseResult(SysdistrInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SysdistrInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					SysdistrInfo dataInfo = new SysdistrInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoSysdistrDbTableColumn.COL_COD_OWNER);
					dataInfo.districtSearchDefault = stmtResult.getString(DaoSysdistrDbTableColumn.COL_DISTRICT_SEARCH_DEFAULT);	
					
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
