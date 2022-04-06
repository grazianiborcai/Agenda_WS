package br.com.mind5.business.employeeLeaveDateSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLeaveDateSearch.info.EmplarchInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoJoinEmp;
import br.com.mind5.dao.common.DaoJoinStore;
import br.com.mind5.dao.common.DaoOptionValue;

public final class EmplarchDaoSelectSingle extends DaoStmtTemplate<EmplarchInfo> {	
	private final String MAIN_TABLE = DaoDbTable.EMP_LD_TABLE;	
	
	
	
	public EmplarchDaoSelectSingle(Connection conn, EmplarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.EMP_LD_SEARCH_VIEW;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EmplarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new EmplarchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected List<DaoJoin> getJoinsHook(EmplarchInfo recordInfo) {
		List<DaoJoin> joins = new ArrayList<>();
		
		DaoJoinBuilder joinStore = new DaoJoinStore(MAIN_TABLE);		
		joins.add(joinStore.build());
		
		DaoJoinBuilder joinEmp = new DaoJoinEmp(MAIN_TABLE);		
		joins.add(joinEmp.build());
		
		return joins;
	}
	
	
	
	@Override protected DaoResultParser<EmplarchInfo> getResultParserHook() {
		return new DaoResultParser<EmplarchInfo>() {
			@Override public List<EmplarchInfo> parseResult(EmplarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<EmplarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					EmplarchInfo dataInfo = new EmplarchInfo();
					
					dataInfo.codOwner = stmtResult.getLong(EmplarchDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(EmplarchDaoDbTableColumn.COL_COD_STORE);
					dataInfo.codEmployee = stmtResult.getLong(EmplarchDaoDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.recordMode = stmtResult.getString(EmplarchDaoDbTableColumn.COL_RECORD_MODE);	
					dataInfo.timeValidFrom = DaoFormatter.sqlToLocalTime(stmtResult, EmplarchDaoDbTableColumn.COL_TM_VALID_FROM);
					dataInfo.dateValidFrom = DaoFormatter.sqlToLocalDate(stmtResult, EmplarchDaoDbTableColumn.COL_DT_VALID_FROM);
					
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
