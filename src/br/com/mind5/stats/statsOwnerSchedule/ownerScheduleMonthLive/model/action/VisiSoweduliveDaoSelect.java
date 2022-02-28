package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.dao.DaoSoweduliveSelect;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.info.SoweduliveInfo;

final class VisiSoweduliveDaoSelect extends ActionVisitorTemplateStmt<SoweduliveInfo> {

	public VisiSoweduliveDaoSelect(DeciTreeOption<SoweduliveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SoweduliveInfo> buildStmtExecHook(List<DaoStmtExecOption<SoweduliveInfo>> stmtOptions) {
		return new DaoSoweduliveSelect(stmtOptions);
	}
}
