package br.com.mind5.business.storeLeaveDate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class StolateDaoUpdateSingle extends DaoStmtTemplate<StolateInfo> {
	private final String MAIN_TABLE = DaoDbTable.STORE_LD_TABLE;	
	
	
	public StolateDaoUpdateSingle(Connection conn, StolateInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.UPDATE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StolateInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new StolateDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoStmtParamTranslator<StolateInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<StolateInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, StolateInfo recordInfo) throws SQLException {			
				int i = 1;
				
				stmt = DaoFormatter.localDateToStmt(stmt, i++, recordInfo.dateValidTo);
				stmt = DaoFormatter.localTimeToStmt(stmt, i++, recordInfo.timeValidTo);
				stmt.setString(i++, recordInfo.description);
				stmt.setString(i++, recordInfo.recordMode);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.monthValidFrom);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.yearValidFrom);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);	
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.validFrom);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.validTo);
				
				return stmt;
			}		
		};
	}
}
