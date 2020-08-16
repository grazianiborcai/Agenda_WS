package br.com.mind5.business.materialStoreSnapshot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStoreSnapshot.info.MatorapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class DaoMatorapInsertSingle extends DaoStmtTemplate<MatorapInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_STORE_SNAPSHOT_TABLE;
	
	
	public DaoMatorapInsertSingle(Connection conn, MatorapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<MatorapInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<MatorapInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, MatorapInfo recordInfo) throws SQLException {					
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
				
				return stmt;
			}		
		};
	}
	
	
	
	@Override protected DaoResultParser<MatorapInfo> getResultParserHook() {
		return new DaoResultParser<MatorapInfo>() {		
			@Override public List<MatorapInfo> parseResult(MatorapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MatorapInfo> finalResult = new ArrayList<>();
				recordInfo.codSnapshot = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}	
}
