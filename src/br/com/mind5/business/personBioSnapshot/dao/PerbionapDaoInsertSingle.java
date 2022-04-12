package br.com.mind5.business.personBioSnapshot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personBioSnapshot.info.PerbionapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class PerbionapDaoInsertSingle extends DaoStmtTemplate<PerbionapInfo> {
	private final String MAIN_TABLE = DaoDbTable.PERSON_BIO_SNAPSHOT_TABLE;	
	
	
	public PerbionapDaoInsertSingle(Connection conn, PerbionapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);		
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<PerbionapInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<PerbionapInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, PerbionapInfo recordInfo) throws SQLException {
				int i = 1;
				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwner);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPerson);
				stmt.setString(i++, recordInfo.codLanguage);				
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);				
				stmt.setString(i++, recordInfo.recordMode);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
				stmt.setString(i++, recordInfo.txtBio);
				
				return stmt;
			}		
		};
	}
	
	
	
	@Override protected DaoResultParser<PerbionapInfo> getResultParserHook() {
		return new DaoResultParser<PerbionapInfo>() {		
			@Override public List<PerbionapInfo> parseResult(PerbionapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PerbionapInfo> finalResult = new ArrayList<>();
				recordInfo.codSnapshot = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
