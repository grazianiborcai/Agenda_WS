package br.com.mind5.masterData.dayPartingSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.masterData.dayPartingSearch.info.DayparchInfo;

public final class DaoDayparchSelectSingle extends DaoStmtTemplate<DayparchInfo> {
	private final String MAIN_TABLE = DaoDbTable.DAYPART_TABLE;
	
	
	public DaoDayparchSelectSingle(Connection conn, DayparchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.DAYPART_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, DayparchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new DaoDayparchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(DayparchInfo recordInfo) {
		DaoJoinBuilder joinText = new DaoDayparchJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<DayparchInfo> getResultParserHook() {
		return new DaoResultParser<DayparchInfo>() {
			@Override public List<DayparchInfo> parseResult(DayparchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<DayparchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					DayparchInfo dataInfo = new DayparchInfo();
					
					dataInfo.codDaypart = stmtResult.getInt(DaoDayparchDbTableColumn.COL_COD_DAYPART);
					dataInfo.txtDaypart = stmtResult.getString(DaoDayparchDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(DaoDayparchDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	} 
}
