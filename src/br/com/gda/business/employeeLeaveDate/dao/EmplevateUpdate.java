package br.com.gda.business.employeeLeaveDate.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class EmplevateUpdate implements DaoStmtExec<EmplevateInfo> {
	private DaoStmtExec<EmplevateInfo> helper;
	
	
	public EmplevateUpdate(List<DaoStmtExecOption<EmplevateInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, EmplevateUpdateSingle.class, EmplevateInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmplevateInfo> getResultset() {
		return helper.getResultset();
	}
}
