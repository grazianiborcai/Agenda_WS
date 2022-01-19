package br.com.mind5.masterData.petWeightSearch.dao;

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
import br.com.mind5.masterData.petWeightSearch.info.PeteightarchInfo;

public final class DaoPeteightarchSelectSingle extends DaoStmtTemplate<PeteightarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.PET_WEIGHT_TABLE;
	
	
	public DaoPeteightarchSelectSingle(Connection conn, PeteightarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.PET_WEIGHT_SEARCH_VIEW;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PeteightarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new DaoPeteightarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(PeteightarchInfo recordInfo) {
		DaoJoinBuilder joinText = new DaoPeteightarchJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}	
	
	
	
	@Override protected DaoResultParser<PeteightarchInfo> getResultParserHook() {
		return new DaoResultParser<PeteightarchInfo>() {
			@Override public List<PeteightarchInfo> parseResult(PeteightarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PeteightarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					PeteightarchInfo dataInfo = new PeteightarchInfo();
					
					dataInfo.codPeteight = DaoFormatter.sqlToInt(stmtResult, DaoPeteightarchDbTableColumn.COL_COD_PET_WEIGHT);
					dataInfo.txtPeteightKg = stmtResult.getString(DaoPeteightarchDbTableColumn.COL_NAME_KG);
					dataInfo.codLanguage = stmtResult.getString(DaoPeteightarchDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
