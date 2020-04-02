package br.com.mind5.business.employeeWorkTimeRange.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeRange.info.EmpworgInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class EmpworgSelect implements DaoStmtExec_<EmpworgInfo> {
	private DaoStmtExec_<EmpworgInfo> helper;
	
	
	public EmpworgSelect(List<DaoStmtExecOption<EmpworgInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, EmpworgSelectSingle.class, EmpworgInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<EmpworgInfo> getResultset() {
		return helper.getResultset();
	}
}
