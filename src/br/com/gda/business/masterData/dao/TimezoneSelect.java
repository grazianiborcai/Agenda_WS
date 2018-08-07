package br.com.gda.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class TimezoneSelect implements DaoStmtExec<TimezoneInfo> {
	private DaoStmtExec<TimezoneInfo> helper;
	
	
	public TimezoneSelect(List<DaoStmtExecOption<TimezoneInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, TimezoneSelectSingle.class, TimezoneInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<TimezoneInfo> getResultset() {
		return helper.getResultset();
	}
}
