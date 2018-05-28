package br.com.gda.business.employee.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.employee.info.EmpWTimeInfo;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public final class EmpWtimeDeleteExec implements SqlStmtExec<EmpWTimeInfo> {
	private SqlStmtExec<EmpWTimeInfo> helper;
	
	
	public EmpWtimeDeleteExec(List<SqlStmtExecOption<EmpWTimeInfo>> options) {
		helper = new SqlStmtExecHelper<>(options, EmpWtimeDelete.class, EmpWTimeInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<EmpWTimeInfo> getResultset() {
		return helper.getResultset();
	}
}
