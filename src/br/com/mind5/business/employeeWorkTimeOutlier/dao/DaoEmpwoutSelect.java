package br.com.mind5.business.employeeWorkTimeOutlier.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoEmpwoutSelect implements DaoStmtExecV2<EmpwoutInfo> {
	private DaoStmtExecV2<EmpwoutInfo> helper;
	
	
	public DaoEmpwoutSelect(List<DaoStmtExecOption<EmpwoutInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoEmpwoutSelectSingle.class, EmpwoutInfo.class);
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
