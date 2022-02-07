package br.com.mind5.stats.statsOwnerUser.userAccountLive.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.userAccountLive.info.SowusiveInfo;

public final class StdSowusiveMergeToSelect extends ActionStdTemplate<SowusiveInfo> {

	public StdSowusiveMergeToSelect(DeciTreeOption<SowusiveInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SowusiveInfo> buildVisitorHook(DeciTreeOption<SowusiveInfo> option) {
		return new VisiSowusiveMergeToSelect(option);
	}
}
