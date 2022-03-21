package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.info.CustamoniveInfo;

public final class CustamoniveDaoSelect implements DaoStmtExec<CustamoniveInfo> {
	private DaoStmtExec<CustamoniveInfo> helper;
	
	
	public CustamoniveDaoSelect(List<DaoStmtExecOption<CustamoniveInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CustamoniveDaoSelectSingle.class, CustamoniveInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CustamoniveInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
