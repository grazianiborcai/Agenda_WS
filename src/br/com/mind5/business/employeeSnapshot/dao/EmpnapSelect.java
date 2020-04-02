package br.com.mind5.business.employeeSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class EmpnapSelect implements DaoStmtExec_<EmpnapInfo> {
	private DaoStmtExec_<EmpnapInfo> helper;
	
	
	public EmpnapSelect(List<DaoStmtExecOption<EmpnapInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, EmpnapSelectSingle.class, EmpnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmpnapInfo> getResultset() {
		return helper.getResultset();
	}
}
