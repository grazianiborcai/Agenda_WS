package br.com.mind5.masterData.materialSubgroupSearch.dao;

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
import br.com.mind5.masterData.materialSubgroupSearch.info.MatubuparchInfo;

public final class DaoMatubuparchSelectSingle extends DaoStmtTemplate<MatubuparchInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_SUBGROUP_TABLE;
	
	
	public DaoMatubuparchSelectSingle(Connection conn, MatubuparchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.MAT_SUBGROUP_SEARCH_VIEW;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MatubuparchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new DaoMatubuparchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected List<DaoJoin> getJoinsHook(MatubuparchInfo recordInfo) {
		List<DaoJoin> joins = new ArrayList<>();
		
		DaoJoinBuilder joinText = new DaoMatubuparchJoinTxt(MAIN_TABLE);		
		joins.add(joinText.build());
		
		return joins;
	}
	
	
	
	@Override protected DaoResultParser<MatubuparchInfo> getResultParserHook() {
		return new DaoResultParser<MatubuparchInfo>() {			
			@Override public List<MatubuparchInfo> parseResult(MatubuparchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MatubuparchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					MatubuparchInfo dataInfo = new MatubuparchInfo();
					
					dataInfo.codSubgroup = stmtResult.getInt(DaoMatubuparchDbTableColumn.COL_COD_MAT_SUBGROUP);
					dataInfo.codGroup = stmtResult.getInt(DaoMatubuparchDbTableColumn.COL_COD_MAT_GROUP);				
					dataInfo.txtSubgroup = stmtResult.getString(DaoMatubuparchDbTableColumn.COL_NAME);					
					dataInfo.codLanguage = stmtResult.getString(DaoMatubuparchDbTableColumn.COL_COD_LANGUAGE);		
					
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
