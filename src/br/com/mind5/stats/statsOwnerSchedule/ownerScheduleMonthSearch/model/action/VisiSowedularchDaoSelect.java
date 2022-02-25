package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.dao.DaoSowedularchSelect;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.info.SowedularchInfo;

final class VisiSowedularchDaoSelect extends ActionVisitorTemplateStmt<SowedularchInfo> {

	public VisiSowedularchDaoSelect(DeciTreeOption<SowedularchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SowedularchInfo> buildStmtExecHook(List<DaoStmtExecOption<SowedularchInfo>> stmtOptions) {
		return new DaoSowedularchSelect(stmtOptions);
	}
}
