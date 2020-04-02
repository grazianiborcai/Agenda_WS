package br.com.mind5.business.employee.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class EmpDelete implements DaoStmtExec_<EmpInfo> {
	private DaoStmtExec_<EmpInfo> helper;
	
	
	public EmpDelete(List<DaoStmtExecOption<EmpInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, EmpDeleteSingle.class, EmpInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmpInfo> getResultset() {
		return helper.getResultset();
	}
}
