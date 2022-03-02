package br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.dao.SowusagrDaoDelete;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.info.SowusagrInfo;

public final class SowusagrVisiDaoDelete extends ActionVisitorTemplateStmt<SowusagrInfo> {

	public SowusagrVisiDaoDelete(DeciTreeOption<SowusagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SowusagrInfo> buildStmtExecHook(List<DaoStmtExecOption<SowusagrInfo>> stmtOptions) {
		return new SowusagrDaoDelete(stmtOptions);
	}
}
