package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleLive.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleLive.info.SoweduliveInfo;

public final class StdSoweduliveMergeToSelect extends ActionStdTemplate<SoweduliveInfo> {

	public StdSoweduliveMergeToSelect(DeciTreeOption<SoweduliveInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SoweduliveInfo> buildVisitorHook(DeciTreeOption<SoweduliveInfo> option) {
		return new VisiSoweduliveMergeToSelect(option);
	}
}
