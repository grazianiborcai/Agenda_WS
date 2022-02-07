package br.com.mind5.stats.statsOwnerStore.ownerStore.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStore.info.SowotInfo;

public final class StdSowotSuccess extends ActionStdSuccessTemplate<SowotInfo> {
	
	public StdSowotSuccess(DeciTreeOption<SowotInfo> option) {
		super(option);
	}
}
