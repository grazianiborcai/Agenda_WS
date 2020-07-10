package br.com.mind5.config.sysStorePartitioning.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.config.sysStorePartitioning.dao.DaoSytotinSelect;
import br.com.mind5.config.sysStorePartitioning.info.SytotinInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSytotinDaoSelect extends ActionVisitorTemplateStmtV2<SytotinInfo> {

	public VisiSytotinDaoSelect(DeciTreeOption<SytotinInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<SytotinInfo> buildStmtExecHook(List<DaoStmtExecOption<SytotinInfo>> stmtOptions) {
		return new DaoSytotinSelect(stmtOptions);
	}
}
