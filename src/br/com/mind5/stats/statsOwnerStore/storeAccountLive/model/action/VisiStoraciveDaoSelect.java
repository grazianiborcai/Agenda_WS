package br.com.mind5.stats.statsStoreAccount.storeAccountLive.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreAccount.storeAccountLive.dao.DaoStoraciveSelect;
import br.com.mind5.stats.statsStoreAccount.storeAccountLive.info.StoraciveInfo;

final class VisiStoraciveDaoSelect extends ActionVisitorTemplateStmt<StoraciveInfo> {

	public VisiStoraciveDaoSelect(DeciTreeOption<StoraciveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StoraciveInfo> buildStmtExecHook(List<DaoStmtExecOption<StoraciveInfo>> stmtOptions) {
		return new DaoStoraciveSelect(stmtOptions);
	}
}
