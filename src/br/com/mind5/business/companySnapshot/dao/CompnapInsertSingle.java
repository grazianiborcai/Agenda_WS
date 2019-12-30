package br.com.mind5.business.companySnapshot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class CompnapInsertSingle extends DaoStmtTemplate<CompnapInfo> {	
	private final String MAIN_TABLE = DaoDbTable.COMP_SNAPHOT_TABLE;		
	
	
	public CompnapInsertSingle(Connection conn, CompnapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<CompnapInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<CompnapInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, CompnapInfo recordInfo) throws SQLException {			
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codOwner);
				stmt.setLong(i++, recordInfo.codCompany);
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
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);	
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);	
				
				return stmt;
			}		
		};
	}	
	
	
	
	@Override protected DaoResultParserV2<CompnapInfo> getResultParserHook() {
		return new DaoResultParserV2<CompnapInfo>() {		
			@Override public List<CompnapInfo> parseResult(CompnapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CompnapInfo> finalResult = new ArrayList<>();
				recordInfo.codSnapshot = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
