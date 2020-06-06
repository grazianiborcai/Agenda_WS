package br.com.mind5.business.employeeWorkTimeSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
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

public final class DaoEmpwotarchSelectSingle extends DaoStmtTemplate<EmpwotarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.EMP_WT_TABLE;	
	

	public DaoEmpwotarchSelectSingle(Connection conn, EmpwotarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.EMP_WT_SEARCH_VIEW;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EmpwotarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoEmpwotarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected List<DaoJoin> getJoinsHook(EmpwotarchInfo recordInfo) {
		List<DaoJoin> joins = new ArrayList<>();
		
		DaoJoinBuilder joinStore = new DaoJoinStore(MAIN_TABLE);		
		joins.add(joinStore.build());
		
		DaoJoinBuilder joinEmp = new DaoJoinEmp(MAIN_TABLE);		
		joins.add(joinEmp.build());
		
		return joins;
	}
	
	
	
	@Override protected DaoResultParser<EmpwotarchInfo> getResultParserHook() {
		return new DaoResultParser<EmpwotarchInfo>() {
			@Override public List<EmpwotarchInfo> parseResult(EmpwotarchInfo redcordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<EmpwotarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					EmpwotarchInfo dataInfo = new EmpwotarchInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoEmpwotarchDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(DaoEmpwotarchDbTableColumn.COL_COD_STORE);
					dataInfo.codEmployee = stmtResult.getLong(DaoEmpwotarchDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codWeekday = stmtResult.getInt(DaoEmpwotarchDbTableColumn.COL_COD_WEEKDAY);
					dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, DaoEmpwotarchDbTableColumn.COL_BEGIN_TIME);
					dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, DaoEmpwotarchDbTableColumn.COL_END_TIME);
					dataInfo.recordMode = stmtResult.getString(DaoEmpwotarchDbTableColumn.COL_RECORD_MODE);			
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
