package br.com.mind5.business.employeeLeaveDate.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class EmplateInsert implements DaoStmtExec_<EmplateInfo> {
	private DaoStmtExec_<EmplateInfo> helper;
	
	
	public EmplateInsert(List<DaoStmtExecOption<EmplateInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, EmplateInsertSingle.class, EmplateInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<EmplateInfo> getResultset() {
		return helper.getResultset();
	}
}
