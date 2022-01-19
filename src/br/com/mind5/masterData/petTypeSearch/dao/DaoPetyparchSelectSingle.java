package br.com.mind5.masterData.petTypeSearch.dao;

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
import br.com.mind5.masterData.petTypeSearch.info.PetyparchInfo;

public final class DaoPetyparchSelectSingle extends DaoStmtTemplate<PetyparchInfo> {
	private final String MAIN_TABLE = DaoDbTable.PET_TYPE_TABLE;
	
	
	public DaoPetyparchSelectSingle(Connection conn, PetyparchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.PET_TYPE_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PetyparchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new DaoPetyparchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(PetyparchInfo recordInfo) {
		DaoJoinBuilder joinText = new DaoPetyparchJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}	
	
	
	
	@Override protected DaoResultParser<PetyparchInfo> getResultParserHook() {
		return new DaoResultParser<PetyparchInfo>() {
			@Override public List<PetyparchInfo> parseResult(PetyparchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PetyparchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					PetyparchInfo dataInfo = new PetyparchInfo();
					
					dataInfo.codPetype = DaoFormatter.sqlToInt(stmtResult, DaoPetyparchDbTableColumn.COL_COD_PET_TYPE);
					dataInfo.txtPetype = stmtResult.getString(DaoPetyparchDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(DaoPetyparchDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
