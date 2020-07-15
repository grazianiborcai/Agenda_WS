package br.com.mind5.business.employeeSnapshot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class DaoEmpnapInsertSingle extends DaoStmtTemplate<EmpnapInfo> {	
	private final String MAIN_TABLE = DaoDbTable.EMP_SNAPSHOT_TABLE;	
	
	
	public DaoEmpnapInsertSingle(Connection conn, EmpnapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<EmpnapInfo> getParamTranslatorHook() {	
		return new DaoStmtParamTranslator<EmpnapInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, EmpnapInfo recordInfo) throws SQLException {	
				int i = 1;
				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codEmployee);
				stmt.setLong(i++, recordInfo.codOwner);					
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPerson);
				stmt.setString(i++, recordInfo.recordMode);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUser);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPersonSnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUserSnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
				
				return stmt;
			}		
		};
	}
	
	
	
	@Override protected DaoResultParser<EmpnapInfo> getResultParserHook() {
		return new DaoResultParser<EmpnapInfo>() {		
			@Override public List<EmpnapInfo> parseResult(EmpnapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<EmpnapInfo> finalResult = new ArrayList<>();
				recordInfo.codSnapshot = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
