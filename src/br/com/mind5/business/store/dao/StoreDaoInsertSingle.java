package br.com.mind5.business.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class StoreDaoInsertSingle extends DaoStmtTemplate<StoreInfo> {
	private final String MAIN_TABLE = DaoDbTable.STORE_TABLE;		
	
	
	public StoreDaoInsertSingle(Connection conn, StoreInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<StoreInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<StoreInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, StoreInfo recordInfo) throws SQLException {
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codOwner);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCompany);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt.setString(i++, recordInfo.codCurr);
				stmt.setString(i++, recordInfo.codTimezone);
				stmt.setString(i++, recordInfo.recordMode);		
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUser);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codSnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
				stmt.setBoolean(i++, recordInfo.isLocked);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codLegalPerson);
				
				return stmt;
			}	
		};
	}
	
	
	
	@Override protected DaoResultParser<StoreInfo> getResultParserHook() {
		return new DaoResultParser<StoreInfo>() {		
			@Override public List<StoreInfo> parseResult(StoreInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StoreInfo> finalResult = new ArrayList<>();
				recordInfo.codStore = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
