package br.com.gda.business.employeeList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class EmplisSelect implements DaoStmtExec<EmplisInfo> {
	private DaoStmtExec<EmplisInfo> helper;
	
	
	public EmplisSelect(List<DaoStmtExecOption<EmplisInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, EmplisSelectSingle.class, EmplisInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmplisInfo> getResultset() {
		return helper.getResultset();
	}
}
