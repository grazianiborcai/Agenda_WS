package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.StateInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class StateSelect implements DaoStmtExec_<StateInfo> {
	private DaoStmtExec_<StateInfo> helper;
	
	
	public StateSelect(List<DaoStmtExecOption<StateInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, StateSelectSingle.class, StateInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StateInfo> getResultset() {
		return helper.getResultset();
	}
}
