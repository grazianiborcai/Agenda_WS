package br.com.mind5.business.customer.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class CusDaoSelectSingle extends DaoStmtTemplate<CusInfo> {
	private final String MAIN_TABLE = DaoDbTable.CUS_TABLE;
	
	
	public CusDaoSelectSingle(Connection conn, CusInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}

	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CusInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull       = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new CusDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<CusInfo> getResultParserHook() {
		return new DaoResultParser<CusInfo>() {
			@Override public List<CusInfo> parseResult(CusInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CusInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					CusInfo dataInfo = new CusInfo();
					
					dataInfo.codUser       = DaoFormatter.sqlToLong(stmtResult, CusDaoDbTableColumn.COL_COD_USER);
					dataInfo.codOwner      = DaoFormatter.sqlToLong(stmtResult, CusDaoDbTableColumn.COL_COD_OWNER);					
					dataInfo.codStore      = DaoFormatter.sqlToLong(stmtResult, CusDaoDbTableColumn.COL_COD_STORE);
					dataInfo.codPerson     = DaoFormatter.sqlToLong(stmtResult, CusDaoDbTableColumn.COL_COD_PERSON);
					dataInfo.createdOn     = DaoFormatter.sqlToLocalDateTime(stmtResult, CusDaoDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy     = DaoFormatter.sqlToLong(stmtResult, CusDaoDbTableColumn.COL_CREATED_BY);
					dataInfo.recordMode    = stmtResult.getString(CusDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.codCustomer   = DaoFormatter.sqlToLong(stmtResult, CusDaoDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.codSnapshot   = DaoFormatter.sqlToLong(stmtResult, CusDaoDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.lastChanged   = DaoFormatter.sqlToLocalDateTime(stmtResult, CusDaoDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, CusDaoDbTableColumn.COL_LAST_CHANGED_BY);
	
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
