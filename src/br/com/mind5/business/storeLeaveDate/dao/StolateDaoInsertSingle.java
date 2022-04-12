package br.com.mind5.business.storeLeaveDate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class StolateDaoInsertSingle extends DaoStmtTemplate<StolateInfo> {
	private final String MAIN_TABLE = DaoDbTable.STORE_LD_TABLE;	
	
	
	public StolateDaoInsertSingle(Connection conn, StolateInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<StolateInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<StolateInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, StolateInfo recordInfo) throws SQLException {				
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codOwner);
				stmt.setLong(i++, recordInfo.codStore);
				stmt = DaoFormatter.localDateToStmt(stmt, i++, recordInfo.dateValidFrom);
				stmt = DaoFormatter.localTimeToStmt(stmt, i++, recordInfo.timeValidFrom);
				stmt = DaoFormatter.localDateToStmt(stmt, i++, recordInfo.dateValidTo);
				stmt = DaoFormatter.localTimeToStmt(stmt, i++, recordInfo.timeValidTo);
				stmt.setString(i++, recordInfo.description);
				stmt.setString(i++, recordInfo.recordMode);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.monthValidFrom);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.yearValidFrom);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);	
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.validFrom);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.validTo);
				
				return stmt;
			}		
		};
	}
}
