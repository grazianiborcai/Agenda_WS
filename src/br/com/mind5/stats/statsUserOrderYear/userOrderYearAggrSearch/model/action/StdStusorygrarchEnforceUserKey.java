package br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.info.StusorygrarchInfo;

public final class StdStusorygrarchEnforceUserKey extends ActionStdTemplate<StusorygrarchInfo> {

	public StdStusorygrarchEnforceUserKey(DeciTreeOption<StusorygrarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StusorygrarchInfo> buildVisitorHook(DeciTreeOption<StusorygrarchInfo> option) {
		return new VisiStusorygrarchEnforceUserKey(option);
	}
}
