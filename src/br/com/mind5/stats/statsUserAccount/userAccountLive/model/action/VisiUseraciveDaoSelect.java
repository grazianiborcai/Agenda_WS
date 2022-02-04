package br.com.mind5.stats.statsUserAccount.userAccountLive.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserAccount.userAccountLive.dao.DaoUseraciveSelect;
import br.com.mind5.stats.statsUserAccount.userAccountLive.info.UseraciveInfo;

final class VisiUseraciveDaoSelect extends ActionVisitorTemplateStmt<UseraciveInfo> {

	public VisiUseraciveDaoSelect(DeciTreeOption<UseraciveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<UseraciveInfo> buildStmtExecHook(List<DaoStmtExecOption<UseraciveInfo>> stmtOptions) {
		return new DaoUseraciveSelect(stmtOptions);
	}
}
