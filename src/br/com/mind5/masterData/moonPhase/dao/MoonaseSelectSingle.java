package br.com.mind5.masterData.moonPhase.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class MoonaseSelectSingle extends DaoStmtTemplate<MoonaseInfo> {
	private final String MAIN_TABLE = DaoDbTable.MOON_PHASE_TABLE;
	
	
	public MoonaseSelectSingle(Connection conn, MoonaseInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MoonaseInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		
		DaoStmtWhere whereClause = new MoonaseWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(MoonaseInfo recordInfo) {
		DaoJoinBuilder joinText = new MoonaseJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<MoonaseInfo> getResultParserHook() {
		return new DaoResultParser<MoonaseInfo>() {
			@Override public List<MoonaseInfo> parseResult(MoonaseInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MoonaseInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					MoonaseInfo dataInfo = new MoonaseInfo();
					
					dataInfo.codMoonPhase = stmtResult.getInt(MoonaseDbTableColumn.COL_COD_MOON_PHASE);
					dataInfo.txtMoonPhase = stmtResult.getString(MoonaseDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(MoonaseDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	} 
}
