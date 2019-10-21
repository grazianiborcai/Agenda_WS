package br.com.mind5.business.scheduleSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.scheduleSearch.info.SchedarchInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class SchedarchSelect implements DaoStmtExec<SchedarchInfo> {
	private DaoStmtExec<SchedarchInfo> helper;
	
	
	public SchedarchSelect(List<DaoStmtExecOption<SchedarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SchedarchSelectSingle.class, SchedarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SchedarchInfo> getResultset() {
		return helper.getResultset();
	}
}
