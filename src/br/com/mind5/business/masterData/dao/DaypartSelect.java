package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.DaypartInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class DaypartSelect implements DaoStmtExec<DaypartInfo> {
	private DaoStmtExec<DaypartInfo> helper;
	
	
	public DaypartSelect(List<DaoStmtExecOption<DaypartInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaypartSelectSingle.class, DaypartInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<DaypartInfo> getResultset() {
		return helper.getResultset();
	}
}
