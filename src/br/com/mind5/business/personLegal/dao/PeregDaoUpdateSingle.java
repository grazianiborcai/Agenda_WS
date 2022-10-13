package br.com.mind5.business.personLegal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class PeregDaoUpdateSingle extends DaoStmtTemplate<PeregInfo> {
	private final String MAIN_TABLE = DaoDbTable.LEGAL_PERSON_TABLE;	
	
	
	public PeregDaoUpdateSingle(Connection conn, PeregInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);			
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.UPDATE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PeregInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;
		
		DaoStmtWhere whereClause = new PeregDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoStmtParamTranslator<PeregInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<PeregInfo>() {	
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, PeregInfo recordInfo) throws SQLException {		
				int i = 1;
				
				stmt.setString(i++, recordInfo.recordMode);			
				stmt.setTimestamp(i++, DaoFormatter.localToSqlTimestamp(recordInfo.lastChanged));
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPerson);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);		
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
				
				return stmt;
			}		
		};
	}
}
