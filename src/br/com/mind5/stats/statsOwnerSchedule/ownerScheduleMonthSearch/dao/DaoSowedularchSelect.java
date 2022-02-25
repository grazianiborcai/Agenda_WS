package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.info.SowedularchInfo;

public final class DaoSowedularchSelect implements DaoStmtExec<SowedularchInfo> {
	private DaoStmtExec<SowedularchInfo> helper;
	
	
	public DaoSowedularchSelect(List<DaoStmtExecOption<SowedularchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoSowedularchSelectSingle.class, SowedularchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
	}

	
	
	@Override public List<SowedularchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();
	}
}
