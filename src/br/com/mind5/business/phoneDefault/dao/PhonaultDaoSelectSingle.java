package br.com.mind5.business.phoneDefault.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phoneDefault.info.PhonaultInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class PhonaultDaoSelectSingle extends DaoStmtTemplate<PhonaultInfo> {
	private final String MAIN_TABLE = DaoDbTable.PHONE_TABLE;	
	
	
	public PhonaultDaoSelectSingle(Connection conn, PhonaultInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.PHONE_DEFAULT_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PhonaultInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new PhonaultDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<PhonaultInfo> getResultParserHook() {
		return new DaoResultParser<PhonaultInfo>() {
			@Override public List<PhonaultInfo> parseResult(PhonaultInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PhonaultInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					PhonaultInfo dataInfo = new PhonaultInfo();
					
					dataInfo.codPhone = stmtResult.getLong(PhonaultDaoDbTableColumn.COL_COD_PHONE);
					dataInfo.codOwner = stmtResult.getLong(PhonaultDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.recordMode = stmtResult.getString(PhonaultDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, PhonaultDaoDbTableColumn.COL_COD_STORE);
					dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, PhonaultDaoDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, PhonaultDaoDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, PhonaultDaoDbTableColumn.COL_COD_USER);
					dataInfo.codOwnerRef = DaoFormatter.sqlToLong(stmtResult, PhonaultDaoDbTableColumn.COL_COD_OWNER_REF);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, PhonaultDaoDbTableColumn.COL_COD_SNAPSHOT);				
					
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
