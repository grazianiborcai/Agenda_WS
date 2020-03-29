package br.com.mind5.masterData.moonPhaseSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.moonPhaseSearch.info.MoonasarchInfo;
import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class MoonasarchSelectSingle extends DaoStmtTemplate<MoonasarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.MOON_PHASE_TABLE;
	
	
	public MoonasarchSelectSingle(Connection conn, MoonasarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.MOON_PHASE_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MoonasarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new MoonasarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(MoonasarchInfo recordInfo) {
		DaoJoinBuilder joinText = new MoonasarchJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<MoonasarchInfo> getResultParserHook() {
		return new DaoResultParser<MoonasarchInfo>() {
			@Override public List<MoonasarchInfo> parseResult(MoonasarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MoonasarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					MoonasarchInfo dataInfo = new MoonasarchInfo();
					
					dataInfo.codMoonPhase = stmtResult.getInt(MoonasarchDbTableColumn.COL_COD_MOON_PHASE);
					dataInfo.txtMoonPhase = stmtResult.getString(MoonasarchDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(MoonasarchDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	} 
}
