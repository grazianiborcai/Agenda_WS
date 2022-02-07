package br.com.mind5.stats.statsOwnerStore.ownerStore.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStore.info.SowotInfo;

public final class StdSowotMergeStoracive extends ActionStdTemplate<SowotInfo> {

	public StdSowotMergeStoracive(DeciTreeOption<SowotInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SowotInfo> buildVisitorHook(DeciTreeOption<SowotInfo> option) {
		return new VisiSowotMergeStoracive(option);
	}
}
