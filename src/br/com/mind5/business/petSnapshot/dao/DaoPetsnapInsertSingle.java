package br.com.mind5.business.petSnapshot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.petSnapshot.info.PetsnapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class DaoPetsnapInsertSingle extends DaoStmtTemplate<PetsnapInfo> {
	private final String MAIN_TABLE = DaoDbTable.PET_SNAPSHOT_TABLE;	
	
	
	public DaoPetsnapInsertSingle(Connection conn, PetsnapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);		
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<PetsnapInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<PetsnapInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, PetsnapInfo recordInfo) throws SQLException {
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codOwner);
				stmt.setLong(i++, recordInfo.codPet);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);	
				stmt.setString(i++, recordInfo.recordMode);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
				stmt.setLong(i++, recordInfo.codCustomer);
				stmt.setString(i++, recordInfo.petName);
				stmt.setInt(i++, recordInfo.codPeteight);
				stmt.setInt(i++, recordInfo.codPetype);
				stmt.setString(i++, recordInfo.petNote);
				stmt = DaoFormatter.localDateToStmt(stmt, i++, recordInfo.petBirthDate);				
				
				return stmt;
			}		
		};
	}
	
	
	
	@Override protected DaoResultParser<PetsnapInfo> getResultParserHook() {
		return new DaoResultParser<PetsnapInfo>() {		
			@Override public List<PetsnapInfo> parseResult(PetsnapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PetsnapInfo> finalResult = new ArrayList<>();
				recordInfo.codPet = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
