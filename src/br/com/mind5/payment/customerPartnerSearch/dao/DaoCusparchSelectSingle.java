package br.com.mind5.payment.customerPartnerSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;

public final class DaoCusparchSelectSingle extends DaoStmtTemplate<CusparchInfo> {
	private final String MAIN_TABLE = DaoDbTable.PAY_CUS_TABLE;
	
	
	
	public DaoCusparchSelectSingle(Connection conn, CusparchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.PAY_CUS_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CusparchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoCusparchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
		
	@Override protected DaoResultParser<CusparchInfo> getResultParserHook() {
		return new DaoResultParser<CusparchInfo>() {
			@Override public List<CusparchInfo> parseResult(CusparchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {				
				List<CusparchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					CusparchInfo dataInfo = new CusparchInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoCusparchDbTableColumn.COL_COD_OWNER);	
					dataInfo.codPayCustomer = stmtResult.getLong(DaoCusparchDbTableColumn.COL_COD_PAYCUS);
					dataInfo.codUser = stmtResult.getLong(DaoCusparchDbTableColumn.COL_COD_USER);
					dataInfo.recordMode = stmtResult.getString(DaoCusparchDbTableColumn.COL_RECORD_MODE);				
					dataInfo.compoundId = stmtResult.getString(DaoCusparchDbTableColumn.COL_COMPOUND_ID);
					dataInfo.customerId = stmtResult.getString(DaoCusparchDbTableColumn.COL_CUSTOMER_ID);
					dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, DaoCusparchDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.codPayPartner = DaoFormatter.sqlToInt(stmtResult, DaoCusparchDbTableColumn.COL_COD_PAY_PARTNER);				
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
