package br.com.mind5.business.customerList.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class CuslisDaoSelectSingle extends DaoStmtTemplate<CuslisInfo> {
	private final String MAIN_TABLE = DaoDbTable.CUS_TABLE;
	
	
	public CuslisDaoSelectSingle(Connection conn, CuslisInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.CUS_LIST_VIEW;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}	
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CuslisInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new CuslisDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<CuslisInfo> getResultParserHook() {
		return new DaoResultParser<CuslisInfo>() {
			@Override public List<CuslisInfo> parseResult(CuslisInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CuslisInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					CuslisInfo dataInfo = new CuslisInfo();
					
					dataInfo.codUser     = DaoFormatter.sqlToLong(stmtResult, CuslisDaoDbTableColumn.COL_COD_USER);
					dataInfo.codOwner    = stmtResult.getLong(CuslisDaoDbTableColumn.COL_COD_OWNER);					
					dataInfo.codStore    = stmtResult.getLong(CuslisDaoDbTableColumn.COL_COD_STORE);					
					dataInfo.codPerson   = DaoFormatter.sqlToLong(stmtResult, CuslisDaoDbTableColumn.COL_COD_PERSON);
					dataInfo.recordMode  = stmtResult.getString(CuslisDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.codCustomer = stmtResult.getLong(CuslisDaoDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, CuslisDaoDbTableColumn.COL_COD_SNAPSHOT);
	
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
