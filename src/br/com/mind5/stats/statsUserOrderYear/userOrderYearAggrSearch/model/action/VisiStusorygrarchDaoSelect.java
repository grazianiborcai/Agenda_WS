package br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.dao.DaoStusorygrarchSelect;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.info.StusorygrarchInfo;

final class VisiStusorygrarchDaoSelect extends ActionVisitorTemplateStmt<StusorygrarchInfo> {

	public VisiStusorygrarchDaoSelect(DeciTreeOption<StusorygrarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StusorygrarchInfo> buildStmtExecHook(List<DaoStmtExecOption<StusorygrarchInfo>> stmtOptions) {
		return new DaoStusorygrarchSelect(stmtOptions);
	}
}
