package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.dao.SowotagrDaoSelect;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.info.SowotagrInfo;

public final class SowotagrVisiDaoSelect extends ActionVisitorTemplateStmt<SowotagrInfo> {

	public SowotagrVisiDaoSelect(DeciTreeOption<SowotagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SowotagrInfo> buildStmtExecHook(List<DaoStmtExecOption<SowotagrInfo>> stmtOptions) {
		return new SowotagrDaoSelect(stmtOptions);
	}
}
