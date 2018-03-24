package br.com.gda.employee.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.employee.info.EmpWTimeInfo;
import br.com.gda.sql.SqlStmt;

public final class EmpWtimeStmtExecInsert extends EmpWtimeStmtExecAbstract {	
	
	public EmpWtimeStmtExecInsert(List<EmpStmtOption<EmpWTimeInfo>> options) {
		super(options);	
	}
	
	
	
	@Override protected List<SqlStmt<EmpWTimeInfo>> requestPrepareStatementHook() {
		List<SqlStmt<EmpWTimeInfo>> resultStatements = new ArrayList<>();
		
		for (EmpStmtOption<EmpWTimeInfo> eachOption : this.options) {
			SqlStmt<EmpWTimeInfo> sqlStatement = new EmpWtimeStmtInsert(eachOption);
			resultStatements.add(sqlStatement);
		}
		
		return resultStatements;
	}
}