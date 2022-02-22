package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.dao.DaoStedmoniveSelect;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.info.StedmoniveInfo;

final class VisiStedmoniveDaoSelect extends ActionVisitorTemplateStmt<StedmoniveInfo> {

	public VisiStedmoniveDaoSelect(DeciTreeOption<StedmoniveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StedmoniveInfo> buildStmtExecHook(List<DaoStmtExecOption<StedmoniveInfo>> stmtOptions) {
		return new DaoStedmoniveSelect(stmtOptions);
	}
}
