package br.com.mind5.masterData.materialUnitSearch.dao;

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
import br.com.mind5.masterData.materialUnitSearch.info.MatunitarchInfo;

public final class DaoMatunitarchSelectSingle extends DaoStmtTemplate<MatunitarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_UNIT_TABLE;
	
	
	public DaoMatunitarchSelectSingle(Connection conn, MatunitarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.MAT_UNIT_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MatunitarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new DaoMatunitarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(MatunitarchInfo recordInfo) {
		DaoJoinBuilder joinText = new DaoMatunitarchJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<MatunitarchInfo> getResultParserHook() {
		return new DaoResultParser<MatunitarchInfo>() {
			@Override public List<MatunitarchInfo> parseResult(MatunitarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MatunitarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					MatunitarchInfo dataInfo = new MatunitarchInfo();
					
					dataInfo.codUnit = stmtResult.getString(DaoMatunitarchDbTableColumn.COL_COD_UNIT);
					dataInfo.txtUnit = stmtResult.getString(DaoMatunitarchDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(DaoMatunitarchDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
