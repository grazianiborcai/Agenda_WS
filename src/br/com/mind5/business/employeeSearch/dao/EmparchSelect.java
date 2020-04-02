package br.com.mind5.business.employeeSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class EmparchSelect implements DaoStmtExec_<EmparchInfo> {
	private DaoStmtExec_<EmparchInfo> helper;
	
	
	public EmparchSelect(List<DaoStmtExecOption<EmparchInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, EmparchSelectSingle.class, EmparchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmparchInfo> getResultset() {
		return helper.getResultset();
	}
}
