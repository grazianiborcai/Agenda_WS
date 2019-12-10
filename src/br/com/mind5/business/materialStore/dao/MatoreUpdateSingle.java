package br.com.mind5.business.materialStore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class MatoreUpdateSingle extends DaoStmtTemplate<MatoreInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_STORE_TABLE;	
	
	
	public MatoreUpdateSingle(Connection conn, MatoreInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);	
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.UPDATE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MatoreInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new MatoreWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoStmtParamTranslator<MatoreInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<MatoreInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, MatoreInfo recordInfo) throws SQLException {
				
				int i = 1;
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.matPrice);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.matPrice1);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.matPrice2);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.matPrice3);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.matPrice4);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.matPrice5);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.matPrice6);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.matPrice7);
				stmt.setString(i++, recordInfo.recordMode);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
				
				return stmt;
			}		
		};
	}
}
