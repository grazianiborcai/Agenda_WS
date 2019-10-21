package br.com.mind5.business.employeeWorkTimeConflict.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class EmpwocoSelect implements DaoStmtExec<EmpwocoInfo> {
	private DaoStmtExec<EmpwocoInfo> helper;
	
	
	public EmpwocoSelect(List<DaoStmtExecOption<EmpwocoInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, EmpwocoSelectSingle.class, EmpwocoInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmpwocoInfo> getResultset() {
		return helper.getResultset();
	}
}
