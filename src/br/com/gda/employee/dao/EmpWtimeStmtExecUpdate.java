package br.com.gda.employee.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.employee.info.EmpWTimeInfo;
import br.com.gda.sql.SqlStmtOption;
import br.com.gda.sql.SqlStmt;

public final class EmpWtimeStmtExecUpdate extends EmpWtimeStmtExecAbstract {
	
	public EmpWtimeStmtExecUpdate(List<SqlStmtOption<EmpWTimeInfo>> options) {
		super(options);	
	}
	
	
	
	@Override protected List<SqlStmt<EmpWTimeInfo>> requestPrepareStatementHook() {
		List<SqlStmt<EmpWTimeInfo>> resultStatements = new ArrayList<>();
		
		for (SqlStmtOption<EmpWTimeInfo> eachOption : this.options) {
			SqlStmt<EmpWTimeInfo> sqlStatement = new EmpWtimeStmtUpdate(eachOption);
			resultStatements.add(sqlStatement);
		}
		
		return resultStatements;
	}
}
