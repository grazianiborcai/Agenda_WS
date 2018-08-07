package br.com.gda.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class WeekdaySelect implements DaoStmtExec<WeekdayInfo> {
	private DaoStmtExec<WeekdayInfo> helper;
	
	
	public WeekdaySelect(List<DaoStmtExecOption<WeekdayInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, WeekdaySelectSingle.class, WeekdayInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<WeekdayInfo> getResultset() {
		return helper.getResultset();
	}
}
