package br.com.mind5.stats.statsOwnerUser.ownerUserLive.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.ownerUserLive.info.SowusiveInfo;

public final class StdSowusiveDaoSelect extends ActionStdTemplate<SowusiveInfo> {

	public StdSowusiveDaoSelect(DeciTreeOption<SowusiveInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SowusiveInfo> buildVisitorHook(DeciTreeOption<SowusiveInfo> option) {
		return new VisiSowusiveDaoSelect(option);
	}
}
