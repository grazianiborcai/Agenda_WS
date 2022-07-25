package br.com.mind5.masterData.state.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.state.info.StateInfo;

public final class StateDaoSelect implements DaoStmtExec<StateInfo> {
	private DaoStmtExec<StateInfo> helper;
	
	
	public StateDaoSelect(List<DaoStmtExecOption<StateInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StateDaoSelectSingle.class, StateInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StateInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
