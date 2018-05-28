package br.com.gda.business.employee.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public final class EmpUpdateExec implements SqlStmtExec<EmpInfo> {
	private SqlStmtExec<EmpInfo> helper;
	
	
	public EmpUpdateExec(List<SqlStmtExecOption<EmpInfo>> options) {
		helper = new SqlStmtExecHelper<>(options, EmpUpdate.class, EmpInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<EmpInfo> getResultset() {
		return helper.getResultset();
	}
}
