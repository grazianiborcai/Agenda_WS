package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.StateInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class StateSelect implements DaoStmtExec<StateInfo> {
	private DaoStmtExec<StateInfo> helper;
	
	
	public StateSelect(List<DaoStmtExecOption<StateInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StateSelectSingle.class, StateInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StateInfo> getResultset() {
		return helper.getResultset();
	}
}
