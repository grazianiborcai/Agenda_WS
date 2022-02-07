package br.com.mind5.stats.statsOwnerStore.ownerStoreLive.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreLive.dao.DaoSowotiveSelect;
import br.com.mind5.stats.statsOwnerStore.ownerStoreLive.info.SowotiveInfo;

final class VisiSowotiveDaoSelect extends ActionVisitorTemplateStmt<SowotiveInfo> {

	public VisiSowotiveDaoSelect(DeciTreeOption<SowotiveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SowotiveInfo> buildStmtExecHook(List<DaoStmtExecOption<SowotiveInfo>> stmtOptions) {
		return new DaoSowotiveSelect(stmtOptions);
	}
}
