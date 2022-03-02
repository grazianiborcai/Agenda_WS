package br.com.mind5.stats.statsOwnerUser.ownerUserMonthLive.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthLive.dao.SowusiveDaoSelect;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthLive.info.SowusiveInfo;

public final class SowusiveVisiDaoSelect extends ActionVisitorTemplateStmt<SowusiveInfo> {

	public SowusiveVisiDaoSelect(DeciTreeOption<SowusiveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SowusiveInfo> buildStmtExecHook(List<DaoStmtExecOption<SowusiveInfo>> stmtOptions) {
		return new SowusiveDaoSelect(stmtOptions);
	}
}
