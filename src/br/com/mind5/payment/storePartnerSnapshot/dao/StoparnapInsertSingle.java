package br.com.mind5.payment.storePartnerSnapshot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapInfo;

public final class StoparnapInsertSingle extends DaoStmtTemplate<StoparnapInfo> {
	private final String MAIN_TABLE = DaoDbTable.PAY_PARTNER_STORE_SNAPSHOT_TABLE;
	
	
	public StoparnapInsertSingle(Connection conn, StoparnapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<StoparnapInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<StoparnapInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, StoparnapInfo recordInfo) throws SQLException {	
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codOwner);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPayPartner);
				stmt.setString(i++, recordInfo.recordMode);	
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);	
				stmt.setString(i++, recordInfo.codePayPartnerStore);
				stmt.setString(i++, recordInfo.idPayPartnerStore);
				stmt.setString(i++, recordInfo.accessToken);
				stmt.setString(i++, recordInfo.refreshToken);
				stmt.setString(i++, recordInfo.scope);
				stmt = DaoFormatter.localDateToStmt(stmt, i++, recordInfo.tokenExpiresIn);					
				
				return stmt;
			}		
		};
	}
	
	
	
	@Override protected DaoResultParser<StoparnapInfo> getResultParserHook() {
		return new DaoResultParser<StoparnapInfo>() {	
			@Override public List<StoparnapInfo> parseResult(StoparnapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StoparnapInfo> finalResult = new ArrayList<>();
				recordInfo.codSnapshot = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
