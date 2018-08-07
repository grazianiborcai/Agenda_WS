package br.com.gda.business.employee.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class EmpSelect implements DaoStmtExec<EmpInfo> {
	private DaoStmtExec<EmpInfo> helper;
	
	
	public EmpSelect(List<DaoStmtExecOption<EmpInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, EmpSelectSingle.class, EmpInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmpInfo> getResultset() {
		return helper.getResultset();
	}
}
