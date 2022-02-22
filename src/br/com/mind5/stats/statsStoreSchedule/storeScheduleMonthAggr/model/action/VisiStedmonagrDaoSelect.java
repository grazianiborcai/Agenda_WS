package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.dao.DaoStedmonagrSelect;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.info.StedmonagrInfo;

final class VisiStedmonagrDaoSelect extends ActionVisitorTemplateStmt<StedmonagrInfo> {

	public VisiStedmonagrDaoSelect(DeciTreeOption<StedmonagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StedmonagrInfo> buildStmtExecHook(List<DaoStmtExecOption<StedmonagrInfo>> stmtOptions) {
		return new DaoStedmonagrSelect(stmtOptions);
	}
}
