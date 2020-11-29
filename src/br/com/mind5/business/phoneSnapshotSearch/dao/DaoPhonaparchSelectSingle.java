package br.com.mind5.business.phoneSnapshotSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phoneSnapshotSearch.info.PhonaparchInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoPhonaparchSelectSingle extends DaoStmtTemplate<PhonaparchInfo> {
	private final String MAIN_TABLE = DaoDbTable.PHONE_SNAPSHOT_TABLE;	
	
	
	public DaoPhonaparchSelectSingle(Connection conn, PhonaparchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.PHONE_SNAPSHOT_SEARCH_VIEW;
	}	
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PhonaparchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoPhonaparchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<PhonaparchInfo> getResultParserHook() {
		return new DaoResultParser<PhonaparchInfo>() {
			@Override public List<PhonaparchInfo> parseResult(PhonaparchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PhonaparchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					PhonaparchInfo dataInfo = new PhonaparchInfo();
					
					dataInfo.codPhone = stmtResult.getLong(DaoPhonaparchDbTableColumn.COL_COD_PHONE);
					dataInfo.codSnapshot = stmtResult.getLong(DaoPhonaparchDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codOwner = stmtResult.getLong(DaoPhonaparchDbTableColumn.COL_COD_OWNER);
					dataInfo.recordMode = stmtResult.getString(DaoPhonaparchDbTableColumn.COL_RECORD_MODE);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, DaoPhonaparchDbTableColumn.COL_COD_STORE);
					dataInfo.codStoreSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoPhonaparchDbTableColumn.COL_COD_STORE_SNAPSHOT);
					dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, DaoPhonaparchDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.codCustomerSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoPhonaparchDbTableColumn.COL_COD_CUSTOMER_SNAPSHOT);
					dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, DaoPhonaparchDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codEmployeeSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoPhonaparchDbTableColumn.COL_COD_EMPLOYEE_SNAPSHOT);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, DaoPhonaparchDbTableColumn.COL_COD_USER);
					dataInfo.codUserSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoPhonaparchDbTableColumn.COL_COD_USER_SNAPSHOT);
					dataInfo.codOwnerRef = DaoFormatter.sqlToLong(stmtResult, DaoPhonaparchDbTableColumn.COL_COD_OWNER_REF);
					dataInfo.codOwnerRefSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoPhonaparchDbTableColumn.COL_COD_OWNER_REF_SNAPSHOT);
					dataInfo.isDefault = stmtResult.getBoolean(DaoPhonaparchDbTableColumn.COL_IS_DEFAULT);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
