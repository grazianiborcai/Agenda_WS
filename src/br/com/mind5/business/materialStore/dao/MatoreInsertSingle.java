package br.com.mind5.business.materialStore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class MatoreInsertSingle extends DaoStmtTemplate<MatoreInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_STORE_TABLE;
	
	
	public MatoreInsertSingle(Connection conn, MatoreInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<MatoreInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<MatoreInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, MatoreInfo recordInfo) throws SQLException {					
				int i = 1;
				stmt.setLong(i++, recordInfo.codOwner);
				stmt.setLong(i++, recordInfo.codStore);
				stmt.setLong(i++, recordInfo.codMat);				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.matPrice);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.matPrice1);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.matPrice2);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.matPrice3);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.matPrice4);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.matPrice5);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.matPrice6);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.matPrice7);
				stmt.setString(i++, recordInfo.recordMode);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);			
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codSnapshot);
				
				return stmt;
			}		
		};
	}
}
