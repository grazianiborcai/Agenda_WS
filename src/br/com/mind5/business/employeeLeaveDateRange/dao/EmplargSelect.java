package br.com.mind5.business.employeeLeaveDateRange.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeLeaveDateRange.info.EmplargInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class EmplargSelect implements DaoStmtExec_<EmplargInfo> {
	private DaoStmtExec_<EmplargInfo> helper;
	
	
	public EmplargSelect(List<DaoStmtExecOption<EmplargInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, EmplargSelectSingle.class, EmplargInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmplargInfo> getResultset() {
		return helper.getResultset();
	}
}
