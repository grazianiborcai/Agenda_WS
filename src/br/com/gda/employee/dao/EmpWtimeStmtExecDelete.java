package br.com.gda.employee.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.employee.info.EmpWtimeInfo;
import br.com.gda.helper.RecordMode;
import br.com.gda.sql.SqlStmt;

public final class EmpWtimeStmtExecDelete extends EmpWtimeStmtExecAbstract {
	
	public EmpWtimeStmtExecDelete(List<EmpStmtOption> options) {
		super(options);	
	}
	
	
	
	@Override protected String setRecordModeHook() {
		return RecordMode.RECORD_DELETED;
	}
	
	
	
	@Override protected List<SqlStmt<EmpWtimeInfo>> requestPrepareStatementHook() {
		List<SqlStmt<EmpWtimeInfo>> resultStatements = new ArrayList<>();
		
		for (EmpStmtOption eachOption : this.options) {
			SqlStmt<EmpWtimeInfo> sqlStatement = new EmpWtimeStmtUpdate(eachOption);
			resultStatements.add(sqlStatement);
		}
		
		return resultStatements;
	}
}
