package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.dao.SoweduliveDaoSelect;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.info.SoweduliveInfo;

public final class SoweduliveVisiDaoSelect extends ActionVisitorTemplateStmt<SoweduliveInfo> {

	public SoweduliveVisiDaoSelect(DeciTreeOption<SoweduliveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SoweduliveInfo> buildStmtExecHook(List<DaoStmtExecOption<SoweduliveInfo>> stmtOptions) {
		return new SoweduliveDaoSelect(stmtOptions);
	}
}
