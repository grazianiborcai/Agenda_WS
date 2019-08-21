package br.com.gda.business.scheduleSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.scheduleSearch.info.SchedarchInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

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
