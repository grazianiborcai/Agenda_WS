package br.com.mind5.business.employeeLeaveDate.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class EmplevateSelectRange implements DaoStmtExec<EmplevateInfo> {
	private DaoStmtExec<EmplevateInfo> helper;
	
	
	public EmplevateSelectRange(List<DaoStmtExecOption<EmplevateInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, EmplevateSelectRangeSingle.class, EmplevateInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<EmplevateInfo> getResultset() {
		return helper.getResultset();
	}
}
