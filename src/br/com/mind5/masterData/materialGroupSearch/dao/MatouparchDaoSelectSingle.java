package br.com.mind5.masterData.materialGroupSearch.dao;

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
import br.com.mind5.masterData.materialGroupSearch.info.MatouparchInfo;

public final class MatouparchDaoSelectSingle extends DaoStmtTemplate<MatouparchInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_GROUP_TABLE;
	
	
	public MatouparchDaoSelectSingle(Connection conn, MatouparchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.MAT_GROUP_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MatouparchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new MatouparchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected List<DaoJoin> getJoinsHook(MatouparchInfo recordInfo) {
		List<DaoJoin> joins = new ArrayList<>();
		
		DaoJoinBuilder joinText = new MatouparchDaoJoinTxt(MAIN_TABLE);		
		joins.add(joinText.build());
		
		return joins;
	}
	
	
	
	@Override protected DaoResultParser<MatouparchInfo> getResultParserHook() {
		return new DaoResultParser<MatouparchInfo>() {			
			@Override public List<MatouparchInfo> parseResult(MatouparchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MatouparchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					MatouparchInfo dataInfo = new MatouparchInfo();
					
					dataInfo.codGroup = stmtResult.getInt(MatouparchDaoDbTableColumn.COL_COD_MAT_GROUP);				
					dataInfo.txtGroup = stmtResult.getString(MatouparchDaoDbTableColumn.COL_NAME);
					dataInfo.codBusiness = stmtResult.getInt(MatouparchDaoDbTableColumn.COL_COD_BUSINESS);
					dataInfo.codLanguage = stmtResult.getString(MatouparchDaoDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		super.executeStmt();
	}
}
