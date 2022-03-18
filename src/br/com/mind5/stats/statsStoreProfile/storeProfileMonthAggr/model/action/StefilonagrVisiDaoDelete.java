package br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.dao.StefilonagrDaoDelete;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.info.StefilonagrInfo;

public final class StefilonagrVisiDaoDelete extends ActionVisitorTemplateStmt<StefilonagrInfo> {

	public StefilonagrVisiDaoDelete(DeciTreeOption<StefilonagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StefilonagrInfo> buildStmtExecHook(List<DaoStmtExecOption<StefilonagrInfo>> stmtOptions) {
		return new StefilonagrDaoDelete(stmtOptions);
	}
}
