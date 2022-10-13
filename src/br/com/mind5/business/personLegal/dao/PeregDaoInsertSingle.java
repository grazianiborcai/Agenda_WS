package br.com.mind5.business.personLegal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class PeregDaoInsertSingle extends DaoStmtTemplate<PeregInfo> {	
	private final String MAIN_TABLE = DaoDbTable.LEGAL_PERSON_TABLE;
	
	
	public PeregDaoInsertSingle(Connection conn, PeregInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<PeregInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<PeregInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, PeregInfo recordInfo) throws SQLException {
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codOwner);		
				stmt.setString(i++, recordInfo.recordMode);			
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPerson);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
				
				return stmt;
			}		
		};
	}
	
	
	
	@Override protected DaoResultParser<PeregInfo> getResultParserHook() {
		return new DaoResultParser<PeregInfo>() {		
			@Override public List<PeregInfo> parseResult(PeregInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PeregInfo> finalResult = new ArrayList<>();
				recordInfo.codLegalPerson = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
