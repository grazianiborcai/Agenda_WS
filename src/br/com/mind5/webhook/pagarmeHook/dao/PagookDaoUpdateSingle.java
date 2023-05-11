package br.com.mind5.webhook.pagarmeHook.dao;

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
import br.com.mind5.webhook.pagarmeHook.info.PagookInfo;

public final class PagookDaoUpdateSingle extends DaoStmtTemplate<PagookInfo> {
	private final String MAIN_TABLE = DaoDbTable.WEBHOOK_PAGARME_TABLE;
	
	
	public PagookDaoUpdateSingle(Connection conn, PagookInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.UPDATE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PagookInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;
		
		DaoStmtWhere whereClause = new PagookDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoStmtParamTranslator<PagookInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<PagookInfo>() {	
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, PagookInfo recordInfo) throws SQLException {	
				int i = 1;
				
				stmt.setString(i++, recordInfo.type);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwner);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPayOrder);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPayOrderItem);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				
				return stmt;
			}		
		};
	}
}
