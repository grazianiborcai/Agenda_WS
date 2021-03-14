package br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.dao.DaoStusorylirchSelect;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.info.StusorylirchInfo;

final class VisiStusorylirchDaoSelect extends ActionVisitorTemplateStmt<StusorylirchInfo> {

	public VisiStusorylirchDaoSelect(DeciTreeOption<StusorylirchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StusorylirchInfo> buildStmtExecHook(List<DaoStmtExecOption<StusorylirchInfo>> stmtOptions) {
		return new DaoStusorylirchSelect(stmtOptions);
	}
}
