package br.com.mind5.business.refundPolicyStore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class DaoRefuporeInsertSingle extends DaoStmtTemplate<RefuporeInfo> {
	private final String MAIN_TABLE = DaoDbTable.REFUND_POLICY_STORE_TABLE;
	
	
	public DaoRefuporeInsertSingle(Connection conn, RefuporeInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<RefuporeInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<RefuporeInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, RefuporeInfo recordInfo) throws SQLException {		
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codStore);
				stmt.setLong(i++, recordInfo.codOwner);				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codRefundPolicyGroup);
				stmt.setString(i++, recordInfo.recordMode);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);	
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);					
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);	
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);		
	
				return stmt;
			}		
		};
	}
}
