package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.dao.DaoSteddiveSelect;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.info.SteddiveInfo;

final class VisiSteddiveDaoSelect extends ActionVisitorTemplateStmt<SteddiveInfo> {

	public VisiSteddiveDaoSelect(DeciTreeOption<SteddiveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SteddiveInfo> buildStmtExecHook(List<DaoStmtExecOption<SteddiveInfo>> stmtOptions) {
		return new DaoSteddiveSelect(stmtOptions);
	}
}
