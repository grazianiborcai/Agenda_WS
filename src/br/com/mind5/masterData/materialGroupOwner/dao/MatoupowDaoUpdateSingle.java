package br.com.mind5.masterData.materialGroupOwner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.masterData.materialGroupOwner.info.MatoupowInfo;

public final class MatoupowDaoUpdateSingle extends DaoStmtTemplate<MatoupowInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_GROUP_OWNER_TABLE;	
	
	
	public MatoupowDaoUpdateSingle(Connection conn, MatoupowInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);			
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.UPDATE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MatoupowInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;
		
		DaoStmtWhere whereClause = new MatoupowDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoStmtParamTranslator<MatoupowInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<MatoupowInfo>() {	
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, MatoupowInfo recordInfo) throws SQLException {				
				int i = 1;
				
				stmt.setBoolean(i++, recordInfo.isLocked);
				stmt.setString(i++, recordInfo.recordMode);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.rgbDecBlue);	
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.rgbDecGreen);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.rgbDecRed);
				stmt.setString(i++, recordInfo.rgbHex);
				
				return stmt;
			}		
		};
	}
}
