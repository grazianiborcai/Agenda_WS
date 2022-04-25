package br.com.mind5.business.employeeLunchTimeSnapshot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLunchTimeSnapshot.info.EmplutmapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class EmplutmapDaoInsertSingle extends DaoStmtTemplate<EmplutmapInfo> {
	private final String MAIN_TABLE = DaoDbTable.EMP_LT_SNAPSHOT_TABLE;		
	
	
	public EmplutmapDaoInsertSingle(Connection conn, EmplutmapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<EmplutmapInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<EmplutmapInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, EmplutmapInfo recordInfo) throws SQLException {				
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codOwner);
				stmt.setLong(i++, recordInfo.codStore);
				stmt.setLong(i++, recordInfo.codEmployee);
				stmt.setInt(i++, recordInfo.codWeekday);
				stmt = DaoFormatter.localTimeToStmt(stmt, i++, recordInfo.beginTime);
				stmt = DaoFormatter.localTimeToStmt(stmt, i++, recordInfo.endTime);
				stmt.setString(i++, recordInfo.recordMode);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
				
				return stmt;
			}		
		};
	}
	
	
	
	@Override protected DaoResultParser<EmplutmapInfo> getResultParserHook() {
		return new DaoResultParser<EmplutmapInfo>() {		
			@Override public List<EmplutmapInfo> parseResult(EmplutmapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<EmplutmapInfo> finalResult = new ArrayList<>();
				recordInfo.codSnapshot = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
