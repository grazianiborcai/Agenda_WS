package br.com.mind5.business.addressDefault.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressDefault.info.AddaultInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class AddaultDaoSelectSingle extends DaoStmtTemplate<AddaultInfo> {
	private final String MAIN_TABLE = DaoDbTable.ADDRESS_TABLE;	
	
	
	public AddaultDaoSelectSingle(Connection conn, AddaultInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.ADDRESS_DEFAULT_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, AddaultInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new AddaultDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<AddaultInfo> getResultParserHook() {
		return new DaoResultParser<AddaultInfo>() {
			@Override public List<AddaultInfo> parseResult(AddaultInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<AddaultInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					AddaultInfo dataInfo = new AddaultInfo();
					
					dataInfo.codAddress = stmtResult.getLong(AddaultDaoDbTableColumn.COL_COD_ADDRESS);
					dataInfo.codOwner = stmtResult.getLong(AddaultDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.recordMode = stmtResult.getString(AddaultDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, AddaultDaoDbTableColumn.COL_COD_STORE);
					dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, AddaultDaoDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, AddaultDaoDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, AddaultDaoDbTableColumn.COL_COD_USER);
					dataInfo.codOwnerRef = DaoFormatter.sqlToLong(stmtResult, AddaultDaoDbTableColumn.COL_COD_OWNER_REF);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, AddaultDaoDbTableColumn.COL_COD_SNAPSHOT);				
					
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
