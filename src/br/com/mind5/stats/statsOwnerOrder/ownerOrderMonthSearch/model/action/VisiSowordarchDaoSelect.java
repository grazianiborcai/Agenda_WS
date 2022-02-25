package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.dao.DaoSowordarchSelect;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.info.SowordarchInfo;

final class VisiSowordarchDaoSelect extends ActionVisitorTemplateStmt<SowordarchInfo> {

	public VisiSowordarchDaoSelect(DeciTreeOption<SowordarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SowordarchInfo> buildStmtExecHook(List<DaoStmtExecOption<SowordarchInfo>> stmtOptions) {
		return new DaoSowordarchSelect(stmtOptions);
	}
}
