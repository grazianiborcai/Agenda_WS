package br.com.mind5.business.phoneSnapshot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class PhonapInsertSingle extends DaoStmtTemplate<PhonapInfo> {
	private final String MAIN_TABLE = DaoDbTable.PHONE_SNAPSHOT_TABLE;
	
	
	public PhonapInsertSingle(Connection conn, PhonapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<PhonapInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<PhonapInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, PhonapInfo recordInfo) throws SQLException {				
				int i = 1;
				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwner);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPhone);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCustomer);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codEmployee);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCountryPhone);
				stmt.setString(i++, recordInfo.fullNumber);
				stmt.setString(i++, recordInfo.recordMode);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt.setString(i++, recordInfo.complement);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUser);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwnerRef);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCustomerSnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codEmployeeSnapshot);	
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStoreSnapshot);	
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUserSnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwnerRefSnapshot);
				stmt.setString(i++, recordInfo.number);
				stmt.setString(i++, recordInfo.codArea);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);	
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);				
	
				return stmt;
			}		
		};
	}	
	
	
	
	@Override protected DaoResultParserV2<PhonapInfo> getResultParserHook() {
		return new DaoResultParserV2<PhonapInfo>() {		
			@Override public List<PhonapInfo> parseResult(PhonapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PhonapInfo> finalResult = new ArrayList<>();
				recordInfo.codSnapshot = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
