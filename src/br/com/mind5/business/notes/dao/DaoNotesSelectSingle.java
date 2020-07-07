package br.com.mind5.business.notes.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoNotesSelectSingle extends DaoStmtTemplate<NotesInfo> {
	private final String MAIN_TABLE = DaoDbTable.NOTES_TABLE;
	
	
	public DaoNotesSelectSingle(Connection conn, NotesInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, NotesInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoNotesWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<NotesInfo> getResultParserHook() {
		return new DaoResultParser<NotesInfo>() {
			@Override public List<NotesInfo> parseResult(NotesInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<NotesInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					NotesInfo dataInfo = new NotesInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoNotesDbTableColumn.COL_COD_OWNER);
					dataInfo.codNote = stmtResult.getLong(DaoNotesDbTableColumn.COL_COD_NOTE);
					dataInfo.recordMode = stmtResult.getString(DaoNotesDbTableColumn.COL_RECORD_MODE);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoNotesDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, DaoNotesDbTableColumn.COL_LAST_CHANGED_BY);					
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoNotesDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, DaoNotesDbTableColumn.COL_CREATED_BY);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		super.executeStmt();
	}
}
