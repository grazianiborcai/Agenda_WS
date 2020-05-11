package br.com.mind5.security.user.dao;

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
import br.com.mind5.security.user.info.UserInfo;

public final class DaoUserInsertSingle extends DaoStmtTemplate<UserInfo> {	
	private final String MAIN_TABLE = DaoDbTable.USER_TABLE;	
	
	
	public DaoUserInsertSingle(Connection conn, UserInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<UserInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<UserInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, UserInfo recordInfo) throws SQLException {			
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codOwner);		
				stmt.setString(i++, recordInfo.recordMode);	
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPerson);
				stmt = DaoFormatter.charToStmt(stmt, i++, recordInfo.codUserCategory);
				stmt.setString(i++, recordInfo.username);	
				stmt.setString(i++, recordInfo.codAuthGroup);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codSnapshot);			
				
				return stmt;
			}		
		};
	}
	
	
	
	@Override protected DaoResultParser<UserInfo> getResultParserHook() {
		return new DaoResultParser<UserInfo>() {		
			@Override public List<UserInfo> parseResult(UserInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<UserInfo> finalResult = new ArrayList<>();
				recordInfo.codUser = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
