package br.com.gda.employee.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.employee.info.EmpWTimeInfo;
import br.com.gda.sql.SqlStmt;
import br.com.gda.sql.SqlStmtExecutorOption;

public final class EmpWtimeStmtExecSelect extends EmpWtimeStmtExecAbstract {

	public EmpWtimeStmtExecSelect(List<SqlStmtExecutorOption<EmpWTimeInfo>> options) {
		super(options);	
	}
	
	
	
	@Override protected List<SqlStmt<EmpWTimeInfo>> requestPrepareStatementHook() {
		List<SqlStmt<EmpWTimeInfo>> resultStatements = new ArrayList<>();
		
		for (SqlStmtExecutorOption<EmpWTimeInfo> eachOption : this.options) {
			SqlStmt<EmpWTimeInfo> sqlStatement = new EmpWtimeStmtSelect(eachOption.conn, eachOption.recordInfo, eachOption.schemaName);
			resultStatements.add(sqlStatement);
		}
		
		return resultStatements;
	}
}
