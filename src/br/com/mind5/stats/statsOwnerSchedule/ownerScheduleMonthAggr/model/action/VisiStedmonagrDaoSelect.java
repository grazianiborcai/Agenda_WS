package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.dao.DaoSowedulagrSelect;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info.SowedulagrInfo;

final class VisiStedmonagrDaoSelect extends ActionVisitorTemplateStmt<SowedulagrInfo> {

	public VisiStedmonagrDaoSelect(DeciTreeOption<SowedulagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SowedulagrInfo> buildStmtExecHook(List<DaoStmtExecOption<SowedulagrInfo>> stmtOptions) {
		return new DaoSowedulagrSelect(stmtOptions);
	}
}
