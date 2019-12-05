package br.com.mind5.business.materialSnapshot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class MatsnapInsertSingle extends DaoStmtTemplate<MatsnapInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_SNAPSHOT_TABLE;	
	
	
	public MatsnapInsertSingle(Connection conn, MatsnapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);	
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<MatsnapInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<MatsnapInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, MatsnapInfo recordInfo) throws SQLException {	
				int i = 1;
				stmt.setLong(i++, recordInfo.codOwner);
				stmt.setLong(i++, recordInfo.codMat);
				stmt.setInt(i++, recordInfo.codType);
				stmt.setInt(i++, recordInfo.codMatCateg);
				stmt.setString(i++, recordInfo.codUnit);
				stmt.setInt(i++, recordInfo.priceUnit);
				stmt.setInt(i++, recordInfo.codGroup);
				stmt.setBoolean(i++, recordInfo.isLocked);
				stmt.setString(i++, recordInfo.recordMode);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);	
				
				return stmt;
			}		
		};
	}
	
	
	
	@Override protected DaoResultParserV2<MatsnapInfo> getResultParserHook() {
		return new DaoResultParserV2<MatsnapInfo>() {		
			@Override public List<MatsnapInfo> parseResult(MatsnapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MatsnapInfo> finalResult = new ArrayList<>();
				recordInfo.codSnapshot = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
