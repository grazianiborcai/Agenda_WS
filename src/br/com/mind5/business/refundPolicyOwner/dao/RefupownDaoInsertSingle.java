package br.com.mind5.business.refundPolicyOwner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class RefupownDaoInsertSingle extends DaoStmtTemplate<RefupownInfo> {
	private final String MAIN_TABLE = DaoDbTable.REFUND_POLICY_OWNER_TABLE;
	
	
	public RefupownDaoInsertSingle(Connection conn, RefupownInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<RefupownInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<RefupownInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, RefupownInfo recordInfo) throws SQLException {		
				int i = 1;
				
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
