package br.com.mind5.business.materialMovement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class MatmovDaoInsertSingle extends DaoStmtTemplate<MatmovInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_MOVEMENT_TABLE;		
	
	
	public MatmovDaoInsertSingle(Connection conn, MatmovInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);			
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<MatmovInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<MatmovInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, MatmovInfo recordInfo) throws SQLException {				
				
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codOwner);
				stmt = DaoFormatter.charToStmt(stmt, i++, recordInfo.codMatmovType);
				stmt.setLong(i++, recordInfo.codMat);
				stmt.setLong(i++, recordInfo.codStore);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
				stmt.setInt(i++, recordInfo.quantity);	
				stmt = DaoFormatter.localDateToStmt(stmt, i++, recordInfo.postingDate);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.postingMonth);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.postingYear);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.postingYearMonth);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.quantityStock);
				
				return stmt;
			}		
		};
	}
	
	
	
	@Override protected DaoResultParser<MatmovInfo> getResultParserHook() {
		return new DaoResultParser<MatmovInfo>() {		
			@Override public List<MatmovInfo> parseResult(MatmovInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {		
				List<MatmovInfo> finalResult = new ArrayList<>();
				recordInfo.codMatmov = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
