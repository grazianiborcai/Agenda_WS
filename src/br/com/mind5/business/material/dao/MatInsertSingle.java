package br.com.mind5.business.material.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class MatInsertSingle extends DaoStmtTemplate<MatInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_TABLE;		
	
	
	public MatInsertSingle(Connection conn, MatInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);		
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<MatInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<MatInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, MatInfo recordInfo) throws SQLException {
				
				int i = 1;
				stmt.setLong(i++, recordInfo.codOwner);
				stmt.setInt(i++, recordInfo.codType);
				stmt.setInt(i++, recordInfo.codMatCateg);
				stmt.setString(i++, recordInfo.codUnit);
				stmt.setInt(i++, recordInfo.priceUnit);
				stmt.setInt(i++, recordInfo.codGroup);
				stmt.setBoolean(i++, recordInfo.isLocked);
				stmt.setString(i++, recordInfo.recordMode);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codSnapshot);	
				
				return stmt;
			}		
		};
	}
		
	
	
	@Override protected DaoResultParserV2<MatInfo> getResultParserHook() {
		return new DaoResultParserV2<MatInfo>() {		
			@Override public List<MatInfo> parseResult(MatInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MatInfo> finalResult = new ArrayList<>();
				recordInfo.codMat = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
