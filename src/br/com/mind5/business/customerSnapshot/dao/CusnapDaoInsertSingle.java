package br.com.mind5.business.customerSnapshot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class CusnapDaoInsertSingle extends DaoStmtTemplate<CusnapInfo> {	
	private final String MAIN_TABLE = DaoDbTable.CUS_SNAPSHOT_TABLE;
		
	
	public CusnapDaoInsertSingle(Connection conn, CusnapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<CusnapInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<CusnapInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, CusnapInfo recordInfo) throws SQLException {		
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codOwner);		
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCustomer);
				stmt.setString(i++, recordInfo.recordMode);			
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPerson);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUser);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPersonSnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUserSnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStoreSnapshot);
				
				return stmt;
			}
		};
	}
	
	
	
	@Override protected DaoResultParser<CusnapInfo> getResultParserHook() {
		return new DaoResultParser<CusnapInfo>() {		
			@Override public List<CusnapInfo> parseResult(CusnapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CusnapInfo> finalResult = new ArrayList<>();
				recordInfo.codSnapshot = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
