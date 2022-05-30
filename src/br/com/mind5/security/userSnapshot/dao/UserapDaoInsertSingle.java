package br.com.mind5.security.userSnapshot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

public final class UserapDaoInsertSingle extends DaoStmtTemplate<UserapInfo> {	
	private final String MAIN_TABLE = DaoDbTable.USER_SNAPSHOT_TABLE;
	
	
	public UserapDaoInsertSingle(Connection conn, UserapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<UserapInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<UserapInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, UserapInfo recordInfo) throws SQLException {	
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codOwner);
				stmt.setLong(i++, recordInfo.codUser);
				stmt.setString(i++, recordInfo.recordMode);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPerson);
				stmt = DaoFormatter.charToStmt(stmt, i++, recordInfo.codUserCategory);
				stmt.setString(i++, recordInfo.username);
				stmt.setString(i++, recordInfo.codAuthGroup);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPersonSnapshot);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);
				
				return stmt;
			}			
		};
	}	
	
	
	
	@Override protected DaoResultParser<UserapInfo> getResultParserHook() {
		return new DaoResultParser<UserapInfo>() {		
			@Override public List<UserapInfo> parseResult(UserapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<UserapInfo> finalResult = new ArrayList<>();
				recordInfo.codSnapshot = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
