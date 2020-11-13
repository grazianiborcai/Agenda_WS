package br.com.mind5.business.employeeWorkTimeRange.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeRange.info.EmpworgInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoEmpworgSelect implements DaoStmtExec<EmpworgInfo> {
	private DaoStmtExec<EmpworgInfo> helper;
	
	
	public DaoEmpworgSelect(List<DaoStmtExecOption<EmpworgInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoEmpworgSelectSingle.class, EmpworgInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<EmpworgInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
