package br.com.mind5.stats.statsUserAccount.userAccountLive.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserAccount.userAccountLive.dao.DaoSuseraciveSelect;
import br.com.mind5.stats.statsUserAccount.userAccountLive.info.SuseraciveInfo;

final class VisiSuseraciveDaoSelect extends ActionVisitorTemplateStmt<SuseraciveInfo> {

	public VisiSuseraciveDaoSelect(DeciTreeOption<SuseraciveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SuseraciveInfo> buildStmtExecHook(List<DaoStmtExecOption<SuseraciveInfo>> stmtOptions) {
		return new DaoSuseraciveSelect(stmtOptions);
	}
}
