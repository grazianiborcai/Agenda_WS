package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.TimezoneInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class TimezoneSelect implements DaoStmtExec_<TimezoneInfo> {
	private DaoStmtExec_<TimezoneInfo> helper;
	
	
	public TimezoneSelect(List<DaoStmtExecOption<TimezoneInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, TimezoneSelectSingle.class, TimezoneInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<TimezoneInfo> getResultset() {
		return helper.getResultset();
	}
}
