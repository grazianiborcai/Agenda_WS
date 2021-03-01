package br.com.mind5.stats.statsUserStore.userStoreAggr.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserStore.userStoreAggr.dao.DaoStusoraggSelect;
import br.com.mind5.stats.statsUserStore.userStoreAggr.info.StusoraggInfo;

final class VisiStusoraggDaoSelect extends ActionVisitorTemplateStmt<StusoraggInfo> {

	public VisiStusoraggDaoSelect(DeciTreeOption<StusoraggInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StusoraggInfo> buildStmtExecHook(List<DaoStmtExecOption<StusoraggInfo>> stmtOptions) {
		return new DaoStusoraggSelect(stmtOptions);
	}
}
