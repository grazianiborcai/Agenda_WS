package br.com.mind5.business.materialStock.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class DaoMatockInsertSingle extends DaoStmtTemplate<MatockInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_STOCK_TABLE;	
	
	
	public DaoMatockInsertSingle(Connection conn, MatockInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<MatockInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<MatockInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, MatockInfo recordInfo) throws SQLException {
				
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codOwner);
				stmt.setLong(i++, recordInfo.codMat);
				stmt.setLong(i++, recordInfo.codStore);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt.setInt(i++, recordInfo.quantityStock);			
				
				return stmt;
			}		
		};
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		super.executeStmt();
	}
}
