package br.com.mind5.business.employeeWorkTimeOutlier.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoEmpwoutSelect implements DaoStmtExec<EmpwoutInfo> {
	private DaoStmtExec<EmpwoutInfo> helper;
	
	
	public DaoEmpwoutSelect(List<DaoStmtExecOption<EmpwoutInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoEmpwoutSelectSingle.class, EmpwoutInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmpwoutInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
