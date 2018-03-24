package br.com.gda.employee.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.employee.info.EmpWTimeInfo;
import br.com.gda.helper.RecordMode;
import br.com.gda.sql.SqlStmt;

public final class EmpWtimeStmtExecDelete extends EmpWtimeStmtExecAbstract {
	
	public EmpWtimeStmtExecDelete(List<EmpStmtOption<EmpWTimeInfo>> options) {
		super(options);	
	}
	
	
	
	@Override protected String setRecordModeHook() {
		return RecordMode.RECORD_DELETED;
	}
	
	
	
	@Override protected List<SqlStmt<EmpWTimeInfo>> requestPrepareStatementHook() {
		List<SqlStmt<EmpWTimeInfo>> resultStatements = new ArrayList<>();
		
		for (EmpStmtOption<EmpWTimeInfo> eachOption : this.options) {
			SqlStmt<EmpWTimeInfo> sqlStatement = new EmpWtimeStmtUpdate(eachOption);
			resultStatements.add(sqlStatement);
		}
		
		return resultStatements;
	}
}
