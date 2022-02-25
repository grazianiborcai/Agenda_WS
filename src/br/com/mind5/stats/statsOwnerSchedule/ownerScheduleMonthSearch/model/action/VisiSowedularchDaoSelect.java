package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.dao.DaoSowedularchSelect;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.info.SowedularchhInfo;

final class VisiSowedularchDaoSelect extends ActionVisitorTemplateStmt<SowedularchhInfo> {

	public VisiSowedularchDaoSelect(DeciTreeOption<SowedularchhInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SowedularchhInfo> buildStmtExecHook(List<DaoStmtExecOption<SowedularchhInfo>> stmtOptions) {
		return new DaoSowedularchSelect(stmtOptions);
	}
}
