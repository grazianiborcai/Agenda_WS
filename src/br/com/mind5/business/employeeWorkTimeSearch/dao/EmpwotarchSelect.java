package br.com.mind5.business.employeeWorkTimeSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class EmpwotarchSelect implements DaoStmtExec_<EmpwotarchInfo> {
	private DaoStmtExec_<EmpwotarchInfo> helper;
	
	
	public EmpwotarchSelect(List<DaoStmtExecOption<EmpwotarchInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, EmpwotarchSelectSingle.class, EmpwotarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmpwotarchInfo> getResultset() {
		return helper.getResultset();
	}
}
