package br.com.mind5.business.notes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class NotesDaoInsertSingle extends DaoStmtTemplate<NotesInfo> {
	private final String MAIN_TABLE = DaoDbTable.NOTES_TABLE;	
	
	
	public NotesDaoInsertSingle(Connection conn, NotesInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);		
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<NotesInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<NotesInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, NotesInfo recordInfo) throws SQLException {
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codOwner);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);	
				stmt.setString(i++, recordInfo.recordMode);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
				stmt.setLong(i++, recordInfo.codCustomer);
				
				return stmt;
			}		
		};
	}
	
	
	
	@Override protected DaoResultParser<NotesInfo> getResultParserHook() {
		return new DaoResultParser<NotesInfo>() {		
			@Override public List<NotesInfo> parseResult(NotesInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<NotesInfo> finalResult = new ArrayList<>();
				recordInfo.codNote = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
