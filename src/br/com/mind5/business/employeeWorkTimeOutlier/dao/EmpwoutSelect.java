package br.com.mind5.business.employeeWorkTimeOutlier.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class EmpwoutSelect implements DaoStmtExec_<EmpwoutInfo> {
	private DaoStmtExec_<EmpwoutInfo> helper;
	
	
	public EmpwoutSelect(List<DaoStmtExecOption<EmpwoutInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, EmpwoutSelectSingle.class, EmpwoutInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmpwoutInfo> getResultset() {
		return helper.getResultset();
	}
}
