package br.com.mind5.business.employeeWorkTimeConflict.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class EmpwocoSelect implements DaoStmtExec_<EmpwocoInfo> {
	private DaoStmtExec_<EmpwocoInfo> helper;
	
	
	public EmpwocoSelect(List<DaoStmtExecOption<EmpwocoInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, EmpwocoSelectSingle.class, EmpwocoInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmpwocoInfo> getResultset() {
		return helper.getResultset();
	}
}
