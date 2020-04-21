package br.com.mind5.masterData.businessAreaSearch.dao;

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
import br.com.mind5.masterData.businessAreaSearch.info.BusarearchInfo;

public final class DaoBusarearchSelectSingle extends DaoStmtTemplate<BusarearchInfo> {
	private final String MAIN_TABLE = DaoDbTable.BUSINESS_AREA_TABLE;
	
	
	public DaoBusarearchSelectSingle(Connection conn, BusarearchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.BUSINESS_AREA_SEARCH_VIEW;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, BusarearchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new DaoBusarearchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(BusarearchInfo recordInfo) {
		DaoJoinBuilder joinText = new DaoBusarearchJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<BusarearchInfo> getResultParserHook() {
		return new DaoResultParser<BusarearchInfo>() {
			@Override public List<BusarearchInfo> parseResult(BusarearchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<BusarearchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					BusarearchInfo dataInfo = new BusarearchInfo();
					
					dataInfo.codBusiness = stmtResult.getInt(DaoBusarearchDbTableColumn.COL_COD_BUSINESS);
					dataInfo.txtBusiness = stmtResult.getString(DaoBusarearchDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(DaoBusarearchDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
