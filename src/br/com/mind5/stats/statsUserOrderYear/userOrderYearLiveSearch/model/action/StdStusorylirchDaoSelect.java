package br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.info.StusorylirchInfo;

public final class StdStusorylirchDaoSelect extends ActionStdTemplate<StusorylirchInfo> {

	public StdStusorylirchDaoSelect(DeciTreeOption<StusorylirchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StusorylirchInfo> buildVisitorHook(DeciTreeOption<StusorylirchInfo> option) {
		return new VisiStusorylirchDaoSelect(option);
	}
}
