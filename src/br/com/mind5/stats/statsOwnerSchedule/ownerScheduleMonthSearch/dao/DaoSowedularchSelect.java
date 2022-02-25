package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.info.SowedularchhInfo;

public final class DaoSowedularchSelect implements DaoStmtExec<SowedularchhInfo> {
	private DaoStmtExec<SowedularchhInfo> helper;
	
	
	public DaoSowedularchSelect(List<DaoStmtExecOption<SowedularchhInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoSowedularchSelectSingle.class, SowedularchhInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
	}

	
	
	@Override public List<SowedularchhInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();
	}
}
