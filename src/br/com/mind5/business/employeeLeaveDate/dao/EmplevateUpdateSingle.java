package br.com.mind5.business.employeeLeaveDate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.mind5.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class EmplevateUpdateSingle extends DaoStmtTemplate<EmplevateInfo> {
	private final String LT_MAIN = DaoDbTable.EMP_LD_TABLE;	
	
	
	public EmplevateUpdateSingle(Connection conn, EmplevateInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return LT_MAIN;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.UPDATE;
	}	
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EmplevateInfo recordInfo) {		
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;
		
		DaoStmtWhere whereClause = new EmplevateWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoStmtParamTranslator<EmplevateInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<EmplevateInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, EmplevateInfo recordInfo) throws SQLException {			
				int i = 1;
				stmt = DaoFormatter.localDateToStmt(stmt, i++, recordInfo.dateValidTo);
				stmt = DaoFormatter.localTimeToStmt(stmt, i++, recordInfo.timeValidTo);
				stmt.setString(i++, recordInfo.description);
				stmt.setString(i++, recordInfo.recordMode);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);	
				
				return stmt;
			}		
		};
	}
}
