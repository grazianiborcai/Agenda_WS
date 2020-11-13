package br.com.mind5.business.materialStock.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoMatockUpdateSingle extends DaoStmtTemplate<MatockInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_STOCK_TABLE;	
	
	
	public DaoMatockUpdateSingle(Connection conn, MatockInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);	
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.UPDATE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MatockInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;
		
		DaoStmtWhere whereClause = new DaoMatockWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoStmtParamTranslator<MatockInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<MatockInfo>() {	
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, MatockInfo recordInfo) throws SQLException {	
				
				int i = 1;
				
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt.setInt(i++, recordInfo.quantityStock);					
				
				return stmt;
			}		
		};
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		super.executeStmt();
	}	
}
