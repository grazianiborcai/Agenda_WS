package br.com.mind5.business.customerSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
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
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoCusarchSelectSingle extends DaoStmtTemplate<CusarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.CUS_TABLE;
	
	
	public DaoCusarchSelectSingle(Connection conn, CusarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.CUS_SEARCH_VIEW;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CusarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;	
		
		DaoStmtWhere whereClause = new DaoCusarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected List<DaoJoin> getJoinsHook(CusarchInfo recordInfo) {
		List<DaoJoin> joins = new ArrayList<>();
		
		DaoJoinBuilder joinPerson = new DaoJoinPerson(MAIN_TABLE);		
		joins.add(joinPerson.build());
		
		DaoJoinBuilder joinPhone = new DaoCusarchJoinPhone(MAIN_TABLE);		
		joins.add(joinPhone.build());
		
		return joins;
	}
	
	
	
	@Override protected DaoResultParser<CusarchInfo> getResultParserHook() {
		return new DaoResultParser<CusarchInfo>() {
			@Override public List<CusarchInfo> parseResult(CusarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CusarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					CusarchInfo dataInfo = new CusarchInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoCusarchDbTableColumn.COL_COD_OWNER);
					dataInfo.codCustomer = stmtResult.getLong(DaoCusarchDbTableColumn.COL_COD_CUSTOMER);	
					dataInfo.recordMode = stmtResult.getString(DaoCusarchDbTableColumn.COL_RECORD_MODE);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, DaoCusarchDbTableColumn.COL_COD_USER);
					
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
