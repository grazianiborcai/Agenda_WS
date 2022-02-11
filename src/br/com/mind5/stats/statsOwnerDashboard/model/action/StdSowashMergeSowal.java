package br.com.mind5.stats.statsOwnerDashboard.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerDashboard.info.SowashInfo;

public final class StdSowashMergeSowal extends ActionStdTemplate<SowashInfo> {

	public StdSowashMergeSowal(DeciTreeOption<SowashInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SowashInfo> buildVisitorHook(DeciTreeOption<SowashInfo> option) {
		return new VisiSowashMergeSowal(option);
	}
}
