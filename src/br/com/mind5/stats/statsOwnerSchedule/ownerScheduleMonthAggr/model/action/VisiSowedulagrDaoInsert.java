package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.dao.DaoSowedulagrInsert;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info.SowedulagrInfo;

final class VisiSowedulagrDaoInsert extends ActionVisitorTemplateStmt<SowedulagrInfo> {

	public VisiSowedulagrDaoInsert(DeciTreeOption<SowedulagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SowedulagrInfo> buildStmtExecHook(List<DaoStmtExecOption<SowedulagrInfo>> stmtOptions) {
		return new DaoSowedulagrInsert(stmtOptions);
	}
}
