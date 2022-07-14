package br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.dao.StusorylirchDaoSelect;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.info.StusorylirchInfo;

public final class StusorylirchVisiDaoSelect extends ActionVisitorTemplateStmt<StusorylirchInfo> {

	public StusorylirchVisiDaoSelect(DeciTreeOption<StusorylirchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StusorylirchInfo> buildStmtExecHook(List<DaoStmtExecOption<StusorylirchInfo>> stmtOptions) {
		return new StusorylirchDaoSelect(stmtOptions);
	}
}
