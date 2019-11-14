package br.com.mind5.business.employeePositionSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class EmposarchSelectSingle extends DaoStmtTemplate<EmposarchInfo> {	
	private final String MAIN_TABLE = DaoDbTable.EMPOS_TABLE;	

	
	public EmposarchSelectSingle(Connection conn, EmposarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName, EmposarchSelectSingle.class);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.EMPOS_SEARCH_VIEW;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EmposarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new EmposarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected List<DaoJoin> getJoinsHook() {
		List<DaoJoin> joins = new ArrayList<>();
		
		DaoJoinBuilder joinStore = new EmposarchJoinStore(MAIN_TABLE);		
		joins.add(joinStore.build());
		
		DaoJoinBuilder joinEmp = new EmposarchJoinEmp(MAIN_TABLE);		
		joins.add(joinEmp.build());
		
		return joins;
	}
	
	
	
	@Override protected DaoResultParser<EmposarchInfo> getResultParserHook() {
		return new DaoResultParser<EmposarchInfo>() {
			private final boolean EMPTY_RESULT_SET = false;
			
			@Override public List<EmposarchInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
				List<EmposarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == EMPTY_RESULT_SET)				
					return finalResult;
				
				do {
					EmposarchInfo dataInfo = new EmposarchInfo();
					dataInfo.codOwner = stmtResult.getLong(EmposarchDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(EmposarchDbTableColumn.COL_COD_STORE);
					dataInfo.codEmployee = stmtResult.getLong(EmposarchDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codPosition = stmtResult.getInt(EmposarchDbTableColumn.COL_COD_POSITION);
					dataInfo.recordMode = stmtResult.getString(EmposarchDbTableColumn.COL_RECORD_MODE);					
					
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
