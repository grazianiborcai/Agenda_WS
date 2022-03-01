package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.dao.SowotarchDaoSelect;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.info.SowotarchInfo;

public final class SowotarchVisiDaoSelect extends ActionVisitorTemplateStmt<SowotarchInfo> {

	public SowotarchVisiDaoSelect(DeciTreeOption<SowotarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SowotarchInfo> buildStmtExecHook(List<DaoStmtExecOption<SowotarchInfo>> stmtOptions) {
		return new SowotarchDaoSelect(stmtOptions);
	}
}
