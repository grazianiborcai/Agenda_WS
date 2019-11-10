package br.com.mind5.business.employeeWorkTimeSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class EmpwotarchSelect implements DaoStmtExec<EmpwotarchInfo> {
	private DaoStmtExec<EmpwotarchInfo> helper;
	
	
	public EmpwotarchSelect(List<DaoStmtExecOption<EmpwotarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, EmpwotarchSelectSingle.class, EmpwotarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmpwotarchInfo> getResultset() {
		return helper.getResultset();
	}
}
