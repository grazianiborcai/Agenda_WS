package br.com.mind5.business.addressSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoAddarchSelectSingle extends DaoStmtTemplate<AddarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.ADDRESS_TABLE;	
	
	
	public DaoAddarchSelectSingle(Connection conn, AddarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, AddarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoAddarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<AddarchInfo> getResultParserHook() {
		return new DaoResultParser<AddarchInfo>() {
			@Override public List<AddarchInfo> parseResult(AddarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<AddarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					AddarchInfo dataInfo = new AddarchInfo();
					
					dataInfo.codAddress = stmtResult.getLong(DaoAddarchDbTableColumn.COL_COD_ADDRESS);
					dataInfo.codOwner = stmtResult.getLong(DaoAddarchDbTableColumn.COL_COD_OWNER);
					dataInfo.codCountry = stmtResult.getString(DaoAddarchDbTableColumn.COL_COUNTRY);
					dataInfo.codState = stmtResult.getString(DaoAddarchDbTableColumn.COL_STATE_PROVINCE);
					dataInfo.city = stmtResult.getString(DaoAddarchDbTableColumn.COL_CITY);
					dataInfo.recordMode = stmtResult.getString(DaoAddarchDbTableColumn.COL_RECORD_MODE);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, DaoAddarchDbTableColumn.COL_COD_STORE);
					dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, DaoAddarchDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, DaoAddarchDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, DaoAddarchDbTableColumn.COL_COD_USER);
					dataInfo.codOwnerRef = DaoFormatter.sqlToLong(stmtResult, DaoAddarchDbTableColumn.COL_COD_OWNER_REF);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoAddarchDbTableColumn.COL_COD_SNAPSHOT);				
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
