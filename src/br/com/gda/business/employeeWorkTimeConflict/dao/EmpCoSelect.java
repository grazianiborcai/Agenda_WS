package br.com.gda.business.employeeWorkTimeConflict.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.employeeWorkTimeConflict.info.EmpCoInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class EmpCoSelect implements DaoStmtExec<EmpCoInfo> {
	private DaoStmtExec<EmpCoInfo> helper;
	
	
	public EmpCoSelect(List<DaoStmtExecOption<EmpCoInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, EmpCoSelectSingle.class, EmpCoInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmpCoInfo> getResultset() {
		return helper.getResultset();
	}
}
