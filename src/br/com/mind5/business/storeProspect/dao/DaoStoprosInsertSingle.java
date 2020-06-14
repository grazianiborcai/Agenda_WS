package br.com.mind5.business.storeProspect.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class DaoStoprosInsertSingle extends DaoStmtTemplate<StoprosInfo> {
	private final String MAIN_TABLE = DaoDbTable.STORE_PROSPECT_TABLE;		
	
	
	public DaoStoprosInsertSingle(Connection conn, StoprosInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<StoprosInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<StoprosInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, StoprosInfo recordInfo) throws SQLException {
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codOwner);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt.setString(i++, recordInfo.recordMode);	
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
				stmt.setString(i++, recordInfo.prospecteEmail);	
				stmt.setString(i++, recordInfo.prospectName);	
				stmt.setString(i++, recordInfo.prospectPhone);	
				
				return stmt;
			}	
		};
	}
	
	
	
	@Override protected DaoResultParser<StoprosInfo> getResultParserHook() {
		return new DaoResultParser<StoprosInfo>() {		
			@Override public List<StoprosInfo> parseResult(StoprosInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StoprosInfo> finalResult = new ArrayList<>();
				recordInfo.codStoreProspect = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
