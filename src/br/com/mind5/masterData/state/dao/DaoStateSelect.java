package br.com.mind5.masterData.state.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.state.info.StateInfo;

public final class DaoStateSelect implements DaoStmtExecV2<StateInfo> {
	private DaoStmtExecV2<StateInfo> helper;
	
	
	public DaoStateSelect(List<DaoStmtExecOption<StateInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoStateSelectSingle.class, StateInfo.class);
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
