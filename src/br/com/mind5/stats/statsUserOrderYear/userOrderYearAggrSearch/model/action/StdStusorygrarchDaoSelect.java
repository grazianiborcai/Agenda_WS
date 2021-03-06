package br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.info.StusorygrarchInfo;

public final class StdStusorygrarchDaoSelect extends ActionStdTemplate<StusorygrarchInfo> {

	public StdStusorygrarchDaoSelect(DeciTreeOption<StusorygrarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StusorygrarchInfo> buildVisitorHook(DeciTreeOption<StusorygrarchInfo> option) {
		return new VisiStusorygrarchDaoSelect(option);
	}
}
