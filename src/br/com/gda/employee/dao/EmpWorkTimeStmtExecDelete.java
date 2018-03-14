package br.com.gda.employee.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.employee.info.EmpWorkTimeInfo;
import br.com.gda.sql.SqlStmt;

public final class EmpWorkTimeStmtExecDelete extends EmpWorkTimeStmtExecAbstract {
	
	public EmpWorkTimeStmtExecDelete(List<EmpStmtOption> options) {
		super(options);	
	}
	
	
	
	@Override protected List<SqlStmt<EmpWorkTimeInfo>> requestPrepareStatementHook() {
		List<SqlStmt<EmpWorkTimeInfo>> resultStatements = new ArrayList<>();
		
		for (EmpStmtOption eachOption : this.options) {
			SqlStmt<EmpWorkTimeInfo> sqlStatement = new EmpWorkTimeStmtDelete(eachOption);
			resultStatements.add(sqlStatement);
		}
		
		return resultStatements;
	}
}
