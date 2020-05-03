package br.com.mind5.masterData.feeCategorySearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.masterData.feeCategorySearch.info.FeecatarchInfo;

public final class DaoFeecatarchSelectSingle extends DaoStmtTemplate<FeecatarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.FEE_CATEG_TABLE;
	
	
	public DaoFeecatarchSelectSingle(Connection conn, FeecatarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.FEE_CATEG_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, FeecatarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new DaoFeecatarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(FeecatarchInfo recordInfo) {
		DaoJoinBuilder joinText = new DaoFeecatarchJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<FeecatarchInfo> getResultParserHook() {
		return new DaoResultParser<FeecatarchInfo>() {
			@Override public List<FeecatarchInfo> parseResult(FeecatarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<FeecatarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					FeecatarchInfo dataInfo = new FeecatarchInfo();
					
					dataInfo.codFeeCateg = DaoFormatter.sqlToChar(stmtResult, DaoFeecatarchDbTableColumn.COL_COD_FEE_CATEG);
					dataInfo.txtFeeCateg = stmtResult.getString(DaoFeecatarchDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(DaoFeecatarchDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	} 
}
