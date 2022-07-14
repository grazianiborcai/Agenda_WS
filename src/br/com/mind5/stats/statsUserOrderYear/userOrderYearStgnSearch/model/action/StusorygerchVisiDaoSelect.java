package br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.dao.StusorygerchDaoSelect;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.info.StusorygerchInfo;

final class StusorygerchVisiDaoSelect extends ActionVisitorTemplateStmt<StusorygerchInfo> {

	public StusorygerchVisiDaoSelect(DeciTreeOption<StusorygerchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StusorygerchInfo> buildStmtExecHook(List<DaoStmtExecOption<StusorygerchInfo>> stmtOptions) {
		return new StusorygerchDaoSelect(stmtOptions);
	}
}
