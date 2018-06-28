package br.com.gda.business.employee.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public final class EmpSelect implements SqlStmtExec<EmpInfo> {
	private SqlStmtExec<EmpInfo> helper;
	
	
	public EmpSelect(List<SqlStmtExecOption<EmpInfo>> options) {
		helper = new SqlStmtExecHelper<>(options, EmpSelectSingle.class, EmpInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmpInfo> getResultset() {
		return helper.getResultset();
	}
}
