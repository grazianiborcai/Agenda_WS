package br.com.gda.employee.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.employee.info.EmpWtimeInfo;
import br.com.gda.sql.SqlStmt;

public final class EmpWtimeStmtExecSelect extends EmpWtimeStmtExecAbstract {

	public EmpWtimeStmtExecSelect(List<EmpStmtOption> options) {
		super(options);	
	}
	
	
	
	@Override protected List<SqlStmt<EmpWtimeInfo>> requestPrepareStatementHook() {
		List<SqlStmt<EmpWtimeInfo>> resultStatements = new ArrayList<>();
		
		for (EmpStmtOption eachOption : this.options) {
			SqlStmt<EmpWtimeInfo> sqlStatement = new EmpWtimeStmtSelect(eachOption);
			resultStatements.add(sqlStatement);
		}
		
		return resultStatements;
	}
}
