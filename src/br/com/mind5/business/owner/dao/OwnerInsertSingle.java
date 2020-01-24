package br.com.mind5.business.owner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class OwnerInsertSingle extends DaoStmtTemplate<OwnerInfo> {	
	private final String MAIN_TABLE = DaoDbTable.OWNER_TABLE;		
	
	
	public OwnerInsertSingle(Connection conn, OwnerInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<OwnerInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<OwnerInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, OwnerInfo recordInfo) throws SQLException {					
				int i = 1;
				
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt.setString(i++, recordInfo.recordMode);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPerson);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCompany);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUser);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codSnapshot);
				
				return stmt;
			}		
		};
	}
	
	
	
	
	
	@Override protected DaoResultParserV2<OwnerInfo> getResultParserHook() {
		return new DaoResultParserV2<OwnerInfo>() {		
			@Override public List<OwnerInfo> parseResult(OwnerInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<OwnerInfo> finalResult = new ArrayList<>();
				recordInfo.codOwner = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
