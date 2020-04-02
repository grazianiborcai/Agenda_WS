package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class WeekdaySelect implements DaoStmtExec_<WeekdayInfo> {
	private DaoStmtExec_<WeekdayInfo> helper;
	
	
	public WeekdaySelect(List<DaoStmtExecOption<WeekdayInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, WeekdaySelectSingle.class, WeekdayInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<WeekdayInfo> getResultset() {
		return helper.getResultset();
	}
}
