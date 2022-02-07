package br.com.mind5.stats.statsOwnerUser.userAccountLive.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.userAccountLive.dao.DaoSowusiveSelect;
import br.com.mind5.stats.statsOwnerUser.userAccountLive.info.SowusiveInfo;

final class VisiSowusiveDaoSelect extends ActionVisitorTemplateStmt<SowusiveInfo> {

	public VisiSowusiveDaoSelect(DeciTreeOption<SowusiveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SowusiveInfo> buildStmtExecHook(List<DaoStmtExecOption<SowusiveInfo>> stmtOptions) {
		return new DaoSowusiveSelect(stmtOptions);
	}
}
