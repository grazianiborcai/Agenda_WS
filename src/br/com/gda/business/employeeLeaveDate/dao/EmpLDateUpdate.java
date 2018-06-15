package br.com.gda.business.employeeLeaveDate.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.employeeLeaveDate.info.EmpLDateInfo;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public final class EmpLDateUpdate implements SqlStmtExec<EmpLDateInfo> {
	private SqlStmtExec<EmpLDateInfo> helper;
	
	
	public EmpLDateUpdate(List<SqlStmtExecOption<EmpLDateInfo>> options) {
		helper = new SqlStmtExecHelper<>(options, EmpLDateUpdateSingle.class, EmpLDateInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmpLDateInfo> getResultset() {
		return helper.getResultset();
	}
}
