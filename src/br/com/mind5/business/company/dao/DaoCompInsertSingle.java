package br.com.mind5.business.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class DaoCompInsertSingle extends DaoStmtTemplate<CompInfo> {	
	private final String MAIN_TABLE = DaoDbTable.COMP_TABLE;	
	
	
	public DaoCompInsertSingle(Connection conn, CompInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	

	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<CompInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<CompInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, CompInfo recordInfo) throws SQLException {			
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codOwner);
				stmt.setString(i++, recordInfo.cnpj);
				stmt.setString(i++, recordInfo.name);
				stmt.setString(i++, recordInfo.email);			
				stmt.setString(i++, recordInfo.recordMode);	
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt.setString(i++, recordInfo.codEntityCateg);
				stmt.setString(i++, recordInfo.codCountryLegal);
				stmt.setString(i++, recordInfo.inscrEst);
				stmt.setString(i++, recordInfo.inscrMun);
				stmt.setString(i++, recordInfo.razaoSocial);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codSnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);	
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
				stmt.setString(i++, recordInfo.nameSearch);
				
				return stmt;
			}		
		};
	}
	
	
	
	@Override protected DaoResultParser<CompInfo> getResultParserHook() {
		return new DaoResultParser<CompInfo>() {		
			@Override public List<CompInfo> parseResult(CompInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CompInfo> finalResult = new ArrayList<>();
				recordInfo.codCompany = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
