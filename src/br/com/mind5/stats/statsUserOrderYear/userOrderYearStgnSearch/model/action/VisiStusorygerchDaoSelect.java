package br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.dao.DaoStusorygerchSelect;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.info.StusorygerchInfo;

final class VisiStusorygerchDaoSelect extends ActionVisitorTemplateStmt<StusorygerchInfo> {

	public VisiStusorygerchDaoSelect(DeciTreeOption<StusorygerchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StusorygerchInfo> buildStmtExecHook(List<DaoStmtExecOption<StusorygerchInfo>> stmtOptions) {
		return new DaoStusorygerchSelect(stmtOptions);
	}
}
