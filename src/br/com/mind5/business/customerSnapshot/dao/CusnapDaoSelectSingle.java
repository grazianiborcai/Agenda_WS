package br.com.mind5.business.customerSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class CusnapDaoSelectSingle extends DaoStmtTemplate<CusnapInfo> {
	private final String MAIN_TABLE = DaoDbTable.CUS_SNAPSHOT_TABLE;
	
	
	public CusnapDaoSelectSingle(Connection conn, CusnapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CusnapInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new CusnapDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<CusnapInfo> getResultParserHook() {
		return new DaoResultParser<CusnapInfo>() {
			@Override public List<CusnapInfo> parseResult(CusnapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CusnapInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					CusnapInfo dataInfo = new CusnapInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, CusnapDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, CusnapDaoDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, CusnapDaoDbTableColumn.COL_COD_STORE);
					dataInfo.codStoreSnapshot = DaoFormatter.sqlToLong(stmtResult, CusnapDaoDbTableColumn.COL_COD_STORE_SNAPSHOT);
					dataInfo.recordMode = stmtResult.getString(CusnapDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.codPerson = DaoFormatter.sqlToLong(stmtResult, CusnapDaoDbTableColumn.COL_COD_PERSON);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, CusnapDaoDbTableColumn.COL_COD_USER);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, CusnapDaoDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, CusnapDaoDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, CusnapDaoDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codUserSnapshot = DaoFormatter.sqlToLong(stmtResult, CusnapDaoDbTableColumn.COL_COD_USER_SNAPSHOT);
					dataInfo.codPersonSnapshot = DaoFormatter.sqlToLong(stmtResult, CusnapDaoDbTableColumn.COL_COD_PERSON_SNAPSHOT);
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, CusnapDaoDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, CusnapDaoDbTableColumn.COL_CREATED_BY);
	
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
