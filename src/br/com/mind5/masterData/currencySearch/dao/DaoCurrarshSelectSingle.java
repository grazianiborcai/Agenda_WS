package br.com.mind5.masterData.currencySearch.dao;

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
import br.com.mind5.masterData.currencySearch.info.CurrarshInfo;

public final class DaoCurrarshSelectSingle extends DaoStmtTemplate<CurrarshInfo> {
	private final String MAIN_TABLE = DaoDbTable.CURRENCY_TABLE;
	
	
	public DaoCurrarshSelectSingle(Connection conn, CurrarshInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.CURRENCY_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CurrarshInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new DaoCurrarshWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(CurrarshInfo recordInfo) {
		DaoJoinBuilder joinText = new DaoCurrarshJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<CurrarshInfo> getResultParserHook() {
		return new DaoResultParser<CurrarshInfo>() {
			@Override public List<CurrarshInfo> parseResult(CurrarshInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CurrarshInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					CurrarshInfo dataInfo = new CurrarshInfo();
					
					dataInfo.codCurr = stmtResult.getString(DaoCurrarshDbTableColumn.COL_COD_CURRENCY);
					dataInfo.symbolCurr = stmtResult.getString(DaoCurrarshDbTableColumn.COL_CURRENCY_SYMBOL);
					dataInfo.txtCurr = stmtResult.getString(DaoCurrarshDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(DaoCurrarshDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
