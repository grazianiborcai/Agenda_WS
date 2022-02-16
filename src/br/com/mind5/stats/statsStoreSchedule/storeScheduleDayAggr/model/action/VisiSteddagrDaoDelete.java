package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.dao.DaoSteddagrDelete;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.info.SteddagrInfo;

final class VisiSteddagrDaoDelete extends ActionVisitorTemplateStmt<SteddagrInfo> {

	public VisiSteddagrDaoDelete(DeciTreeOption<SteddagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SteddagrInfo> buildStmtExecHook(List<DaoStmtExecOption<SteddagrInfo>> stmtOptions) {
		return new DaoSteddagrDelete(stmtOptions);
	}
}
