package br.com.mind5.business.scheduleSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.scheduleSearch.info.SchedarchInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoSchedarchSelect implements DaoStmtExecV2<SchedarchInfo> {
	private DaoStmtExecV2<SchedarchInfo> helper;
	
	
	public DaoSchedarchSelect(List<DaoStmtExecOption<SchedarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoSchedarchSelectSingle.class, SchedarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SchedarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
