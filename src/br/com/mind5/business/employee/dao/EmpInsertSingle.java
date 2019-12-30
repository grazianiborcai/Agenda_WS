package br.com.mind5.business.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class EmpInsertSingle extends DaoStmtTemplate<EmpInfo> {	
	private final String MAIN_TABLE = DaoDbTable.EMP_TABLE;	
	
	
	public EmpInsertSingle(Connection conn, EmpInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);		
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<EmpInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<EmpInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, EmpInfo recordInfo) throws SQLException {				
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codOwner);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPerson);			
				stmt.setString(i++, recordInfo.recordMode);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUser);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codSnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
				
				return stmt;
			}		
		};
	}
	
	
	
	@Override protected DaoResultParserV2<EmpInfo> getResultParserHook() {
		return new DaoResultParserV2<EmpInfo>() {		
			@Override public List<EmpInfo> parseResult(EmpInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<EmpInfo> finalResult = new ArrayList<>();
				recordInfo.codEmployee = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
