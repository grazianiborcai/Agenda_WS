package br.com.mind5.business.employeeWorkTimeOutlier.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
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

public final class EmpwoutSelectSingle extends DaoStmtTemplate<EmpwoutInfo> {
	private final String MAIN_TABLE = DaoDbTable.EMP_WT_TABLE;	
	
	
	public EmpwoutSelectSingle(Connection conn, EmpwoutInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.EMP_WT_OUTLIER_VIEW;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EmpwoutInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new EmpwoutWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected List<DaoJoin> getJoinsHook() {
		List<DaoJoin> joins = new ArrayList<>();
		
		DaoJoinBuilder joinStore = new DaoJoinStore(MAIN_TABLE);		
		joins.add(joinStore.build());
		
		DaoJoinBuilder joinEmp = new DaoJoinEmp(MAIN_TABLE);		
		joins.add(joinEmp.build());
		
		return joins;
	}
	
	
	
	@Override protected DaoResultParser<EmpwoutInfo> getResultParserHook() {
		return new DaoResultParser<EmpwoutInfo>() {
			@Override public List<EmpwoutInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
				List<EmpwoutInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					EmpwoutInfo dataInfo = new EmpwoutInfo();
					dataInfo.codOwner = stmtResult.getLong(EmpwoutDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(EmpwoutDbTableColumn.COL_COD_STORE);
					dataInfo.codEmployee = stmtResult.getLong(EmpwoutDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codWeekday = stmtResult.getInt(EmpwoutDbTableColumn.COL_COD_WEEKDAY);
					dataInfo.recordMode = stmtResult.getString(EmpwoutDbTableColumn.COL_RECORD_MODE);
					dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, EmpwoutDbTableColumn.COL_BEGIN_TIME);
					dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, EmpwoutDbTableColumn.COL_END_TIME);
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
