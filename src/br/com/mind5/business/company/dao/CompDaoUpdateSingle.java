package br.com.mind5.business.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class CompDaoUpdateSingle extends DaoStmtTemplate<CompInfo> {
	private final String MAIN_TABLE = DaoDbTable.COMP_TABLE;	
	
	
	public CompDaoUpdateSingle(Connection conn, CompInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.UPDATE;
	}	
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CompInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;
		
		DaoStmtWhere whereClause = new CompDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoStmtParamTranslator<CompInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<CompInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, CompInfo recordInfo) throws SQLException {
				int i = 1;
				
				stmt.setString(i++, recordInfo.cnpj);
				stmt.setString(i++, recordInfo.name);
				stmt.setString(i++, recordInfo.email);	
				stmt.setString(i++, recordInfo.recordMode);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt.setString(i++, recordInfo.codEntityCateg);
				stmt.setString(i++, recordInfo.codCountryLegal);
				stmt.setString(i++, recordInfo.inscrEst);
				stmt.setString(i++, recordInfo.inscrMun);
				stmt.setString(i++, recordInfo.razaoSocial);	
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codSnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);	
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
				stmt.setString(i++, recordInfo.nameSearch);
				
				return stmt;
			}		
		};
	}
}
