package br.com.mind5.stats.userStorePurchaseStgn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.stats.userStorePurchaseStgn.info.StusorageInfo;

public final class DaoStusorageInsertSingle extends DaoStmtTemplate<StusorageInfo> {
	private final String MAIN_TABLE = DaoDbTable.ADDRESS_TABLE;
	
	
	public DaoStusorageInsertSingle(Connection conn, StusorageInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<StusorageInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<StusorageInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, StusorageInfo recordInfo) throws SQLException {		
				int i = 1;
				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwner);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUser);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);	
	
				return stmt;
			}		
		};
	}
}
