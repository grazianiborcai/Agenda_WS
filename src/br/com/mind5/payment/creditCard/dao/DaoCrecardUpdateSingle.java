package br.com.mind5.payment.creditCard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class DaoCrecardUpdateSingle extends DaoStmtTemplate<CrecardInfo> {
	private final String MAIN_TABLE = DaoDbTable.CREDIT_CARD_TABLE;
	
	
	public DaoCrecardUpdateSingle(Connection conn, CrecardInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.UPDATE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CrecardInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;
		
		DaoStmtWhere whereClause = new DaoCrecardWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoStmtParamTranslator<CrecardInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<CrecardInfo>() {	
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, CrecardInfo recordInfo) throws SQLException {					
				int i = 1;
				
				stmt.setString(i++, recordInfo.creditCardId);
				stmt.setString(i++, recordInfo.creditCardBrand);
				stmt.setString(i++, recordInfo.creditCardLast4);
				stmt.setString(i++, recordInfo.recordMode);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codAddressHolder);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codAddressSnapshotHolder);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPhoneHolder);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPhoneSnapshotHolder);		
				stmt.setString(i++, recordInfo.expirationMonth);
				stmt.setString(i++, recordInfo.expirationYear);
				
				return stmt;
			}		
		};
	}
}
