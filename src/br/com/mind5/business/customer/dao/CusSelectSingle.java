package br.com.mind5.business.customer.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class CusSelectSingle extends DaoStmtTemplate<CusInfo> {
	private final String MAIN_TABLE = DaoDbTable.CUS_TABLE;
	
	
	public CusSelectSingle(Connection conn, CusInfo recordInfo, String schemaName) {
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
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new CusWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParserV2<CusInfo> getResultParserHook() {
		return new DaoResultParserV2<CusInfo>() {
			@Override public List<CusInfo> parseResult(CusInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CusInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					CusInfo dataInfo = new CusInfo();
					dataInfo.codOwner = stmtResult.getLong(CusDbTableColumn.COL_COD_OWNER);
					dataInfo.codCustomer = stmtResult.getLong(CusDbTableColumn.COL_COD_CUSTOMER);									
					dataInfo.recordMode = stmtResult.getString(CusDbTableColumn.COL_RECORD_MODE);
					dataInfo.codPerson = DaoFormatter.sqlToLong(stmtResult, CusDbTableColumn.COL_COD_PERSON);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, CusDbTableColumn.COL_COD_USER);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, CusDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, CusDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, CusDbTableColumn.COL_COD_SNAPSHOT);
	
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
