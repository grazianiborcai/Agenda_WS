package br.com.mind5.masterData.materialSubgroup.dao;

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
import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;

public final class DaoMatubupSelectSingle extends DaoStmtTemplate<MatubupInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_SUBGROUP_TABLE;
	
	
	public DaoMatubupSelectSingle(Connection conn, MatubupInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MatubupInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoMatubupWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected List<DaoJoin> getJoinsHook(MatubupInfo recordInfo) {
		List<DaoJoin> joins = new ArrayList<>();
		
		DaoJoinBuilder joinText = new DaoMatubupJoinTxt(MAIN_TABLE);		
		joins.add(joinText.build());
		
		return joins;
	}
	
	
	
	@Override protected DaoResultParser<MatubupInfo> getResultParserHook() {
		return new DaoResultParser<MatubupInfo>() {			
			@Override public List<MatubupInfo> parseResult(MatubupInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MatubupInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					MatubupInfo dataInfo = new MatubupInfo();
					
					dataInfo.codSubgroup = stmtResult.getInt(DaoMatubupDbTableColumn.COL_COD_MAT_SUBGROUP);
					dataInfo.codGroup = stmtResult.getInt(DaoMatubupDbTableColumn.COL_COD_MAT_GROUP);	
					dataInfo.sortSubgroup = stmtResult.getInt(DaoMatubupDbTableColumn.COL_SORT);
					dataInfo.txtSubgroup = stmtResult.getString(DaoMatubupDbTableColumn.COL_NAME);					
					dataInfo.codLanguage = stmtResult.getString(DaoMatubupDbTableColumn.COL_COD_LANGUAGE);		
					
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
