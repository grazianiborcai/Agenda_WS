package br.com.gda.business.employeeWorkTime.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public final class EmpWTimeDelete implements SqlStmtExec<EmpWTimeInfo> {
	private SqlStmtExec<EmpWTimeInfo> helper;
	
	
	public EmpWTimeDelete(List<SqlStmtExecOption<EmpWTimeInfo>> options) {
		helper = new SqlStmtExecHelper<>(options, EmpWTimeDeleteSingle.class, EmpWTimeInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmpWTimeInfo> getResultset() {
		return helper.getResultset();
	}
}
