package br.com.mind5.business.employeeMaterialSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchInfo;
import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class EmpmarchDaoSelectSingle extends DaoStmtTemplate<EmpmarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.EMP_MAT_TABLE;
	
	
	public EmpmarchDaoSelectSingle(Connection conn, EmpmarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	protected String getLookupTableHook() {
		return DaoDbTable.EMP_MAT_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EmpmarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new EmpmarchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected List<DaoJoin> getJoinsHook(EmpmarchInfo recordInfo) {
		List<DaoJoin> joins = new ArrayList<>();
		
		DaoJoinBuilder joinEmp = new EmpmarchDaoJoinEmp(MAIN_TABLE);		
		joins.add(joinEmp.build());
		
		DaoJoinBuilder joinMat = new EmpmarchDaoJoinMat(MAIN_TABLE);		
		joins.add(joinMat.build());
		
		return joins;
	}
	
	
	
	@Override protected DaoResultParser<EmpmarchInfo> getResultParserHook() {
		return new DaoResultParser<EmpmarchInfo>() {
			@Override public List<EmpmarchInfo> parseResult(EmpmarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<EmpmarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					EmpmarchInfo dataInfo = new EmpmarchInfo();
					
					dataInfo.codOwner = stmtResult.getLong(EmpmarchDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codEmployee = stmtResult.getLong(EmpmarchDaoDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codMat = stmtResult.getLong(EmpmarchDaoDbTableColumn.COL_COD_MATERIAL);
					dataInfo.codStore = stmtResult.getLong(EmpmarchDaoDbTableColumn.COL_COD_STORE);
					dataInfo.recordMode = stmtResult.getString(EmpmarchDaoDbTableColumn.COL_RECORD_MODE);	
					
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
