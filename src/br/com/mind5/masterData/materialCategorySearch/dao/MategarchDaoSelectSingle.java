package br.com.mind5.masterData.materialCategorySearch.dao;

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
import br.com.mind5.masterData.materialCategorySearch.info.MategarchInfo;

public final class MategarchDaoSelectSingle extends DaoStmtTemplate<MategarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_CATEG_TABLE;
	
	
	public MategarchDaoSelectSingle(Connection conn, MategarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.MAT_CATEG_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MategarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new MategarchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(MategarchInfo recordInfo) {
		DaoJoinBuilder joinText = new MategarchDaoJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<MategarchInfo> getResultParserHook() {
		return new DaoResultParser<MategarchInfo>() {
			@Override public List<MategarchInfo> parseResult(MategarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MategarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					MategarchInfo dataInfo = new MategarchInfo();
					
					dataInfo.codMatCateg = stmtResult.getInt(MategarchDaoDbTableColumn.COL_COD_MAT_CATEG);
					dataInfo.txtMatCateg = stmtResult.getString(MategarchDaoDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(MategarchDaoDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
