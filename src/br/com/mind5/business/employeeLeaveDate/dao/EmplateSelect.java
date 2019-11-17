package br.com.mind5.business.employeeLeaveDate.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class EmplateSelect implements DaoStmtExec<EmplateInfo> {
	private DaoStmtExec<EmplateInfo> helper;
	
	
	public EmplateSelect(List<DaoStmtExecOption<EmplateInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, EmplateSelectSingle.class, EmplateInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmplateInfo> getResultset() {
		return helper.getResultset();
	}
}
