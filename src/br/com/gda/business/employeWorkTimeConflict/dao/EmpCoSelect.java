package br.com.gda.business.employeWorkTimeConflict.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.employeWorkTimeConflict.info.EmpCoInfo;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public final class EmpCoSelect implements SqlStmtExec<EmpCoInfo> {
	private SqlStmtExec<EmpCoInfo> helper;
	
	
	public EmpCoSelect(List<SqlStmtExecOption<EmpCoInfo>> options) {
		helper = new SqlStmtExecHelper<>(options, EmpCoSelectSingle.class, EmpCoInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmpCoInfo> getResultset() {
		return helper.getResultset();
	}
}
