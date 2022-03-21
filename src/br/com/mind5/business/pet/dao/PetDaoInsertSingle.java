package br.com.mind5.business.pet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class PetDaoInsertSingle extends DaoStmtTemplate<PetInfo> {
	private final String MAIN_TABLE = DaoDbTable.PET_TABLE;	
	
	
	public PetDaoInsertSingle(Connection conn, PetInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);		
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<PetInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<PetInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, PetInfo recordInfo) throws SQLException {
				int i = 1;
				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwner);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);	
				stmt.setString(i++, recordInfo.recordMode);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCustomer);
				stmt.setString(i++, recordInfo.petName);
				stmt.setInt(i++, recordInfo.codPeteight);
				stmt.setInt(i++, recordInfo.codPetype);
				stmt.setString(i++, recordInfo.petNote);
				stmt = DaoFormatter.localDateToStmt(stmt, i++, recordInfo.petBirthDate);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codSnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUser);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
				stmt.setBoolean(i++, recordInfo.isDefault);
				
				return stmt;
			}		
		};
	}
	
	
	
	@Override protected DaoResultParser<PetInfo> getResultParserHook() {
		return new DaoResultParser<PetInfo>() {		
			@Override public List<PetInfo> parseResult(PetInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PetInfo> finalResult = new ArrayList<>();
				recordInfo.codPet = lastId;

				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
