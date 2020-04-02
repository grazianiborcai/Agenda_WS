package br.com.mind5.business.employeeLeaveDateSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeLeaveDateSearch.info.EmplarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class EmplarchSelect implements DaoStmtExec_<EmplarchInfo> {
	private DaoStmtExec_<EmplarchInfo> helper;
	
	
	public EmplarchSelect(List<DaoStmtExecOption<EmplarchInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, EmplarchSelectSingle.class, EmplarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmplarchInfo> getResultset() {
		return helper.getResultset();
	}
}
