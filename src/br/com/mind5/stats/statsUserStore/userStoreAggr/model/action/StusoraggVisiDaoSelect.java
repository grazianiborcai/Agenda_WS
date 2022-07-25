package br.com.mind5.stats.statsUserStore.userStoreAggr.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserStore.userStoreAggr.dao.StusoraggDaoSelect;
import br.com.mind5.stats.statsUserStore.userStoreAggr.info.StusoraggInfo;

public final class StusoraggVisiDaoSelect extends ActionVisitorTemplateStmt<StusoraggInfo> {

	public StusoraggVisiDaoSelect(DeciTreeOption<StusoraggInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StusoraggInfo> buildStmtExecHook(List<DaoStmtExecOption<StusoraggInfo>> stmtOptions) {
		return new StusoraggDaoSelect(stmtOptions);
	}
}
