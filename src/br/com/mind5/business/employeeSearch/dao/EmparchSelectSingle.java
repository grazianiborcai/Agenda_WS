package br.com.mind5.business.employeeSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoJoinPerson;
import br.com.mind5.dao.common.DaoJoinUser;
import br.com.mind5.dao.common.DaoOptionValue;

public final class EmparchSelectSingle extends DaoStmtTemplate<EmparchInfo> {
	private final String MAIN_TABLE = DaoDbTable.EMP_TABLE;
	
	
	public EmparchSelectSingle(Connection conn, EmparchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.EMP_SEARCH_VIEW;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EmparchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new EmparchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected List<DaoJoin> getJoinsHook(EmparchInfo recordInfo) {
		List<DaoJoin> joins = new ArrayList<>();
		
		DaoJoinBuilder joinPerson = new DaoJoinPerson(MAIN_TABLE);		
		joins.add(joinPerson.build());
		
		DaoJoinBuilder joinUser = new DaoJoinUser(MAIN_TABLE);		
		joins.add(joinUser.build());
		
		return joins;
	}
	
	
		
	@Override protected DaoResultParser<EmparchInfo> getResultParserHook() {
		return new DaoResultParser<EmparchInfo>() {
			@Override public List<EmparchInfo> parseResult(EmparchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<EmparchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					EmparchInfo dataInfo = new EmparchInfo();
					
					dataInfo.codOwner = stmtResult.getLong(EmparchDbTableColumn.COL_COD_OWNER);
					dataInfo.codEmployee = stmtResult.getLong(EmparchDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.recordMode = stmtResult.getString(EmparchDbTableColumn.COL_RECORD_MODE);
					dataInfo.codPerson = DaoFormatter.sqlToLong(stmtResult, EmparchDbTableColumn.COL_COD_PERSON);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, EmparchDbTableColumn.COL_COD_USER);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, EmparchDbTableColumn.COL_COD_SNAPSHOT);				
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
