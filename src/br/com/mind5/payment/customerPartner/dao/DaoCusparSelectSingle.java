package br.com.mind5.payment.customerPartner.dao;

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
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class DaoCusparSelectSingle extends DaoStmtTemplate<CusparInfo> {
	private final String MAIN_TABLE = DaoDbTable.PAY_CUS_TABLE;
	
	
	
	public DaoCusparSelectSingle(Connection conn, CusparInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CusparInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoCusparWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
		
	@Override protected DaoResultParser<CusparInfo> getResultParserHook() {
		return new DaoResultParser<CusparInfo>() {
			@Override public List<CusparInfo> parseResult(CusparInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {				
				List<CusparInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					CusparInfo dataInfo = new CusparInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoCusparDbTableColumn.COL_COD_OWNER);	
					dataInfo.codPayCustomer = stmtResult.getLong(DaoCusparDbTableColumn.COL_COD_PAYCUS);
					dataInfo.codUser = stmtResult.getLong(DaoCusparDbTableColumn.COL_COD_USER);
					dataInfo.recordMode = stmtResult.getString(DaoCusparDbTableColumn.COL_RECORD_MODE);				
					dataInfo.compoundId = stmtResult.getString(DaoCusparDbTableColumn.COL_COMPOUND_ID);
					dataInfo.customerId = stmtResult.getString(DaoCusparDbTableColumn.COL_CUSTOMER_ID);
					dataInfo.codUserSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoCusparDbTableColumn.COL_COD_USER_SNAPSHOT);
					dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, DaoCusparDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.codCustomerSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoCusparDbTableColumn.COL_COD_CUSTOMER_SNAPSHOT);
					dataInfo.codPayPartner = DaoFormatter.sqlToInt(stmtResult, DaoCusparDbTableColumn.COL_COD_PAY_PARTNER);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoCusparDbTableColumn.COL_LAST_CHANGED);						
					dataInfo.codAddress = DaoFormatter.sqlToLong(stmtResult, DaoCusparDbTableColumn.COL_COD_ADDRESS);
					dataInfo.codAddressSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoCusparDbTableColumn.COL_COD_ADDRESS_SNAPSHOT);
					dataInfo.codPhone = DaoFormatter.sqlToLong(stmtResult, DaoCusparDbTableColumn.COL_COD_PHONE);
					dataInfo.codPhoneSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoCusparDbTableColumn.COL_COD_PHONE_SNAPSHOT);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
