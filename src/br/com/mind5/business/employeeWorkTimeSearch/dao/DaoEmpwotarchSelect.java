package br.com.mind5.business.employeeWorkTimeSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoEmpwotarchSelect implements DaoStmtExec<EmpwotarchInfo> {
	private DaoStmtExec<EmpwotarchInfo> helper;
	
	
	public DaoEmpwotarchSelect(List<DaoStmtExecOption<EmpwotarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoEmpwotarchSelectSingle.class, EmpwotarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmpwotarchInfo> getResultset() {
		return helper.getResultset();
	}



	@Override public void close() {
		helper.close();		
	}
}
