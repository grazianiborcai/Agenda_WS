package br.com.mind5.business.material.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class MatDaoUpdateSingle extends DaoStmtTemplate<MatInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_TABLE;	
	
	
	public MatDaoUpdateSingle(Connection conn, MatInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);			
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.UPDATE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MatInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;
		
		DaoStmtWhere whereClause = new MatDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoStmtParamTranslator<MatInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<MatInfo>() {	
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, MatInfo recordInfo) throws SQLException {				
				int i = 1;
				
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
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codSubgroup);
				
				return stmt;
			}		
		};
	}
}
