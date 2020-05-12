package br.com.mind5.payment.customerPartner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class DaoCusparUpdateSingle extends DaoStmtTemplate<CusparInfo> {
	private final String MAIN_TABLE = DaoDbTable.PAY_CUS_TABLE;
	
	
	public DaoCusparUpdateSingle(Connection conn, CusparInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.UPDATE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CusparInfo recordInfo) {	
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;
		
		DaoStmtWhere whereClause = new DaoCusparWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoStmtParamTranslator<CusparInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<CusparInfo>() {	
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, CusparInfo recordInfo) throws SQLException {					
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codUser);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUserSnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCustomer);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCustomerSnapshot);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt.setString(i++, recordInfo.recordMode);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPayPartner);
				stmt.setString(i++, recordInfo.compoundId);
				stmt.setString(i++, recordInfo.customerId);
				stmt.setNull(i++, Types.VARCHAR);
				stmt.setNull(i++, Types.VARCHAR);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codAddress);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codAddressSnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPhone);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPhoneSnapshot);
	
				return stmt;
			}		
		};
	}
}