package br.com.mind5.masterData.materialTypeSearch.dao;

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
import br.com.mind5.masterData.materialTypeSearch.info.MatyparchInfo;

public final class MatyparchDaoSelectSingle extends DaoStmtTemplate<MatyparchInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_TYPE_TABLE;
	
	
	public MatyparchDaoSelectSingle(Connection conn, MatyparchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.MAT_TYPE_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MatyparchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new MatyparchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(MatyparchInfo recordInfo) {
		DaoJoinBuilder joinText = new MatyparchDaoJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<MatyparchInfo> getResultParserHook() {
		return new DaoResultParser<MatyparchInfo>() {
			@Override public List<MatyparchInfo> parseResult(MatyparchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MatyparchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					MatyparchInfo dataInfo = new MatyparchInfo();
					
					dataInfo.codType = stmtResult.getInt(MatyparchDaoDbTableColumn.COL_COD_MAT_TYPE);
					dataInfo.txtType = stmtResult.getString(MatyparchDaoDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(MatyparchDaoDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
