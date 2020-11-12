package br.com.mind5.business.employeeWorkTimeRange.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeRange.info.EmpworgInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoEmpworgSelect implements DaoStmtExecV2<EmpworgInfo> {
	private DaoStmtExecV2<EmpworgInfo> helper;
	
	
	public DaoEmpworgSelect(List<DaoStmtExecOption<EmpworgInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoEmpworgSelectSingle.class, EmpworgInfo.class);
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
