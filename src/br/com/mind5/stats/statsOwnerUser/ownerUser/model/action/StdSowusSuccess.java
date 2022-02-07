package br.com.mind5.stats.statsOwnerUser.ownerUser.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.ownerUser.info.SowusInfo;

public final class StdSowusSuccess extends ActionStdSuccessTemplate<SowusInfo> {
	
	public StdSowusSuccess(DeciTreeOption<SowusInfo> option) {
		super(option);
	}
}
