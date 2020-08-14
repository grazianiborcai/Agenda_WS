package br.com.mind5.business.ownerSnapshot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class DaoOwnerapInsertSingle extends DaoStmtTemplate<OwnerapInfo> {	
	private final String MAIN_TABLE = DaoDbTable.OWNER_SNAPSHOT_TABLE;	
	
	
	public DaoOwnerapInsertSingle(Connection conn, OwnerapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<OwnerapInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<OwnerapInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, OwnerapInfo recordInfo) throws SQLException {					
				int i = 1;
				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwner);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt.setString(i++, recordInfo.recordMode);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPerson);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCompany);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUser);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPersonSnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUserSnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCompanySnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codBusiness);
				
				return stmt;
			}		
		};
	}	
	
	
	
	@Override protected DaoResultParser<OwnerapInfo> getResultParserHook() {
		return new DaoResultParser<OwnerapInfo>() {		
			@Override public List<OwnerapInfo> parseResult(OwnerapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<OwnerapInfo> finalResult = new ArrayList<>();
				recordInfo.codSnapshot = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
