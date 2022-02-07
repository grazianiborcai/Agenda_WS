package br.com.mind5.stats.statsOwnerStore.ownerStoreLive.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreLive.info.SowotiveInfo;

public final class StdSowotiveMergeCalonthLtm extends ActionStdTemplate<SowotiveInfo> {

	public StdSowotiveMergeCalonthLtm(DeciTreeOption<SowotiveInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SowotiveInfo> buildVisitorHook(DeciTreeOption<SowotiveInfo> option) {
		return new VisiSowotiveMergeCalonthLtm(option);
	}
}
