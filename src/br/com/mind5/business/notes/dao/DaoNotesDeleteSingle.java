package br.com.mind5.business.notes.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoNotesDeleteSingle extends DaoStmtTemplate<NotesInfo> {
	private final String MAIN_TABLE = DaoDbTable.NOTES_TABLE;	
	
	
	public DaoNotesDeleteSingle(Connection conn, NotesInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);	
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SOFT_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, NotesInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;	
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;		
		
		DaoStmtWhere whereClause = new DaoNotesWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<NotesInfo> getResultParserHook() {
		return new DaoResultParser<NotesInfo>() {
			@Override public List<NotesInfo> parseResult(NotesInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<NotesInfo> finalResult = new ArrayList<>();
				NotesInfo emptyInfo = new NotesInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
