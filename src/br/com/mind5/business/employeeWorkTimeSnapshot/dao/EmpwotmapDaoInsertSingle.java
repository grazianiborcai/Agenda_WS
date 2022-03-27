package br.com.mind5.business.employeeWorkTimeSnapshot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeSnapshot.info.EmpwotmapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class EmpwotmapDaoInsertSingle extends DaoStmtTemplate<EmpwotmapInfo> {
	private final String MAIN_TABLE = DaoDbTable.EMP_WT_SNAPSHOT_TABLE;		
	
	
	public EmpwotmapDaoInsertSingle(Connection conn, EmpwotmapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<EmpwotmapInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<EmpwotmapInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, EmpwotmapInfo recordInfo) throws SQLException {				
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
	
	
	
	@Override protected DaoResultParser<EmpwotmapInfo> getResultParserHook() {
		return new DaoResultParser<EmpwotmapInfo>() {		
			@Override public List<EmpwotmapInfo> parseResult(EmpwotmapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<EmpwotmapInfo> finalResult = new ArrayList<>();
				recordInfo.codSnapshot = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
