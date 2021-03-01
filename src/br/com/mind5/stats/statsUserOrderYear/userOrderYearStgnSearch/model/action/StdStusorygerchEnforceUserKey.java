package br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.info.StusorygerchInfo;

public final class StdStusorygerchEnforceUserKey extends ActionStdTemplate<StusorygerchInfo> {

	public StdStusorygerchEnforceUserKey(DeciTreeOption<StusorygerchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StusorygerchInfo> buildVisitorHook(DeciTreeOption<StusorygerchInfo> option) {
		return new VisiStusorygerchEnforceUserKey(option);
	}
}
